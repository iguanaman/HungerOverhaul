package iguanaman.hungeroverhaul.core;

import static org.objectweb.asm.Opcodes.*;
import iguanaman.hungeroverhaul.util.FoodValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

public class ClassTransformer implements IClassTransformer
{

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass)
	{
		if (transformedName.equals("net.minecraft.entity.player.EntityPlayer"))
		{
			boolean isObfuscated = !name.equals(transformedName);

			ClassNode classNode = readClassFromBytes(basicClass);

			MethodNode methodNode = findMethodNodeOfClass(classNode, "<init>", null);
			if (methodNode != null)
			{
				patchEntityPlayerInit(methodNode, isObfuscated);
				return writeClassToBytes(classNode);
			}
			else
				throw new RuntimeException("EntityPlayer: <init> method not found");
		}
		if (transformedName.equals("net.minecraft.util.FoodStats"))
		{
			boolean isObfuscated = !name.equals(transformedName);

			ClassNode classNode = readClassFromBytes(basicClass);

			injectFoodStatsPlayerField(classNode);
			injectFoodStatsConstructor(classNode);

			MethodNode methodNode = findMethodNodeOfClass(classNode, isObfuscated ? "a" : "func_151686_a", isObfuscated ? "(Lacx;Ladd;)V" : "(Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;)V");
			if (methodNode != null)
			{
				addFoodStatsHook(methodNode, Hooks.class, "modifyFoodValues", "(Lnet/minecraft/util/FoodStats;Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;Liguanaman/hungeroverhaul/util/FoodValues;Lnet/minecraft/entity/player/EntityPlayer;)Z");
			}
			else
				throw new RuntimeException("FoodStats: addStats method not found");
			
			return writeClassToBytes(classNode);
		}

		return basicClass;
	}

	public void patchEntityPlayerInit(MethodNode method, boolean isObfuscated)
	{
		// find NEW net/minecraft/util/FoodStats
		AbstractInsnNode targetNode = findFirstInstructionOfTypeWithDesc(method, NEW, "net/minecraft/util/FoodStats");

		if (targetNode == null)
		{
			throw new RuntimeException("patchEntityPlayerInit: NEW instruction not found");
		}

		do
		{
			targetNode = targetNode.getNext();
		}
		while (targetNode != null && targetNode.getOpcode() != INVOKESPECIAL);

		if (targetNode == null)
		{
			throw new RuntimeException("patchEntityPlayerInit: INVOKESPECIAL instruction not found");
		}

		method.instructions.insertBefore(targetNode, new VarInsnNode(ALOAD, 0));
		((MethodInsnNode) targetNode).desc = "(Lnet/minecraft/entity/player/EntityPlayer;)V";
	}

	public void injectFoodStatsPlayerField(ClassNode classNode)
	{
		classNode.fields.add(new FieldNode(ACC_PUBLIC, "player", Type.getDescriptor(EntityPlayer.class), null, null));
	}

	public void injectFoodStatsConstructor(ClassNode classNode)
	{
		MethodNode constructor = new MethodNode(ACC_PUBLIC, "<init>", "(Lnet/minecraft/entity/player/EntityPlayer;)V", null, null);

		constructor.visitVarInsn(ALOAD, 0);
		constructor.visitMethodInsn(INVOKESPECIAL, classNode.superName, "<init>", "()V");

		constructor.visitVarInsn(ALOAD, 0); // this
		constructor.visitVarInsn(ALOAD, 1); // player param
		constructor.visitFieldInsn(PUTFIELD, classNode.name, "player", Type.getDescriptor(EntityPlayer.class));

		constructor.visitInsn(RETURN);
		constructor.visitMaxs(2, 2);
		constructor.visitEnd();

		classNode.methods.add(constructor);
	}

	public void addFoodStatsHook(MethodNode method, Class<?> hookClass, String hookMethod, String hookDesc)
	{
		AbstractInsnNode targetNode = findFirstInstruction(method);

		InsnList toInject = new InsnList();

		// equivalent to:
		/*
		ItemFood par1=null; ItemStack par2=null;
		
		iguanaman.hungeroverhaul.util.FoodValues modifiedFoodValues = new iguanaman.hungeroverhaul.util.FoodValues(par1.func_150905_g(par2), par1.func_150906_h(par2));
		if (Hooks.modifyFoodValues(null, null, null, modifiedFoodValues))
		{
			this.addStats(modifiedFoodValues.hunger, modifiedFoodValues.saturationModifier);
			return;
		}
		*/

		LabelNode varStartLabel = new LabelNode();
		LabelNode end = findEndLabel(method);
		LocalVariableNode localVar = new LocalVariableNode("modifiedFoodValues", Type.getDescriptor(FoodValues.class), null, varStartLabel, end, method.maxLocals);
		method.maxLocals += 1;
		method.localVariables.add(localVar);
		
		// initialize modifiedFoodValues
		toInject.add(new TypeInsnNode(NEW, Type.getInternalName(FoodValues.class)));
		toInject.add(new InsnNode(DUP));
		toInject.add(new VarInsnNode(ALOAD, 1)); // param 1: ItemFood
		toInject.add(new VarInsnNode(ALOAD, 2)); // param 2: ItemStack
		toInject.add(new MethodInsnNode(INVOKEVIRTUAL, Type.getInternalName(ItemFood.class), "func_150905_g", "(Lnet/minecraft/item/ItemStack;)I"));
		toInject.add(new VarInsnNode(ALOAD, 1)); // param 1: ItemFood
		toInject.add(new VarInsnNode(ALOAD, 2)); // param 2: ItemStack
		toInject.add(new MethodInsnNode(INVOKEVIRTUAL, Type.getInternalName(ItemFood.class), "func_150906_h", "(Lnet/minecraft/item/ItemStack;)F"));
		toInject.add(new MethodInsnNode(INVOKESPECIAL, Type.getInternalName(FoodValues.class), "<init>", "(IF)V"));
		toInject.add(new VarInsnNode(ASTORE, localVar.index));
		toInject.add(varStartLabel);			// variable scope start

		LabelNode ifJumpLabel = new LabelNode();
		
		// get modifiedFoodValues
		toInject.add(new VarInsnNode(ALOAD, 0));					// this
		toInject.add(new VarInsnNode(ALOAD, 1));					// param 1: ItemFood
		toInject.add(new VarInsnNode(ALOAD, 2));					// param 2: ItemStack
		toInject.add(new VarInsnNode(ALOAD, localVar.index));		// food values
		toInject.add(new VarInsnNode(ALOAD, 0));					// this.player
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "player", Type.getDescriptor(EntityPlayer.class)));
		toInject.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(hookClass), hookMethod, hookDesc));
		toInject.add(new JumpInsnNode(IFEQ, ifJumpLabel));			// modifiedFoodValues = hookClass.hookMethod(...)

		// if true, then call addStats with the modified values
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new VarInsnNode(ALOAD, localVar.index));		// modifiedFoodValues
		toInject.add(new FieldInsnNode(GETFIELD, Type.getInternalName(FoodValues.class), "hunger", "I"));
		toInject.add(new VarInsnNode(ALOAD, localVar.index));		// modifiedFoodValues
		toInject.add(new FieldInsnNode(GETFIELD, Type.getInternalName(FoodValues.class), "saturationModifier", "F"));
		toInject.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/util/FoodStats", "addStats", "(IF)V"));
		toInject.add(new InsnNode(RETURN));
		
		toInject.add(ifJumpLabel);			// if hook returned false, will jump here

		method.instructions.insertBefore(targetNode, toInject);
	}

	private ClassNode readClassFromBytes(byte[] bytes)
	{
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		return classNode;
	}

	private byte[] writeClassToBytes(ClassNode classNode)
	{
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		classNode.accept(writer);
		return writer.toByteArray();
	}

	private AbstractInsnNode findFirstInstruction(MethodNode method)
	{
		for (AbstractInsnNode instruction : method.instructions.toArray())
		{
			if (instruction.getType() != AbstractInsnNode.LABEL && instruction.getType() != AbstractInsnNode.LINE)
				return instruction;
		}
		return null;
	}

	private AbstractInsnNode findFirstInstructionOfTypeWithDesc(MethodNode method, int opcode, String desc)
	{
		for (AbstractInsnNode instruction : method.instructions.toArray())
		{
			if (instruction.getOpcode() == opcode)
			{
				boolean descMatches = false;
				switch (instruction.getType())
				{
					case AbstractInsnNode.TYPE_INSN:
						descMatches = desc.equals(((TypeInsnNode) instruction).desc);
						break;
					default:
						break;
				}
				if (descMatches)
					return instruction;
			}
		}
		return null;
	}

	private MethodNode findMethodNodeOfClass(ClassNode classNode, String methodName, String methodDesc)
	{
		for (MethodNode method : classNode.methods)
		{
			if (method.name.equals(methodName) && (methodDesc == null || method.desc.equals(methodDesc)))
			{
				return method;
			}
		}
		return null;
	}

	private LabelNode findEndLabel(MethodNode method)
	{
		LabelNode lastLabel = null;
		for (AbstractInsnNode instruction : method.instructions.toArray())
		{
			if (instruction instanceof LabelNode)
				lastLabel = (LabelNode) instruction;
		}
		return lastLabel;
	}
}
