package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCrop;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class IguanaSeedFood extends IguanaFood implements IPlantable{

	/** Block ID of the crop this seed food should place. */
	private int cropId;

	private EnumPlantType PlantType;

	public IguanaSeedFood(int par1, int par2, float par3, int par4, int par5)
	{
		this(par1 ,par2, par3, par4, par5, false);
	}

	public IguanaSeedFood(int par1, int par2, float par3, int par4, int par5, boolean integrate)
	{
		super(par1, par2, par3, false, integrate);
		cropId = par4;
		PlantType = EnumPlantType.Crop;
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 == 1 && par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
		{
			int var11 = par3World.getBlockId(par4, par5, par6);
			Block soil = Block.blocksList[var11];

			if (soil != null && soil.canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) && par3World.isAirBlock(par4, par5 + 1, par6))
			{
				par3World.setBlock(par4, par5 + 1, par6, cropId);
				--par1ItemStack.stackSize;
				return true;
			}
		}

		return false;
	}

	public Item setPlantType(EnumPlantType par1)
	{
		PlantType = par1;
		return this;
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return PlantType;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z)
	{
		return cropId;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z)
	{
		return 0;
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (IguanaConfig.wrongBiomeRegrowthMultiplier > 1)
		{
			Type[] theBiomes = null;
			if (Block.blocksList[cropId] instanceof IguanaCrop)
				theBiomes = ((IguanaCrop)Block.blocksList[cropId]).biomes;

			if (theBiomes != null) {
				String tooltip = "";
				for(Type biomeType : theBiomes)
					tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
				par3List.add("Crop grows best in:");
				par3List.add(tooltip.substring(0, tooltip.length() - 2));
			}
		}
	}

}
