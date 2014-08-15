package iguanaman.hungeroverhaul.module;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.food.FoodModifier;
import iguanaman.hungeroverhaul.util.BonemealModification;
import iguanaman.hungeroverhaul.util.PlantGrowthModification;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary.Type;
import squeek.applecore.api.food.FoodValues;

import com.pam.harvestcraft.BlockPamFruit;
import com.pam.harvestcraft.BlockPamSapling;
import com.pam.harvestcraft.BlockRegistry;
import com.pam.harvestcraft.ItemRegistry;

public class ModuleHarvestCraft
{
    public static void init()
    {
        // SETUP VALUES
        float foodSaturation = 0.1F;
        if (IguanaConfig.modifyFoodValues)
        {
            ItemRegistry.cropfoodRestore = 1;
        }
        FoodValues cropFoodValues = new FoodValues(ItemRegistry.cropfoodRestore, foodSaturation);

        FoodModifier.setModifiedFoodValues(ItemRegistry.asparagusItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.barleyItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.beanItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.beetItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.broccoliItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cauliflowerItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.celeryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cranberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.garlicItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.gingerItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.leekItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.lettuceItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.oatsItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.onionItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.parsnipItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.peanutItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.pineappleItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.radishItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.riceItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.rutabagaItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.ryeItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.scallionItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.soybeanItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.spiceleafItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.sunflowerseedsItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.sweetpotatoItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.tealeafItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.turnipItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.whitemushroomItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.artichokeItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.bellpepperItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.brusselsproutItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cabbageItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cactusfruitItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.candleberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cantaloupeItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.chilipepperItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.coffeebeanItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cornItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.cucumberItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.eggplantItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.grapeItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.kiwiItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.mustardseedsItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.okraItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.peasItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.rhubarbItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.seaweedItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.tomatoItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.wintersquashItem, cropFoodValues);
        FoodModifier.setModifiedFoodValues(ItemRegistry.zucchiniItem, cropFoodValues);

        // HavestCraft Base
        if (IguanaConfig.modifyFoodValues)
        {
            FoodModifier.setModifiedFoodValues(ItemRegistry.toastItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cheeseItem, new FoodValues(1, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.icecreamItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grilledcheeseItem, new FoodValues(7, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.applejuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.applesauceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.applepieItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.caramelappleItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pumpkinbreadItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.roastedpumpkinseedsItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pumpkinsoupItem, new FoodValues(4, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.melonjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.melonsmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.carrotjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.carrotcakeItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.carrotsoupItem, new FoodValues(4, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.glazedcarrotsItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.butteredpotatoItem, new FoodValues(4, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.loadedbakedpotatoItem, new FoodValues(8, 0.6F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mashedpotatoesItem, new FoodValues(5, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.potatosaladItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.potatosoupItem, new FoodValues(4, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.friesItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grilledmushroomItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.stuffedmushroomItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickensandwichItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickennoodlesoupItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickenpotpieItem, new FoodValues(8, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.breadedporkchopItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.hotdogItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bakedhamItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.hamburgerItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cheeseburgerItem, new FoodValues(8, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.baconcheeseburgerItem, new FoodValues(9, 0.6F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.potroastItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishsandwichItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishsticksItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishandchipsItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.friedeggItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.scrambledeggItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.boiledeggItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.eggsaladItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.caramelItem, new FoodValues(1, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.taffyItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spidereyesoupItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zombiejerkyItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatebarItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.hotchocolateItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolateicecreamItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.vegetablesoupItem, new FoodValues(6, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.stockItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fruitsaladItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spagettiItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spagettiandmeatballsItem, new FoodValues(10, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.tomatosoupItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickenparmasanItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pizzaItem, new FoodValues(8, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.springsaladItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.porklettucewrapItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishlettucewrapItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bltItem, new FoodValues(9, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.leafychickensandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.leafyfishsandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.deluxecheeseburgerItem, new FoodValues(10, 0.6F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.delightedmealItem, new FoodValues(16, 0.8F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.onionsoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.potatocakesItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.hashItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.braisedonionsItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.heartybreakfastItem, new FoodValues(15, 0.8F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cornonthecobItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cornbreadItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.tortillaItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.nachoesItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.tacoItem, new FoodValues(8, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishtacoItem, new FoodValues(8, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.creamedcornItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberrysmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberrypieItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberrysaladItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatestrawberryItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peanutbutterItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.trailmixItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pbandjItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peanutbuttercookiesItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapejuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapejellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapesaladItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raisincookiesItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.picklesItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cucumbersaladItem, new FoodValues(5, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cucumbersoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.vegetarianlettucewrapItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.marinatedcucumbersItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.ricesoupItem, new FoodValues(5, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.friedriceItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mushroomrisottoItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.curryItem, new FoodValues(10, 0.55F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.rainbowcurryItem, new FoodValues(13, 0.7F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.refriedbeansItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bakedbeansItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.beansandriceItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chiliItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.beanburritoItem, new FoodValues(8, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.stuffedpepperItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.veggiestirfryItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grilledskewersItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.supremepizzaItem, new FoodValues(12, 0.7F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.omeletItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.hotwingsItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chilipoppersItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.extremechiliItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chilichocolateItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonaideItem, new FoodValues(1, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonbarItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fishdinnerItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonsmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonmeringueItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.candiedlemonItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonchickenItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberrysmoothieItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberrypieItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberrymuffinItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pancakesItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberrypancakesItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherrypieItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatecherryItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherrysmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cheesecakeItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherrycheesecakeItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.stuffedeggplantItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.eggplantparmItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryicedteaItem, new FoodValues(1, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chaiteaItem, new FoodValues(0, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.espressoItem, new FoodValues(1, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coffeeconlecheItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mochaicecreamItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pickledbeetsItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.beetsaladItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.beetsoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bakedbeetsItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.broccolimacItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.broccolindipItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.creamedbroccolisoupItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.sweetpotatopieItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.candiedsweetpotatoesItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mashedsweetpotatoesItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.steamedpeasItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.splitpeasoupItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pineappleupsidedowncakeItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pineapplehamItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pineappleyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.turnipsoupItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.roastedrootveggiemedleyItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bakedturnipsItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gingerbreadItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gingersnapsItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.candiedgingerItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.softpretzelandmustardItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spicymustardporkItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spicygreensItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.garlicbreadItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.garlicmashedpotatoesItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.garlicchickenItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.summerradishsaladItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.summersquashwithradishItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.celeryandpeanutbutterItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickencelerycasseroleItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peasandceleryItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.celerysoupItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zucchinibreadItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zucchinifriesItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zestyzucchiniItem, new FoodValues(9, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zucchinibakeItem, new FoodValues(9, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.asparagusquicheItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.asparagussoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.walnutraisinbreadItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.candiedwalnutsItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.brownieItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayajuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayasmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayayogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruitjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruitsmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruityogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.guacamoleItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.creamofavocadosoupItem, new FoodValues(6, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.avocadoburritoItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.poachedpearItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fruitcrumbleItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pearyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.plumyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bananasplitItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.banananutbreadItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bananasmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bananayogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coconutmilkItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chickencurryItem, new FoodValues(9, 0.5F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coconutshrimpItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coconutyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangejuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangechickenItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangesmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangeyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachcobblerItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachsmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limejuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.keylimepieItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limesmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limeyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangojuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangosmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangoyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranatejuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranatesmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranateyogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.vanillayogurtItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cinnamonrollItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.frenchtoastItem, new FoodValues(7, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.marshmellowsItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.donutItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatedonutItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.powdereddonutItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.jellydonutItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.frosteddonutItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cactussoupItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.wafflesItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.seedsoupItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.softpretzelItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.jellybeansItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.biscuitItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.creamcookieItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.jaffaItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.friedchickenItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatesprinklecakeItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.redvelvetcakeItem, new FoodValues(7, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.footlongItem, new FoodValues(9, 0.55F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherryyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapeyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolateyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberrycobblerItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberrysmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chocolatemilkItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pumpkinyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberrypieItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberrysmoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cinnamonsugardonutItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.melonyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwijuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwismoothieItem, new FoodValues(3, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwiyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.plainyogurtItem, new FoodValues(1, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.appleyogurtItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.saltedsunflowerseedsItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.sunflowerwheatrollsItem, new FoodValues(6, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.sunflowerbroccolisaladItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberryjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberrysauceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberrybarItem, new FoodValues(5, 0.3F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peppermintItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cactusfruitjuiceItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.baklavaItem, new FoodValues(7, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gummybearsItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.baconmushroomburgerItem, new FoodValues(10, 0.65F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.fruitpunchItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.meatystewItem, new FoodValues(6, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mixedsaladItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pinacoladaItem, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.shepardspieItem, new FoodValues(6, 0.4F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.eggnogItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.custardItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.sushiItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gardensoupItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.muttonrawItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.muttoncookedItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.calamarirawItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.calamaricookedItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.applejellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.applejellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwijellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwijellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limejellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limejellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangojellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangojellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangejellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangejellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayajellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayajellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranatejellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranatejellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruitjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruitjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.watermelonjellyItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.watermelonjellysandwichItem, new FoodValues(8, 0.45F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherrysodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.colasodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gingersodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapesodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonlimesodaItem, new FoodValues(3, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangesodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.rootbeersodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberrysodaItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.caramelicecreamItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mintchocolatechipicemcreamItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryicecreamItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.vanillaicecreamItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.ediblerootItem, new FoodValues(1, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gingerchickenItem, new FoodValues(6, 0.35F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.oldworldveggiesoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spicebunItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.gingeredrhubarbtartItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lambbarleysoupItem, new FoodValues(5, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.honeylemonlambItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pumpkinoatsconesItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.beefjerkyItem, new FoodValues(3, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.plumjuiceItem, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pearjuiceItem, new FoodValues(2, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.ovenroastedcauliflowerItem, new FoodValues(5, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.leekbaconsoupItem, new FoodValues(4, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.herbbutterparsnipsItem, new FoodValues(4, 0.2F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.scallionbakedpotatoItem, new FoodValues(4, 0.25F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.soymilkItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.firmtofuItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.silkentofuItem, new FoodValues(3, 0.15F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grilledasparagusItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.avocadoItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bananaItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.bellpepperItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blackberryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.blueberryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cactusfruitItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cantaloupeItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cherryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.chilipepperItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coconutItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.toastedcoconutItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.coffeeItem, new FoodValues(0, 0.0F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cornItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.popcornItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cranberryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.cucumberItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.dragonfruitItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.eggplantItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grilledeggplantItem, new FoodValues(2, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.grapeItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raisinsItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.kiwiItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lemonItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.limeItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.lettuceItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.mangoItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.nutmegItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.oliveItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.orangeItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.papayaItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.peachItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pearItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.plumItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.pomegranateItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.raspberryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.riceItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.ricecakeItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.spiceleafItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.starfruitItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.strawberryItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.tealeafItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.teaItem, new FoodValues(2, 0.1F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.tomatoItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.walnutItem, new FoodValues(1, 0.05F));
            FoodModifier.setModifiedFoodValues(ItemRegistry.zucchiniItem, new FoodValues(1, 0.05F));
        }

        //TODO Make work with Thaumcraft 4.2 when it comes out. That will be the first 1.7.10 version.

        // SAPLING ASPECTS
        /*if (Loader.isModLoaded("Thaumcraft"))
        {
            AspectList saplingAspects = new AspectList().add(Aspect.PLANT, 1).add(Aspect.TREE, 1);
            Block saplings[] = new Block[]{
            BlockRegistry.pamappleSapling, BlockRegistry.pamavocadoSapling, BlockRegistry.pambananaSapling,
            BlockRegistry.pamcherrySapling, BlockRegistry.pamcinnamonSapling, BlockRegistry.pamcoconutSapling,
            BlockRegistry.pamdragonfruitSapling, BlockRegistry.pamlemonSapling, BlockRegistry.pamlimeSapling,
            BlockRegistry.pammangoSapling, BlockRegistry.pamnutmegSapling, BlockRegistry.pamoliveSapling,
            BlockRegistry.pampapayaSapling, BlockRegistry.pampearSapling, BlockRegistry.pampeppercornSapling,
            BlockRegistry.pamplumSapling, BlockRegistry.pampomegranateSapling, BlockRegistry.pamstarfruitSapling,
            BlockRegistry.pamvanillabeanSapling, BlockRegistry.pamwalnutSapling
            };
            for (Block sapling : saplings)
                registerAspects(Item.getItemFromBlock(sapling), saplingAspects);
        }*/

        // SAPLING GROWTH
        PlantGrowthModification saplingGrowthModification = new PlantGrowthModification()
                .setGrowthTickProbability(IguanaConfig.saplingRegrowthMultiplier);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockPamSapling.class, saplingGrowthModification);

        // CROP GROWTH
        // only need to register the exceptions here,
        // the BlockCrops modification will cover the rest
        PlantGrowthModification humidCropGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.JUNGLE, 1)
                .setBiomeGrowthModifier(Type.SWAMP, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pampineappleCrop, humidCropGrowthModification);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pamspiceleafCrop, humidCropGrowthModification);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pamcandleberryCrop, humidCropGrowthModification);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pamgrapeCrop, humidCropGrowthModification);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pamkiwiCrop, humidCropGrowthModification);

        PlantGrowthModification desertCropGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(true)
                .setGrowthTickProbability(IguanaConfig.cropRegrowthMultiplier)
                .setBiomeGrowthModifier(Type.SANDY, 1);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockRegistry.pamcactusfruitCrop, desertCropGrowthModification);

        // FRUIT GROWTH
        // TODO: figure out if Jungle/Swamp being set as the correct biome for all fruit was intentional
        PlantGrowthModification fruitGrowthModification = new PlantGrowthModification()
                .setNeedsSunlight(false)
                .setGrowthTickProbability(IguanaConfig.treeCropRegrowthMultiplier);
        ModulePlantGrowth.registerPlantGrowthModifier(BlockPamFruit.class, fruitGrowthModification);

        /*
         * Bonemeal
         */
        BonemealModification fruitBonemealModification = new BonemealModification()
        {
            @Override
            public int getNewMeta(World world, int x, int y, int z, Block block, int currentMeta)
            {
                return Math.min(currentMeta + 1, 2);
            }
        };
        ModuleBonemeal.registerBonemealModifier(BlockPamFruit.class, fruitBonemealModification);
    }

    /*public static void registerAspects(Item item, AspectList aspects)
    {
        if (!ThaumcraftApi.exists(item, -1))
            ThaumcraftApi.registerObjectTag(new ItemStack(item, 1), new int[]{-1}, aspects);
    }*/
}
