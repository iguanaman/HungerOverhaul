package iguanaman.hungeroverhaul;

import java.io.File;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class IguanaConfig {

    public static boolean addTradesButcher;
    public static boolean addTradesFarmer;
    public static boolean addHarvestCraftChestLoot;
    public static boolean addCustomVillageField;
    public static boolean addFoodTooltips;
    public static boolean addFoodRotting;
    public static boolean modifyFoodStackSize;
    public static boolean modifyFoodEatingSpeed;
    public static boolean modifyFoodStats;
    public static boolean modifyFoodValues;
    public static boolean cropsNeedSunlight;
    public static boolean addGuiText;
    public static boolean addSetHungerCommand;
    public static boolean removeTallGrassSeeds;
    public static boolean removeHoeRecipes;
    public static boolean modifyHoeUse;
    public static boolean difficultyScalingBoneMeal;
    public static boolean addSleepHungerLoss;
    public static boolean difficultyScalingSleepHungerLoss;
    
    public static int hoeToolDamageMultiplier;
    public static int wrongBiomeRegrowthMultiplier;
    public static int flowerRegrowthMultiplier;
    public static int cropRegrowthMultiplier;
    public static int treeCropRegrowthMultiplier;
    public static int seedsPerHarvestMin;
    public static int seedsPerHarvestMax;
    public static int producePerHarvestMin;
    public static int producePerHarvestMax;
    public static int foodStackSizeMultiplier;
    public static int modFoodValueDivider;
    public static int seedChance;
    public static int seedChanceDifficultyModifier;
    public static int eggTimeoutMultiplier;
    public static int breedingTimeoutMultiplier;
    public static int childDurationMultiplier;
    public static int chestLootChance;

    public static int fieldNormalWeight;
    public static int fieldReedWeight;
    public static int fieldStemWeight;
    
    public static int foodRotSpeed;

    public static boolean foodRegensHealth;
    public static boolean disableHunger;
    public static boolean difficultyScaling;
    public static boolean difficultyScalingEffects;
    public static boolean difficultyScalingHealing;
    public static boolean difficultyScalingHunger;
    public static boolean difficultyScalingRespawnHunger;
    public static boolean constantHungerLoss;
    public static boolean addWellFedEffect;
    public static boolean addLowStatEffects;
    public static boolean addLowStatNausea;
    public static boolean addLowStatSlowness;
    public static boolean addLowStatWeakness;
    public static boolean addLowStatMiningSlowdown;
    public static boolean disableHealingHungerDrain;
    public static int damageOnStarve;
    public static int minHungerToHeal;
    public static int respawnHungerValue;
    public static int respawnHungerDifficultyModifier;
    public static int hungerLossRatePercentage;
    public static int healthRegenRatePercentage;
    public static int lowHealthRegenRateModifier;
    public static int foodHealDivider;
    
    public static int wellFedId;
	public static int newSlowdownPotionId;
	
	public static void init(File file) {

        Configuration config = new Configuration(file);
        config.load();
        
        // modules
		ConfigCategory modulesCategory = config.getCategory("modules");
		modulesCategory.setComment("Disable features here.  Some features won't be added unless you have other mods, shown in brackets.");
		
        Property addFoodTooltipsProperty = config.get("modules", "addFoodTooltips", true);
		addFoodTooltipsProperty.comment = "Add tooltips to food items showing hints at food value";
		addFoodTooltips = addFoodTooltipsProperty.getBoolean(true);
		
        Property addFoodRottingProperty = config.get("modules", "addFoodRotting", false);
        addFoodRottingProperty.comment = "Turning on causes food to spoil over time";
        addFoodRotting = addFoodRottingProperty.getBoolean(false);

        Property addGuiTextProperty = config.get("modules", "addGuiText", true);
		addGuiTextProperty.comment = "Shows onscreen text when hunger/health is low";
		addGuiText = addGuiTextProperty.getBoolean(true);

        Property addHarvestCraftChestLootProperty = config.get("modules", "addHarvestCraftChestLoot", true);
		addHarvestCraftChestLootProperty.comment = "HarvestCraft items added to dungeon/temple chests (Harvestcraft)";
		addHarvestCraftChestLoot = addHarvestCraftChestLootProperty.getBoolean(true);

        Property addCustomVillageFieldProperty = config.get("modules", "addCustomVillageField", false);
        addCustomVillageFieldProperty.comment = "Adds a custom field to villages (possibly causes crashes, use at own risk)";
		addCustomVillageField = addCustomVillageFieldProperty.getBoolean(false);

        Property addSetHungerCommandProperty = config.get("modules", "addSetHungerCommand", true);
		addSetHungerCommandProperty.comment = "Adds a console command to allow OPs to set a player's hunger level";
		addSetHungerCommand = addSetHungerCommandProperty.getBoolean(true);

        Property addTradesButcherProperty = config.get("modules", "addTradesButcher", true);
		addTradesButcherProperty.comment = "Add high tier HarvestCraft foods to the items butcher villagers will sell (HarvestCraft)";
		addTradesButcher = addTradesButcherProperty.getBoolean(true);

        Property addTradesFarmerProperty = config.get("modules", "addTradesFarmer", true);
		addTradesFarmerProperty.comment = "Add HarvestCraft crop produce to the items farmer villagers will buy (HarvestCraft)";
		addTradesFarmer = addTradesFarmerProperty.getBoolean(true);

        Property cropsNeedSunlightProperty = config.get("modules", "cropsNeedSunlight", true);
		cropsNeedSunlightProperty.comment = "Make crops only grow in sunlight (not torchlight)";
		cropsNeedSunlight = cropsNeedSunlightProperty.getBoolean(true);

        Property modifyFoodEatingSpeedProperty = config.get("modules", "modifyFoodEatingSpeed", true);
		modifyFoodEatingSpeedProperty.comment = "Changes the eating animation speed to be dependant on the food's replenishment value";
		modifyFoodEatingSpeed = modifyFoodEatingSpeedProperty.getBoolean(true);

        Property modifyFoodStackSizeProperty = config.get("modules", "modifyFoodStackSize", true);
		modifyFoodStackSizeProperty.comment = "Changes the stack size of food to be dependant on the food's replenishment value";
		modifyFoodStackSize = modifyFoodStackSizeProperty.getBoolean(true);

        Property modifyFoodStatsProperty = config.get("modules", "modifyFoodStats", true);
		modifyFoodStatsProperty.comment = "Enable/disable all features under the 'hunger' category of this config";
		modifyFoodStats = modifyFoodStatsProperty.getBoolean(true);

        Property modifyFoodValuesProperty = config.get("modules", "modifyFoodValues", true);
		modifyFoodValuesProperty.comment = "Changes the replenishment value of vanilla and HarvestCraft foods";
		modifyFoodValues = modifyFoodValuesProperty.getBoolean(true);

        Property removeHoeRecipesProperty = config.get("modules", "removeHoeRecipes", true);
        removeHoeRecipesProperty.comment = "Whether wood and stone hoe recipes are removed";
        removeHoeRecipes = removeHoeRecipesProperty.getBoolean(true);

        Property modifyHoeUseProperty = config.get("modules", "modifyHoeUse", true);
        modifyHoeUseProperty.comment = "Changes the use of hoes depending on the availability of water";
		modifyHoeUse = modifyHoeUseProperty.getBoolean(true);

        Property removeTallGrassSeedsProperty = config.get("modules", "removeTallGrassSeeds", true);
        removeTallGrassSeedsProperty.comment = "Removes seed drops when breaking tall grass";
        removeTallGrassSeeds = removeTallGrassSeedsProperty.getBoolean(true);

        Property difficultyScalingBoneMealProperty = config.get("modules", "difficultyScalingBoneMeal", true);
        difficultyScalingBoneMealProperty.comment = "Effects of bone meal dependant of difficulty ('difficultyScaling' must be true)";
		difficultyScalingBoneMeal = difficultyScalingBoneMealProperty.getBoolean(true);

        Property difficultyScalingSleepHungerLossProperty = config.get("modules", "difficultyScalingSleepHungerLoss", true);
        difficultyScalingSleepHungerLossProperty.comment = "Hunger loss while sleeping depends on difficulty ('addSleepHungerLoss' and 'difficultyScaling' must be true)";
        difficultyScalingSleepHungerLoss = difficultyScalingSleepHungerLossProperty.getBoolean(true);

        Property addSleepHungerLossProperty = config.get("modules", "addSleepHungerLoss", false);
        addSleepHungerLossProperty.comment = "Enable/disable hunger loss while sleeping";
        addSleepHungerLoss = addSleepHungerLossProperty.getBoolean(false);
		
        Property difficultyScalingProperty = config.get("modules", "difficultyScaling", true);
		difficultyScalingProperty.comment = "Enable/Disable all difficulty scaling effect in one setting";
		difficultyScaling = difficultyScalingProperty.getBoolean(true);
		
		
		// modifiers
		ConfigCategory modifiersCategory = config.getCategory("modifiers");
		modifiersCategory.setComment("Here you can change various multipiers and cutoff values");
		
        Property wrongBiomeRegrowthMultiplierProperty = config.get("modifiers", "wrongBiomeRegrowthMultiplier", 2);
		wrongBiomeRegrowthMultiplierProperty.comment = "Multipier on time it takes any crop to grow in the wrong biome";
		wrongBiomeRegrowthMultiplier = wrongBiomeRegrowthMultiplierProperty.getInt(2);

        Property flowerRegrowthMultiplierProperty = config.get("modifiers", "flowerRegrowthMultiplier", 1);
        flowerRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a WeeeFlower crop to grow";
		flowerRegrowthMultiplier = flowerRegrowthMultiplierProperty.getInt(1);

        Property cropRegrowthMultiplierProperty = config.get("modifiers", "cropRegrowthMultiplier", 4);
		cropRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a non-tree crop to grow";
		cropRegrowthMultiplier = cropRegrowthMultiplierProperty.getInt(4);

        Property treeCropRegrowthMultiplierProperty = config.get("modifiers", "treeCropRegrowthMultiplier", 2);
		treeCropRegrowthMultiplierProperty.comment = "Multiplier on the time it takes a tree crop to grow";
		treeCropRegrowthMultiplier = treeCropRegrowthMultiplierProperty.getInt(2);

        Property seedsPerHarvestMinProperty = config.get("modifiers", "seedsPerHarvestMin", 0);
		seedsPerHarvestMinProperty.comment = "Minimum number of seeds you get when harvesting a non-tree crop";
		seedsPerHarvestMin = seedsPerHarvestMinProperty.getInt(0);

        Property seedsPerHarvestMaxProperty = config.get("modifiers", "seedsPerHarvestMax", 0);
		seedsPerHarvestMaxProperty.comment = "Maximum number of seeds you get when harvesting a non-tree crop";
		seedsPerHarvestMax = seedsPerHarvestMaxProperty.getInt(0);

        Property producePerHarvestMinProperty = config.get("modifiers", "producePerHarvestMin", 2);
		producePerHarvestMinProperty.comment = "Minimum number of produce you get when harvesting a non-tree crop";
		producePerHarvestMin = producePerHarvestMinProperty.getInt(2);

        Property producePerHarvestMaxProperty = config.get("modifiers", "producePerHarvestMax", 4);
		producePerHarvestMaxProperty.comment = "Maximum number of produce you get when harvesting a non-tree crop";
		producePerHarvestMax = producePerHarvestMaxProperty.getInt(4);

        Property wellFedIdProperty = config.get("modifiers", "wellFedID", 30);
		wellFedIdProperty.comment = "Potion ID for the 'Well Fed' effect (maximum 31)";
		wellFedId = wellFedIdProperty.getInt(30);

        Property foodStackSizeMultiplierProperty = config.get("modifiers", "foodStackSizeMultiplier", 1);
		foodStackSizeMultiplierProperty.comment = "Multiplier on the stack size of food ('modifyFoodStackSize' must be true)";
		foodStackSizeMultiplier = foodStackSizeMultiplierProperty.getInt(1);

        Property modFoodValueDividerProperty = config.get("modifiers", "modFoodValueDivider", 4);
        modFoodValueDividerProperty.comment = "Other mod's food replenishment values are divided by this ('modifyFoodStats' and 'modifyFoodValues' must be true)";
		modFoodValueDivider = modFoodValueDividerProperty.getInt(4);

        Property hoeToolDamageMultiplierProperty = config.get("modifiers", "hoeToolDamageMultiplier", 5);
        hoeToolDamageMultiplierProperty.comment = "Multiplier on tool damage taken when a hoe is used";
        hoeToolDamageMultiplier = hoeToolDamageMultiplierProperty.getInt(5);

        Property seedChanceProperty = config.get("modifiers", "seedChance", 40);
        seedChanceProperty.comment = "Chance for seed to drop on peaceful difficulty";
        seedChance = seedChanceProperty.getInt(40);

        Property seedChanceDifficultyModifierProperty = config.get("modifiers", "seedChanceDifficultyModifier", 10);
        seedChanceDifficultyModifierProperty.comment = "Amount subtracted from 'seedChance' for every level of difficulty over peaceful";
        seedChanceDifficultyModifier = seedChanceDifficultyModifierProperty.getInt(10);

        Property eggTimeoutMultiplierProperty = config.get("modifiers", "eggTimeoutMultiplier", 4);
        eggTimeoutMultiplierProperty.comment = "Multiplier applied to the delay between chicken egg laying";
        eggTimeoutMultiplier = eggTimeoutMultiplierProperty.getInt(4);

        Property breedingTimeoutMultiplierProperty = config.get("modifiers", "breedingTimeoutMultiplier", 4);
        breedingTimeoutMultiplierProperty.comment = "Multiplier applied to the delay between breeding entities";
        breedingTimeoutMultiplier = breedingTimeoutMultiplierProperty.getInt(4);

        Property childDurationMultiplierProperty = config.get("modifiers", "childDurationMultiplier", 4);
        childDurationMultiplierProperty.comment = "Multiplier applied to the delay before children become adults";
        childDurationMultiplier = childDurationMultiplierProperty.getInt(4);

        Property fieldNormalWeightProperty = config.get("modifiers", "fieldNormalWeight", 70);
        fieldNormalWeightProperty.comment = "Weighted chance for custom field to contain 'normal' crops";
        fieldNormalWeight = fieldNormalWeightProperty.getInt(70);

        Property fieldReedWeightProperty = config.get("modifiers", "fieldReedWeight", 10);
        fieldReedWeightProperty.comment = "Weighted chance for custom field to contain reeds";
        fieldReedWeight = fieldReedWeightProperty.getInt(10);

        Property fieldStemWeightProperty = config.get("modifiers", "fieldStemWeight", 10);
        fieldStemWeightProperty.comment = "Weighted chance for custom field to contain pumpkins/melons";
        fieldStemWeight = fieldStemWeightProperty.getInt(10);

        Property chestLootChanceProperty = config.get("modifiers", "chestLootChance", 5);
        chestLootChanceProperty.comment = "Weighted chance for food to be found in chests (addHarvestCraftChestLoot must be true)";
        chestLootChance = chestLootChanceProperty.getInt(5);

        Property foodRotSpeedProperty = config.get("modifiers", "foodRotSpeed", 100);
        foodRotSpeedProperty.comment = "Rate at which food rots";
        foodRotSpeed = foodRotSpeedProperty.getInt(100);

        Property foodHealDividerProperty = config.get("modifiers", "foodHealDivider", 4);
        foodHealDividerProperty.comment = "Amount of health food restores is the food value divided by this number (foodRegensHealth must be true)";
        foodHealDivider = foodHealDividerProperty.getInt(4);
        
        Property newSlowdownPotionIdProperty = config.get("modifiers", "newSlowdownPotionId", 28);
        newSlowdownPotionIdProperty.comment = "Potion ID for the new slowdown effect (maximum 31)";
        newSlowdownPotionId = newSlowdownPotionIdProperty.getInt(28);
        
        if (newSlowdownPotionId < 0) {
        	newSlowdownPotionId = 0;
        	newSlowdownPotionIdProperty.set(newSlowdownPotionId);
        	}
        
        
        
		// hunger settings
		ConfigCategory hungerCategory = config.getCategory("hunger");
		hungerCategory.setComment("These settings only take effect if 'modifyFoodStats' is true");

        Property foodRegensHealthProperty = config.get("hunger", "foodRegensHealth", false);
        foodRegensHealthProperty.comment = "Eating food regenerates health";
		foodRegensHealth = foodRegensHealthProperty.getBoolean(false);

        Property disableHungerProperty = config.get("hunger", "disableHunger", false);
        disableHungerProperty.comment = "Eating food regenerates health";
        disableHunger = disableHungerProperty.getBoolean(false);

        Property difficultyScalingEffectsProperty = config.get("hunger", "difficultyScalingEffects", true);
		difficultyScalingEffectsProperty.comment = "Negative effects on low health/hunger scale by difficulty ('difficultyScaling' must be true)";
		difficultyScalingEffects = difficultyScalingEffectsProperty.getBoolean(true);

        Property difficultyScalingHealingProperty = config.get("hunger", "difficultyScalingHealing", true);
		difficultyScalingHealingProperty.comment = "Healing rate scales by difficulty ('difficultyScaling' must be true)";
		difficultyScalingHealing = difficultyScalingHealingProperty.getBoolean(true);

        Property difficultyScalingHungerProperty = config.get("hunger", "difficultyScalingHunger", true);
		difficultyScalingHungerProperty.comment = "Hunger loss rate scales by difficulty ('difficultyScaling' must be true)";
		difficultyScalingHunger = difficultyScalingHungerProperty.getBoolean(true);

        Property difficultyScalingRespawnHungerProperty = config.get("hunger", "difficultyScalingRespawnHunger", true);
        difficultyScalingRespawnHungerProperty.comment = "Hunger value after respawn is affected by difficulty ('difficultyScaling' must be true)";
        difficultyScalingRespawnHunger = difficultyScalingRespawnHungerProperty.getBoolean(true);

        Property constantHungerLossProperty = config.get("hunger", "constantHungerLoss", true);
        constantHungerLossProperty.comment = "You lose hunger (very slowly) at all times";
        constantHungerLoss = constantHungerLossProperty.getBoolean(true);

        Property addWellFedEffectProperty = config.get("hunger", "addWellFedEffect", true);
        addWellFedEffectProperty.comment = "Adds a 'well fed' effect that gives slight health regen";
		addWellFedEffect = addWellFedEffectProperty.getBoolean(true);

        Property addLowStatEffectsProperty = config.get("hunger", "addLowStatEffects", true);
		addLowStatEffectsProperty.comment = "Enables/disables all low hunger/health effects";
		addLowStatEffects = addLowStatEffectsProperty.getBoolean(true);

        Property addLowStatNauseaProperty = config.get("hunger", "addLowStatNausea", true);
		addLowStatNauseaProperty.comment = "Nausea effect when hunger is really low ('addLowStatEffects' must be true)";
		addLowStatNausea = addLowStatNauseaProperty.getBoolean(true);

        Property addLowStatSlownessProperty = config.get("hunger", "addLowStatSlowness", true);
		addLowStatSlownessProperty.comment = "Slowness effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatSlowness = addLowStatSlownessProperty.getBoolean(true);

        Property addLowStatWeaknessProperty = config.get("hunger", "addLowStatWeakness", true);
		addLowStatWeaknessProperty.comment = "Weakness effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatWeakness = addLowStatWeaknessProperty.getBoolean(true);

        Property addLowStatMiningSlowdownProperty = config.get("hunger", "addLowStatMiningSlowdown", true);
		addLowStatMiningSlowdownProperty.comment = "Mining slowdown effect when health/hunger is low ('addLowStatEffects' must be true)";
		addLowStatMiningSlowdown = addLowStatMiningSlowdownProperty.getBoolean(true);

        Property disableHealingHungerDrainProperty = config.get("hunger", "disableHealingHungerDrain", true);
        disableHealingHungerDrainProperty.comment = "Disable the hunger drain when healing that was introduced in vanilla 1.6.2";
		disableHealingHungerDrain = disableHealingHungerDrainProperty.getBoolean(true);

        Property minHungerToHealProperty = config.get("hunger", "minHungerToHeal", 7);
		minHungerToHealProperty.comment = "Minimum hunger level before healing starts (vanilla default is 18)";
		minHungerToHeal = minHungerToHealProperty.getInt(7);

        Property respawnHungerValueProperty = config.get("hunger", "respawnHungerValue", 20);
        respawnHungerValueProperty.comment = "Hunger value set after respawning for peaceful/easy difficulty (vanilla default is 20)";
        respawnHungerValue = respawnHungerValueProperty.getInt(20);

        Property respawnHungerDifficultyModifierProperty = config.get("hunger", "respawnHungerDifficultyModifier", 4);
        respawnHungerDifficultyModifierProperty.comment = "The amount difficulty modifies the hunger value set after respawning  ('difficultyScaling' and 'difficultyScalingRespawnHunger' must be true)";
        respawnHungerDifficultyModifier = respawnHungerDifficultyModifierProperty.getInt(4);

        Property damageOnStarveProperty = config.get("hunger", "damageOnStarve", 20);
		damageOnStarveProperty.comment = "Amount of damage you take when hunger hits zero (vanilla default 2)";
		damageOnStarve = damageOnStarveProperty.getInt(20);

        Property hungerLossRatePercentageProperty = config.get("hunger", "hungerLossRatePercentage", 100);
        hungerLossRatePercentageProperty.comment = "Speed up or slow down the rate that hunger drops";
		hungerLossRatePercentage = hungerLossRatePercentageProperty.getInt(100);

        Property healthRegenRatePercentageProperty = config.get("hunger", "healthRegenRatePercentage", 100);
        healthRegenRatePercentageProperty.comment = "Speed up or slow down the rate that health regenerates (0 to disable regen)";
        healthRegenRatePercentage = healthRegenRatePercentageProperty.getInt(100);

        Property lowHealthRegenRateModifierProperty = config.get("hunger", "lowHealthRegenRateModifier", 10);
        lowHealthRegenRateModifierProperty.comment = "The lower your health the longer it takes to regen, modify the effect here (lower = less effect)";
        lowHealthRegenRateModifier = lowHealthRegenRateModifierProperty.getInt(10);

        if (lowHealthRegenRateModifier < 0) {
        	lowHealthRegenRateModifier = 0;
        	hungerLossRatePercentageProperty.set(lowHealthRegenRateModifier);
        	}
        if (hungerLossRatePercentage < 0) {
        	hungerLossRatePercentage = 0;
        	hungerLossRatePercentageProperty.set(hungerLossRatePercentage);
        	}
        if (healthRegenRatePercentage < 0) {
        	healthRegenRatePercentage = 0;
        	healthRegenRatePercentageProperty.set(healthRegenRatePercentage);
        	}
        if (wrongBiomeRegrowthMultiplier < 1) {
        	wrongBiomeRegrowthMultiplier = 1;
        	wrongBiomeRegrowthMultiplierProperty.set(wrongBiomeRegrowthMultiplier);
        	}
        if (cropRegrowthMultiplier < 1) {
        	cropRegrowthMultiplier = 1;
			cropRegrowthMultiplierProperty.set(cropRegrowthMultiplier);
        	}
        if (treeCropRegrowthMultiplier < 1) {
        	treeCropRegrowthMultiplier = 1;
			treeCropRegrowthMultiplierProperty.set(treeCropRegrowthMultiplier);
        	}
        if (seedsPerHarvestMin < 0) {
        	seedsPerHarvestMin = 0;
			seedsPerHarvestMinProperty.set(seedsPerHarvestMin);
        	}
        if (seedsPerHarvestMax < seedsPerHarvestMin) {
        	seedsPerHarvestMax = seedsPerHarvestMin;
			seedsPerHarvestMaxProperty.set(seedsPerHarvestMax);
        	}
        if (producePerHarvestMin < 1) {
        	producePerHarvestMin = 1;
			producePerHarvestMinProperty.set(producePerHarvestMin);
        	}
        if (producePerHarvestMax < producePerHarvestMin) {
        	producePerHarvestMax = producePerHarvestMin;
			producePerHarvestMaxProperty.set(producePerHarvestMax);
        	}
        if (foodStackSizeMultiplier < 1) {
        	foodStackSizeMultiplier = 1;
			foodStackSizeMultiplierProperty.set(foodStackSizeMultiplier);
        	}
        if (foodStackSizeMultiplier > 4) {
        	foodStackSizeMultiplier = 4;
			foodStackSizeMultiplierProperty.set(foodStackSizeMultiplier);
        	}
        if (modFoodValueDivider < 1) {
        	modFoodValueDivider = 1;
			modFoodValueDividerProperty.set(modFoodValueDivider);
        	}
        if (eggTimeoutMultiplier < 1) {
        	eggTimeoutMultiplier = 1;
        	eggTimeoutMultiplierProperty.set(eggTimeoutMultiplier);
        	}
        if (breedingTimeoutMultiplier < 1) {
        	breedingTimeoutMultiplier = 1;
        	breedingTimeoutMultiplierProperty.set(breedingTimeoutMultiplier);
        	}
        if (childDurationMultiplier < 1) {
        	childDurationMultiplier = 1;
        	childDurationMultiplierProperty.set(childDurationMultiplier);
        	}
        if (wellFedId > 31) {
        	wellFedId = 31;
        	wellFedIdProperty.set(wellFedId);
        	}
        if (fieldNormalWeight < 0) {
        	fieldNormalWeight = 0;
        	fieldNormalWeightProperty.set(fieldNormalWeight);
        	}
        if (fieldReedWeight < 0) {
        	fieldReedWeight = 0;
        	fieldReedWeightProperty.set(fieldReedWeight);
        	}
        if (fieldStemWeight < 0) {
        	fieldStemWeight = 0;
        	fieldStemWeightProperty.set(fieldStemWeight);
        	}
        if (chestLootChance < 1) {
        	chestLootChance = 1;
        	chestLootChanceProperty.set(chestLootChance);
        	}
        if (foodRotSpeed < 1) {
        	foodRotSpeed = 1;
        	foodRotSpeedProperty.set(foodRotSpeed);
        	}
        if (foodHealDivider < 1) {
        	foodHealDivider = 1;
        	foodHealDividerProperty.set(foodHealDivider);
        	}

        config.save();
	}

}
