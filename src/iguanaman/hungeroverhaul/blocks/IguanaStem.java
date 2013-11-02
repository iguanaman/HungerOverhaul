package iguanaman.hungeroverhaul.blocks;

import iguanaman.hungeroverhaul.IguanaConfig;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.BiomeDictionary.Type;

public class IguanaStem extends BlockStem {

	public ArrayList<Type> biomes;
	
	public IguanaStem(int par1, Block par2Block) {
		super(par1, par2Block);
		// TODO Auto-generated constructor stub
	}

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && 
        		(IguanaConfig.cropsNeedSunlight == true && par1World.isDaytime() && par1World.canBlockSeeTheSky(par2, par3, par4))
        		||
        		(IguanaConfig.cropsNeedSunlight == false)
        		)
        {

            // biome modifier
            float biomeModifier = (float)IguanaConfig.wrongBiomeRegrowthMultiplier;
        	try {
        		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(par2, par4);
        		for (Type biomeType : this.biomes) {
        			if(BiomeDictionary.isBiomeOfType(biome, biomeType)) {
        				biomeModifier = 1.0F;
        				break;
        			}
        		}
        		if (this.biomes.contains(biome)) {biomeModifier = 1.0F;}
			} catch (Exception var5) {
				biomeModifier = 1.0F;
			}
        	
            float f = this.getGrowthModifier(par1World, par2, par3, par4);

            if (par5Random.nextInt((int)((5.0F * (float)IguanaConfig.cropRegrowthMultiplier * biomeModifier) / f) + 1) == 0)
            {
                int l = par1World.getBlockMetadata(par2, par3, par4);

                if (l < 7)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
                else if (par5Random.nextInt((int)((30.0F * (float)IguanaConfig.cropRegrowthMultiplier * biomeModifier) / f) + 1) == 0)
                {
                    if (par1World.getBlockId(par2 - 1, par3, par4) == this.fruitType.blockID)
                    {
                        return;
                    }

                    if (par1World.getBlockId(par2 + 1, par3, par4) == this.fruitType.blockID)
                    {
                        return;
                    }

                    if (par1World.getBlockId(par2, par3, par4 - 1) == this.fruitType.blockID)
                    {
                        return;
                    }

                    if (par1World.getBlockId(par2, par3, par4 + 1) == this.fruitType.blockID)
                    {
                        return;
                    }

                    int i1 = par5Random.nextInt(4);
                    int j1 = par2;
                    int k1 = par4;

                    if (i1 == 0)
                    {
                        j1 = par2 - 1;
                    }

                    if (i1 == 1)
                    {
                        ++j1;
                    }

                    if (i1 == 2)
                    {
                        k1 = par4 - 1;
                    }

                    if (i1 == 3)
                    {
                        ++k1;
                    }

                    int l1 = par1World.getBlockId(j1, par3 - 1, k1);

                    boolean isSoil = (blocksList[l1] != null && blocksList[l1].canSustainPlant(par1World, j1, par3 - 1, k1, ForgeDirection.UP, this));
                    if (par1World.getBlockId(j1, par3, k1) == 0 && (isSoil || l1 == Block.dirt.blockID || l1 == Block.grass.blockID))
                    {
                        par1World.setBlock(j1, par3, k1, this.fruitType.blockID);
                    }
                }
            }
        }
    }

    public void fertilizeStem(World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

        if (l > 7)
        {
            l = 7;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    public IguanaStem setBiomes(Type[] par1)
    {
    	this.biomes = new ArrayList<Type>();
    	for(Type biome : par1) {this.biomes.add(biome);}
        return this;
    }


    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(fruitType == pumpkin ? Item.pumpkinSeeds : Item.melonSeeds));
        return ret;
    }
}
