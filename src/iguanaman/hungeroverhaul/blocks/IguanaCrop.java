package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaCrop extends BlockCrops { // implements IFarmable, ICrop 

    int cropID;
    int cropMeta;
    int seedID;
	int soilID;
	EnumPlantType plantType;
	
	public ArrayList<Type> biomes;

	String veg;
    
		
    /** The metadata value the crop returns to after being harvested. */
    private final int regrowState;
    
    
    protected IguanaCrop(int par1, String veg, int regrow)
    {
        super(par1);
        this.regrowState = regrow;
        this.soilID = Block.tilledField.blockID;
        this.plantType = EnumPlantType.Crop;
        this.setBiomes(new Type[]{Type.FOREST, Type.PLAINS});
        this.veg = veg;
    }
    
    public IguanaCrop(int par1, String veg)
    {
    	this(par1, veg, 0);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == this.soilID;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        int light = par1World.getBlockLightValue(par2, par3, par4);
        if (light >= 9 && 
        		((IguanaConfig.cropsNeedSunlight && par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4))
        		|| !IguanaConfig.cropsNeedSunlight)
        		)
            {
            int l = par1World.getBlockMetadata(par2, par3, par4);
    		
            if (l < 7)
            {
                // biome modifier
                float biomeModifier = (float)IguanaConfig.wrongBiomeRegrowthMultiplier;
            	try {
            		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
            		for (Type biomeType : this.biomes) {
            			if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
                        	//FMLLog.warning("biome is type: " + biomeType.toString(), new Object());
            				biomeModifier = 1.0F;
            				break;
            			}
            		}
				} catch (Exception var5) {
    				biomeModifier = 1.0F;
				}
            	
            	//FMLLog.warning("biomeModifier: " + biomeModifier, new Object());
        		
                float f = this.getGrowthRate(par1World, par2, par3, par4);
                
        		if (par1World.getBlockMetadata(par2, par3, par4) >= this.regrowState) {
        			f *= 1.0F - ((float)this.regrowState / 7.0F);
        		}

                if (par5Random.nextInt((int)((25.0F * (float)IguanaConfig.cropRegrowthMultiplier * biomeModifier) / f) + 1) == 0)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    /**
     * Apply bonemeal to the crops.
     */
    @Override
    public void fertilize(World par1World, int par2, int par3, int par4)
    {

 	   if (par1World.difficultySetting < 3 || IguanaConfig.difficultyScalingBoneMeal == false) {
	        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
	
	        if (l > 7)
	        {
	            l = 7;
	        }
	
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
 	   }

    }
    

    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        if (metadata >= 7)
        {

            int produce = IguanaConfig.producePerHarvestMin + world.rand.nextInt(1 + IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
            if (produce > 0) { 
            	ret.add(new ItemStack(this.getCropItem(), produce, this.getCropItemMeta()));
            }
            
            int seeds = IguanaConfig.seedsPerHarvestMin + world.rand.nextInt(1 + IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin);
            if (seeds > 0) { 
            	ret.add(new ItemStack(this.getSeedItem(), seeds, 0));
            }
        }

        return ret;
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
    @Override
    protected int getCropItem()
    {
        return this.cropID;
    }
    
    protected int getCropItemMeta()
    {
        return this.cropMeta;
    }

    public IguanaCrop setCropItem(int id)
    {
    	return this.setCropItem(id, 0);
    }

    protected IguanaCrop setCropItem(int id, int meta)
    {
        this.cropID = id;
        this.cropMeta = meta;
        return this;
    }

    /**
     * Generate a seed ItemStack for this crop.
     */
    @Override
    protected int getSeedItem()
    {
        return this.seedID;
    }

    public IguanaCrop setSeedItem(int par1)
    {
        this.seedID = par1;
        return this;
    }

    protected IguanaCrop setSoilItem(int par1)
    {
        this.soilID = par1;
        return this;
    }

    protected IguanaCrop setBiomes(Type[] par1)
    {
    	this.biomes = new ArrayList<Type>();
    	for(Type biome : par1) {this.biomes.add(biome);}
        return this;
    }
    
    @Override
    public int damageDropped(int par1)
    {
        return par1 == 7 ? this.getCropItemMeta() : 0;
    }

    /**
     * Harvest crops by right clicking on them (also bone meal)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
       int par5 = par1World.getBlockMetadata(par2, par3, par4);
       if(par5 >= 7) {
       		super.dropBlockAsItem(par1World, par2, par3, par4, par5, par6);
	       	par1World.setBlockMetadataWithNotify(par2, par3, par4, this.regrowState, 2);
	        super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	        return true;
       }
       else
       {
           return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
       }
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
    	return this.plantType;
    }
    
    public IguanaCrop setPlantType(EnumPlantType par1)
    {
    	 this.plantType = par1;
    	 return this;
    }


	/*
    @Override
    public void onBlockDestroyedByPlayer(World world, int par2, int par3, int par4, int par5)
    {
    	if (par5 == 7)
    	{
    		EntityItem entityitem = new EntityItem(world, par2, par3, par4, new ItemStack(this.getSeedItem(), 1, 0));
			world.spawnEntityInWorld(entityitem);
    	}
    }
    
	@Override
	public boolean isSaplingAt(World world, int x, int y, int z) {
	      if (world.getBlockId(x, y, z) == this.blockID) {
	    	  if (world.getBlockMetadata(x, y, z) < 7) {
	    		  return true;
	    	  }
	      }
	      return false;
	}

	@Override
	public ICrop getCropAt(World world, int x, int y, int z) {
	      return world.getBlockId(x, y, z) != this.blockID?null:(world.getBlockMetadata(x, y, z) != 7?null:this);
	}

	@Override
	public boolean isGermling(ItemStack itemstack) {
		return getSeedItem() == itemstack.itemID;
	}

	@Override
	public boolean isWindfall(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean plantSaplingAt(ItemStack germling, World world, int x,
			int y, int z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		return world.setBlock(x, y, z, this.blockID, 0, 2);
	}
	
	@Override
	public Collection<ItemStack> harvest() {
		Collection<ItemStack> harvested = this.getBlockDropped(world, this.x, this.y, this.z, 7, 0);
		//HungerOverhaul.proxy.addBlockDestroyEffects(world, this.x, this.y, this.z, this.blockID, 0);
		world.setBlock(this.x, this.y, this.z, 0, 0, 2);
		return harvested;
	}
*/

}
