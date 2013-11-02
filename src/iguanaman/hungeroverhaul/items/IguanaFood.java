package iguanaman.hungeroverhaul.items;

import iguanaman.hungeroverhaul.HungerOverhaul;
import iguanaman.hungeroverhaul.IguanaConfig;
import iguanaman.hungeroverhaul.handlers.TradeHandlerFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.VillagerRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import net.minecraft.item.crafting.IRecipe;

public class IguanaFood extends ItemFood {

    /** The amount this food item heals the player. */
    public int healAmount;
    
	public IguanaFood(int par1, int par2, float par3, boolean par4, boolean integrate, boolean isJuicy, boolean isSeedy) {
		super(par1, par2, par3, par4);
        this.healAmount = par2;
       
        // this.setAlwaysEdible();

		if (IguanaConfig.modifyFoodStackSize == true) {
	    	if (par2 <= 2) {
	            this.setMaxStackSize(16 * IguanaConfig.foodStackSizeMultiplier);
	    	} else if (par2 <= 5) {
	            this.setMaxStackSize(8 * IguanaConfig.foodStackSizeMultiplier);
	    	} else if (par2 <= 8) {
	            this.setMaxStackSize(4 * IguanaConfig.foodStackSizeMultiplier);
	    	} else if (par2 <= 11) {
	            this.setMaxStackSize(2 * IguanaConfig.foodStackSizeMultiplier);
	    	} else  {
	            this.setMaxStackSize(1 * IguanaConfig.foodStackSizeMultiplier);
	    	}
		}
    	
    	if (integrate == true && par2 > 9) {
    		if (IguanaConfig.addTradesButcher == true) {
        		VillagerRegistry.instance().registerVillageTradeHandler(4, new TradeHandlerFood(this.itemID, this.maxStackSize));
    		}

    		if (IguanaConfig.addHarvestCraftChestLoot == true) {
            	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, this.maxStackSize, IguanaConfig.chestLootChance));
            	ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, this.maxStackSize, IguanaConfig.chestLootChance));
            	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, this.maxStackSize, IguanaConfig.chestLootChance));
            	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(this), 0, this.maxStackSize, IguanaConfig.chestLootChance));
    		}
    	}

	}

	public IguanaFood(int par1, int par2, float par3, boolean par4) {
		this(par1, par2, par3, par4, false, false, false);
	}

	public IguanaFood(int par1, int par2, float par3, boolean par4, boolean integrate) {
		this(par1, par2, par3, par4, integrate, false, false);
	}

	public IguanaFood(int par1, int par2, float par3, boolean par4, boolean integrate, boolean isJuicy) {
		this(par1, par2, par3, par4, integrate, isJuicy, false);
	}

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
		return EnumAction.eat;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    { 
        if (par3EntityPlayer.canEat(super.alwaysEdible) && !par3EntityPlayer.isPotionActive(Potion.hunger))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

	@Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	
    	if (!par2World.isRemote) {
	    	if (IguanaConfig.addWellFedEffect == true)
	    	{
		    	int duration = 0;
		        try {
		        	duration = (int)Math.pow(this.healAmount * 100, 1.2);
		        } catch (Exception var5) {
		        	duration = 0;
		        }
		        if (duration > 0)	
		        {
		        	PotionEffect currentEffect = par3EntityPlayer.getActivePotionEffect(HungerOverhaul.potionWellFed);
		        	if (currentEffect != null) {
		        		duration += currentEffect.duration;
		        	}
		        	par3EntityPlayer.addPotionEffect(new PotionEffect(HungerOverhaul.potionWellFed.id, duration, 0, true));
		        }
	    	}
	    	
	    	/*
	    	List<Integer> ingredients = getIngredients(this.itemID);
	    	for(int ingredient : ingredients) {
	    		addFoodType(ingredient, par3EntityPlayer);
	    	}
	    	*/
	    	
    	}

        --par1ItemStack.stackSize;
        par3EntityPlayer.getFoodStats().addStats(this.getHealAmount(), this.getSaturationModifier());
        if (par2World.rand.nextInt(6) == 0)
        {
        	par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        }
        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        return par1ItemStack;
    }
    
    /*
    public List<Integer> getIngredients(int outputID)
    {
    	List<Integer> ingredients = new ArrayList<Integer>();
    	
    	IRecipe thisRecipe = null;
    	for(Object recipeObj : CraftingManager.getInstance().getRecipeList()) {
    		if (recipeObj instanceof IRecipe) {
        		IRecipe recipe = (IRecipe)recipeObj;
        		if (recipe.getRecipeOutput() != null) {
            		if (recipe.getRecipeOutput().itemID <= 0) {
          	           FMLLog.warning("Recipe output item ID is 0", new Object[0]);
            		} else {
                		if (recipe.getRecipeOutput().itemID == outputID) {
                			thisRecipe = recipe;
                			break;
                		}
            		}
        		}
    		} else {
 	           FMLLog.warning("Recipe not IRecipe", new Object[0]);
    		}
    	}
    
    	if (thisRecipe == null) {
	           FMLLog.warning("Could not find food recipe", new Object[0]);
    	} else {
    		FMLLog.warning("Recipe found", new Object[0]);
    		if (thisRecipe instanceof ShapedRecipes) {
 	           FMLLog.warning("Shaped recipe found", new Object[0]);
    			ItemStack[] recipeItems = ((ShapedRecipes) thisRecipe).recipeItems;
    			for(ItemStack item : recipeItems) {
    	 	           FMLLog.warning("Found itemstack ingredient: " + item.getDisplayName(), new Object[0]);
    	 	           ingredients.add(((ItemStack)item).itemID);
    			}
    		} else if  (thisRecipe instanceof ShapelessRecipes) {
	           FMLLog.warning("Shapeless recipe found", new Object[0]);
    			List recipeItems = ((ShapelessRecipes) thisRecipe).recipeItems;
    			for(Object item : recipeItems) {
 	 	           FMLLog.warning("Found itemstack ingredient: " + ((ItemStack)item).getDisplayName(), new Object[0]);
	 	           ingredients.add(((ItemStack)item).itemID);
    			}
    		} else if  (thisRecipe instanceof ShapedOreRecipe) {
 	           FMLLog.warning("Shapeless recipe found", new Object[0]);
     			Object[] recipeItems = ((ShapedOreRecipe) thisRecipe).getInput();
     			for(Object item : recipeItems) {
     				if (item instanceof ItemStack) {
        	 	           FMLLog.warning("Found itemstack ingredient: " + ((ItemStack)item).getDisplayName(), new Object[0]);
        	 	           ingredients.add(((ItemStack)item).itemID);
      				} else if (item instanceof String) {
      					FMLLog.warning("Found string ingredient: " + (String)item, new Object[0]);
      				} else if (item instanceof ItemStack[]) {
 	         	 	    FMLLog.warning("Found itemstack array ingredient list", new Object[0]);
      					for(ItemStack ingredient : (ItemStack[])item) {
 		        	 	       FMLLog.warning("Found itemstack array ingredient: " + ingredient.getDisplayName(), new Object[0]);
 		       	 	           ingredients.add(ingredient.itemID);
      					}
      				} else if (item instanceof ArrayList) {
 	         	 	   FMLLog.warning("Found arraylist ingredient list", new Object[0]);
      					for(ItemStack ingredient : (ArrayList<ItemStack>)item) {
      						FMLLog.warning("Found arraylist ingredient: " + ingredient.getDisplayName(), new Object[0]);
 		       	 	           ingredients.add(ingredient.itemID);
      					}
      				} else {
          	 	       FMLLog.warning("Found unknown ingredient", new Object[0]);
      				}
     			}
     		} else if  (thisRecipe instanceof ShapelessOreRecipe) {
 	           FMLLog.warning("Shapeless recipe found", new Object[0]);
     			List recipeItems = ((ShapelessOreRecipe) thisRecipe).getInput();
     			for(Object item : recipeItems) {
     				if (item instanceof ItemStack) {
       	 	           FMLLog.warning("Found itemstack ingredient: " + ((ItemStack)item).getDisplayName(), new Object[0]);
       	 	           ingredients.add(((ItemStack)item).itemID);
     				} else if (item instanceof String) {
     					FMLLog.warning("Found string ingredient: " + (String)item, new Object[0]);
     				} else if (item instanceof ItemStack[]) {
	         	 	    FMLLog.warning("Found itemstack array ingredient list", new Object[0]);
     					for(ItemStack ingredient : (ItemStack[])item) {
		        	 	       FMLLog.warning("Found itemstack array ingredient: " + ingredient.getDisplayName(), new Object[0]);
		       	 	           ingredients.add(ingredient.itemID);
     					}
     				} else if (item instanceof ArrayList) {
	         	 	   FMLLog.warning("Found arraylist ingredient list", new Object[0]);
     					for(ItemStack ingredient : (ArrayList<ItemStack>)item) {
     						FMLLog.warning("Found arraylist ingredient: " + ingredient.getDisplayName(), new Object[0]);
		       	 	           ingredients.add(ingredient.itemID);
     					}
     				} else {
         	 	       FMLLog.warning("Found unknown ingredient", new Object[0]);
     				}
     			}
     		}
    	}
    	
    	return ingredients;
    }
    
    public boolean addFoodType(int foodID, EntityPlayer player)
    {
		if (Item.itemsList[foodID] instanceof IguanaFood) {
			IguanaFood foodItem = (IguanaFood)Item.itemsList[foodID];
			if (foodItem.type != null && HungerOverhaul.modifyFoodStats == true) {
  	 	       	FMLLog.warning("Added to diet stat " + foodItem.type.name() + foodItem.type.id, new Object[0]);
				++player.getFoodStats().diet[foodItem.type.id];
				player.getFoodStats().diet[foodItem.type.id]++;
				player.getFoodStats().diet[foodItem.type.id] += 1;
				player.getFoodStats().diet[foodItem.type.id] = player.foodStats.diet[foodItem.type.id] +1;
				return true;
			}
		}
		return false;
    }
    */
    

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
		if (IguanaConfig.modifyFoodEatingSpeed == true) {
			return (this.getHealAmount() * 8) + 8;
		} else {
			return 32;
		}
    }
    
    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		if (IguanaConfig.addFoodTooltips == true) {
	    	int hungerFill = this.getHealAmount();
	    	float satiation = (this.getSaturationModifier() * 20) - (float) hungerFill;
	    	
	    	String tooltip = "";
	    	
	    	if (satiation  >= 3.0F) {
	    		tooltip += "hearty "; 
	    	} else if (satiation  >= 2.0F) {
	    		tooltip += "wholesome ";
	    	} else if (satiation  > 0.0F) {
	    		tooltip += "nourishing ";
	    	} else if (satiation < 0.0F) {
	    		tooltip += "unfulfilling "; 
	    	} 
	    	
	    	if (hungerFill <= 1) {
	        	tooltip += "morsel";
	    	} else if (hungerFill <= 2) {
	        	tooltip += "snack";
	    	} else if (hungerFill <= 5) {
	        	tooltip += "light meal";
	    	} else if (hungerFill <= 8) {
	        	tooltip += "meal";
	    	} else if (hungerFill <= 11) {
	        	tooltip += "large meal";
	    	} else  {
	        	tooltip += "feast";
	    	}
	    	
	    	par3List.add(tooltip.substring(0, 1).toUpperCase() + tooltip.substring(1));

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
		}
    }

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
    
    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    /*
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
