package iguanaman.hungeroverhaul.util;

import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.module.ModuleGrassSeeds;
import iguanaman.hungeroverhaul.module.ModulePlantGrowth;

import java.text.DecimalFormat;
import java.util.Random;

import mods.natura.Natura;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.common.NContent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent;
import squeek.applecore.api.AppleCoreAPI;
import squeek.applecore.api.food.FoodValues;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaEventHook
{

    @SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event)
    {

        Random rand = new Random();

        // Slow growth and egg rates
        if (event.entityLiving instanceof EntityAnimal)
        {
            int rndBreed = rand.nextInt(IguanaConfig.breedingTimeoutMultiplier);
            int rndChild = rand.nextInt(IguanaConfig.childDurationMultiplier);
            EntityAgeable ageable = (EntityAgeable) event.entityLiving;
            int growingAge = ageable.getGrowingAge();
            if (growingAge > 0 && rndBreed != 0)
                ageable.setGrowingAge(++growingAge);
            else if (growingAge < 0 && rndChild != 0)
                ageable.setGrowingAge(--growingAge);

            if (IguanaConfig.eggTimeoutMultiplier > 1 && event.entityLiving instanceof EntityChicken)
            {
                int rnd = rand.nextInt(IguanaConfig.eggTimeoutMultiplier);
                EntityChicken chicken = (EntityChicken) event.entityLiving;
                if (chicken.timeUntilNextEgg > 0 && rnd != 0)
                    chicken.timeUntilNextEgg += 1;
            }

            // Reduced milked value every second
            if (IguanaConfig.milkedTimeout > 0 && event.entityLiving instanceof EntityCow && event.entityLiving.worldObj.getWorldTime() % 20 == 0)
            {
                NBTTagCompound tags = event.entityLiving.getEntityData();
                if (tags.hasKey("Milked"))
                {
                    int milked = tags.getInteger("Milked");
                    if (--milked <= 0)
                        tags.removeTag("Milked");
                    else
                        tags.setInteger("Milked", milked);
                }
            }
        }

        if (!event.entityLiving.worldObj.isRemote)
        {
            NBTTagCompound tags = event.entityLiving.getEntityData();

            // low stat effects
            if (tags.hasKey("HungerOverhaulCheck"))
            {
                int lastCheck = tags.getInteger("HungerOverhaulCheck");
                if (--lastCheck <= 0)
                    tags.removeTag("HungerOverhaulCheck");
                else
                    tags.setInteger("HungerOverhaulCheck", lastCheck);
            }
            else
            {
                float healthPercent = event.entityLiving.getHealth() / event.entityLiving.getMaxHealth();
                int foodLevel = 20;
                boolean creative = false;
                boolean isPlayer = false;
                if (event.entityLiving instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer) event.entityLiving;
                    creative = player.capabilities.isCreativeMode;
                    foodLevel = player.getFoodStats().getFoodLevel();
                    isPlayer = true;
                }
                else
                    healthPercent /= 2;

                if (event.entityLiving instanceof EntityPlayer && IguanaConfig.constantHungerLoss)
                {
                    EntityPlayer player = (EntityPlayer) event.entityLiving;
                    if (!player.capabilities.isCreativeMode && !player.isDead)
                        player.addExhaustion(0.01F);
                }

                if (IguanaConfig.addLowStatEffects)
                {
                    int difficultyModifierEffects = 2;
                    if (IguanaConfig.difficultyScaling && IguanaConfig.difficultyScalingEffects)
                    {
                        difficultyModifierEffects = event.entityLiving.worldObj.difficultySetting.getDifficultyId();

                        if (!(event.entityLiving instanceof EntityPlayer))
                            difficultyModifierEffects = difficultyModifierEffects * -1 + 3;
                    }

                    // low stat effects
                    if (!creative && isPlayer && !event.entityLiving.isDead && healthPercent > 0f)
                    {

                        if (IguanaConfig.addLowStatSlowness)
                            if (foodLevel <= 1 || healthPercent <= 0.05F)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, 1 + difficultyModifierEffects, true));
                            else if (foodLevel <= 2 || healthPercent <= 0.10F)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, difficultyModifierEffects, true));
                            else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 1)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -1 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 4 || healthPercent <= 0.20F) && difficultyModifierEffects >= 2)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -2 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 5 || healthPercent <= 0.25F) && difficultyModifierEffects >= 3)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 19, -3 + difficultyModifierEffects, true));

                        if (IguanaConfig.addLowStatMiningSlowdown)
                            if (foodLevel <= 1 || healthPercent <= 0.05F)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, 1 + difficultyModifierEffects, true));
                            else if (foodLevel <= 2 || healthPercent <= 0.10F)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, difficultyModifierEffects, true));
                            else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 1)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -1 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 4 || healthPercent <= 0.20F) && difficultyModifierEffects >= 2)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -2 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 5 || healthPercent <= 0.25F) && difficultyModifierEffects >= 3)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 19, -3 + difficultyModifierEffects, true));

                        if (IguanaConfig.addLowStatWeakness)
                            //Weakness effect
                            if ((foodLevel <= 1 || healthPercent <= 0.05F) && difficultyModifierEffects >= 1)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -1 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 2 || healthPercent <= 0.10F) && difficultyModifierEffects >= 2)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -2 + difficultyModifierEffects, true));
                            else if ((foodLevel <= 3 || healthPercent <= 0.15F) && difficultyModifierEffects >= 3)
                                event.entityLiving.addPotionEffect(new PotionEffect(Potion.weakness.id, 19, -3 + difficultyModifierEffects, true));

                        if (IguanaConfig.addLowStatNausea && isPlayer && (foodLevel <= 1 || healthPercent <= 0.05F))
                            event.entityLiving.addPotionEffect(new PotionEffect(Potion.confusion.id, 19, 0, true));
                    }
                }

                tags.setInteger("HungerOverhaulCheck", 9);
            }
        }
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event)
    {
        if (IguanaConfig.modifyHoeUse)
        {
            Block block = event.world.getBlock(event.x, event.y, event.z);

            if ((block == Blocks.dirt || block == Blocks.grass) && isWaterNearby(event.world, event.x, event.y, event.z))
            {
                if (IguanaConfig.hoeToolDamageMultiplier > 1)
                    event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
            }
            else if (block == Blocks.grass && !isWaterNearby(event.world, event.x, event.y, event.z))
            {

                Block block1 = Blocks.farmland;
                event.world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, block1.stepSound.soundName, (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
                if (!event.world.isRemote)
                {
                    int seedChance = IguanaConfig.seedChance;
                    if (event.world.difficultySetting.getDifficultyId() < 2)
                        seedChance *= 2;
                    else if (event.world.difficultySetting.getDifficultyId() == 3)
                        seedChance = Math.max(Math.round(seedChance / 2f), 1);

                    if (event.world.rand.nextInt(100) <= seedChance)
                    {
                        ItemStack seed = ModuleGrassSeeds.getSeedFromTillingGrass(event.world);
                        if (seed != null)
                            block.dropBlockAsItem(event.world, event.x, event.y, event.z, seed);
                    }
                    event.world.setBlock(event.x, event.y, event.z, Blocks.dirt);
                }

                if (IguanaConfig.hoeToolDamageMultiplier > 1)
                    event.current.damageItem(IguanaConfig.hoeToolDamageMultiplier - 1, event.entityPlayer);
                event.setResult(Result.ALLOW);
            }
            else
                event.setCanceled(true);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event)
    {
        if (IguanaConfig.addGuiText)
        {
            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayer player = mc.thePlayer;

            if (!player.isDead && !player.capabilities.isCreativeMode && !mc.gameSettings.showDebugInfo)
            {

                float healthPercent = player.getHealth() / player.getMaxHealth();

                if (healthPercent <= 0.15F)
                    event.left.add("\u00A7cDying\u00A7r");
                else if (healthPercent <= 0.3F)
                    event.left.add("\u00A7eInjured\u00A7r");
                else if (healthPercent < 0.5F)
                    event.left.add("\u00A7fHurt\u00A7r");

                if (player.getFoodStats().getFoodLevel() <= 6)
                    event.right.add("\u00A7cStarving\u00A7r");
                else if (player.getFoodStats().getFoodLevel() <= 10)
                    event.right.add("\u00A7eHungry\u00A7r");
                else if (player.getFoodStats().getFoodLevel() <= 14)
                    event.right.add("\u00A7fPeckish\u00A7r");
            }
        }
    }

    @SubscribeEvent
    public void onEntityInteractEvent(EntityInteractEvent event)
    {
        if (IguanaConfig.milkedTimeout > 0 && event.entityPlayer != null && event.target != null && event.target instanceof EntityCow)
        {
            EntityCow cow = (EntityCow) event.target;
            EntityPlayer player = event.entityPlayer;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped != null && equipped.getItem() != null)
            {
                Item item = equipped.getItem();
                if (item instanceof ItemBucket && ((ItemBucket) item).isFull == Blocks.air || cow instanceof EntityMooshroom && item == Items.bowl)
                {
                    NBTTagCompound tags = cow.getEntityData();
                    if (tags.hasKey("Milked"))
                    {
                        event.setCanceled(true);
                        if (!player.worldObj.isRemote)
                            cow.playSound("mob.cow.hurt", 0.4F, (event.entity.worldObj.rand.nextFloat() - event.entity.worldObj.rand.nextFloat()) * 0.2F + 1.0F);
                    }
                    else
                        tags.setInteger("Milked", IguanaConfig.milkedTimeout * 60);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent event)
    {
        if (event.entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            AppleCoreAPI.mutator.setHealthRegenTickCounter(player, 0);
        }
    }

    @SubscribeEvent
    public void onPlayerInteraction(PlayerInteractEvent event)
    {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)
        {
            Block clicked = event.world.getBlock(event.x, event.y, event.z);
            if (clicked instanceof BlockCrops)
            {
                int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
                if (meta >= 7)
                {
                    clicked.dropBlockAsItem(event.world, event.x, event.y, event.z, meta, 0);
                    event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 2);
                    event.useItem = Result.DENY;
                }
            }
        }
    }

    @SubscribeEvent
    public void onBonemealUsed(BonemealEvent event) //TODO Condense to stop recalculating things over and over again. And to make cleaner.
    {
        if (event.block instanceof BlockCrops)
        {
            if (event.world.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
            {
                int r = 1;
                if (event.world.difficultySetting.getDifficultyId() < 1 && !IguanaConfig.difficultyScalingBoneMeal)
                    r = event.world.rand.nextInt(3);
                int l = Math.min(event.world.getBlockMetadata(event.x, event.y, event.z) + r, 7);
                event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
                event.setResult(Result.ALLOW);
            }
        }
        else if (event.block instanceof BlockStem)
        {
            int l = event.world.getBlockMetadata(event.x, event.y, event.z) + 1;
            if (l > 7)
                l = 7;
            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, l, 2);
            event.setResult(Result.ALLOW);
        }
        else if (Loader.isModLoaded("Natura"))
        {
            if (event.block == NContent.crops)
            {
                if (event.world.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
                {
                    int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
                    if (meta != 3 && meta != 8)
                    {
                        if (meta < 3)
                        {
                            int output = Natura.random.nextInt(3) + 1 + meta;
                            if (event.world.difficultySetting.getDifficultyId() == 2 && IguanaConfig.difficultyScalingBoneMeal)
                                output = 1 + meta;
                            if (output > 3)
                                output = 3;
                            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, output, 3);
                            event.setResult(Result.ALLOW);
                        }
                        else
                        {
                            int output = Natura.random.nextInt(4) + 1 + meta;
                            if (event.world.difficultySetting.getDifficultyId() == 2 && IguanaConfig.difficultyScalingBoneMeal)
                                output = 1 + meta;
                            if (output > 8)
                                output = 8;
                            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, output, 3);
                            event.setResult(Result.ALLOW);
                        }
                    }
                }
            }
            else if (event.block == NContent.berryBush)
            {
                if (event.world.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
                {
                    int meta = event.world.getBlockMetadata(event.x, event.y, event.z);

                    if (meta / 4 < 2)
                    {
                        int setMeta = event.world.rand.nextInt(2) + 1 + meta / 4;
                        if (setMeta > 2)
                            setMeta = 2;
                        if (event.world.difficultySetting.getDifficultyId() == 2 && IguanaConfig.difficultyScalingBoneMeal)
                            setMeta = 1;
                        event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, meta % 4 + setMeta * 4, 4);
                        event.setResult(Result.ALLOW);
                    }

                    Block block = event.world.getBlock(event.x, event.y + 1, event.z);
                    if (block == null || block.isAir(event.world, event.x, event.y + 1, event.z))
                    {
                        if (event.world.rand.nextInt(3) == 0)
                            event.world.setBlock(event.x, event.y + 1, event.z, event.block, meta % 4, 3);
                        event.setResult(Result.ALLOW);
                    }
                }
            }
            else if (event.block == NContent.netherBerryBush)
            {
                if (event.world.difficultySetting.getDifficultyId() < 3 || !IguanaConfig.difficultyScalingBoneMeal)
                {
                    int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
                    if (meta / 4 < 2)
                    {
                        if (event.world.rand.nextBoolean())
                        {
                            int setMeta = event.world.rand.nextInt(2) + 1 + meta / 4;
                            if (setMeta > 2)
                                setMeta = 2;
                            if (event.world.difficultySetting.getDifficultyId() == 2 && IguanaConfig.difficultyScalingBoneMeal)
                                setMeta = 1;
                            event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, meta % 4 + setMeta * 4, 4);
                        }
                        event.setResult(Result.ALLOW);
                    }

                    Block block = event.world.getBlock(event.x, event.y + 1, event.z);
                    if (block == null || block.isAir(event.world, event.x, event.y + 1, event.z))
                    {
                        if (event.world.rand.nextInt(6) == 0)
                            event.world.setBlock(event.x, event.y + 1, event.z, event.block, meta % 4, 3);
                        event.setResult(Result.ALLOW);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void renderTooltips(ItemTooltipEvent event)
    {
        if (AppleCoreAPI.accessor.isFood(event.itemStack))
        {
            if (IguanaConfig.addFoodTooltips)
            {
                FoodValues values = FoodValues.get(event.itemStack);
                int hungerFill = values.hunger;
                float satiation = values.saturationModifier * 20 - hungerFill;

                String mealDescriptor = "";

                if (hungerFill <= 1)
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.morsel");
                else if (hungerFill <= 2)
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.snack");
                else if (hungerFill <= 5)
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.lightmeal");
                else if (hungerFill <= 8)
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.meal");
                else if (hungerFill <= 11)
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.largemeal");
                else
                    mealDescriptor = StatCollector.translateToLocal("hungeroverhaul.feast");

                if (satiation >= 3.0F)
                    mealDescriptor = StatCollector.translateToLocalFormatted(StatCollector.translateToLocal("hungeroverhaul.hearty"), mealDescriptor);
                else if (satiation >= 2.0F)
                    mealDescriptor = StatCollector.translateToLocalFormatted(StatCollector.translateToLocal("hungeroverhaul.wholesome"), mealDescriptor);
                else if (satiation > 0.0F)
                    mealDescriptor = StatCollector.translateToLocalFormatted(StatCollector.translateToLocal("hungeroverhaul.nourishing"), mealDescriptor);
                else if (satiation < 0.0F)
                    mealDescriptor = StatCollector.translateToLocalFormatted(StatCollector.translateToLocal("hungeroverhaul.unfulfilling"), mealDescriptor);

                event.toolTip.add(mealDescriptor.substring(0, 1).toUpperCase() + mealDescriptor.substring(1));

                if (event.showAdvancedItemTooltips)
                {
                    event.toolTip.add("Hunger: " + values.hunger + " Sat: " + values.saturationModifier + " (+" + new DecimalFormat("##.##").format(values.getSaturationIncrement()) + ")");
                    FoodValues unmodifiedValues = FoodValues.getUnmodified(event.itemStack);
                    event.toolTip.add("Unmodified hunger: " + unmodifiedValues.hunger + " Sat: " + unmodifiedValues.saturationModifier + " (+" + new DecimalFormat("##.##").format(unmodifiedValues.getSaturationIncrement()) + ")");
                }
            }
        }
        else if (IguanaConfig.wrongBiomeRegrowthMultiplier > 1)
        {
            PlantGrowthModification growthModification = null;
            if (event.itemStack.getItem() instanceof IPlantable)
            {
                growthModification = ModulePlantGrowth.getPlantGrowthModification(((IPlantable) event.itemStack.getItem()).getPlant(null, 0, 0, 0));
            }

            if (growthModification != null && !growthModification.biomeGrowthModifiers.isEmpty())
            {
                String tooltip = "";
                for (BiomeDictionary.Type biomeType : growthModification.biomeGrowthModifiers.keySet())
                    tooltip += biomeType.toString().substring(0, 1).toUpperCase() + biomeType.toString().substring(1).toLowerCase() + ", ";
                event.toolTip.add(StatCollector.translateToLocal("hungeroverhaul.crop.grows.best.in"));
                event.toolTip.add(tooltip.substring(0, tooltip.length() - 2));
            }
        }
    }

    @SubscribeEvent
    public void onBlockHarvested(BlockEvent.HarvestDropsEvent event)
    {
        if (Loader.isModLoaded("Natura") && event.block instanceof CropBlock)
        {
            event.drops.clear();
            if (event.blockMetadata == 3 || event.blockMetadata == 8)
            {
                int count = IguanaConfig.producePerHarvestMin + event.world.rand.nextInt(IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
                for (int i = 0; i < count; i++)
                {
                    Item item = event.block.getItemDropped(event.blockMetadata, event.world.rand, 0);
                    if (item != null)
                        event.drops.add(new ItemStack(item, 1, event.block.damageDropped(event.blockMetadata)));
                }
            }
            else
            {
                event.drops.add(new ItemStack(BlockHelper.getSeedDropps(event.block), 1, BlockHelper.getSeedMetadata(event.block, event.blockMetadata)));
            }
        }
        else if (event.block instanceof BlockCrops)
        {
            event.drops.clear();
            if (event.blockMetadata >= 7)
            {
                int produce = IguanaConfig.producePerHarvestMin + event.world.rand.nextInt(1 + IguanaConfig.producePerHarvestMax - IguanaConfig.producePerHarvestMin);
                if (produce > 0)
                    event.drops.add(new ItemStack(BlockHelper.getPlantDrops(event.block), produce, 0));

                int seeds = IguanaConfig.seedsPerHarvestMin + event.world.rand.nextInt(1 + IguanaConfig.seedsPerHarvestMax - IguanaConfig.seedsPerHarvestMin);
                if (seeds > 0)
                    event.drops.add(new ItemStack(BlockHelper.getSeedDropps(event.block), seeds, 0));
            }
            else
            {
                event.drops.add(new ItemStack(BlockHelper.getSeedDropps(event.block), 1, 0));
            }
        }
    }

    /**
     * returns true if there's water nearby (x-4 to x+4, y to y+1, k-4 to k+4)
     */
    private boolean isWaterNearby(World par1World, int par2, int par3, int par4)
    {
        for (int l = par2 - 4; l <= par2 + 4; ++l)
            for (int i1 = par3; i1 <= par3 + 1; ++i1)
                for (int j1 = par4 - 4; j1 <= par4 + 4; ++j1)
                    if (par1World.getBlock(l, i1, j1).getMaterial() == Material.water)
                        return true;

        return false;
    }
}
