package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.blocks.IguanaCrop;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class IguanaFoodSeed extends IguanaFood implements IPlantable{

    /** Block ID of the crop this seed food should place. */
    private int cropId;

    /** Block ID of the soil this seed food should be planted on. */
    private int soilId;
    
    private EnumPlantType PlantType;

    public IguanaFoodSeed(int par1, int par2, float par3, int par4, int par5, boolean integrate, boolean isJuicy, boolean isSeedy)
    {
        super(par1, par2, par3, false, integrate, isJuicy, isSeedy);
        this.cropId = par4;
        this.soilId = par5;
        this.PlantType = EnumPlantType.Crop;
    }

    public IguanaFoodSeed(int par1, int par2, float par3, int par4, int par5, boolean integrate, boolean isJuicy)
    {
    	this(par1 ,par2, par3, par4, par5, integrate, isJuicy, false);
    }

    public IguanaFoodSeed(int par1, int par2, float par3, int par4, int par5, boolean integrate)
    {
    	this(par1 ,par2, par3, par4, par5, integrate, false, false);
    }

    public IguanaFoodSeed(int par1, int par2, float par3, int par4, int par5)
    {
    	this(par1 ,par2, par3, par4, par5, false, false, false);
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

            if (var11 == this.soilId && par3World.isAirBlock(par4, par5 + 1, par6))
            {
                par3World.setBlock(par4, par5 + 1, par6, this.cropId);
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

    public Item setPlantType(EnumPlantType par1)
    {
        this.PlantType = par1;
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
    	super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);

    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) { 
        	par3List.add("");
	    	par3List.add("Plant on: " + Block.blocksList[this.soilId].getLocalizedName());
	    	par3List.add(" ");
	    	par3List.add("Crop grows best in:");
	    	String tooltip = "";
	    	for(BiomeDictionary.Type biomeType : ((IguanaCrop)Block.blocksList[this.cropId]).biomes) {
	    		tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
	    	}
	    	par3List.add(tooltip.substring(0, tooltip.length() - 2));
    	} else {
	    	par3List.add("\u00A7o<Hold SHIFT for more>\u00A7r");
    	}
    }
    
}
