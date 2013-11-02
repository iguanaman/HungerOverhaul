package iguanaman.hungeroverhaul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ComponentVillageCustomField extends ComponentVillage
{
    private int averageGroundLevel = -1;
    private fieldType typeA;
    private fieldType typeB;

    public ComponentVillageCustomField(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;

    }
    
    private enum fieldType {
    	NORMAL, REED, STEM
    }

    private int getRandomStemCrop(Random par1Random)
    {
    	ArrayList<Integer> crops = new ArrayList<Integer>();
		crops.add(ModuleVanilla.pumpkinStemNew.blockID);
		crops.add(ModuleVanilla.melonStemNew.blockID);
        return crops.get(par1Random.nextInt(crops.size() - 1));
    }

    /**
     * Returns a crop type to be planted on this field.
     */
    private int getRandomCrop(Random par1Random)
    {
    	ArrayList<Integer> crops = new ArrayList<Integer>();
    	
    	crops.add(ModuleVanilla.wheatNew.blockID);
    	crops.add(ModuleVanilla.carrotNew.blockID);
    	crops.add(ModuleVanilla.potatoNew.blockID);
		
		return crops.get(par1Random.nextInt(crops.size()));
    }

    /**
     * Returns a crop type to be planted on this field.
     */
    private int getRandomCropType(Random par1Random)
    {
    	return 0;
    	
    	/*
    	if (par1Random.nextInt(63) < 3) {
    		return 0;
    	} else {
    		return 1;
    	}
    	*/
    }

    /**
     * Returns a crop type to be planted on this field.
     */
    private int getRandomHarvestcraftCrop(Random par1Random)
    {
    	return par1Random.nextInt(60);
    }

    public static ComponentVillageCustomField buildComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 13, 4, 9, par6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new ComponentVillageCustomField(par0ComponentVillageStartPiece, par7, par2Random, var8, par6) : null;
    }
    
    private fieldType randomFieldType(BiomeGenBase biome, Random random) {

        int normalWeight = IguanaConfig.fieldNormalWeight;
        int reedWeight = IguanaConfig.fieldReedWeight;
        int stemWeight = IguanaConfig.fieldStemWeight;

		if (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) || BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) {
			reedWeight *= 2;
			stemWeight *= 2;
		}
      
        int weights = normalWeight + reedWeight + stemWeight;
        int rnd = random.nextInt(weights);
        
        if (rnd < reedWeight) {
        	return fieldType.REED;
        } else if (rnd < reedWeight + stemWeight) {
        	return fieldType.STEM;
        } else {
        	return fieldType.NORMAL;
        }
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(par1World, par3StructureBoundingBox);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        int x = par3StructureBoundingBox.getCenterX();
        int z = par3StructureBoundingBox.getCenterZ();

		BiomeGenBase biome = par1World.getWorldChunkManager().getBiomeGenAt(x, z);

		typeA = randomFieldType(biome, par2Random);
		typeB = randomFieldType(biome, par2Random);
		
        int blockOutA = Block.tilledField.blockID;
        int blockInA = Block.waterMoving.blockID;
        int blockOutB = Block.tilledField.blockID;
        int blockInB = Block.waterMoving.blockID;

        int crop1A = 0;
        int crop2A = 0;
        int crop1B = 0;
        int crop2B = 0;

        int crop1Atype = 0;
        int crop2Atype = 0;
        int crop1Btype = 0;
        int crop2Btype = 0;
        
        if (typeA == fieldType.REED) {
    		if (BiomeDictionary.isBiomeOfType(biome, Type.DESERT)) {
    			blockOutA = Block.sand.blockID;
    		} else {
    			blockOutA = Block.dirt.blockID;
    		}
    		crop1A = ModuleVanilla.reedNew.blockID;
    		crop2A = ModuleVanilla.reedNew.blockID;
    	} else if (typeA == fieldType.STEM) {
    		crop1A = getRandomStemCrop(par2Random);
    		crop2A = getRandomStemCrop(par2Random);
		} else {
	        crop1Atype = getRandomCropType(par2Random);
	        if (crop1Atype == 0) {
				crop1A = getRandomCrop(par2Random);
	        } else {
				crop1A = getRandomHarvestcraftCrop(par2Random);
	        }

	        crop2Atype = getRandomCropType(par2Random);
	        if (crop2Atype == 0) {
				crop2A = getRandomCrop(par2Random);
	        } else {
				crop2A = getRandomHarvestcraftCrop(par2Random);
	        }
		}
        
        if (typeB == fieldType.REED) {
    		if (BiomeDictionary.isBiomeOfType(biome, Type.DESERT)) {
    			blockOutB = Block.sand.blockID;
    		} else {
    			blockOutB = Block.dirt.blockID;
    		}
    		crop1B = ModuleVanilla.reedNew.blockID;
    		crop2B = ModuleVanilla.reedNew.blockID;
    	} else if (typeA == fieldType.STEM) {
    		crop1B = getRandomStemCrop(par2Random);
    		crop2B = getRandomStemCrop(par2Random);
		} else {
	        crop1Btype = getRandomCropType(par2Random);
	        if (crop1Btype == 0) {
				crop1B = getRandomCrop(par2Random);
	        } else {
				crop1B = getRandomHarvestcraftCrop(par2Random);
	        }

	        crop2Btype = getRandomCropType(par2Random);
	        if (crop2Btype == 0) {
				crop2B = getRandomCrop(par2Random);
	        } else {
				crop2B = getRandomHarvestcraftCrop(par2Random);
	        }
		}
        
		//BASE
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 12, 4, 8, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 0, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 0, 0, 6, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 12, 0, 0, 12, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 0, 11, 0, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 8, 11, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        
		//A
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 2, 0, 7, blockOutA, blockOutA, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 0, 1, 3, 0, 7, blockInA, blockInA, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 0, 1, 5, 0, 7, blockOutA, blockOutA, false);
        
        //B
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 7, 0, 1, 8, 0, 7, blockOutB, blockOutB, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 9, 0, 1, 9, 0, 7, blockInB, blockInB, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 10, 0, 1, 11, 0, 7, blockOutB, blockOutB, false);

        //CROPS A
        int tmp = 1;
        if (typeA == fieldType.STEM) {++tmp;}
        while (tmp <= 7)
        {
	        this.placeBlockAtCurrentPosition(par1World, crop1A, MathHelper.getRandomIntegerInRange(par2Random, 0, 4), 2, 1, tmp, par3StructureBoundingBox);
        	this.placeBlockAtCurrentPosition(par1World, crop2A, MathHelper.getRandomIntegerInRange(par2Random, 0, 4), 4, 1, tmp, par3StructureBoundingBox);
            if (typeA == fieldType.STEM) {++tmp;++tmp;} else {++tmp;}
        }
        
        //CROPS B
        tmp = 1;
        if (typeA == fieldType.STEM) {++tmp;}
        while (tmp <= 7)
        {
    		this.placeBlockAtCurrentPosition(par1World, crop1B, MathHelper.getRandomIntegerInRange(par2Random, 0, 4), 8, 1, tmp, par3StructureBoundingBox);
    		this.placeBlockAtCurrentPosition(par1World, crop2B, MathHelper.getRandomIntegerInRange(par2Random, 0, 4), 10, 1, tmp, par3StructureBoundingBox);
            if (typeA == fieldType.STEM) {++tmp;++tmp;} else {++tmp;}
        }

        //FILLER
        for (int var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 13; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(par1World, var5, 4, var4, par3StructureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(par1World, Block.dirt.blockID, 0, var5, -1, var4, par3StructureBoundingBox);
            }
        }

        return true;
    }
}
