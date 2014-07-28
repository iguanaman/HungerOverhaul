Incomplete list of things that need to be done. Will be added to/edited as things move forward.

#### From IguanaFoodStats
- [ ] Food value modifications
 - [x] Vanilla
 - [x] HarvestCraft
 - [x] TConstruct
 - [x] Natura
 - [x] Catch-all food value division for anything not specifically modified (IguanaConfig.modFoodValueDivider)
 - [ ] JSON for additional mods
- [x] Food regens health (config option)
- [x] Configurable damage on starve
- [x] Configurable max foodExhaustionLevel
- [x] IguanaConfig.hungerLossRatePercentage being zero stopping food stats from changing/keeping it at a specific level (19/0/0)
- [x] Configurable minimum hunger to heal (IguanaConfig.minHungerToHeal)
- [x] Configurable time between health regen from hunger (multiple config options)
- [x] Configurable food exhaustion from health regen (IguanaConfig.disableHealingHungerDrain)

#### From IguanaFood
- [x] Well fed buff (should be added to FoodEventHandler.onFoodEaten)
- [x] Stacksize modifications
- [x] Village trading/chest loot additions
- [x] Food eating speed modification
- [x] Food value tooltips (should use Forge's ItemTooltipEvent)

#### From IguanaPlayerHandler
- [x] Configurable hunger on respawn

#### From Block* Classes
- [ ] Stop updateTick from running depending on biome/sunlight/regrowthMultiplier (ASM)
 - [ ] Separate regrowthMultipliers for cactus/cocoa (cactusRegrowthMultiplier/cocoaRegrowthMultiplier)
- [x] Bonemealing
 - [x] Vanilla
 - [x] Natura
- [x] getDrops
- [x] Right-click to Harvest

#### All seeds
- [ ] Add 'crop grows best in' tooltips
 - [x] Vanilla seeds
 - [ ] HarvestCraft seeds
 - [x] Natura seeds

#### All foods/seeds
- [ ] Add Thaumcraft aspects
