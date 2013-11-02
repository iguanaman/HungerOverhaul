package iguanaman.hungeroverhaul.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

import java.util.Random;

public class TradeHandlerFood implements IVillageTradeHandler {
	
	final int itemID;
	final int tradeValue;

    
    public TradeHandlerFood(int par1, int par2) {
		itemID = par1;
		tradeValue = par2;
	}
	

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 1), new ItemStack(this.itemID, tradeValue, 0)));
		
	}

}