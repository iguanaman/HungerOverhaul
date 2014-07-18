Incomplete list of things that need to be done. Will be added to/edited as things move forward.

#### From IguanaFoodStats
- [x] Player field
- [x] Food value modification support
- [ ] Food value modifications
 - [x] Vanilla
 - [ ] HarvestCraft
 - [x] TConstruct
 - [ ] Natura
 - [x] Catch-all food value division for anything not specifically modified (IguanaConfig.modFoodValueDivider)
- [x] Food regens health (config option)
- [x] Configurable damage on starve
- [x] Configurable max foodExhaustionLevel
- [x] IguanaConfig.hungerLossRatePercentage being zero stopping food stats from changing/keeping it at a specific level (19/0/0)
- [x] Configurable minimum hunger to heal (IguanaConfig.minHungerToHeal)
- [ ] Configurable time between health regen from hunger (multiple config options)
- [ ] Separate starve timer from food timer

#### From IguanaFood
- [x] Well fed buff (should be added to FoodEventHandler.onFoodEaten)
- [x] Stacksize modifications
- [ ] Village trading/chest loot additions
- [x] Food eating speed modification
- [x] Food value tooltips (should use Forge's ItemTooltipEvent)

#### From Block* Classes
- [ ] Stop updateTick from running depending on biome/sunlight/regrowthMultiplier
 - [ ] Separate regrowthMultipliers for cactus/cocoa (cactusRegrowthMultiplier/cocoaRegrowthMultiplier)
- [x] Bonemealing
- [x] getDrops
- [x] Right-click to Harvest

#### All seeds
- [ ] Add 'crop grows best in' tooltips
 - [x] Vanilla seeds
 - [ ] HarvestCraft seeds

#### All foods/seeds
- [ ] Add Thaumcraft aspects