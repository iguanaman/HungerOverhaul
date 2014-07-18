Incomplete list of things that need to be done. Will be added to/edited as things move forward.

#### From IguanaFoodStats
- [x] Player field
- [x] Food value modification support
- [ ] Food value modifications
 - [x] Vanilla
 - [ ] HarvestCraft
 - [ ] TConstruct
 - [ ] Natura
 - [x] Catch-all food value division for anything not specifically modified (IguanaConfig.modFoodValueDivider)
- [x] Food regens health (config option)
- [x] Configurable damage on starve
- [ ] Configurable max foodExhaustionLevel
- [ ] IguanaConfig.hungerLossRatePercentage being zero stopping food stats from changing/keeping it at a specific level (19/0/0)
- [ ] Configurable minimum hunger to theal (IguanaConfig.minHungerToHeal)
- [ ] Configurable time between health regen from hunger (multiple config options)
- [ ] Separate starve timer from food timer

#### From IguanaFood
- [x] Well fed buff (should be added to FoodEventHandler.onFoodEaten)
- [x] Stacksize modifications
- [ ] Village trading/chest loot additions
- [x] Food eating speed modification
- [x] Food value tooltips (should use Forge's ItemTooltipEvent)

#### From Block* Classes
- [ ] updateTick (Tick Events?)
- [x] Bonemealing
- [x] getDrops
- [x] Right-click to Harvest