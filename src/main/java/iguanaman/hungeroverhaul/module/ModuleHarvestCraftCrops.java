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

			ItemRegistry.toastItem = new IguanaFoodPam(HarvestConfigurationHandler.toastID, ((ItemFood)ItemRegistry.toastItem).getHealAmount(), ((ItemFood)ItemRegistry.toastItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:toastItem");
			ItemRegistry.cheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseID, ((ItemFood)ItemRegistry.cheeseItem).getHealAmount(), ((ItemFood)ItemRegistry.cheeseItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cheeseItem");
			ItemRegistry.icecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.icecreamID, ((ItemFood)ItemRegistry.icecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.icecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:icecreamItem");
			ItemRegistry.grilledcheeseItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledcheeseID, ((ItemFood)ItemRegistry.grilledcheeseItem).getHealAmount(), ((ItemFood)ItemRegistry.grilledcheeseItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grilledcheeseItem");
			ItemRegistry.applejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.applejuiceID, ((ItemFood)ItemRegistry.applejuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.applejuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:applejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.applesauceItem = new IguanaFoodPam(HarvestConfigurationHandler.applesauceID, ((ItemFood)ItemRegistry.applesauceItem).getHealAmount(), ((ItemFood)ItemRegistry.applesauceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:applesauceItem");
			ItemRegistry.applepieItem = new IguanaFoodPam(HarvestConfigurationHandler.applepieID, ((ItemFood)ItemRegistry.applepieItem).getHealAmount(), ((ItemFood)ItemRegistry.applepieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:applepieItem");
			ItemRegistry.caramelappleItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelappleID, ((ItemFood)ItemRegistry.caramelappleItem).getHealAmount(), ((ItemFood)ItemRegistry.caramelappleItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:caramelappleItem");
			ItemRegistry.pumpkinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinbreadID, ((ItemFood)ItemRegistry.pumpkinbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.pumpkinbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pumpkinbreadItem");
			ItemRegistry.roastedpumpkinseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedpumpkinseedsID, ((ItemFood)ItemRegistry.roastedpumpkinseedsItem).getHealAmount(), ((ItemFood)ItemRegistry.roastedpumpkinseedsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:roastedpumpkinseedsItem");
			ItemRegistry.pumpkinsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinsoupID, ((ItemFood)ItemRegistry.pumpkinsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.pumpkinsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pumpkinsoupItem");
			ItemRegistry.melonjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.melonjuiceID, ((ItemFood)ItemRegistry.melonjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.melonjuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:melonjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.melonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.melonsmoothieID, ((ItemFood)ItemRegistry.melonsmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.melonsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:melonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotjuiceID, ((ItemFood)ItemRegistry.carrotjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.carrotjuiceItem).getSaturationModifier(), false, true).setAlwaysEdible().setUnlocalizedName("ItemRegistry:carrotjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.carrotcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotcakeID, ((ItemFood)ItemRegistry.carrotcakeItem).getHealAmount(), ((ItemFood)ItemRegistry.carrotcakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:carrotcakeItem");
			ItemRegistry.carrotsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.carrotsoupID, ((ItemFood)ItemRegistry.carrotsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.carrotsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:carrotsoupItem");
			ItemRegistry.glazedcarrotsItem = new IguanaFoodPam(HarvestConfigurationHandler.glazedcarrotsID, ((ItemFood)ItemRegistry.glazedcarrotsItem).getHealAmount(), ((ItemFood)ItemRegistry.glazedcarrotsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:glazedcarrotsItem");
			ItemRegistry.butteredpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.butteredpotatoID, ((ItemFood)ItemRegistry.butteredpotatoItem).getHealAmount(), ((ItemFood)ItemRegistry.butteredpotatoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:butteredpotatoItem");
			ItemRegistry.loadedbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.loadedbakedpotatoID, ((ItemFood)ItemRegistry.loadedbakedpotatoItem).getHealAmount(), ((ItemFood)ItemRegistry.loadedbakedpotatoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:loadedbakedpotatoItem");
			ItemRegistry.mashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedpotatoesID, ((ItemFood)ItemRegistry.mashedpotatoesItem).getHealAmount(), ((ItemFood)ItemRegistry.mashedpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mashedpotatoesItem");
			ItemRegistry.potatosaladItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosaladID, ((ItemFood)ItemRegistry.potatosaladItem).getHealAmount(), ((ItemFood)ItemRegistry.potatosaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:potatosaladItem");
			ItemRegistry.potatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.potatosoupID, ((ItemFood)ItemRegistry.potatosoupItem).getHealAmount(), ((ItemFood)ItemRegistry.potatosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:potatosoupItem");
			ItemRegistry.friesItem = new IguanaFoodPam(HarvestConfigurationHandler.friesID, ((ItemFood)ItemRegistry.friesItem).getHealAmount(), ((ItemFood)ItemRegistry.friesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:friesItem");
			ItemRegistry.grilledmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledmushroomID, ((ItemFood)ItemRegistry.grilledmushroomItem).getHealAmount(), ((ItemFood)ItemRegistry.grilledmushroomItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grilledmushroomItem");
			ItemRegistry.stuffedmushroomItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedmushroomID, ((ItemFood)ItemRegistry.stuffedmushroomItem).getHealAmount(), ((ItemFood)ItemRegistry.stuffedmushroomItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:stuffedmushroomItem");
			ItemRegistry.chickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.chickensandwichID, ((ItemFood)ItemRegistry.chickensandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.chickensandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickensandwichItem");
			ItemRegistry.chickennoodlesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.chickennoodlesoupID, ((ItemFood)ItemRegistry.chickennoodlesoupItem).getHealAmount(), ((ItemFood)ItemRegistry.chickennoodlesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickennoodlesoupItem");
			ItemRegistry.chickenpotpieItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenpotpieID, ((ItemFood)ItemRegistry.chickenpotpieItem).getHealAmount(), ((ItemFood)ItemRegistry.chickenpotpieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickenpotpieItem");
			ItemRegistry.breadedporkchopItem = new IguanaFoodPam(HarvestConfigurationHandler.breadedporkchopID, ((ItemFood)ItemRegistry.breadedporkchopItem).getHealAmount(), ((ItemFood)ItemRegistry.breadedporkchopItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:breadedporkchopItem");
			ItemRegistry.hotdogItem = new IguanaFoodPam(HarvestConfigurationHandler.hotdogID, ((ItemFood)ItemRegistry.hotdogItem).getHealAmount(), ((ItemFood)ItemRegistry.hotdogItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:hotdogItem");
			ItemRegistry.bakedhamItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedhamID, ((ItemFood)ItemRegistry.bakedhamItem).getHealAmount(), ((ItemFood)ItemRegistry.bakedhamItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bakedhamItem");
			ItemRegistry.hamburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.hamburgerID, ((ItemFood)ItemRegistry.hamburgerItem).getHealAmount(), ((ItemFood)ItemRegistry.hamburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:hamburgerItem");
			ItemRegistry.cheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.cheeseburgerID, ((ItemFood)ItemRegistry.cheeseburgerItem).getHealAmount(), ((ItemFood)ItemRegistry.cheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cheeseburgerItem");
			ItemRegistry.baconcheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconcheeseburgerID, ((ItemFood)ItemRegistry.baconcheeseburgerItem).getHealAmount(), ((ItemFood)ItemRegistry.baconcheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:baconcheeseburgerItem");
			ItemRegistry.potroastItem = new IguanaFoodPam(HarvestConfigurationHandler.potroastID, ((ItemFood)ItemRegistry.potroastItem).getHealAmount(), ((ItemFood)ItemRegistry.potroastItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:potroastItem");
			ItemRegistry.fishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsandwichID, ((ItemFood)ItemRegistry.fishsandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.fishsandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishsandwichItem");
			ItemRegistry.fishsticksItem = new IguanaFoodPam(HarvestConfigurationHandler.fishsticksID, ((ItemFood)ItemRegistry.fishsticksItem).getHealAmount(), ((ItemFood)ItemRegistry.fishsticksItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishsticksItem");
			ItemRegistry.fishandchipsItem = new IguanaFoodPam(HarvestConfigurationHandler.fishandchipsID, ((ItemFood)ItemRegistry.fishandchipsItem).getHealAmount(), ((ItemFood)ItemRegistry.fishandchipsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishandchipsItem");
			ItemRegistry.friedeggItem = new IguanaFoodPam(HarvestConfigurationHandler.friedeggID, ((ItemFood)ItemRegistry.friedeggItem).getHealAmount(), ((ItemFood)ItemRegistry.friedeggItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:friedeggItem");
			ItemRegistry.scrambledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.scrambledeggID, ((ItemFood)ItemRegistry.scrambledeggItem).getHealAmount(), ((ItemFood)ItemRegistry.scrambledeggItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:scrambledeggItem");
			ItemRegistry.boiledeggItem = new IguanaFoodPam(HarvestConfigurationHandler.boiledeggID, ((ItemFood)ItemRegistry.boiledeggItem).getHealAmount(), ((ItemFood)ItemRegistry.boiledeggItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:boiledeggItem");
			ItemRegistry.eggsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.eggsaladID, ((ItemFood)ItemRegistry.eggsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.eggsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:eggsaladItem");
			ItemRegistry.caramelItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelID, ((ItemFood)ItemRegistry.caramelItem).getHealAmount(), ((ItemFood)ItemRegistry.caramelItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:caramelItem");
			ItemRegistry.taffyItem = new IguanaFoodPam(HarvestConfigurationHandler.taffyID, ((ItemFood)ItemRegistry.taffyItem).getHealAmount(), ((ItemFood)ItemRegistry.taffyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:taffyItem");
			ItemRegistry.spidereyesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.spidereyesoupID, ((ItemFood)ItemRegistry.spidereyesoupItem).getHealAmount(), ((ItemFood)ItemRegistry.spidereyesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:spidereyesoupItem");
			ItemRegistry.zombiejerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.zombiejerkyID, ((ItemFood)ItemRegistry.zombiejerkyItem).getHealAmount(), ((ItemFood)ItemRegistry.zombiejerkyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:zombiejerkyItem");
			ItemRegistry.chocolatebarItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatebarID, ((ItemFood)ItemRegistry.chocolatebarItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatebarItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatebarItem");
			ItemRegistry.hotchocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.hotchocolateID, ((ItemFood)ItemRegistry.hotchocolateItem).getHealAmount(), ((ItemFood)ItemRegistry.hotchocolateItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:hotchocolateItem");
			ItemRegistry.chocolateicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateicecreamID, ((ItemFood)ItemRegistry.chocolateicecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolateicecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolateicecreamItem");
			ItemRegistry.vegetablesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetablesoupID, ((ItemFood)ItemRegistry.vegetablesoupItem).getHealAmount(), ((ItemFood)ItemRegistry.vegetablesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:vegetablesoupItem");
			ItemRegistry.stockItem = new IguanaFoodPam(HarvestConfigurationHandler.stockID, ((ItemFood)ItemRegistry.stockItem).getHealAmount(), ((ItemFood)ItemRegistry.stockItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:stockItem");
			ItemRegistry.fruitsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitsaladID, ((ItemFood)ItemRegistry.fruitsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.fruitsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fruitsaladItem");
			ItemRegistry.spagettiItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiID, ((ItemFood)ItemRegistry.spagettiItem).getHealAmount(), ((ItemFood)ItemRegistry.spagettiItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:spagettiItem");
			ItemRegistry.spagettiandmeatballsItem = new IguanaFoodPam(HarvestConfigurationHandler.spagettiandmeatballsID, ((ItemFood)ItemRegistry.spagettiandmeatballsItem).getHealAmount(), ((ItemFood)ItemRegistry.spagettiandmeatballsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:spagettiandmeatballsItem");
			ItemRegistry.tomatosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.tomatosoupID, ((ItemFood)ItemRegistry.tomatosoupItem).getHealAmount(), ((ItemFood)ItemRegistry.tomatosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:tomatosoupItem");
			ItemRegistry.chickenparmasanItem = new IguanaFoodPam(HarvestConfigurationHandler.chickenparmasanID, ((ItemFood)ItemRegistry.chickenparmasanItem).getHealAmount(), ((ItemFood)ItemRegistry.chickenparmasanItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickenparmasanItem");
			ItemRegistry.pizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.pizzaID, ((ItemFood)ItemRegistry.pizzaItem).getHealAmount(), ((ItemFood)ItemRegistry.pizzaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pizzaItem");
			ItemRegistry.springsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.springsaladID, ((ItemFood)ItemRegistry.springsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.springsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:springsaladItem");
			ItemRegistry.porklettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.porklettucewrapID, ((ItemFood)ItemRegistry.porklettucewrapItem).getHealAmount(), ((ItemFood)ItemRegistry.porklettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:porklettucewrapItem");
			ItemRegistry.fishlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.fishlettucewrapID, ((ItemFood)ItemRegistry.fishlettucewrapItem).getHealAmount(), ((ItemFood)ItemRegistry.fishlettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishlettucewrapItem");
			ItemRegistry.bltItem = new IguanaFoodPam(HarvestConfigurationHandler.bltID, ((ItemFood)ItemRegistry.bltItem).getHealAmount(), ((ItemFood)ItemRegistry.bltItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bltItem");
			ItemRegistry.leafychickensandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafychickensandwichID, ((ItemFood)ItemRegistry.leafychickensandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.leafychickensandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:leafychickensandwichItem");
			ItemRegistry.leafyfishsandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.leafyfishsandwichID, ((ItemFood)ItemRegistry.leafyfishsandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.leafyfishsandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:leafyfishsandwichItem");
			ItemRegistry.deluxecheeseburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.deluxecheeseburgerID, ((ItemFood)ItemRegistry.deluxecheeseburgerItem).getHealAmount(), ((ItemFood)ItemRegistry.deluxecheeseburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:deluxecheeseburgerItem");
			ItemRegistry.delightedmealItem = new IguanaFoodPam(HarvestConfigurationHandler.delightedmealID, ((ItemFood)ItemRegistry.delightedmealItem).getHealAmount(), ((ItemFood)ItemRegistry.delightedmealItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:delightedmealItem");
			ItemRegistry.onionsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.onionsoupID, ((ItemFood)ItemRegistry.onionsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.onionsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:onionsoupItem");
			ItemRegistry.potatocakesItem = new IguanaFoodPam(HarvestConfigurationHandler.potatocakesID, ((ItemFood)ItemRegistry.potatocakesItem).getHealAmount(), ((ItemFood)ItemRegistry.potatocakesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:potatocakesItem");
			ItemRegistry.hashItem = new IguanaFoodPam(HarvestConfigurationHandler.hashID, ((ItemFood)ItemRegistry.hashItem).getHealAmount(), ((ItemFood)ItemRegistry.hashItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:hashItem");
			ItemRegistry.braisedonionsItem = new IguanaFoodPam(HarvestConfigurationHandler.braisedonionsID, ((ItemFood)ItemRegistry.braisedonionsItem).getHealAmount(), ((ItemFood)ItemRegistry.braisedonionsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:braisedonionsItem");
			ItemRegistry.heartybreakfastItem = new IguanaFoodPam(HarvestConfigurationHandler.heartybreakfastID, ((ItemFood)ItemRegistry.heartybreakfastItem).getHealAmount(), ((ItemFood)ItemRegistry.heartybreakfastItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:heartybreakfastItem");
			ItemRegistry.cornonthecobItem = new IguanaFoodPam(HarvestConfigurationHandler.cornonthecobID, ((ItemFood)ItemRegistry.cornonthecobItem).getHealAmount(), ((ItemFood)ItemRegistry.cornonthecobItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cornonthecobItem");
			ItemRegistry.cornbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.cornbreadID, ((ItemFood)ItemRegistry.cornbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.cornbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cornbreadItem");
			ItemRegistry.tortillaItem = new IguanaFoodPam(HarvestConfigurationHandler.tortillaID, ((ItemFood)ItemRegistry.tortillaItem).getHealAmount(), ((ItemFood)ItemRegistry.tortillaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:tortillaItem");
			ItemRegistry.nachoesItem = new IguanaFoodPam(HarvestConfigurationHandler.nachoesID, ((ItemFood)ItemRegistry.nachoesItem).getHealAmount(), ((ItemFood)ItemRegistry.nachoesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:nachoesItem");
			ItemRegistry.tacoItem = new IguanaFoodPam(HarvestConfigurationHandler.tacoID, ((ItemFood)ItemRegistry.tacoItem).getHealAmount(), ((ItemFood)ItemRegistry.tacoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:tacoItem");
			ItemRegistry.fishtacoItem = new IguanaFoodPam(HarvestConfigurationHandler.fishtacoID, ((ItemFood)ItemRegistry.fishtacoItem).getHealAmount(), ((ItemFood)ItemRegistry.fishtacoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishtacoItem");
			ItemRegistry.creamedcornItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedcornID, ((ItemFood)ItemRegistry.creamedcornItem).getHealAmount(), ((ItemFood)ItemRegistry.creamedcornItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:creamedcornItem");
			ItemRegistry.strawberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysmoothieID, ((ItemFood)ItemRegistry.strawberrysmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberrysmoothieItem");
			ItemRegistry.strawberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrypieID, ((ItemFood)ItemRegistry.strawberrypieItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberrypieItem");
			ItemRegistry.strawberrysaladItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberrysaladID, ((ItemFood)ItemRegistry.strawberrysaladItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberrysaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberrysaladItem");
			ItemRegistry.strawberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjuiceID, ((ItemFood)ItemRegistry.strawberryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chocolatestrawberryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatestrawberryID, ((ItemFood)ItemRegistry.chocolatestrawberryItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatestrawberryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatestrawberryItem");
			ItemRegistry.peanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbutterID, ((ItemFood)ItemRegistry.peanutbutterItem).getHealAmount(), ((ItemFood)ItemRegistry.peanutbutterItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peanutbutterItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.trailmixItem = new IguanaFoodPam(HarvestConfigurationHandler.trailmixID, ((ItemFood)ItemRegistry.trailmixItem).getHealAmount(), ((ItemFood)ItemRegistry.trailmixItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:trailmixItem");
			ItemRegistry.pbandjItem = new IguanaFoodPam(HarvestConfigurationHandler.pbandjID, ((ItemFood)ItemRegistry.pbandjItem).getHealAmount(), ((ItemFood)ItemRegistry.pbandjItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pbandjItem");
			ItemRegistry.peanutbuttercookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.peanutbuttercookiesID, ((ItemFood)ItemRegistry.peanutbuttercookiesItem).getHealAmount(), ((ItemFood)ItemRegistry.peanutbuttercookiesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peanutbuttercookiesItem");
			ItemRegistry.grapejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejuiceID, ((ItemFood)ItemRegistry.grapejuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.grapejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grapejuiceItem");
			ItemRegistry.grapejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.grapejellyID, ((ItemFood)ItemRegistry.grapejellyItem).getHealAmount(), ((ItemFood)ItemRegistry.grapejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grapejellyItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.grapesaladItem = new IguanaFoodPam(HarvestConfigurationHandler.grapesaladID, ((ItemFood)ItemRegistry.grapesaladItem).getHealAmount(), ((ItemFood)ItemRegistry.grapesaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grapesaladItem");
			ItemRegistry.raisincookiesItem = new IguanaFoodPam(HarvestConfigurationHandler.raisincookiesID, ((ItemFood)ItemRegistry.raisincookiesItem).getHealAmount(), ((ItemFood)ItemRegistry.raisincookiesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raisincookiesItem");
			ItemRegistry.picklesItem = new IguanaFoodPam(HarvestConfigurationHandler.picklesID, ((ItemFood)ItemRegistry.picklesItem).getHealAmount(), ((ItemFood)ItemRegistry.picklesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:picklesItem");
			ItemRegistry.cucumbersaladItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersaladID, ((ItemFood)ItemRegistry.cucumbersaladItem).getHealAmount(), ((ItemFood)ItemRegistry.cucumbersaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cucumbersaladItem");
			ItemRegistry.cucumbersoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cucumbersoupID, ((ItemFood)ItemRegistry.cucumbersoupItem).getHealAmount(), ((ItemFood)ItemRegistry.cucumbersoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cucumbersoupItem");
			ItemRegistry.vegetarianlettucewrapItem = new IguanaFoodPam(HarvestConfigurationHandler.vegetarianlettucewrapID, ((ItemFood)ItemRegistry.vegetarianlettucewrapItem).getHealAmount(), ((ItemFood)ItemRegistry.vegetarianlettucewrapItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:vegetarianlettucewrapItem");
			ItemRegistry.marinatedcucumbersItem = new IguanaFoodPam(HarvestConfigurationHandler.marinatedcucumbersID, ((ItemFood)ItemRegistry.marinatedcucumbersItem).getHealAmount(), ((ItemFood)ItemRegistry.marinatedcucumbersItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:marinatedcucumbersItem");
			ItemRegistry.ricesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.ricesoupID, ((ItemFood)ItemRegistry.ricesoupItem).getHealAmount(), ((ItemFood)ItemRegistry.ricesoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:ricesoupItem");
			ItemRegistry.friedriceItem = new IguanaFoodPam(HarvestConfigurationHandler.friedriceID, ((ItemFood)ItemRegistry.friedriceItem).getHealAmount(), ((ItemFood)ItemRegistry.friedriceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:friedriceItem");
			ItemRegistry.mushroomrisottoItem = new IguanaFoodPam(HarvestConfigurationHandler.mushroomrisottoID, ((ItemFood)ItemRegistry.mushroomrisottoItem).getHealAmount(), ((ItemFood)ItemRegistry.mushroomrisottoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mushroomrisottoItem");
			ItemRegistry.curryItem = new IguanaFoodPam(HarvestConfigurationHandler.curryID, ((ItemFood)ItemRegistry.curryItem).getHealAmount(), ((ItemFood)ItemRegistry.curryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:curryItem");
			ItemRegistry.rainbowcurryItem = new IguanaFoodPam(HarvestConfigurationHandler.rainbowcurryID, ((ItemFood)ItemRegistry.rainbowcurryItem).getHealAmount(), ((ItemFood)ItemRegistry.rainbowcurryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:rainbowcurryItem");
			ItemRegistry.refriedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.refriedbeansID, ((ItemFood)ItemRegistry.refriedbeansItem).getHealAmount(), ((ItemFood)ItemRegistry.refriedbeansItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:refriedbeansItem");
			ItemRegistry.bakedbeansItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeansID, ((ItemFood)ItemRegistry.bakedbeansItem).getHealAmount(), ((ItemFood)ItemRegistry.bakedbeansItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bakedbeansItem");
			ItemRegistry.beansandriceItem = new IguanaFoodPam(HarvestConfigurationHandler.beansandriceID, ((ItemFood)ItemRegistry.beansandriceItem).getHealAmount(), ((ItemFood)ItemRegistry.beansandriceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:beansandriceItem");
			ItemRegistry.chiliItem = new IguanaFoodPam(HarvestConfigurationHandler.chiliID, ((ItemFood)ItemRegistry.chiliItem).getHealAmount(), ((ItemFood)ItemRegistry.chiliItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chiliItem");
			ItemRegistry.beanburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.beanburritoID, ((ItemFood)ItemRegistry.beanburritoItem).getHealAmount(), ((ItemFood)ItemRegistry.beanburritoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:beanburritoItem");
			ItemRegistry.stuffedpepperItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedpepperID, ((ItemFood)ItemRegistry.stuffedpepperItem).getHealAmount(), ((ItemFood)ItemRegistry.stuffedpepperItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:stuffedpepperItem");
			ItemRegistry.veggiestirfryItem = new IguanaFoodPam(HarvestConfigurationHandler.veggiestirfryID, ((ItemFood)ItemRegistry.veggiestirfryItem).getHealAmount(), ((ItemFood)ItemRegistry.veggiestirfryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:veggiestirfryItem");
			ItemRegistry.grilledskewersItem = new IguanaFoodPam(HarvestConfigurationHandler.grilledskewersID, ((ItemFood)ItemRegistry.grilledskewersItem).getHealAmount(), ((ItemFood)ItemRegistry.grilledskewersItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grilledskewersItem");
			ItemRegistry.supremepizzaItem = new IguanaFoodPam(HarvestConfigurationHandler.supremepizzaID, ((ItemFood)ItemRegistry.supremepizzaItem).getHealAmount(), ((ItemFood)ItemRegistry.supremepizzaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:supremepizzaItem");
			ItemRegistry.omeletItem = new IguanaFoodPam(HarvestConfigurationHandler.omeletID, ((ItemFood)ItemRegistry.omeletItem).getHealAmount(), ((ItemFood)ItemRegistry.omeletItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:omeletItem");
			ItemRegistry.hotwingsItem = new IguanaFoodPam(HarvestConfigurationHandler.hotwingsID, ((ItemFood)ItemRegistry.hotwingsItem).getHealAmount(), ((ItemFood)ItemRegistry.hotwingsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:hotwingsItem");
			ItemRegistry.chilipoppersItem = new IguanaFoodPam(HarvestConfigurationHandler.chilipoppersID, ((ItemFood)ItemRegistry.chilipoppersItem).getHealAmount(), ((ItemFood)ItemRegistry.chilipoppersItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chilipoppersItem");
			ItemRegistry.extremechiliItem = new IguanaFoodPam(HarvestConfigurationHandler.extremechiliID, ((ItemFood)ItemRegistry.extremechiliItem).getHealAmount(), ((ItemFood)ItemRegistry.extremechiliItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:extremechiliItem");
			ItemRegistry.chilichocolateItem = new IguanaFoodPam(HarvestConfigurationHandler.chilichocolateID, ((ItemFood)ItemRegistry.chilichocolateItem).getHealAmount(), ((ItemFood)ItemRegistry.chilichocolateItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chilichocolateItem");
			ItemRegistry.lemonaideItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonaideID, ((ItemFood)ItemRegistry.lemonaideItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonaideItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonaideItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonbarItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonbarID, ((ItemFood)ItemRegistry.lemonbarItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonbarItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonbarItem");
			ItemRegistry.fishdinnerItem = new IguanaFoodPam(HarvestConfigurationHandler.fishdinnerID, ((ItemFood)ItemRegistry.fishdinnerItem).getHealAmount(), ((ItemFood)ItemRegistry.fishdinnerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fishdinnerItem");
			ItemRegistry.lemonsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonsmoothieID, ((ItemFood)ItemRegistry.lemonsmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.lemonmeringueItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonmeringueID, ((ItemFood)ItemRegistry.lemonmeringueItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonmeringueItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonmeringueItem");
			ItemRegistry.candiedlemonItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedlemonID, ((ItemFood)ItemRegistry.candiedlemonItem).getHealAmount(), ((ItemFood)ItemRegistry.candiedlemonItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:candiedlemonItem");
			ItemRegistry.lemonchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonchickenID, ((ItemFood)ItemRegistry.lemonchickenItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonchickenItem");
			ItemRegistry.blueberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrysmoothieID, ((ItemFood)ItemRegistry.blueberrysmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberrysmoothieItem");
			ItemRegistry.blueberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypieID, ((ItemFood)ItemRegistry.blueberrypieItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberrypieItem");
			ItemRegistry.blueberrymuffinItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrymuffinID, ((ItemFood)ItemRegistry.blueberrymuffinItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberrymuffinItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberrymuffinItem");
			ItemRegistry.blueberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjuiceID, ((ItemFood)ItemRegistry.blueberryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.pancakesID, ((ItemFood)ItemRegistry.pancakesItem).getHealAmount(), ((ItemFood)ItemRegistry.pancakesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pancakesItem");
			ItemRegistry.blueberrypancakesItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberrypancakesID, ((ItemFood)ItemRegistry.blueberrypancakesItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberrypancakesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberrypancakesItem");
			ItemRegistry.cherryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjuiceID, ((ItemFood)ItemRegistry.cherryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.cherryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cherrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrypieID, ((ItemFood)ItemRegistry.cherrypieItem).getHealAmount(), ((ItemFood)ItemRegistry.cherrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherrypieItem");
			ItemRegistry.chocolatecherryItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatecherryID, ((ItemFood)ItemRegistry.chocolatecherryItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatecherryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatecherryItem");
			ItemRegistry.cherrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrysmoothieID, ((ItemFood)ItemRegistry.cherrysmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.cherrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cheesecakeID, ((ItemFood)ItemRegistry.cheesecakeItem).getHealAmount(), ((ItemFood)ItemRegistry.cheesecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cheesecakeItem");
			ItemRegistry.cherrycheesecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.cherrycheesecakeID, ((ItemFood)ItemRegistry.cherrycheesecakeItem).getHealAmount(), ((ItemFood)ItemRegistry.cherrycheesecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherrycheesecakeItem");
			ItemRegistry.stuffedeggplantItem = new IguanaFoodPam(HarvestConfigurationHandler.stuffedeggplantID, ((ItemFood)ItemRegistry.stuffedeggplantItem).getHealAmount(), ((ItemFood)ItemRegistry.stuffedeggplantItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:stuffedeggplantItem");
			ItemRegistry.eggplantparmItem = new IguanaFoodPam(HarvestConfigurationHandler.eggplantparmID, ((ItemFood)ItemRegistry.eggplantparmItem).getHealAmount(), ((ItemFood)ItemRegistry.eggplantparmItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:eggplantparmItem");
			ItemRegistry.raspberryicedteaItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryicedteaID, ((ItemFood)ItemRegistry.raspberryicedteaItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberryicedteaItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:raspberryicedteaItem");
			ItemRegistry.chaiteaItem = new IguanaFoodPam(HarvestConfigurationHandler.chaiteaID, ((ItemFood)ItemRegistry.chaiteaItem).getHealAmount(), ((ItemFood)ItemRegistry.chaiteaItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:chaiteaItem");
			ItemRegistry.espressoItem = new IguanaFoodPam(HarvestConfigurationHandler.espressoID, ((ItemFood)ItemRegistry.espressoItem).getHealAmount(), ((ItemFood)ItemRegistry.espressoItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 10, 1, 0.5F).setPotionEffect(Potion.jump.id, 10, 1, 0.5F).setUnlocalizedName("ItemRegistry:espressoItem");
			ItemRegistry.coffeeconlecheItem = new IguanaFoodPam(HarvestConfigurationHandler.coffeeconlecheID, ((ItemFood)ItemRegistry.coffeeconlecheItem).getHealAmount(), ((ItemFood)ItemRegistry.coffeeconlecheItem).getSaturationModifier(), false, true).setPotionEffect(Potion.moveSpeed.id, 30, 0, 0.5F).setPotionEffect(Potion.jump.id, 30, 0, 0.5F).setUnlocalizedName("ItemRegistry:coffeeconlecheItem");
			ItemRegistry.mochaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mochaicecreamID, ((ItemFood)ItemRegistry.mochaicecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.mochaicecreamItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mochaicecreamItem");
			ItemRegistry.pickledbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.pickledbeetsID, ((ItemFood)ItemRegistry.pickledbeetsItem).getHealAmount(), ((ItemFood)ItemRegistry.pickledbeetsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pickledbeetsItem");
			ItemRegistry.beetsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsaladID, ((ItemFood)ItemRegistry.beetsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.beetsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:beetsaladItem");
			ItemRegistry.beetsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.beetsoupID, ((ItemFood)ItemRegistry.beetsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.beetsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:beetsoupItem");
			ItemRegistry.bakedbeetsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedbeetsID, ((ItemFood)ItemRegistry.bakedbeetsItem).getHealAmount(), ((ItemFood)ItemRegistry.bakedbeetsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bakedbeetsItem");
			ItemRegistry.broccolimacItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolimacID, ((ItemFood)ItemRegistry.broccolimacItem).getHealAmount(), ((ItemFood)ItemRegistry.broccolimacItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:broccolimacItem");
			ItemRegistry.broccolindipItem = new IguanaFoodPam(HarvestConfigurationHandler.broccolindipID, ((ItemFood)ItemRegistry.broccolindipItem).getHealAmount(), ((ItemFood)ItemRegistry.broccolindipItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:broccolindipItem");
			ItemRegistry.creamedbroccolisoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamedbroccolisoupID, ((ItemFood)ItemRegistry.creamedbroccolisoupItem).getHealAmount(), ((ItemFood)ItemRegistry.creamedbroccolisoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:creamedbroccolisoupItem");
			ItemRegistry.sweetpotatopieItem = new IguanaFoodPam(HarvestConfigurationHandler.sweetpotatopieID, ((ItemFood)ItemRegistry.sweetpotatopieItem).getHealAmount(), ((ItemFood)ItemRegistry.sweetpotatopieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:sweetpotatopieItem");
			ItemRegistry.candiedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedsweetpotatoesID, ((ItemFood)ItemRegistry.candiedsweetpotatoesItem).getHealAmount(), ((ItemFood)ItemRegistry.candiedsweetpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:candiedsweetpotatoesItem");
			ItemRegistry.mashedsweetpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.mashedsweetpotatoesID, ((ItemFood)ItemRegistry.mashedsweetpotatoesItem).getHealAmount(), ((ItemFood)ItemRegistry.mashedsweetpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mashedsweetpotatoesItem");
			ItemRegistry.steamedpeasItem = new IguanaFoodPam(HarvestConfigurationHandler.steamedpeasID, ((ItemFood)ItemRegistry.steamedpeasItem).getHealAmount(), ((ItemFood)ItemRegistry.steamedpeasItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:steamedpeasItem");
			ItemRegistry.splitpeasoupItem = new IguanaFoodPam(HarvestConfigurationHandler.splitpeasoupID, ((ItemFood)ItemRegistry.splitpeasoupItem).getHealAmount(), ((ItemFood)ItemRegistry.splitpeasoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:splitpeasoupItem");
			ItemRegistry.pineappleupsidedowncakeItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleupsidedowncakeID, ((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).getHealAmount(), ((ItemFood)ItemRegistry.pineappleupsidedowncakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pineappleupsidedowncakeItem");
			ItemRegistry.pineapplehamItem = new IguanaFoodPam(HarvestConfigurationHandler.pineapplehamID, ((ItemFood)ItemRegistry.pineapplehamItem).getHealAmount(), ((ItemFood)ItemRegistry.pineapplehamItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pineapplehamItem");
			ItemRegistry.pineappleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pineappleyogurtID, ((ItemFood)ItemRegistry.pineappleyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.pineappleyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pineappleyogurtItem");
			ItemRegistry.turnipsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.turnipsoupID, ((ItemFood)ItemRegistry.turnipsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.turnipsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:turnipsoupItem");
			ItemRegistry.roastedrootveggiemedleyItem = new IguanaFoodPam(HarvestConfigurationHandler.roastedrootveggiemedleyID, ((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).getHealAmount(), ((ItemFood)ItemRegistry.roastedrootveggiemedleyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:roastedrootveggiemedleyItem");
			ItemRegistry.bakedturnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.bakedturnipsID, ((ItemFood)ItemRegistry.bakedturnipsItem).getHealAmount(), ((ItemFood)ItemRegistry.bakedturnipsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bakedturnipsItem");
			ItemRegistry.gingerbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerbreadID, ((ItemFood)ItemRegistry.gingerbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.gingerbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:gingerbreadItem");
			ItemRegistry.gingersnapsItem = new IguanaFoodPam(HarvestConfigurationHandler.gingersnapsID, ((ItemFood)ItemRegistry.gingersnapsItem).getHealAmount(), ((ItemFood)ItemRegistry.gingersnapsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:gingersnapsItem");
			ItemRegistry.candiedgingerItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedgingerID, ((ItemFood)ItemRegistry.candiedgingerItem).getHealAmount(), ((ItemFood)ItemRegistry.candiedgingerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:candiedgingerItem");
			ItemRegistry.softpretzelandmustardItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelandmustardID, ((ItemFood)ItemRegistry.softpretzelandmustardItem).getHealAmount(), ((ItemFood)ItemRegistry.softpretzelandmustardItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:softpretzelandmustardItem");
			ItemRegistry.spicymustardporkItem = new IguanaFoodPam(HarvestConfigurationHandler.spicymustardporkID, ((ItemFood)ItemRegistry.spicymustardporkItem).getHealAmount(), ((ItemFood)ItemRegistry.spicymustardporkItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:spicymustardporkItem");
			ItemRegistry.spicygreensItem = new IguanaFoodPam(HarvestConfigurationHandler.spicygreensID, ((ItemFood)ItemRegistry.spicygreensItem).getHealAmount(), ((ItemFood)ItemRegistry.spicygreensItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:spicygreensItem");
			ItemRegistry.garlicbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicbreadID, ((ItemFood)ItemRegistry.garlicbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.garlicbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:garlicbreadItem");
			ItemRegistry.garlicmashedpotatoesItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicmashedpotatoesID, ((ItemFood)ItemRegistry.garlicmashedpotatoesItem).getHealAmount(), ((ItemFood)ItemRegistry.garlicmashedpotatoesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:garlicmashedpotatoesItem");
			ItemRegistry.garlicchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.garlicchickenID, ((ItemFood)ItemRegistry.garlicchickenItem).getHealAmount(), ((ItemFood)ItemRegistry.garlicchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:garlicchickenItem");
			ItemRegistry.summerradishsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.summerradishsaladID, ((ItemFood)ItemRegistry.summerradishsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.summerradishsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:summerradishsaladItem");
			ItemRegistry.summersquashwithradishItem = new IguanaFoodPam(HarvestConfigurationHandler.summersquashwithradishID, ((ItemFood)ItemRegistry.summersquashwithradishItem).getHealAmount(), ((ItemFood)ItemRegistry.summersquashwithradishItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:summersquashwithradishItem");
			ItemRegistry.celeryandpeanutbutterItem = new IguanaFoodPam(HarvestConfigurationHandler.celeryandpeanutbutterID, ((ItemFood)ItemRegistry.celeryandpeanutbutterItem).getHealAmount(), ((ItemFood)ItemRegistry.celeryandpeanutbutterItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:celeryandpeanutbutterItem");
			ItemRegistry.chickencelerycasseroleItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencelerycasseroleID, ((ItemFood)ItemRegistry.chickencelerycasseroleItem).getHealAmount(), ((ItemFood)ItemRegistry.chickencelerycasseroleItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickencelerycasseroleItem");
			ItemRegistry.peasandceleryItem = new IguanaFoodPam(HarvestConfigurationHandler.peasandceleryID, ((ItemFood)ItemRegistry.peasandceleryItem).getHealAmount(), ((ItemFood)ItemRegistry.peasandceleryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peasandceleryItem");
			ItemRegistry.celerysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.celerysoupID, ((ItemFood)ItemRegistry.celerysoupItem).getHealAmount(), ((ItemFood)ItemRegistry.celerysoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:celerysoupItem");
			ItemRegistry.zucchinibreadItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibreadID, ((ItemFood)ItemRegistry.zucchinibreadItem).getHealAmount(), ((ItemFood)ItemRegistry.zucchinibreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:zucchinibreadItem");
			ItemRegistry.zucchinifriesItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinifriesID, ((ItemFood)ItemRegistry.zucchinifriesItem).getHealAmount(), ((ItemFood)ItemRegistry.zucchinifriesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:zucchinifriesItem");
			ItemRegistry.zestyzucchiniItem = new IguanaFoodPam(HarvestConfigurationHandler.zestyzucchiniID, ((ItemFood)ItemRegistry.zestyzucchiniItem).getHealAmount(), ((ItemFood)ItemRegistry.zestyzucchiniItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:zestyzucchiniItem");
			ItemRegistry.zucchinibakeItem = new IguanaFoodPam(HarvestConfigurationHandler.zucchinibakeID, ((ItemFood)ItemRegistry.zucchinibakeItem).getHealAmount(), ((ItemFood)ItemRegistry.zucchinibakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:zucchinibakeItem");
			ItemRegistry.asparagusquicheItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagusquicheID, ((ItemFood)ItemRegistry.asparagusquicheItem).getHealAmount(), ((ItemFood)ItemRegistry.asparagusquicheItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:asparagusquicheItem");
			ItemRegistry.asparagussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.asparagussoupID, ((ItemFood)ItemRegistry.asparagussoupItem).getHealAmount(), ((ItemFood)ItemRegistry.asparagussoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:asparagussoupItem");
			ItemRegistry.walnutraisinbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.walnutraisinbreadID, ((ItemFood)ItemRegistry.walnutraisinbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.walnutraisinbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:walnutraisinbreadItem");
			ItemRegistry.candiedwalnutsItem = new IguanaFoodPam(HarvestConfigurationHandler.candiedwalnutsID, ((ItemFood)ItemRegistry.candiedwalnutsItem).getHealAmount(), ((ItemFood)ItemRegistry.candiedwalnutsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:candiedwalnutsItem");
			ItemRegistry.brownieItem = new IguanaFoodPam(HarvestConfigurationHandler.brownieID, ((ItemFood)ItemRegistry.brownieItem).getHealAmount(), ((ItemFood)ItemRegistry.brownieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:brownieItem");
			ItemRegistry.papayajuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajuiceID, ((ItemFood)ItemRegistry.papayajuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.papayajuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:papayajuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.papayasmoothieID, ((ItemFood)ItemRegistry.papayasmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.papayasmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:papayasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.papayayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.papayayogurtID, ((ItemFood)ItemRegistry.papayayogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.papayayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:papayayogurtItem");
			ItemRegistry.starfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjuiceID, ((ItemFood)ItemRegistry.starfruitjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.starfruitjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:starfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruitsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitsmoothieID, ((ItemFood)ItemRegistry.starfruitsmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.starfruitsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:starfruitsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.starfruityogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruityogurtID, ((ItemFood)ItemRegistry.starfruityogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.starfruityogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:starfruityogurtItem");
			ItemRegistry.guacamoleItem = new IguanaFoodPam(HarvestConfigurationHandler.guacamoleID, ((ItemFood)ItemRegistry.guacamoleItem).getHealAmount(), ((ItemFood)ItemRegistry.guacamoleItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:guacamoleItem");
			ItemRegistry.creamofavocadosoupItem = new IguanaFoodPam(HarvestConfigurationHandler.creamofavocadosoupID, ((ItemFood)ItemRegistry.creamofavocadosoupItem).getHealAmount(), ((ItemFood)ItemRegistry.creamofavocadosoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:creamofavocadosoupItem");
			ItemRegistry.avocadoburritoItem = new IguanaFoodPam(HarvestConfigurationHandler.avocadoburritoID, ((ItemFood)ItemRegistry.avocadoburritoItem).getHealAmount(), ((ItemFood)ItemRegistry.avocadoburritoItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:avocadoburritoItem");
			ItemRegistry.poachedpearItem = new IguanaFoodPam(HarvestConfigurationHandler.poachedpearID, ((ItemFood)ItemRegistry.poachedpearItem).getHealAmount(), ((ItemFood)ItemRegistry.poachedpearItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:poachedpearItem");
			ItemRegistry.fruitcrumbleItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitcrumbleID, ((ItemFood)ItemRegistry.fruitcrumbleItem).getHealAmount(), ((ItemFood)ItemRegistry.fruitcrumbleItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fruitcrumbleItem");
			ItemRegistry.pearyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pearyogurtID, ((ItemFood)ItemRegistry.pearyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.pearyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pearyogurtItem");
			ItemRegistry.plumyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plumyogurtID, ((ItemFood)ItemRegistry.plumyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.plumyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:plumyogurtItem");
			ItemRegistry.bananasplitItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasplitID, ((ItemFood)ItemRegistry.bananasplitItem).getHealAmount(), ((ItemFood)ItemRegistry.bananasplitItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bananasplitItem");
			ItemRegistry.banananutbreadItem = new IguanaFoodPam(HarvestConfigurationHandler.banananutbreadID, ((ItemFood)ItemRegistry.banananutbreadItem).getHealAmount(), ((ItemFood)ItemRegistry.banananutbreadItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:banananutbreadItem");
			ItemRegistry.bananasmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.bananasmoothieID, ((ItemFood)ItemRegistry.bananasmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.bananasmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bananasmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.bananayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.bananayogurtID, ((ItemFood)ItemRegistry.bananayogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.bananayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:bananayogurtItem");
			ItemRegistry.coconutmilkItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutmilkID, ((ItemFood)ItemRegistry.coconutmilkItem).getHealAmount(), ((ItemFood)ItemRegistry.coconutmilkItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:coconutmilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.chickencurryItem = new IguanaFoodPam(HarvestConfigurationHandler.chickencurryID, ((ItemFood)ItemRegistry.chickencurryItem).getHealAmount(), ((ItemFood)ItemRegistry.chickencurryItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chickencurryItem");
			ItemRegistry.coconutshrimpItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutshrimpID, ((ItemFood)ItemRegistry.coconutshrimpItem).getHealAmount(), ((ItemFood)ItemRegistry.coconutshrimpItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:coconutshrimpItem");
			ItemRegistry.coconutyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.coconutyogurtID, ((ItemFood)ItemRegistry.coconutyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.coconutyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:coconutyogurtItem");
			ItemRegistry.orangejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejuiceID, ((ItemFood)ItemRegistry.orangejuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.orangejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangechickenItem = new IguanaFoodPam(HarvestConfigurationHandler.orangechickenID, ((ItemFood)ItemRegistry.orangechickenItem).getHealAmount(), ((ItemFood)ItemRegistry.orangechickenItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangechickenItem");
			ItemRegistry.orangesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.orangesmoothieID, ((ItemFood)ItemRegistry.orangesmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.orangesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.orangeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.orangeyogurtID, ((ItemFood)ItemRegistry.orangeyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.orangeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangeyogurtItem");
			ItemRegistry.peachjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjuiceID, ((ItemFood)ItemRegistry.peachjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.peachjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachcobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.peachcobblerID, ((ItemFood)ItemRegistry.peachcobblerItem).getHealAmount(), ((ItemFood)ItemRegistry.peachcobblerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachcobblerItem");
			ItemRegistry.peachsmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.peachsmoothieID, ((ItemFood)ItemRegistry.peachsmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.peachsmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachsmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.peachyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.peachyogurtID, ((ItemFood)ItemRegistry.peachyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.peachyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachyogurtItem");
			ItemRegistry.limejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.limejuiceID, ((ItemFood)ItemRegistry.limejuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.limejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:limejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.keylimepieItem = new IguanaFoodPam(HarvestConfigurationHandler.keylimepieID, ((ItemFood)ItemRegistry.keylimepieItem).getHealAmount(), ((ItemFood)ItemRegistry.keylimepieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:keylimepieItem");
			ItemRegistry.limesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.limesmoothieID, ((ItemFood)ItemRegistry.limesmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.limesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:limesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.limeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.limeyogurtID, ((ItemFood)ItemRegistry.limeyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.limeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:limeyogurtItem");
			ItemRegistry.mangojuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojuiceID, ((ItemFood)ItemRegistry.mangojuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.mangojuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mangojuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangosmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.mangosmoothieID, ((ItemFood)ItemRegistry.mangosmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.mangosmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mangosmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.mangoyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.mangoyogurtID, ((ItemFood)ItemRegistry.mangoyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.mangoyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mangoyogurtItem");
			ItemRegistry.pomegranatejuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejuiceID, ((ItemFood)ItemRegistry.pomegranatejuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.pomegranatejuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pomegranatejuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranatesmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatesmoothieID, ((ItemFood)ItemRegistry.pomegranatesmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.pomegranatesmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pomegranatesmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pomegranateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranateyogurtID, ((ItemFood)ItemRegistry.pomegranateyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.pomegranateyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pomegranateyogurtItem");
			ItemRegistry.vanillayogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillayogurtID, ((ItemFood)ItemRegistry.vanillayogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.vanillayogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:vanillayogurtItem");
			ItemRegistry.cinnamonrollItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonrollID, ((ItemFood)ItemRegistry.cinnamonrollItem).getHealAmount(), ((ItemFood)ItemRegistry.cinnamonrollItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cinnamonrollItem");
			ItemRegistry.frenchtoastItem = new IguanaFoodPam(HarvestConfigurationHandler.frenchtoastID, ((ItemFood)ItemRegistry.frenchtoastItem).getHealAmount(), ((ItemFood)ItemRegistry.frenchtoastItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:frenchtoastItem");
			ItemRegistry.marshmellowsItem = new IguanaFoodPam(HarvestConfigurationHandler.marshmellowsID, ((ItemFood)ItemRegistry.marshmellowsItem).getHealAmount(), ((ItemFood)ItemRegistry.marshmellowsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:marshmellowsItem");
			ItemRegistry.donutItem = new IguanaFoodPam(HarvestConfigurationHandler.donutID, ((ItemFood)ItemRegistry.donutItem).getHealAmount(), ((ItemFood)ItemRegistry.donutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:donutItem");
			ItemRegistry.chocolatedonutItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatedonutID, ((ItemFood)ItemRegistry.chocolatedonutItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatedonutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatedonutItem");
			ItemRegistry.powdereddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.powdereddonutID, ((ItemFood)ItemRegistry.powdereddonutItem).getHealAmount(), ((ItemFood)ItemRegistry.powdereddonutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:powdereddonutItem");
			ItemRegistry.jellydonutItem = new IguanaFoodPam(HarvestConfigurationHandler.jellydonutID, ((ItemFood)ItemRegistry.jellydonutItem).getHealAmount(), ((ItemFood)ItemRegistry.jellydonutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:jellydonutItem");
			ItemRegistry.frosteddonutItem = new IguanaFoodPam(HarvestConfigurationHandler.frosteddonutID, ((ItemFood)ItemRegistry.frosteddonutItem).getHealAmount(), ((ItemFood)ItemRegistry.frosteddonutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:frosteddonutItem");
			ItemRegistry.cactussoupItem = new IguanaFoodPam(HarvestConfigurationHandler.cactussoupID, ((ItemFood)ItemRegistry.cactussoupItem).getHealAmount(), ((ItemFood)ItemRegistry.cactussoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cactussoupItem");
			ItemRegistry.wafflesItem = new IguanaFoodPam(HarvestConfigurationHandler.wafflesID, ((ItemFood)ItemRegistry.wafflesItem).getHealAmount(), ((ItemFood)ItemRegistry.wafflesItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:wafflesItem");
			ItemRegistry.seedsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.seedsoupID, ((ItemFood)ItemRegistry.seedsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.seedsoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:seedsoupItem");
			ItemRegistry.softpretzelItem = new IguanaFoodPam(HarvestConfigurationHandler.softpretzelID, ((ItemFood)ItemRegistry.softpretzelItem).getHealAmount(), ((ItemFood)ItemRegistry.softpretzelItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:softpretzelItem");
			ItemRegistry.jellybeansItem = new IguanaFoodPam(HarvestConfigurationHandler.jellybeansID, ((ItemFood)ItemRegistry.jellybeansItem).getHealAmount(), ((ItemFood)ItemRegistry.jellybeansItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:jellybeansItem");
			ItemRegistry.biscuitItem = new IguanaFoodPam(HarvestConfigurationHandler.biscuitID, ((ItemFood)ItemRegistry.biscuitItem).getHealAmount(), ((ItemFood)ItemRegistry.biscuitItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:biscuitItem");
			ItemRegistry.creamcookieItem = new IguanaFoodPam(HarvestConfigurationHandler.creamcookieID, ((ItemFood)ItemRegistry.creamcookieItem).getHealAmount(), ((ItemFood)ItemRegistry.creamcookieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:creamcookieItem");
			ItemRegistry.jaffaItem = new IguanaFoodPam(HarvestConfigurationHandler.jaffaID, ((ItemFood)ItemRegistry.jaffaItem).getHealAmount(), ((ItemFood)ItemRegistry.jaffaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:jaffaItem");
			ItemRegistry.friedchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.friedchickenID, ((ItemFood)ItemRegistry.friedchickenItem).getHealAmount(), ((ItemFood)ItemRegistry.friedchickenItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:friedchickenItem");
			ItemRegistry.chocolatesprinklecakeItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatesprinklecakeID, ((ItemFood)ItemRegistry.chocolatesprinklecakeItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatesprinklecakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatesprinklecakeItem");
			ItemRegistry.redvelvetcakeItem = new IguanaFoodPam(HarvestConfigurationHandler.redvelvetcakeID, ((ItemFood)ItemRegistry.redvelvetcakeItem).getHealAmount(), ((ItemFood)ItemRegistry.redvelvetcakeItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:redvelvetcakeItem");
			ItemRegistry.footlongItem = new IguanaFoodPam(HarvestConfigurationHandler.footlongID, ((ItemFood)ItemRegistry.footlongItem).getHealAmount(), ((ItemFood)ItemRegistry.footlongItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:footlongItem");
			ItemRegistry.blueberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryyogurtID, ((ItemFood)ItemRegistry.blueberryyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberryyogurtItem");
			ItemRegistry.lemonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonyogurtID, ((ItemFood)ItemRegistry.lemonyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonyogurtItem");
			ItemRegistry.cherryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryyogurtID, ((ItemFood)ItemRegistry.cherryyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.cherryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherryyogurtItem");
			ItemRegistry.strawberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryyogurtID, ((ItemFood)ItemRegistry.strawberryyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberryyogurtItem");
			ItemRegistry.grapeyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.grapeyogurtID, ((ItemFood)ItemRegistry.grapeyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.grapeyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:grapeyogurtItem");
			ItemRegistry.chocolateyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolateyogurtID, ((ItemFood)ItemRegistry.chocolateyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolateyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolateyogurtItem");
			ItemRegistry.blackberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjuiceID, ((ItemFood)ItemRegistry.blackberryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberrycobblerItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrycobblerID, ((ItemFood)ItemRegistry.blackberrycobblerItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberrycobblerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberrycobblerItem");
			ItemRegistry.blackberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberrysmoothieID, ((ItemFood)ItemRegistry.blackberrysmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.blackberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryyogurtID, ((ItemFood)ItemRegistry.blackberryyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberryyogurtItem");
			ItemRegistry.chocolatemilkItem = new IguanaFoodPam(HarvestConfigurationHandler.chocolatemilkID, ((ItemFood)ItemRegistry.chocolatemilkItem).getHealAmount(), ((ItemFood)ItemRegistry.chocolatemilkItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:chocolatemilkItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.pumpkinyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinyogurtID, ((ItemFood)ItemRegistry.pumpkinyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.pumpkinyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pumpkinyogurtItem");
			ItemRegistry.raspberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjuiceID, ((ItemFood)ItemRegistry.raspberryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberrypieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrypieID, ((ItemFood)ItemRegistry.raspberrypieItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberrypieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberrypieItem");
			ItemRegistry.raspberrysmoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberrysmoothieID, ((ItemFood)ItemRegistry.raspberrysmoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberrysmoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberrysmoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.raspberryyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryyogurtID, ((ItemFood)ItemRegistry.raspberryyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberryyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberryyogurtItem");
			ItemRegistry.cinnamonsugardonutItem = new IguanaFoodPam(HarvestConfigurationHandler.cinnamonsugardonutID, ((ItemFood)ItemRegistry.cinnamonsugardonutItem).getHealAmount(), ((ItemFood)ItemRegistry.cinnamonsugardonutItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cinnamonsugardonutItem");
			ItemRegistry.melonyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.melonyogurtID, ((ItemFood)ItemRegistry.melonyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.melonyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:melonyogurtItem");
			ItemRegistry.kiwijuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijuiceID, ((ItemFood)ItemRegistry.kiwijuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.kiwijuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:kiwijuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwismoothieItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwismoothieID, ((ItemFood)ItemRegistry.kiwismoothieItem).getHealAmount(), ((ItemFood)ItemRegistry.kiwismoothieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:kiwismoothieItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.kiwiyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwiyogurtID, ((ItemFood)ItemRegistry.kiwiyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.kiwiyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:kiwiyogurtItem");
			ItemRegistry.plainyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.plainyogurtID, ((ItemFood)ItemRegistry.plainyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.plainyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:plainyogurtItem");
			ItemRegistry.appleyogurtItem = new IguanaFoodPam(HarvestConfigurationHandler.appleyogurtID, ((ItemFood)ItemRegistry.appleyogurtItem).getHealAmount(), ((ItemFood)ItemRegistry.appleyogurtItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:appleyogurtItem");
			ItemRegistry.saltedsunflowerseedsItem = new IguanaFoodPam(HarvestConfigurationHandler.saltedsunflowerseedsID, ((ItemFood)ItemRegistry.saltedsunflowerseedsItem).getHealAmount(), ((ItemFood)ItemRegistry.saltedsunflowerseedsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:saltedsunflowerseedsItem");
			ItemRegistry.sunflowerwheatrollsItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerwheatrollsID, ((ItemFood)ItemRegistry.sunflowerwheatrollsItem).getHealAmount(), ((ItemFood)ItemRegistry.sunflowerwheatrollsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:sunflowerwheatrollsItem");
			ItemRegistry.sunflowerbroccolisaladItem = new IguanaFoodPam(HarvestConfigurationHandler.sunflowerbroccolisaladID, ((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).getHealAmount(), ((ItemFood)ItemRegistry.sunflowerbroccolisaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:sunflowerbroccolisaladItem");
			ItemRegistry.cranberryjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjuiceID, ((ItemFood)ItemRegistry.cranberryjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.cranberryjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cranberryjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.cranberrysauceItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrysauceID, ((ItemFood)ItemRegistry.cranberrysauceItem).getHealAmount(), ((ItemFood)ItemRegistry.cranberrysauceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cranberrysauceItem");
			ItemRegistry.cranberrybarItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberrybarID, ((ItemFood)ItemRegistry.cranberrybarItem).getHealAmount(), ((ItemFood)ItemRegistry.cranberrybarItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cranberrybarItem");
			ItemRegistry.peppermintItem = new IguanaFoodPam(HarvestConfigurationHandler.peppermintID, ((ItemFood)ItemRegistry.peppermintItem).getHealAmount(), ((ItemFood)ItemRegistry.peppermintItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peppermintItem");
			ItemRegistry.cactusfruitjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.cactusfruitjuiceID, ((ItemFood)ItemRegistry.cactusfruitjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.cactusfruitjuiceItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cactusfruitjuiceItem").setContainerItem(Items.glass_bottle);
			ItemRegistry.baklavaItem = new IguanaFoodPam(HarvestConfigurationHandler.baklavaID, ((ItemFood)ItemRegistry.baklavaItem).getHealAmount(), ((ItemFood)ItemRegistry.baklavaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:baklavaItem");
			ItemRegistry.gummybearsItem = new IguanaFoodPam(HarvestConfigurationHandler.gummybearsID, ((ItemFood)ItemRegistry.gummybearsItem).getHealAmount(), ((ItemFood)ItemRegistry.gummybearsItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:gummybearsItem");
			ItemRegistry.baconmushroomburgerItem = new IguanaFoodPam(HarvestConfigurationHandler.baconmushroomburgerID, ((ItemFood)ItemRegistry.baconmushroomburgerItem).getHealAmount(), ((ItemFood)ItemRegistry.baconmushroomburgerItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:baconmushroomburgerItem");
			ItemRegistry.fruitpunchItem = new IguanaFoodPam(HarvestConfigurationHandler.fruitpunchID, ((ItemFood)ItemRegistry.fruitpunchItem).getHealAmount(), ((ItemFood)ItemRegistry.fruitpunchItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:fruitpunchItem");
			ItemRegistry.meatystewItem = new IguanaFoodPam(HarvestConfigurationHandler.meatystewID, ((ItemFood)ItemRegistry.meatystewItem).getHealAmount(), ((ItemFood)ItemRegistry.meatystewItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:meatystewItem");
			ItemRegistry.mixedsaladItem = new IguanaFoodPam(HarvestConfigurationHandler.mixedsaladID, ((ItemFood)ItemRegistry.mixedsaladItem).getHealAmount(), ((ItemFood)ItemRegistry.mixedsaladItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mixedsaladItem");
			ItemRegistry.pinacoladaItem = new IguanaFoodPam(HarvestConfigurationHandler.pinacoladaID, ((ItemFood)ItemRegistry.pinacoladaItem).getHealAmount(), ((ItemFood)ItemRegistry.pinacoladaItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pinacoladaItem");
			ItemRegistry.shepardspieItem = new IguanaFoodPam(HarvestConfigurationHandler.shepardspieID, ((ItemFood)ItemRegistry.shepardspieItem).getHealAmount(), ((ItemFood)ItemRegistry.shepardspieItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:shepardspieItem");
			ItemRegistry.eggnogItem = new IguanaFoodPam(HarvestConfigurationHandler.eggnogID, ((ItemFood)ItemRegistry.eggnogItem).getHealAmount(), ((ItemFood)ItemRegistry.eggnogItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:eggnogItem");
			ItemRegistry.custardItem = new IguanaFoodPam(HarvestConfigurationHandler.custardID, ((ItemFood)ItemRegistry.custardItem).getHealAmount(), ((ItemFood)ItemRegistry.custardItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:custardItem");
			ItemRegistry.sushiItem = new IguanaFoodPam(HarvestConfigurationHandler.sushiID, ((ItemFood)ItemRegistry.sushiItem).getHealAmount(), ((ItemFood)ItemRegistry.sushiItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:sushiItem");
			ItemRegistry.gardensoupItem = new IguanaFoodPam(HarvestConfigurationHandler.gardensoupID, ((ItemFood)ItemRegistry.gardensoupItem).getHealAmount(), ((ItemFood)ItemRegistry.gardensoupItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:gardensoupItem");
			ItemRegistry.muttonrawItem = new IguanaFoodPam(HarvestConfigurationHandler.muttonrawID, ((ItemFood)ItemRegistry.muttonrawItem).getHealAmount(), ((ItemFood)ItemRegistry.muttonrawItem).getSaturationModifier(), true, true).setUnlocalizedName("ItemRegistry:muttonrawItem");
			ItemRegistry.muttoncookedItem = new IguanaFoodPam(HarvestConfigurationHandler.muttoncookedID, ((ItemFood)ItemRegistry.muttoncookedItem).getHealAmount(), ((ItemFood)ItemRegistry.muttoncookedItem).getSaturationModifier(), true, true).setUnlocalizedName("ItemRegistry:muttoncookedItem");
			ItemRegistry.calamarirawItem = new IguanaFoodPam(HarvestConfigurationHandler.calamarirawID, ((ItemFood)ItemRegistry.calamarirawItem).getHealAmount(), ((ItemFood)ItemRegistry.calamarirawItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:calamarirawItem");
			ItemRegistry.calamaricookedItem = new IguanaFoodPam(HarvestConfigurationHandler.calamaricookedID, ((ItemFood)ItemRegistry.calamaricookedItem).getHealAmount(), ((ItemFood)ItemRegistry.calamaricookedItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:calamaricookedItem");
			ItemRegistry.applejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellyID, ((ItemFood)ItemRegistry.applejellyItem).getHealAmount(), ((ItemFood)ItemRegistry.applejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:applejellyItem");
			ItemRegistry.applejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.applejellysandwichID, ((ItemFood)ItemRegistry.applejellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.applejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:applejellysandwichItem");
			ItemRegistry.blackberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellyID, ((ItemFood)ItemRegistry.blackberryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberryjellyItem");
			ItemRegistry.blackberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blackberryjellysandwichID, ((ItemFood)ItemRegistry.blackberryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.blackberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blackberryjellysandwichItem");
			ItemRegistry.blueberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellyID, ((ItemFood)ItemRegistry.blueberryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberryjellyItem");
			ItemRegistry.blueberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.blueberryjellysandwichID, ((ItemFood)ItemRegistry.blueberryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.blueberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:blueberryjellysandwichItem");
			ItemRegistry.cherryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellyID, ((ItemFood)ItemRegistry.cherryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.cherryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherryjellyItem");
			ItemRegistry.cherryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cherryjellysandwichID, ((ItemFood)ItemRegistry.cherryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.cherryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cherryjellysandwichItem");
			ItemRegistry.cranberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellyID, ((ItemFood)ItemRegistry.cranberryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.cranberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cranberryjellyItem");
			ItemRegistry.cranberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.cranberryjellysandwichID, ((ItemFood)ItemRegistry.cranberryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.cranberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:cranberryjellysandwichItem");
			ItemRegistry.kiwijellyItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellyID, ((ItemFood)ItemRegistry.kiwijellyItem).getHealAmount(), ((ItemFood)ItemRegistry.kiwijellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:kiwijellyItem");
			ItemRegistry.kiwijellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.kiwijellysandwichID, ((ItemFood)ItemRegistry.kiwijellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.kiwijellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:kiwijellysandwichItem");
			ItemRegistry.lemonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellyID, ((ItemFood)ItemRegistry.lemonjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonjellyItem");
			ItemRegistry.lemonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.lemonjellysandwichID, ((ItemFood)ItemRegistry.lemonjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:lemonjellysandwichItem");
			ItemRegistry.limejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellyID, ((ItemFood)ItemRegistry.limejellyItem).getHealAmount(), ((ItemFood)ItemRegistry.limejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:limejellyItem");
			ItemRegistry.limejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.limejellysandwichID, ((ItemFood)ItemRegistry.limejellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.limejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:limejellysandwichItem");
			ItemRegistry.mangojellyItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellyID, ((ItemFood)ItemRegistry.mangojellyItem).getHealAmount(), ((ItemFood)ItemRegistry.mangojellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mangojellyItem");
			ItemRegistry.mangojellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.mangojellysandwichID, ((ItemFood)ItemRegistry.mangojellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.mangojellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:mangojellysandwichItem");
			ItemRegistry.orangejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellyID, ((ItemFood)ItemRegistry.orangejellyItem).getHealAmount(), ((ItemFood)ItemRegistry.orangejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangejellyItem");
			ItemRegistry.orangejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.orangejellysandwichID, ((ItemFood)ItemRegistry.orangejellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.orangejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:orangejellysandwichItem");
			ItemRegistry.papayajellyItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellyID, ((ItemFood)ItemRegistry.papayajellyItem).getHealAmount(), ((ItemFood)ItemRegistry.papayajellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:papayajellyItem");
			ItemRegistry.papayajellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.papayajellysandwichID, ((ItemFood)ItemRegistry.papayajellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.papayajellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:papayajellysandwichItem");
			ItemRegistry.peachjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellyID, ((ItemFood)ItemRegistry.peachjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.peachjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachjellyItem");
			ItemRegistry.peachjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.peachjellysandwichID, ((ItemFood)ItemRegistry.peachjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.peachjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:peachjellysandwichItem");
			ItemRegistry.pomegranatejellyItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellyID, ((ItemFood)ItemRegistry.pomegranatejellyItem).getHealAmount(), ((ItemFood)ItemRegistry.pomegranatejellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellyItem");
			ItemRegistry.pomegranatejellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.pomegranatejellysandwichID, ((ItemFood)ItemRegistry.pomegranatejellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.pomegranatejellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:pomegranatejellysandwichItem");
			ItemRegistry.raspberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellyID, ((ItemFood)ItemRegistry.raspberryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberryjellyItem");
			ItemRegistry.raspberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.raspberryjellysandwichID, ((ItemFood)ItemRegistry.raspberryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.raspberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:raspberryjellysandwichItem");
			ItemRegistry.starfruitjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellyID, ((ItemFood)ItemRegistry.starfruitjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.starfruitjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:starfruitjellyItem");
			ItemRegistry.starfruitjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.starfruitjellysandwichID, ((ItemFood)ItemRegistry.starfruitjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.starfruitjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:starfruitjellysandwichItem");
			ItemRegistry.strawberryjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellyID, ((ItemFood)ItemRegistry.strawberryjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberryjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberryjellyItem");
			ItemRegistry.strawberryjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryjellysandwichID, ((ItemFood)ItemRegistry.strawberryjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberryjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:strawberryjellysandwichItem");
			ItemRegistry.watermelonjellyItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellyID, ((ItemFood)ItemRegistry.watermelonjellyItem).getHealAmount(), ((ItemFood)ItemRegistry.watermelonjellyItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:watermelonjellyItem");
			ItemRegistry.watermelonjellysandwichItem = new IguanaFoodPam(HarvestConfigurationHandler.watermelonjellysandwichID, ((ItemFood)ItemRegistry.watermelonjellysandwichItem).getHealAmount(), ((ItemFood)ItemRegistry.watermelonjellysandwichItem).getSaturationModifier(), false, true).setUnlocalizedName("ItemRegistry:watermelonjellysandwichItem");

			ItemRegistry.cherrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.cherrysodaID, ((ItemFood)ItemRegistry.cherrysodaItem).getHealAmount(), ((ItemFood)ItemRegistry.cherrysodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:cherrysodaItem");
			ItemRegistry.colasodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.colasodaID, ((ItemFood)ItemRegistry.colasodaItem).getHealAmount(), ((ItemFood)ItemRegistry.colasodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:colasodaItem");
			ItemRegistry.gingersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.gingersodaID, ((ItemFood)ItemRegistry.gingersodaItem).getHealAmount(), ((ItemFood)ItemRegistry.gingersodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:gingersodaItem");
			ItemRegistry.grapesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.grapesodaID, ((ItemFood)ItemRegistry.grapesodaItem).getHealAmount(), ((ItemFood)ItemRegistry.grapesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:grapesodaItem");
			ItemRegistry.lemonlimesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.lemonlimesodaID, ((ItemFood)ItemRegistry.lemonlimesodaItem).getHealAmount(), ((ItemFood)ItemRegistry.lemonlimesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:lemonlimesodaItem");
			ItemRegistry.orangesodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.orangesodaID, ((ItemFood)ItemRegistry.orangesodaItem).getHealAmount(), ((ItemFood)ItemRegistry.orangesodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:orangesodaItem");
			ItemRegistry.rootbeersodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.rootbeersodaID, ((ItemFood)ItemRegistry.rootbeersodaItem).getHealAmount(), ((ItemFood)ItemRegistry.rootbeersodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:rootbeersodaItem");
			ItemRegistry.strawberrysodaItem = new IguanaFoodPamPotion(HarvestConfigurationHandler.strawberrysodaID, ((ItemFood)ItemRegistry.strawberrysodaItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberrysodaItem).getSaturationModifier(), false).setPotionEffect(Potion.moveSpeed.id, 60, 0, 0.8F).setAlwaysEdible().setUnlocalizedName("ItemRegistry:strawberrysodaItem");

			ItemRegistry.caramelicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.caramelicecreamID, ((ItemFood)ItemRegistry.caramelicecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.caramelicecreamItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:caramelicecreamItem");
			ItemRegistry.mintchocolatechipicemcreamItem = new IguanaFoodPam(HarvestConfigurationHandler.mintchocolatechipicecreamID, ((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).getHealAmount(), ((ItemFood)ItemRegistry.mintchocolatechipicemcreamItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:mintchocolatechipicecreamItem");
			ItemRegistry.strawberryicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.strawberryicecreamID, ((ItemFood)ItemRegistry.strawberryicecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.strawberryicecreamItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:strawberryicecreamItem");
			ItemRegistry.vanillaicecreamItem = new IguanaFoodPam(HarvestConfigurationHandler.vanillaicecreamID, ((ItemFood)ItemRegistry.vanillaicecreamItem).getHealAmount(), ((ItemFood)ItemRegistry.vanillaicecreamItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:vanillaicecreamItem");

			ItemRegistry.ediblerootItem = new ItemSeedFood(HarvestConfigurationHandler.ediblerootID, ((ItemFood)ItemRegistry.ediblerootItem).getHealAmount(), ((ItemFood)ItemRegistry.ediblerootItem).getSaturationModifier(), 23).setUnlocalizedName("ItemRegistry:ediblerootItem");

			ItemRegistry.gingerchickenItem = new IguanaFoodPam(HarvestConfigurationHandler.gingerchickenID, ((ItemFood)ItemRegistry.gingerchickenItem).getHealAmount(), ((ItemFood)ItemRegistry.gingerchickenItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:gingerchickenItem");


			ItemRegistry.oldworldveggiesoupItem = new IguanaFoodPam(HarvestConfigurationHandler.oldworldveggiesoupID, ((ItemFood)ItemRegistry.oldworldveggiesoupItem).getHealAmount(), ((ItemFood)ItemRegistry.oldworldveggiesoupItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:oldworldveggiesoupItem");
			ItemRegistry.spicebunItem = new IguanaFoodPam(HarvestConfigurationHandler.spicebunID, ((ItemFood)ItemRegistry.spicebunItem).getHealAmount(), ((ItemFood)ItemRegistry.spicebunItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:spicebunItem");
			ItemRegistry.gingeredrhubarbtartItem = new IguanaFoodPam(HarvestConfigurationHandler.gingeredrhubarbtartID, ((ItemFood)ItemRegistry.gingeredrhubarbtartItem).getHealAmount(), ((ItemFood)ItemRegistry.gingeredrhubarbtartItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:gingeredrhubarbtartItem");
			ItemRegistry.lambbarleysoupItem = new IguanaFoodPam(HarvestConfigurationHandler.lambbarleysoupID, ((ItemFood)ItemRegistry.lambbarleysoupItem).getHealAmount(), ((ItemFood)ItemRegistry.lambbarleysoupItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:lambbarleysoupItem");
			ItemRegistry.honeylemonlambItem = new IguanaFoodPam(HarvestConfigurationHandler.honeylemonlambID, ((ItemFood)ItemRegistry.honeylemonlambItem).getHealAmount(), ((ItemFood)ItemRegistry.honeylemonlambItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:honeylemonlambItem");
			ItemRegistry.pumpkinoatsconesItem = new IguanaFoodPam(HarvestConfigurationHandler.pumpkinoatsconesID, ((ItemFood)ItemRegistry.pumpkinoatsconesItem).getHealAmount(), ((ItemFood)ItemRegistry.pumpkinoatsconesItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:pumpkinoatsconesItem");
			ItemRegistry.beefjerkyItem = new IguanaFoodPam(HarvestConfigurationHandler.beefjerkyID, ((ItemFood)ItemRegistry.beefjerkyItem).getHealAmount(), ((ItemFood)ItemRegistry.beefjerkyItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:beefjerkyItem");
			ItemRegistry.plumjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.plumjuiceID, ((ItemFood)ItemRegistry.plumjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.plumjuiceItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:plumjuiceItem");
			ItemRegistry.pearjuiceItem = new IguanaFoodPam(HarvestConfigurationHandler.pearjuiceID, ((ItemFood)ItemRegistry.pearjuiceItem).getHealAmount(), ((ItemFood)ItemRegistry.pearjuiceItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:pearjuiceItem");
			ItemRegistry.ovenroastedcauliflowerItem = new IguanaFoodPam(HarvestConfigurationHandler.ovenroastedcauliflowerID, ((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).getHealAmount(), ((ItemFood)ItemRegistry.ovenroastedcauliflowerItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:ovenroastedcauliflowerItem");
			ItemRegistry.leekbaconsoupItem = new IguanaFoodPam(HarvestConfigurationHandler.leekbaconsoupID, ((ItemFood)ItemRegistry.leekbaconsoupItem).getHealAmount(), ((ItemFood)ItemRegistry.leekbaconsoupItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:leekbaconsoupItem");
			ItemRegistry.herbbutterparsnipsItem = new IguanaFoodPam(HarvestConfigurationHandler.herbbutterparsnipsID, ((ItemFood)ItemRegistry.herbbutterparsnipsItem).getHealAmount(), ((ItemFood)ItemRegistry.herbbutterparsnipsItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:herbbutterparsnipsItem");
			ItemRegistry.scallionbakedpotatoItem = new IguanaFoodPam(HarvestConfigurationHandler.scallionbakedpotatoID, ((ItemFood)ItemRegistry.scallionbakedpotatoItem).getHealAmount(), ((ItemFood)ItemRegistry.scallionbakedpotatoItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:scallionbakedpotatoItem");
			ItemRegistry.soymilkItem = new IguanaFoodPam(HarvestConfigurationHandler.soymilkID, ((ItemFood)ItemRegistry.soymilkItem).getHealAmount(), ((ItemFood)ItemRegistry.soymilkItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:soymilkItem");
			ItemRegistry.firmtofuItem = new IguanaFoodPam(HarvestConfigurationHandler.firmtofuID, ((ItemFood)ItemRegistry.firmtofuItem).getHealAmount(), ((ItemFood)ItemRegistry.firmtofuItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:firmtofuItem");
			ItemRegistry.silkentofuItem = new IguanaFoodPam(HarvestConfigurationHandler.silkentofuID, ((ItemFood)ItemRegistry.silkentofuItem).getHealAmount(), ((ItemFood)ItemRegistry.silkentofuItem).getSaturationModifier(), false).setUnlocalizedName("ItemRegistry:silkentofuItem");

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
		if (!ThaumcraftApi.exists(item, -1)) ThaumcraftApi.registerObjectTag(new ItemStack(item,1), new int[] {-1}, aspects);
	}

}
