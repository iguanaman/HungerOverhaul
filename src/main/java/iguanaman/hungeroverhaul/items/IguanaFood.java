package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.util.TradeHandlerFood;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class IguanaFood extends ItemFood {

	public IguanaFood(int par1, int par2, float par3, boolean par4) {
		this(par1, par2, par3, par4, false);
	}

	public IguanaFood(int par1, int par2, float par3, boolean par4, boolean integrate) {
		super(par1, par2, par3, par4);

		if (IguanaConfig.modifyFoodStackSize == true)
			if (par2 <= 2) setMaxStackSize(16 * IguanaConfig.foodStackSizeMultiplier);
			else if (par2 <= 5) setMaxStackSize(8 * IguanaConfig.foodStackSizeMultiplier);
			else if (par2 <= 8) setMaxStackSize(4 * IguanaConfig.foodStackSizeMultiplier);
			else if (par2 <= 11) setMaxStackSize(2 * IguanaConfig.foodStackSizeMultiplier);
			else setMaxStackSize(1 * IguanaConfig.foodStackSizeMultiplier);

		if (integrate && par2 > 9) {
			if (IguanaConfig.addTradesButcher)
				VillagerRegistry.instance().registerVillageTradeHandler(4, new TradeHandlerFood(itemID, maxStackSize));

			if (IguanaConfig.addHarvestCraftChestLoot) {
				ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, maxStackSize, IguanaConfig.chestLootChance));
				ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, maxStackSize, IguanaConfig.chestLootChance));
				ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, maxStackSize, IguanaConfig.chestLootChance));
				ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, maxStackSize, IguanaConfig.chestLootChance));
			}
		}

	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par3EntityPlayer.canEat(super.alwaysEdible) && !par3EntityPlayer.isPotionActive(Potion.hunger))
			par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));

		return par1ItemStack;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{

		if (!par2World.isRemote && par2World.getGameRules().getGameRuleBooleanValue("naturalRegeneration")
				&& IguanaConfig.healthRegenRatePercentage > 0)
			if (IguanaConfig.addWellFedEffect)
			{
				int duration = 0;
				try {
					duration = (int)Math.pow(healAmount * 100, 1.2);
				} catch (Exception var5) {}

				if (duration >= 30)
				{
					PotionEffect currentEffect = par3EntityPlayer.getActivePotionEffect(HungerOverhaul.potionWellFed);
					if (currentEffect != null) duration += currentEffect.duration;
					par3EntityPlayer.addPotionEffect(new PotionEffect(HungerOverhaul.potionWellFed.id, duration, 0, true));
				}
			}

		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().addStats(getHealAmount(), getSaturationModifier());
		if (par2World.rand.nextInt(6) == 0)
			par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		return par1ItemStack;
	}


	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return IguanaConfig.modifyFoodEatingSpeed ? getHealAmount() * 8 + 8 : 32;
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 */
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);

		if (IguanaConfig.addFoodTooltips) {
			int hungerFill = getHealAmount();
			float satiation = getSaturationModifier() * 20 - hungerFill;

			String tooltip = "";

			if (satiation  >= 3.0F) tooltip += "hearty ";
			else if (satiation  >= 2.0F) tooltip += "wholesome ";
			else if (satiation  > 0.0F) tooltip += "nourishing ";
			else if (satiation < 0.0F) tooltip += "unfulfilling ";

			if (hungerFill <= 1) tooltip += "morsel";
			else if (hungerFill <= 2) tooltip += "snack";
			else if (hungerFill <= 5) tooltip += "light meal";
			else if (hungerFill <= 8) tooltip += "meal";
			else if (hungerFill <= 11) tooltip += "large meal";
			else tooltip += "feast";

			par3List.add(tooltip.substring(0, 1).toUpperCase() + tooltip.substring(1));

			/*
	        int age = 0;
	        try {
	  	      age = par1ItemStack.stackTagCompound.getInteger("Age");
	        } catch (Exception e) {

	        }
	    	if (age >= stageRotten) {
	    		par3List.add("\u00A7cWill make you sick\u00A7r");
	    	} else if (age >= stageSpoiled) {
	    		par3List.add("\u00A76Will probably make you sick\u00A7r");
	    	} else if (age >= stageStale) {
	    		par3List.add("\u00A7eMay make you sick\u00A7r");
	    	} else if (age >= stageAged) {
	    		par3List.add("\u00A72Safe to eat\u00A7r");
	    	}
			 */
		}
	}

	/*
    public int rotTimer = 0;
    public int stageAged = 1; //(int)(90F / (HungerOverhaul.foodRotSpeed / 100));
    public int stageStale = 2; //(int)(180F / (HungerOverhaul.foodRotSpeed / 100));
    public int stageSpoiled = 3; //(int)(270F / (HungerOverhaul.foodRotSpeed / 100));
    public int stageRotten = 4; //(int)(360F / (HungerOverhaul.foodRotSpeed / 100));

    @Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
	        if (par1ItemStack.stackTagCompound == null)
	        {
                   par1ItemStack.setTagCompound(new NBTTagCompound());
                   par1ItemStack.stackTagCompound.setInteger("Age", 0);
	        }
	}

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

		if (par3Entity instanceof EntityPlayer && HungerOverhaul.addFoodRotting) {
			EntityPlayer player = (EntityPlayer)par3Entity;
			if (!player.capabilities.isCreativeMode) {
				if (++rotTimer >= 12000 / (HungerOverhaul.foodRotSpeed / 100)) { //10 mins default
					rotTimer = 0;
					int age = 0;
			        try {
			  	      age = par1ItemStack.stackTagCompound.getInteger("Age");
			        } catch (Exception e) {
		                   par1ItemStack.setTagCompound(new NBTTagCompound());
		                   par1ItemStack.stackTagCompound.setInteger("Age", 0);
			        }
			        if (age <= stageRotten)
			        {
		                par1ItemStack.stackTagCompound.setInteger("Age", ++age);
		    			if (age == stageAged) {
		    				par1ItemStack.setItemName("Aged " + new ItemStack(this).getDisplayName());
		    			} else if (age == stageStale) {
		    				par1ItemStack.setItemName("Stale " + new ItemStack(this).getDisplayName());
		    				this.setPotionEffect(Potion.poison.id, 30, 0, 0.2F);
		    			} else if (age == stageSpoiled) {
		    				par1ItemStack.setItemName("Spoiled " + new ItemStack(this).getDisplayName());
		    				this.setPotionEffect(Potion.poison.id, 30, 0, 0.6F);
		    			} else if (age == stageRotten) {
		    				par1ItemStack.setItemName("Rotten " + new ItemStack(this).getDisplayName());
		    				this.setPotionEffect(Potion.poison.id, 30, 0, 1.0F);
		            		//par1ItemStack.damageItem(1, player);
		    			}
			        }
				}
			}
		}
    }
	 */
}