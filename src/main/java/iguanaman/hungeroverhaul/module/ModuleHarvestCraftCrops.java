package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.blocks.IguanaCropPam;
import iguanaman.hungeroverhaul.items.IguanaFoodPam;
import iguanaman.hungeroverhaul.items.IguanaFoodPamPotion;
import iguanaman.hungeroverhaul.items.IguanaSeedPam;
import iguanaman.hungeroverhaul.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.pam.harvestcraft.BlockRegistry;
import com.pam.harvestcraft.ItemRegistry;

import cpw.mods.fml.common.Loader;

public class ModuleHarvestCraftCrops {

	public static void init()
	{

		// CROP BLOCK
		for(Block block : HarvestCraftHelper.PamCrops) {
			String unloc = block.getUnlocalizedName();
			block = new IguanaCropPam().setBlockName(unloc);
		}

		// SETUP VALUES
		float foodSaturation = 0.1F;
		if (IguanaConfig.modifyFoodValues) {
			ItemRegistry.cropfoodRestore = 1;
		}

		// ITEM CHANGES
		ItemRegistry.asparagusItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamasparagusCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:asparagusItem");
		ItemRegistry.asparagusseedItem = new IguanaSeedPam(BlockRegistry.pamasparagusCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:asparagusseedItem");
		ItemRegistry.barleyItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambarleyCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:barleyItem");
		ItemRegistry.barleyseedItem = new IguanaSeedPam(BlockRegistry.pambarleyCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:barleyseedItem");
		ItemRegistry.beanItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beanItem");
		ItemRegistry.beanseedItem = new IguanaSeedPam(BlockRegistry.pambeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beanseedItem");
		ItemRegistry.beetItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambeetCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beetItem");
		ItemRegistry.beetseedItem = new IguanaSeedPam(BlockRegistry.pambeetCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beetseedItem");
		ItemRegistry.broccoliItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambroccoliCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:broccoliItem");
		ItemRegistry.broccoliseedItem = new IguanaSeedPam(BlockRegistry.pambroccoliCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:broccoliseedItem");
		ItemRegistry.cauliflowerItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcauliflowerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cauliflowerItem");
		ItemRegistry.cauliflowerseedItem = new IguanaSeedPam(BlockRegistry.pamcauliflowerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cauliflowerseedItem");
		ItemRegistry.celeryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamceleryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:celeryItem");
		ItemRegistry.celeryseedItem = new IguanaSeedPam(BlockRegistry.pamceleryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:celeryseedItem");
		ItemRegistry.cranberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcranberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cranberryItem");
		ItemRegistry.cranberryseedItem = new IguanaSeedPam(BlockRegistry.pamcranberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cranberryseedItem");
		ItemRegistry.garlicItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgarlicCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:garlicItem");
		ItemRegistry.garlicseedItem = new IguanaSeedPam(BlockRegistry.pamgarlicCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:garlicseedItem");
		ItemRegistry.gingerItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgingerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:gingerItem");
		ItemRegistry.gingerseedItem = new IguanaSeedPam(BlockRegistry.pamgingerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:gingerseedItem");
		ItemRegistry.leekItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamleekCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:leekItem");
		ItemRegistry.leekseedItem = new IguanaSeedPam(BlockRegistry.pamleekCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:leekseedItem");
		ItemRegistry.lettuceItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamlettuceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:lettuceItem");
		ItemRegistry.lettuceseedItem = new IguanaSeedPam(BlockRegistry.pamlettuceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:lettuceseedItem");
		ItemRegistry.oatsItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamoatsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:oatsItem");
		ItemRegistry.oatsseedItem = new IguanaSeedPam(BlockRegistry.pamoatsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:oatsseedItem");
		ItemRegistry.onionItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamonionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:onionItem");
		ItemRegistry.onionseedItem = new IguanaSeedPam(BlockRegistry.pamonionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:onionseedItem");
		ItemRegistry.parsnipItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamparsnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:parsnipItem");
		ItemRegistry.parsnipseedItem = new IguanaSeedPam(BlockRegistry.pamparsnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:parsnipseedItem");
		ItemRegistry.peanutItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampeanutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peanutItem");
		ItemRegistry.peanutseedItem = new IguanaSeedPam(BlockRegistry.pampeanutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peanutseedItem");
		ItemRegistry.pineappleItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampineappleCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:pineappleItem");
		ItemRegistry.pineappleseedItem = new IguanaSeedPam(BlockRegistry.pampineappleCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:pineappleseedItem");
		ItemRegistry.radishItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamradishCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:radishItem");
		ItemRegistry.radishseedItem = new IguanaSeedPam(BlockRegistry.pamradishCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:radishseedItem");
		ItemRegistry.riceItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamriceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:riceItem");
		ItemRegistry.riceseedItem = new IguanaSeedPam(BlockRegistry.pamriceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:riceseedItem");
		ItemRegistry.rutabagaItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamrutabagaCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rutabagaItem");
		ItemRegistry.rutabagaseedItem = new IguanaSeedPam(BlockRegistry.pamrutabagaCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rutabagaseedItem");
		ItemRegistry.ryeItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamryeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ryeItem");
		ItemRegistry.ryeseedItem = new IguanaSeedPam(BlockRegistry.pamryeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ryeseedItem");
		ItemRegistry.scallionItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamscallionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:scallionItem");
		ItemRegistry.scallionseedItem = new IguanaSeedPam(BlockRegistry.pamscallionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:scallionseedItem");
		ItemRegistry.soybeanItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamsoybeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:soybeanItem");
		ItemRegistry.soybeanseedItem = new IguanaSeedPam(BlockRegistry.pamsoybeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:soybeanseedItem");
		ItemRegistry.spiceleafItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:spiceleafItem");
		ItemRegistry.spiceleafseedItem = new IguanaSeedPam(BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:spiceleafseedItem");
		ItemRegistry.sunflowerseedsItem = new ItemFood(ItemRegistry.cropfoodRestore, foodSaturation, false).setUnlocalizedName("ItemRegistry:sunflowerseedsItem");
		ItemRegistry.sweetpotatoItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamsweetpotatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:sweetpotatoItem");
		ItemRegistry.sweetpotatoseedItem = new IguanaSeedPam(BlockRegistry.pamsweetpotatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:sweetpotatoseedItem");
		ItemRegistry.tealeafItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamtealeafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tealeafItem");
		ItemRegistry.teaseedItem = new IguanaSeedPam(BlockRegistry.pamtealeafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:teaseedItem");
		ItemRegistry.turnipItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamturnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:turnipItem");
		ItemRegistry.turnipseedItem = new IguanaSeedPam(BlockRegistry.pamturnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:turnipseedItem");
		ItemRegistry.whitemushroomItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamwhitemushroomCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:whitemushroomItem");
		ItemRegistry.whitemushroomseedItem = new IguanaSeedPam(BlockRegistry.pamwhitemushroomCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:whitemushroomseedItem");

		ItemRegistry.artichokeItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamartichokeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:artichokeItem");
		ItemRegistry.artichokeseedItem = new IguanaSeedPam(BlockRegistry.pamartichokeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:artichokeseedItem");
		ItemRegistry.bellpepperItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambellpepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:bellpepperItem");
		ItemRegistry.bellpepperseedItem = new IguanaSeedPam(BlockRegistry.pambellpepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:bellpepperseedItem");
		ItemRegistry.blackberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamblackberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blackberryItem");
		ItemRegistry.blackberryseedItem = new IguanaSeedPam(BlockRegistry.pamblackberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blackberryseedItem");
		ItemRegistry.blueberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamblueberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blueberryItem");
		ItemRegistry.blueberryseedItem = new IguanaSeedPam(BlockRegistry.pamblueberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blueberryseedItem");
		ItemRegistry.brusselsproutItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambrusselsproutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:brusselsproutItem");
		ItemRegistry.brusselsproutseedItem = new IguanaSeedPam(BlockRegistry.pambrusselsproutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:brusselsproutseedItem");
		ItemRegistry.cabbageItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcabbageCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cabbageItem");
		ItemRegistry.cabbageseedItem = new IguanaSeedPam(BlockRegistry.pamcabbageCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cabbageseedItem");
		ItemRegistry.cactusfruitItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcactusfruitCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cactusfruitItem");
		ItemRegistry.cactusfruitseedItem = new IguanaSeedPam(BlockRegistry.pamcactusfruitCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cactusfruitseedItem");
		ItemRegistry.candleberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcandleberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:candleberryItem");
		ItemRegistry.candleberryseedItem = new IguanaSeedPam(BlockRegistry.pamcandleberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:candleberryseedItem");
		ItemRegistry.cantaloupeItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcantaloupeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cantaloupeItem");
		ItemRegistry.cantaloupeseedItem = new IguanaSeedPam(BlockRegistry.pamcantaloupeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cantaloupeseedItem");
		ItemRegistry.chilipepperItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamchilipepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:chilipepperItem");
		ItemRegistry.chilipepperseedItem = new IguanaSeedPam(BlockRegistry.pamchilipepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:chilipepperseedItem");
		ItemRegistry.coffeebeanItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcoffeebeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:coffeebeanItem");
		ItemRegistry.coffeeseedItem = new IguanaSeedPam(BlockRegistry.pamcoffeebeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:coffeeseedItem");
		ItemRegistry.cornItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcornCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cornItem");
		ItemRegistry.cornseedItem = new IguanaSeedPam(BlockRegistry.pamcornCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cornseedItem");
		ItemRegistry.cottonseedItem = new IguanaSeedPam(BlockRegistry.pamcottonCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cottonseedItem");
		ItemRegistry.cucumberItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcucumberCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cucumberItem");
		ItemRegistry.cucumberseedItem = new IguanaSeedPam(BlockRegistry.pamcucumberCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cucumberseedItem");
		ItemRegistry.eggplantItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pameggplantCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:eggplantItem");
		ItemRegistry.eggplantseedItem = new IguanaSeedPam(BlockRegistry.pameggplantCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:eggplantseedItem");
		ItemRegistry.grapeItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgrapeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:grapeItem");
		ItemRegistry.grapeseedItem = new IguanaSeedPam(BlockRegistry.pamgrapeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:grapeseedItem");
		ItemRegistry.kiwiItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamkiwiCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:kiwiItem");
		ItemRegistry.kiwiseedItem = new IguanaSeedPam(BlockRegistry.pamkiwiCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:kiwiseedItem");
		ItemRegistry.mustardseedsItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pammustardseedsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:mustardseedsItem");
		ItemRegistry.mustardseedItem = new IguanaSeedPam(BlockRegistry.pammustardseedsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:mustardseedItem");
		ItemRegistry.okraItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamokraCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:okraItem");
		ItemRegistry.okraseedItem = new IguanaSeedPam(BlockRegistry.pamokraCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:okraseedItem");
		ItemRegistry.peasItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampeasCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peasItem");
		ItemRegistry.peasseedItem = new IguanaSeedPam(BlockRegistry.pampeasCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peasseedItem");
		ItemRegistry.raspberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamraspberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:raspberryItem");
		ItemRegistry.raspberryseedItem = new IguanaSeedPam(BlockRegistry.pamraspberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:raspberryseedItem");
		ItemRegistry.rhubarbItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamrhubarbCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rhubarbItem");
		ItemRegistry.rhubarbseedItem = new IguanaSeedPam(BlockRegistry.pamrhubarbCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rhubarbseedItem");
		ItemRegistry.seaweedItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamseaweedCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:seaweedItem");
		ItemRegistry.seaweedseedItem = new IguanaSeedPam(BlockRegistry.pamseaweedCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:seaweedseedItem");
		ItemRegistry.strawberryItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamstrawberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:strawberryItem");
		ItemRegistry.strawberryseedItem = new IguanaSeedPam(BlockRegistry.pamstrawberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:strawberryseedItem");
		ItemRegistry.tomatoItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamtomatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tomatoItem");
		ItemRegistry.tomatoseedItem = new IguanaSeedPam(BlockRegistry.pamtomatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tomatoseedItem");
		ItemRegistry.wintersquashItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamwintersquashCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:wintersquashItem");
		ItemRegistry.wintersquashseedItem = new IguanaSeedPam(BlockRegistry.pamwintersquashCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:wintersquashseedItem");
		ItemRegistry.zucchiniItem = new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamzucchiniCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:zucchiniItem");
		ItemRegistry.zucchiniseedItem = new IguanaSeedPam(BlockRegistry.pamzucchiniCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:zucchiniseedItem");

		
		Utils.replace(ItemRegistry.asparagusItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamasparagusCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:asparagusItem"));
		Utils.replace(ItemRegistry.asparagusseedItem, new IguanaSeedPam(BlockRegistry.pamasparagusCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:asparagusseedItem"));
		Utils.replace(ItemRegistry.barleyItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambarleyCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:barleyItem"));
		Utils.replace(ItemRegistry.barleyseedItem, new IguanaSeedPam(BlockRegistry.pambarleyCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:barleyseedItem"));
		Utils.replace(ItemRegistry.beanItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beanItem"));
		Utils.replace(ItemRegistry.beanseedItem, new IguanaSeedPam(BlockRegistry.pambeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beanseedItem"));
		Utils.replace(ItemRegistry.beetItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambeetCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beetItem"));
		Utils.replace(ItemRegistry.beetseedItem, new IguanaSeedPam(BlockRegistry.pambeetCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:beetseedItem"));
		Utils.replace(ItemRegistry.broccoliItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambroccoliCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:broccoliItem"));
		Utils.replace(ItemRegistry.broccoliseedItem, new IguanaSeedPam(BlockRegistry.pambroccoliCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:broccoliseedItem"));
		Utils.replace(ItemRegistry.cauliflowerItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcauliflowerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cauliflowerItem"));
		Utils.replace(ItemRegistry.cauliflowerseedItem, new IguanaSeedPam(BlockRegistry.pamcauliflowerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cauliflowerseedItem"));
		Utils.replace(ItemRegistry.celeryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamceleryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:celeryItem"));
		Utils.replace(ItemRegistry.celeryseedItem, new IguanaSeedPam(BlockRegistry.pamceleryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:celeryseedItem"));
		Utils.replace(ItemRegistry.cranberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcranberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cranberryItem"));
		Utils.replace(ItemRegistry.cranberryseedItem, new IguanaSeedPam(BlockRegistry.pamcranberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cranberryseedItem"));
		Utils.replace(ItemRegistry.garlicItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgarlicCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:garlicItem"));
		Utils.replace(ItemRegistry.garlicseedItem, new IguanaSeedPam(BlockRegistry.pamgarlicCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:garlicseedItem"));
		Utils.replace(ItemRegistry.gingerItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgingerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:gingerItem"));
		Utils.replace(ItemRegistry.gingerseedItem, new IguanaSeedPam(BlockRegistry.pamgingerCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:gingerseedItem"));
		Utils.replace(ItemRegistry.leekItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamleekCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:leekItem"));
		Utils.replace(ItemRegistry.leekseedItem, new IguanaSeedPam(BlockRegistry.pamleekCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:leekseedItem"));
		Utils.replace(ItemRegistry.lettuceItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamlettuceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:lettuceItem"));
		Utils.replace(ItemRegistry.lettuceseedItem, new IguanaSeedPam(BlockRegistry.pamlettuceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:lettuceseedItem"));
		Utils.replace(ItemRegistry.oatsItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamoatsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:oatsItem"));
		Utils.replace(ItemRegistry.oatsseedItem, new IguanaSeedPam(BlockRegistry.pamoatsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:oatsseedItem"));
		Utils.replace(ItemRegistry.onionItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamonionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:onionItem"));
		Utils.replace(ItemRegistry.onionseedItem, new IguanaSeedPam(BlockRegistry.pamonionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:onionseedItem"));
		Utils.replace(ItemRegistry.parsnipItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamparsnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:parsnipItem"));
		Utils.replace(ItemRegistry.parsnipseedItem, new IguanaSeedPam(BlockRegistry.pamparsnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:parsnipseedItem"));
		Utils.replace(ItemRegistry.peanutItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampeanutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peanutItem"));
		Utils.replace(ItemRegistry.peanutseedItem, new IguanaSeedPam(BlockRegistry.pampeanutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peanutseedItem"));
		Utils.replace(ItemRegistry.pineappleItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampineappleCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:pineappleItem"));
		Utils.replace(ItemRegistry.pineappleseedItem, new IguanaSeedPam(BlockRegistry.pampineappleCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:pineappleseedItem"));
		Utils.replace(ItemRegistry.radishItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamradishCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:radishItem"));
		Utils.replace(ItemRegistry.radishseedItem, new IguanaSeedPam(BlockRegistry.pamradishCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:radishseedItem"));
		Utils.replace(ItemRegistry.riceItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamriceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:riceItem"));
		Utils.replace(ItemRegistry.riceseedItem, new IguanaSeedPam(BlockRegistry.pamriceCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:riceseedItem"));
		Utils.replace(ItemRegistry.rutabagaItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamrutabagaCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rutabagaItem"));
		Utils.replace(ItemRegistry.rutabagaseedItem, new IguanaSeedPam(BlockRegistry.pamrutabagaCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rutabagaseedItem"));
		Utils.replace(ItemRegistry.ryeItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamryeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ryeItem"));
		Utils.replace(ItemRegistry.ryeseedItem, new IguanaSeedPam(BlockRegistry.pamryeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ryeseedItem"));
		Utils.replace(ItemRegistry.scallionItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamscallionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:scallionItem"));
		Utils.replace(ItemRegistry.scallionseedItem, new IguanaSeedPam(BlockRegistry.pamscallionCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:scallionseedItem"));
		Utils.replace(ItemRegistry.soybeanItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamsoybeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:soybeanItem"));
		Utils.replace(ItemRegistry.soybeanseedItem, new IguanaSeedPam(BlockRegistry.pamsoybeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:soybeanseedItem"));
		Utils.replace(ItemRegistry.spiceleafItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:spiceleafItem"));
		Utils.replace(ItemRegistry.spiceleafseedItem, new IguanaSeedPam(BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:spiceleafseedItem"));
		Utils.replace(ItemRegistry.sunflowerseedsItem, new ItemFood(ItemRegistry.cropfoodRestore, foodSaturation, false).setUnlocalizedName("ItemRegistry:sunflowerseedsItem"));
		Utils.replace(ItemRegistry.sweetpotatoItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamsweetpotatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:sweetpotatoItem"));
		Utils.replace(ItemRegistry.sweetpotatoseedItem, new IguanaSeedPam(BlockRegistry.pamsweetpotatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:sweetpotatoseedItem"));
		Utils.replace(ItemRegistry.tealeafItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamtealeafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tealeafItem"));
		Utils.replace(ItemRegistry.teaseedItem, new IguanaSeedPam(BlockRegistry.pamtealeafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:teaseedItem"));
		Utils.replace(ItemRegistry.turnipItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamturnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:turnipItem"));
		Utils.replace(ItemRegistry.turnipseedItem, new IguanaSeedPam(BlockRegistry.pamturnipCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:turnipseedItem"));
		Utils.replace(ItemRegistry.whitemushroomItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamwhitemushroomCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:whitemushroomItem"));
		Utils.replace(ItemRegistry.whitemushroomseedItem, new IguanaSeedPam(BlockRegistry.pamwhitemushroomCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:whitemushroomseedItem"));

		Utils.replace(ItemRegistry.artichokeItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamartichokeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:artichokeItem"));
		Utils.replace(ItemRegistry.artichokeseedItem, new IguanaSeedPam(BlockRegistry.pamartichokeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:artichokeseedItem"));
		Utils.replace(ItemRegistry.bellpepperItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambellpepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:bellpepperItem"));
		Utils.replace(ItemRegistry.bellpepperseedItem, new IguanaSeedPam(BlockRegistry.pambellpepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:bellpepperseedItem"));
		Utils.replace(ItemRegistry.blackberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamblackberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blackberryItem"));
		Utils.replace(ItemRegistry.blackberryseedItem, new IguanaSeedPam(BlockRegistry.pamblackberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blackberryseedItem"));
		Utils.replace(ItemRegistry.blueberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamblueberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blueberryItem"));
		Utils.replace(ItemRegistry.blueberryseedItem, new IguanaSeedPam(BlockRegistry.pamblueberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:blueberryseedItem"));
		Utils.replace(ItemRegistry.brusselsproutItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pambrusselsproutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:brusselsproutItem"));
		Utils.replace(ItemRegistry.brusselsproutseedItem, new IguanaSeedPam(BlockRegistry.pambrusselsproutCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:brusselsproutseedItem"));
		Utils.replace(ItemRegistry.cabbageItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcabbageCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cabbageItem"));
		Utils.replace(ItemRegistry.cabbageseedItem, new IguanaSeedPam(BlockRegistry.pamcabbageCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cabbageseedItem"));
		Utils.replace(ItemRegistry.cactusfruitItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcactusfruitCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cactusfruitItem"));
		Utils.replace(ItemRegistry.cactusfruitseedItem, new IguanaSeedPam(BlockRegistry.pamcactusfruitCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cactusfruitseedItem"));
		Utils.replace(ItemRegistry.candleberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcandleberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:candleberryItem"));
		Utils.replace(ItemRegistry.candleberryseedItem, new IguanaSeedPam(BlockRegistry.pamcandleberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:candleberryseedItem"));
		Utils.replace(ItemRegistry.cantaloupeItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcantaloupeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cantaloupeItem"));
		Utils.replace(ItemRegistry.cantaloupeseedItem, new IguanaSeedPam(BlockRegistry.pamcantaloupeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cantaloupeseedItem"));
		Utils.replace(ItemRegistry.chilipepperItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamchilipepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:chilipepperItem"));
		Utils.replace(ItemRegistry.chilipepperseedItem, new IguanaSeedPam(BlockRegistry.pamchilipepperCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:chilipepperseedItem"));
		Utils.replace(ItemRegistry.coffeebeanItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcoffeebeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:coffeebeanItem"));
		Utils.replace(ItemRegistry.coffeeseedItem, new IguanaSeedPam(BlockRegistry.pamcoffeebeanCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:coffeeseedItem"));
		Utils.replace(ItemRegistry.cornItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcornCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cornItem"));
		Utils.replace(ItemRegistry.cornseedItem, new IguanaSeedPam(BlockRegistry.pamcornCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cornseedItem"));
		Utils.replace(ItemRegistry.cottonseedItem, new IguanaSeedPam(BlockRegistry.pamcottonCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cottonseedItem"));
		Utils.replace(ItemRegistry.cucumberItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamcucumberCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cucumberItem"));
		Utils.replace(ItemRegistry.cucumberseedItem, new IguanaSeedPam(BlockRegistry.pamcucumberCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:cucumberseedItem"));
		Utils.replace(ItemRegistry.eggplantItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pameggplantCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:eggplantItem"));
		Utils.replace(ItemRegistry.eggplantseedItem, new IguanaSeedPam(BlockRegistry.pameggplantCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:eggplantseedItem"));
		Utils.replace(ItemRegistry.grapeItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamgrapeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:grapeItem"));
		Utils.replace(ItemRegistry.grapeseedItem, new IguanaSeedPam(BlockRegistry.pamgrapeCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:grapeseedItem"));
		Utils.replace(ItemRegistry.kiwiItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamkiwiCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:kiwiItem"));
		Utils.replace(ItemRegistry.kiwiseedItem, new IguanaSeedPam(BlockRegistry.pamkiwiCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:kiwiseedItem"));
		Utils.replace(ItemRegistry.mustardseedsItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pammustardseedsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:mustardseedsItem"));
		Utils.replace(ItemRegistry.mustardseedItem, new IguanaSeedPam(BlockRegistry.pammustardseedsCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:mustardseedItem"));
		Utils.replace(ItemRegistry.okraItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamokraCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:okraItem"));
		Utils.replace(ItemRegistry.okraseedItem, new IguanaSeedPam(BlockRegistry.pamokraCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:okraseedItem"));
		Utils.replace(ItemRegistry.peasItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pampeasCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peasItem"));
		Utils.replace(ItemRegistry.peasseedItem, new IguanaSeedPam(BlockRegistry.pampeasCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:peasseedItem"));
		Utils.replace(ItemRegistry.raspberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamraspberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:raspberryItem"));
		Utils.replace(ItemRegistry.raspberryseedItem, new IguanaSeedPam(BlockRegistry.pamraspberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:raspberryseedItem"));
		Utils.replace(ItemRegistry.rhubarbItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamrhubarbCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rhubarbItem"));
		Utils.replace(ItemRegistry.rhubarbseedItem, new IguanaSeedPam(BlockRegistry.pamrhubarbCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:rhubarbseedItem"));
		Utils.replace(ItemRegistry.seaweedItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamseaweedCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:seaweedItem"));
		Utils.replace(ItemRegistry.seaweedseedItem, new IguanaSeedPam(BlockRegistry.pamseaweedCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:seaweedseedItem"));
		Utils.replace(ItemRegistry.strawberryItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamstrawberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:strawberryItem"));
		Utils.replace(ItemRegistry.strawberryseedItem, new IguanaSeedPam(BlockRegistry.pamstrawberryCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:strawberryseedItem"));
		Utils.replace(ItemRegistry.tomatoItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamtomatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tomatoItem"));
		Utils.replace(ItemRegistry.tomatoseedItem, new IguanaSeedPam(BlockRegistry.pamtomatoCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:tomatoseedItem"));
		Utils.replace(ItemRegistry.wintersquashItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamwintersquashCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:wintersquashItem"));
		Utils.replace(ItemRegistry.wintersquashseedItem, new IguanaSeedPam(BlockRegistry.pamwintersquashCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:wintersquashseedItem"));
		Utils.replace(ItemRegistry.zucchiniItem, new ItemSeedFood(ItemRegistry.cropfoodRestore, foodSaturation, BlockRegistry.pamzucchiniCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:zucchiniItem"));
		Utils.replace(ItemRegistry.zucchiniseedItem, new IguanaSeedPam(BlockRegistry.pamzucchiniCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:zucchiniseedItem"));
		
		// HavestCraft Base
		if(IguanaConfig.modifyFoodValues)
		{
			ItemRegistry.toastItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:toastItem");
			ItemRegistry.cheeseItem = new IguanaFoodPam(1, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cheeseItem");
			ItemRegistry.icecreamItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:icecreamItem");
			ItemRegistry.grilledcheeseItem = new IguanaFoodPam(7, 0.5F, false, true).setUnlocalizedName("ItemRegistry:grilledcheeseItem");
			ItemRegistry.applejuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:applejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.applesauceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:applesauceItem");
			ItemRegistry.applepieItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:applepieItem");
			ItemRegistry.caramelappleItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:caramelappleItem");
			ItemRegistry.pumpkinbreadItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pumpkinbreadItem");
			ItemRegistry.roastedpumpkinseedsItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:roastedpumpkinseedsItem");
			ItemRegistry.pumpkinsoupItem = new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pumpkinsoupItem");
			ItemRegistry.melonjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:melonjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.melonsmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:melonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:carrotjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotcakeItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:carrotcakeItem");
			ItemRegistry.carrotsoupItem = new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:carrotsoupItem");
			ItemRegistry.glazedcarrotsItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:glazedcarrotsItem");
			ItemRegistry.butteredpotatoItem = new IguanaFoodPam(4, 0.35F, false, true).setUnlocalizedName("ItemRegistry:butteredpotatoItem");
			ItemRegistry.loadedbakedpotatoItem = new IguanaFoodPam(8, 0.6F, false, true).setUnlocalizedName("ItemRegistry:loadedbakedpotatoItem");
			ItemRegistry.mashedpotatoesItem = new IguanaFoodPam(5, 0.4F, false, true).setUnlocalizedName("ItemRegistry:mashedpotatoesItem");
			ItemRegistry.potatosaladItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:potatosaladItem");
			ItemRegistry.potatosoupItem = new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:potatosoupItem");
			ItemRegistry.friesItem = new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:friesItem");
			ItemRegistry.grilledmushroomItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:grilledmushroomItem");
			ItemRegistry.stuffedmushroomItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:stuffedmushroomItem");
			ItemRegistry.chickensandwichItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:chickensandwichItem");
			ItemRegistry.chickennoodlesoupItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chickennoodlesoupItem");
			ItemRegistry.chickenpotpieItem = new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:chickenpotpieItem");
			ItemRegistry.breadedporkchopItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:breadedporkchopItem");
			ItemRegistry.hotdogItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:hotdogItem");
			ItemRegistry.bakedhamItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedhamItem");
			ItemRegistry.hamburgerItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:hamburgerItem");
			ItemRegistry.cheeseburgerItem = new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:cheeseburgerItem");
			ItemRegistry.baconcheeseburgerItem = new IguanaFoodPam(9, 0.6F, false, true).setUnlocalizedName("ItemRegistry:baconcheeseburgerItem");
			ItemRegistry.potroastItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:potroastItem");
			ItemRegistry.fishsandwichItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:fishsandwichItem");
			ItemRegistry.fishsticksItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:fishsticksItem");
			ItemRegistry.fishandchipsItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:fishandchipsItem");
			ItemRegistry.friedeggItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:friedeggItem");
			ItemRegistry.scrambledeggItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:scrambledeggItem");
			ItemRegistry.boiledeggItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:boiledeggItem");
			ItemRegistry.eggsaladItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:eggsaladItem");
			ItemRegistry.caramelItem = new IguanaFoodPam(1, 0.1F, false, true).setUnlocalizedName("ItemRegistry:caramelItem");
			ItemRegistry.taffyItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:taffyItem");
			ItemRegistry.spidereyesoupItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:spidereyesoupItem");
			ItemRegistry.zombiejerkyItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:zombiejerkyItem");
			ItemRegistry.chocolatebarItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolatebarItem");
			ItemRegistry.hotchocolateItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:hotchocolateItem");
			ItemRegistry.chocolateicecreamItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolateicecreamItem");
			ItemRegistry.vegetablesoupItem = new IguanaFoodPam(6, 0.25F, false, true).setUnlocalizedName("ItemRegistry:vegetablesoupItem");
			ItemRegistry.stockItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:stockItem");
			ItemRegistry.fruitsaladItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:fruitsaladItem");
			ItemRegistry.spagettiItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:spagettiItem");
			ItemRegistry.spagettiandmeatballsItem = new IguanaFoodPam(10, 0.5F, false, true).setUnlocalizedName("ItemRegistry:spagettiandmeatballsItem");
			ItemRegistry.tomatosoupItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:tomatosoupItem");
			ItemRegistry.chickenparmasanItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:chickenparmasanItem");
			ItemRegistry.pizzaItem = new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:pizzaItem");
			ItemRegistry.springsaladItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:springsaladItem");
			ItemRegistry.porklettucewrapItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:porklettucewrapItem");
			ItemRegistry.fishlettucewrapItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:fishlettucewrapItem");
			ItemRegistry.bltItem = new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:bltItem");
			ItemRegistry.leafychickensandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:leafychickensandwichItem");
			ItemRegistry.leafyfishsandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:leafyfishsandwichItem");
			ItemRegistry.deluxecheeseburgerItem = new IguanaFoodPam(10, 0.6F, false, true).setUnlocalizedName("ItemRegistry:deluxecheeseburgerItem");
			ItemRegistry.delightedmealItem = new IguanaFoodPam(16, 0.8F, false, true).setUnlocalizedName("ItemRegistry:delightedmealItem");
			ItemRegistry.onionsoupItem = new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:onionsoupItem");
			ItemRegistry.potatocakesItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:potatocakesItem");
			ItemRegistry.hashItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:hashItem");
			ItemRegistry.braisedonionsItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:braisedonionsItem");
			ItemRegistry.heartybreakfastItem = new IguanaFoodPam(15, 0.8F, false, true).setUnlocalizedName("ItemRegistry:heartybreakfastItem");
			ItemRegistry.cornonthecobItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:cornonthecobItem");
			ItemRegistry.cornbreadItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cornbreadItem");
			ItemRegistry.tortillaItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:tortillaItem");
			ItemRegistry.nachoesItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:nachoesItem");
			ItemRegistry.tacoItem = new IguanaFoodPam(8, 0.4F, false, true).setUnlocalizedName("ItemRegistry:tacoItem");
			ItemRegistry.fishtacoItem = new IguanaFoodPam(8, 0.4F, false, true).setUnlocalizedName("ItemRegistry:fishtacoItem");
			ItemRegistry.creamedcornItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:creamedcornItem");
			ItemRegistry.strawberrysmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:strawberrysmoothieItem");
			ItemRegistry.strawberrypieItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:strawberrypieItem");
			ItemRegistry.strawberrysaladItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:strawberrysaladItem");
			ItemRegistry.strawberryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:strawberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chocolatestrawberryItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolatestrawberryItem");
			ItemRegistry.peanutbutterItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peanutbutterItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.trailmixItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:trailmixItem");
			ItemRegistry.pbandjItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:pbandjItem");
			ItemRegistry.peanutbuttercookiesItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:peanutbuttercookiesItem");
			ItemRegistry.grapejuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:grapejuiceItem");
			ItemRegistry.grapejellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:grapejellyItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.grapesaladItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:grapesaladItem");
			ItemRegistry.raisincookiesItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:raisincookiesItem");
			ItemRegistry.picklesItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:picklesItem");
			ItemRegistry.cucumbersaladItem = new IguanaFoodPam(5, 0.2F, false, true).setUnlocalizedName("ItemRegistry:cucumbersaladItem");
			ItemRegistry.cucumbersoupItem = new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:cucumbersoupItem");
			ItemRegistry.vegetarianlettucewrapItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:vegetarianlettucewrapItem");
			ItemRegistry.marinatedcucumbersItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:marinatedcucumbersItem");
			ItemRegistry.ricesoupItem = new IguanaFoodPam(5, 0.2F, false, true).setUnlocalizedName("ItemRegistry:ricesoupItem");
			ItemRegistry.friedriceItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:friedriceItem");
			ItemRegistry.mushroomrisottoItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:mushroomrisottoItem");
			ItemRegistry.curryItem = new IguanaFoodPam(10, 0.55F, false, true).setUnlocalizedName("ItemRegistry:curryItem");
			ItemRegistry.rainbowcurryItem = new IguanaFoodPam(13, 0.7F, false, true).setUnlocalizedName("ItemRegistry:rainbowcurryItem");
			ItemRegistry.refriedbeansItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:refriedbeansItem");
			ItemRegistry.bakedbeansItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedbeansItem");
			ItemRegistry.beansandriceItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:beansandriceItem");
			ItemRegistry.chiliItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chiliItem");
			ItemRegistry.beanburritoItem = new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:beanburritoItem");
			ItemRegistry.stuffedpepperItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:stuffedpepperItem");
			ItemRegistry.veggiestirfryItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:veggiestirfryItem");
			ItemRegistry.grilledskewersItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:grilledskewersItem");
			ItemRegistry.supremepizzaItem = new IguanaFoodPam(12, 0.7F, false, true).setUnlocalizedName("ItemRegistry:supremepizzaItem");
			ItemRegistry.omeletItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:omeletItem");
			ItemRegistry.hotwingsItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:hotwingsItem");
			ItemRegistry.chilipoppersItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:chilipoppersItem");
			ItemRegistry.extremechiliItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:extremechiliItem");
			ItemRegistry.chilichocolateItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chilichocolateItem");
			ItemRegistry.lemonaideItem = new IguanaFoodPam(1, 0.0F, false, true).setUnlocalizedName("ItemRegistry:lemonaideItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonbarItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonbarItem");
			ItemRegistry.fishdinnerItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:fishdinnerItem");
			ItemRegistry.lemonsmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonmeringueItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:lemonmeringueItem");
			ItemRegistry.candiedlemonItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:candiedlemonItem");
			ItemRegistry.lemonchickenItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:lemonchickenItem");
			ItemRegistry.blueberrysmoothieItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blueberrysmoothieItem");
			ItemRegistry.blueberrypieItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:blueberrypieItem");
			ItemRegistry.blueberrymuffinItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:blueberrymuffinItem");
			ItemRegistry.blueberryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blueberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pancakesItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:pancakesItem");
			ItemRegistry.blueberrypancakesItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:blueberrypancakesItem");
			ItemRegistry.cherryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cherryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cherrypieItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:cherrypieItem");
			ItemRegistry.chocolatecherryItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolatecherryItem");
			ItemRegistry.cherrysmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cherrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cheesecakeItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:cheesecakeItem");
			ItemRegistry.cherrycheesecakeItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:cherrycheesecakeItem");
			ItemRegistry.stuffedeggplantItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:stuffedeggplantItem");
			ItemRegistry.eggplantparmItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:eggplantparmItem");
			ItemRegistry.raspberryicedteaItem = new IguanaFoodPam(1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:raspberryicedteaItem");
			ItemRegistry.chaiteaItem = new IguanaFoodPam(0, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:chaiteaItem");
			ItemRegistry.espressoItem = new IguanaFoodPam(1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("ItemRegistry:espressoItem");
			ItemRegistry.coffeeconlecheItem = new IguanaFoodPam(2, 0.05F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:coffeeconlecheItem");
			ItemRegistry.mochaicecreamItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mochaicecreamItem");
			ItemRegistry.pickledbeetsItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pickledbeetsItem");
			ItemRegistry.beetsaladItem = new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:beetsaladItem");
			ItemRegistry.beetsoupItem = new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:beetsoupItem");
			ItemRegistry.bakedbeetsItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:bakedbeetsItem");
			ItemRegistry.broccolimacItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:broccolimacItem");
			ItemRegistry.broccolindipItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:broccolindipItem");
			ItemRegistry.creamedbroccolisoupItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:creamedbroccolisoupItem");
			ItemRegistry.sweetpotatopieItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:sweetpotatopieItem");
			ItemRegistry.candiedsweetpotatoesItem = new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:candiedsweetpotatoesItem");
			ItemRegistry.mashedsweetpotatoesItem = new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:mashedsweetpotatoesItem");
			ItemRegistry.steamedpeasItem = new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:steamedpeasItem");
			ItemRegistry.splitpeasoupItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:splitpeasoupItem");
			ItemRegistry.pineappleupsidedowncakeItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pineappleupsidedowncakeItem");
			ItemRegistry.pineapplehamItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pineapplehamItem");
			ItemRegistry.pineappleyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pineappleyogurtItem");
			ItemRegistry.turnipsoupItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:turnipsoupItem");
			ItemRegistry.roastedrootveggiemedleyItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:roastedrootveggiemedleyItem");
			ItemRegistry.bakedturnipsItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedturnipsItem");
			ItemRegistry.gingerbreadItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:gingerbreadItem");
			ItemRegistry.gingersnapsItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:gingersnapsItem");
			ItemRegistry.candiedgingerItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:candiedgingerItem");
			ItemRegistry.softpretzelandmustardItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:softpretzelandmustardItem");
			ItemRegistry.spicymustardporkItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:spicymustardporkItem");
			ItemRegistry.spicygreensItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:spicygreensItem");
			ItemRegistry.garlicbreadItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:garlicbreadItem");
			ItemRegistry.garlicmashedpotatoesItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:garlicmashedpotatoesItem");
			ItemRegistry.garlicchickenItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:garlicchickenItem");
			ItemRegistry.summerradishsaladItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:summerradishsaladItem");
			ItemRegistry.summersquashwithradishItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:summersquashwithradishItem");
			ItemRegistry.celeryandpeanutbutterItem = new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:celeryandpeanutbutterItem");
			ItemRegistry.chickencelerycasseroleItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:chickencelerycasseroleItem");
			ItemRegistry.peasandceleryItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:peasandceleryItem");
			ItemRegistry.celerysoupItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:celerysoupItem");
			ItemRegistry.zucchinibreadItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:zucchinibreadItem");
			ItemRegistry.zucchinifriesItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:zucchinifriesItem");
			ItemRegistry.zestyzucchiniItem = new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:zestyzucchiniItem");
			ItemRegistry.zucchinibakeItem = new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:zucchinibakeItem");
			ItemRegistry.asparagusquicheItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:asparagusquicheItem");
			ItemRegistry.asparagussoupItem = new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:asparagussoupItem");
			ItemRegistry.walnutraisinbreadItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:walnutraisinbreadItem");
			ItemRegistry.candiedwalnutsItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:candiedwalnutsItem");
			ItemRegistry.brownieItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:brownieItem");
			ItemRegistry.papayajuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:papayajuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayasmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayayogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayayogurtItem");
			ItemRegistry.starfruitjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:starfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruitsmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruitsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruityogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruityogurtItem");
			ItemRegistry.guacamoleItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:guacamoleItem");
			ItemRegistry.creamofavocadosoupItem = new IguanaFoodPam(6, 0.25F, false, true).setUnlocalizedName("ItemRegistry:creamofavocadosoupItem");
			ItemRegistry.avocadoburritoItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:avocadoburritoItem");
			ItemRegistry.poachedpearItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:poachedpearItem");
			ItemRegistry.fruitcrumbleItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:fruitcrumbleItem");
			ItemRegistry.pearyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pearyogurtItem");
			ItemRegistry.plumyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:plumyogurtItem");
			ItemRegistry.bananasplitItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:bananasplitItem");
			ItemRegistry.banananutbreadItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:banananutbreadItem");
			ItemRegistry.bananasmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:bananasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.bananayogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:bananayogurtItem");
			ItemRegistry.coconutmilkItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:coconutmilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chickencurryItem = new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:chickencurryItem");
			ItemRegistry.coconutshrimpItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:coconutshrimpItem");
			ItemRegistry.coconutyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:coconutyogurtItem");
			ItemRegistry.orangejuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:orangejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangechickenItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:orangechickenItem");
			ItemRegistry.orangesmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangeyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangeyogurtItem");
			ItemRegistry.peachjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:peachjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachcobblerItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:peachcobblerItem");
			ItemRegistry.peachsmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachyogurtItem");
			ItemRegistry.limejuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:limejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.keylimepieItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:keylimepieItem");
			ItemRegistry.limesmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.limeyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limeyogurtItem");
			ItemRegistry.mangojuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:mangojuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangosmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangosmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangoyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangoyogurtItem");
			ItemRegistry.pomegranatejuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranatesmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranatesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranateyogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranateyogurtItem");
			ItemRegistry.vanillayogurtItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:vanillayogurtItem");
			ItemRegistry.cinnamonrollItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cinnamonrollItem");
			ItemRegistry.frenchtoastItem = new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:frenchtoastItem");
			ItemRegistry.marshmellowsItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:marshmellowsItem");
			ItemRegistry.donutItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:donutItem");
			ItemRegistry.chocolatedonutItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:chocolatedonutItem");
			ItemRegistry.powdereddonutItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:powdereddonutItem");
			ItemRegistry.jellydonutItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:jellydonutItem");
			ItemRegistry.frosteddonutItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:frosteddonutItem");
			ItemRegistry.cactussoupItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cactussoupItem");
			ItemRegistry.wafflesItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:wafflesItem");
			ItemRegistry.seedsoupItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:seedsoupItem");
			ItemRegistry.softpretzelItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:softpretzelItem");
			ItemRegistry.jellybeansItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:jellybeansItem");
			ItemRegistry.biscuitItem = new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:biscuitItem");
			ItemRegistry.creamcookieItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:creamcookieItem");
			ItemRegistry.jaffaItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:jaffaItem");
			ItemRegistry.friedchickenItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:friedchickenItem");
			ItemRegistry.chocolatesprinklecakeItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chocolatesprinklecakeItem");
			ItemRegistry.redvelvetcakeItem = new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:redvelvetcakeItem");
			ItemRegistry.footlongItem = new IguanaFoodPam(9, 0.55F, false, true).setUnlocalizedName("ItemRegistry:footlongItem");
			ItemRegistry.blueberryyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blueberryyogurtItem");
			ItemRegistry.lemonyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:lemonyogurtItem");
			ItemRegistry.cherryyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cherryyogurtItem");
			ItemRegistry.strawberryyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:strawberryyogurtItem");
			ItemRegistry.grapeyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:grapeyogurtItem");
			ItemRegistry.chocolateyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolateyogurtItem");
			ItemRegistry.blackberryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blackberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberrycobblerItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:blackberrycobblerItem");
			ItemRegistry.blackberrysmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blackberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberryyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blackberryyogurtItem");
			ItemRegistry.chocolatemilkItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolatemilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pumpkinyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pumpkinyogurtItem");
			ItemRegistry.raspberryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:raspberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberrypieItem = new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:raspberrypieItem");
			ItemRegistry.raspberrysmoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:raspberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberryyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:raspberryyogurtItem");
			ItemRegistry.cinnamonsugardonutItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cinnamonsugardonutItem");
			ItemRegistry.melonyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:melonyogurtItem");
			ItemRegistry.kiwijuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:kiwijuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwismoothieItem = new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:kiwismoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwiyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:kiwiyogurtItem");
			ItemRegistry.plainyogurtItem = new IguanaFoodPam(1, 0.0F, false, true).setUnlocalizedName("ItemRegistry:plainyogurtItem");
			ItemRegistry.appleyogurtItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:appleyogurtItem");
			ItemRegistry.saltedsunflowerseedsItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:saltedsunflowerseedsItem");
			ItemRegistry.sunflowerwheatrollsItem = new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:sunflowerwheatrollsItem");
			ItemRegistry.sunflowerbroccolisaladItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:sunflowerbroccolisaladItem");
			ItemRegistry.cranberryjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cranberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cranberrysauceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cranberrysauceItem");
			ItemRegistry.cranberrybarItem = new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cranberrybarItem");
			ItemRegistry.peppermintItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:peppermintItem");
			ItemRegistry.cactusfruitjuiceItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cactusfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.baklavaItem = new IguanaFoodPam(7, 0.45F, false, true).setUnlocalizedName("ItemRegistry:baklavaItem");
			ItemRegistry.gummybearsItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:gummybearsItem");
			ItemRegistry.baconmushroomburgerItem = new IguanaFoodPam(10, 0.65F, false, true).setUnlocalizedName("ItemRegistry:baconmushroomburgerItem");
			ItemRegistry.fruitpunchItem = new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:fruitpunchItem");
			ItemRegistry.meatystewItem = new IguanaFoodPam(6, 0.45F, false, true).setUnlocalizedName("ItemRegistry:meatystewItem");
			ItemRegistry.mixedsaladItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:mixedsaladItem");
			ItemRegistry.pinacoladaItem = new IguanaFoodPam(2, 0.15F, false, true).setUnlocalizedName("ItemRegistry:pinacoladaItem");
			ItemRegistry.shepardspieItem = new IguanaFoodPam(6, 0.4F, false, true).setUnlocalizedName("ItemRegistry:shepardspieItem");
			ItemRegistry.eggnogItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:eggnogItem");
			ItemRegistry.custardItem = new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:custardItem");
			ItemRegistry.sushiItem = new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:sushiItem");
			ItemRegistry.gardensoupItem = new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:gardensoupItem");
			ItemRegistry.muttonrawItem = new IguanaFoodPam(1, 0.05F, true, true).setUnlocalizedName("ItemRegistry:muttonrawItem");
			ItemRegistry.muttoncookedItem = new IguanaFoodPam(2, 0.1F, true, true).setUnlocalizedName("ItemRegistry:muttoncookedItem");
			ItemRegistry.calamarirawItem = new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:calamarirawItem");
			ItemRegistry.calamaricookedItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:calamaricookedItem");
			ItemRegistry.applejellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:applejellyItem");
			ItemRegistry.applejellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:applejellysandwichItem");
			ItemRegistry.blackberryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blackberryjellyItem");
			ItemRegistry.blackberryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:blackberryjellysandwichItem");
			ItemRegistry.blueberryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blueberryjellyItem");
			ItemRegistry.blueberryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:blueberryjellysandwichItem");
			ItemRegistry.cherryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cherryjellyItem");
			ItemRegistry.cherryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:cherryjellysandwichItem");
			ItemRegistry.cranberryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cranberryjellyItem");
			ItemRegistry.cranberryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:cranberryjellysandwichItem");
			ItemRegistry.kiwijellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:kiwijellyItem");
			ItemRegistry.kiwijellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:kiwijellysandwichItem");
			ItemRegistry.lemonjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonjellyItem");
			ItemRegistry.lemonjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:lemonjellysandwichItem");
			ItemRegistry.limejellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limejellyItem");
			ItemRegistry.limejellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:limejellysandwichItem");
			ItemRegistry.mangojellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangojellyItem");
			ItemRegistry.mangojellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:mangojellysandwichItem");
			ItemRegistry.orangejellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangejellyItem");
			ItemRegistry.orangejellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:orangejellysandwichItem");
			ItemRegistry.papayajellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayajellyItem");
			ItemRegistry.papayajellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:papayajellysandwichItem");
			ItemRegistry.peachjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachjellyItem");
			ItemRegistry.peachjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:peachjellysandwichItem");
			ItemRegistry.pomegranatejellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejellyItem");
			ItemRegistry.pomegranatejellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejellysandwichItem");
			ItemRegistry.raspberryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:raspberryjellyItem");
			ItemRegistry.raspberryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:raspberryjellysandwichItem");
			ItemRegistry.starfruitjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruitjellyItem");
			ItemRegistry.starfruitjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:starfruitjellysandwichItem");
			ItemRegistry.strawberryjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:strawberryjellyItem");
			ItemRegistry.strawberryjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:strawberryjellysandwichItem");
			ItemRegistry.watermelonjellyItem = new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:watermelonjellyItem");
			ItemRegistry.watermelonjellysandwichItem = new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:watermelonjellysandwichItem");

			ItemRegistry.cherrysodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:cherrysodaItem");
			ItemRegistry.colasodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:colasodaItem");
			ItemRegistry.gingersodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:gingersodaItem");
			ItemRegistry.grapesodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:grapesodaItem");
			ItemRegistry.lemonlimesodaItem = new IguanaFoodPamPotion(3, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:lemonlimesodaItem");
			ItemRegistry.orangesodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:orangesodaItem");
			ItemRegistry.rootbeersodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:rootbeersodaItem");
			ItemRegistry.strawberrysodaItem = new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:strawberrysodaItem");

			ItemRegistry.caramelicecreamItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:caramelicecreamItem");
			ItemRegistry.mintchocolatechipicemcreamItem = new IguanaFoodPam(5, 0.25F, false).setUnlocalizedName("ItemRegistry:mintchocolatechipicecreamItem");
			ItemRegistry.strawberryicecreamItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:strawberryicecreamItem");
			ItemRegistry.vanillaicecreamItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:vanillaicecreamItem");

			ItemRegistry.ediblerootItem = new ItemSeedFood(1, 0.1F, BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ediblerootItem");

			ItemRegistry.gingerchickenItem = new IguanaFoodPam(6, 0.35F, false).setUnlocalizedName("ItemRegistry:gingerchickenItem");

			ItemRegistry.oldworldveggiesoupItem = new IguanaFoodPam(4, 0.15F, false).setUnlocalizedName("ItemRegistry:oldworldveggiesoupItem");
			ItemRegistry.spicebunItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:spicebunItem");
			ItemRegistry.gingeredrhubarbtartItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:gingeredrhubarbtartItem");
			ItemRegistry.lambbarleysoupItem = new IguanaFoodPam(5, 0.2F, false).setUnlocalizedName("ItemRegistry:lambbarleysoupItem");
			ItemRegistry.honeylemonlambItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:honeylemonlambItem");
			ItemRegistry.pumpkinoatsconesItem = new IguanaFoodPam(3, 0.15F, false).setUnlocalizedName("ItemRegistry:pumpkinoatsconesItem");
			ItemRegistry.beefjerkyItem = new IguanaFoodPam(3, 0.2F, false).setUnlocalizedName("ItemRegistry:beefjerkyItem");
			ItemRegistry.plumjuiceItem = new IguanaFoodPam(2, 0.15F, false).setUnlocalizedName("ItemRegistry:plumjuiceItem");
			ItemRegistry.pearjuiceItem = new IguanaFoodPam(2, 0.15F, false).setUnlocalizedName("ItemRegistry:pearjuiceItem");
			ItemRegistry.ovenroastedcauliflowerItem = new IguanaFoodPam(5, 0.25F, false).setUnlocalizedName("ItemRegistry:ovenroastedcauliflowerItem");
			ItemRegistry.leekbaconsoupItem = new IguanaFoodPam(4, 0.15F, false).setUnlocalizedName("ItemRegistry:leekbaconsoupItem");
			ItemRegistry.herbbutterparsnipsItem = new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:herbbutterparsnipsItem");
			ItemRegistry.scallionbakedpotatoItem = new IguanaFoodPam(4, 0.25F, false).setUnlocalizedName("ItemRegistry:scallionbakedpotatoItem");
			ItemRegistry.soymilkItem = new IguanaFoodPam(2, 0.05F, false).setUnlocalizedName("ItemRegistry:soymilkItem");
			ItemRegistry.firmtofuItem = new IguanaFoodPam(2, 0.1F, false).setUnlocalizedName("ItemRegistry:firmtofuItem");
			ItemRegistry.silkentofuItem = new IguanaFoodPam(3, 0.15F, false).setUnlocalizedName("ItemRegistry:silkentofuItem");
			
			Utils.replace(ItemRegistry.toastItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:toastItem"));
			Utils.replace(ItemRegistry.cheeseItem, new IguanaFoodPam(1, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cheeseItem"));
			Utils.replace(ItemRegistry.icecreamItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:icecreamItem"));
			Utils.replace(ItemRegistry.grilledcheeseItem, new IguanaFoodPam(7, 0.5F, false, true).setUnlocalizedName("ItemRegistry:grilledcheeseItem"));
			Utils.replace(ItemRegistry.applejuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:applejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.applesauceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:applesauceItem"));
			Utils.replace(ItemRegistry.applepieItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:applepieItem"));
			Utils.replace(ItemRegistry.caramelappleItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:caramelappleItem"));
			Utils.replace(ItemRegistry.pumpkinbreadItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pumpkinbreadItem"));
			Utils.replace(ItemRegistry.roastedpumpkinseedsItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:roastedpumpkinseedsItem"));
			Utils.replace(ItemRegistry.pumpkinsoupItem, new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pumpkinsoupItem"));
			Utils.replace(ItemRegistry.melonjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:melonjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.melonsmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:melonsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.carrotjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:carrotjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.carrotcakeItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:carrotcakeItem"));
			Utils.replace(ItemRegistry.carrotsoupItem, new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:carrotsoupItem"));
			Utils.replace(ItemRegistry.glazedcarrotsItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:glazedcarrotsItem"));
			Utils.replace(ItemRegistry.butteredpotatoItem, new IguanaFoodPam(4, 0.35F, false, true).setUnlocalizedName("ItemRegistry:butteredpotatoItem"));
			Utils.replace(ItemRegistry.loadedbakedpotatoItem, new IguanaFoodPam(8, 0.6F, false, true).setUnlocalizedName("ItemRegistry:loadedbakedpotatoItem"));
			Utils.replace(ItemRegistry.mashedpotatoesItem, new IguanaFoodPam(5, 0.4F, false, true).setUnlocalizedName("ItemRegistry:mashedpotatoesItem"));
			Utils.replace(ItemRegistry.potatosaladItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:potatosaladItem"));
			Utils.replace(ItemRegistry.potatosoupItem, new IguanaFoodPam(4, 0.1F, false, true).setUnlocalizedName("ItemRegistry:potatosoupItem"));
			Utils.replace(ItemRegistry.friesItem, new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:friesItem"));
			Utils.replace(ItemRegistry.grilledmushroomItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:grilledmushroomItem"));
			Utils.replace(ItemRegistry.stuffedmushroomItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:stuffedmushroomItem"));
			Utils.replace(ItemRegistry.chickensandwichItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:chickensandwichItem"));
			Utils.replace(ItemRegistry.chickennoodlesoupItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chickennoodlesoupItem"));
			Utils.replace(ItemRegistry.chickenpotpieItem, new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:chickenpotpieItem"));
			Utils.replace(ItemRegistry.breadedporkchopItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:breadedporkchopItem"));
			Utils.replace(ItemRegistry.hotdogItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:hotdogItem"));
			Utils.replace(ItemRegistry.bakedhamItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedhamItem"));
			Utils.replace(ItemRegistry.hamburgerItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:hamburgerItem"));
			Utils.replace(ItemRegistry.cheeseburgerItem, new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:cheeseburgerItem"));
			Utils.replace(ItemRegistry.baconcheeseburgerItem, new IguanaFoodPam(9, 0.6F, false, true).setUnlocalizedName("ItemRegistry:baconcheeseburgerItem"));
			Utils.replace(ItemRegistry.potroastItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:potroastItem"));
			Utils.replace(ItemRegistry.fishsandwichItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:fishsandwichItem"));
			Utils.replace(ItemRegistry.fishsticksItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:fishsticksItem"));
			Utils.replace(ItemRegistry.fishandchipsItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:fishandchipsItem"));
			Utils.replace(ItemRegistry.friedeggItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:friedeggItem"));
			Utils.replace(ItemRegistry.scrambledeggItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:scrambledeggItem"));
			Utils.replace(ItemRegistry.boiledeggItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:boiledeggItem"));
			Utils.replace(ItemRegistry.eggsaladItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:eggsaladItem"));
			Utils.replace(ItemRegistry.caramelItem, new IguanaFoodPam(1, 0.1F, false, true).setUnlocalizedName("ItemRegistry:caramelItem"));
			Utils.replace(ItemRegistry.taffyItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:taffyItem"));
			Utils.replace(ItemRegistry.spidereyesoupItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:spidereyesoupItem"));
			Utils.replace(ItemRegistry.zombiejerkyItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:zombiejerkyItem"));
			Utils.replace(ItemRegistry.chocolatebarItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolatebarItem"));
			Utils.replace(ItemRegistry.hotchocolateItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:hotchocolateItem"));
			Utils.replace(ItemRegistry.chocolateicecreamItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolateicecreamItem"));
			Utils.replace(ItemRegistry.vegetablesoupItem, new IguanaFoodPam(6, 0.25F, false, true).setUnlocalizedName("ItemRegistry:vegetablesoupItem"));
			Utils.replace(ItemRegistry.stockItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:stockItem"));
			Utils.replace(ItemRegistry.fruitsaladItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:fruitsaladItem"));
			Utils.replace(ItemRegistry.spagettiItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:spagettiItem"));
			Utils.replace(ItemRegistry.spagettiandmeatballsItem, new IguanaFoodPam(10, 0.5F, false, true).setUnlocalizedName("ItemRegistry:spagettiandmeatballsItem"));
			Utils.replace(ItemRegistry.tomatosoupItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:tomatosoupItem"));
			Utils.replace(ItemRegistry.chickenparmasanItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:chickenparmasanItem"));
			Utils.replace(ItemRegistry.pizzaItem, new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:pizzaItem"));
			Utils.replace(ItemRegistry.springsaladItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:springsaladItem"));
			Utils.replace(ItemRegistry.porklettucewrapItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:porklettucewrapItem"));
			Utils.replace(ItemRegistry.fishlettucewrapItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:fishlettucewrapItem"));
			Utils.replace(ItemRegistry.bltItem, new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:bltItem"));
			Utils.replace(ItemRegistry.leafychickensandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:leafychickensandwichItem"));
			Utils.replace(ItemRegistry.leafyfishsandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:leafyfishsandwichItem"));
			Utils.replace(ItemRegistry.deluxecheeseburgerItem, new IguanaFoodPam(10, 0.6F, false, true).setUnlocalizedName("ItemRegistry:deluxecheeseburgerItem"));
			Utils.replace(ItemRegistry.delightedmealItem, new IguanaFoodPam(16, 0.8F, false, true).setUnlocalizedName("ItemRegistry:delightedmealItem"));
			Utils.replace(ItemRegistry.onionsoupItem, new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:onionsoupItem"));
			Utils.replace(ItemRegistry.potatocakesItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:potatocakesItem"));
			Utils.replace(ItemRegistry.hashItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:hashItem"));
			Utils.replace(ItemRegistry.braisedonionsItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:braisedonionsItem"));
			Utils.replace(ItemRegistry.heartybreakfastItem, new IguanaFoodPam(15, 0.8F, false, true).setUnlocalizedName("ItemRegistry:heartybreakfastItem"));
			Utils.replace(ItemRegistry.cornonthecobItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:cornonthecobItem"));
			Utils.replace(ItemRegistry.cornbreadItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cornbreadItem"));
			Utils.replace(ItemRegistry.tortillaItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:tortillaItem"));
			Utils.replace(ItemRegistry.nachoesItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:nachoesItem"));
			Utils.replace(ItemRegistry.tacoItem, new IguanaFoodPam(8, 0.4F, false, true).setUnlocalizedName("ItemRegistry:tacoItem"));
			Utils.replace(ItemRegistry.fishtacoItem, new IguanaFoodPam(8, 0.4F, false, true).setUnlocalizedName("ItemRegistry:fishtacoItem"));
			Utils.replace(ItemRegistry.creamedcornItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:creamedcornItem"));
			Utils.replace(ItemRegistry.strawberrysmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:strawberrysmoothieItem"));
			Utils.replace(ItemRegistry.strawberrypieItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:strawberrypieItem"));
			Utils.replace(ItemRegistry.strawberrysaladItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:strawberrysaladItem"));
			Utils.replace(ItemRegistry.strawberryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:strawberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.chocolatestrawberryItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolatestrawberryItem"));
			Utils.replace(ItemRegistry.peanutbutterItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peanutbutterItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.trailmixItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:trailmixItem"));
			Utils.replace(ItemRegistry.pbandjItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:pbandjItem"));
			Utils.replace(ItemRegistry.peanutbuttercookiesItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:peanutbuttercookiesItem"));
			Utils.replace(ItemRegistry.grapejuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:grapejuiceItem"));
			Utils.replace(ItemRegistry.grapejellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:grapejellyItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.grapesaladItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:grapesaladItem"));
			Utils.replace(ItemRegistry.raisincookiesItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:raisincookiesItem"));
			Utils.replace(ItemRegistry.picklesItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:picklesItem"));
			Utils.replace(ItemRegistry.cucumbersaladItem, new IguanaFoodPam(5, 0.2F, false, true).setUnlocalizedName("ItemRegistry:cucumbersaladItem"));
			Utils.replace(ItemRegistry.cucumbersoupItem, new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:cucumbersoupItem"));
			Utils.replace(ItemRegistry.vegetarianlettucewrapItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:vegetarianlettucewrapItem"));
			Utils.replace(ItemRegistry.marinatedcucumbersItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:marinatedcucumbersItem"));
			Utils.replace(ItemRegistry.ricesoupItem, new IguanaFoodPam(5, 0.2F, false, true).setUnlocalizedName("ItemRegistry:ricesoupItem"));
			Utils.replace(ItemRegistry.friedriceItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:friedriceItem"));
			Utils.replace(ItemRegistry.mushroomrisottoItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:mushroomrisottoItem"));
			Utils.replace(ItemRegistry.curryItem, new IguanaFoodPam(10, 0.55F, false, true).setUnlocalizedName("ItemRegistry:curryItem"));
			Utils.replace(ItemRegistry.rainbowcurryItem, new IguanaFoodPam(13, 0.7F, false, true).setUnlocalizedName("ItemRegistry:rainbowcurryItem"));
			Utils.replace(ItemRegistry.refriedbeansItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:refriedbeansItem"));
			Utils.replace(ItemRegistry.bakedbeansItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedbeansItem"));
			Utils.replace(ItemRegistry.beansandriceItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:beansandriceItem"));
			Utils.replace(ItemRegistry.chiliItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chiliItem"));
			Utils.replace(ItemRegistry.beanburritoItem, new IguanaFoodPam(8, 0.5F, false, true).setUnlocalizedName("ItemRegistry:beanburritoItem"));
			Utils.replace(ItemRegistry.stuffedpepperItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:stuffedpepperItem"));
			Utils.replace(ItemRegistry.veggiestirfryItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:veggiestirfryItem"));
			Utils.replace(ItemRegistry.grilledskewersItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:grilledskewersItem"));
			Utils.replace(ItemRegistry.supremepizzaItem, new IguanaFoodPam(12, 0.7F, false, true).setUnlocalizedName("ItemRegistry:supremepizzaItem"));
			Utils.replace(ItemRegistry.omeletItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:omeletItem"));
			Utils.replace(ItemRegistry.hotwingsItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:hotwingsItem"));
			Utils.replace(ItemRegistry.chilipoppersItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:chilipoppersItem"));
			Utils.replace(ItemRegistry.extremechiliItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:extremechiliItem"));
			Utils.replace(ItemRegistry.chilichocolateItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chilichocolateItem"));
			Utils.replace(ItemRegistry.lemonaideItem, new IguanaFoodPam(1, 0.0F, false, true).setUnlocalizedName("ItemRegistry:lemonaideItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.lemonbarItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonbarItem"));
			Utils.replace(ItemRegistry.fishdinnerItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:fishdinnerItem"));
			Utils.replace(ItemRegistry.lemonsmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.lemonmeringueItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:lemonmeringueItem"));
			Utils.replace(ItemRegistry.candiedlemonItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:candiedlemonItem"));
			Utils.replace(ItemRegistry.lemonchickenItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:lemonchickenItem"));
			Utils.replace(ItemRegistry.blueberrysmoothieItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blueberrysmoothieItem"));
			Utils.replace(ItemRegistry.blueberrypieItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:blueberrypieItem"));
			Utils.replace(ItemRegistry.blueberrymuffinItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:blueberrymuffinItem"));
			Utils.replace(ItemRegistry.blueberryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blueberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pancakesItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:pancakesItem"));
			Utils.replace(ItemRegistry.blueberrypancakesItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:blueberrypancakesItem"));
			Utils.replace(ItemRegistry.cherryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cherryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cherrypieItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:cherrypieItem"));
			Utils.replace(ItemRegistry.chocolatecherryItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:chocolatecherryItem"));
			Utils.replace(ItemRegistry.cherrysmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cherrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cheesecakeItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:cheesecakeItem"));
			Utils.replace(ItemRegistry.cherrycheesecakeItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:cherrycheesecakeItem"));
			Utils.replace(ItemRegistry.stuffedeggplantItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:stuffedeggplantItem"));
			Utils.replace(ItemRegistry.eggplantparmItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:eggplantparmItem"));
			Utils.replace(ItemRegistry.raspberryicedteaItem, new IguanaFoodPam(1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:raspberryicedteaItem"));
			Utils.replace(ItemRegistry.chaiteaItem, new IguanaFoodPam(0, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:chaiteaItem"));
			Utils.replace(ItemRegistry.espressoItem, new IguanaFoodPam(1, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("ItemRegistry:espressoItem"));
			Utils.replace(ItemRegistry.coffeeconlecheItem, new IguanaFoodPam(2, 0.05F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:coffeeconlecheItem"));
			Utils.replace(ItemRegistry.mochaicecreamItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mochaicecreamItem"));
			Utils.replace(ItemRegistry.pickledbeetsItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pickledbeetsItem"));
			Utils.replace(ItemRegistry.beetsaladItem, new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:beetsaladItem"));
			Utils.replace(ItemRegistry.beetsoupItem, new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:beetsoupItem"));
			Utils.replace(ItemRegistry.bakedbeetsItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:bakedbeetsItem"));
			Utils.replace(ItemRegistry.broccolimacItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:broccolimacItem"));
			Utils.replace(ItemRegistry.broccolindipItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:broccolindipItem"));
			Utils.replace(ItemRegistry.creamedbroccolisoupItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:creamedbroccolisoupItem"));
			Utils.replace(ItemRegistry.sweetpotatopieItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:sweetpotatopieItem"));
			Utils.replace(ItemRegistry.candiedsweetpotatoesItem, new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:candiedsweetpotatoesItem"));
			Utils.replace(ItemRegistry.mashedsweetpotatoesItem, new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:mashedsweetpotatoesItem"));
			Utils.replace(ItemRegistry.steamedpeasItem, new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:steamedpeasItem"));
			Utils.replace(ItemRegistry.splitpeasoupItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:splitpeasoupItem"));
			Utils.replace(ItemRegistry.pineappleupsidedowncakeItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pineappleupsidedowncakeItem"));
			Utils.replace(ItemRegistry.pineapplehamItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:pineapplehamItem"));
			Utils.replace(ItemRegistry.pineappleyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pineappleyogurtItem"));
			Utils.replace(ItemRegistry.turnipsoupItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:turnipsoupItem"));
			Utils.replace(ItemRegistry.roastedrootveggiemedleyItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:roastedrootveggiemedleyItem"));
			Utils.replace(ItemRegistry.bakedturnipsItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:bakedturnipsItem"));
			Utils.replace(ItemRegistry.gingerbreadItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:gingerbreadItem"));
			Utils.replace(ItemRegistry.gingersnapsItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:gingersnapsItem"));
			Utils.replace(ItemRegistry.candiedgingerItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:candiedgingerItem"));
			Utils.replace(ItemRegistry.softpretzelandmustardItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:softpretzelandmustardItem"));
			Utils.replace(ItemRegistry.spicymustardporkItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:spicymustardporkItem"));
			Utils.replace(ItemRegistry.spicygreensItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:spicygreensItem"));
			Utils.replace(ItemRegistry.garlicbreadItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:garlicbreadItem"));
			Utils.replace(ItemRegistry.garlicmashedpotatoesItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:garlicmashedpotatoesItem"));
			Utils.replace(ItemRegistry.garlicchickenItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:garlicchickenItem"));
			Utils.replace(ItemRegistry.summerradishsaladItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:summerradishsaladItem"));
			Utils.replace(ItemRegistry.summersquashwithradishItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:summersquashwithradishItem"));
			Utils.replace(ItemRegistry.celeryandpeanutbutterItem, new IguanaFoodPam(3, 0.15F, false, true).setUnlocalizedName("ItemRegistry:celeryandpeanutbutterItem"));
			Utils.replace(ItemRegistry.chickencelerycasseroleItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:chickencelerycasseroleItem"));
			Utils.replace(ItemRegistry.peasandceleryItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:peasandceleryItem"));
			Utils.replace(ItemRegistry.celerysoupItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:celerysoupItem"));
			Utils.replace(ItemRegistry.zucchinibreadItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:zucchinibreadItem"));
			Utils.replace(ItemRegistry.zucchinifriesItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:zucchinifriesItem"));
			Utils.replace(ItemRegistry.zestyzucchiniItem, new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:zestyzucchiniItem"));
			Utils.replace(ItemRegistry.zucchinibakeItem, new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:zucchinibakeItem"));
			Utils.replace(ItemRegistry.asparagusquicheItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:asparagusquicheItem"));
			Utils.replace(ItemRegistry.asparagussoupItem, new IguanaFoodPam(4, 0.15F, false, true).setUnlocalizedName("ItemRegistry:asparagussoupItem"));
			Utils.replace(ItemRegistry.walnutraisinbreadItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:walnutraisinbreadItem"));
			Utils.replace(ItemRegistry.candiedwalnutsItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:candiedwalnutsItem"));
			Utils.replace(ItemRegistry.brownieItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:brownieItem"));
			Utils.replace(ItemRegistry.papayajuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:papayajuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.papayasmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayasmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.papayayogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayayogurtItem"));
			Utils.replace(ItemRegistry.starfruitjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:starfruitjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.starfruitsmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruitsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.starfruityogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruityogurtItem"));
			Utils.replace(ItemRegistry.guacamoleItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:guacamoleItem"));
			Utils.replace(ItemRegistry.creamofavocadosoupItem, new IguanaFoodPam(6, 0.25F, false, true).setUnlocalizedName("ItemRegistry:creamofavocadosoupItem"));
			Utils.replace(ItemRegistry.avocadoburritoItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:avocadoburritoItem"));
			Utils.replace(ItemRegistry.poachedpearItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:poachedpearItem"));
			Utils.replace(ItemRegistry.fruitcrumbleItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:fruitcrumbleItem"));
			Utils.replace(ItemRegistry.pearyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pearyogurtItem"));
			Utils.replace(ItemRegistry.plumyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:plumyogurtItem"));
			Utils.replace(ItemRegistry.bananasplitItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:bananasplitItem"));
			Utils.replace(ItemRegistry.banananutbreadItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:banananutbreadItem"));
			Utils.replace(ItemRegistry.bananasmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:bananasmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.bananayogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:bananayogurtItem"));
			Utils.replace(ItemRegistry.coconutmilkItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:coconutmilkItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.chickencurryItem, new IguanaFoodPam(9, 0.5F, false, true).setUnlocalizedName("ItemRegistry:chickencurryItem"));
			Utils.replace(ItemRegistry.coconutshrimpItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:coconutshrimpItem"));
			Utils.replace(ItemRegistry.coconutyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:coconutyogurtItem"));
			Utils.replace(ItemRegistry.orangejuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:orangejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.orangechickenItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:orangechickenItem"));
			Utils.replace(ItemRegistry.orangesmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.orangeyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangeyogurtItem"));
			Utils.replace(ItemRegistry.peachjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:peachjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.peachcobblerItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:peachcobblerItem"));
			Utils.replace(ItemRegistry.peachsmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.peachyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachyogurtItem"));
			Utils.replace(ItemRegistry.limejuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:limejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.keylimepieItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:keylimepieItem"));
			Utils.replace(ItemRegistry.limesmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.limeyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limeyogurtItem"));
			Utils.replace(ItemRegistry.mangojuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:mangojuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.mangosmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangosmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.mangoyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangoyogurtItem"));
			Utils.replace(ItemRegistry.pomegranatejuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pomegranatesmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranatesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pomegranateyogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranateyogurtItem"));
			Utils.replace(ItemRegistry.vanillayogurtItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:vanillayogurtItem"));
			Utils.replace(ItemRegistry.cinnamonrollItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cinnamonrollItem"));
			Utils.replace(ItemRegistry.frenchtoastItem, new IguanaFoodPam(7, 0.4F, false, true).setUnlocalizedName("ItemRegistry:frenchtoastItem"));
			Utils.replace(ItemRegistry.marshmellowsItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:marshmellowsItem"));
			Utils.replace(ItemRegistry.donutItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:donutItem"));
			Utils.replace(ItemRegistry.chocolatedonutItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:chocolatedonutItem"));
			Utils.replace(ItemRegistry.powdereddonutItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:powdereddonutItem"));
			Utils.replace(ItemRegistry.jellydonutItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:jellydonutItem"));
			Utils.replace(ItemRegistry.frosteddonutItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:frosteddonutItem"));
			Utils.replace(ItemRegistry.cactussoupItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cactussoupItem"));
			Utils.replace(ItemRegistry.wafflesItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:wafflesItem"));
			Utils.replace(ItemRegistry.seedsoupItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:seedsoupItem"));
			Utils.replace(ItemRegistry.softpretzelItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:softpretzelItem"));
			Utils.replace(ItemRegistry.jellybeansItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:jellybeansItem"));
			Utils.replace(ItemRegistry.biscuitItem, new IguanaFoodPam(4, 0.25F, false, true).setUnlocalizedName("ItemRegistry:biscuitItem"));
			Utils.replace(ItemRegistry.creamcookieItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:creamcookieItem"));
			Utils.replace(ItemRegistry.jaffaItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:jaffaItem"));
			Utils.replace(ItemRegistry.friedchickenItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:friedchickenItem"));
			Utils.replace(ItemRegistry.chocolatesprinklecakeItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:chocolatesprinklecakeItem"));
			Utils.replace(ItemRegistry.redvelvetcakeItem, new IguanaFoodPam(7, 0.35F, false, true).setUnlocalizedName("ItemRegistry:redvelvetcakeItem"));
			Utils.replace(ItemRegistry.footlongItem, new IguanaFoodPam(9, 0.55F, false, true).setUnlocalizedName("ItemRegistry:footlongItem"));
			Utils.replace(ItemRegistry.blueberryyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blueberryyogurtItem"));
			Utils.replace(ItemRegistry.lemonyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:lemonyogurtItem"));
			Utils.replace(ItemRegistry.cherryyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cherryyogurtItem"));
			Utils.replace(ItemRegistry.strawberryyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:strawberryyogurtItem"));
			Utils.replace(ItemRegistry.grapeyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:grapeyogurtItem"));
			Utils.replace(ItemRegistry.chocolateyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolateyogurtItem"));
			Utils.replace(ItemRegistry.blackberryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blackberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.blackberrycobblerItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:blackberrycobblerItem"));
			Utils.replace(ItemRegistry.blackberrysmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blackberrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.blackberryyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:blackberryyogurtItem"));
			Utils.replace(ItemRegistry.chocolatemilkItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:chocolatemilkItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pumpkinyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:pumpkinyogurtItem"));
			Utils.replace(ItemRegistry.raspberryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:raspberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.raspberrypieItem, new IguanaFoodPam(6, 0.35F, false, true).setUnlocalizedName("ItemRegistry:raspberrypieItem"));
			Utils.replace(ItemRegistry.raspberrysmoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:raspberrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.raspberryyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:raspberryyogurtItem"));
			Utils.replace(ItemRegistry.cinnamonsugardonutItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cinnamonsugardonutItem"));
			Utils.replace(ItemRegistry.melonyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:melonyogurtItem"));
			Utils.replace(ItemRegistry.kiwijuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:kiwijuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.kiwismoothieItem, new IguanaFoodPam(3, 0.1F, false, true).setUnlocalizedName("ItemRegistry:kiwismoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.kiwiyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:kiwiyogurtItem"));
			Utils.replace(ItemRegistry.plainyogurtItem, new IguanaFoodPam(1, 0.0F, false, true).setUnlocalizedName("ItemRegistry:plainyogurtItem"));
			Utils.replace(ItemRegistry.appleyogurtItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:appleyogurtItem"));
			Utils.replace(ItemRegistry.saltedsunflowerseedsItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:saltedsunflowerseedsItem"));
			Utils.replace(ItemRegistry.sunflowerwheatrollsItem, new IguanaFoodPam(6, 0.3F, false, true).setUnlocalizedName("ItemRegistry:sunflowerwheatrollsItem"));
			Utils.replace(ItemRegistry.sunflowerbroccolisaladItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:sunflowerbroccolisaladItem"));
			Utils.replace(ItemRegistry.cranberryjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cranberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cranberrysauceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cranberrysauceItem"));
			Utils.replace(ItemRegistry.cranberrybarItem, new IguanaFoodPam(5, 0.3F, false, true).setUnlocalizedName("ItemRegistry:cranberrybarItem"));
			Utils.replace(ItemRegistry.peppermintItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:peppermintItem"));
			Utils.replace(ItemRegistry.cactusfruitjuiceItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:cactusfruitjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.baklavaItem, new IguanaFoodPam(7, 0.45F, false, true).setUnlocalizedName("ItemRegistry:baklavaItem"));
			Utils.replace(ItemRegistry.gummybearsItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:gummybearsItem"));
			Utils.replace(ItemRegistry.baconmushroomburgerItem, new IguanaFoodPam(10, 0.65F, false, true).setUnlocalizedName("ItemRegistry:baconmushroomburgerItem"));
			Utils.replace(ItemRegistry.fruitpunchItem, new IguanaFoodPam(2, 0.05F, false, true).setUnlocalizedName("ItemRegistry:fruitpunchItem"));
			Utils.replace(ItemRegistry.meatystewItem, new IguanaFoodPam(6, 0.45F, false, true).setUnlocalizedName("ItemRegistry:meatystewItem"));
			Utils.replace(ItemRegistry.mixedsaladItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:mixedsaladItem"));
			Utils.replace(ItemRegistry.pinacoladaItem, new IguanaFoodPam(2, 0.15F, false, true).setUnlocalizedName("ItemRegistry:pinacoladaItem"));
			Utils.replace(ItemRegistry.shepardspieItem, new IguanaFoodPam(6, 0.4F, false, true).setUnlocalizedName("ItemRegistry:shepardspieItem"));
			Utils.replace(ItemRegistry.eggnogItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:eggnogItem"));
			Utils.replace(ItemRegistry.custardItem, new IguanaFoodPam(5, 0.25F, false, true).setUnlocalizedName("ItemRegistry:custardItem"));
			Utils.replace(ItemRegistry.sushiItem, new IguanaFoodPam(3, 0.2F, false, true).setUnlocalizedName("ItemRegistry:sushiItem"));
			Utils.replace(ItemRegistry.gardensoupItem, new IguanaFoodPam(4, 0.2F, false, true).setUnlocalizedName("ItemRegistry:gardensoupItem"));
			Utils.replace(ItemRegistry.muttonrawItem, new IguanaFoodPam(1, 0.05F, true, true).setUnlocalizedName("ItemRegistry:muttonrawItem"));
			Utils.replace(ItemRegistry.muttoncookedItem, new IguanaFoodPam(2, 0.1F, true, true).setUnlocalizedName("ItemRegistry:muttoncookedItem"));
			Utils.replace(ItemRegistry.calamarirawItem, new IguanaFoodPam(1, 0.05F, false, true).setUnlocalizedName("ItemRegistry:calamarirawItem"));
			Utils.replace(ItemRegistry.calamaricookedItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:calamaricookedItem"));
			Utils.replace(ItemRegistry.applejellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:applejellyItem"));
			Utils.replace(ItemRegistry.applejellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:applejellysandwichItem"));
			Utils.replace(ItemRegistry.blackberryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blackberryjellyItem"));
			Utils.replace(ItemRegistry.blackberryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:blackberryjellysandwichItem"));
			Utils.replace(ItemRegistry.blueberryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:blueberryjellyItem"));
			Utils.replace(ItemRegistry.blueberryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:blueberryjellysandwichItem"));
			Utils.replace(ItemRegistry.cherryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cherryjellyItem"));
			Utils.replace(ItemRegistry.cherryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:cherryjellysandwichItem"));
			Utils.replace(ItemRegistry.cranberryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:cranberryjellyItem"));
			Utils.replace(ItemRegistry.cranberryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:cranberryjellysandwichItem"));
			Utils.replace(ItemRegistry.kiwijellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:kiwijellyItem"));
			Utils.replace(ItemRegistry.kiwijellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:kiwijellysandwichItem"));
			Utils.replace(ItemRegistry.lemonjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:lemonjellyItem"));
			Utils.replace(ItemRegistry.lemonjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:lemonjellysandwichItem"));
			Utils.replace(ItemRegistry.limejellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:limejellyItem"));
			Utils.replace(ItemRegistry.limejellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:limejellysandwichItem"));
			Utils.replace(ItemRegistry.mangojellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:mangojellyItem"));
			Utils.replace(ItemRegistry.mangojellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:mangojellysandwichItem"));
			Utils.replace(ItemRegistry.orangejellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:orangejellyItem"));
			Utils.replace(ItemRegistry.orangejellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:orangejellysandwichItem"));
			Utils.replace(ItemRegistry.papayajellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:papayajellyItem"));
			Utils.replace(ItemRegistry.papayajellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:papayajellysandwichItem"));
			Utils.replace(ItemRegistry.peachjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:peachjellyItem"));
			Utils.replace(ItemRegistry.peachjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:peachjellysandwichItem"));
			Utils.replace(ItemRegistry.pomegranatejellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejellyItem"));
			Utils.replace(ItemRegistry.pomegranatejellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:pomegranatejellysandwichItem"));
			Utils.replace(ItemRegistry.raspberryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:raspberryjellyItem"));
			Utils.replace(ItemRegistry.raspberryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:raspberryjellysandwichItem"));
			Utils.replace(ItemRegistry.starfruitjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:starfruitjellyItem"));
			Utils.replace(ItemRegistry.starfruitjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:starfruitjellysandwichItem"));
			Utils.replace(ItemRegistry.strawberryjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:strawberryjellyItem"));
			Utils.replace(ItemRegistry.strawberryjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:strawberryjellysandwichItem"));
			Utils.replace(ItemRegistry.watermelonjellyItem, new IguanaFoodPam(2, 0.1F, false, true).setUnlocalizedName("ItemRegistry:watermelonjellyItem"));
			Utils.replace(ItemRegistry.watermelonjellysandwichItem, new IguanaFoodPam(8, 0.45F, false, true).setUnlocalizedName("ItemRegistry:watermelonjellysandwichItem"));

			Utils.replace(ItemRegistry.cherrysodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:cherrysodaItem"));
			Utils.replace(ItemRegistry.colasodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:colasodaItem"));
			Utils.replace(ItemRegistry.gingersodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:gingersodaItem"));
			Utils.replace(ItemRegistry.grapesodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:grapesodaItem"));
			Utils.replace(ItemRegistry.lemonlimesodaItem, new IguanaFoodPamPotion(3, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:lemonlimesodaItem"));
			Utils.replace(ItemRegistry.orangesodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:orangesodaItem"));
			Utils.replace(ItemRegistry.rootbeersodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:rootbeersodaItem"));
			Utils.replace(ItemRegistry.strawberrysodaItem, new IguanaFoodPamPotion(2, 0.05F, false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:strawberrysodaItem"));

			Utils.replace(ItemRegistry.caramelicecreamItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:caramelicecreamItem"));
			Utils.replace(ItemRegistry.mintchocolatechipicemcreamItem, new IguanaFoodPam(5, 0.25F, false).setUnlocalizedName("ItemRegistry:mintchocolatechipicecreamItem"));
			Utils.replace(ItemRegistry.strawberryicecreamItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:strawberryicecreamItem"));
			Utils.replace(ItemRegistry.vanillaicecreamItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:vanillaicecreamItem"));

			Utils.replace(ItemRegistry.ediblerootItem, new ItemSeedFood(1, 0.1F, BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ediblerootItem"));

			Utils.replace(ItemRegistry.gingerchickenItem, new IguanaFoodPam(6, 0.35F, false).setUnlocalizedName("ItemRegistry:gingerchickenItem"));

			Utils.replace(ItemRegistry.oldworldveggiesoupItem, new IguanaFoodPam(4, 0.15F, false).setUnlocalizedName("ItemRegistry:oldworldveggiesoupItem"));
			Utils.replace(ItemRegistry.spicebunItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:spicebunItem"));
			Utils.replace(ItemRegistry.gingeredrhubarbtartItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:gingeredrhubarbtartItem"));
			Utils.replace(ItemRegistry.lambbarleysoupItem, new IguanaFoodPam(5, 0.2F, false).setUnlocalizedName("ItemRegistry:lambbarleysoupItem"));
			Utils.replace(ItemRegistry.honeylemonlambItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:honeylemonlambItem"));
			Utils.replace(ItemRegistry.pumpkinoatsconesItem, new IguanaFoodPam(3, 0.15F, false).setUnlocalizedName("ItemRegistry:pumpkinoatsconesItem"));
			Utils.replace(ItemRegistry.beefjerkyItem, new IguanaFoodPam(3, 0.2F, false).setUnlocalizedName("ItemRegistry:beefjerkyItem"));
			Utils.replace(ItemRegistry.plumjuiceItem, new IguanaFoodPam(2, 0.15F, false).setUnlocalizedName("ItemRegistry:plumjuiceItem"));
			Utils.replace(ItemRegistry.pearjuiceItem, new IguanaFoodPam(2, 0.15F, false).setUnlocalizedName("ItemRegistry:pearjuiceItem"));
			Utils.replace(ItemRegistry.ovenroastedcauliflowerItem, new IguanaFoodPam(5, 0.25F, false).setUnlocalizedName("ItemRegistry:ovenroastedcauliflowerItem"));
			Utils.replace(ItemRegistry.leekbaconsoupItem, new IguanaFoodPam(4, 0.15F, false).setUnlocalizedName("ItemRegistry:leekbaconsoupItem"));
			Utils.replace(ItemRegistry.herbbutterparsnipsItem, new IguanaFoodPam(4, 0.2F, false).setUnlocalizedName("ItemRegistry:herbbutterparsnipsItem"));
			Utils.replace(ItemRegistry.scallionbakedpotatoItem, new IguanaFoodPam(4, 0.25F, false).setUnlocalizedName("ItemRegistry:scallionbakedpotatoItem"));
			Utils.replace(ItemRegistry.soymilkItem, new IguanaFoodPam(2, 0.05F, false).setUnlocalizedName("ItemRegistry:soymilkItem"));
			Utils.replace(ItemRegistry.firmtofuItem, new IguanaFoodPam(2, 0.1F, false).setUnlocalizedName("ItemRegistry:firmtofuItem"));
			Utils.replace(ItemRegistry.silkentofuItem, new IguanaFoodPam(3, 0.15F, false).setUnlocalizedName("ItemRegistry:silkentofuItem"));

		} else {

			ItemRegistry.toastItem = new IguanaFoodPam(((ItemFood)ItemRegistry.toastItem).func_150905_g(null), ((ItemFood)ItemRegistry.toastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:toastItem");
			ItemRegistry.cheeseItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cheeseItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheeseItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheeseItem");
			ItemRegistry.icecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.icecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.icecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:icecreamItem");
			ItemRegistry.grilledcheeseItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grilledcheeseItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledcheeseItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledcheeseItem");
			ItemRegistry.applejuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.applejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:applejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.applesauceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.applesauceItem).func_150905_g(null), ((ItemFood)ItemRegistry.applesauceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applesauceItem");
			ItemRegistry.applepieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.applepieItem).func_150905_g(null), ((ItemFood)ItemRegistry.applepieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applepieItem");
			ItemRegistry.caramelappleItem = new IguanaFoodPam(((ItemFood)ItemRegistry.caramelappleItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelappleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:caramelappleItem");
			ItemRegistry.pumpkinbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinbreadItem");
			ItemRegistry.roastedpumpkinseedsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.roastedpumpkinseedsItem).func_150905_g(null), ((ItemFood)ItemRegistry.roastedpumpkinseedsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:roastedpumpkinseedsItem");
			ItemRegistry.pumpkinsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinsoupItem");
			ItemRegistry.melonjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.melonjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonjuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:melonjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.melonsmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.melonsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:melonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.carrotjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotjuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:carrotjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotcakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.carrotcakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotcakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:carrotcakeItem");
			ItemRegistry.carrotsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.carrotsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:carrotsoupItem");
			ItemRegistry.glazedcarrotsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.glazedcarrotsItem).func_150905_g(null), ((ItemFood)ItemRegistry.glazedcarrotsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:glazedcarrotsItem");
			ItemRegistry.butteredpotatoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.butteredpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.butteredpotatoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:butteredpotatoItem");
			ItemRegistry.loadedbakedpotatoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.loadedbakedpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.loadedbakedpotatoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:loadedbakedpotatoItem");
			ItemRegistry.mashedpotatoesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mashedpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.mashedpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mashedpotatoesItem");
			ItemRegistry.potatosaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.potatosaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatosaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatosaladItem");
			ItemRegistry.potatosoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.potatosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatosoupItem");
			ItemRegistry.friesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.friesItem).func_150905_g(null), ((ItemFood)ItemRegistry.friesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friesItem");
			ItemRegistry.grilledmushroomItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grilledmushroomItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledmushroomItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledmushroomItem");
			ItemRegistry.stuffedmushroomItem = new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedmushroomItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedmushroomItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedmushroomItem");
			ItemRegistry.chickensandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickensandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickensandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickensandwichItem");
			ItemRegistry.chickennoodlesoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickennoodlesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickennoodlesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickennoodlesoupItem");
			ItemRegistry.chickenpotpieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickenpotpieItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickenpotpieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickenpotpieItem");
			ItemRegistry.breadedporkchopItem = new IguanaFoodPam(((ItemFood)ItemRegistry.breadedporkchopItem).func_150905_g(null), ((ItemFood)ItemRegistry.breadedporkchopItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:breadedporkchopItem");
			ItemRegistry.hotdogItem = new IguanaFoodPam(((ItemFood)ItemRegistry.hotdogItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotdogItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotdogItem");
			ItemRegistry.bakedhamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bakedhamItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedhamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedhamItem");
			ItemRegistry.hamburgerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.hamburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.hamburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hamburgerItem");
			ItemRegistry.cheeseburgerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheeseburgerItem");
			ItemRegistry.baconcheeseburgerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.baconcheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.baconcheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baconcheeseburgerItem");
			ItemRegistry.potroastItem = new IguanaFoodPam(((ItemFood)ItemRegistry.potroastItem).func_150905_g(null), ((ItemFood)ItemRegistry.potroastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potroastItem");
			ItemRegistry.fishsandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishsandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishsandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishsandwichItem");
			ItemRegistry.fishsticksItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishsticksItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishsticksItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishsticksItem");
			ItemRegistry.fishandchipsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishandchipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishandchipsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishandchipsItem");
			ItemRegistry.friedeggItem = new IguanaFoodPam(((ItemFood)ItemRegistry.friedeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedeggItem");
			ItemRegistry.scrambledeggItem = new IguanaFoodPam(((ItemFood)ItemRegistry.scrambledeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.scrambledeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:scrambledeggItem");
			ItemRegistry.boiledeggItem = new IguanaFoodPam(((ItemFood)ItemRegistry.boiledeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.boiledeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:boiledeggItem");
			ItemRegistry.eggsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.eggsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggsaladItem");
			ItemRegistry.caramelItem = new IguanaFoodPam(((ItemFood)ItemRegistry.caramelItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:caramelItem");
			ItemRegistry.taffyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.taffyItem).func_150905_g(null), ((ItemFood)ItemRegistry.taffyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:taffyItem");
			ItemRegistry.spidereyesoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spidereyesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.spidereyesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spidereyesoupItem");
			ItemRegistry.zombiejerkyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.zombiejerkyItem).func_150905_g(null), ((ItemFood)ItemRegistry.zombiejerkyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zombiejerkyItem");
			ItemRegistry.chocolatebarItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatebarItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatebarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatebarItem");
			ItemRegistry.hotchocolateItem = new IguanaFoodPam(((ItemFood)ItemRegistry.hotchocolateItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotchocolateItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotchocolateItem");
			ItemRegistry.chocolateicecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolateicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolateicecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolateicecreamItem");
			ItemRegistry.vegetablesoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.vegetablesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.vegetablesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vegetablesoupItem");
			ItemRegistry.stockItem = new IguanaFoodPam(((ItemFood)ItemRegistry.stockItem).func_150905_g(null), ((ItemFood)ItemRegistry.stockItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stockItem");
			ItemRegistry.fruitsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fruitsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitsaladItem");
			ItemRegistry.spagettiItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spagettiItem).func_150905_g(null), ((ItemFood)ItemRegistry.spagettiItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spagettiItem");
			ItemRegistry.spagettiandmeatballsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spagettiandmeatballsItem).func_150905_g(null), ((ItemFood)ItemRegistry.spagettiandmeatballsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spagettiandmeatballsItem");
			ItemRegistry.tomatosoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.tomatosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.tomatosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tomatosoupItem");
			ItemRegistry.chickenparmasanItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickenparmasanItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickenparmasanItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickenparmasanItem");
			ItemRegistry.pizzaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pizzaItem).func_150905_g(null), ((ItemFood)ItemRegistry.pizzaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pizzaItem");
			ItemRegistry.springsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.springsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.springsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:springsaladItem");
			ItemRegistry.porklettucewrapItem = new IguanaFoodPam(((ItemFood)ItemRegistry.porklettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.porklettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:porklettucewrapItem");
			ItemRegistry.fishlettucewrapItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishlettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishlettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishlettucewrapItem");
			ItemRegistry.bltItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bltItem).func_150905_g(null), ((ItemFood)ItemRegistry.bltItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bltItem");
			ItemRegistry.leafychickensandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.leafychickensandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.leafychickensandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:leafychickensandwichItem");
			ItemRegistry.leafyfishsandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.leafyfishsandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.leafyfishsandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:leafyfishsandwichItem");
			ItemRegistry.deluxecheeseburgerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.deluxecheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.deluxecheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:deluxecheeseburgerItem");
			ItemRegistry.delightedmealItem = new IguanaFoodPam(((ItemFood)ItemRegistry.delightedmealItem).func_150905_g(null), ((ItemFood)ItemRegistry.delightedmealItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:delightedmealItem");
			ItemRegistry.onionsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.onionsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.onionsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:onionsoupItem");
			ItemRegistry.potatocakesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.potatocakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatocakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatocakesItem");
			ItemRegistry.hashItem = new IguanaFoodPam(((ItemFood)ItemRegistry.hashItem).func_150905_g(null), ((ItemFood)ItemRegistry.hashItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hashItem");
			ItemRegistry.braisedonionsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.braisedonionsItem).func_150905_g(null), ((ItemFood)ItemRegistry.braisedonionsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:braisedonionsItem");
			ItemRegistry.heartybreakfastItem = new IguanaFoodPam(((ItemFood)ItemRegistry.heartybreakfastItem).func_150905_g(null), ((ItemFood)ItemRegistry.heartybreakfastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:heartybreakfastItem");
			ItemRegistry.cornonthecobItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cornonthecobItem).func_150905_g(null), ((ItemFood)ItemRegistry.cornonthecobItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cornonthecobItem");
			ItemRegistry.cornbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cornbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.cornbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cornbreadItem");
			ItemRegistry.tortillaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.tortillaItem).func_150905_g(null), ((ItemFood)ItemRegistry.tortillaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tortillaItem");
			ItemRegistry.nachoesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.nachoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.nachoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:nachoesItem");
			ItemRegistry.tacoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.tacoItem).func_150905_g(null), ((ItemFood)ItemRegistry.tacoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tacoItem");
			ItemRegistry.fishtacoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishtacoItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishtacoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishtacoItem");
			ItemRegistry.creamedcornItem = new IguanaFoodPam(((ItemFood)ItemRegistry.creamedcornItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamedcornItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamedcornItem");
			ItemRegistry.strawberrysmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrysmoothieItem");
			ItemRegistry.strawberrypieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrypieItem");
			ItemRegistry.strawberrysaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrysaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrysaladItem");
			ItemRegistry.strawberryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chocolatestrawberryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatestrawberryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatestrawberryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatestrawberryItem");
			ItemRegistry.peanutbutterItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peanutbutterItem).func_150905_g(null), ((ItemFood)ItemRegistry.peanutbutterItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peanutbutterItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.trailmixItem = new IguanaFoodPam(((ItemFood)ItemRegistry.trailmixItem).func_150905_g(null), ((ItemFood)ItemRegistry.trailmixItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:trailmixItem");
			ItemRegistry.pbandjItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pbandjItem).func_150905_g(null), ((ItemFood)ItemRegistry.pbandjItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pbandjItem");
			ItemRegistry.peanutbuttercookiesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peanutbuttercookiesItem).func_150905_g(null), ((ItemFood)ItemRegistry.peanutbuttercookiesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peanutbuttercookiesItem");
			ItemRegistry.grapejuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grapejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapejuiceItem");
			ItemRegistry.grapejellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grapejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapejellyItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.grapesaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grapesaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapesaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapesaladItem");
			ItemRegistry.raisincookiesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raisincookiesItem).func_150905_g(null), ((ItemFood)ItemRegistry.raisincookiesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raisincookiesItem");
			ItemRegistry.picklesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.picklesItem).func_150905_g(null), ((ItemFood)ItemRegistry.picklesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:picklesItem");
			ItemRegistry.cucumbersaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cucumbersaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.cucumbersaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cucumbersaladItem");
			ItemRegistry.cucumbersoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cucumbersoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.cucumbersoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cucumbersoupItem");
			ItemRegistry.vegetarianlettucewrapItem = new IguanaFoodPam(((ItemFood)ItemRegistry.vegetarianlettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.vegetarianlettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vegetarianlettucewrapItem");
			ItemRegistry.marinatedcucumbersItem = new IguanaFoodPam(((ItemFood)ItemRegistry.marinatedcucumbersItem).func_150905_g(null), ((ItemFood)ItemRegistry.marinatedcucumbersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:marinatedcucumbersItem");
			ItemRegistry.ricesoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.ricesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.ricesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:ricesoupItem");
			ItemRegistry.friedriceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.friedriceItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedriceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedriceItem");
			ItemRegistry.mushroomrisottoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mushroomrisottoItem).func_150905_g(null), ((ItemFood)ItemRegistry.mushroomrisottoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mushroomrisottoItem");
			ItemRegistry.curryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.curryItem).func_150905_g(null), ((ItemFood)ItemRegistry.curryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:curryItem");
			ItemRegistry.rainbowcurryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.rainbowcurryItem).func_150905_g(null), ((ItemFood)ItemRegistry.rainbowcurryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:rainbowcurryItem");
			ItemRegistry.refriedbeansItem = new IguanaFoodPam(((ItemFood)ItemRegistry.refriedbeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.refriedbeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:refriedbeansItem");
			ItemRegistry.bakedbeansItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bakedbeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedbeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedbeansItem");
			ItemRegistry.beansandriceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.beansandriceItem).func_150905_g(null), ((ItemFood)ItemRegistry.beansandriceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beansandriceItem");
			ItemRegistry.chiliItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chiliItem).func_150905_g(null), ((ItemFood)ItemRegistry.chiliItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chiliItem");
			ItemRegistry.beanburritoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.beanburritoItem).func_150905_g(null), ((ItemFood)ItemRegistry.beanburritoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beanburritoItem");
			ItemRegistry.stuffedpepperItem = new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedpepperItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedpepperItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedpepperItem");
			ItemRegistry.veggiestirfryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.veggiestirfryItem).func_150905_g(null), ((ItemFood)ItemRegistry.veggiestirfryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:veggiestirfryItem");
			ItemRegistry.grilledskewersItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grilledskewersItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledskewersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledskewersItem");
			ItemRegistry.supremepizzaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.supremepizzaItem).func_150905_g(null), ((ItemFood)ItemRegistry.supremepizzaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:supremepizzaItem");
			ItemRegistry.omeletItem = new IguanaFoodPam(((ItemFood)ItemRegistry.omeletItem).func_150905_g(null), ((ItemFood)ItemRegistry.omeletItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:omeletItem");
			ItemRegistry.hotwingsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.hotwingsItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotwingsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotwingsItem");
			ItemRegistry.chilipoppersItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chilipoppersItem).func_150905_g(null), ((ItemFood)ItemRegistry.chilipoppersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chilipoppersItem");
			ItemRegistry.extremechiliItem = new IguanaFoodPam(((ItemFood)ItemRegistry.extremechiliItem).func_150905_g(null), ((ItemFood)ItemRegistry.extremechiliItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:extremechiliItem");
			ItemRegistry.chilichocolateItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chilichocolateItem).func_150905_g(null), ((ItemFood)ItemRegistry.chilichocolateItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chilichocolateItem");
			ItemRegistry.lemonaideItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonaideItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonaideItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonaideItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonbarItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonbarItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonbarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonbarItem");
			ItemRegistry.fishdinnerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fishdinnerItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishdinnerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishdinnerItem");
			ItemRegistry.lemonsmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonmeringueItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonmeringueItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonmeringueItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonmeringueItem");
			ItemRegistry.candiedlemonItem = new IguanaFoodPam(((ItemFood)ItemRegistry.candiedlemonItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedlemonItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedlemonItem");
			ItemRegistry.lemonchickenItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonchickenItem");
			ItemRegistry.blueberrysmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrysmoothieItem");
			ItemRegistry.blueberrypieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrypieItem");
			ItemRegistry.blueberrymuffinItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrymuffinItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrymuffinItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrymuffinItem");
			ItemRegistry.blueberryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pancakesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pancakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.pancakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pancakesItem");
			ItemRegistry.blueberrypancakesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrypancakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrypancakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrypancakesItem");
			ItemRegistry.cherryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cherrypieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrypieItem");
			ItemRegistry.chocolatecherryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatecherryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatecherryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatecherryItem");
			ItemRegistry.cherrysmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cheesecakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cheesecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheesecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheesecakeItem");
			ItemRegistry.cherrycheesecakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherrycheesecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrycheesecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrycheesecakeItem");
			ItemRegistry.stuffedeggplantItem = new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedeggplantItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedeggplantItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedeggplantItem");
			ItemRegistry.eggplantparmItem = new IguanaFoodPam(((ItemFood)ItemRegistry.eggplantparmItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggplantparmItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggplantparmItem");
			ItemRegistry.raspberryicedteaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryicedteaItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryicedteaItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:raspberryicedteaItem");
			ItemRegistry.chaiteaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chaiteaItem).func_150905_g(null), ((ItemFood)ItemRegistry.chaiteaItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:chaiteaItem");
			ItemRegistry.espressoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.espressoItem).func_150905_g(null), ((ItemFood)ItemRegistry.espressoItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("ItemRegistry:espressoItem");
			ItemRegistry.coffeeconlecheItem = new IguanaFoodPam(((ItemFood)ItemRegistry.coffeeconlecheItem).func_150905_g(null), ((ItemFood)ItemRegistry.coffeeconlecheItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:coffeeconlecheItem");
			ItemRegistry.mochaicecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mochaicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.mochaicecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mochaicecreamItem");
			ItemRegistry.pickledbeetsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pickledbeetsItem).func_150905_g(null), ((ItemFood)ItemRegistry.pickledbeetsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pickledbeetsItem");
			ItemRegistry.beetsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.beetsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.beetsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beetsaladItem");
			ItemRegistry.beetsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.beetsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.beetsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beetsoupItem");
			ItemRegistry.bakedbeetsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bakedbeetsItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedbeetsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedbeetsItem");
			ItemRegistry.broccolimacItem = new IguanaFoodPam(((ItemFood)ItemRegistry.broccolimacItem).func_150905_g(null), ((ItemFood)ItemRegistry.broccolimacItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:broccolimacItem");
			ItemRegistry.broccolindipItem = new IguanaFoodPam(((ItemFood)ItemRegistry.broccolindipItem).func_150905_g(null), ((ItemFood)ItemRegistry.broccolindipItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:broccolindipItem");
			ItemRegistry.creamedbroccolisoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.creamedbroccolisoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamedbroccolisoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamedbroccolisoupItem");
			ItemRegistry.sweetpotatopieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.sweetpotatopieItem).func_150905_g(null), ((ItemFood)ItemRegistry.sweetpotatopieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sweetpotatopieItem");
			ItemRegistry.candiedsweetpotatoesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.candiedsweetpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedsweetpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedsweetpotatoesItem");
			ItemRegistry.mashedsweetpotatoesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mashedsweetpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.mashedsweetpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mashedsweetpotatoesItem");
			ItemRegistry.steamedpeasItem = new IguanaFoodPam(((ItemFood)ItemRegistry.steamedpeasItem).func_150905_g(null), ((ItemFood)ItemRegistry.steamedpeasItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:steamedpeasItem");
			ItemRegistry.splitpeasoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.splitpeasoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.splitpeasoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:splitpeasoupItem");
			ItemRegistry.pineappleupsidedowncakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineappleupsidedowncakeItem");
			ItemRegistry.pineapplehamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pineapplehamItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineapplehamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineapplehamItem");
			ItemRegistry.pineappleyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pineappleyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineappleyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineappleyogurtItem");
			ItemRegistry.turnipsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.turnipsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.turnipsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:turnipsoupItem");
			ItemRegistry.roastedrootveggiemedleyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).func_150905_g(null), ((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:roastedrootveggiemedleyItem");
			ItemRegistry.bakedturnipsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bakedturnipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedturnipsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedturnipsItem");
			ItemRegistry.gingerbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gingerbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingerbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gingerbreadItem");
			ItemRegistry.gingersnapsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gingersnapsItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingersnapsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gingersnapsItem");
			ItemRegistry.candiedgingerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.candiedgingerItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedgingerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedgingerItem");
			ItemRegistry.softpretzelandmustardItem = new IguanaFoodPam(((ItemFood)ItemRegistry.softpretzelandmustardItem).func_150905_g(null), ((ItemFood)ItemRegistry.softpretzelandmustardItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:softpretzelandmustardItem");
			ItemRegistry.spicymustardporkItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spicymustardporkItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicymustardporkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spicymustardporkItem");
			ItemRegistry.spicygreensItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spicygreensItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicygreensItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spicygreensItem");
			ItemRegistry.garlicbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.garlicbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicbreadItem");
			ItemRegistry.garlicmashedpotatoesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.garlicmashedpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicmashedpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicmashedpotatoesItem");
			ItemRegistry.garlicchickenItem = new IguanaFoodPam(((ItemFood)ItemRegistry.garlicchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicchickenItem");
			ItemRegistry.summerradishsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.summerradishsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.summerradishsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:summerradishsaladItem");
			ItemRegistry.summersquashwithradishItem = new IguanaFoodPam(((ItemFood)ItemRegistry.summersquashwithradishItem).func_150905_g(null), ((ItemFood)ItemRegistry.summersquashwithradishItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:summersquashwithradishItem");
			ItemRegistry.celeryandpeanutbutterItem = new IguanaFoodPam(((ItemFood)ItemRegistry.celeryandpeanutbutterItem).func_150905_g(null), ((ItemFood)ItemRegistry.celeryandpeanutbutterItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:celeryandpeanutbutterItem");
			ItemRegistry.chickencelerycasseroleItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickencelerycasseroleItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickencelerycasseroleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickencelerycasseroleItem");
			ItemRegistry.peasandceleryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peasandceleryItem).func_150905_g(null), ((ItemFood)ItemRegistry.peasandceleryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peasandceleryItem");
			ItemRegistry.celerysoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.celerysoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.celerysoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:celerysoupItem");
			ItemRegistry.zucchinibreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinibreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinibreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinibreadItem");
			ItemRegistry.zucchinifriesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinifriesItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinifriesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinifriesItem");
			ItemRegistry.zestyzucchiniItem = new IguanaFoodPam(((ItemFood)ItemRegistry.zestyzucchiniItem).func_150905_g(null), ((ItemFood)ItemRegistry.zestyzucchiniItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zestyzucchiniItem");
			ItemRegistry.zucchinibakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinibakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinibakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinibakeItem");
			ItemRegistry.asparagusquicheItem = new IguanaFoodPam(((ItemFood)ItemRegistry.asparagusquicheItem).func_150905_g(null), ((ItemFood)ItemRegistry.asparagusquicheItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:asparagusquicheItem");
			ItemRegistry.asparagussoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.asparagussoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.asparagussoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:asparagussoupItem");
			ItemRegistry.walnutraisinbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.walnutraisinbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.walnutraisinbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:walnutraisinbreadItem");
			ItemRegistry.candiedwalnutsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.candiedwalnutsItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedwalnutsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedwalnutsItem");
			ItemRegistry.brownieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.brownieItem).func_150905_g(null), ((ItemFood)ItemRegistry.brownieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:brownieItem");
			ItemRegistry.papayajuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.papayajuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayasmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.papayasmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayasmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayayogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.papayayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayayogurtItem");
			ItemRegistry.starfruitjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruitsmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruityogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.starfruityogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruityogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruityogurtItem");
			ItemRegistry.guacamoleItem = new IguanaFoodPam(((ItemFood)ItemRegistry.guacamoleItem).func_150905_g(null), ((ItemFood)ItemRegistry.guacamoleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:guacamoleItem");
			ItemRegistry.creamofavocadosoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.creamofavocadosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamofavocadosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamofavocadosoupItem");
			ItemRegistry.avocadoburritoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.avocadoburritoItem).func_150905_g(null), ((ItemFood)ItemRegistry.avocadoburritoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:avocadoburritoItem");
			ItemRegistry.poachedpearItem = new IguanaFoodPam(((ItemFood)ItemRegistry.poachedpearItem).func_150905_g(null), ((ItemFood)ItemRegistry.poachedpearItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:poachedpearItem");
			ItemRegistry.fruitcrumbleItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fruitcrumbleItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitcrumbleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitcrumbleItem");
			ItemRegistry.pearyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pearyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pearyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pearyogurtItem");
			ItemRegistry.plumyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.plumyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.plumyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:plumyogurtItem");
			ItemRegistry.bananasplitItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bananasplitItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananasplitItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananasplitItem");
			ItemRegistry.banananutbreadItem = new IguanaFoodPam(((ItemFood)ItemRegistry.banananutbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.banananutbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:banananutbreadItem");
			ItemRegistry.bananasmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bananasmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananasmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.bananayogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.bananayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananayogurtItem");
			ItemRegistry.coconutmilkItem = new IguanaFoodPam(((ItemFood)ItemRegistry.coconutmilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutmilkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutmilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chickencurryItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chickencurryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickencurryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickencurryItem");
			ItemRegistry.coconutshrimpItem = new IguanaFoodPam(((ItemFood)ItemRegistry.coconutshrimpItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutshrimpItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutshrimpItem");
			ItemRegistry.coconutyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.coconutyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutyogurtItem");
			ItemRegistry.orangejuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangechickenItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangechickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangechickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangechickenItem");
			ItemRegistry.orangesmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangeyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangeyogurtItem");
			ItemRegistry.peachjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachcobblerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachcobblerItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachcobblerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachcobblerItem");
			ItemRegistry.peachsmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachyogurtItem");
			ItemRegistry.limejuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.limejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.keylimepieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.keylimepieItem).func_150905_g(null), ((ItemFood)ItemRegistry.keylimepieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:keylimepieItem");
			ItemRegistry.limesmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.limesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.limesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.limeyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.limeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.limeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limeyogurtItem");
			ItemRegistry.mangojuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mangojuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangosmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mangosmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangosmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangosmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangoyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mangoyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangoyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangoyogurtItem");
			ItemRegistry.pomegranatejuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranatesmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranateyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranateyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranateyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranateyogurtItem");
			ItemRegistry.vanillayogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.vanillayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.vanillayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vanillayogurtItem");
			ItemRegistry.cinnamonrollItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cinnamonrollItem).func_150905_g(null), ((ItemFood)ItemRegistry.cinnamonrollItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cinnamonrollItem");
			ItemRegistry.frenchtoastItem = new IguanaFoodPam(((ItemFood)ItemRegistry.frenchtoastItem).func_150905_g(null), ((ItemFood)ItemRegistry.frenchtoastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:frenchtoastItem");
			ItemRegistry.marshmellowsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.marshmellowsItem).func_150905_g(null), ((ItemFood)ItemRegistry.marshmellowsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:marshmellowsItem");
			ItemRegistry.donutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.donutItem).func_150905_g(null), ((ItemFood)ItemRegistry.donutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:donutItem");
			ItemRegistry.chocolatedonutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatedonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatedonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatedonutItem");
			ItemRegistry.powdereddonutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.powdereddonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.powdereddonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:powdereddonutItem");
			ItemRegistry.jellydonutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.jellydonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.jellydonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jellydonutItem");
			ItemRegistry.frosteddonutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.frosteddonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.frosteddonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:frosteddonutItem");
			ItemRegistry.cactussoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cactussoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.cactussoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cactussoupItem");
			ItemRegistry.wafflesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.wafflesItem).func_150905_g(null), ((ItemFood)ItemRegistry.wafflesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:wafflesItem");
			ItemRegistry.seedsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.seedsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.seedsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:seedsoupItem");
			ItemRegistry.softpretzelItem = new IguanaFoodPam(((ItemFood)ItemRegistry.softpretzelItem).func_150905_g(null), ((ItemFood)ItemRegistry.softpretzelItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:softpretzelItem");
			ItemRegistry.jellybeansItem = new IguanaFoodPam(((ItemFood)ItemRegistry.jellybeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.jellybeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jellybeansItem");
			ItemRegistry.biscuitItem = new IguanaFoodPam(((ItemFood)ItemRegistry.biscuitItem).func_150905_g(null), ((ItemFood)ItemRegistry.biscuitItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:biscuitItem");
			ItemRegistry.creamcookieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.creamcookieItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamcookieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamcookieItem");
			ItemRegistry.jaffaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.jaffaItem).func_150905_g(null), ((ItemFood)ItemRegistry.jaffaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jaffaItem");
			ItemRegistry.friedchickenItem = new IguanaFoodPam(((ItemFood)ItemRegistry.friedchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedchickenItem");
			ItemRegistry.chocolatesprinklecakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatesprinklecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatesprinklecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatesprinklecakeItem");
			ItemRegistry.redvelvetcakeItem = new IguanaFoodPam(((ItemFood)ItemRegistry.redvelvetcakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.redvelvetcakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:redvelvetcakeItem");
			ItemRegistry.footlongItem = new IguanaFoodPam(((ItemFood)ItemRegistry.footlongItem).func_150905_g(null), ((ItemFood)ItemRegistry.footlongItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:footlongItem");
			ItemRegistry.blueberryyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryyogurtItem");
			ItemRegistry.lemonyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonyogurtItem");
			ItemRegistry.cherryyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryyogurtItem");
			ItemRegistry.strawberryyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryyogurtItem");
			ItemRegistry.grapeyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.grapeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapeyogurtItem");
			ItemRegistry.chocolateyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolateyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolateyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolateyogurtItem");
			ItemRegistry.blackberryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberrycobblerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberrycobblerItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberrycobblerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberrycobblerItem");
			ItemRegistry.blackberrysmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberryyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryyogurtItem");
			ItemRegistry.chocolatemilkItem = new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatemilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatemilkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatemilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pumpkinyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinyogurtItem");
			ItemRegistry.raspberryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberrypieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberrypieItem");
			ItemRegistry.raspberrysmoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberryyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryyogurtItem");
			ItemRegistry.cinnamonsugardonutItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cinnamonsugardonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.cinnamonsugardonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cinnamonsugardonutItem");
			ItemRegistry.melonyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.melonyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:melonyogurtItem");
			ItemRegistry.kiwijuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwismoothieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.kiwismoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwismoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwismoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwiyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.kiwiyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwiyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwiyogurtItem");
			ItemRegistry.plainyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.plainyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.plainyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:plainyogurtItem");
			ItemRegistry.appleyogurtItem = new IguanaFoodPam(((ItemFood)ItemRegistry.appleyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.appleyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:appleyogurtItem");
			ItemRegistry.saltedsunflowerseedsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.saltedsunflowerseedsItem).func_150905_g(null), ((ItemFood)ItemRegistry.saltedsunflowerseedsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:saltedsunflowerseedsItem");
			ItemRegistry.sunflowerwheatrollsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.sunflowerwheatrollsItem).func_150905_g(null), ((ItemFood)ItemRegistry.sunflowerwheatrollsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sunflowerwheatrollsItem");
			ItemRegistry.sunflowerbroccolisaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sunflowerbroccolisaladItem");
			ItemRegistry.cranberryjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cranberrysauceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cranberrysauceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberrysauceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberrysauceItem");
			ItemRegistry.cranberrybarItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cranberrybarItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberrybarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberrybarItem");
			ItemRegistry.peppermintItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peppermintItem).func_150905_g(null), ((ItemFood)ItemRegistry.peppermintItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peppermintItem");
			ItemRegistry.cactusfruitjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cactusfruitjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cactusfruitjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cactusfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.baklavaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.baklavaItem).func_150905_g(null), ((ItemFood)ItemRegistry.baklavaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baklavaItem");
			ItemRegistry.gummybearsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gummybearsItem).func_150905_g(null), ((ItemFood)ItemRegistry.gummybearsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gummybearsItem");
			ItemRegistry.baconmushroomburgerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.baconmushroomburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.baconmushroomburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baconmushroomburgerItem");
			ItemRegistry.fruitpunchItem = new IguanaFoodPam(((ItemFood)ItemRegistry.fruitpunchItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitpunchItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitpunchItem");
			ItemRegistry.meatystewItem = new IguanaFoodPam(((ItemFood)ItemRegistry.meatystewItem).func_150905_g(null), ((ItemFood)ItemRegistry.meatystewItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:meatystewItem");
			ItemRegistry.mixedsaladItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mixedsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.mixedsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mixedsaladItem");
			ItemRegistry.pinacoladaItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pinacoladaItem).func_150905_g(null), ((ItemFood)ItemRegistry.pinacoladaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pinacoladaItem");
			ItemRegistry.shepardspieItem = new IguanaFoodPam(((ItemFood)ItemRegistry.shepardspieItem).func_150905_g(null), ((ItemFood)ItemRegistry.shepardspieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:shepardspieItem");
			ItemRegistry.eggnogItem = new IguanaFoodPam(((ItemFood)ItemRegistry.eggnogItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggnogItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggnogItem");
			ItemRegistry.custardItem = new IguanaFoodPam(((ItemFood)ItemRegistry.custardItem).func_150905_g(null), ((ItemFood)ItemRegistry.custardItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:custardItem");
			ItemRegistry.sushiItem = new IguanaFoodPam(((ItemFood)ItemRegistry.sushiItem).func_150905_g(null), ((ItemFood)ItemRegistry.sushiItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sushiItem");
			ItemRegistry.gardensoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gardensoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.gardensoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gardensoupItem");
			ItemRegistry.muttonrawItem = new IguanaFoodPam(((ItemFood)ItemRegistry.muttonrawItem).func_150905_g(null), ((ItemFood)ItemRegistry.muttonrawItem).func_150906_h(null), true, true).setUnlocalizedName("ItemRegistry:muttonrawItem");
			ItemRegistry.muttoncookedItem = new IguanaFoodPam(((ItemFood)ItemRegistry.muttoncookedItem).func_150905_g(null), ((ItemFood)ItemRegistry.muttoncookedItem).func_150906_h(null), true, true).setUnlocalizedName("ItemRegistry:muttoncookedItem");
			ItemRegistry.calamarirawItem = new IguanaFoodPam(((ItemFood)ItemRegistry.calamarirawItem).func_150905_g(null), ((ItemFood)ItemRegistry.calamarirawItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:calamarirawItem");
			ItemRegistry.calamaricookedItem = new IguanaFoodPam(((ItemFood)ItemRegistry.calamaricookedItem).func_150905_g(null), ((ItemFood)ItemRegistry.calamaricookedItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:calamaricookedItem");
			ItemRegistry.applejellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.applejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applejellyItem");
			ItemRegistry.applejellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.applejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applejellysandwichItem");
			ItemRegistry.blackberryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjellyItem");
			ItemRegistry.blackberryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjellysandwichItem");
			ItemRegistry.blueberryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjellyItem");
			ItemRegistry.blueberryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjellysandwichItem");
			ItemRegistry.cherryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjellyItem");
			ItemRegistry.cherryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjellysandwichItem");
			ItemRegistry.cranberryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjellyItem");
			ItemRegistry.cranberryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjellysandwichItem");
			ItemRegistry.kiwijellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijellyItem");
			ItemRegistry.kiwijellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijellysandwichItem");
			ItemRegistry.lemonjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonjellyItem");
			ItemRegistry.lemonjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lemonjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonjellysandwichItem");
			ItemRegistry.limejellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.limejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejellyItem");
			ItemRegistry.limejellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.limejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejellysandwichItem");
			ItemRegistry.mangojellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mangojellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojellyItem");
			ItemRegistry.mangojellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mangojellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojellysandwichItem");
			ItemRegistry.orangejellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejellyItem");
			ItemRegistry.orangejellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.orangejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejellysandwichItem");
			ItemRegistry.papayajellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.papayajellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajellyItem");
			ItemRegistry.papayajellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.papayajellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajellysandwichItem");
			ItemRegistry.peachjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjellyItem");
			ItemRegistry.peachjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.peachjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjellysandwichItem");
			ItemRegistry.pomegranatejellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellyItem");
			ItemRegistry.pomegranatejellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellysandwichItem");
			ItemRegistry.raspberryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjellyItem");
			ItemRegistry.raspberryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjellysandwichItem");
			ItemRegistry.starfruitjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjellyItem");
			ItemRegistry.starfruitjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjellysandwichItem");
			ItemRegistry.strawberryjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjellyItem");
			ItemRegistry.strawberryjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjellysandwichItem");
			ItemRegistry.watermelonjellyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.watermelonjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.watermelonjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:watermelonjellyItem");
			ItemRegistry.watermelonjellysandwichItem = new IguanaFoodPam(((ItemFood)ItemRegistry.watermelonjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.watermelonjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:watermelonjellysandwichItem");

			ItemRegistry.cherrysodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.cherrysodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrysodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:cherrysodaItem");
			ItemRegistry.colasodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.colasodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.colasodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:colasodaItem");
			ItemRegistry.gingersodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.gingersodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingersodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:gingersodaItem");
			ItemRegistry.grapesodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.grapesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:grapesodaItem");
			ItemRegistry.lemonlimesodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.lemonlimesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonlimesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:lemonlimesodaItem");
			ItemRegistry.orangesodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.orangesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:orangesodaItem");
			ItemRegistry.rootbeersodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.rootbeersodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.rootbeersodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:rootbeersodaItem");
			ItemRegistry.strawberrysodaItem = new IguanaFoodPamPotion(((ItemFood)ItemRegistry.strawberrysodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:strawberrysodaItem");

			ItemRegistry.caramelicecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.caramelicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:caramelicecreamItem");
			ItemRegistry.mintchocolatechipicemcreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:mintchocolatechipicecreamItem");
			ItemRegistry.strawberryicecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:strawberryicecreamItem");
			ItemRegistry.vanillaicecreamItem = new IguanaFoodPam(((ItemFood)ItemRegistry.vanillaicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.vanillaicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:vanillaicecreamItem");

			ItemRegistry.ediblerootItem = new ItemSeedFood(((ItemFood)ItemRegistry.ediblerootItem).func_150905_g(null), ((ItemFood)ItemRegistry.ediblerootItem).func_150906_h(null), BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ediblerootItem");

			ItemRegistry.gingerchickenItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gingerchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingerchickenItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:gingerchickenItem");

			ItemRegistry.oldworldveggiesoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.oldworldveggiesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.oldworldveggiesoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:oldworldveggiesoupItem");
			ItemRegistry.spicebunItem = new IguanaFoodPam(((ItemFood)ItemRegistry.spicebunItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicebunItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:spicebunItem");
			ItemRegistry.gingeredrhubarbtartItem = new IguanaFoodPam(((ItemFood)ItemRegistry.gingeredrhubarbtartItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingeredrhubarbtartItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:gingeredrhubarbtartItem");
			ItemRegistry.lambbarleysoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.lambbarleysoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.lambbarleysoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:lambbarleysoupItem");
			ItemRegistry.honeylemonlambItem = new IguanaFoodPam(((ItemFood)ItemRegistry.honeylemonlambItem).func_150905_g(null), ((ItemFood)ItemRegistry.honeylemonlambItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:honeylemonlambItem");
			ItemRegistry.pumpkinoatsconesItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinoatsconesItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinoatsconesItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:pumpkinoatsconesItem");
			ItemRegistry.beefjerkyItem = new IguanaFoodPam(((ItemFood)ItemRegistry.beefjerkyItem).func_150905_g(null), ((ItemFood)ItemRegistry.beefjerkyItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:beefjerkyItem");
			ItemRegistry.plumjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.plumjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.plumjuiceItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:plumjuiceItem");
			ItemRegistry.pearjuiceItem = new IguanaFoodPam(((ItemFood)ItemRegistry.pearjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.pearjuiceItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:pearjuiceItem");
			ItemRegistry.ovenroastedcauliflowerItem = new IguanaFoodPam(((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).func_150905_g(null), ((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:ovenroastedcauliflowerItem");
			ItemRegistry.leekbaconsoupItem = new IguanaFoodPam(((ItemFood)ItemRegistry.leekbaconsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.leekbaconsoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:leekbaconsoupItem");
			ItemRegistry.herbbutterparsnipsItem = new IguanaFoodPam(((ItemFood)ItemRegistry.herbbutterparsnipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.herbbutterparsnipsItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:herbbutterparsnipsItem");
			ItemRegistry.scallionbakedpotatoItem = new IguanaFoodPam(((ItemFood)ItemRegistry.scallionbakedpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.scallionbakedpotatoItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:scallionbakedpotatoItem");
			ItemRegistry.soymilkItem = new IguanaFoodPam(((ItemFood)ItemRegistry.soymilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.soymilkItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:soymilkItem");
			ItemRegistry.firmtofuItem = new IguanaFoodPam(((ItemFood)ItemRegistry.firmtofuItem).func_150905_g(null), ((ItemFood)ItemRegistry.firmtofuItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:firmtofuItem");
			ItemRegistry.silkentofuItem = new IguanaFoodPam(((ItemFood)ItemRegistry.silkentofuItem).func_150905_g(null), ((ItemFood)ItemRegistry.silkentofuItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:silkentofuItem");
			
			Utils.replace(ItemRegistry.toastItem, new IguanaFoodPam(((ItemFood)ItemRegistry.toastItem).func_150905_g(null), ((ItemFood)ItemRegistry.toastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:toastItem"));
			Utils.replace(ItemRegistry.cheeseItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cheeseItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheeseItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheeseItem"));
			Utils.replace(ItemRegistry.icecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.icecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.icecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:icecreamItem"));
			Utils.replace(ItemRegistry.grilledcheeseItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grilledcheeseItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledcheeseItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledcheeseItem"));
			Utils.replace(ItemRegistry.applejuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.applejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:applejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.applesauceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.applesauceItem).func_150905_g(null), ((ItemFood)ItemRegistry.applesauceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applesauceItem"));
			Utils.replace(ItemRegistry.applepieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.applepieItem).func_150905_g(null), ((ItemFood)ItemRegistry.applepieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applepieItem"));
			Utils.replace(ItemRegistry.caramelappleItem, new IguanaFoodPam(((ItemFood)ItemRegistry.caramelappleItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelappleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:caramelappleItem"));
			Utils.replace(ItemRegistry.pumpkinbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinbreadItem"));
			Utils.replace(ItemRegistry.roastedpumpkinseedsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.roastedpumpkinseedsItem).func_150905_g(null), ((ItemFood)ItemRegistry.roastedpumpkinseedsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:roastedpumpkinseedsItem"));
			Utils.replace(ItemRegistry.pumpkinsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinsoupItem"));
			Utils.replace(ItemRegistry.melonjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.melonjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonjuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:melonjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.melonsmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.melonsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:melonsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.carrotjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.carrotjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotjuiceItem).func_150906_h(null), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:carrotjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.carrotcakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.carrotcakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotcakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:carrotcakeItem"));
			Utils.replace(ItemRegistry.carrotsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.carrotsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.carrotsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:carrotsoupItem"));
			Utils.replace(ItemRegistry.glazedcarrotsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.glazedcarrotsItem).func_150905_g(null), ((ItemFood)ItemRegistry.glazedcarrotsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:glazedcarrotsItem"));
			Utils.replace(ItemRegistry.butteredpotatoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.butteredpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.butteredpotatoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:butteredpotatoItem"));
			Utils.replace(ItemRegistry.loadedbakedpotatoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.loadedbakedpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.loadedbakedpotatoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:loadedbakedpotatoItem"));
			Utils.replace(ItemRegistry.mashedpotatoesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mashedpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.mashedpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mashedpotatoesItem"));
			Utils.replace(ItemRegistry.potatosaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.potatosaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatosaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatosaladItem"));
			Utils.replace(ItemRegistry.potatosoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.potatosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatosoupItem"));
			Utils.replace(ItemRegistry.friesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.friesItem).func_150905_g(null), ((ItemFood)ItemRegistry.friesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friesItem"));
			Utils.replace(ItemRegistry.grilledmushroomItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grilledmushroomItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledmushroomItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledmushroomItem"));
			Utils.replace(ItemRegistry.stuffedmushroomItem, new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedmushroomItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedmushroomItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedmushroomItem"));
			Utils.replace(ItemRegistry.chickensandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickensandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickensandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickensandwichItem"));
			Utils.replace(ItemRegistry.chickennoodlesoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickennoodlesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickennoodlesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickennoodlesoupItem"));
			Utils.replace(ItemRegistry.chickenpotpieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickenpotpieItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickenpotpieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickenpotpieItem"));
			Utils.replace(ItemRegistry.breadedporkchopItem, new IguanaFoodPam(((ItemFood)ItemRegistry.breadedporkchopItem).func_150905_g(null), ((ItemFood)ItemRegistry.breadedporkchopItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:breadedporkchopItem"));
			Utils.replace(ItemRegistry.hotdogItem, new IguanaFoodPam(((ItemFood)ItemRegistry.hotdogItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotdogItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotdogItem"));
			Utils.replace(ItemRegistry.bakedhamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bakedhamItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedhamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedhamItem"));
			Utils.replace(ItemRegistry.hamburgerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.hamburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.hamburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hamburgerItem"));
			Utils.replace(ItemRegistry.cheeseburgerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheeseburgerItem"));
			Utils.replace(ItemRegistry.baconcheeseburgerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.baconcheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.baconcheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baconcheeseburgerItem"));
			Utils.replace(ItemRegistry.potroastItem, new IguanaFoodPam(((ItemFood)ItemRegistry.potroastItem).func_150905_g(null), ((ItemFood)ItemRegistry.potroastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potroastItem"));
			Utils.replace(ItemRegistry.fishsandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishsandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishsandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishsandwichItem"));
			Utils.replace(ItemRegistry.fishsticksItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishsticksItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishsticksItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishsticksItem"));
			Utils.replace(ItemRegistry.fishandchipsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishandchipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishandchipsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishandchipsItem"));
			Utils.replace(ItemRegistry.friedeggItem, new IguanaFoodPam(((ItemFood)ItemRegistry.friedeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedeggItem"));
			Utils.replace(ItemRegistry.scrambledeggItem, new IguanaFoodPam(((ItemFood)ItemRegistry.scrambledeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.scrambledeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:scrambledeggItem"));
			Utils.replace(ItemRegistry.boiledeggItem, new IguanaFoodPam(((ItemFood)ItemRegistry.boiledeggItem).func_150905_g(null), ((ItemFood)ItemRegistry.boiledeggItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:boiledeggItem"));
			Utils.replace(ItemRegistry.eggsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.eggsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggsaladItem"));
			Utils.replace(ItemRegistry.caramelItem, new IguanaFoodPam(((ItemFood)ItemRegistry.caramelItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:caramelItem"));
			Utils.replace(ItemRegistry.taffyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.taffyItem).func_150905_g(null), ((ItemFood)ItemRegistry.taffyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:taffyItem"));
			Utils.replace(ItemRegistry.spidereyesoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spidereyesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.spidereyesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spidereyesoupItem"));
			Utils.replace(ItemRegistry.zombiejerkyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.zombiejerkyItem).func_150905_g(null), ((ItemFood)ItemRegistry.zombiejerkyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zombiejerkyItem"));
			Utils.replace(ItemRegistry.chocolatebarItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatebarItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatebarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatebarItem"));
			Utils.replace(ItemRegistry.hotchocolateItem, new IguanaFoodPam(((ItemFood)ItemRegistry.hotchocolateItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotchocolateItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotchocolateItem"));
			Utils.replace(ItemRegistry.chocolateicecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolateicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolateicecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolateicecreamItem"));
			Utils.replace(ItemRegistry.vegetablesoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.vegetablesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.vegetablesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vegetablesoupItem"));
			Utils.replace(ItemRegistry.stockItem, new IguanaFoodPam(((ItemFood)ItemRegistry.stockItem).func_150905_g(null), ((ItemFood)ItemRegistry.stockItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stockItem"));
			Utils.replace(ItemRegistry.fruitsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fruitsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitsaladItem"));
			Utils.replace(ItemRegistry.spagettiItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spagettiItem).func_150905_g(null), ((ItemFood)ItemRegistry.spagettiItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spagettiItem"));
			Utils.replace(ItemRegistry.spagettiandmeatballsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spagettiandmeatballsItem).func_150905_g(null), ((ItemFood)ItemRegistry.spagettiandmeatballsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spagettiandmeatballsItem"));
			Utils.replace(ItemRegistry.tomatosoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.tomatosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.tomatosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tomatosoupItem"));
			Utils.replace(ItemRegistry.chickenparmasanItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickenparmasanItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickenparmasanItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickenparmasanItem"));
			Utils.replace(ItemRegistry.pizzaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pizzaItem).func_150905_g(null), ((ItemFood)ItemRegistry.pizzaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pizzaItem"));
			Utils.replace(ItemRegistry.springsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.springsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.springsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:springsaladItem"));
			Utils.replace(ItemRegistry.porklettucewrapItem, new IguanaFoodPam(((ItemFood)ItemRegistry.porklettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.porklettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:porklettucewrapItem"));
			Utils.replace(ItemRegistry.fishlettucewrapItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishlettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishlettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishlettucewrapItem"));
			Utils.replace(ItemRegistry.bltItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bltItem).func_150905_g(null), ((ItemFood)ItemRegistry.bltItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bltItem"));
			Utils.replace(ItemRegistry.leafychickensandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.leafychickensandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.leafychickensandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:leafychickensandwichItem"));
			Utils.replace(ItemRegistry.leafyfishsandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.leafyfishsandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.leafyfishsandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:leafyfishsandwichItem"));
			Utils.replace(ItemRegistry.deluxecheeseburgerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.deluxecheeseburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.deluxecheeseburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:deluxecheeseburgerItem"));
			Utils.replace(ItemRegistry.delightedmealItem, new IguanaFoodPam(((ItemFood)ItemRegistry.delightedmealItem).func_150905_g(null), ((ItemFood)ItemRegistry.delightedmealItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:delightedmealItem"));
			Utils.replace(ItemRegistry.onionsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.onionsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.onionsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:onionsoupItem"));
			Utils.replace(ItemRegistry.potatocakesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.potatocakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.potatocakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:potatocakesItem"));
			Utils.replace(ItemRegistry.hashItem, new IguanaFoodPam(((ItemFood)ItemRegistry.hashItem).func_150905_g(null), ((ItemFood)ItemRegistry.hashItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hashItem"));
			Utils.replace(ItemRegistry.braisedonionsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.braisedonionsItem).func_150905_g(null), ((ItemFood)ItemRegistry.braisedonionsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:braisedonionsItem"));
			Utils.replace(ItemRegistry.heartybreakfastItem, new IguanaFoodPam(((ItemFood)ItemRegistry.heartybreakfastItem).func_150905_g(null), ((ItemFood)ItemRegistry.heartybreakfastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:heartybreakfastItem"));
			Utils.replace(ItemRegistry.cornonthecobItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cornonthecobItem).func_150905_g(null), ((ItemFood)ItemRegistry.cornonthecobItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cornonthecobItem"));
			Utils.replace(ItemRegistry.cornbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cornbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.cornbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cornbreadItem"));
			Utils.replace(ItemRegistry.tortillaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.tortillaItem).func_150905_g(null), ((ItemFood)ItemRegistry.tortillaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tortillaItem"));
			Utils.replace(ItemRegistry.nachoesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.nachoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.nachoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:nachoesItem"));
			Utils.replace(ItemRegistry.tacoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.tacoItem).func_150905_g(null), ((ItemFood)ItemRegistry.tacoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:tacoItem"));
			Utils.replace(ItemRegistry.fishtacoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishtacoItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishtacoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishtacoItem"));
			Utils.replace(ItemRegistry.creamedcornItem, new IguanaFoodPam(((ItemFood)ItemRegistry.creamedcornItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamedcornItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamedcornItem"));
			Utils.replace(ItemRegistry.strawberrysmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrysmoothieItem"));
			Utils.replace(ItemRegistry.strawberrypieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrypieItem"));
			Utils.replace(ItemRegistry.strawberrysaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberrysaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberrysaladItem"));
			Utils.replace(ItemRegistry.strawberryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.chocolatestrawberryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatestrawberryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatestrawberryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatestrawberryItem"));
			Utils.replace(ItemRegistry.peanutbutterItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peanutbutterItem).func_150905_g(null), ((ItemFood)ItemRegistry.peanutbutterItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peanutbutterItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.trailmixItem, new IguanaFoodPam(((ItemFood)ItemRegistry.trailmixItem).func_150905_g(null), ((ItemFood)ItemRegistry.trailmixItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:trailmixItem"));
			Utils.replace(ItemRegistry.pbandjItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pbandjItem).func_150905_g(null), ((ItemFood)ItemRegistry.pbandjItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pbandjItem"));
			Utils.replace(ItemRegistry.peanutbuttercookiesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peanutbuttercookiesItem).func_150905_g(null), ((ItemFood)ItemRegistry.peanutbuttercookiesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peanutbuttercookiesItem"));
			Utils.replace(ItemRegistry.grapejuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grapejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapejuiceItem"));
			Utils.replace(ItemRegistry.grapejellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grapejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapejellyItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.grapesaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grapesaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapesaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapesaladItem"));
			Utils.replace(ItemRegistry.raisincookiesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raisincookiesItem).func_150905_g(null), ((ItemFood)ItemRegistry.raisincookiesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raisincookiesItem"));
			Utils.replace(ItemRegistry.picklesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.picklesItem).func_150905_g(null), ((ItemFood)ItemRegistry.picklesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:picklesItem"));
			Utils.replace(ItemRegistry.cucumbersaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cucumbersaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.cucumbersaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cucumbersaladItem"));
			Utils.replace(ItemRegistry.cucumbersoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cucumbersoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.cucumbersoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cucumbersoupItem"));
			Utils.replace(ItemRegistry.vegetarianlettucewrapItem, new IguanaFoodPam(((ItemFood)ItemRegistry.vegetarianlettucewrapItem).func_150905_g(null), ((ItemFood)ItemRegistry.vegetarianlettucewrapItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vegetarianlettucewrapItem"));
			Utils.replace(ItemRegistry.marinatedcucumbersItem, new IguanaFoodPam(((ItemFood)ItemRegistry.marinatedcucumbersItem).func_150905_g(null), ((ItemFood)ItemRegistry.marinatedcucumbersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:marinatedcucumbersItem"));
			Utils.replace(ItemRegistry.ricesoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.ricesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.ricesoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:ricesoupItem"));
			Utils.replace(ItemRegistry.friedriceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.friedriceItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedriceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedriceItem"));
			Utils.replace(ItemRegistry.mushroomrisottoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mushroomrisottoItem).func_150905_g(null), ((ItemFood)ItemRegistry.mushroomrisottoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mushroomrisottoItem"));
			Utils.replace(ItemRegistry.curryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.curryItem).func_150905_g(null), ((ItemFood)ItemRegistry.curryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:curryItem"));
			Utils.replace(ItemRegistry.rainbowcurryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.rainbowcurryItem).func_150905_g(null), ((ItemFood)ItemRegistry.rainbowcurryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:rainbowcurryItem"));
			Utils.replace(ItemRegistry.refriedbeansItem, new IguanaFoodPam(((ItemFood)ItemRegistry.refriedbeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.refriedbeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:refriedbeansItem"));
			Utils.replace(ItemRegistry.bakedbeansItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bakedbeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedbeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedbeansItem"));
			Utils.replace(ItemRegistry.beansandriceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.beansandriceItem).func_150905_g(null), ((ItemFood)ItemRegistry.beansandriceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beansandriceItem"));
			Utils.replace(ItemRegistry.chiliItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chiliItem).func_150905_g(null), ((ItemFood)ItemRegistry.chiliItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chiliItem"));
			Utils.replace(ItemRegistry.beanburritoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.beanburritoItem).func_150905_g(null), ((ItemFood)ItemRegistry.beanburritoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beanburritoItem"));
			Utils.replace(ItemRegistry.stuffedpepperItem, new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedpepperItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedpepperItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedpepperItem"));
			Utils.replace(ItemRegistry.veggiestirfryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.veggiestirfryItem).func_150905_g(null), ((ItemFood)ItemRegistry.veggiestirfryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:veggiestirfryItem"));
			Utils.replace(ItemRegistry.grilledskewersItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grilledskewersItem).func_150905_g(null), ((ItemFood)ItemRegistry.grilledskewersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grilledskewersItem"));
			Utils.replace(ItemRegistry.supremepizzaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.supremepizzaItem).func_150905_g(null), ((ItemFood)ItemRegistry.supremepizzaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:supremepizzaItem"));
			Utils.replace(ItemRegistry.omeletItem, new IguanaFoodPam(((ItemFood)ItemRegistry.omeletItem).func_150905_g(null), ((ItemFood)ItemRegistry.omeletItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:omeletItem"));
			Utils.replace(ItemRegistry.hotwingsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.hotwingsItem).func_150905_g(null), ((ItemFood)ItemRegistry.hotwingsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:hotwingsItem"));
			Utils.replace(ItemRegistry.chilipoppersItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chilipoppersItem).func_150905_g(null), ((ItemFood)ItemRegistry.chilipoppersItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chilipoppersItem"));
			Utils.replace(ItemRegistry.extremechiliItem, new IguanaFoodPam(((ItemFood)ItemRegistry.extremechiliItem).func_150905_g(null), ((ItemFood)ItemRegistry.extremechiliItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:extremechiliItem"));
			Utils.replace(ItemRegistry.chilichocolateItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chilichocolateItem).func_150905_g(null), ((ItemFood)ItemRegistry.chilichocolateItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chilichocolateItem"));
			Utils.replace(ItemRegistry.lemonaideItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonaideItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonaideItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonaideItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.lemonbarItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonbarItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonbarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonbarItem"));
			Utils.replace(ItemRegistry.fishdinnerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fishdinnerItem).func_150905_g(null), ((ItemFood)ItemRegistry.fishdinnerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fishdinnerItem"));
			Utils.replace(ItemRegistry.lemonsmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.lemonmeringueItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonmeringueItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonmeringueItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonmeringueItem"));
			Utils.replace(ItemRegistry.candiedlemonItem, new IguanaFoodPam(((ItemFood)ItemRegistry.candiedlemonItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedlemonItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedlemonItem"));
			Utils.replace(ItemRegistry.lemonchickenItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonchickenItem"));
			Utils.replace(ItemRegistry.blueberrysmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrysmoothieItem"));
			Utils.replace(ItemRegistry.blueberrypieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrypieItem"));
			Utils.replace(ItemRegistry.blueberrymuffinItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrymuffinItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrymuffinItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrymuffinItem"));
			Utils.replace(ItemRegistry.blueberryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pancakesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pancakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.pancakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pancakesItem"));
			Utils.replace(ItemRegistry.blueberrypancakesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberrypancakesItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberrypancakesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberrypancakesItem"));
			Utils.replace(ItemRegistry.cherryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cherrypieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrypieItem"));
			Utils.replace(ItemRegistry.chocolatecherryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatecherryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatecherryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatecherryItem"));
			Utils.replace(ItemRegistry.cherrysmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cheesecakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cheesecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.cheesecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cheesecakeItem"));
			Utils.replace(ItemRegistry.cherrycheesecakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherrycheesecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrycheesecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherrycheesecakeItem"));
			Utils.replace(ItemRegistry.stuffedeggplantItem, new IguanaFoodPam(((ItemFood)ItemRegistry.stuffedeggplantItem).func_150905_g(null), ((ItemFood)ItemRegistry.stuffedeggplantItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:stuffedeggplantItem"));
			Utils.replace(ItemRegistry.eggplantparmItem, new IguanaFoodPam(((ItemFood)ItemRegistry.eggplantparmItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggplantparmItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggplantparmItem"));
			Utils.replace(ItemRegistry.raspberryicedteaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryicedteaItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryicedteaItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:raspberryicedteaItem"));
			Utils.replace(ItemRegistry.chaiteaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chaiteaItem).func_150905_g(null), ((ItemFood)ItemRegistry.chaiteaItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:chaiteaItem"));
			Utils.replace(ItemRegistry.espressoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.espressoItem).func_150905_g(null), ((ItemFood)ItemRegistry.espressoItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("ItemRegistry:espressoItem"));
			Utils.replace(ItemRegistry.coffeeconlecheItem, new IguanaFoodPam(((ItemFood)ItemRegistry.coffeeconlecheItem).func_150905_g(null), ((ItemFood)ItemRegistry.coffeeconlecheItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:coffeeconlecheItem"));
			Utils.replace(ItemRegistry.mochaicecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mochaicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.mochaicecreamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mochaicecreamItem"));
			Utils.replace(ItemRegistry.pickledbeetsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pickledbeetsItem).func_150905_g(null), ((ItemFood)ItemRegistry.pickledbeetsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pickledbeetsItem"));
			Utils.replace(ItemRegistry.beetsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.beetsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.beetsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beetsaladItem"));
			Utils.replace(ItemRegistry.beetsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.beetsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.beetsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:beetsoupItem"));
			Utils.replace(ItemRegistry.bakedbeetsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bakedbeetsItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedbeetsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedbeetsItem"));
			Utils.replace(ItemRegistry.broccolimacItem, new IguanaFoodPam(((ItemFood)ItemRegistry.broccolimacItem).func_150905_g(null), ((ItemFood)ItemRegistry.broccolimacItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:broccolimacItem"));
			Utils.replace(ItemRegistry.broccolindipItem, new IguanaFoodPam(((ItemFood)ItemRegistry.broccolindipItem).func_150905_g(null), ((ItemFood)ItemRegistry.broccolindipItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:broccolindipItem"));
			Utils.replace(ItemRegistry.creamedbroccolisoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.creamedbroccolisoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamedbroccolisoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamedbroccolisoupItem"));
			Utils.replace(ItemRegistry.sweetpotatopieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.sweetpotatopieItem).func_150905_g(null), ((ItemFood)ItemRegistry.sweetpotatopieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sweetpotatopieItem"));
			Utils.replace(ItemRegistry.candiedsweetpotatoesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.candiedsweetpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedsweetpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedsweetpotatoesItem"));
			Utils.replace(ItemRegistry.mashedsweetpotatoesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mashedsweetpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.mashedsweetpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mashedsweetpotatoesItem"));
			Utils.replace(ItemRegistry.steamedpeasItem, new IguanaFoodPam(((ItemFood)ItemRegistry.steamedpeasItem).func_150905_g(null), ((ItemFood)ItemRegistry.steamedpeasItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:steamedpeasItem"));
			Utils.replace(ItemRegistry.splitpeasoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.splitpeasoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.splitpeasoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:splitpeasoupItem"));
			Utils.replace(ItemRegistry.pineappleupsidedowncakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineappleupsidedowncakeItem"));
			Utils.replace(ItemRegistry.pineapplehamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pineapplehamItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineapplehamItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineapplehamItem"));
			Utils.replace(ItemRegistry.pineappleyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pineappleyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pineappleyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pineappleyogurtItem"));
			Utils.replace(ItemRegistry.turnipsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.turnipsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.turnipsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:turnipsoupItem"));
			Utils.replace(ItemRegistry.roastedrootveggiemedleyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).func_150905_g(null), ((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:roastedrootveggiemedleyItem"));
			Utils.replace(ItemRegistry.bakedturnipsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bakedturnipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.bakedturnipsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bakedturnipsItem"));
			Utils.replace(ItemRegistry.gingerbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gingerbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingerbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gingerbreadItem"));
			Utils.replace(ItemRegistry.gingersnapsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gingersnapsItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingersnapsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gingersnapsItem"));
			Utils.replace(ItemRegistry.candiedgingerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.candiedgingerItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedgingerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedgingerItem"));
			Utils.replace(ItemRegistry.softpretzelandmustardItem, new IguanaFoodPam(((ItemFood)ItemRegistry.softpretzelandmustardItem).func_150905_g(null), ((ItemFood)ItemRegistry.softpretzelandmustardItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:softpretzelandmustardItem"));
			Utils.replace(ItemRegistry.spicymustardporkItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spicymustardporkItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicymustardporkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spicymustardporkItem"));
			Utils.replace(ItemRegistry.spicygreensItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spicygreensItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicygreensItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:spicygreensItem"));
			Utils.replace(ItemRegistry.garlicbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.garlicbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicbreadItem"));
			Utils.replace(ItemRegistry.garlicmashedpotatoesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.garlicmashedpotatoesItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicmashedpotatoesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicmashedpotatoesItem"));
			Utils.replace(ItemRegistry.garlicchickenItem, new IguanaFoodPam(((ItemFood)ItemRegistry.garlicchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.garlicchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:garlicchickenItem"));
			Utils.replace(ItemRegistry.summerradishsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.summerradishsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.summerradishsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:summerradishsaladItem"));
			Utils.replace(ItemRegistry.summersquashwithradishItem, new IguanaFoodPam(((ItemFood)ItemRegistry.summersquashwithradishItem).func_150905_g(null), ((ItemFood)ItemRegistry.summersquashwithradishItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:summersquashwithradishItem"));
			Utils.replace(ItemRegistry.celeryandpeanutbutterItem, new IguanaFoodPam(((ItemFood)ItemRegistry.celeryandpeanutbutterItem).func_150905_g(null), ((ItemFood)ItemRegistry.celeryandpeanutbutterItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:celeryandpeanutbutterItem"));
			Utils.replace(ItemRegistry.chickencelerycasseroleItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickencelerycasseroleItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickencelerycasseroleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickencelerycasseroleItem"));
			Utils.replace(ItemRegistry.peasandceleryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peasandceleryItem).func_150905_g(null), ((ItemFood)ItemRegistry.peasandceleryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peasandceleryItem"));
			Utils.replace(ItemRegistry.celerysoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.celerysoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.celerysoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:celerysoupItem"));
			Utils.replace(ItemRegistry.zucchinibreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinibreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinibreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinibreadItem"));
			Utils.replace(ItemRegistry.zucchinifriesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinifriesItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinifriesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinifriesItem"));
			Utils.replace(ItemRegistry.zestyzucchiniItem, new IguanaFoodPam(((ItemFood)ItemRegistry.zestyzucchiniItem).func_150905_g(null), ((ItemFood)ItemRegistry.zestyzucchiniItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zestyzucchiniItem"));
			Utils.replace(ItemRegistry.zucchinibakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.zucchinibakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.zucchinibakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:zucchinibakeItem"));
			Utils.replace(ItemRegistry.asparagusquicheItem, new IguanaFoodPam(((ItemFood)ItemRegistry.asparagusquicheItem).func_150905_g(null), ((ItemFood)ItemRegistry.asparagusquicheItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:asparagusquicheItem"));
			Utils.replace(ItemRegistry.asparagussoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.asparagussoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.asparagussoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:asparagussoupItem"));
			Utils.replace(ItemRegistry.walnutraisinbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.walnutraisinbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.walnutraisinbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:walnutraisinbreadItem"));
			Utils.replace(ItemRegistry.candiedwalnutsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.candiedwalnutsItem).func_150905_g(null), ((ItemFood)ItemRegistry.candiedwalnutsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:candiedwalnutsItem"));
			Utils.replace(ItemRegistry.brownieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.brownieItem).func_150905_g(null), ((ItemFood)ItemRegistry.brownieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:brownieItem"));
			Utils.replace(ItemRegistry.papayajuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.papayajuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.papayasmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.papayasmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayasmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayasmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.papayayogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.papayayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayayogurtItem"));
			Utils.replace(ItemRegistry.starfruitjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.starfruitsmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.starfruityogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.starfruityogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruityogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruityogurtItem"));
			Utils.replace(ItemRegistry.guacamoleItem, new IguanaFoodPam(((ItemFood)ItemRegistry.guacamoleItem).func_150905_g(null), ((ItemFood)ItemRegistry.guacamoleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:guacamoleItem"));
			Utils.replace(ItemRegistry.creamofavocadosoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.creamofavocadosoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamofavocadosoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamofavocadosoupItem"));
			Utils.replace(ItemRegistry.avocadoburritoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.avocadoburritoItem).func_150905_g(null), ((ItemFood)ItemRegistry.avocadoburritoItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:avocadoburritoItem"));
			Utils.replace(ItemRegistry.poachedpearItem, new IguanaFoodPam(((ItemFood)ItemRegistry.poachedpearItem).func_150905_g(null), ((ItemFood)ItemRegistry.poachedpearItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:poachedpearItem"));
			Utils.replace(ItemRegistry.fruitcrumbleItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fruitcrumbleItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitcrumbleItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitcrumbleItem"));
			Utils.replace(ItemRegistry.pearyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pearyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pearyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pearyogurtItem"));
			Utils.replace(ItemRegistry.plumyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.plumyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.plumyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:plumyogurtItem"));
			Utils.replace(ItemRegistry.bananasplitItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bananasplitItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananasplitItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananasplitItem"));
			Utils.replace(ItemRegistry.banananutbreadItem, new IguanaFoodPam(((ItemFood)ItemRegistry.banananutbreadItem).func_150905_g(null), ((ItemFood)ItemRegistry.banananutbreadItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:banananutbreadItem"));
			Utils.replace(ItemRegistry.bananasmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bananasmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananasmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananasmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.bananayogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.bananayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.bananayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:bananayogurtItem"));
			Utils.replace(ItemRegistry.coconutmilkItem, new IguanaFoodPam(((ItemFood)ItemRegistry.coconutmilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutmilkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutmilkItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.chickencurryItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chickencurryItem).func_150905_g(null), ((ItemFood)ItemRegistry.chickencurryItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chickencurryItem"));
			Utils.replace(ItemRegistry.coconutshrimpItem, new IguanaFoodPam(((ItemFood)ItemRegistry.coconutshrimpItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutshrimpItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutshrimpItem"));
			Utils.replace(ItemRegistry.coconutyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.coconutyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.coconutyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:coconutyogurtItem"));
			Utils.replace(ItemRegistry.orangejuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.orangechickenItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangechickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangechickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangechickenItem"));
			Utils.replace(ItemRegistry.orangesmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.orangeyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangeyogurtItem"));
			Utils.replace(ItemRegistry.peachjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.peachcobblerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachcobblerItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachcobblerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachcobblerItem"));
			Utils.replace(ItemRegistry.peachsmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachsmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachsmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachsmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.peachyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachyogurtItem"));
			Utils.replace(ItemRegistry.limejuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.limejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.keylimepieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.keylimepieItem).func_150905_g(null), ((ItemFood)ItemRegistry.keylimepieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:keylimepieItem"));
			Utils.replace(ItemRegistry.limesmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.limesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.limesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.limeyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.limeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.limeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limeyogurtItem"));
			Utils.replace(ItemRegistry.mangojuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mangojuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.mangosmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mangosmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangosmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangosmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.mangoyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mangoyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangoyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangoyogurtItem"));
			Utils.replace(ItemRegistry.pomegranatejuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pomegranatesmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatesmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatesmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatesmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pomegranateyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranateyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranateyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranateyogurtItem"));
			Utils.replace(ItemRegistry.vanillayogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.vanillayogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.vanillayogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:vanillayogurtItem"));
			Utils.replace(ItemRegistry.cinnamonrollItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cinnamonrollItem).func_150905_g(null), ((ItemFood)ItemRegistry.cinnamonrollItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cinnamonrollItem"));
			Utils.replace(ItemRegistry.frenchtoastItem, new IguanaFoodPam(((ItemFood)ItemRegistry.frenchtoastItem).func_150905_g(null), ((ItemFood)ItemRegistry.frenchtoastItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:frenchtoastItem"));
			Utils.replace(ItemRegistry.marshmellowsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.marshmellowsItem).func_150905_g(null), ((ItemFood)ItemRegistry.marshmellowsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:marshmellowsItem"));
			Utils.replace(ItemRegistry.donutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.donutItem).func_150905_g(null), ((ItemFood)ItemRegistry.donutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:donutItem"));
			Utils.replace(ItemRegistry.chocolatedonutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatedonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatedonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatedonutItem"));
			Utils.replace(ItemRegistry.powdereddonutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.powdereddonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.powdereddonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:powdereddonutItem"));
			Utils.replace(ItemRegistry.jellydonutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.jellydonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.jellydonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jellydonutItem"));
			Utils.replace(ItemRegistry.frosteddonutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.frosteddonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.frosteddonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:frosteddonutItem"));
			Utils.replace(ItemRegistry.cactussoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cactussoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.cactussoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cactussoupItem"));
			Utils.replace(ItemRegistry.wafflesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.wafflesItem).func_150905_g(null), ((ItemFood)ItemRegistry.wafflesItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:wafflesItem"));
			Utils.replace(ItemRegistry.seedsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.seedsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.seedsoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:seedsoupItem"));
			Utils.replace(ItemRegistry.softpretzelItem, new IguanaFoodPam(((ItemFood)ItemRegistry.softpretzelItem).func_150905_g(null), ((ItemFood)ItemRegistry.softpretzelItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:softpretzelItem"));
			Utils.replace(ItemRegistry.jellybeansItem, new IguanaFoodPam(((ItemFood)ItemRegistry.jellybeansItem).func_150905_g(null), ((ItemFood)ItemRegistry.jellybeansItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jellybeansItem"));
			Utils.replace(ItemRegistry.biscuitItem, new IguanaFoodPam(((ItemFood)ItemRegistry.biscuitItem).func_150905_g(null), ((ItemFood)ItemRegistry.biscuitItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:biscuitItem"));
			Utils.replace(ItemRegistry.creamcookieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.creamcookieItem).func_150905_g(null), ((ItemFood)ItemRegistry.creamcookieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:creamcookieItem"));
			Utils.replace(ItemRegistry.jaffaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.jaffaItem).func_150905_g(null), ((ItemFood)ItemRegistry.jaffaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:jaffaItem"));
			Utils.replace(ItemRegistry.friedchickenItem, new IguanaFoodPam(((ItemFood)ItemRegistry.friedchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.friedchickenItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:friedchickenItem"));
			Utils.replace(ItemRegistry.chocolatesprinklecakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatesprinklecakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatesprinklecakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatesprinklecakeItem"));
			Utils.replace(ItemRegistry.redvelvetcakeItem, new IguanaFoodPam(((ItemFood)ItemRegistry.redvelvetcakeItem).func_150905_g(null), ((ItemFood)ItemRegistry.redvelvetcakeItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:redvelvetcakeItem"));
			Utils.replace(ItemRegistry.footlongItem, new IguanaFoodPam(((ItemFood)ItemRegistry.footlongItem).func_150905_g(null), ((ItemFood)ItemRegistry.footlongItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:footlongItem"));
			Utils.replace(ItemRegistry.blueberryyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryyogurtItem"));
			Utils.replace(ItemRegistry.lemonyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonyogurtItem"));
			Utils.replace(ItemRegistry.cherryyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryyogurtItem"));
			Utils.replace(ItemRegistry.strawberryyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryyogurtItem"));
			Utils.replace(ItemRegistry.grapeyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.grapeyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapeyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:grapeyogurtItem"));
			Utils.replace(ItemRegistry.chocolateyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolateyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolateyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolateyogurtItem"));
			Utils.replace(ItemRegistry.blackberryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.blackberrycobblerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberrycobblerItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberrycobblerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberrycobblerItem"));
			Utils.replace(ItemRegistry.blackberrysmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.blackberryyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryyogurtItem"));
			Utils.replace(ItemRegistry.chocolatemilkItem, new IguanaFoodPam(((ItemFood)ItemRegistry.chocolatemilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.chocolatemilkItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:chocolatemilkItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.pumpkinyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pumpkinyogurtItem"));
			Utils.replace(ItemRegistry.raspberryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.raspberrypieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberrypieItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberrypieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberrypieItem"));
			Utils.replace(ItemRegistry.raspberrysmoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberrysmoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberrysmoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberrysmoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.raspberryyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryyogurtItem"));
			Utils.replace(ItemRegistry.cinnamonsugardonutItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cinnamonsugardonutItem).func_150905_g(null), ((ItemFood)ItemRegistry.cinnamonsugardonutItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cinnamonsugardonutItem"));
			Utils.replace(ItemRegistry.melonyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.melonyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.melonyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:melonyogurtItem"));
			Utils.replace(ItemRegistry.kiwijuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.kiwismoothieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.kiwismoothieItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwismoothieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwismoothieItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.kiwiyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.kiwiyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwiyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwiyogurtItem"));
			Utils.replace(ItemRegistry.plainyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.plainyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.plainyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:plainyogurtItem"));
			Utils.replace(ItemRegistry.appleyogurtItem, new IguanaFoodPam(((ItemFood)ItemRegistry.appleyogurtItem).func_150905_g(null), ((ItemFood)ItemRegistry.appleyogurtItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:appleyogurtItem"));
			Utils.replace(ItemRegistry.saltedsunflowerseedsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.saltedsunflowerseedsItem).func_150905_g(null), ((ItemFood)ItemRegistry.saltedsunflowerseedsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:saltedsunflowerseedsItem"));
			Utils.replace(ItemRegistry.sunflowerwheatrollsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.sunflowerwheatrollsItem).func_150905_g(null), ((ItemFood)ItemRegistry.sunflowerwheatrollsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sunflowerwheatrollsItem"));
			Utils.replace(ItemRegistry.sunflowerbroccolisaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sunflowerbroccolisaladItem"));
			Utils.replace(ItemRegistry.cranberryjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.cranberrysauceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cranberrysauceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberrysauceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberrysauceItem"));
			Utils.replace(ItemRegistry.cranberrybarItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cranberrybarItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberrybarItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberrybarItem"));
			Utils.replace(ItemRegistry.peppermintItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peppermintItem).func_150905_g(null), ((ItemFood)ItemRegistry.peppermintItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peppermintItem"));
			Utils.replace(ItemRegistry.cactusfruitjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cactusfruitjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.cactusfruitjuiceItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cactusfruitjuiceItem").setContainerItem(Items.glass_bottle));
			Utils.replace(ItemRegistry.baklavaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.baklavaItem).func_150905_g(null), ((ItemFood)ItemRegistry.baklavaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baklavaItem"));
			Utils.replace(ItemRegistry.gummybearsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gummybearsItem).func_150905_g(null), ((ItemFood)ItemRegistry.gummybearsItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gummybearsItem"));
			Utils.replace(ItemRegistry.baconmushroomburgerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.baconmushroomburgerItem).func_150905_g(null), ((ItemFood)ItemRegistry.baconmushroomburgerItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:baconmushroomburgerItem"));
			Utils.replace(ItemRegistry.fruitpunchItem, new IguanaFoodPam(((ItemFood)ItemRegistry.fruitpunchItem).func_150905_g(null), ((ItemFood)ItemRegistry.fruitpunchItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:fruitpunchItem"));
			Utils.replace(ItemRegistry.meatystewItem, new IguanaFoodPam(((ItemFood)ItemRegistry.meatystewItem).func_150905_g(null), ((ItemFood)ItemRegistry.meatystewItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:meatystewItem"));
			Utils.replace(ItemRegistry.mixedsaladItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mixedsaladItem).func_150905_g(null), ((ItemFood)ItemRegistry.mixedsaladItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mixedsaladItem"));
			Utils.replace(ItemRegistry.pinacoladaItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pinacoladaItem).func_150905_g(null), ((ItemFood)ItemRegistry.pinacoladaItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pinacoladaItem"));
			Utils.replace(ItemRegistry.shepardspieItem, new IguanaFoodPam(((ItemFood)ItemRegistry.shepardspieItem).func_150905_g(null), ((ItemFood)ItemRegistry.shepardspieItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:shepardspieItem"));
			Utils.replace(ItemRegistry.eggnogItem, new IguanaFoodPam(((ItemFood)ItemRegistry.eggnogItem).func_150905_g(null), ((ItemFood)ItemRegistry.eggnogItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:eggnogItem"));
			Utils.replace(ItemRegistry.custardItem, new IguanaFoodPam(((ItemFood)ItemRegistry.custardItem).func_150905_g(null), ((ItemFood)ItemRegistry.custardItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:custardItem"));
			Utils.replace(ItemRegistry.sushiItem, new IguanaFoodPam(((ItemFood)ItemRegistry.sushiItem).func_150905_g(null), ((ItemFood)ItemRegistry.sushiItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:sushiItem"));
			Utils.replace(ItemRegistry.gardensoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gardensoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.gardensoupItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:gardensoupItem"));
			Utils.replace(ItemRegistry.muttonrawItem, new IguanaFoodPam(((ItemFood)ItemRegistry.muttonrawItem).func_150905_g(null), ((ItemFood)ItemRegistry.muttonrawItem).func_150906_h(null), true, true).setUnlocalizedName("ItemRegistry:muttonrawItem"));
			Utils.replace(ItemRegistry.muttoncookedItem, new IguanaFoodPam(((ItemFood)ItemRegistry.muttoncookedItem).func_150905_g(null), ((ItemFood)ItemRegistry.muttoncookedItem).func_150906_h(null), true, true).setUnlocalizedName("ItemRegistry:muttoncookedItem"));
			Utils.replace(ItemRegistry.calamarirawItem, new IguanaFoodPam(((ItemFood)ItemRegistry.calamarirawItem).func_150905_g(null), ((ItemFood)ItemRegistry.calamarirawItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:calamarirawItem"));
			Utils.replace(ItemRegistry.calamaricookedItem, new IguanaFoodPam(((ItemFood)ItemRegistry.calamaricookedItem).func_150905_g(null), ((ItemFood)ItemRegistry.calamaricookedItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:calamaricookedItem"));
			Utils.replace(ItemRegistry.applejellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.applejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applejellyItem"));
			Utils.replace(ItemRegistry.applejellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.applejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.applejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:applejellysandwichItem"));
			Utils.replace(ItemRegistry.blackberryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjellyItem"));
			Utils.replace(ItemRegistry.blackberryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blackberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.blackberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blackberryjellysandwichItem"));
			Utils.replace(ItemRegistry.blueberryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjellyItem"));
			Utils.replace(ItemRegistry.blueberryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.blueberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.blueberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:blueberryjellysandwichItem"));
			Utils.replace(ItemRegistry.cherryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjellyItem"));
			Utils.replace(ItemRegistry.cherryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cherryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cherryjellysandwichItem"));
			Utils.replace(ItemRegistry.cranberryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjellyItem"));
			Utils.replace(ItemRegistry.cranberryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.cranberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.cranberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:cranberryjellysandwichItem"));
			Utils.replace(ItemRegistry.kiwijellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijellyItem"));
			Utils.replace(ItemRegistry.kiwijellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.kiwijellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.kiwijellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:kiwijellysandwichItem"));
			Utils.replace(ItemRegistry.lemonjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonjellyItem"));
			Utils.replace(ItemRegistry.lemonjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lemonjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:lemonjellysandwichItem"));
			Utils.replace(ItemRegistry.limejellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.limejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejellyItem"));
			Utils.replace(ItemRegistry.limejellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.limejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.limejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:limejellysandwichItem"));
			Utils.replace(ItemRegistry.mangojellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mangojellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojellyItem"));
			Utils.replace(ItemRegistry.mangojellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mangojellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.mangojellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:mangojellysandwichItem"));
			Utils.replace(ItemRegistry.orangejellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejellyItem"));
			Utils.replace(ItemRegistry.orangejellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.orangejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:orangejellysandwichItem"));
			Utils.replace(ItemRegistry.papayajellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.papayajellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajellyItem"));
			Utils.replace(ItemRegistry.papayajellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.papayajellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.papayajellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:papayajellysandwichItem"));
			Utils.replace(ItemRegistry.peachjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjellyItem"));
			Utils.replace(ItemRegistry.peachjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.peachjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.peachjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:peachjellysandwichItem"));
			Utils.replace(ItemRegistry.pomegranatejellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellyItem"));
			Utils.replace(ItemRegistry.pomegranatejellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pomegranatejellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.pomegranatejellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellysandwichItem"));
			Utils.replace(ItemRegistry.raspberryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjellyItem"));
			Utils.replace(ItemRegistry.raspberryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.raspberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.raspberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:raspberryjellysandwichItem"));
			Utils.replace(ItemRegistry.starfruitjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjellyItem"));
			Utils.replace(ItemRegistry.starfruitjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.starfruitjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.starfruitjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:starfruitjellysandwichItem"));
			Utils.replace(ItemRegistry.strawberryjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjellyItem"));
			Utils.replace(ItemRegistry.strawberryjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:strawberryjellysandwichItem"));
			Utils.replace(ItemRegistry.watermelonjellyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.watermelonjellyItem).func_150905_g(null), ((ItemFood)ItemRegistry.watermelonjellyItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:watermelonjellyItem"));
			Utils.replace(ItemRegistry.watermelonjellysandwichItem, new IguanaFoodPam(((ItemFood)ItemRegistry.watermelonjellysandwichItem).func_150905_g(null), ((ItemFood)ItemRegistry.watermelonjellysandwichItem).func_150906_h(null), false, true).setUnlocalizedName("ItemRegistry:watermelonjellysandwichItem"));

			Utils.replace(ItemRegistry.cherrysodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.cherrysodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.cherrysodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:cherrysodaItem"));
			Utils.replace(ItemRegistry.colasodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.colasodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.colasodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:colasodaItem"));
			Utils.replace(ItemRegistry.gingersodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.gingersodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingersodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:gingersodaItem"));
			Utils.replace(ItemRegistry.grapesodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.grapesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.grapesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:grapesodaItem"));
			Utils.replace(ItemRegistry.lemonlimesodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.lemonlimesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.lemonlimesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:lemonlimesodaItem"));
			Utils.replace(ItemRegistry.orangesodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.orangesodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.orangesodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:orangesodaItem"));
			Utils.replace(ItemRegistry.rootbeersodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.rootbeersodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.rootbeersodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:rootbeersodaItem"));
			Utils.replace(ItemRegistry.strawberrysodaItem, new IguanaFoodPamPotion(((ItemFood)ItemRegistry.strawberrysodaItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberrysodaItem).func_150906_h(null), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:strawberrysodaItem"));

			Utils.replace(ItemRegistry.caramelicecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.caramelicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.caramelicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:caramelicecreamItem"));
			Utils.replace(ItemRegistry.mintchocolatechipicemcreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:mintchocolatechipicecreamItem"));
			Utils.replace(ItemRegistry.strawberryicecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.strawberryicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.strawberryicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:strawberryicecreamItem"));
			Utils.replace(ItemRegistry.vanillaicecreamItem, new IguanaFoodPam(((ItemFood)ItemRegistry.vanillaicecreamItem).func_150905_g(null), ((ItemFood)ItemRegistry.vanillaicecreamItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:vanillaicecreamItem"));

			Utils.replace(ItemRegistry.ediblerootItem, new ItemSeedFood(((ItemFood)ItemRegistry.ediblerootItem).func_150905_g(null), ((ItemFood)ItemRegistry.ediblerootItem).func_150906_h(null), BlockRegistry.pamspiceleafCrop, Blocks.farmland).setUnlocalizedName("ItemRegistry:ediblerootItem"));

			Utils.replace(ItemRegistry.gingerchickenItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gingerchickenItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingerchickenItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:gingerchickenItem"));

			Utils.replace(ItemRegistry.oldworldveggiesoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.oldworldveggiesoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.oldworldveggiesoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:oldworldveggiesoupItem"));
			Utils.replace(ItemRegistry.spicebunItem, new IguanaFoodPam(((ItemFood)ItemRegistry.spicebunItem).func_150905_g(null), ((ItemFood)ItemRegistry.spicebunItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:spicebunItem"));
			Utils.replace(ItemRegistry.gingeredrhubarbtartItem, new IguanaFoodPam(((ItemFood)ItemRegistry.gingeredrhubarbtartItem).func_150905_g(null), ((ItemFood)ItemRegistry.gingeredrhubarbtartItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:gingeredrhubarbtartItem"));
			Utils.replace(ItemRegistry.lambbarleysoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.lambbarleysoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.lambbarleysoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:lambbarleysoupItem"));
			Utils.replace(ItemRegistry.honeylemonlambItem, new IguanaFoodPam(((ItemFood)ItemRegistry.honeylemonlambItem).func_150905_g(null), ((ItemFood)ItemRegistry.honeylemonlambItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:honeylemonlambItem"));
			Utils.replace(ItemRegistry.pumpkinoatsconesItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pumpkinoatsconesItem).func_150905_g(null), ((ItemFood)ItemRegistry.pumpkinoatsconesItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:pumpkinoatsconesItem"));
			Utils.replace(ItemRegistry.beefjerkyItem, new IguanaFoodPam(((ItemFood)ItemRegistry.beefjerkyItem).func_150905_g(null), ((ItemFood)ItemRegistry.beefjerkyItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:beefjerkyItem"));
			Utils.replace(ItemRegistry.plumjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.plumjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.plumjuiceItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:plumjuiceItem"));
			Utils.replace(ItemRegistry.pearjuiceItem, new IguanaFoodPam(((ItemFood)ItemRegistry.pearjuiceItem).func_150905_g(null), ((ItemFood)ItemRegistry.pearjuiceItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:pearjuiceItem"));
			Utils.replace(ItemRegistry.ovenroastedcauliflowerItem, new IguanaFoodPam(((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).func_150905_g(null), ((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:ovenroastedcauliflowerItem"));
			Utils.replace(ItemRegistry.leekbaconsoupItem, new IguanaFoodPam(((ItemFood)ItemRegistry.leekbaconsoupItem).func_150905_g(null), ((ItemFood)ItemRegistry.leekbaconsoupItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:leekbaconsoupItem"));
			Utils.replace(ItemRegistry.herbbutterparsnipsItem, new IguanaFoodPam(((ItemFood)ItemRegistry.herbbutterparsnipsItem).func_150905_g(null), ((ItemFood)ItemRegistry.herbbutterparsnipsItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:herbbutterparsnipsItem"));
			Utils.replace(ItemRegistry.scallionbakedpotatoItem, new IguanaFoodPam(((ItemFood)ItemRegistry.scallionbakedpotatoItem).func_150905_g(null), ((ItemFood)ItemRegistry.scallionbakedpotatoItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:scallionbakedpotatoItem"));
			Utils.replace(ItemRegistry.soymilkItem, new IguanaFoodPam(((ItemFood)ItemRegistry.soymilkItem).func_150905_g(null), ((ItemFood)ItemRegistry.soymilkItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:soymilkItem"));
			Utils.replace(ItemRegistry.firmtofuItem, new IguanaFoodPam(((ItemFood)ItemRegistry.firmtofuItem).func_150905_g(null), ((ItemFood)ItemRegistry.firmtofuItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:firmtofuItem"));
			Utils.replace(ItemRegistry.silkentofuItem, new IguanaFoodPam(((ItemFood)ItemRegistry.silkentofuItem).func_150905_g(null), ((ItemFood)ItemRegistry.silkentofuItem).func_150906_h(null), false).setUnlocalizedName("ItemRegistry:silkentofuItem"));
		}

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.grilledasparagusItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledasparagusID, ((ItemFood)PamHarvestCraft.grilledasparagusItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.grilledasparagusItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:grilledasparagusItem");
		else
			PamHarvestCraft.grilledasparagusItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledasparagusID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:grilledasparagusItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.avocadoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoID, ((ItemFood)PamHarvestCraft.avocadoItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.avocadoItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:avocadoItem");
		else
			PamHarvestCraft.avocadoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:avocadoItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.bananaItem = new IguanaFoodPam(HarvestConfigurationHandler.bananaID, ((ItemFood)PamHarvestCraft.bananaItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.bananaItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:bananaItem");
		else
			PamHarvestCraft.bananaItem = new IguanaFoodPam(HarvestConfigurationHandler.bananaID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:bananaItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.bellpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.bellpepperID, ((ItemFood)PamHarvestCraft.bellpepperItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.bellpepperItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:bellpepperItem");
		else
			PamHarvestCraft.bellpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.bellpepperID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:bellpepperItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.blackberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryID, ((ItemFood)PamHarvestCraft.blackberryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.blackberryItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:blackberryItem");
		else
			PamHarvestCraft.blackberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:blackberryItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.blueberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryID, ((ItemFood)PamHarvestCraft.blueberryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.blueberryItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:blueberryItem");
		else
			PamHarvestCraft.blueberryItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:blueberryItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cactusfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitID, ((ItemFood)PamHarvestCraft.cactusfruitItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cactusfruitItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:cactusfruitItem");
		else
			PamHarvestCraft.cactusfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:cactusfruitItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cantaloupeItem = new IguanaFoodPam(HarvestConfigurationHandler.cantaloupeID, ((ItemFood)PamHarvestCraft.cantaloupeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cantaloupeItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:cantaloupeItem");
		else
			PamHarvestCraft.cantaloupeItem = new IguanaFoodPam(HarvestConfigurationHandler.cantaloupeID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:cantaloupeItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cherryItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryID, ((ItemFood)PamHarvestCraft.cherryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cherryItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:cherryItem");
		else
			PamHarvestCraft.cherryItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cherryItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.chilipepperItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipepperID, ((ItemFood)PamHarvestCraft.chilipepperItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.chilipepperItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:chilipepperItem");
		else
			PamHarvestCraft.chilipepperItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipepperID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:chilipepperItem");

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.coconutItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutID, ((ItemFood)PamHarvestCraft.coconutItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.coconutItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:coconutItem");
			PamHarvestCraft.toastedcoconutItem = new IguanaFoodPam(HarvestConfigurationHandler.toastedcoconutID, ((ItemFood)PamHarvestCraft.toastedcoconutItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.toastedcoconutItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:toastedcoconutItem");
		} else {
			PamHarvestCraft.coconutItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:coconutItem");
			PamHarvestCraft.toastedcoconutItem = new IguanaFoodPam(HarvestConfigurationHandler.toastedcoconutID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:toastedcoconutItem");
		}
		
		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.coffeeItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeID, ((ItemFood)PamHarvestCraft.coffeeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.coffeeItem).func_150906_h(null), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeItem");
		else
			PamHarvestCraft.coffeeItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeID, 0, 0.0F, false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("PamHarvestCraft:coffeeItem");

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.cornItem = new IguanaFoodPam(HarvestConfigurationHandler.cornID, ((ItemFood)PamHarvestCraft.cornItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cornItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:cornItem");
			PamHarvestCraft.popcornItem = new IguanaFoodPam(HarvestConfigurationHandler.popcornID, ((ItemFood)PamHarvestCraft.popcornItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.popcornItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:popcornItem");
		} else {
			PamHarvestCraft.cornItem = new IguanaFoodPam(HarvestConfigurationHandler.cornID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cornItem");
			PamHarvestCraft.popcornItem = new IguanaFoodPam(HarvestConfigurationHandler.popcornID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:popcornItem");
		}

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cranberryItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryID, ((ItemFood)PamHarvestCraft.cranberryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cranberryItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:cranberryItem");
		else
			PamHarvestCraft.cranberryItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:cranberryItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.cucumberItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumberID, ((ItemFood)PamHarvestCraft.cucumberItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.cucumberItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:cucumberItem");
		else
			PamHarvestCraft.cucumberItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumberID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:cucumberItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.dragonfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.dragonfruitID, ((ItemFood)PamHarvestCraft.dragonfruitItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.dragonfruitItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:dragonfruitItem");
		else
			PamHarvestCraft.dragonfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.dragonfruitID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:dragonfruitItem");

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.eggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantID, ((ItemFood)PamHarvestCraft.eggplantItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.eggplantItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:eggplantItem");
			PamHarvestCraft.grilledeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledeggplantID, ((ItemFood)PamHarvestCraft.grilledeggplantItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.grilledeggplantItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:grilledeggplantItem");
		} else {
			PamHarvestCraft.eggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:eggplantItem");
			PamHarvestCraft.grilledeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledeggplantID, 2, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:grilledeggplantItem");
		}

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.grapeItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeID, ((ItemFood)PamHarvestCraft.grapeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.grapeItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:grapeItem");
			PamHarvestCraft.raisinsItem = new IguanaFoodPam(HarvestConfigurationHandler.raisinsID, ((ItemFood)PamHarvestCraft.raisinsItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.raisinsItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:raisinsItem");
		} else {
			PamHarvestCraft.grapeItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:grapeItem");
			PamHarvestCraft.raisinsItem = new IguanaFoodPam(HarvestConfigurationHandler.raisinsID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:raisinsItem");
		}

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.kiwiItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiID, ((ItemFood)PamHarvestCraft.kiwiItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.kiwiItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:kiwiItem");
		else
			PamHarvestCraft.kiwiItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:kiwiItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.lemonItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonID, ((ItemFood)PamHarvestCraft.lemonItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.lemonItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:lemonItem");
		else
			PamHarvestCraft.lemonItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:lemonItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.limeItem = new IguanaFoodPam(HarvestConfigurationHandler.limeID, ((ItemFood)PamHarvestCraft.limeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.limeItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:limeItem");
		else
			PamHarvestCraft.limeItem = new IguanaFoodPam(HarvestConfigurationHandler.limeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:limeItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.lettuceItem = new IguanaFoodPam(HarvestConfigurationHandler.lettuceID, ((ItemFood)PamHarvestCraft.lettuceItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.lettuceItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:lettuceItem");
		else
			PamHarvestCraft.lettuceItem = new IguanaFoodPam(HarvestConfigurationHandler.lettuceID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:lettuceItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.mangoItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoID, ((ItemFood)PamHarvestCraft.mangoItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.mangoItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:mangoItem");
		else
			PamHarvestCraft.mangoItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:mangoItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.nutmegItem = new IguanaFoodPam(HarvestConfigurationHandler.nutmegID, ((ItemFood)PamHarvestCraft.nutmegItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.nutmegItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:nutmegItem");
		else
			PamHarvestCraft.nutmegItem = new IguanaFoodPam(HarvestConfigurationHandler.nutmegID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:nutmegItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.oliveItem = new IguanaFoodPam(HarvestConfigurationHandler.oliveID, ((ItemFood)PamHarvestCraft.oliveItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.oliveItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:oliveItem");
		else
			PamHarvestCraft.oliveItem = new IguanaFoodPam(HarvestConfigurationHandler.oliveID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:oliveItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.orangeItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeID, ((ItemFood)PamHarvestCraft.orangeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.orangeItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:orangeItem");
		else
			PamHarvestCraft.orangeItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:orangeItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.papayaItem = new IguanaFoodPam(HarvestConfigurationHandler.papayaID, ((ItemFood)PamHarvestCraft.papayaItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.papayaItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:papayaItem");
		else
			PamHarvestCraft.papayaItem = new IguanaFoodPam(HarvestConfigurationHandler.papayaID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:papayaItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.peachItem = new IguanaFoodPam(HarvestConfigurationHandler.peachID, ((ItemFood)PamHarvestCraft.peachItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.peachItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:peachItem");
		else
			PamHarvestCraft.peachItem = new IguanaFoodPam(HarvestConfigurationHandler.peachID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:peachItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.pearItem = new IguanaFoodPam(HarvestConfigurationHandler.pearID, ((ItemFood)PamHarvestCraft.pearItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.pearItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:pearItem");
		else
			PamHarvestCraft.pearItem = new IguanaFoodPam(HarvestConfigurationHandler.pearID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:pearItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.plumItem = new IguanaFoodPam(HarvestConfigurationHandler.plumID, ((ItemFood)PamHarvestCraft.plumItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.plumItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:plumItem");
		else
			PamHarvestCraft.plumItem = new IguanaFoodPam(HarvestConfigurationHandler.plumID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:plumItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.pomegranateItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateID, ((ItemFood)PamHarvestCraft.pomegranateItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.pomegranateItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:pomegranateItem");
		else
			PamHarvestCraft.pomegranateItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:pomegranateItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.raspberryItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryID, ((ItemFood)PamHarvestCraft.raspberryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.raspberryItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:raspberryItem");
		else
			PamHarvestCraft.raspberryItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:raspberryItem");

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.riceItem = new IguanaFoodPam(HarvestConfigurationHandler.riceID, ((ItemFood)PamHarvestCraft.riceItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.riceItem).func_150906_h(null), true).setUnlocalizedName("PamHarvestCraft:riceItem");
			PamHarvestCraft.ricecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.ricecakeID, ((ItemFood)PamHarvestCraft.ricecakeItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.ricecakeItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:ricecakeItem");
		} else {
			PamHarvestCraft.riceItem = new IguanaFoodPam(HarvestConfigurationHandler.riceID, 1, 0.05F, true).setUnlocalizedName("PamHarvestCraft:riceItem");
			PamHarvestCraft.ricecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.ricecakeID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:ricecakeItem");
		}

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.spiceleafItem = new IguanaFoodPam(HarvestConfigurationHandler.spiceleafID, ((ItemFood)PamHarvestCraft.spiceleafItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.spiceleafItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:spiceleafItem");
		else
			PamHarvestCraft.spiceleafItem = new IguanaFoodPam(HarvestConfigurationHandler.spiceleafID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:spiceleafItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.starfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitID, ((ItemFood)PamHarvestCraft.starfruitItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.starfruitItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:starfruitItem");
		else
			PamHarvestCraft.starfruitItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:starfruitItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.strawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryID, ((ItemFood)PamHarvestCraft.strawberryItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.strawberryItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:strawberryItem");
		else
			PamHarvestCraft.strawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:strawberryItem");

		if (IguanaConfig.modifyFoodValues == false) {
			PamHarvestCraft.tealeafItem = new IguanaFoodPam(HarvestConfigurationHandler.tealeafID, ((ItemFood)PamHarvestCraft.tealeafItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.tealeafItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:tealeafItem");
			PamHarvestCraft.teaItem = new IguanaFoodPam(HarvestConfigurationHandler.teaID, ((ItemFood)PamHarvestCraft.teaItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.teaItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:teaItem");
		} else {
			PamHarvestCraft.tealeafItem = new IguanaFoodPam(HarvestConfigurationHandler.tealeafID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:tealeafItem");
			PamHarvestCraft.teaItem = new IguanaFoodPam(HarvestConfigurationHandler.teaID, 2, 0.1F, false, true).setUnlocalizedName("PamHarvestCraft:teaItem");
		}

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.tomatoItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatoID, ((ItemFood)PamHarvestCraft.tomatoItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.tomatoItem).func_150906_h(null), false).setUnlocalizedName("PamHarvestCraft:tomatoItem");
		else
			PamHarvestCraft.tomatoItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatoID, 1, 0.05F, false).setUnlocalizedName("PamHarvestCraft:tomatoItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.walnutItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutID, ((ItemFood)PamHarvestCraft.walnutItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.walnutItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:walnutItem");
		else
			PamHarvestCraft.walnutItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutID, 1, 0.05F, false, true).setUnlocalizedName("PamHarvestCraft:walnutItem");

		if (IguanaConfig.modifyFoodValues == false)
			PamHarvestCraft.zucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchiniID, ((ItemFood)PamHarvestCraft.zucchiniItem).func_150905_g(null), ((ItemFood)PamHarvestCraft.zucchiniItem).func_150906_h(null), false, true).setUnlocalizedName("PamHarvestCraft:zucchiniItem");
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
		if (!ThaumcraftApi.exists(item, -1)) ThaumcraftApi.registerObjectTag(new ItemStack(item,1), new int[] {-1}, aspects);
	}
}
