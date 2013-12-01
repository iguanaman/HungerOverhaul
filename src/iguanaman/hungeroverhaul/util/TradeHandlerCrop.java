package iguanaman.hungeroverhaul.util;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

import java.util.Random;

public class TradeHandlerCrop implements IVillageTradeHandler {
	
	final int itemID;

    
    protected TradeHandlerCrop(int par1) {
		itemID = par1;
	}
	

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(this.itemID, 16, 0), new ItemStack(Item.emerald, 1)));
	}

}