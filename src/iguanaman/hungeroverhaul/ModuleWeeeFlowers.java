package iguanaman.hungeroverhaul;

public class ModuleWeeeFlowers {

	public static void init()
	{

		/*
		if(Loader.isModLoaded("PamWeeeFlowers") == true)
        {

			Item.itemsList[PamWeeeFlowers.whiteflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.orangeflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.magentaflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.lightblueflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.yellowflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.limeflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.pinkflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.lightgreyflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.darkgreyflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.cyanflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.purpleflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.blueflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.brownflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.greenflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.redflowerseedItem.itemID] = null;
	        Item.itemsList[PamWeeeFlowers.blackflowerseedItem.itemID] = null;
			PamWeeeFlowers.whiteflowerseedItem = new IguanaSeed(PamWeeeFlowers.whiteseedID, PamWeeeFlowers.pamwhiteflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:whiteflowerseedItem");
	        PamWeeeFlowers.orangeflowerseedItem = new IguanaSeed(PamWeeeFlowers.orangeseedID, PamWeeeFlowers.pamorangeflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:orangeflowerseedItem");
	        PamWeeeFlowers.magentaflowerseedItem = new IguanaSeed(PamWeeeFlowers.magentaseedID, PamWeeeFlowers.pammagentaflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:magentaflowerseedItem");
	        PamWeeeFlowers.lightblueflowerseedItem = new IguanaSeed(PamWeeeFlowers.lightblueseedID, PamWeeeFlowers.pamlightblueflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:lightblueflowerseedItem");
	        PamWeeeFlowers.yellowflowerseedItem = new IguanaSeed(PamWeeeFlowers.yellowseedID, PamWeeeFlowers.pamyellowflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:yellowflowerseedItem");
	        PamWeeeFlowers.limeflowerseedItem = new IguanaSeed(PamWeeeFlowers.limeseedID, PamWeeeFlowers.pamlimeflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:limeflowerseedItem");
	        PamWeeeFlowers.pinkflowerseedItem = new IguanaSeed(PamWeeeFlowers.pinkseedID, PamWeeeFlowers.pampinkflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:pinkflowerseedItem");
	        PamWeeeFlowers.lightgreyflowerseedItem = new IguanaSeed(PamWeeeFlowers.lightgreyseedID, PamWeeeFlowers.pamlightgreyflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:lightgreyflowerseedItem");
	        PamWeeeFlowers.darkgreyflowerseedItem = new IguanaSeed(PamWeeeFlowers.darkgreyseedID, PamWeeeFlowers.pamdarkgreyflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:darkgreyflowerseedItem");
	        PamWeeeFlowers.cyanflowerseedItem = new IguanaSeed(PamWeeeFlowers.cyanseedID, PamWeeeFlowers.pamcyanflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:cyanflowerseedItem");
	        PamWeeeFlowers.purpleflowerseedItem = new IguanaSeed(PamWeeeFlowers.purpleseedID, PamWeeeFlowers.pampurpleflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:purpleflowerseedItem");
	        PamWeeeFlowers.blueflowerseedItem = new IguanaSeed(PamWeeeFlowers.blueseedID, PamWeeeFlowers.pamblueflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:blueflowerseedItem");
	        PamWeeeFlowers.brownflowerseedItem = new IguanaSeed(PamWeeeFlowers.brownseedID, PamWeeeFlowers.pambrownflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:brownflowerseedItem");
	        PamWeeeFlowers.greenflowerseedItem = new IguanaSeed(PamWeeeFlowers.greenseedID, PamWeeeFlowers.pamgreenflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:greenflowerseedItem");
	        PamWeeeFlowers.redflowerseedItem = new IguanaSeed(PamWeeeFlowers.redseedID, PamWeeeFlowers.pamredflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:redflowerseedItem");
	        PamWeeeFlowers.blackflowerseedItem = new IguanaSeed(PamWeeeFlowers.blackseedID, PamWeeeFlowers.pamblackflowerCrop.blockID, Block.tilledField.blockID).setUnlocalizedName("PamWeeeFlowers:blackflowerseedItem");

			ModLoader.registerBlock(PamWeeeFlowers.pamwhiteflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamorangeflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pammagentaflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamlightblueflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamyellowflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamlimeflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pampinkflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamlightgreyflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamdarkgreyflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamcyanflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pampurpleflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamblueflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pambrownflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamgreenflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamredflowerCrop);
	    	ModLoader.registerBlock(PamWeeeFlowers.pamblackflowerCrop);
	    	
			Block.blocksList[PamWeeeFlowers.pamwhiteflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamorangeflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pammagentaflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamlightblueflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamyellowflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamlimeflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pampinkflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamlightgreyflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamdarkgreyflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamcyanflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pampurpleflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamblueflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pambrownflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamgreenflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamredflowerCrop.blockID] = null;
			Block.blocksList[PamWeeeFlowers.pamblackflowerCrop.blockID] = null;
			PamWeeeFlowers.pamwhiteflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamwhiteflowerCrop.blockID, "white").setSeedItem(PamWeeeFlowers.whiteflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 0, false).setUnlocalizedName("PamWeeeFlowers:whiteflowerCrop");
	    	PamWeeeFlowers.pamorangeflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamorangeflowerCrop.blockID, "orange").setSeedItem(PamWeeeFlowers.orangeflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 1, false).setUnlocalizedName("PamWeeeFlowers:orangeflowerCrop");
	    	PamWeeeFlowers.pammagentaflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pammagentaflowerCrop.blockID, "magenta").setSeedItem(PamWeeeFlowers.magentaflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 2, false).setUnlocalizedName("PamWeeeFlowers:magentaflowerCrop");
	    	PamWeeeFlowers.pamlightblueflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamlightblueflowerCrop.blockID, "lightblue").setSeedItem(PamWeeeFlowers.lightblueflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 3, false).setUnlocalizedName("PamWeeeFlowers:lightblueflowerCrop");
	    	PamWeeeFlowers.pamyellowflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamyellowflowerCrop.blockID, "yellow").setSeedItem(PamWeeeFlowers.yellowflowerseedItem.itemID).setCropItem(Block.plantYellow.blockID, false).setUnlocalizedName("PamWeeeFlowers:yellowflowerCrop");
	    	PamWeeeFlowers.pamlimeflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamlimeflowerCrop.blockID, "lime").setSeedItem(PamWeeeFlowers.limeflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 4, false).setUnlocalizedName("PamWeeeFlowers:limeflowerCrop");
	    	PamWeeeFlowers.pampinkflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pampinkflowerCrop.blockID, "pink").setSeedItem(PamWeeeFlowers.pinkflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 5, false).setUnlocalizedName("PamWeeeFlowers:pinkflowerCrop");
	    	PamWeeeFlowers.pamlightgreyflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamlightgreyflowerCrop.blockID, "lightgrey").setSeedItem(PamWeeeFlowers.lightgreyflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 7, false).setUnlocalizedName("PamWeeeFlowers:lightgreyflowerCrop");
	    	PamWeeeFlowers.pamdarkgreyflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamdarkgreyflowerCrop.blockID, "darkgrey").setSeedItem(PamWeeeFlowers.darkgreyflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 6, false).setUnlocalizedName("PamWeeeFlowers:darkgreyflowerCrop");
	    	PamWeeeFlowers.pamcyanflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamcyanflowerCrop.blockID, "cyan").setSeedItem(PamWeeeFlowers.cyanflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 8, false).setUnlocalizedName("PamWeeeFlowers:cyanflowerCrop");
	    	PamWeeeFlowers.pampurpleflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pampurpleflowerCrop.blockID, "purple").setSeedItem(PamWeeeFlowers.purpleflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 9, false).setUnlocalizedName("PamWeeeFlowers:purpleflowerCrop");
	    	PamWeeeFlowers.pamblueflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamblueflowerCrop.blockID, "blue").setSeedItem(PamWeeeFlowers.blueflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 10, false).setUnlocalizedName("PamWeeeFlowers:blueflowerCrop");
	    	PamWeeeFlowers.pambrownflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pambrownflowerCrop.blockID, "brown").setSeedItem(PamWeeeFlowers.brownflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 11, false).setUnlocalizedName("PamWeeeFlowers:brownflowerCrop");
	    	PamWeeeFlowers.pamgreenflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamgreenflowerCrop.blockID, "green").setSeedItem(PamWeeeFlowers.greenflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 12, false).setUnlocalizedName("PamWeeeFlowers:greenflowerCrop");
	    	PamWeeeFlowers.pamredflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamredflowerCrop.blockID, "red").setSeedItem(PamWeeeFlowers.redflowerseedItem.itemID).setCropItem(Block.plantRed.blockID, false).setUnlocalizedName("PamWeeeFlowers:redflowerCrop");
	    	PamWeeeFlowers.pamblackflowerCrop = new IguanaCropPamFlower(PamWeeeFlowers.pamblackflowerCrop.blockID, "black").setSeedItem(PamWeeeFlowers.blackflowerseedItem.itemID).setCropItem(PamWeeeFlowers.pamFlower.blockID, 13, false).setUnlocalizedName("PamWeeeFlowers:blackflowerCrop");
        }
        */
	}
	
}
