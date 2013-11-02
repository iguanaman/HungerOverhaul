package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.blocks.IguanaCrop;
import iguanaman.hungeroverhaul.blocks.IguanaStem;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.Loader;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class IguanaSeed extends ItemSeeds implements IPlantable {

    /**
     * The type of block this seed turns into (wheat or pumpkin stems for instance)
     */
    //public int blockType;

    /** BlockID of the block the seeds can be planted on. */
    //public int soilBlockID;

    public IguanaSeed(int par1, int par2, int par3)
    {
        super(par1, par2, par3);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
        {
            int var11 = par3World.getBlockId(par4, par5, par6);

            if (var11 == this.soilBlockID && par3World.isAirBlock(par4, par5 + 1, par6))
            {
                par3World.setBlock(par4, par5 + 1, par6, this.blockType);
                --par1ItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /*
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return EnumPlantType.Crop;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return this.blockType;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) { 
	    	par3List.add("Plant on: " + Block.blocksList[this.soilBlockID].getLocalizedName());
	    	par3List.add(" ");
	    	par3List.add("Crop grows best in:");
	    	String tooltip = "";

	    	ArrayList<Type> theBiomes = null;
	    	if (Block.blocksList[this.blockType] instanceof IguanaCrop) {
	    		theBiomes = ((IguanaCrop)Block.blocksList[this.blockType]).biomes;
	    	} else if (Block.blocksList[this.blockType] instanceof IguanaStem) {
	    		theBiomes = ((IguanaStem)Block.blocksList[this.blockType]).biomes;
	    	}
	    	
	    	if (theBiomes != null) {
		    	for(Type biomeType : theBiomes) {
		    		tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
		    	}
		    	par3List.add(tooltip.substring(0, tooltip.length() - 2));
	    	}
    	} else {
	    	par3List.add("\u00A7o<Hold SHIFT for more>\u00A7r");
    	}
    }
}
