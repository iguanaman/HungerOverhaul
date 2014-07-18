package iguanaman.hungeroverhaul.core;

import static org.objectweb.asm.Opcodes.*;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.api.FoodValues;
import net.minecraft.entity.player.EntityPlayer;
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

            MethodNode addStatsMethodNode = findMethodNodeOfClass(classNode, isObfuscated ? "a" : "addStats", "(IF)V");
            if(addStatsMethodNode != null)
            {
                addHungerLossRateCheck(addStatsMethodNode);
            }

			MethodNode methodNode = findMethodNodeOfClass(classNode, isObfuscated ? "a" : "func_151686_a", isObfuscated ? "(Lacx;Ladd;)V" : "(Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;)V");
			if (methodNode != null)
			{
				addItemStackAwareFoodStatsHook(methodNode, Hooks.class, "onFoodStatsAdded", "(Lnet/minecraft/util/FoodStats;Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/player/EntityPlayer;)Liguanaman/hungeroverhaul/api/FoodValues;");
			}
			else
				throw new RuntimeException("FoodStats: ItemStack-aware addStats method not found");

            MethodNode updateMethodNode = findMethodNodeOfClass(classNode, isObfuscated ? "a" : "onUpdate", isObfuscated ? "(Lyz;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V");
            if (updateMethodNode != null)
            {
                addMinHungerToHeal(updateMethodNode, isObfuscated);
                addConfigurableDamageOnStarve(updateMethodNode);
                addConfigurableHungerLoss(classNode, updateMethodNode, isObfuscated);
            }
            else
                throw new RuntimeException("FoodStats: onUpdate method not found");

			return writeClassToBytes(classNode);
		}
		if (transformedName.equals("net.minecraft.item.ItemFood"))
		{
			boolean isObfuscated = !name.equals(transformedName);

			ClassNode classNode = readClassFromBytes(basicClass);

			MethodNode methodNode = findMethodNodeOfClass(classNode, isObfuscated ? "d_" : "getMaxItemUseDuration", isObfuscated ? "(Ladd;)I" : "(Lnet/minecraft/item/ItemStack;)I");
			if (methodNode != null)
			{
				addFoodEatingSpeedHook(methodNode, Hooks.class, "getModifiedFoodEatingSpeed", "(Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;)I");
			}
			else
				throw new RuntimeException("FoodStats: ItemStack-aware addStats method not found");

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

	public void addItemStackAwareFoodStatsHook(MethodNode method, Class<?> hookClass, String hookMethod, String hookDesc)
	{
		// injected code:
		/*
		FoodValues modifiedFoodValues;
		if ((modifiedFoodValues = Hooks.onFoodStatsAdded(this, par1, par2, this.player)) != null)
		{
			int prevFoodLevel = this.foodLevel;
			float prevSaturationLevel = this.foodSaturationLevel;
			
			this.addStats(modifiedFoodValues.hunger, modifiedFoodValues.saturationModifier);
			
			Hooks.onPostFoodStatsAdded(this, modifiedFoodValues, this.foodLevel - prevFoodLevel, this.foodSaturationLevel - prevSaturationLevel, this.player);
			return;
		}
		*/

		AbstractInsnNode targetNode = findFirstInstruction(method);

		InsnList toInject = new InsnList();

		// create modifiedFoodValues variable
		LabelNode modifiedFoodValuesStart = new LabelNode();
		LabelNode end = findEndLabel(method);
		LocalVariableNode modifiedFoodValues = new LocalVariableNode("modifiedFoodValues", Type.getDescriptor(FoodValues.class), null, modifiedFoodValuesStart, end, method.maxLocals);
		method.maxLocals += 1;
		method.localVariables.add(modifiedFoodValues);

		LabelNode ifJumpLabel = new LabelNode();

		// create prevFoodLevel variable
		LabelNode prevFoodLevelStart = new LabelNode();
		LocalVariableNode prevFoodLevel = new LocalVariableNode("prevFoodLevel", "I", null, prevFoodLevelStart, ifJumpLabel, method.maxLocals);
		method.maxLocals += 1;
		method.localVariables.add(prevFoodLevel);

		// create prevSaturationLevel variable
		LabelNode prevSaturationLevelStart = new LabelNode();
		LocalVariableNode prevSaturationLevel = new LocalVariableNode("prevSaturationLevel", "F", null, prevSaturationLevelStart, ifJumpLabel, method.maxLocals);
		method.maxLocals += 1;
		method.localVariables.add(prevSaturationLevel);

		// get modifiedFoodValues
		toInject.add(new VarInsnNode(ALOAD, 0));					// this
		toInject.add(new VarInsnNode(ALOAD, 1));					// param 1: ItemFood
		toInject.add(new VarInsnNode(ALOAD, 2));					// param 2: ItemStack
		toInject.add(new VarInsnNode(ALOAD, 0));					// this.player (together with below line)
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "player", Type.getDescriptor(EntityPlayer.class)));
		toInject.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(hookClass), hookMethod, hookDesc));
		toInject.add(new InsnNode(DUP));
		toInject.add(new VarInsnNode(ASTORE, modifiedFoodValues.index));		// modifiedFoodValues = hookClass.hookMethod(...)
		toInject.add(modifiedFoodValuesStart);								// variable scope start
		toInject.add(new JumpInsnNode(IFNULL, ifJumpLabel));		// if (modifiedFoodValues != null)

		// if true
		// save current hunger/saturation levels
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "foodLevel", "I"));
		toInject.add(new VarInsnNode(ISTORE, prevFoodLevel.index));
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "foodSaturationLevel", "F"));
		toInject.add(new VarInsnNode(FSTORE, prevSaturationLevel.index));

		// call this.addStats(IF)V with the modified values
		toInject.add(new VarInsnNode(ALOAD, 0));					// this
		toInject.add(new VarInsnNode(ALOAD, modifiedFoodValues.index));		// modifiedFoodValues
		toInject.add(new FieldInsnNode(GETFIELD, Type.getInternalName(FoodValues.class), "hunger", "I"));
		toInject.add(new VarInsnNode(ALOAD, modifiedFoodValues.index));		// modifiedFoodValues
		toInject.add(new FieldInsnNode(GETFIELD, Type.getInternalName(FoodValues.class), "saturationModifier", "F"));
		toInject.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/util/FoodStats", "addStats", "(IF)V"));

		/*
		 * Start onPostFoodStatsAdded call
		 */
		// this
		toInject.add(new VarInsnNode(ALOAD, 0));

		// par1 (ItemFood)
		toInject.add(new VarInsnNode(ALOAD, 1));

		// par2 (ItemStack)
		toInject.add(new VarInsnNode(ALOAD, 2));

		// modifiedFoodValues
		toInject.add(new VarInsnNode(ALOAD, modifiedFoodValues.index));

		// prevFoodLevel - this.foodLevel
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "foodLevel", "I"));
		toInject.add(new VarInsnNode(ILOAD, prevFoodLevel.index));
		toInject.add(new InsnNode(ISUB));

		// prevSaturationLevel - this.foodSaturationLevel
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "foodSaturationLevel", "F"));
		toInject.add(new VarInsnNode(FLOAD, prevSaturationLevel.index));
		toInject.add(new InsnNode(FSUB));

		// player
		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/FoodStats", "player", Type.getDescriptor(EntityPlayer.class)));
		toInject.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(hookClass), "onPostFoodStatsAdded", "(Lnet/minecraft/util/FoodStats;Lnet/minecraft/item/ItemFood;Lnet/minecraft/item/ItemStack;Liguanaman/hungeroverhaul/api/FoodValues;IFLnet/minecraft/entity/player/EntityPlayer;)V"));
		/*
		 * End onPostFoodStatsAdded call
		 */

		// return
		toInject.add(new InsnNode(RETURN));
		toInject.add(ifJumpLabel);			// if hook returned null, will jump here

		method.instructions.insertBefore(targetNode, toInject);
	}

	private void addFoodEatingSpeedHook(MethodNode method, Class<?> hookClass, String hookMethod, String hookDesc)
	{
		// modified code:
		/*
		return IguanaConfig.modifyFoodEatingSpeed ? Hooks.getModifiedFoodEatingSpeed(this, par1) : 32;
		*/

		AbstractInsnNode targetNode = findFirstInstruction(method);

		LabelNode ifShouldntModify = new LabelNode();
		LabelNode beforeReturn = new LabelNode();

		InsnList toInject = new InsnList();
		toInject.add(new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "modifyFoodEatingSpeed", "Z"));
		toInject.add(new JumpInsnNode(IFEQ, ifShouldntModify));
		toInject.add(new VarInsnNode(ALOAD, 0)); // this (ItemFood)
		toInject.add(new VarInsnNode(ALOAD, 1)); // par1 (ItemStack)
		toInject.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(hookClass), hookMethod, hookDesc));
		toInject.add(new JumpInsnNode(GOTO, beforeReturn));
		toInject.add(ifShouldntModify);

		method.instructions.insertBefore(targetNode, toInject);

		targetNode = findLastInstructionOfType(method, IRETURN);

		method.instructions.insertBefore(targetNode, beforeReturn);
	}

    private void addHungerLossRateCheck(MethodNode method)
    {
        // injected code:
        /*
        if(IguanaConfig.hungerLossRatePercentage > 0)
        {
            // default code
        }
        */

        AbstractInsnNode targetNode = findFirstInstruction(method);

        LabelNode ifGreaterThan = new LabelNode();

        InsnList toInject = new InsnList();
        toInject.add(new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "hungerLossRatePercentage", "I"));
        toInject.add(new JumpInsnNode(IFLE, ifGreaterThan));

        method.instructions.insertBefore(targetNode, toInject);

        targetNode = findLastInstructionOfType(method, PUTFIELD).getNext().getNext();

        method.instructions.insertBefore(targetNode, ifGreaterThan);
    }

    private void addMinHungerToHeal(MethodNode method, boolean isObfuscated)
    {
        // modified code:
        /*
        this.foodLevel >= 18
        	modified to:
        this.foodLevel >= IguanaConfig.minHungerToHeal && IguanaConfig.healthRegenRatePercentage > 0
        */

        AbstractInsnNode targetNode = findField(method, isObfuscated ? "a" : "foodLevel", "I", 3).getNext().getNext();

        method.instructions.remove(targetNode.getPrevious());
        method.instructions.insertBefore(targetNode, new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "minHungerToHeal", "I"));
        
        LabelNode ifLabel = null;
        if (targetNode.getOpcode() == IF_ICMPLT)
        	ifLabel = ((JumpInsnNode) targetNode).label;
        else
        	throw new RuntimeException("IF_ICMPLT node not found");
        
        InsnList ifRegenRateInstructions = new InsnList();
        ifRegenRateInstructions.add(new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "healthRegenRatePercentage", "I"));
        ifRegenRateInstructions.add(new JumpInsnNode(IFLE, ifLabel));
        
        method.instructions.insert(targetNode, ifRegenRateInstructions);
    }

    private void addConfigurableDamageOnStarve(MethodNode method)
    {
        // modified code:
        /*
        p_75118_1_.attackEntityFrom(DamageSource.starve, 1.0F); -> p_75118_1_.attackEntityFrom(DamageSource.starve, IguanaConfig.damageOnStarve);
        */

        AbstractInsnNode targetNode = findLastInstructionOfType(method, INVOKEVIRTUAL);

        InsnList toInject = new InsnList();
        toInject.add(new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "damageOnStarve", "I"));
        toInject.add(new InsnNode(I2F));

        method.instructions.remove(targetNode.getPrevious());

        method.instructions.insertBefore(targetNode, toInject);
    }

	private void addConfigurableHungerLoss(ClassNode classNode, MethodNode method, boolean isObfuscated)
	{
		// code modified to:
		/*
    	if (IguanaConfig.hungerLossRatePercentage == 0)
    	{
	    	foodExhaustionLevel = 0.0F;
	    	foodSaturationLevel = 0.0F;
	    	foodLevel = 19;
    	}
    	else if (this.foodExhaustionLevel > Hooks.getMaxExhaustion(player))
        {
            this.foodExhaustionLevel = 0.0F;

			// default code
        }
		 */

		AbstractInsnNode firstInjectPoint = findFirstInstructionOfType(method, PUTFIELD);
		AbstractInsnNode maxExhaustionReplacePoint = findFirstInstructionOfType(method, LDC);

		LabelNode afterFoodExhaustionCheck = null;
		AbstractInsnNode ifLE = maxExhaustionReplacePoint.getNext().getNext();
		if (ifLE.getOpcode() == IFLE)
			afterFoodExhaustionCheck = ((JumpInsnNode) ifLE).label;
			
		
		if (firstInjectPoint == null || maxExhaustionReplacePoint == null || ifLE == null || afterFoodExhaustionCheck == null)
			throw new RuntimeException("Unexpected instructions found in FoodStats.onUpdate");

		InsnList toInject = new InsnList();

		LabelNode ifHungerLossPercentageNotZero = new LabelNode();

		toInject.add(new FieldInsnNode(GETSTATIC, Type.getInternalName(IguanaConfig.class), "hungerLossRatePercentage", "I"));
		toInject.add(new JumpInsnNode(IFNE, ifHungerLossPercentageNotZero));

		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new InsnNode(FCONST_0));
		toInject.add(new FieldInsnNode(PUTFIELD, classNode.name.replace(".", "/"), isObfuscated ? "c" : "foodExhaustionLevel", "F"));

		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new InsnNode(FCONST_0));
		toInject.add(new FieldInsnNode(PUTFIELD, classNode.name.replace(".", "/"), isObfuscated ? "b" : "foodSaturationLevel", "F"));

		toInject.add(new VarInsnNode(ALOAD, 0));
		toInject.add(new VarInsnNode(BIPUSH, 19));
		toInject.add(new FieldInsnNode(PUTFIELD, classNode.name.replace(".", "/"), isObfuscated ? "a" : "foodLevel", "I"));

		toInject.add(new JumpInsnNode(GOTO, afterFoodExhaustionCheck));
		toInject.add(ifHungerLossPercentageNotZero);

		method.instructions.insert(firstInjectPoint, toInject);
		
		toInject.clear();
		toInject.add(new VarInsnNode(ALOAD, 1));
		toInject.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(Hooks.class), "getMaxExhaustion", "(Lnet/minecraft/entity/player/EntityPlayer;)F"));
		
		method.instructions.insertBefore(maxExhaustionReplacePoint, toInject);
		method.instructions.remove(maxExhaustionReplacePoint);
		
		AbstractInsnNode setToZeroTarget = ifLE.getNext();
		while (setToZeroTarget != null && setToZeroTarget.getOpcode() != DUP)
		{
			setToZeroTarget = setToZeroTarget.getNext();
		}
		
		if (setToZeroTarget == null)
			throw new RuntimeException("Failed to find DUP instruction after IFLE");
		
		method.instructions.insertBefore(setToZeroTarget, new InsnNode(FCONST_0));
		
		AbstractInsnNode insnToRemove = setToZeroTarget;
		while (insnToRemove != null && insnToRemove.getOpcode() != PUTFIELD)
		{
			insnToRemove = insnToRemove.getNext();
			method.instructions.remove(insnToRemove.getPrevious());
		}
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
		for (AbstractInsnNode instruction = method.instructions.getFirst(); instruction != null; instruction = instruction.getNext())
		{
			if (instruction.getType() != AbstractInsnNode.LABEL && instruction.getType() != AbstractInsnNode.LINE)
				return instruction;
		}
		return null;
	}

	private AbstractInsnNode findFirstInstructionOfType(MethodNode method, int opcode)
	{
		for (AbstractInsnNode instruction = method.instructions.getFirst(); instruction != null; instruction = instruction.getNext())
		{
			if (instruction.getOpcode() == opcode)
				return instruction;
		}
		return null;
	}

	private AbstractInsnNode findFirstInstructionOfTypeWithDesc(MethodNode method, int opcode, String desc)
	{
		for (AbstractInsnNode instruction = method.instructions.getFirst(); instruction != null; instruction = instruction.getNext())
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

    private AbstractInsnNode findField(MethodNode method, String field, String type, int timeFound)
    {
        int found = 0;
		for (AbstractInsnNode instruction = method.instructions.getFirst(); instruction != null; instruction = instruction.getNext())
		{
            if(instruction.getOpcode() == GETFIELD)
            {
                FieldInsnNode fieldNode = (FieldInsnNode) instruction;
                if(fieldNode.name.equals(field) && fieldNode.desc.equals(type))
                {
                    ++found;
                    if(found == timeFound)
                    {
                        return instruction;
                    }
                }
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
		for (AbstractInsnNode instruction = method.instructions.getLast(); instruction != null; instruction = instruction.getPrevious())
		{
			if (instruction instanceof LabelNode)
				return (LabelNode) instruction;
		}
		return null;
	}

	private AbstractInsnNode findLastInstructionOfType(MethodNode method, int bytecode)
	{
		for (AbstractInsnNode instruction = method.instructions.getLast(); instruction != null; instruction = instruction.getPrevious())
		{
			if (instruction.getOpcode() == bytecode)
				return instruction;
		}
		return null;
	}
}
