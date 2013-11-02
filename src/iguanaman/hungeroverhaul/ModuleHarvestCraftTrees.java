package iguanaman.hungeroverhaul;

import iguanaman.hungeroverhaul.blocks.IguanaCropPam;
import iguanaman.hungeroverhaul.blocks.IguanaFruit;
import iguanaman.hungeroverhaul.items.IguanaSeedPam;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import assets.pamharvestcraft.HarvestConfigurationHandler;
import assets.pamharvestcraft.ItemPamSeedFood;
import assets.pamharvestcraft.PamHarvestCraft;
import cpw.mods.fml.common.Loader;

public class ModuleHarvestCraftTrees {

	public static void init()
	{

		if(Loader.isModLoaded("pamharvestcraft"))
		{
			Block.blocksList[PamHarvestCraft.pamApple.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamAvocado.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamBanana.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamCherry.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamCinnamon.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamCoconut.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamDragonfruit.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamLemon.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamLime.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamMango.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamNutmeg.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamOlive.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamOrange.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPapaya.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPeach.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPear.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPeppercorn.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPlum.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamPomegranate.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamStarfruit.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamVanillabean.blockID] = null;
			Block.blocksList[PamHarvestCraft.pamWalnut.blockID] = null;
			PamHarvestCraft.pamApple = new IguanaFruit(HarvestConfigurationHandler.pamappleID, "apple").setTreeDrop(Item.appleRed.itemID);
			PamHarvestCraft.pamAvocado = new IguanaFruit(HarvestConfigurationHandler.pamavocadoID, "avocado").setTreeDrop(PamHarvestCraft.avocadoItem.itemID);
			PamHarvestCraft.pamBanana = new IguanaFruit(HarvestConfigurationHandler.pambananaID, "banana").setTreeDrop(PamHarvestCraft.bananaItem.itemID);
			PamHarvestCraft.pamCherry = new IguanaFruit(HarvestConfigurationHandler.pamcherryID, "cherry").setTreeDrop(PamHarvestCraft.cherryItem.itemID);
			PamHarvestCraft.pamCinnamon = new IguanaFruit(HarvestConfigurationHandler.pamcinnamonID, "cinnamon").setTreeDrop(PamHarvestCraft.cinnamonItem.itemID);
			PamHarvestCraft.pamCoconut = new IguanaFruit(HarvestConfigurationHandler.pamcoconutID, "coconut").setTreeDrop(PamHarvestCraft.coconutItem.itemID);
			PamHarvestCraft.pamDragonfruit = new IguanaFruit(HarvestConfigurationHandler.pamdragonfruitID, "dragonfruit").setTreeDrop(PamHarvestCraft.dragonfruitItem.itemID);
			PamHarvestCraft.pamLemon = new IguanaFruit(HarvestConfigurationHandler.pamlemonID, "lemon").setTreeDrop(PamHarvestCraft.lemonItem.itemID);
			PamHarvestCraft.pamLime = new IguanaFruit(HarvestConfigurationHandler.pamlimeID, "lime").setTreeDrop(PamHarvestCraft.limeItem.itemID);
			PamHarvestCraft.pamMango = new IguanaFruit(HarvestConfigurationHandler.pammangoID, "mango").setTreeDrop(PamHarvestCraft.mangoItem.itemID);
			PamHarvestCraft.pamNutmeg = new IguanaFruit(HarvestConfigurationHandler.pamnutmegID, "nutmeg").setTreeDrop(PamHarvestCraft.nutmegItem.itemID);
			PamHarvestCraft.pamOlive = new IguanaFruit(HarvestConfigurationHandler.pamoliveID, "olive").setTreeDrop(PamHarvestCraft.oliveItem.itemID);
			PamHarvestCraft.pamOrange = new IguanaFruit(HarvestConfigurationHandler.pamorangeID, "orange").setTreeDrop(PamHarvestCraft.orangeItem.itemID);
			PamHarvestCraft.pamPapaya = new IguanaFruit(HarvestConfigurationHandler.pampapayaID, "papaya").setTreeDrop(PamHarvestCraft.papayaItem.itemID);
			PamHarvestCraft.pamPeach = new IguanaFruit(HarvestConfigurationHandler.pampeachID, "peach").setTreeDrop(PamHarvestCraft.peachItem.itemID);
			PamHarvestCraft.pamPear = new IguanaFruit(HarvestConfigurationHandler.pampearID, "pear").setTreeDrop(PamHarvestCraft.pearItem.itemID);
			PamHarvestCraft.pamPeppercorn = new IguanaFruit(HarvestConfigurationHandler.pampeppercornID, "peppercorn").setTreeDrop(PamHarvestCraft.peppercornItem.itemID);
			PamHarvestCraft.pamPlum = new IguanaFruit(HarvestConfigurationHandler.pamplumID, "plum").setTreeDrop(PamHarvestCraft.plumItem.itemID);
			PamHarvestCraft.pamPomegranate = new IguanaFruit(HarvestConfigurationHandler.pampomegranateID, "pomegranate").setTreeDrop(PamHarvestCraft.pomegranateItem.itemID);
			PamHarvestCraft.pamStarfruit = new IguanaFruit(HarvestConfigurationHandler.pamstarfruitID, "starfruit").setTreeDrop(PamHarvestCraft.starfruitItem.itemID);
			PamHarvestCraft.pamVanillabean = new IguanaFruit(HarvestConfigurationHandler.pamvanillabeanID, "vanillabean").setTreeDrop(PamHarvestCraft.vanillabeanItem.itemID);
			PamHarvestCraft.pamWalnut = new IguanaFruit(HarvestConfigurationHandler.pamwalnutID, "walnut").setTreeDrop(PamHarvestCraft.walnutItem.itemID);

		}
	}
	
}
