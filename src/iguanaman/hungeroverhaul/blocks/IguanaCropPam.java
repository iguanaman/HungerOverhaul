package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.common.Loader;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.oredict.OreDictionary;
import assets.pamharvestcraft.BlockPamCrop;
import assets.pamharvestcraft.HarvestConfigurationHandler;
import assets.pamharvestcraft.PamHarvestCraft;
import assets.pamharvestcraft.TileEntityPamCrop;

public class IguanaCropPam extends BlockPamCrop {
	   
	public static Type[] biomesNormal = new Type[]{Type.FOREST, Type.PLAINS};
	public static Type[] biomesHumid = new Type[]{Type.JUNGLE, Type.SWAMP};
	public static Type[] biomesDesert = new Type[]{Type.DESERT};
	
   public static Type[][] biomes = new Type[][]
		   {biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal,
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal,  
		   biomesHumid, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesHumid, 
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, 
		   
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, 
		   biomesNormal, biomesDesert, biomesHumid, biomesNormal, biomesNormal, 
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesHumid, biomesHumid, 
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, biomesNormal, 
		   biomesNormal, biomesNormal, biomesNormal, biomesNormal};
	   
	public IguanaCropPam(int par1) {
		super(par1);
		
    	if (Loader.isModLoaded("Thaumcraft"))
    	{
    	   if (!ThaumcraftApi.exists(blockID, -1))
    	   {
    		   ThaumcraftApi.registerObjectTag(blockID, -1, new AspectList()
    		   .add(Aspect.CROP, 2).add(Aspect.HUNGER, 1)
    		   );
    	   }
    	}
	}

	   public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) 
	   {
	      if(!par1World.isRemote) 
	      {
	         Random random = new Random();
	         TileEntityPamCrop tileentitypamcrop = (TileEntityPamCrop)par1World.getBlockTileEntity(par2, par3, par4);
	         if(tileentitypamcrop != null) {
	            int cropID = tileentitypamcrop.getCropID();
	            int stage = tileentitypamcrop.getGrowthStage();
	            {
	            	int produce = IguanaConfig.producePerHarvestMin;
	            	if (IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin > 0)
	            		produce += par1World.rand.nextInt(IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
	            	int seeds = 1 + IguanaConfig.seedsPerHarvestMin;
	            	if (IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin > 0)
		            		seeds += par1World.rand.nextInt(IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin);
	               
	            	   if (stage < 2)
	            	   {
	            		   par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 0.7D, (double)par4 + 0.5D, new ItemStack(PamHarvestCraft.PamSeeds[cropID], 1, 0)));
	                   } 
	            	   else if(stage == 2) 
		               {
	            		   if (produce > 0)
                         	par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 0.7D, (double)par4 + 0.5D, new ItemStack(PamHarvestCraft.PamCropItems[cropID], produce, 0)));
	            		   if (seeds > 0)
                         	par1World.spawnEntityInWorld(new EntityItem(par1World, (double)par2 + 0.5D, (double)par3 + 0.7D, (double)par4 + 0.5D, new ItemStack(PamHarvestCraft.PamSeeds[cropID], seeds, 0)));
		              }
	             }
	       }
	    }
	      

	    par1World.removeBlockTileEntity(par2, par3, par4);
	   }

	/* Right-click harvests crop item*/
	@Override
	public boolean onBlockActivated (World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		/*if (world.isRemote)
			return false;*/
		int i1 = world.getBlockId(par2, par3, par4);
		if(i1 == PamHarvestCraft.pamCrop.blockID) {
			TileEntityPamCrop tileentitypamcrop = (TileEntityPamCrop)world.getBlockTileEntity(par2, par3, par4);
			int cropID = tileentitypamcrop.getCropID();
	        int stage = tileentitypamcrop.getGrowthStage();
	        
	        if (stage == 2)
			{
	            if (world.isRemote) return true;
	            
            	int meta = 0;
            	int produce = IguanaConfig.producePerHarvestMin + world.rand.nextInt(IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
				if (cropID > 28) {
					meta = 1;
					produce = Math.min(Math.round((float) produce / 2f), 1);
				}

	    		EntityItem entityitem = new EntityItem(world, player.posX, player.posY - 1.0D, player.posZ, new ItemStack(PamHarvestCraft.PamCropItems[cropID], produce, 0));
				world.spawnEntityInWorld(entityitem);
				entityitem.onCollideWithPlayer(player);
				tileentitypamcrop.setGrowthStage(meta);
				world.markBlockForUpdate(par2, par3, par4);
				return true;
			}

		}
		
		return false;
	}

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	
    	int sunlightModifier = par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4) ? 1 : IguanaConfig.noSunlightRegrowthMultiplier;
        if (sunlightModifier == 0) return;
    	
        TileEntityPamCrop tileentitypamcrop = (TileEntityPamCrop)par1World.getBlockTileEntity(par2, par3, par4);
        if(tileentitypamcrop != null) {
           int cropID = tileentitypamcrop.getCropID();
           
	        // biome modifier
	        int biomeModifier = IguanaConfig.wrongBiomeRegrowthMultiplier;
	    	try {
	    		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
	    		for (Type biomeType : this.biomes[cropID]) {
	    			if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
	                	//FMLLog.warning("biome is type: " + biomeType.toString(), new Object());
	    				biomeModifier = 1;
	    				break;
	    			}
	    		}
			} catch (Exception var5) { biomeModifier = 1; }
	    	if (biomeModifier == 0) return;
	    	
	    	if (par5Random.nextInt(IguanaConfig.cropRegrowthMultiplier * biomeModifier) != 0) return;
        }

    	super.updateTick(par1World, par2, par3, par4, par5Random);
    }

   /**
    * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
    * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
    * this one). Args: x, y, z
    */
   private float getGrowthRate(World par1World, int par2, int par3, int par4)
   {
       float f = 1.0F;
       int l = par1World.getBlockId(par2, par3, par4 - 1);
       int i1 = par1World.getBlockId(par2, par3, par4 + 1);
       int j1 = par1World.getBlockId(par2 - 1, par3, par4);
       int k1 = par1World.getBlockId(par2 + 1, par3, par4);
       int l1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
       int i2 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
       int j2 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
       int k2 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
       boolean flag = j1 == this.blockID || k1 == this.blockID;
       boolean flag1 = l == this.blockID || i1 == this.blockID;
       boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

       for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2)
       {
           for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3)
           {
               int j3 = par1World.getBlockId(l2, par3 - 1, i3);
               float f1 = 0.0F;

               if (blocksList[j3] != null && blocksList[j3].canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this))
               {
                   f1 = 1.0F;

                   if (blocksList[j3].isFertile(par1World, l2, par3 - 1, i3))
                   {
                       f1 = 3.0F;
                   }
               }

               if (l2 != par2 || i3 != par4)
               {
                   f1 /= 4.0F;
               }

               f += f1;
           }
       }

       if (flag2 || flag && flag1)
       {
           f /= 2.0F;
       }

       return f;
   }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
  	   if (par1World.difficultySetting < 3 || !IguanaConfig.difficultyScalingBoneMeal) 
  	   {
	 	  int i1 = par1World.getBlockId(par2, par3, par4);
 	      if(i1 == PamHarvestCraft.pamCrop.blockID) 
 	      {
 	         TileEntityPamCrop tileentitypamcrop = (TileEntityPamCrop)par1World.getBlockTileEntity(par2, par3, par4);

 	         int rnd = 1;
		  	 if (par1World.difficultySetting == 2  && IguanaConfig.difficultyScalingBoneMeal) rnd = 3;
	 	     if (tileentitypamcrop.cropID > 28) rnd *= 2;
	 	     
	 	     if (rnd == 1 || par1World.rand.nextInt(rnd) == 0) 
	 	     {
		  		   tileentitypamcrop.setGrowthStage(Math.min(tileentitypamcrop.getGrowthStage() + 1, 2));
		  		   par1World.markBlockForUpdate(par2, par3, par4);
	 	     }
 	      }
  	   }
    }
 
}
