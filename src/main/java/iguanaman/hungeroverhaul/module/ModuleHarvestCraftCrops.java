package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropPam;
import iguanaman.hungeroverhaul.items.IguanaFoodPam;
import iguanaman.hungeroverhaul.items.IguanaFoodPamPotion;
import iguanaman.hungeroverhaul.items.IguanaSeedPam;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

public class ModuleHarvestCraftCrops {

	public static void init()
	{

		// CROP BLOCK
		Block.blocksList[PamHarvestCraft.pamCrop.blockID] = null;
		PamHarvestCraft.pamCrop = new IguanaCropPam(HarvestConfigurationHandler.pamcropID).setUnlocalizedName("Crop");

		// SETUP VALUES
		float foodSaturation = 0.1F;
		if (IguanaConfig.modifyFoodValues) {
			HarvestConfigurationHandler.bushfoodrestore = 1;
			HarvestConfigurationHandler.cropfoodrestore = 1;
		}

		// ITEM CHANGES
		Item.itemsList[PamHarvestCraft.asparagusItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.asparagusseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.barleyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.barleyseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beanItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beanseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beetItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beetseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.broccoliItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.broccoliseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cauliflowerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cauliflowerseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.celeryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.celeryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.garlicItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.garlicseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingerseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.leekItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.leekseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lettuceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lettuceseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.oatsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.oatsseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.onionItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.onionseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.parsnipItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.parsnipseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peanutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peanutseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pineappleItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pineappleseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.radishItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.radishseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.riceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.riceseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rutabagaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rutabagaseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.ryeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.ryeseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.scallionItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.scallionseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.soybeanItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.soybeanseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spiceleafItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spiceleafseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sunflowerseedsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sunflowerseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sweetpotatoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sweetpotatoseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tealeafItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.teaseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.turnipItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.turnipseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.whitemushroomItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.whitemushroomseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.artichokeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.artichokeseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bellpepperItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bellpepperseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.brusselsproutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.brusselsproutseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cabbageItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cabbageseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cactusfruitItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cactusfruitseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candleberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candleberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cantaloupeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cantaloupeseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chilipepperItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chilipepperseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coffeebeanItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coffeeseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cornItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cornseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cottonseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cucumberItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cucumberseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.eggplantItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.eggplantseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapeseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwiItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwiseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mustardseedsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mustardseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.okraItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.okraseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peasItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peasseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rhubarbItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rhubarbseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.seaweedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.seaweedseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tomatoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tomatoseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.wintersquashItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.wintersquashseedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zucchiniItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zucchiniseedItem.itemID] = null;
		PamHarvestCraft.asparagusItem = new ItemPamSeedFood(HarvestConfigurationHandler.asparagusID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 0).setUnlocalizedName("PamHarvestCraft:asparagusItem");
		PamHarvestCraft.asparagusseedItem = new IguanaSeedPam(HarvestConfigurationHandler.asparagusseedID, 0).setUnlocalizedName("PamHarvestCraft:asparagusseedItem");
		PamHarvestCraft.barleyItem = new ItemPamSeedFood(HarvestConfigurationHandler.barleyID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 1).setUnlocalizedName("PamHarvestCraft:barleyItem");
		PamHarvestCraft.barleyseedItem = new IguanaSeedPam(HarvestConfigurationHandler.barleyseedID, 1).setUnlocalizedName("PamHarvestCraft:barleyseedItem");
		PamHarvestCraft.beanItem = new ItemPamSeedFood(HarvestConfigurationHandler.beanID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 2).setUnlocalizedName("PamHarvestCraft:beanItem");
		PamHarvestCraft.beanseedItem = new IguanaSeedPam(HarvestConfigurationHandler.beanseedID, 2).setUnlocalizedName("PamHarvestCraft:beanseedItem");
		PamHarvestCraft.beetItem = new ItemPamSeedFood(HarvestConfigurationHandler.beetID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 3).setUnlocalizedName("PamHarvestCraft:beetItem");
		PamHarvestCraft.beetseedItem = new IguanaSeedPam(HarvestConfigurationHandler.beetseedID, 3).setUnlocalizedName("PamHarvestCraft:beetseedItem");
		PamHarvestCraft.broccoliItem = new ItemPamSeedFood(HarvestConfigurationHandler.broccoliID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 4).setUnlocalizedName("PamHarvestCraft:broccoliItem");
		PamHarvestCraft.broccoliseedItem = new IguanaSeedPam(HarvestConfigurationHandler.broccoliseedID, 4).setUnlocalizedName("PamHarvestCraft:broccoliseedItem");
		PamHarvestCraft.cauliflowerItem = new ItemPamSeedFood(HarvestConfigurationHandler.cauliflowerID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 5).setUnlocalizedName("PamHarvestCraft:cauliflowerItem");
		PamHarvestCraft.cauliflowerseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cauliflowerseedID, 5).setUnlocalizedName("PamHarvestCraft:cauliflowerseedItem");
		PamHarvestCraft.celeryItem = new ItemPamSeedFood(HarvestConfigurationHandler.celeryID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 6).setUnlocalizedName("PamHarvestCraft:celeryItem");
		PamHarvestCraft.celeryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.celeryseedID, 6).setUnlocalizedName("PamHarvestCraft:celeryseedItem");
		PamHarvestCraft.cranberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.cranberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 7).setUnlocalizedName("PamHarvestCraft:cranberryItem");
		PamHarvestCraft.cranberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cranberryseedID, 7).setUnlocalizedName("PamHarvestCraft:cranberryseedItem");
		PamHarvestCraft.garlicItem = new ItemPamSeedFood(HarvestConfigurationHandler.garlicID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 8).setUnlocalizedName("PamHarvestCraft:garlicItem");
		PamHarvestCraft.garlicseedItem = new IguanaSeedPam(HarvestConfigurationHandler.garlicseedID, 8).setUnlocalizedName("PamHarvestCraft:garlicseedItem");
		PamHarvestCraft.gingerItem = new ItemPamSeedFood(HarvestConfigurationHandler.gingerID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 9).setUnlocalizedName("PamHarvestCraft:gingerItem");
		PamHarvestCraft.gingerseedItem = new IguanaSeedPam(HarvestConfigurationHandler.gingerseedID, 9).setUnlocalizedName("PamHarvestCraft:gingerseedItem");
		PamHarvestCraft.leekItem = new ItemPamSeedFood(HarvestConfigurationHandler.leekID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 10).setUnlocalizedName("PamHarvestCraft:leekItem");
		PamHarvestCraft.leekseedItem = new IguanaSeedPam(HarvestConfigurationHandler.leekseedID, 10).setUnlocalizedName("PamHarvestCraft:leekseedItem");
		PamHarvestCraft.lettuceItem = new ItemPamSeedFood(HarvestConfigurationHandler.lettuceID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 11).setUnlocalizedName("PamHarvestCraft:lettuceItem");
		PamHarvestCraft.lettuceseedItem = new IguanaSeedPam(HarvestConfigurationHandler.lettuceseedID, 11).setUnlocalizedName("PamHarvestCraft:lettuceseedItem");
		PamHarvestCraft.oatsItem = new ItemPamSeedFood(HarvestConfigurationHandler.oatsID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 12).setUnlocalizedName("PamHarvestCraft:oatsItem");
		PamHarvestCraft.oatsseedItem = new IguanaSeedPam(HarvestConfigurationHandler.oatsseedID, 12).setUnlocalizedName("PamHarvestCraft:oatsseedItem");
		PamHarvestCraft.onionItem = new ItemPamSeedFood(HarvestConfigurationHandler.onionID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 13).setUnlocalizedName("PamHarvestCraft:onionItem");
		PamHarvestCraft.onionseedItem = new IguanaSeedPam(HarvestConfigurationHandler.onionseedID, 13).setUnlocalizedName("PamHarvestCraft:onionseedItem");
		PamHarvestCraft.parsnipItem = new ItemPamSeedFood(HarvestConfigurationHandler.parsnipID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 14).setUnlocalizedName("PamHarvestCraft:parsnipItem");
		PamHarvestCraft.parsnipseedItem = new IguanaSeedPam(HarvestConfigurationHandler.parsnipseedID, 14).setUnlocalizedName("PamHarvestCraft:parsnipseedItem");
		PamHarvestCraft.peanutItem = new ItemPamSeedFood(HarvestConfigurationHandler.peanutID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 15).setUnlocalizedName("PamHarvestCraft:peanutItem");
		PamHarvestCraft.peanutseedItem = new IguanaSeedPam(HarvestConfigurationHandler.peanutseedID, 15).setUnlocalizedName("PamHarvestCraft:peanutseedItem");
		PamHarvestCraft.pineappleItem = new ItemPamSeedFood(HarvestConfigurationHandler.pineappleID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 16).setUnlocalizedName("PamHarvestCraft:pineappleItem");
		PamHarvestCraft.pineappleseedItem = new IguanaSeedPam(HarvestConfigurationHandler.pineappleseedID, 16).setUnlocalizedName("PamHarvestCraft:pineappleseedItem");
		PamHarvestCraft.radishItem = new ItemPamSeedFood(HarvestConfigurationHandler.radishID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 17).setUnlocalizedName("PamHarvestCraft:radishItem");
		PamHarvestCraft.radishseedItem = new IguanaSeedPam(HarvestConfigurationHandler.radishseedID, 17).setUnlocalizedName("PamHarvestCraft:radishseedItem");
		PamHarvestCraft.riceItem = new ItemPamSeedFood(HarvestConfigurationHandler.riceID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 18).setUnlocalizedName("PamHarvestCraft:riceItem");
		PamHarvestCraft.riceseedItem = new IguanaSeedPam(HarvestConfigurationHandler.riceseedID, 18).setUnlocalizedName("PamHarvestCraft:riceseedItem");
		PamHarvestCraft.rutabagaItem = new ItemPamSeedFood(HarvestConfigurationHandler.rutabagaID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 19).setUnlocalizedName("PamHarvestCraft:rutabagaItem");
		PamHarvestCraft.rutabagaseedItem = new IguanaSeedPam(HarvestConfigurationHandler.rutabagaseedID, 19).setUnlocalizedName("PamHarvestCraft:rutabagaseedItem");
		PamHarvestCraft.ryeItem = new ItemPamSeedFood(HarvestConfigurationHandler.ryeID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 20).setUnlocalizedName("PamHarvestCraft:ryeItem");
		PamHarvestCraft.ryeseedItem = new IguanaSeedPam(HarvestConfigurationHandler.ryeseedID, 20).setUnlocalizedName("PamHarvestCraft:ryeseedItem");
		PamHarvestCraft.scallionItem = new ItemPamSeedFood(HarvestConfigurationHandler.scallionID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 21).setUnlocalizedName("PamHarvestCraft:scallionItem");
		PamHarvestCraft.scallionseedItem = new IguanaSeedPam(HarvestConfigurationHandler.scallionseedID, 21).setUnlocalizedName("PamHarvestCraft:scallionseedItem");
		PamHarvestCraft.soybeanItem = new ItemPamSeedFood(HarvestConfigurationHandler.soybeanID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 22).setUnlocalizedName("PamHarvestCraft:soybeanItem");
		PamHarvestCraft.soybeanseedItem = new IguanaSeedPam(HarvestConfigurationHandler.soybeanseedID, 22).setUnlocalizedName("PamHarvestCraft:soybeanseedItem");
		PamHarvestCraft.spiceleafItem = new ItemPamSeedFood(HarvestConfigurationHandler.spiceleafID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 23).setUnlocalizedName("PamHarvestCraft:spiceleafItem");
		PamHarvestCraft.spiceleafseedItem = new IguanaSeedPam(HarvestConfigurationHandler.spiceleafseedID, 23).setUnlocalizedName("PamHarvestCraft:spiceleafseedItem");
		PamHarvestCraft.sunflowerseedsItem = new ItemPamSeedFood(HarvestConfigurationHandler.sunflowerseedsID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 24).setUnlocalizedName("PamHarvestCraft:sunflowerseedsItem");
		PamHarvestCraft.sunflowerseedItem = new IguanaSeedPam(HarvestConfigurationHandler.sunflowerseedID, 24).setUnlocalizedName("PamHarvestCraft:sunflowerseedItem");
		PamHarvestCraft.sweetpotatoItem = new ItemPamSeedFood(HarvestConfigurationHandler.sweetpotatoID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 25).setUnlocalizedName("PamHarvestCraft:sweetpotatoItem");
		PamHarvestCraft.sweetpotatoseedItem = new IguanaSeedPam(HarvestConfigurationHandler.sweetpotatoseedID, 25).setUnlocalizedName("PamHarvestCraft:sweetpotatoseedItem");
		PamHarvestCraft.tealeafItem = new ItemPamSeedFood(HarvestConfigurationHandler.tealeafID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 26).setUnlocalizedName("PamHarvestCraft:tealeafItem");
		PamHarvestCraft.teaseedItem = new IguanaSeedPam(HarvestConfigurationHandler.teaseedID, 26).setUnlocalizedName("PamHarvestCraft:teaseedItem");
		PamHarvestCraft.turnipItem = new ItemPamSeedFood(HarvestConfigurationHandler.turnipID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 27).setUnlocalizedName("PamHarvestCraft:turnipItem");
		PamHarvestCraft.turnipseedItem = new IguanaSeedPam(HarvestConfigurationHandler.turnipseedID, 27).setUnlocalizedName("PamHarvestCraft:turnipseedItem");
		PamHarvestCraft.whitemushroomItem = new ItemPamSeedFood(HarvestConfigurationHandler.whitemushroomID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 28).setUnlocalizedName("PamHarvestCraft:whitemushroomItem");
		PamHarvestCraft.whitemushroomseedItem = new IguanaSeedPam(HarvestConfigurationHandler.whitemushroomseedID, 28).setUnlocalizedName("PamHarvestCraft:whitemushroomseedItem");

		PamHarvestCraft.artichokeItem = new ItemPamSeedFood(HarvestConfigurationHandler.artichokeID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 29).setUnlocalizedName("PamHarvestCraft:artichokeItem");
		PamHarvestCraft.artichokeseedItem = new IguanaSeedPam(HarvestConfigurationHandler.artichokeseedID, 29).setUnlocalizedName("PamHarvestCraft:artichokeseedItem");
		PamHarvestCraft.bellpepperItem = new ItemPamSeedFood(HarvestConfigurationHandler.bellpepperID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 30).setUnlocalizedName("PamHarvestCraft:bellpepperItem");
		PamHarvestCraft.bellpepperseedItem = new IguanaSeedPam(HarvestConfigurationHandler.bellpepperseedID, 30).setUnlocalizedName("PamHarvestCraft:bellpepperseedItem");
		PamHarvestCraft.blackberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.blackberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 31).setUnlocalizedName("PamHarvestCraft:blackberryItem");
		PamHarvestCraft.blackberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.blackberryseedID, 31).setUnlocalizedName("PamHarvestCraft:blackberryseedItem");
		PamHarvestCraft.blueberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.blueberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 32).setUnlocalizedName("PamHarvestCraft:blueberryItem");
		PamHarvestCraft.blueberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.blueberryseedID, 32).setUnlocalizedName("PamHarvestCraft:blueberryseedItem");
		PamHarvestCraft.brusselsproutItem = new ItemPamSeedFood(HarvestConfigurationHandler.brusselsproutID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 33).setUnlocalizedName("PamHarvestCraft:brusselsproutItem");
		PamHarvestCraft.brusselsproutseedItem = new IguanaSeedPam(HarvestConfigurationHandler.brusselsproutseedID, 33).setUnlocalizedName("PamHarvestCraft:brusselsproutseedItem");
		PamHarvestCraft.cabbageItem = new ItemPamSeedFood(HarvestConfigurationHandler.cabbageID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 34).setUnlocalizedName("PamHarvestCraft:cabbageItem");
		PamHarvestCraft.cabbageseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cabbageseedID, 34).setUnlocalizedName("PamHarvestCraft:cabbageseedItem");
		PamHarvestCraft.cactusfruitItem = new ItemPamSeedFood(HarvestConfigurationHandler.cactusfruitID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 35).setUnlocalizedName("PamHarvestCraft:cactusfruitItem");
		PamHarvestCraft.cactusfruitseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cactusfruitseedID, 35).setUnlocalizedName("PamHarvestCraft:cactusfruitseedItem");
		PamHarvestCraft.candleberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.candleberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 36).setUnlocalizedName("PamHarvestCraft:candleberryItem");
		PamHarvestCraft.candleberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.candleberryseedID, 36).setUnlocalizedName("PamHarvestCraft:candleberryseedItem");
		PamHarvestCraft.cantaloupeItem = new ItemPamSeedFood(HarvestConfigurationHandler.cantaloupeID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 37).setUnlocalizedName("PamHarvestCraft:cantaloupeItem");
		PamHarvestCraft.cantaloupeseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cantaloupeseedID, 37).setUnlocalizedName("PamHarvestCraft:cantaloupeseedItem");
		PamHarvestCraft.chilipepperItem = new ItemPamSeedFood(HarvestConfigurationHandler.chilipepperID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 38).setUnlocalizedName("PamHarvestCraft:chilipepperItem");
		PamHarvestCraft.chilipepperseedItem = new IguanaSeedPam(HarvestConfigurationHandler.chilipepperseedID, 38).setUnlocalizedName("PamHarvestCraft:chilipepperseedItem");
		PamHarvestCraft.coffeebeanItem = new ItemPamSeedFood(HarvestConfigurationHandler.coffeebeanID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 39).setUnlocalizedName("PamHarvestCraft:coffeebeanItem");
		PamHarvestCraft.coffeeseedItem = new IguanaSeedPam(HarvestConfigurationHandler.coffeeseedID, 39).setUnlocalizedName("PamHarvestCraft:coffeeseedItem");
		PamHarvestCraft.cornItem = new ItemPamSeedFood(HarvestConfigurationHandler.cornID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 40).setUnlocalizedName("PamHarvestCraft:cornItem");
		PamHarvestCraft.cornseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cornseedID, 40).setUnlocalizedName("PamHarvestCraft:cornseedItem");
		PamHarvestCraft.cottonseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cottonseedID, 41).setUnlocalizedName("PamHarvestCraft:cottonseedItem");
		PamHarvestCraft.cucumberItem = new ItemPamSeedFood(HarvestConfigurationHandler.cucumberID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 42).setUnlocalizedName("PamHarvestCraft:cucumberItem");
		PamHarvestCraft.cucumberseedItem = new IguanaSeedPam(HarvestConfigurationHandler.cucumberseedID, 42).setUnlocalizedName("PamHarvestCraft:cucumberseedItem");
		PamHarvestCraft.eggplantItem = new ItemPamSeedFood(HarvestConfigurationHandler.eggplantID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 43).setUnlocalizedName("PamHarvestCraft:eggplantItem");
		PamHarvestCraft.eggplantseedItem = new IguanaSeedPam(HarvestConfigurationHandler.eggplantseedID, 43).setUnlocalizedName("PamHarvestCraft:eggplantseedItem");
		PamHarvestCraft.grapeItem = new ItemPamSeedFood(HarvestConfigurationHandler.grapeID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 44).setUnlocalizedName("PamHarvestCraft:grapeItem");
		PamHarvestCraft.grapeseedItem = new IguanaSeedPam(HarvestConfigurationHandler.grapeseedID, 44).setUnlocalizedName("PamHarvestCraft:grapeseedItem");
		PamHarvestCraft.kiwiItem = new ItemPamSeedFood(HarvestConfigurationHandler.kiwiID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 45).setUnlocalizedName("PamHarvestCraft:kiwiItem");
		PamHarvestCraft.kiwiseedItem = new IguanaSeedPam(HarvestConfigurationHandler.kiwiseedID, 45).setUnlocalizedName("PamHarvestCraft:kiwiseedItem");
		PamHarvestCraft.mustardseedsItem = new ItemPamSeedFood(HarvestConfigurationHandler.mustardseedsID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 46).setUnlocalizedName("PamHarvestCraft:mustardseedsItem");
		PamHarvestCraft.mustardseedItem = new IguanaSeedPam(HarvestConfigurationHandler.mustardseedID, 46).setUnlocalizedName("PamHarvestCraft:mustardseedItem");
		PamHarvestCraft.okraItem = new ItemPamSeedFood(HarvestConfigurationHandler.okraID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 47).setUnlocalizedName("PamHarvestCraft:okraItem");
		PamHarvestCraft.okraseedItem = new IguanaSeedPam(HarvestConfigurationHandler.okraseedID, 47).setUnlocalizedName("PamHarvestCraft:okraseedItem");
		PamHarvestCraft.peasItem = new ItemPamSeedFood(HarvestConfigurationHandler.peasID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 48).setUnlocalizedName("PamHarvestCraft:peasItem");
		PamHarvestCraft.peasseedItem = new IguanaSeedPam(HarvestConfigurationHandler.peasseedID, 48).setUnlocalizedName("PamHarvestCraft:peasseedItem");
		PamHarvestCraft.raspberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.raspberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 49).setUnlocalizedName("PamHarvestCraft:raspberryItem");
		PamHarvestCraft.raspberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.raspberryseedID, 49).setUnlocalizedName("PamHarvestCraft:raspberryseedItem");
		PamHarvestCraft.rhubarbItem = new ItemPamSeedFood(HarvestConfigurationHandler.rhubarbID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 50).setUnlocalizedName("PamHarvestCraft:rhubarbItem");
		PamHarvestCraft.rhubarbseedItem = new IguanaSeedPam(HarvestConfigurationHandler.rhubarbseedID, 50).setUnlocalizedName("PamHarvestCraft:rhubarbseedItem");
		PamHarvestCraft.seaweedItem = new ItemPamSeedFood(HarvestConfigurationHandler.seaweedID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 51).setUnlocalizedName("PamHarvestCraft:seaweedItem");
		PamHarvestCraft.seaweedseedItem = new IguanaSeedPam(HarvestConfigurationHandler.seaweedseedID, 51).setUnlocalizedName("PamHarvestCraft:seaweedseedItem");
		PamHarvestCraft.strawberryItem = new ItemPamSeedFood(HarvestConfigurationHandler.strawberryID, HarvestConfigurationHandler.bushfoodrestore, foodSaturation, 52).setUnlocalizedName("PamHarvestCraft:strawberryItem");
		PamHarvestCraft.strawberryseedItem = new IguanaSeedPam(HarvestConfigurationHandler.strawberryseedID, 52).setUnlocalizedName("PamHarvestCraft:strawberryseedItem");
		PamHarvestCraft.tomatoItem = new ItemPamSeedFood(HarvestConfigurationHandler.tomatoID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 53).setUnlocalizedName("PamHarvestCraft:tomatoItem");
		PamHarvestCraft.tomatoseedItem = new IguanaSeedPam(HarvestConfigurationHandler.tomatoseedID, 53).setUnlocalizedName("PamHarvestCraft:tomatoseedItem");
		PamHarvestCraft.wintersquashItem = new ItemPamSeedFood(HarvestConfigurationHandler.wintersquashID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 54).setUnlocalizedName("PamHarvestCraft:wintersquashItem");
		PamHarvestCraft.wintersquashseedItem = new IguanaSeedPam(HarvestConfigurationHandler.wintersquashseedID, 54).setUnlocalizedName("PamHarvestCraft:wintersquashseedItem");
		PamHarvestCraft.zucchiniItem = new ItemPamSeedFood(HarvestConfigurationHandler.zucchiniID, HarvestConfigurationHandler.cropfoodrestore, foodSaturation, 55).setUnlocalizedName("PamHarvestCraft:zucchiniItem");
		PamHarvestCraft.zucchiniseedItem = new IguanaSeedPam(HarvestConfigurationHandler.zucchiniseedID, 55).setUnlocalizedName("PamHarvestCraft:zucchiniseedItem");

		// HavestCraft Base
		Item.itemsList[PamHarvestCraft.toastItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cheeseItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.icecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grilledcheeseItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.applejuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.applesauceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.applepieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.caramelappleItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pumpkinbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.roastedpumpkinseedsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pumpkinsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.melonjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.melonsmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.carrotjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.carrotcakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.carrotsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.glazedcarrotsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.butteredpotatoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.loadedbakedpotatoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mashedpotatoesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.potatosaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.potatosoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.friesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grilledmushroomItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.stuffedmushroomItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickensandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickennoodlesoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickenpotpieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.breadedporkchopItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.hotdogItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bakedhamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.hamburgerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cheeseburgerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.baconcheeseburgerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.potroastItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishsandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishsticksItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishandchipsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.friedeggItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.scrambledeggItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.boiledeggItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.eggsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.caramelItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.taffyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spidereyesoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zombiejerkyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatebarItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.hotchocolateItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolateicecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.vegetablesoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.stockItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fruitsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spagettiItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spagettiandmeatballsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tomatosoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickenparmasanItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pizzaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.springsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.porklettucewrapItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishlettucewrapItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bltItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.leafychickensandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.leafyfishsandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.deluxecheeseburgerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.delightedmealItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.onionsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.potatocakesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.hashItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.braisedonionsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.heartybreakfastItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cornonthecobItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cornbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tortillaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.nachoesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.tacoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishtacoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.creamedcornItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberrysmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberrypieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberrysaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatestrawberryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peanutbutterItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.trailmixItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pbandjItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peanutbuttercookiesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapejuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapejellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapesaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raisincookiesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.picklesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cucumbersaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cucumbersoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.vegetarianlettucewrapItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.marinatedcucumbersItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.ricesoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.friedriceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mushroomrisottoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.curryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rainbowcurryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.refriedbeansItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bakedbeansItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beansandriceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chiliItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beanburritoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.stuffedpepperItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.veggiestirfryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grilledskewersItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.supremepizzaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.omeletItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.hotwingsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chilipoppersItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.extremechiliItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chilichocolateItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonaideItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonbarItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fishdinnerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonsmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonmeringueItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candiedlemonItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonchickenItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberrysmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberrypieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberrymuffinItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pancakesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberrypancakesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherrypieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatecherryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherrysmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cheesecakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherrycheesecakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.stuffedeggplantItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.eggplantparmItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryicedteaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chaiteaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.espressoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coffeeconlecheItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mochaicecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pickledbeetsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beetsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.beetsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bakedbeetsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.broccolimacItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.broccolindipItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.creamedbroccolisoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sweetpotatopieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candiedsweetpotatoesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mashedsweetpotatoesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.steamedpeasItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.splitpeasoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pineappleupsidedowncakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pineapplehamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pineappleyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.turnipsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.roastedrootveggiemedleyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bakedturnipsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingerbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingersnapsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candiedgingerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.softpretzelandmustardItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spicymustardporkItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.spicygreensItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.garlicbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.garlicmashedpotatoesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.garlicchickenItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.summerradishsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.summersquashwithradishItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.celeryandpeanutbutterItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickencelerycasseroleItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peasandceleryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.celerysoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zucchinibreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zucchinifriesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zestyzucchiniItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.zucchinibakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.asparagusquicheItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.asparagussoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.walnutraisinbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.candiedwalnutsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.brownieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.papayajuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.papayasmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.papayayogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.starfruitjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.starfruitsmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.starfruityogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.guacamoleItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.creamofavocadosoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.avocadoburritoItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.poachedpearItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fruitcrumbleItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pearyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.plumyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bananasplitItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.banananutbreadItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bananasmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.bananayogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coconutmilkItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chickencurryItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coconutshrimpItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.coconutyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangejuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangechickenItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangesmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangeyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachcobblerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachsmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.limejuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.keylimepieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.limesmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.limeyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mangojuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mangosmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mangoyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pomegranatejuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pomegranatesmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pomegranateyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.vanillayogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cinnamonrollItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.frenchtoastItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.marshmellowsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.donutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatedonutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.powdereddonutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.jellydonutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.frosteddonutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cactussoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.wafflesItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.seedsoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.softpretzelItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.jellybeansItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.biscuitItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.creamcookieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.jaffaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.friedchickenItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatesprinklecakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.redvelvetcakeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.footlongItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherryyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapeyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolateyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberrycobblerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberrysmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.chocolatemilkItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pumpkinyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberrypieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberrysmoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cinnamonsugardonutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.melonyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwijuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwismoothieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwiyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.plainyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.appleyogurtItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.saltedsunflowerseedsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sunflowerwheatrollsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sunflowerbroccolisaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberryjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberrysauceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberrybarItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peppermintItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cactusfruitjuiceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.baklavaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gummybearsItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.baconmushroomburgerItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.fruitpunchItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.meatystewItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mixedsaladItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pinacoladaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.shepardspieItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.eggnogItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.custardItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.sushiItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gardensoupItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.muttonrawItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.muttoncookedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.calamarirawItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.calamaricookedItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.applejellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.applejellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blackberryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.blueberryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cherryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.cranberryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwijellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.kiwijellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.limejellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.limejellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mangojellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mangojellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangejellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangejellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.papayajellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.papayajellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.peachjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pomegranatejellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.pomegranatejellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raspberryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.starfruitjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.starfruitjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryjellysandwichItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.watermelonjellyItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.watermelonjellysandwichItem.itemID] = null;

		Item.itemsList[PamHarvestCraft.cherrysodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.colasodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingersodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grapesodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.lemonlimesodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.orangesodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.rootbeersodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberrysodaItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.caramelicecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.mintchocolatechipicemcreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.strawberryicecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.vanillaicecreamItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.ediblerootItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.gingerchickenItem.itemID] = null;

		if(IguanaConfig.modifyFoodValues)
		{
			PamHarvestCraft.toastItem = new IguanaFoodPam(HarvestConfigurationHandler.toastID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:toastItem");
			PamHarvestCraft.cheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseID, 1, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cheeseItem");
			PamHarvestCraft.icecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.icecreamID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:icecreamItem");
			PamHarvestCraft.grilledcheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledcheeseID, 7, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:grilledcheeseItem");
			PamHarvestCraft.applejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.applejuiceID, 2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:applejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.applesauceItem = new IguanaFoodPam(HarvestConfigurationHandler.applesauceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:applesauceItem");
			PamHarvestCraft.applepieItem = new IguanaFoodPam(HarvestConfigurationHandler.applepieID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:applepieItem");
			PamHarvestCraft.caramelappleItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelappleID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:caramelappleItem");
			PamHarvestCraft.pumpkinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinbreadID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:pumpkinbreadItem");
			PamHarvestCraft.roastedpumpkinseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedpumpkinseedsID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:roastedpumpkinseedsItem");
			PamHarvestCraft.pumpkinsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinsoupID, 4, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pumpkinsoupItem");
			PamHarvestCraft.melonjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.melonjuiceID, 2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:melonjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.melonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.melonsmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:melonsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.carrotjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotjuiceID, 2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:carrotjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.carrotcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotcakeID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:carrotcakeItem");
			PamHarvestCraft.carrotsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotsoupID, 4, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:carrotsoupItem");
			PamHarvestCraft.glazedcarrotsItem = new IguanaFoodPam(HarvestConfigurationHandler.glazedcarrotsID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:glazedcarrotsItem");
			PamHarvestCraft.butteredpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.butteredpotatoID, 4, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:butteredpotatoItem");
			PamHarvestCraft.loadedbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.loadedbakedpotatoID, 8, 0.6F, false, true).setUnlocalizedName("PamHarvestCraft:loadedbakedpotatoItem");
			PamHarvestCraft.mashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedpotatoesID, 5, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:mashedpotatoesItem");
			PamHarvestCraft.potatosaladItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosaladID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:potatosaladItem");
			PamHarvestCraft.potatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosoupID, 4, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:potatosoupItem");
			PamHarvestCraft.friesItem = new IguanaFoodPam(HarvestConfigurationHandler.friesID, 3, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:friesItem");
			PamHarvestCraft.grilledmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledmushroomID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:grilledmushroomItem");
			PamHarvestCraft.stuffedmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedmushroomID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:stuffedmushroomItem");
			PamHarvestCraft.chickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.chickensandwichID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:chickensandwichItem");
			PamHarvestCraft.chickennoodlesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.chickennoodlesoupID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:chickennoodlesoupItem");
			PamHarvestCraft.chickenpotpieItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenpotpieID, 8, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:chickenpotpieItem");
			PamHarvestCraft.breadedporkchopItem = new IguanaFoodPam(HarvestConfigurationHandler.breadedporkchopID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:breadedporkchopItem");
			PamHarvestCraft.hotdogItem = new IguanaFoodPam(HarvestConfigurationHandler.hotdogID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:hotdogItem");
			PamHarvestCraft.bakedhamItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedhamID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:bakedhamItem");
			PamHarvestCraft.hamburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.hamburgerID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:hamburgerItem");
			PamHarvestCraft.cheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseburgerID, 8, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:cheeseburgerItem");
			PamHarvestCraft.baconcheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconcheeseburgerID, 9, 0.6F, false, true).setUnlocalizedName("PamHarvestCraft:baconcheeseburgerItem");
			PamHarvestCraft.potroastItem = new IguanaFoodPam(HarvestConfigurationHandler.potroastID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:potroastItem");
			PamHarvestCraft.fishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsandwichID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:fishsandwichItem");
			PamHarvestCraft.fishsticksItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsticksID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:fishsticksItem");
			PamHarvestCraft.fishandchipsItem = new IguanaFoodPam(HarvestConfigurationHandler.fishandchipsID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:fishandchipsItem");
			PamHarvestCraft.friedeggItem = new IguanaFoodPam(HarvestConfigurationHandler.friedeggID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:friedeggItem");
			PamHarvestCraft.scrambledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.scrambledeggID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:scrambledeggItem");
			PamHarvestCraft.boiledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.boiledeggID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:boiledeggItem");
			PamHarvestCraft.eggsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.eggsaladID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:eggsaladItem");
			PamHarvestCraft.caramelItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelID, 1, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:caramelItem");
			PamHarvestCraft.taffyItem = new IguanaFoodPam(HarvestConfigurationHandler.taffyID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:taffyItem");
			PamHarvestCraft.spidereyesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.spidereyesoupID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:spidereyesoupItem");
			PamHarvestCraft.zombiejerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.zombiejerkyID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:zombiejerkyItem");
			PamHarvestCraft.chocolatebarItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatebarID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatebarItem");
			PamHarvestCraft.hotchocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.hotchocolateID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:hotchocolateItem");
			PamHarvestCraft.chocolateicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateicecreamID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:chocolateicecreamItem");
			PamHarvestCraft.vegetablesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetablesoupID, 6, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:vegetablesoupItem");
			PamHarvestCraft.stockItem = new IguanaFoodPam(HarvestConfigurationHandler.stockID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:stockItem");
			PamHarvestCraft.fruitsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitsaladID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:fruitsaladItem");
			PamHarvestCraft.spagettiItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:spagettiItem");
			PamHarvestCraft.spagettiandmeatballsItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiandmeatballsID, 10, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:spagettiandmeatballsItem");
			PamHarvestCraft.tomatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatosoupID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:tomatosoupItem");
			PamHarvestCraft.chickenparmasanItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenparmasanID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:chickenparmasanItem");
			PamHarvestCraft.pizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.pizzaID, 8, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:pizzaItem");
			PamHarvestCraft.springsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.springsaladID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:springsaladItem");
			PamHarvestCraft.porklettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.porklettucewrapID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:porklettucewrapItem");
			PamHarvestCraft.fishlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.fishlettucewrapID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:fishlettucewrapItem");
			PamHarvestCraft.bltItem = new IguanaFoodPam(HarvestConfigurationHandler.bltID, 9, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:bltItem");
			PamHarvestCraft.leafychickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafychickensandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:leafychickensandwichItem");
			PamHarvestCraft.leafyfishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafyfishsandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:leafyfishsandwichItem");
			PamHarvestCraft.deluxecheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.deluxecheeseburgerID, 10, 0.6F, false, true).setUnlocalizedName("PamHarvestCraft:deluxecheeseburgerItem");
			PamHarvestCraft.delightedmealItem = new IguanaFoodPam(HarvestConfigurationHandler.delightedmealID, 16, 0.8F, false, true).setUnlocalizedName("PamHarvestCraft:delightedmealItem");
			PamHarvestCraft.onionsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.onionsoupID, 4, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:onionsoupItem");
			PamHarvestCraft.potatocakesItem = new IguanaFoodPam(HarvestConfigurationHandler.potatocakesID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:potatocakesItem");
			PamHarvestCraft.hashItem = new IguanaFoodPam(HarvestConfigurationHandler.hashID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:hashItem");
			PamHarvestCraft.braisedonionsItem = new IguanaFoodPam(HarvestConfigurationHandler.braisedonionsID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:braisedonionsItem");
			PamHarvestCraft.heartybreakfastItem = new IguanaFoodPam(HarvestConfigurationHandler.heartybreakfastID, 15, 0.8F, false, true).setUnlocalizedName("PamHarvestCraft:heartybreakfastItem");
			PamHarvestCraft.cornonthecobItem = new IguanaFoodPam(HarvestConfigurationHandler.cornonthecobID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:cornonthecobItem");
			PamHarvestCraft.cornbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.cornbreadID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:cornbreadItem");
			PamHarvestCraft.tortillaItem = new IguanaFoodPam(HarvestConfigurationHandler.tortillaID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:tortillaItem");
			PamHarvestCraft.nachoesItem = new IguanaFoodPam(HarvestConfigurationHandler.nachoesID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:nachoesItem");
			PamHarvestCraft.tacoItem = new IguanaFoodPam(HarvestConfigurationHandler.tacoID, 8, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:tacoItem");
			PamHarvestCraft.fishtacoItem = new IguanaFoodPam(HarvestConfigurationHandler.fishtacoID, 8, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:fishtacoItem");
			PamHarvestCraft.creamedcornItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedcornID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:creamedcornItem");
			PamHarvestCraft.strawberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:strawberrysmoothieItem");
			PamHarvestCraft.strawberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrypieID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:strawberrypieItem");
			PamHarvestCraft.strawberrysaladItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysaladID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:strawberrysaladItem");
			PamHarvestCraft.strawberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:strawberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.chocolatestrawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatestrawberryID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatestrawberryItem");
			PamHarvestCraft.peanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbutterID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:peanutbutterItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.trailmixItem = new IguanaFoodPam(HarvestConfigurationHandler.trailmixID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:trailmixItem");
			PamHarvestCraft.pbandjItem = new IguanaFoodPam(HarvestConfigurationHandler.pbandjID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:pbandjItem");
			PamHarvestCraft.peanutbuttercookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbuttercookiesID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:peanutbuttercookiesItem");
			PamHarvestCraft.grapejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:grapejuiceItem");
			PamHarvestCraft.grapejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:grapejellyItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.grapesaladItem = new IguanaFoodPam(HarvestConfigurationHandler.grapesaladID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:grapesaladItem");
			PamHarvestCraft.raisincookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.raisincookiesID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:raisincookiesItem");
			PamHarvestCraft.picklesItem = new IguanaFoodPam(HarvestConfigurationHandler.picklesID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:picklesItem");
			PamHarvestCraft.cucumbersaladItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersaladID, 5, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:cucumbersaladItem");
			PamHarvestCraft.cucumbersoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersoupID, 4, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:cucumbersoupItem");
			PamHarvestCraft.vegetarianlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetarianlettucewrapID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:vegetarianlettucewrapItem");
			PamHarvestCraft.marinatedcucumbersItem = new IguanaFoodPam(HarvestConfigurationHandler.marinatedcucumbersID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:marinatedcucumbersItem");
			PamHarvestCraft.ricesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.ricesoupID, 5, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:ricesoupItem");
			PamHarvestCraft.friedriceItem = new IguanaFoodPam(HarvestConfigurationHandler.friedriceID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:friedriceItem");
			PamHarvestCraft.mushroomrisottoItem = new IguanaFoodPam(HarvestConfigurationHandler.mushroomrisottoID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:mushroomrisottoItem");
			PamHarvestCraft.curryItem = new IguanaFoodPam(HarvestConfigurationHandler.curryID, 10, 0.55F, false, true).setUnlocalizedName("PamHarvestCraft:curryItem");
			PamHarvestCraft.rainbowcurryItem = new IguanaFoodPam(HarvestConfigurationHandler.rainbowcurryID, 13, 0.7F, false, true).setUnlocalizedName("PamHarvestCraft:rainbowcurryItem");
			PamHarvestCraft.refriedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.refriedbeansID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:refriedbeansItem");
			PamHarvestCraft.bakedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeansID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:bakedbeansItem");
			PamHarvestCraft.beansandriceItem = new IguanaFoodPam(HarvestConfigurationHandler.beansandriceID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:beansandriceItem");
			PamHarvestCraft.chiliItem = new IguanaFoodPam(HarvestConfigurationHandler.chiliID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:chiliItem");
			PamHarvestCraft.beanburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.beanburritoID, 8, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:beanburritoItem");
			PamHarvestCraft.stuffedpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedpepperID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:stuffedpepperItem");
			PamHarvestCraft.veggiestirfryItem = new IguanaFoodPam(HarvestConfigurationHandler.veggiestirfryID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:veggiestirfryItem");
			PamHarvestCraft.grilledskewersItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledskewersID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:grilledskewersItem");
			PamHarvestCraft.supremepizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.supremepizzaID, 12, 0.7F, false, true).setUnlocalizedName("PamHarvestCraft:supremepizzaItem");
			PamHarvestCraft.omeletItem = new IguanaFoodPam(HarvestConfigurationHandler.omeletID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:omeletItem");
			PamHarvestCraft.hotwingsItem = new IguanaFoodPam(HarvestConfigurationHandler.hotwingsID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:hotwingsItem");
			PamHarvestCraft.chilipoppersItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipoppersID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:chilipoppersItem");
			PamHarvestCraft.extremechiliItem = new IguanaFoodPam(HarvestConfigurationHandler.extremechiliID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:extremechiliItem");
			PamHarvestCraft.chilichocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.chilichocolateID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:chilichocolateItem");
			PamHarvestCraft.lemonaideItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonaideID, 1, 0.0F, false, true).setUnlocalizedName("PamHarvestCraft:lemonaideItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.lemonbarItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonbarID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:lemonbarItem");
			PamHarvestCraft.fishdinnerItem = new IguanaFoodPam(HarvestConfigurationHandler.fishdinnerID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:fishdinnerItem");
			PamHarvestCraft.lemonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonsmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:lemonsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.lemonmeringueItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonmeringueID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:lemonmeringueItem");
			PamHarvestCraft.candiedlemonItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedlemonID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:candiedlemonItem");
			PamHarvestCraft.lemonchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonchickenID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:lemonchickenItem");
			PamHarvestCraft.blueberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrysmoothieID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:blueberrysmoothieItem");
			PamHarvestCraft.blueberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypieID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:blueberrypieItem");
			PamHarvestCraft.blueberrymuffinItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrymuffinID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:blueberrymuffinItem");
			PamHarvestCraft.blueberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:blueberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.pancakesID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:pancakesItem");
			PamHarvestCraft.blueberrypancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypancakesID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:blueberrypancakesItem");
			PamHarvestCraft.cherryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cherryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cherrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrypieID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:cherrypieItem");
			PamHarvestCraft.chocolatecherryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatecherryID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatecherryItem");
			PamHarvestCraft.cherrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrysmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cherrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cheesecakeID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:cheesecakeItem");
			PamHarvestCraft.cherrycheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrycheesecakeID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:cherrycheesecakeItem");
			PamHarvestCraft.stuffedeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedeggplantID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:stuffedeggplantItem");
			PamHarvestCraft.eggplantparmItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantparmID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:eggplantparmItem");
			PamHarvestCraft.raspberryicedteaItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryicedteaID, 1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:raspberryicedteaItem");
			PamHarvestCraft.chaiteaItem = new IguanaFoodPam(HarvestConfigurationHandler.chaiteaID, 0, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:chaiteaItem");
			PamHarvestCraft.espressoItem = new IguanaFoodPam(HarvestConfigurationHandler.espressoID, 1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("PamHarvestCraft:espressoItem");
			PamHarvestCraft.coffeeconlecheItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeconlecheID, 2, 0.05F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeconlecheItem");
			PamHarvestCraft.mochaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mochaicecreamID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:mochaicecreamItem");
			PamHarvestCraft.pickledbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.pickledbeetsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pickledbeetsItem");
			PamHarvestCraft.beetsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsaladID, 4, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:beetsaladItem");
			PamHarvestCraft.beetsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsoupID, 4, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:beetsoupItem");
			PamHarvestCraft.bakedbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeetsID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:bakedbeetsItem");
			PamHarvestCraft.broccolimacItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolimacID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:broccolimacItem");
			PamHarvestCraft.broccolindipItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolindipID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:broccolindipItem");
			PamHarvestCraft.creamedbroccolisoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedbroccolisoupID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:creamedbroccolisoupItem");
			PamHarvestCraft.sweetpotatopieItem = new IguanaFoodPam(HarvestConfigurationHandler.sweetpotatopieID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:sweetpotatopieItem");
			PamHarvestCraft.candiedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedsweetpotatoesID, 3, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:candiedsweetpotatoesItem");
			PamHarvestCraft.mashedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedsweetpotatoesID, 3, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:mashedsweetpotatoesItem");
			PamHarvestCraft.steamedpeasItem = new IguanaFoodPam(HarvestConfigurationHandler.steamedpeasID, 3, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:steamedpeasItem");
			PamHarvestCraft.splitpeasoupItem = new IguanaFoodPam(HarvestConfigurationHandler.splitpeasoupID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:splitpeasoupItem");
			PamHarvestCraft.pineappleupsidedowncakeItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleupsidedowncakeID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:pineappleupsidedowncakeItem");
			PamHarvestCraft.pineapplehamItem = new IguanaFoodPam(HarvestConfigurationHandler.pineapplehamID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:pineapplehamItem");
			PamHarvestCraft.pineappleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:pineappleyogurtItem");
			PamHarvestCraft.turnipsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.turnipsoupID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:turnipsoupItem");
			PamHarvestCraft.roastedrootveggiemedleyItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedrootveggiemedleyID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:roastedrootveggiemedleyItem");
			PamHarvestCraft.bakedturnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedturnipsID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:bakedturnipsItem");
			PamHarvestCraft.gingerbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerbreadID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:gingerbreadItem");
			PamHarvestCraft.gingersnapsItem = new IguanaFoodPam(HarvestConfigurationHandler.gingersnapsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:gingersnapsItem");
			PamHarvestCraft.candiedgingerItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedgingerID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:candiedgingerItem");
			PamHarvestCraft.softpretzelandmustardItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelandmustardID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:softpretzelandmustardItem");
			PamHarvestCraft.spicymustardporkItem = new IguanaFoodPam(HarvestConfigurationHandler.spicymustardporkID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:spicymustardporkItem");
			PamHarvestCraft.spicygreensItem = new IguanaFoodPam(HarvestConfigurationHandler.spicygreensID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:spicygreensItem");
			PamHarvestCraft.garlicbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicbreadID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:garlicbreadItem");
			PamHarvestCraft.garlicmashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicmashedpotatoesID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:garlicmashedpotatoesItem");
			PamHarvestCraft.garlicchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicchickenID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:garlicchickenItem");
			PamHarvestCraft.summerradishsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.summerradishsaladID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:summerradishsaladItem");
			PamHarvestCraft.summersquashwithradishItem = new IguanaFoodPam(HarvestConfigurationHandler.summersquashwithradishID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:summersquashwithradishItem");
			PamHarvestCraft.celeryandpeanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.celeryandpeanutbutterID, 3, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:celeryandpeanutbutterItem");
			PamHarvestCraft.chickencelerycasseroleItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencelerycasseroleID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:chickencelerycasseroleItem");
			PamHarvestCraft.peasandceleryItem = new IguanaFoodPam(HarvestConfigurationHandler.peasandceleryID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:peasandceleryItem");
			PamHarvestCraft.celerysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.celerysoupID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:celerysoupItem");
			PamHarvestCraft.zucchinibreadItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibreadID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:zucchinibreadItem");
			PamHarvestCraft.zucchinifriesItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinifriesID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:zucchinifriesItem");
			PamHarvestCraft.zestyzucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zestyzucchiniID, 9, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:zestyzucchiniItem");
			PamHarvestCraft.zucchinibakeItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibakeID, 9, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:zucchinibakeItem");
			PamHarvestCraft.asparagusquicheItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagusquicheID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:asparagusquicheItem");
			PamHarvestCraft.asparagussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagussoupID, 4, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:asparagussoupItem");
			PamHarvestCraft.walnutraisinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutraisinbreadID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:walnutraisinbreadItem");
			PamHarvestCraft.candiedwalnutsItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedwalnutsID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:candiedwalnutsItem");
			PamHarvestCraft.brownieItem = new IguanaFoodPam(HarvestConfigurationHandler.brownieID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:brownieItem");
			PamHarvestCraft.papayajuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:papayajuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.papayasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.papayasmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:papayasmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.papayayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.papayayogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:papayayogurtItem");
			PamHarvestCraft.starfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:starfruitjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.starfruitsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitsmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:starfruitsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.starfruityogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruityogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:starfruityogurtItem");
			PamHarvestCraft.guacamoleItem = new IguanaFoodPam(HarvestConfigurationHandler.guacamoleID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:guacamoleItem");
			PamHarvestCraft.creamofavocadosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamofavocadosoupID, 6, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:creamofavocadosoupItem");
			PamHarvestCraft.avocadoburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoburritoID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:avocadoburritoItem");
			PamHarvestCraft.poachedpearItem = new IguanaFoodPam(HarvestConfigurationHandler.poachedpearID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:poachedpearItem");
			PamHarvestCraft.fruitcrumbleItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitcrumbleID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:fruitcrumbleItem");
			PamHarvestCraft.pearyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pearyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pearyogurtItem");
			PamHarvestCraft.plumyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plumyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:plumyogurtItem");
			PamHarvestCraft.bananasplitItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasplitID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:bananasplitItem");
			PamHarvestCraft.banananutbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.banananutbreadID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:banananutbreadItem");
			PamHarvestCraft.bananasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:bananasmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.bananayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.bananayogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:bananayogurtItem");
			PamHarvestCraft.coconutmilkItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutmilkID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:coconutmilkItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.chickencurryItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencurryID, 9, 0.5F, false, true).setUnlocalizedName("PamHarvestCraft:chickencurryItem");
			PamHarvestCraft.coconutshrimpItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutshrimpID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:coconutshrimpItem");
			PamHarvestCraft.coconutyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:coconutyogurtItem");
			PamHarvestCraft.orangejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:orangejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.orangechickenItem = new IguanaFoodPam(HarvestConfigurationHandler.orangechickenID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:orangechickenItem");
			PamHarvestCraft.orangesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.orangesmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:orangesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.orangeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:orangeyogurtItem");
			PamHarvestCraft.peachjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:peachjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.peachcobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.peachcobblerID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:peachcobblerItem");
			PamHarvestCraft.peachsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.peachsmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:peachsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.peachyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.peachyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:peachyogurtItem");
			PamHarvestCraft.limejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.limejuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:limejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.keylimepieItem = new IguanaFoodPam(HarvestConfigurationHandler.keylimepieID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:keylimepieItem");
			PamHarvestCraft.limesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.limesmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:limesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.limeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.limeyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:limeyogurtItem");
			PamHarvestCraft.mangojuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:mangojuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.mangosmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.mangosmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:mangosmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.mangoyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:mangoyogurtItem");
			PamHarvestCraft.pomegranatejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pomegranatesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatesmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pomegranatesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pomegranateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateyogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pomegranateyogurtItem");
			PamHarvestCraft.vanillayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillayogurtID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:vanillayogurtItem");
			PamHarvestCraft.cinnamonrollItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonrollID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:cinnamonrollItem");
			PamHarvestCraft.frenchtoastItem = new IguanaFoodPam(HarvestConfigurationHandler.frenchtoastID, 7, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:frenchtoastItem");
			PamHarvestCraft.marshmellowsItem = new IguanaFoodPam(HarvestConfigurationHandler.marshmellowsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:marshmellowsItem");
			PamHarvestCraft.donutItem = new IguanaFoodPam(HarvestConfigurationHandler.donutID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:donutItem");
			PamHarvestCraft.chocolatedonutItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatedonutID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatedonutItem");
			PamHarvestCraft.powdereddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.powdereddonutID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:powdereddonutItem");
			PamHarvestCraft.jellydonutItem = new IguanaFoodPam(HarvestConfigurationHandler.jellydonutID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:jellydonutItem");
			PamHarvestCraft.frosteddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.frosteddonutID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:frosteddonutItem");
			PamHarvestCraft.cactussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cactussoupID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cactussoupItem");
			PamHarvestCraft.wafflesItem = new IguanaFoodPam(HarvestConfigurationHandler.wafflesID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:wafflesItem");
			PamHarvestCraft.seedsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.seedsoupID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:seedsoupItem");
			PamHarvestCraft.softpretzelItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:softpretzelItem");
			PamHarvestCraft.jellybeansItem = new IguanaFoodPam(HarvestConfigurationHandler.jellybeansID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:jellybeansItem");
			PamHarvestCraft.biscuitItem = new IguanaFoodPam(HarvestConfigurationHandler.biscuitID, 4, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:biscuitItem");
			PamHarvestCraft.creamcookieItem = new IguanaFoodPam(HarvestConfigurationHandler.creamcookieID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:creamcookieItem");
			PamHarvestCraft.jaffaItem = new IguanaFoodPam(HarvestConfigurationHandler.jaffaID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:jaffaItem");
			PamHarvestCraft.friedchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.friedchickenID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:friedchickenItem");
			PamHarvestCraft.chocolatesprinklecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatesprinklecakeID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatesprinklecakeItem");
			PamHarvestCraft.redvelvetcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.redvelvetcakeID, 7, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:redvelvetcakeItem");
			PamHarvestCraft.footlongItem = new IguanaFoodPam(HarvestConfigurationHandler.footlongID, 9, 0.55F, false, true).setUnlocalizedName("PamHarvestCraft:footlongItem");
			PamHarvestCraft.blueberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:blueberryyogurtItem");
			PamHarvestCraft.lemonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:lemonyogurtItem");
			PamHarvestCraft.cherryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cherryyogurtItem");
			PamHarvestCraft.strawberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:strawberryyogurtItem");
			PamHarvestCraft.grapeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:grapeyogurtItem");
			PamHarvestCraft.chocolateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:chocolateyogurtItem");
			PamHarvestCraft.blackberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:blackberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.blackberrycobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrycobblerID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:blackberrycobblerItem");
			PamHarvestCraft.blackberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrysmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:blackberrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.blackberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:blackberryyogurtItem");
			PamHarvestCraft.chocolatemilkItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatemilkID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:chocolatemilkItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pumpkinyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:pumpkinyogurtItem");
			PamHarvestCraft.raspberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:raspberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.raspberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrypieID, 6, 0.35F, false, true).setUnlocalizedName("PamHarvestCraft:raspberrypieItem");
			PamHarvestCraft.raspberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrysmoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:raspberrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.raspberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:raspberryyogurtItem");
			PamHarvestCraft.cinnamonsugardonutItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonsugardonutID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:cinnamonsugardonutItem");
			PamHarvestCraft.melonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.melonyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:melonyogurtItem");
			PamHarvestCraft.kiwijuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:kiwijuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.kiwismoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwismoothieID, 3, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:kiwismoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.kiwiyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:kiwiyogurtItem");
			PamHarvestCraft.plainyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plainyogurtID, 1, 0.0F, false, true).setUnlocalizedName("PamHarvestCraft:plainyogurtItem");
			PamHarvestCraft.appleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.appleyogurtID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:appleyogurtItem");
			PamHarvestCraft.saltedsunflowerseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.saltedsunflowerseedsID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:saltedsunflowerseedsItem");
			PamHarvestCraft.sunflowerwheatrollsItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerwheatrollsID, 6, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:sunflowerwheatrollsItem");
			PamHarvestCraft.sunflowerbroccolisaladItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerbroccolisaladID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:sunflowerbroccolisaladItem");
			PamHarvestCraft.cranberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cranberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cranberrysauceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrysauceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cranberrysauceItem");
			PamHarvestCraft.cranberrybarItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrybarID, 5, 0.3F, false, true).setUnlocalizedName("PamHarvestCraft:cranberrybarItem");
			PamHarvestCraft.peppermintItem = new IguanaFoodPam(HarvestConfigurationHandler.peppermintID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:peppermintItem");
			PamHarvestCraft.cactusfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitjuiceID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cactusfruitjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.baklavaItem = new IguanaFoodPam(HarvestConfigurationHandler.baklavaID, 7, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:baklavaItem");
			PamHarvestCraft.gummybearsItem = new IguanaFoodPam(HarvestConfigurationHandler.gummybearsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:gummybearsItem");
			PamHarvestCraft.baconmushroomburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconmushroomburgerID, 10, 0.65F, false, true).setUnlocalizedName("PamHarvestCraft:baconmushroomburgerItem");
			PamHarvestCraft.fruitpunchItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitpunchID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:fruitpunchItem");
			PamHarvestCraft.meatystewItem = new IguanaFoodPam(HarvestConfigurationHandler.meatystewID, 6, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:meatystewItem");
			PamHarvestCraft.mixedsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.mixedsaladID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:mixedsaladItem");
			PamHarvestCraft.pinacoladaItem = new IguanaFoodPam(HarvestConfigurationHandler.pinacoladaID, 2, 0.15F, false, true).setUnlocalizedName("PamHarvestCraft:pinacoladaItem");
			PamHarvestCraft.shepardspieItem = new IguanaFoodPam(HarvestConfigurationHandler.shepardspieID, 6, 0.4F, false, true).setUnlocalizedName("PamHarvestCraft:shepardspieItem");
			PamHarvestCraft.eggnogItem = new IguanaFoodPam(HarvestConfigurationHandler.eggnogID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:eggnogItem");
			PamHarvestCraft.custardItem = new IguanaFoodPam(HarvestConfigurationHandler.custardID, 5, 0.25F, false, true).setUnlocalizedName("PamHarvestCraft:custardItem");
			PamHarvestCraft.sushiItem = new IguanaFoodPam(HarvestConfigurationHandler.sushiID, 3, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:sushiItem");
			PamHarvestCraft.gardensoupItem = new IguanaFoodPam(HarvestConfigurationHandler.gardensoupID, 4, 0.2F, false, true).setUnlocalizedName("PamHarvestCraft:gardensoupItem");
			PamHarvestCraft.muttonrawItem = new IguanaFoodPam(HarvestConfigurationHandler.muttonrawID, 1, 0.05F, true, true).setUnlocalizedName("PamHarvestCraft:muttonrawItem");
			PamHarvestCraft.muttoncookedItem = new IguanaFoodPam(HarvestConfigurationHandler.muttoncookedID, 2, 0.1F, true, true).setUnlocalizedName("PamHarvestCraft:muttoncookedItem");
			PamHarvestCraft.calamarirawItem = new IguanaFoodPam(HarvestConfigurationHandler.calamarirawID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:calamarirawItem");
			PamHarvestCraft.calamaricookedItem = new IguanaFoodPam(HarvestConfigurationHandler.calamaricookedID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:calamaricookedItem");
			PamHarvestCraft.applejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:applejellyItem");
			PamHarvestCraft.applejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:applejellysandwichItem");
			PamHarvestCraft.blackberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:blackberryjellyItem");
			PamHarvestCraft.blackberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:blackberryjellysandwichItem");
			PamHarvestCraft.blueberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:blueberryjellyItem");
			PamHarvestCraft.blueberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:blueberryjellysandwichItem");
			PamHarvestCraft.cherryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cherryjellyItem");
			PamHarvestCraft.cherryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:cherryjellysandwichItem");
			PamHarvestCraft.cranberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cranberryjellyItem");
			PamHarvestCraft.cranberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:cranberryjellysandwichItem");
			PamHarvestCraft.kiwijellyItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:kiwijellyItem");
			PamHarvestCraft.kiwijellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:kiwijellysandwichItem");
			PamHarvestCraft.lemonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:lemonjellyItem");
			PamHarvestCraft.lemonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:lemonjellysandwichItem");
			PamHarvestCraft.limejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:limejellyItem");
			PamHarvestCraft.limejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:limejellysandwichItem");
			PamHarvestCraft.mangojellyItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:mangojellyItem");
			PamHarvestCraft.mangojellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:mangojellysandwichItem");
			PamHarvestCraft.orangejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:orangejellyItem");
			PamHarvestCraft.orangejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:orangejellysandwichItem");
			PamHarvestCraft.papayajellyItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:papayajellyItem");
			PamHarvestCraft.papayajellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:papayajellysandwichItem");
			PamHarvestCraft.peachjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:peachjellyItem");
			PamHarvestCraft.peachjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:peachjellysandwichItem");
			PamHarvestCraft.pomegranatejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejellyItem");
			PamHarvestCraft.pomegranatejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejellysandwichItem");
			PamHarvestCraft.raspberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:raspberryjellyItem");
			PamHarvestCraft.raspberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:raspberryjellysandwichItem");
			PamHarvestCraft.starfruitjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:starfruitjellyItem");
			PamHarvestCraft.starfruitjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:starfruitjellysandwichItem");
			PamHarvestCraft.strawberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:strawberryjellyItem");
			PamHarvestCraft.strawberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:strawberryjellysandwichItem");
			PamHarvestCraft.watermelonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellyID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:watermelonjellyItem");
			PamHarvestCraft.watermelonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellysandwichID, 8, 0.45F, false, true).setUnlocalizedName("PamHarvestCraft:watermelonjellysandwichItem");

			PamHarvestCraft.cherrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.cherrysodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:cherrysodaItem");
			PamHarvestCraft.colasodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.colasodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:colasodaItem");
			PamHarvestCraft.gingersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.gingersodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:gingersodaItem");
			PamHarvestCraft.grapesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.grapesodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:grapesodaItem");
			PamHarvestCraft.lemonlimesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.lemonlimesodaID, 3, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:lemonlimesodaItem");
			PamHarvestCraft.orangesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.orangesodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:orangesodaItem");
			PamHarvestCraft.rootbeersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.rootbeersodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:rootbeersodaItem");
			PamHarvestCraft.strawberrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.strawberrysodaID, 2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:strawberrysodaItem");

			PamHarvestCraft.caramelicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelicecreamID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:caramelicecreamItem");
			PamHarvestCraft.mintchocolatechipicemcreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mintchocolatechipicecreamID, 5, 0.25F, false).setUnlocalizedName("PamHarvestCraft:mintchocolatechipicecreamItem");
			PamHarvestCraft.strawberryicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryicecreamID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:strawberryicecreamItem");
			PamHarvestCraft.vanillaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillaicecreamID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:vanillaicecreamItem");

			PamHarvestCraft.ediblerootItem = new ItemPamSeedFood(HarvestConfigurationHandler.ediblerootID, 1, 0.1F, 23).setUnlocalizedName("PamHarvestCraft:ediblerootItem");

			PamHarvestCraft.gingerchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerchickenID, 6, 0.35F, false).setUnlocalizedName("PamHarvestCraft:gingerchickenItem");

			PamHarvestCraft.oldworldveggiesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.oldworldveggiesoupID, 4, 0.15F, false).setUnlocalizedName("PamHarvestCraft:oldworldveggiesoupItem");
			PamHarvestCraft.spicebunItem = new IguanaFoodPam(HarvestConfigurationHandler.spicebunID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:spicebunItem");
			PamHarvestCraft.gingeredrhubarbtartItem = new IguanaFoodPam(HarvestConfigurationHandler.gingeredrhubarbtartID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:gingeredrhubarbtartItem");
			PamHarvestCraft.lambbarleysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.lambbarleysoupID, 5, 0.2F, false).setUnlocalizedName("PamHarvestCraft:lambbarleysoupItem");
			PamHarvestCraft.honeylemonlambItem = new IguanaFoodPam(HarvestConfigurationHandler.honeylemonlambID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:honeylemonlambItem");
			PamHarvestCraft.pumpkinoatsconesItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinoatsconesID, 3, 0.15F, false).setUnlocalizedName("PamHarvestCraft:pumpkinoatsconesItem");
			PamHarvestCraft.beefjerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.beefjerkyID, 3, 0.2F, false).setUnlocalizedName("PamHarvestCraft:beefjerkyItem");
			PamHarvestCraft.plumjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.plumjuiceID, 2, 0.15F, false).setUnlocalizedName("PamHarvestCraft:plumjuiceItem");
			PamHarvestCraft.pearjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pearjuiceID, 2, 0.15F, false).setUnlocalizedName("PamHarvestCraft:pearjuiceItem");
			PamHarvestCraft.ovenroastedcauliflowerItem = new IguanaFoodPam(HarvestConfigurationHandler.ovenroastedcauliflowerID, 5, 0.25F, false).setUnlocalizedName("PamHarvestCraft:ovenroastedcauliflowerItem");
			PamHarvestCraft.leekbaconsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.leekbaconsoupID, 4, 0.15F, false).setUnlocalizedName("PamHarvestCraft:leekbaconsoupItem");
			PamHarvestCraft.herbbutterparsnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.herbbutterparsnipsID, 4, 0.2F, false).setUnlocalizedName("PamHarvestCraft:herbbutterparsnipsItem");
			PamHarvestCraft.scallionbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.scallionbakedpotatoID, 4, 0.25F, false).setUnlocalizedName("PamHarvestCraft:scallionbakedpotatoItem");
			PamHarvestCraft.soymilkItem = new IguanaFoodPam(HarvestConfigurationHandler.soymilkID, 2, 0.05F, false).setUnlocalizedName("PamHarvestCraft:soymilkItem");
			PamHarvestCraft.firmtofuItem = new IguanaFoodPam(HarvestConfigurationHandler.firmtofuID, 2, 0.1F, false).setUnlocalizedName("PamHarvestCraft:firmtofuItem");
			PamHarvestCraft.silkentofuItem = new IguanaFoodPam(HarvestConfigurationHandler.silkentofuID, 3, 0.15F, false).setUnlocalizedName("PamHarvestCraft:silkentofuItem");

		} else {

			PamHarvestCraft.toastItem = new IguanaFoodPam(HarvestConfigurationHandler.toastID, ((ItemFood)PamHarvestCraft.toastItem).getHealAmount(), ((ItemFood)PamHarvestCraft.toastItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:toastItem");
			PamHarvestCraft.cheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseID, ((ItemFood)PamHarvestCraft.cheeseItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cheeseItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cheeseItem");
			PamHarvestCraft.icecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.icecreamID, ((ItemFood)PamHarvestCraft.icecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.icecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:icecreamItem");
			PamHarvestCraft.grilledcheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledcheeseID, ((ItemFood)PamHarvestCraft.grilledcheeseItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grilledcheeseItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grilledcheeseItem");
			PamHarvestCraft.applejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.applejuiceID, ((ItemFood)PamHarvestCraft.applejuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.applejuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:applejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.applesauceItem = new IguanaFoodPam(HarvestConfigurationHandler.applesauceID, ((ItemFood)PamHarvestCraft.applesauceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.applesauceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:applesauceItem");
			PamHarvestCraft.applepieItem = new IguanaFoodPam(HarvestConfigurationHandler.applepieID, ((ItemFood)PamHarvestCraft.applepieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.applepieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:applepieItem");
			PamHarvestCraft.caramelappleItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelappleID, ((ItemFood)PamHarvestCraft.caramelappleItem).getHealAmount(), ((ItemFood)PamHarvestCraft.caramelappleItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:caramelappleItem");
			PamHarvestCraft.pumpkinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinbreadID, ((ItemFood)PamHarvestCraft.pumpkinbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pumpkinbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pumpkinbreadItem");
			PamHarvestCraft.roastedpumpkinseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedpumpkinseedsID, ((ItemFood)PamHarvestCraft.roastedpumpkinseedsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.roastedpumpkinseedsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:roastedpumpkinseedsItem");
			PamHarvestCraft.pumpkinsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinsoupID, ((ItemFood)PamHarvestCraft.pumpkinsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pumpkinsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pumpkinsoupItem");
			PamHarvestCraft.melonjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.melonjuiceID, ((ItemFood)PamHarvestCraft.melonjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.melonjuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:melonjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.melonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.melonsmoothieID, ((ItemFood)PamHarvestCraft.melonsmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.melonsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:melonsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.carrotjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotjuiceID, ((ItemFood)PamHarvestCraft.carrotjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.carrotjuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:carrotjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.carrotcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotcakeID, ((ItemFood)PamHarvestCraft.carrotcakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.carrotcakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:carrotcakeItem");
			PamHarvestCraft.carrotsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotsoupID, ((ItemFood)PamHarvestCraft.carrotsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.carrotsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:carrotsoupItem");
			PamHarvestCraft.glazedcarrotsItem = new IguanaFoodPam(HarvestConfigurationHandler.glazedcarrotsID, ((ItemFood)PamHarvestCraft.glazedcarrotsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.glazedcarrotsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:glazedcarrotsItem");
			PamHarvestCraft.butteredpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.butteredpotatoID, ((ItemFood)PamHarvestCraft.butteredpotatoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.butteredpotatoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:butteredpotatoItem");
			PamHarvestCraft.loadedbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.loadedbakedpotatoID, ((ItemFood)PamHarvestCraft.loadedbakedpotatoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.loadedbakedpotatoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:loadedbakedpotatoItem");
			PamHarvestCraft.mashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedpotatoesID, ((ItemFood)PamHarvestCraft.mashedpotatoesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mashedpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mashedpotatoesItem");
			PamHarvestCraft.potatosaladItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosaladID, ((ItemFood)PamHarvestCraft.potatosaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.potatosaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:potatosaladItem");
			PamHarvestCraft.potatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosoupID, ((ItemFood)PamHarvestCraft.potatosoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.potatosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:potatosoupItem");
			PamHarvestCraft.friesItem = new IguanaFoodPam(HarvestConfigurationHandler.friesID, ((ItemFood)PamHarvestCraft.friesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.friesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:friesItem");
			PamHarvestCraft.grilledmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledmushroomID, ((ItemFood)PamHarvestCraft.grilledmushroomItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grilledmushroomItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grilledmushroomItem");
			PamHarvestCraft.stuffedmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedmushroomID, ((ItemFood)PamHarvestCraft.stuffedmushroomItem).getHealAmount(), ((ItemFood)PamHarvestCraft.stuffedmushroomItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:stuffedmushroomItem");
			PamHarvestCraft.chickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.chickensandwichID, ((ItemFood)PamHarvestCraft.chickensandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickensandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickensandwichItem");
			PamHarvestCraft.chickennoodlesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.chickennoodlesoupID, ((ItemFood)PamHarvestCraft.chickennoodlesoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickennoodlesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickennoodlesoupItem");
			PamHarvestCraft.chickenpotpieItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenpotpieID, ((ItemFood)PamHarvestCraft.chickenpotpieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickenpotpieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickenpotpieItem");
			PamHarvestCraft.breadedporkchopItem = new IguanaFoodPam(HarvestConfigurationHandler.breadedporkchopID, ((ItemFood)PamHarvestCraft.breadedporkchopItem).getHealAmount(), ((ItemFood)PamHarvestCraft.breadedporkchopItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:breadedporkchopItem");
			PamHarvestCraft.hotdogItem = new IguanaFoodPam(HarvestConfigurationHandler.hotdogID, ((ItemFood)PamHarvestCraft.hotdogItem).getHealAmount(), ((ItemFood)PamHarvestCraft.hotdogItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:hotdogItem");
			PamHarvestCraft.bakedhamItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedhamID, ((ItemFood)PamHarvestCraft.bakedhamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bakedhamItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bakedhamItem");
			PamHarvestCraft.hamburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.hamburgerID, ((ItemFood)PamHarvestCraft.hamburgerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.hamburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:hamburgerItem");
			PamHarvestCraft.cheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseburgerID, ((ItemFood)PamHarvestCraft.cheeseburgerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cheeseburgerItem");
			PamHarvestCraft.baconcheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconcheeseburgerID, ((ItemFood)PamHarvestCraft.baconcheeseburgerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.baconcheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:baconcheeseburgerItem");
			PamHarvestCraft.potroastItem = new IguanaFoodPam(HarvestConfigurationHandler.potroastID, ((ItemFood)PamHarvestCraft.potroastItem).getHealAmount(), ((ItemFood)PamHarvestCraft.potroastItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:potroastItem");
			PamHarvestCraft.fishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsandwichID, ((ItemFood)PamHarvestCraft.fishsandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishsandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishsandwichItem");
			PamHarvestCraft.fishsticksItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsticksID, ((ItemFood)PamHarvestCraft.fishsticksItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishsticksItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishsticksItem");
			PamHarvestCraft.fishandchipsItem = new IguanaFoodPam(HarvestConfigurationHandler.fishandchipsID, ((ItemFood)PamHarvestCraft.fishandchipsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishandchipsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishandchipsItem");
			PamHarvestCraft.friedeggItem = new IguanaFoodPam(HarvestConfigurationHandler.friedeggID, ((ItemFood)PamHarvestCraft.friedeggItem).getHealAmount(), ((ItemFood)PamHarvestCraft.friedeggItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:friedeggItem");
			PamHarvestCraft.scrambledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.scrambledeggID, ((ItemFood)PamHarvestCraft.scrambledeggItem).getHealAmount(), ((ItemFood)PamHarvestCraft.scrambledeggItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:scrambledeggItem");
			PamHarvestCraft.boiledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.boiledeggID, ((ItemFood)PamHarvestCraft.boiledeggItem).getHealAmount(), ((ItemFood)PamHarvestCraft.boiledeggItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:boiledeggItem");
			PamHarvestCraft.eggsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.eggsaladID, ((ItemFood)PamHarvestCraft.eggsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.eggsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:eggsaladItem");
			PamHarvestCraft.caramelItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelID, ((ItemFood)PamHarvestCraft.caramelItem).getHealAmount(), ((ItemFood)PamHarvestCraft.caramelItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:caramelItem");
			PamHarvestCraft.taffyItem = new IguanaFoodPam(HarvestConfigurationHandler.taffyID, ((ItemFood)PamHarvestCraft.taffyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.taffyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:taffyItem");
			PamHarvestCraft.spidereyesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.spidereyesoupID, ((ItemFood)PamHarvestCraft.spidereyesoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spidereyesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spidereyesoupItem");
			PamHarvestCraft.zombiejerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.zombiejerkyID, ((ItemFood)PamHarvestCraft.zombiejerkyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zombiejerkyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zombiejerkyItem");
			PamHarvestCraft.chocolatebarItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatebarID, ((ItemFood)PamHarvestCraft.chocolatebarItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatebarItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatebarItem");
			PamHarvestCraft.hotchocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.hotchocolateID, ((ItemFood)PamHarvestCraft.hotchocolateItem).getHealAmount(), ((ItemFood)PamHarvestCraft.hotchocolateItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:hotchocolateItem");
			PamHarvestCraft.chocolateicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateicecreamID, ((ItemFood)PamHarvestCraft.chocolateicecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolateicecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolateicecreamItem");
			PamHarvestCraft.vegetablesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetablesoupID, ((ItemFood)PamHarvestCraft.vegetablesoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.vegetablesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:vegetablesoupItem");
			PamHarvestCraft.stockItem = new IguanaFoodPam(HarvestConfigurationHandler.stockID, ((ItemFood)PamHarvestCraft.stockItem).getHealAmount(), ((ItemFood)PamHarvestCraft.stockItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:stockItem");
			PamHarvestCraft.fruitsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitsaladID, ((ItemFood)PamHarvestCraft.fruitsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fruitsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fruitsaladItem");
			PamHarvestCraft.spagettiItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiID, ((ItemFood)PamHarvestCraft.spagettiItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spagettiItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spagettiItem");
			PamHarvestCraft.spagettiandmeatballsItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiandmeatballsID, ((ItemFood)PamHarvestCraft.spagettiandmeatballsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spagettiandmeatballsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spagettiandmeatballsItem");
			PamHarvestCraft.tomatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatosoupID, ((ItemFood)PamHarvestCraft.tomatosoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.tomatosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:tomatosoupItem");
			PamHarvestCraft.chickenparmasanItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenparmasanID, ((ItemFood)PamHarvestCraft.chickenparmasanItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickenparmasanItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickenparmasanItem");
			PamHarvestCraft.pizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.pizzaID, ((ItemFood)PamHarvestCraft.pizzaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pizzaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pizzaItem");
			PamHarvestCraft.springsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.springsaladID, ((ItemFood)PamHarvestCraft.springsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.springsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:springsaladItem");
			PamHarvestCraft.porklettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.porklettucewrapID, ((ItemFood)PamHarvestCraft.porklettucewrapItem).getHealAmount(), ((ItemFood)PamHarvestCraft.porklettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:porklettucewrapItem");
			PamHarvestCraft.fishlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.fishlettucewrapID, ((ItemFood)PamHarvestCraft.fishlettucewrapItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishlettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishlettucewrapItem");
			PamHarvestCraft.bltItem = new IguanaFoodPam(HarvestConfigurationHandler.bltID, ((ItemFood)PamHarvestCraft.bltItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bltItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bltItem");
			PamHarvestCraft.leafychickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafychickensandwichID, ((ItemFood)PamHarvestCraft.leafychickensandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.leafychickensandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:leafychickensandwichItem");
			PamHarvestCraft.leafyfishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafyfishsandwichID, ((ItemFood)PamHarvestCraft.leafyfishsandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.leafyfishsandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:leafyfishsandwichItem");
			PamHarvestCraft.deluxecheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.deluxecheeseburgerID, ((ItemFood)PamHarvestCraft.deluxecheeseburgerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.deluxecheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:deluxecheeseburgerItem");
			PamHarvestCraft.delightedmealItem = new IguanaFoodPam(HarvestConfigurationHandler.delightedmealID, ((ItemFood)PamHarvestCraft.delightedmealItem).getHealAmount(), ((ItemFood)PamHarvestCraft.delightedmealItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:delightedmealItem");
			PamHarvestCraft.onionsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.onionsoupID, ((ItemFood)PamHarvestCraft.onionsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.onionsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:onionsoupItem");
			PamHarvestCraft.potatocakesItem = new IguanaFoodPam(HarvestConfigurationHandler.potatocakesID, ((ItemFood)PamHarvestCraft.potatocakesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.potatocakesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:potatocakesItem");
			PamHarvestCraft.hashItem = new IguanaFoodPam(HarvestConfigurationHandler.hashID, ((ItemFood)PamHarvestCraft.hashItem).getHealAmount(), ((ItemFood)PamHarvestCraft.hashItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:hashItem");
			PamHarvestCraft.braisedonionsItem = new IguanaFoodPam(HarvestConfigurationHandler.braisedonionsID, ((ItemFood)PamHarvestCraft.braisedonionsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.braisedonionsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:braisedonionsItem");
			PamHarvestCraft.heartybreakfastItem = new IguanaFoodPam(HarvestConfigurationHandler.heartybreakfastID, ((ItemFood)PamHarvestCraft.heartybreakfastItem).getHealAmount(), ((ItemFood)PamHarvestCraft.heartybreakfastItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:heartybreakfastItem");
			PamHarvestCraft.cornonthecobItem = new IguanaFoodPam(HarvestConfigurationHandler.cornonthecobID, ((ItemFood)PamHarvestCraft.cornonthecobItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cornonthecobItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cornonthecobItem");
			PamHarvestCraft.cornbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.cornbreadID, ((ItemFood)PamHarvestCraft.cornbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cornbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cornbreadItem");
			PamHarvestCraft.tortillaItem = new IguanaFoodPam(HarvestConfigurationHandler.tortillaID, ((ItemFood)PamHarvestCraft.tortillaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.tortillaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:tortillaItem");
			PamHarvestCraft.nachoesItem = new IguanaFoodPam(HarvestConfigurationHandler.nachoesID, ((ItemFood)PamHarvestCraft.nachoesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.nachoesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:nachoesItem");
			PamHarvestCraft.tacoItem = new IguanaFoodPam(HarvestConfigurationHandler.tacoID, ((ItemFood)PamHarvestCraft.tacoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.tacoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:tacoItem");
			PamHarvestCraft.fishtacoItem = new IguanaFoodPam(HarvestConfigurationHandler.fishtacoID, ((ItemFood)PamHarvestCraft.fishtacoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishtacoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishtacoItem");
			PamHarvestCraft.creamedcornItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedcornID, ((ItemFood)PamHarvestCraft.creamedcornItem).getHealAmount(), ((ItemFood)PamHarvestCraft.creamedcornItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:creamedcornItem");
			PamHarvestCraft.strawberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysmoothieID, ((ItemFood)PamHarvestCraft.strawberrysmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberrysmoothieItem");
			PamHarvestCraft.strawberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrypieID, ((ItemFood)PamHarvestCraft.strawberrypieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberrypieItem");
			PamHarvestCraft.strawberrysaladItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysaladID, ((ItemFood)PamHarvestCraft.strawberrysaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberrysaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberrysaladItem");
			PamHarvestCraft.strawberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjuiceID, ((ItemFood)PamHarvestCraft.strawberryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.chocolatestrawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatestrawberryID, ((ItemFood)PamHarvestCraft.chocolatestrawberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatestrawberryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatestrawberryItem");
			PamHarvestCraft.peanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbutterID, ((ItemFood)PamHarvestCraft.peanutbutterItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peanutbutterItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peanutbutterItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.trailmixItem = new IguanaFoodPam(HarvestConfigurationHandler.trailmixID, ((ItemFood)PamHarvestCraft.trailmixItem).getHealAmount(), ((ItemFood)PamHarvestCraft.trailmixItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:trailmixItem");
			PamHarvestCraft.pbandjItem = new IguanaFoodPam(HarvestConfigurationHandler.pbandjID, ((ItemFood)PamHarvestCraft.pbandjItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pbandjItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pbandjItem");
			PamHarvestCraft.peanutbuttercookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbuttercookiesID, ((ItemFood)PamHarvestCraft.peanutbuttercookiesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peanutbuttercookiesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peanutbuttercookiesItem");
			PamHarvestCraft.grapejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejuiceID, ((ItemFood)PamHarvestCraft.grapejuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grapejuiceItem");
			PamHarvestCraft.grapejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejellyID, ((ItemFood)PamHarvestCraft.grapejellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grapejellyItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.grapesaladItem = new IguanaFoodPam(HarvestConfigurationHandler.grapesaladID, ((ItemFood)PamHarvestCraft.grapesaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapesaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grapesaladItem");
			PamHarvestCraft.raisincookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.raisincookiesID, ((ItemFood)PamHarvestCraft.raisincookiesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raisincookiesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raisincookiesItem");
			PamHarvestCraft.picklesItem = new IguanaFoodPam(HarvestConfigurationHandler.picklesID, ((ItemFood)PamHarvestCraft.picklesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.picklesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:picklesItem");
			PamHarvestCraft.cucumbersaladItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersaladID, ((ItemFood)PamHarvestCraft.cucumbersaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cucumbersaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cucumbersaladItem");
			PamHarvestCraft.cucumbersoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersoupID, ((ItemFood)PamHarvestCraft.cucumbersoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cucumbersoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cucumbersoupItem");
			PamHarvestCraft.vegetarianlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetarianlettucewrapID, ((ItemFood)PamHarvestCraft.vegetarianlettucewrapItem).getHealAmount(), ((ItemFood)PamHarvestCraft.vegetarianlettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:vegetarianlettucewrapItem");
			PamHarvestCraft.marinatedcucumbersItem = new IguanaFoodPam(HarvestConfigurationHandler.marinatedcucumbersID, ((ItemFood)PamHarvestCraft.marinatedcucumbersItem).getHealAmount(), ((ItemFood)PamHarvestCraft.marinatedcucumbersItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:marinatedcucumbersItem");
			PamHarvestCraft.ricesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.ricesoupID, ((ItemFood)PamHarvestCraft.ricesoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.ricesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:ricesoupItem");
			PamHarvestCraft.friedriceItem = new IguanaFoodPam(HarvestConfigurationHandler.friedriceID, ((ItemFood)PamHarvestCraft.friedriceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.friedriceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:friedriceItem");
			PamHarvestCraft.mushroomrisottoItem = new IguanaFoodPam(HarvestConfigurationHandler.mushroomrisottoID, ((ItemFood)PamHarvestCraft.mushroomrisottoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mushroomrisottoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mushroomrisottoItem");
			PamHarvestCraft.curryItem = new IguanaFoodPam(HarvestConfigurationHandler.curryID, ((ItemFood)PamHarvestCraft.curryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.curryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:curryItem");
			PamHarvestCraft.rainbowcurryItem = new IguanaFoodPam(HarvestConfigurationHandler.rainbowcurryID, ((ItemFood)PamHarvestCraft.rainbowcurryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.rainbowcurryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:rainbowcurryItem");
			PamHarvestCraft.refriedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.refriedbeansID, ((ItemFood)PamHarvestCraft.refriedbeansItem).getHealAmount(), ((ItemFood)PamHarvestCraft.refriedbeansItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:refriedbeansItem");
			PamHarvestCraft.bakedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeansID, ((ItemFood)PamHarvestCraft.bakedbeansItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bakedbeansItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bakedbeansItem");
			PamHarvestCraft.beansandriceItem = new IguanaFoodPam(HarvestConfigurationHandler.beansandriceID, ((ItemFood)PamHarvestCraft.beansandriceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.beansandriceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:beansandriceItem");
			PamHarvestCraft.chiliItem = new IguanaFoodPam(HarvestConfigurationHandler.chiliID, ((ItemFood)PamHarvestCraft.chiliItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chiliItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chiliItem");
			PamHarvestCraft.beanburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.beanburritoID, ((ItemFood)PamHarvestCraft.beanburritoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.beanburritoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:beanburritoItem");
			PamHarvestCraft.stuffedpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedpepperID, ((ItemFood)PamHarvestCraft.stuffedpepperItem).getHealAmount(), ((ItemFood)PamHarvestCraft.stuffedpepperItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:stuffedpepperItem");
			PamHarvestCraft.veggiestirfryItem = new IguanaFoodPam(HarvestConfigurationHandler.veggiestirfryID, ((ItemFood)PamHarvestCraft.veggiestirfryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.veggiestirfryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:veggiestirfryItem");
			PamHarvestCraft.grilledskewersItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledskewersID, ((ItemFood)PamHarvestCraft.grilledskewersItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grilledskewersItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grilledskewersItem");
			PamHarvestCraft.supremepizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.supremepizzaID, ((ItemFood)PamHarvestCraft.supremepizzaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.supremepizzaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:supremepizzaItem");
			PamHarvestCraft.omeletItem = new IguanaFoodPam(HarvestConfigurationHandler.omeletID, ((ItemFood)PamHarvestCraft.omeletItem).getHealAmount(), ((ItemFood)PamHarvestCraft.omeletItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:omeletItem");
			PamHarvestCraft.hotwingsItem = new IguanaFoodPam(HarvestConfigurationHandler.hotwingsID, ((ItemFood)PamHarvestCraft.hotwingsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.hotwingsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:hotwingsItem");
			PamHarvestCraft.chilipoppersItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipoppersID, ((ItemFood)PamHarvestCraft.chilipoppersItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chilipoppersItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chilipoppersItem");
			PamHarvestCraft.extremechiliItem = new IguanaFoodPam(HarvestConfigurationHandler.extremechiliID, ((ItemFood)PamHarvestCraft.extremechiliItem).getHealAmount(), ((ItemFood)PamHarvestCraft.extremechiliItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:extremechiliItem");
			PamHarvestCraft.chilichocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.chilichocolateID, ((ItemFood)PamHarvestCraft.chilichocolateItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chilichocolateItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chilichocolateItem");
			PamHarvestCraft.lemonaideItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonaideID, ((ItemFood)PamHarvestCraft.lemonaideItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonaideItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonaideItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.lemonbarItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonbarID, ((ItemFood)PamHarvestCraft.lemonbarItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonbarItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonbarItem");
			PamHarvestCraft.fishdinnerItem = new IguanaFoodPam(HarvestConfigurationHandler.fishdinnerID, ((ItemFood)PamHarvestCraft.fishdinnerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fishdinnerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fishdinnerItem");
			PamHarvestCraft.lemonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonsmoothieID, ((ItemFood)PamHarvestCraft.lemonsmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.lemonmeringueItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonmeringueID, ((ItemFood)PamHarvestCraft.lemonmeringueItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonmeringueItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonmeringueItem");
			PamHarvestCraft.candiedlemonItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedlemonID, ((ItemFood)PamHarvestCraft.candiedlemonItem).getHealAmount(), ((ItemFood)PamHarvestCraft.candiedlemonItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:candiedlemonItem");
			PamHarvestCraft.lemonchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonchickenID, ((ItemFood)PamHarvestCraft.lemonchickenItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonchickenItem");
			PamHarvestCraft.blueberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrysmoothieID, ((ItemFood)PamHarvestCraft.blueberrysmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberrysmoothieItem");
			PamHarvestCraft.blueberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypieID, ((ItemFood)PamHarvestCraft.blueberrypieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberrypieItem");
			PamHarvestCraft.blueberrymuffinItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrymuffinID, ((ItemFood)PamHarvestCraft.blueberrymuffinItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberrymuffinItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberrymuffinItem");
			PamHarvestCraft.blueberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjuiceID, ((ItemFood)PamHarvestCraft.blueberryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.pancakesID, ((ItemFood)PamHarvestCraft.pancakesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pancakesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pancakesItem");
			PamHarvestCraft.blueberrypancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypancakesID, ((ItemFood)PamHarvestCraft.blueberrypancakesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberrypancakesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberrypancakesItem");
			PamHarvestCraft.cherryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjuiceID, ((ItemFood)PamHarvestCraft.cherryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cherrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrypieID, ((ItemFood)PamHarvestCraft.cherrypieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherrypieItem");
			PamHarvestCraft.chocolatecherryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatecherryID, ((ItemFood)PamHarvestCraft.chocolatecherryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatecherryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatecherryItem");
			PamHarvestCraft.cherrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrysmoothieID, ((ItemFood)PamHarvestCraft.cherrysmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cheesecakeID, ((ItemFood)PamHarvestCraft.cheesecakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cheesecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cheesecakeItem");
			PamHarvestCraft.cherrycheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrycheesecakeID, ((ItemFood)PamHarvestCraft.cherrycheesecakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherrycheesecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherrycheesecakeItem");
			PamHarvestCraft.stuffedeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedeggplantID, ((ItemFood)PamHarvestCraft.stuffedeggplantItem).getHealAmount(), ((ItemFood)PamHarvestCraft.stuffedeggplantItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:stuffedeggplantItem");
			PamHarvestCraft.eggplantparmItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantparmID, ((ItemFood)PamHarvestCraft.eggplantparmItem).getHealAmount(), ((ItemFood)PamHarvestCraft.eggplantparmItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:eggplantparmItem");
			PamHarvestCraft.raspberryicedteaItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryicedteaID, ((ItemFood)PamHarvestCraft.raspberryicedteaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryicedteaItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:raspberryicedteaItem");
			PamHarvestCraft.chaiteaItem = new IguanaFoodPam(HarvestConfigurationHandler.chaiteaID, ((ItemFood)PamHarvestCraft.chaiteaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chaiteaItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:chaiteaItem");
			PamHarvestCraft.espressoItem = new IguanaFoodPam(HarvestConfigurationHandler.espressoID, ((ItemFood)PamHarvestCraft.espressoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.espressoItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("PamHarvestCraft:espressoItem");
			PamHarvestCraft.coffeeconlecheItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeconlecheID, ((ItemFood)PamHarvestCraft.coffeeconlecheItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coffeeconlecheItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeconlecheItem");
			PamHarvestCraft.mochaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mochaicecreamID, ((ItemFood)PamHarvestCraft.mochaicecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mochaicecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mochaicecreamItem");
			PamHarvestCraft.pickledbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.pickledbeetsID, ((ItemFood)PamHarvestCraft.pickledbeetsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pickledbeetsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pickledbeetsItem");
			PamHarvestCraft.beetsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsaladID, ((ItemFood)PamHarvestCraft.beetsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.beetsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:beetsaladItem");
			PamHarvestCraft.beetsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsoupID, ((ItemFood)PamHarvestCraft.beetsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.beetsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:beetsoupItem");
			PamHarvestCraft.bakedbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeetsID, ((ItemFood)PamHarvestCraft.bakedbeetsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bakedbeetsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bakedbeetsItem");
			PamHarvestCraft.broccolimacItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolimacID, ((ItemFood)PamHarvestCraft.broccolimacItem).getHealAmount(), ((ItemFood)PamHarvestCraft.broccolimacItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:broccolimacItem");
			PamHarvestCraft.broccolindipItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolindipID, ((ItemFood)PamHarvestCraft.broccolindipItem).getHealAmount(), ((ItemFood)PamHarvestCraft.broccolindipItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:broccolindipItem");
			PamHarvestCraft.creamedbroccolisoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedbroccolisoupID, ((ItemFood)PamHarvestCraft.creamedbroccolisoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.creamedbroccolisoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:creamedbroccolisoupItem");
			PamHarvestCraft.sweetpotatopieItem = new IguanaFoodPam(HarvestConfigurationHandler.sweetpotatopieID, ((ItemFood)PamHarvestCraft.sweetpotatopieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.sweetpotatopieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:sweetpotatopieItem");
			PamHarvestCraft.candiedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedsweetpotatoesID, ((ItemFood)PamHarvestCraft.candiedsweetpotatoesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.candiedsweetpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:candiedsweetpotatoesItem");
			PamHarvestCraft.mashedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedsweetpotatoesID, ((ItemFood)PamHarvestCraft.mashedsweetpotatoesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mashedsweetpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mashedsweetpotatoesItem");
			PamHarvestCraft.steamedpeasItem = new IguanaFoodPam(HarvestConfigurationHandler.steamedpeasID, ((ItemFood)PamHarvestCraft.steamedpeasItem).getHealAmount(), ((ItemFood)PamHarvestCraft.steamedpeasItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:steamedpeasItem");
			PamHarvestCraft.splitpeasoupItem = new IguanaFoodPam(HarvestConfigurationHandler.splitpeasoupID, ((ItemFood)PamHarvestCraft.splitpeasoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.splitpeasoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:splitpeasoupItem");
			PamHarvestCraft.pineappleupsidedowncakeItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleupsidedowncakeID, ((ItemFood)PamHarvestCraft.pineappleupsidedowncakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pineappleupsidedowncakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pineappleupsidedowncakeItem");
			PamHarvestCraft.pineapplehamItem = new IguanaFoodPam(HarvestConfigurationHandler.pineapplehamID, ((ItemFood)PamHarvestCraft.pineapplehamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pineapplehamItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pineapplehamItem");
			PamHarvestCraft.pineappleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleyogurtID, ((ItemFood)PamHarvestCraft.pineappleyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pineappleyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pineappleyogurtItem");
			PamHarvestCraft.turnipsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.turnipsoupID, ((ItemFood)PamHarvestCraft.turnipsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.turnipsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:turnipsoupItem");
			PamHarvestCraft.roastedrootveggiemedleyItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedrootveggiemedleyID, ((ItemFood)PamHarvestCraft.roastedrootveggiemedleyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.roastedrootveggiemedleyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:roastedrootveggiemedleyItem");
			PamHarvestCraft.bakedturnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedturnipsID, ((ItemFood)PamHarvestCraft.bakedturnipsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bakedturnipsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bakedturnipsItem");
			PamHarvestCraft.gingerbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerbreadID, ((ItemFood)PamHarvestCraft.gingerbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gingerbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:gingerbreadItem");
			PamHarvestCraft.gingersnapsItem = new IguanaFoodPam(HarvestConfigurationHandler.gingersnapsID, ((ItemFood)PamHarvestCraft.gingersnapsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gingersnapsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:gingersnapsItem");
			PamHarvestCraft.candiedgingerItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedgingerID, ((ItemFood)PamHarvestCraft.candiedgingerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.candiedgingerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:candiedgingerItem");
			PamHarvestCraft.softpretzelandmustardItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelandmustardID, ((ItemFood)PamHarvestCraft.softpretzelandmustardItem).getHealAmount(), ((ItemFood)PamHarvestCraft.softpretzelandmustardItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:softpretzelandmustardItem");
			PamHarvestCraft.spicymustardporkItem = new IguanaFoodPam(HarvestConfigurationHandler.spicymustardporkID, ((ItemFood)PamHarvestCraft.spicymustardporkItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spicymustardporkItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spicymustardporkItem");
			PamHarvestCraft.spicygreensItem = new IguanaFoodPam(HarvestConfigurationHandler.spicygreensID, ((ItemFood)PamHarvestCraft.spicygreensItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spicygreensItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spicygreensItem");
			PamHarvestCraft.garlicbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicbreadID, ((ItemFood)PamHarvestCraft.garlicbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.garlicbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:garlicbreadItem");
			PamHarvestCraft.garlicmashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicmashedpotatoesID, ((ItemFood)PamHarvestCraft.garlicmashedpotatoesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.garlicmashedpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:garlicmashedpotatoesItem");
			PamHarvestCraft.garlicchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicchickenID, ((ItemFood)PamHarvestCraft.garlicchickenItem).getHealAmount(), ((ItemFood)PamHarvestCraft.garlicchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:garlicchickenItem");
			PamHarvestCraft.summerradishsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.summerradishsaladID, ((ItemFood)PamHarvestCraft.summerradishsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.summerradishsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:summerradishsaladItem");
			PamHarvestCraft.summersquashwithradishItem = new IguanaFoodPam(HarvestConfigurationHandler.summersquashwithradishID, ((ItemFood)PamHarvestCraft.summersquashwithradishItem).getHealAmount(), ((ItemFood)PamHarvestCraft.summersquashwithradishItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:summersquashwithradishItem");
			PamHarvestCraft.celeryandpeanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.celeryandpeanutbutterID, ((ItemFood)PamHarvestCraft.celeryandpeanutbutterItem).getHealAmount(), ((ItemFood)PamHarvestCraft.celeryandpeanutbutterItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:celeryandpeanutbutterItem");
			PamHarvestCraft.chickencelerycasseroleItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencelerycasseroleID, ((ItemFood)PamHarvestCraft.chickencelerycasseroleItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickencelerycasseroleItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickencelerycasseroleItem");
			PamHarvestCraft.peasandceleryItem = new IguanaFoodPam(HarvestConfigurationHandler.peasandceleryID, ((ItemFood)PamHarvestCraft.peasandceleryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peasandceleryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peasandceleryItem");
			PamHarvestCraft.celerysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.celerysoupID, ((ItemFood)PamHarvestCraft.celerysoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.celerysoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:celerysoupItem");
			PamHarvestCraft.zucchinibreadItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibreadID, ((ItemFood)PamHarvestCraft.zucchinibreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zucchinibreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zucchinibreadItem");
			PamHarvestCraft.zucchinifriesItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinifriesID, ((ItemFood)PamHarvestCraft.zucchinifriesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zucchinifriesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zucchinifriesItem");
			PamHarvestCraft.zestyzucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zestyzucchiniID, ((ItemFood)PamHarvestCraft.zestyzucchiniItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zestyzucchiniItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zestyzucchiniItem");
			PamHarvestCraft.zucchinibakeItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibakeID, ((ItemFood)PamHarvestCraft.zucchinibakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zucchinibakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zucchinibakeItem");
			PamHarvestCraft.asparagusquicheItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagusquicheID, ((ItemFood)PamHarvestCraft.asparagusquicheItem).getHealAmount(), ((ItemFood)PamHarvestCraft.asparagusquicheItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:asparagusquicheItem");
			PamHarvestCraft.asparagussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagussoupID, ((ItemFood)PamHarvestCraft.asparagussoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.asparagussoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:asparagussoupItem");
			PamHarvestCraft.walnutraisinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutraisinbreadID, ((ItemFood)PamHarvestCraft.walnutraisinbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.walnutraisinbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:walnutraisinbreadItem");
			PamHarvestCraft.candiedwalnutsItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedwalnutsID, ((ItemFood)PamHarvestCraft.candiedwalnutsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.candiedwalnutsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:candiedwalnutsItem");
			PamHarvestCraft.brownieItem = new IguanaFoodPam(HarvestConfigurationHandler.brownieID, ((ItemFood)PamHarvestCraft.brownieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.brownieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:brownieItem");
			PamHarvestCraft.papayajuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajuiceID, ((ItemFood)PamHarvestCraft.papayajuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayajuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:papayajuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.papayasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.papayasmoothieID, ((ItemFood)PamHarvestCraft.papayasmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayasmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:papayasmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.papayayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.papayayogurtID, ((ItemFood)PamHarvestCraft.papayayogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:papayayogurtItem");
			PamHarvestCraft.starfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjuiceID, ((ItemFood)PamHarvestCraft.starfruitjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruitjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:starfruitjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.starfruitsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitsmoothieID, ((ItemFood)PamHarvestCraft.starfruitsmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruitsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:starfruitsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.starfruityogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruityogurtID, ((ItemFood)PamHarvestCraft.starfruityogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruityogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:starfruityogurtItem");
			PamHarvestCraft.guacamoleItem = new IguanaFoodPam(HarvestConfigurationHandler.guacamoleID, ((ItemFood)PamHarvestCraft.guacamoleItem).getHealAmount(), ((ItemFood)PamHarvestCraft.guacamoleItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:guacamoleItem");
			PamHarvestCraft.creamofavocadosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamofavocadosoupID, ((ItemFood)PamHarvestCraft.creamofavocadosoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.creamofavocadosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:creamofavocadosoupItem");
			PamHarvestCraft.avocadoburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoburritoID, ((ItemFood)PamHarvestCraft.avocadoburritoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.avocadoburritoItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:avocadoburritoItem");
			PamHarvestCraft.poachedpearItem = new IguanaFoodPam(HarvestConfigurationHandler.poachedpearID, ((ItemFood)PamHarvestCraft.poachedpearItem).getHealAmount(), ((ItemFood)PamHarvestCraft.poachedpearItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:poachedpearItem");
			PamHarvestCraft.fruitcrumbleItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitcrumbleID, ((ItemFood)PamHarvestCraft.fruitcrumbleItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fruitcrumbleItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fruitcrumbleItem");
			PamHarvestCraft.pearyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pearyogurtID, ((ItemFood)PamHarvestCraft.pearyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pearyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pearyogurtItem");
			PamHarvestCraft.plumyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plumyogurtID, ((ItemFood)PamHarvestCraft.plumyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.plumyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:plumyogurtItem");
			PamHarvestCraft.bananasplitItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasplitID, ((ItemFood)PamHarvestCraft.bananasplitItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bananasplitItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bananasplitItem");
			PamHarvestCraft.banananutbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.banananutbreadID, ((ItemFood)PamHarvestCraft.banananutbreadItem).getHealAmount(), ((ItemFood)PamHarvestCraft.banananutbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:banananutbreadItem");
			PamHarvestCraft.bananasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasmoothieID, ((ItemFood)PamHarvestCraft.bananasmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bananasmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bananasmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.bananayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.bananayogurtID, ((ItemFood)PamHarvestCraft.bananayogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bananayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bananayogurtItem");
			PamHarvestCraft.coconutmilkItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutmilkID, ((ItemFood)PamHarvestCraft.coconutmilkItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coconutmilkItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:coconutmilkItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.chickencurryItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencurryID, ((ItemFood)PamHarvestCraft.chickencurryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chickencurryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chickencurryItem");
			PamHarvestCraft.coconutshrimpItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutshrimpID, ((ItemFood)PamHarvestCraft.coconutshrimpItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coconutshrimpItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:coconutshrimpItem");
			PamHarvestCraft.coconutyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutyogurtID, ((ItemFood)PamHarvestCraft.coconutyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coconutyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:coconutyogurtItem");
			PamHarvestCraft.orangejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejuiceID, ((ItemFood)PamHarvestCraft.orangejuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.orangechickenItem = new IguanaFoodPam(HarvestConfigurationHandler.orangechickenID, ((ItemFood)PamHarvestCraft.orangechickenItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangechickenItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangechickenItem");
			PamHarvestCraft.orangesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.orangesmoothieID, ((ItemFood)PamHarvestCraft.orangesmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.orangeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeyogurtID, ((ItemFood)PamHarvestCraft.orangeyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangeyogurtItem");
			PamHarvestCraft.peachjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjuiceID, ((ItemFood)PamHarvestCraft.peachjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.peachcobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.peachcobblerID, ((ItemFood)PamHarvestCraft.peachcobblerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachcobblerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachcobblerItem");
			PamHarvestCraft.peachsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.peachsmoothieID, ((ItemFood)PamHarvestCraft.peachsmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachsmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.peachyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.peachyogurtID, ((ItemFood)PamHarvestCraft.peachyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachyogurtItem");
			PamHarvestCraft.limejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.limejuiceID, ((ItemFood)PamHarvestCraft.limejuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:limejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.keylimepieItem = new IguanaFoodPam(HarvestConfigurationHandler.keylimepieID, ((ItemFood)PamHarvestCraft.keylimepieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.keylimepieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:keylimepieItem");
			PamHarvestCraft.limesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.limesmoothieID, ((ItemFood)PamHarvestCraft.limesmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:limesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.limeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.limeyogurtID, ((ItemFood)PamHarvestCraft.limeyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:limeyogurtItem");
			PamHarvestCraft.mangojuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojuiceID, ((ItemFood)PamHarvestCraft.mangojuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangojuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mangojuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.mangosmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.mangosmoothieID, ((ItemFood)PamHarvestCraft.mangosmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangosmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mangosmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.mangoyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoyogurtID, ((ItemFood)PamHarvestCraft.mangoyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangoyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mangoyogurtItem");
			PamHarvestCraft.pomegranatejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejuiceID, ((ItemFood)PamHarvestCraft.pomegranatejuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranatejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pomegranatesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatesmoothieID, ((ItemFood)PamHarvestCraft.pomegranatesmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranatesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pomegranatesmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pomegranateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateyogurtID, ((ItemFood)PamHarvestCraft.pomegranateyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranateyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pomegranateyogurtItem");
			PamHarvestCraft.vanillayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillayogurtID, ((ItemFood)PamHarvestCraft.vanillayogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.vanillayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:vanillayogurtItem");
			PamHarvestCraft.cinnamonrollItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonrollID, ((ItemFood)PamHarvestCraft.cinnamonrollItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cinnamonrollItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cinnamonrollItem");
			PamHarvestCraft.frenchtoastItem = new IguanaFoodPam(HarvestConfigurationHandler.frenchtoastID, ((ItemFood)PamHarvestCraft.frenchtoastItem).getHealAmount(), ((ItemFood)PamHarvestCraft.frenchtoastItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:frenchtoastItem");
			PamHarvestCraft.marshmellowsItem = new IguanaFoodPam(HarvestConfigurationHandler.marshmellowsID, ((ItemFood)PamHarvestCraft.marshmellowsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.marshmellowsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:marshmellowsItem");
			PamHarvestCraft.donutItem = new IguanaFoodPam(HarvestConfigurationHandler.donutID, ((ItemFood)PamHarvestCraft.donutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.donutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:donutItem");
			PamHarvestCraft.chocolatedonutItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatedonutID, ((ItemFood)PamHarvestCraft.chocolatedonutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatedonutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatedonutItem");
			PamHarvestCraft.powdereddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.powdereddonutID, ((ItemFood)PamHarvestCraft.powdereddonutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.powdereddonutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:powdereddonutItem");
			PamHarvestCraft.jellydonutItem = new IguanaFoodPam(HarvestConfigurationHandler.jellydonutID, ((ItemFood)PamHarvestCraft.jellydonutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.jellydonutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:jellydonutItem");
			PamHarvestCraft.frosteddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.frosteddonutID, ((ItemFood)PamHarvestCraft.frosteddonutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.frosteddonutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:frosteddonutItem");
			PamHarvestCraft.cactussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cactussoupID, ((ItemFood)PamHarvestCraft.cactussoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cactussoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cactussoupItem");
			PamHarvestCraft.wafflesItem = new IguanaFoodPam(HarvestConfigurationHandler.wafflesID, ((ItemFood)PamHarvestCraft.wafflesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.wafflesItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:wafflesItem");
			PamHarvestCraft.seedsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.seedsoupID, ((ItemFood)PamHarvestCraft.seedsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.seedsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:seedsoupItem");
			PamHarvestCraft.softpretzelItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelID, ((ItemFood)PamHarvestCraft.softpretzelItem).getHealAmount(), ((ItemFood)PamHarvestCraft.softpretzelItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:softpretzelItem");
			PamHarvestCraft.jellybeansItem = new IguanaFoodPam(HarvestConfigurationHandler.jellybeansID, ((ItemFood)PamHarvestCraft.jellybeansItem).getHealAmount(), ((ItemFood)PamHarvestCraft.jellybeansItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:jellybeansItem");
			PamHarvestCraft.biscuitItem = new IguanaFoodPam(HarvestConfigurationHandler.biscuitID, ((ItemFood)PamHarvestCraft.biscuitItem).getHealAmount(), ((ItemFood)PamHarvestCraft.biscuitItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:biscuitItem");
			PamHarvestCraft.creamcookieItem = new IguanaFoodPam(HarvestConfigurationHandler.creamcookieID, ((ItemFood)PamHarvestCraft.creamcookieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.creamcookieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:creamcookieItem");
			PamHarvestCraft.jaffaItem = new IguanaFoodPam(HarvestConfigurationHandler.jaffaID, ((ItemFood)PamHarvestCraft.jaffaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.jaffaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:jaffaItem");
			PamHarvestCraft.friedchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.friedchickenID, ((ItemFood)PamHarvestCraft.friedchickenItem).getHealAmount(), ((ItemFood)PamHarvestCraft.friedchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:friedchickenItem");
			PamHarvestCraft.chocolatesprinklecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatesprinklecakeID, ((ItemFood)PamHarvestCraft.chocolatesprinklecakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatesprinklecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatesprinklecakeItem");
			PamHarvestCraft.redvelvetcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.redvelvetcakeID, ((ItemFood)PamHarvestCraft.redvelvetcakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.redvelvetcakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:redvelvetcakeItem");
			PamHarvestCraft.footlongItem = new IguanaFoodPam(HarvestConfigurationHandler.footlongID, ((ItemFood)PamHarvestCraft.footlongItem).getHealAmount(), ((ItemFood)PamHarvestCraft.footlongItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:footlongItem");
			PamHarvestCraft.blueberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryyogurtID, ((ItemFood)PamHarvestCraft.blueberryyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberryyogurtItem");
			PamHarvestCraft.lemonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonyogurtID, ((ItemFood)PamHarvestCraft.lemonyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonyogurtItem");
			PamHarvestCraft.cherryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryyogurtID, ((ItemFood)PamHarvestCraft.cherryyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherryyogurtItem");
			PamHarvestCraft.strawberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryyogurtID, ((ItemFood)PamHarvestCraft.strawberryyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberryyogurtItem");
			PamHarvestCraft.grapeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeyogurtID, ((ItemFood)PamHarvestCraft.grapeyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grapeyogurtItem");
			PamHarvestCraft.chocolateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateyogurtID, ((ItemFood)PamHarvestCraft.chocolateyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolateyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolateyogurtItem");
			PamHarvestCraft.blackberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjuiceID, ((ItemFood)PamHarvestCraft.blackberryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.blackberrycobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrycobblerID, ((ItemFood)PamHarvestCraft.blackberrycobblerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberrycobblerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberrycobblerItem");
			PamHarvestCraft.blackberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrysmoothieID, ((ItemFood)PamHarvestCraft.blackberrysmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.blackberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryyogurtID, ((ItemFood)PamHarvestCraft.blackberryyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberryyogurtItem");
			PamHarvestCraft.chocolatemilkItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatemilkID, ((ItemFood)PamHarvestCraft.chocolatemilkItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chocolatemilkItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chocolatemilkItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.pumpkinyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinyogurtID, ((ItemFood)PamHarvestCraft.pumpkinyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pumpkinyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pumpkinyogurtItem");
			PamHarvestCraft.raspberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjuiceID, ((ItemFood)PamHarvestCraft.raspberryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.raspberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrypieID, ((ItemFood)PamHarvestCraft.raspberrypieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberrypieItem");
			PamHarvestCraft.raspberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrysmoothieID, ((ItemFood)PamHarvestCraft.raspberrysmoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberrysmoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.raspberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryyogurtID, ((ItemFood)PamHarvestCraft.raspberryyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberryyogurtItem");
			PamHarvestCraft.cinnamonsugardonutItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonsugardonutID, ((ItemFood)PamHarvestCraft.cinnamonsugardonutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cinnamonsugardonutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cinnamonsugardonutItem");
			PamHarvestCraft.melonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.melonyogurtID, ((ItemFood)PamHarvestCraft.melonyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.melonyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:melonyogurtItem");
			PamHarvestCraft.kiwijuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijuiceID, ((ItemFood)PamHarvestCraft.kiwijuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwijuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:kiwijuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.kiwismoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwismoothieID, ((ItemFood)PamHarvestCraft.kiwismoothieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwismoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:kiwismoothieItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.kiwiyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiyogurtID, ((ItemFood)PamHarvestCraft.kiwiyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwiyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:kiwiyogurtItem");
			PamHarvestCraft.plainyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plainyogurtID, ((ItemFood)PamHarvestCraft.plainyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.plainyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:plainyogurtItem");
			PamHarvestCraft.appleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.appleyogurtID, ((ItemFood)PamHarvestCraft.appleyogurtItem).getHealAmount(), ((ItemFood)PamHarvestCraft.appleyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:appleyogurtItem");
			PamHarvestCraft.saltedsunflowerseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.saltedsunflowerseedsID, ((ItemFood)PamHarvestCraft.saltedsunflowerseedsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.saltedsunflowerseedsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:saltedsunflowerseedsItem");
			PamHarvestCraft.sunflowerwheatrollsItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerwheatrollsID, ((ItemFood)PamHarvestCraft.sunflowerwheatrollsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.sunflowerwheatrollsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:sunflowerwheatrollsItem");
			PamHarvestCraft.sunflowerbroccolisaladItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerbroccolisaladID, ((ItemFood)PamHarvestCraft.sunflowerbroccolisaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.sunflowerbroccolisaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:sunflowerbroccolisaladItem");
			PamHarvestCraft.cranberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjuiceID, ((ItemFood)PamHarvestCraft.cranberryjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cranberryjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.cranberrysauceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrysauceID, ((ItemFood)PamHarvestCraft.cranberrysauceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberrysauceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cranberrysauceItem");
			PamHarvestCraft.cranberrybarItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrybarID, ((ItemFood)PamHarvestCraft.cranberrybarItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberrybarItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cranberrybarItem");
			PamHarvestCraft.peppermintItem = new IguanaFoodPam(HarvestConfigurationHandler.peppermintID, ((ItemFood)PamHarvestCraft.peppermintItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peppermintItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peppermintItem");
			PamHarvestCraft.cactusfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitjuiceID, ((ItemFood)PamHarvestCraft.cactusfruitjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cactusfruitjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cactusfruitjuiceItem").setContainerItem(Item.glassBottle);
			PamHarvestCraft.baklavaItem = new IguanaFoodPam(HarvestConfigurationHandler.baklavaID, ((ItemFood)PamHarvestCraft.baklavaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.baklavaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:baklavaItem");
			PamHarvestCraft.gummybearsItem = new IguanaFoodPam(HarvestConfigurationHandler.gummybearsID, ((ItemFood)PamHarvestCraft.gummybearsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gummybearsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:gummybearsItem");
			PamHarvestCraft.baconmushroomburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconmushroomburgerID, ((ItemFood)PamHarvestCraft.baconmushroomburgerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.baconmushroomburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:baconmushroomburgerItem");
			PamHarvestCraft.fruitpunchItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitpunchID, ((ItemFood)PamHarvestCraft.fruitpunchItem).getHealAmount(), ((ItemFood)PamHarvestCraft.fruitpunchItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:fruitpunchItem");
			PamHarvestCraft.meatystewItem = new IguanaFoodPam(HarvestConfigurationHandler.meatystewID, ((ItemFood)PamHarvestCraft.meatystewItem).getHealAmount(), ((ItemFood)PamHarvestCraft.meatystewItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:meatystewItem");
			PamHarvestCraft.mixedsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.mixedsaladID, ((ItemFood)PamHarvestCraft.mixedsaladItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mixedsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mixedsaladItem");
			PamHarvestCraft.pinacoladaItem = new IguanaFoodPam(HarvestConfigurationHandler.pinacoladaID, ((ItemFood)PamHarvestCraft.pinacoladaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pinacoladaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pinacoladaItem");
			PamHarvestCraft.shepardspieItem = new IguanaFoodPam(HarvestConfigurationHandler.shepardspieID, ((ItemFood)PamHarvestCraft.shepardspieItem).getHealAmount(), ((ItemFood)PamHarvestCraft.shepardspieItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:shepardspieItem");
			PamHarvestCraft.eggnogItem = new IguanaFoodPam(HarvestConfigurationHandler.eggnogID, ((ItemFood)PamHarvestCraft.eggnogItem).getHealAmount(), ((ItemFood)PamHarvestCraft.eggnogItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:eggnogItem");
			PamHarvestCraft.custardItem = new IguanaFoodPam(HarvestConfigurationHandler.custardID, ((ItemFood)PamHarvestCraft.custardItem).getHealAmount(), ((ItemFood)PamHarvestCraft.custardItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:custardItem");
			PamHarvestCraft.sushiItem = new IguanaFoodPam(HarvestConfigurationHandler.sushiID, ((ItemFood)PamHarvestCraft.sushiItem).getHealAmount(), ((ItemFood)PamHarvestCraft.sushiItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:sushiItem");
			PamHarvestCraft.gardensoupItem = new IguanaFoodPam(HarvestConfigurationHandler.gardensoupID, ((ItemFood)PamHarvestCraft.gardensoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gardensoupItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:gardensoupItem");
			PamHarvestCraft.muttonrawItem = new IguanaFoodPam(HarvestConfigurationHandler.muttonrawID, ((ItemFood)PamHarvestCraft.muttonrawItem).getHealAmount(), ((ItemFood)PamHarvestCraft.muttonrawItem).getSaturationModifier(), true, true).setUnlocalizedName("PamHarvestCraft:muttonrawItem");
			PamHarvestCraft.muttoncookedItem = new IguanaFoodPam(HarvestConfigurationHandler.muttoncookedID, ((ItemFood)PamHarvestCraft.muttoncookedItem).getHealAmount(), ((ItemFood)PamHarvestCraft.muttoncookedItem).getSaturationModifier(), true, true).setUnlocalizedName("PamHarvestCraft:muttoncookedItem");
			PamHarvestCraft.calamarirawItem = new IguanaFoodPam(HarvestConfigurationHandler.calamarirawID, ((ItemFood)PamHarvestCraft.calamarirawItem).getHealAmount(), ((ItemFood)PamHarvestCraft.calamarirawItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:calamarirawItem");
			PamHarvestCraft.calamaricookedItem = new IguanaFoodPam(HarvestConfigurationHandler.calamaricookedID, ((ItemFood)PamHarvestCraft.calamaricookedItem).getHealAmount(), ((ItemFood)PamHarvestCraft.calamaricookedItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:calamaricookedItem");
			PamHarvestCraft.applejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellyID, ((ItemFood)PamHarvestCraft.applejellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.applejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:applejellyItem");
			PamHarvestCraft.applejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellysandwichID, ((ItemFood)PamHarvestCraft.applejellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.applejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:applejellysandwichItem");
			PamHarvestCraft.blackberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellyID, ((ItemFood)PamHarvestCraft.blackberryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberryjellyItem");
			PamHarvestCraft.blackberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellysandwichID, ((ItemFood)PamHarvestCraft.blackberryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blackberryjellysandwichItem");
			PamHarvestCraft.blueberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellyID, ((ItemFood)PamHarvestCraft.blueberryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberryjellyItem");
			PamHarvestCraft.blueberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellysandwichID, ((ItemFood)PamHarvestCraft.blueberryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:blueberryjellysandwichItem");
			PamHarvestCraft.cherryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellyID, ((ItemFood)PamHarvestCraft.cherryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherryjellyItem");
			PamHarvestCraft.cherryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellysandwichID, ((ItemFood)PamHarvestCraft.cherryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherryjellysandwichItem");
			PamHarvestCraft.cranberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellyID, ((ItemFood)PamHarvestCraft.cranberryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cranberryjellyItem");
			PamHarvestCraft.cranberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellysandwichID, ((ItemFood)PamHarvestCraft.cranberryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cranberryjellysandwichItem");
			PamHarvestCraft.kiwijellyItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellyID, ((ItemFood)PamHarvestCraft.kiwijellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwijellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:kiwijellyItem");
			PamHarvestCraft.kiwijellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellysandwichID, ((ItemFood)PamHarvestCraft.kiwijellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwijellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:kiwijellysandwichItem");
			PamHarvestCraft.lemonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellyID, ((ItemFood)PamHarvestCraft.lemonjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonjellyItem");
			PamHarvestCraft.lemonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellysandwichID, ((ItemFood)PamHarvestCraft.lemonjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lemonjellysandwichItem");
			PamHarvestCraft.limejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellyID, ((ItemFood)PamHarvestCraft.limejellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:limejellyItem");
			PamHarvestCraft.limejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellysandwichID, ((ItemFood)PamHarvestCraft.limejellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:limejellysandwichItem");
			PamHarvestCraft.mangojellyItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellyID, ((ItemFood)PamHarvestCraft.mangojellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangojellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mangojellyItem");
			PamHarvestCraft.mangojellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellysandwichID, ((ItemFood)PamHarvestCraft.mangojellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangojellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:mangojellysandwichItem");
			PamHarvestCraft.orangejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellyID, ((ItemFood)PamHarvestCraft.orangejellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangejellyItem");
			PamHarvestCraft.orangejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellysandwichID, ((ItemFood)PamHarvestCraft.orangejellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:orangejellysandwichItem");
			PamHarvestCraft.papayajellyItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellyID, ((ItemFood)PamHarvestCraft.papayajellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayajellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:papayajellyItem");
			PamHarvestCraft.papayajellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellysandwichID, ((ItemFood)PamHarvestCraft.papayajellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayajellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:papayajellysandwichItem");
			PamHarvestCraft.peachjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellyID, ((ItemFood)PamHarvestCraft.peachjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachjellyItem");
			PamHarvestCraft.peachjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellysandwichID, ((ItemFood)PamHarvestCraft.peachjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:peachjellysandwichItem");
			PamHarvestCraft.pomegranatejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellyID, ((ItemFood)PamHarvestCraft.pomegranatejellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranatejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejellyItem");
			PamHarvestCraft.pomegranatejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellysandwichID, ((ItemFood)PamHarvestCraft.pomegranatejellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranatejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:pomegranatejellysandwichItem");
			PamHarvestCraft.raspberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellyID, ((ItemFood)PamHarvestCraft.raspberryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberryjellyItem");
			PamHarvestCraft.raspberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellysandwichID, ((ItemFood)PamHarvestCraft.raspberryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raspberryjellysandwichItem");
			PamHarvestCraft.starfruitjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellyID, ((ItemFood)PamHarvestCraft.starfruitjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruitjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:starfruitjellyItem");
			PamHarvestCraft.starfruitjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellysandwichID, ((ItemFood)PamHarvestCraft.starfruitjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruitjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:starfruitjellysandwichItem");
			PamHarvestCraft.strawberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellyID, ((ItemFood)PamHarvestCraft.strawberryjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberryjellyItem");
			PamHarvestCraft.strawberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellysandwichID, ((ItemFood)PamHarvestCraft.strawberryjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:strawberryjellysandwichItem");
			PamHarvestCraft.watermelonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellyID, ((ItemFood)PamHarvestCraft.watermelonjellyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.watermelonjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:watermelonjellyItem");
			PamHarvestCraft.watermelonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellysandwichID, ((ItemFood)PamHarvestCraft.watermelonjellysandwichItem).getHealAmount(), ((ItemFood)PamHarvestCraft.watermelonjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:watermelonjellysandwichItem");

			PamHarvestCraft.cherrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.cherrysodaID, ((ItemFood)PamHarvestCraft.cherrysodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherrysodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:cherrysodaItem");
			PamHarvestCraft.colasodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.colasodaID, ((ItemFood)PamHarvestCraft.colasodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.colasodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:colasodaItem");
			PamHarvestCraft.gingersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.gingersodaID, ((ItemFood)PamHarvestCraft.gingersodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gingersodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:gingersodaItem");
			PamHarvestCraft.grapesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.grapesodaID, ((ItemFood)PamHarvestCraft.grapesodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:grapesodaItem");
			PamHarvestCraft.lemonlimesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.lemonlimesodaID, ((ItemFood)PamHarvestCraft.lemonlimesodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonlimesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:lemonlimesodaItem");
			PamHarvestCraft.orangesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.orangesodaID, ((ItemFood)PamHarvestCraft.orangesodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:orangesodaItem");
			PamHarvestCraft.rootbeersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.rootbeersodaID, ((ItemFood)PamHarvestCraft.rootbeersodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.rootbeersodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:rootbeersodaItem");
			PamHarvestCraft.strawberrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.strawberrysodaID, ((ItemFood)PamHarvestCraft.strawberrysodaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberrysodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("PamHarvestCraft:strawberrysodaItem");

			PamHarvestCraft.caramelicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelicecreamID, ((ItemFood)PamHarvestCraft.caramelicecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.caramelicecreamItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:caramelicecreamItem");
			PamHarvestCraft.mintchocolatechipicemcreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mintchocolatechipicecreamID, ((ItemFood)PamHarvestCraft.mintchocolatechipicemcreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mintchocolatechipicemcreamItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:mintchocolatechipicecreamItem");
			PamHarvestCraft.strawberryicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryicecreamID, ((ItemFood)PamHarvestCraft.strawberryicecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryicecreamItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:strawberryicecreamItem");
			PamHarvestCraft.vanillaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillaicecreamID, ((ItemFood)PamHarvestCraft.vanillaicecreamItem).getHealAmount(), ((ItemFood)PamHarvestCraft.vanillaicecreamItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:vanillaicecreamItem");

			PamHarvestCraft.ediblerootItem = new ItemPamSeedFood(HarvestConfigurationHandler.ediblerootID, ((ItemFood)PamHarvestCraft.ediblerootItem).getHealAmount(), ((ItemFood)PamHarvestCraft.ediblerootItem).getSaturationModifier(), 23).setUnlocalizedName("PamHarvestCraft:ediblerootItem");

			PamHarvestCraft.gingerchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerchickenID, ((ItemFood)PamHarvestCraft.gingerchickenItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gingerchickenItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:gingerchickenItem");


			PamHarvestCraft.oldworldveggiesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.oldworldveggiesoupID, ((ItemFood)PamHarvestCraft.oldworldveggiesoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.oldworldveggiesoupItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:oldworldveggiesoupItem");
			PamHarvestCraft.spicebunItem = new IguanaFoodPam(HarvestConfigurationHandler.spicebunID, ((ItemFood)PamHarvestCraft.spicebunItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spicebunItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:spicebunItem");
			PamHarvestCraft.gingeredrhubarbtartItem = new IguanaFoodPam(HarvestConfigurationHandler.gingeredrhubarbtartID, ((ItemFood)PamHarvestCraft.gingeredrhubarbtartItem).getHealAmount(), ((ItemFood)PamHarvestCraft.gingeredrhubarbtartItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:gingeredrhubarbtartItem");
			PamHarvestCraft.lambbarleysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.lambbarleysoupID, ((ItemFood)PamHarvestCraft.lambbarleysoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lambbarleysoupItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:lambbarleysoupItem");
			PamHarvestCraft.honeylemonlambItem = new IguanaFoodPam(HarvestConfigurationHandler.honeylemonlambID, ((ItemFood)PamHarvestCraft.honeylemonlambItem).getHealAmount(), ((ItemFood)PamHarvestCraft.honeylemonlambItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:honeylemonlambItem");
			PamHarvestCraft.pumpkinoatsconesItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinoatsconesID, ((ItemFood)PamHarvestCraft.pumpkinoatsconesItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pumpkinoatsconesItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:pumpkinoatsconesItem");
			PamHarvestCraft.beefjerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.beefjerkyID, ((ItemFood)PamHarvestCraft.beefjerkyItem).getHealAmount(), ((ItemFood)PamHarvestCraft.beefjerkyItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:beefjerkyItem");
			PamHarvestCraft.plumjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.plumjuiceID, ((ItemFood)PamHarvestCraft.plumjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.plumjuiceItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:plumjuiceItem");
			PamHarvestCraft.pearjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pearjuiceID, ((ItemFood)PamHarvestCraft.pearjuiceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pearjuiceItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:pearjuiceItem");
			PamHarvestCraft.ovenroastedcauliflowerItem = new IguanaFoodPam(HarvestConfigurationHandler.ovenroastedcauliflowerID, ((ItemFood)PamHarvestCraft.ovenroastedcauliflowerItem).getHealAmount(), ((ItemFood)PamHarvestCraft.ovenroastedcauliflowerItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:ovenroastedcauliflowerItem");
			PamHarvestCraft.leekbaconsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.leekbaconsoupID, ((ItemFood)PamHarvestCraft.leekbaconsoupItem).getHealAmount(), ((ItemFood)PamHarvestCraft.leekbaconsoupItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:leekbaconsoupItem");
			PamHarvestCraft.herbbutterparsnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.herbbutterparsnipsID, ((ItemFood)PamHarvestCraft.herbbutterparsnipsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.herbbutterparsnipsItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:herbbutterparsnipsItem");
			PamHarvestCraft.scallionbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.scallionbakedpotatoID, ((ItemFood)PamHarvestCraft.scallionbakedpotatoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.scallionbakedpotatoItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:scallionbakedpotatoItem");
			PamHarvestCraft.soymilkItem = new IguanaFoodPam(HarvestConfigurationHandler.soymilkID, ((ItemFood)PamHarvestCraft.soymilkItem).getHealAmount(), ((ItemFood)PamHarvestCraft.soymilkItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:soymilkItem");
			PamHarvestCraft.firmtofuItem = new IguanaFoodPam(HarvestConfigurationHandler.firmtofuID, ((ItemFood)PamHarvestCraft.firmtofuItem).getHealAmount(), ((ItemFood)PamHarvestCraft.firmtofuItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:firmtofuItem");
			PamHarvestCraft.silkentofuItem = new IguanaFoodPam(HarvestConfigurationHandler.silkentofuID, ((ItemFood)PamHarvestCraft.silkentofuItem).getHealAmount(), ((ItemFood)PamHarvestCraft.silkentofuItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:silkentofuItem");

		}

		Item.itemsList[PamHarvestCraft.grilledasparagusItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.grilledasparagusItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledasparagusID, ((ItemFood)PamHarvestCraft.grilledasparagusItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grilledasparagusItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grilledasparagusItem");
		else
			PamHarvestCraft.grilledasparagusItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledasparagusID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:grilledasparagusItem");

		Item.itemsList[PamHarvestCraft.avocadoItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.avocadoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoID, ((ItemFood)PamHarvestCraft.avocadoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.avocadoItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:avocadoItem");
		else
			PamHarvestCraft.avocadoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:avocadoItem");

		Item.itemsList[PamHarvestCraft.bananaItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.bananaItem = new IguanaFoodPam(HarvestConfigurationHandler.bananaID, ((ItemFood)PamHarvestCraft.bananaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bananaItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:bananaItem");
		else
			PamHarvestCraft.bananaItem = new IguanaFoodPam(HarvestConfigurationHandler.bananaID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:bananaItem");

		Item.itemsList[PamHarvestCraft.bellpepperItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.bellpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.bellpepperID, ((ItemFood)PamHarvestCraft.bellpepperItem).getHealAmount(), ((ItemFood)PamHarvestCraft.bellpepperItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:bellpepperItem");
		else
			PamHarvestCraft.bellpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.bellpepperID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:bellpepperItem");

		Item.itemsList[PamHarvestCraft.blackberryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.blackberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryID, ((ItemFood)PamHarvestCraft.blackberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blackberryItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:blackberryItem");
		else
			PamHarvestCraft.blackberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:blackberryItem");

		Item.itemsList[PamHarvestCraft.blueberryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.blueberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryID, ((ItemFood)PamHarvestCraft.blueberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.blueberryItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:blueberryItem");
		else
			PamHarvestCraft.blueberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:blueberryItem");

		Item.itemsList[PamHarvestCraft.cactusfruitItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cactusfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitID, ((ItemFood)PamHarvestCraft.cactusfruitItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cactusfruitItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:cactusfruitItem");
		else
			PamHarvestCraft.cactusfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:cactusfruitItem");

		Item.itemsList[PamHarvestCraft.cantaloupeItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cantaloupeItem = new IguanaFoodPam(HarvestConfigurationHandler.cantaloupeID, ((ItemFood)PamHarvestCraft.cantaloupeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cantaloupeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cantaloupeItem");
		else
			PamHarvestCraft.cantaloupeItem = new IguanaFoodPam(HarvestConfigurationHandler.cantaloupeID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cantaloupeItem");

		Item.itemsList[PamHarvestCraft.cherryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cherryItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryID, ((ItemFood)PamHarvestCraft.cherryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cherryItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cherryItem");
		else
			PamHarvestCraft.cherryItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cherryItem");

		Item.itemsList[PamHarvestCraft.chilipepperItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.chilipepperItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipepperID, ((ItemFood)PamHarvestCraft.chilipepperItem).getHealAmount(), ((ItemFood)PamHarvestCraft.chilipepperItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:chilipepperItem");
		else
			PamHarvestCraft.chilipepperItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipepperID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:chilipepperItem");

		Item.itemsList[PamHarvestCraft.coconutItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.toastedcoconutItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.coconutItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutID, ((ItemFood)PamHarvestCraft.coconutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coconutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:coconutItem");
			PamHarvestCraft.toastedcoconutItem = new IguanaFoodPam(HarvestConfigurationHandler.toastedcoconutID, ((ItemFood)PamHarvestCraft.toastedcoconutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.toastedcoconutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:toastedcoconutItem");
		} else {
			PamHarvestCraft.coconutItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:coconutItem");
			PamHarvestCraft.toastedcoconutItem = new IguanaFoodPam(HarvestConfigurationHandler.toastedcoconutID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:toastedcoconutItem");
		}
		Item.itemsList[PamHarvestCraft.coffeeItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.coffeeItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeID, ((ItemFood)PamHarvestCraft.coffeeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.coffeeItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeItem");
		else
			PamHarvestCraft.coffeeItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeID, 0, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeItem");

		Item.itemsList[PamHarvestCraft.cornItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.popcornItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.cornItem = new IguanaFoodPam(HarvestConfigurationHandler.cornID, ((ItemFood)PamHarvestCraft.cornItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cornItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cornItem");
			PamHarvestCraft.popcornItem = new IguanaFoodPam(HarvestConfigurationHandler.popcornID, ((ItemFood)PamHarvestCraft.popcornItem).getHealAmount(), ((ItemFood)PamHarvestCraft.popcornItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:popcornItem");
		} else {
			PamHarvestCraft.cornItem = new IguanaFoodPam(HarvestConfigurationHandler.cornID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cornItem");
			PamHarvestCraft.popcornItem = new IguanaFoodPam(HarvestConfigurationHandler.popcornID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:popcornItem");
		}

		Item.itemsList[PamHarvestCraft.cranberryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cranberryItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryID, ((ItemFood)PamHarvestCraft.cranberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cranberryItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:cranberryItem");
		else
			PamHarvestCraft.cranberryItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:cranberryItem");

		Item.itemsList[PamHarvestCraft.cucumberItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cucumberItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumberID, ((ItemFood)PamHarvestCraft.cucumberItem).getHealAmount(), ((ItemFood)PamHarvestCraft.cucumberItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:cucumberItem");
		else
			PamHarvestCraft.cucumberItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumberID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cucumberItem");

		Item.itemsList[PamHarvestCraft.dragonfruitItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.dragonfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.dragonfruitID, ((ItemFood)PamHarvestCraft.dragonfruitItem).getHealAmount(), ((ItemFood)PamHarvestCraft.dragonfruitItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:dragonfruitItem");
		else
			PamHarvestCraft.dragonfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.dragonfruitID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:dragonfruitItem");

		Item.itemsList[PamHarvestCraft.eggplantItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.grilledeggplantItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.eggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantID, ((ItemFood)PamHarvestCraft.eggplantItem).getHealAmount(), ((ItemFood)PamHarvestCraft.eggplantItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:eggplantItem");
			PamHarvestCraft.grilledeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledeggplantID, ((ItemFood)PamHarvestCraft.grilledeggplantItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grilledeggplantItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:grilledeggplantItem");
		} else {
			PamHarvestCraft.eggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:eggplantItem");
			PamHarvestCraft.grilledeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledeggplantID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:grilledeggplantItem");
		}

		Item.itemsList[PamHarvestCraft.grapeItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.raisinsItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.grapeItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeID, ((ItemFood)PamHarvestCraft.grapeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.grapeItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:grapeItem");
			PamHarvestCraft.raisinsItem = new IguanaFoodPam(HarvestConfigurationHandler.raisinsID, ((ItemFood)PamHarvestCraft.raisinsItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raisinsItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:raisinsItem");
		} else {
			PamHarvestCraft.grapeItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:grapeItem");
			PamHarvestCraft.raisinsItem = new IguanaFoodPam(HarvestConfigurationHandler.raisinsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:raisinsItem");
		}

		Item.itemsList[PamHarvestCraft.kiwiItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.kiwiItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiID, ((ItemFood)PamHarvestCraft.kiwiItem).getHealAmount(), ((ItemFood)PamHarvestCraft.kiwiItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:kiwiItem");
		else
			PamHarvestCraft.kiwiItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:kiwiItem");

		Item.itemsList[PamHarvestCraft.lemonItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.lemonItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonID, ((ItemFood)PamHarvestCraft.lemonItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lemonItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:lemonItem");
		else
			PamHarvestCraft.lemonItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:lemonItem");

		Item.itemsList[PamHarvestCraft.limeItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.limeItem = new IguanaFoodPam(HarvestConfigurationHandler.limeID, ((ItemFood)PamHarvestCraft.limeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.limeItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:limeItem");
		else
			PamHarvestCraft.limeItem = new IguanaFoodPam(HarvestConfigurationHandler.limeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:limeItem");

		Item.itemsList[PamHarvestCraft.lettuceItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.lettuceItem = new IguanaFoodPam(HarvestConfigurationHandler.lettuceID, ((ItemFood)PamHarvestCraft.lettuceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.lettuceItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:lettuceItem");
		else
			PamHarvestCraft.lettuceItem = new IguanaFoodPam(HarvestConfigurationHandler.lettuceID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:lettuceItem");

		Item.itemsList[PamHarvestCraft.mangoItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.mangoItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoID, ((ItemFood)PamHarvestCraft.mangoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.mangoItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:mangoItem");
		else
			PamHarvestCraft.mangoItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:mangoItem");

		Item.itemsList[PamHarvestCraft.nutmegItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.nutmegItem = new IguanaFoodPam(HarvestConfigurationHandler.nutmegID, ((ItemFood)PamHarvestCraft.nutmegItem).getHealAmount(), ((ItemFood)PamHarvestCraft.nutmegItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:nutmegItem");
		else
			PamHarvestCraft.nutmegItem = new IguanaFoodPam(HarvestConfigurationHandler.nutmegID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:nutmegItem");

		Item.itemsList[PamHarvestCraft.oliveItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.oliveItem = new IguanaFoodPam(HarvestConfigurationHandler.oliveID, ((ItemFood)PamHarvestCraft.oliveItem).getHealAmount(), ((ItemFood)PamHarvestCraft.oliveItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:oliveItem");
		else
			PamHarvestCraft.oliveItem = new IguanaFoodPam(HarvestConfigurationHandler.oliveID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:oliveItem");

		Item.itemsList[PamHarvestCraft.orangeItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.orangeItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeID, ((ItemFood)PamHarvestCraft.orangeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.orangeItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:orangeItem");
		else
			PamHarvestCraft.orangeItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:orangeItem");

		Item.itemsList[PamHarvestCraft.papayaItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.papayaItem = new IguanaFoodPam(HarvestConfigurationHandler.papayaID, ((ItemFood)PamHarvestCraft.papayaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.papayaItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:papayaItem");
		else
			PamHarvestCraft.papayaItem = new IguanaFoodPam(HarvestConfigurationHandler.papayaID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:papayaItem");

		Item.itemsList[PamHarvestCraft.peachItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.peachItem = new IguanaFoodPam(HarvestConfigurationHandler.peachID, ((ItemFood)PamHarvestCraft.peachItem).getHealAmount(), ((ItemFood)PamHarvestCraft.peachItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:peachItem");
		else
			PamHarvestCraft.peachItem = new IguanaFoodPam(HarvestConfigurationHandler.peachID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:peachItem");

		Item.itemsList[PamHarvestCraft.pearItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.pearItem = new IguanaFoodPam(HarvestConfigurationHandler.pearID, ((ItemFood)PamHarvestCraft.pearItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pearItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:pearItem");
		else
			PamHarvestCraft.pearItem = new IguanaFoodPam(HarvestConfigurationHandler.pearID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:pearItem");

		Item.itemsList[PamHarvestCraft.plumItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.plumItem = new IguanaFoodPam(HarvestConfigurationHandler.plumID, ((ItemFood)PamHarvestCraft.plumItem).getHealAmount(), ((ItemFood)PamHarvestCraft.plumItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:plumItem");
		else
			PamHarvestCraft.plumItem = new IguanaFoodPam(HarvestConfigurationHandler.plumID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:plumItem");

		Item.itemsList[PamHarvestCraft.pomegranateItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.pomegranateItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateID, ((ItemFood)PamHarvestCraft.pomegranateItem).getHealAmount(), ((ItemFood)PamHarvestCraft.pomegranateItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:pomegranateItem");
		else
			PamHarvestCraft.pomegranateItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:pomegranateItem");

		Item.itemsList[PamHarvestCraft.raspberryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.raspberryItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryID, ((ItemFood)PamHarvestCraft.raspberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.raspberryItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:raspberryItem");
		else
			PamHarvestCraft.raspberryItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:raspberryItem");

		Item.itemsList[PamHarvestCraft.riceItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.ricecakeItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.riceItem = new IguanaFoodPam(HarvestConfigurationHandler.riceID, ((ItemFood)PamHarvestCraft.riceItem).getHealAmount(), ((ItemFood)PamHarvestCraft.riceItem).getSaturationModifier(), true).setUnlocalizedName("PamHarvestCraft:riceItem");
			PamHarvestCraft.ricecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.ricecakeID, ((ItemFood)PamHarvestCraft.ricecakeItem).getHealAmount(), ((ItemFood)PamHarvestCraft.ricecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:ricecakeItem");
		} else {
			PamHarvestCraft.riceItem = new IguanaFoodPam(HarvestConfigurationHandler.riceID, 1, 0.05F, true).setUnlocalizedName("PamHarvestCraft:riceItem");
			PamHarvestCraft.ricecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.ricecakeID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:ricecakeItem");
		}

		Item.itemsList[PamHarvestCraft.spiceleafItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.spiceleafItem = new IguanaFoodPam(HarvestConfigurationHandler.spiceleafID, ((ItemFood)PamHarvestCraft.spiceleafItem).getHealAmount(), ((ItemFood)PamHarvestCraft.spiceleafItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:spiceleafItem");
		else
			PamHarvestCraft.spiceleafItem = new IguanaFoodPam(HarvestConfigurationHandler.spiceleafID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:spiceleafItem");

		Item.itemsList[PamHarvestCraft.starfruitItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.starfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitID, ((ItemFood)PamHarvestCraft.starfruitItem).getHealAmount(), ((ItemFood)PamHarvestCraft.starfruitItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:starfruitItem");
		else
			PamHarvestCraft.starfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:starfruitItem");

		Item.itemsList[PamHarvestCraft.strawberryItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.strawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryID, ((ItemFood)PamHarvestCraft.strawberryItem).getHealAmount(), ((ItemFood)PamHarvestCraft.strawberryItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:strawberryItem");
		else
			PamHarvestCraft.strawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:strawberryItem");

		Item.itemsList[PamHarvestCraft.tealeafItem.itemID] = null;
		Item.itemsList[PamHarvestCraft.teaItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.tealeafItem = new IguanaFoodPam(HarvestConfigurationHandler.tealeafID, ((ItemFood)PamHarvestCraft.tealeafItem).getHealAmount(), ((ItemFood)PamHarvestCraft.tealeafItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:tealeafItem");
			PamHarvestCraft.teaItem = new IguanaFoodPam(HarvestConfigurationHandler.teaID, ((ItemFood)PamHarvestCraft.teaItem).getHealAmount(), ((ItemFood)PamHarvestCraft.teaItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:teaItem");
		} else {
			PamHarvestCraft.tealeafItem = new IguanaFoodPam(HarvestConfigurationHandler.tealeafID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:tealeafItem");
			PamHarvestCraft.teaItem = new IguanaFoodPam(HarvestConfigurationHandler.teaID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:teaItem");
		}

		Item.itemsList[PamHarvestCraft.tomatoItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.tomatoItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatoID, ((ItemFood)PamHarvestCraft.tomatoItem).getHealAmount(), ((ItemFood)PamHarvestCraft.tomatoItem).getSaturationModifier(), false).setUnlocalizedName("PamHarvestCraft:tomatoItem");
		else
			PamHarvestCraft.tomatoItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:tomatoItem");

		Item.itemsList[PamHarvestCraft.walnutItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.walnutItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutID, ((ItemFood)PamHarvestCraft.walnutItem).getHealAmount(), ((ItemFood)PamHarvestCraft.walnutItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:walnutItem");
		else
			PamHarvestCraft.walnutItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:walnutItem");

		Item.itemsList[PamHarvestCraft.zucchiniItem.itemID] = null;
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.zucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchiniID, ((ItemFood)PamHarvestCraft.zucchiniItem).getHealAmount(), ((ItemFood)PamHarvestCraft.zucchiniItem).getSaturationModifier(), false, true).setUnlocalizedName("PamHarvestCraft:zucchiniItem");
		else
			PamHarvestCraft.zucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchiniID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:zucchiniItem");


		// SAPLING ASPECTS
		if (Loader.isModLoaded("Thaumcraft"))
		{
			AspectList saplingAspects = new AspectList().add(Aspect.SEED, 1).add(Aspect.PLANT, 1).add(Aspect.TREE, 1);

			Block saplings[] = new Block[] {
					PamHarvestCraft.pamappleSapling, PamHarvestCraft.pamavocadoSapling, PamHarvestCraft.pambananaSapling,
					PamHarvestCraft.pamcherrySapling, PamHarvestCraft.pamcinnamonSapling, PamHarvestCraft.pamcoconutSapling,
					PamHarvestCraft.pamdragonfruitSapling, PamHarvestCraft.pamlemonSapling, PamHarvestCraft.pamlimeSapling,
					PamHarvestCraft.pammangoSapling, PamHarvestCraft.pamnutmegSapling, PamHarvestCraft.pamoliveSapling,
					PamHarvestCraft.pampapayaSapling, PamHarvestCraft.pampearSapling, PamHarvestCraft.pampeppercornSapling,
					PamHarvestCraft.pamplumSapling, PamHarvestCraft.pampomegranateSapling, PamHarvestCraft.pamstarfruitSapling,
					PamHarvestCraft.pamvanillabeanSapling, PamHarvestCraft.pamwalnutSapling
			};

			for (Block sapling : saplings) registerAspects(sapling.blockID, saplingAspects);

		}
	}

	public static void registerAspects(Item item, AspectList aspects)
	{
		if (!ThaumcraftApi.exists(item, -1)) ThaumcraftApi.registerObjectTag(id, -1, aspects);
	}

}
