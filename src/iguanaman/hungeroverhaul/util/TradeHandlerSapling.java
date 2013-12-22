package iguanaman.hungeroverhaul.util;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class TradeHandlerSapling implements IVillageTradeHandler {

	final int objectID;


	protected TradeHandlerSapling(int par1) {
		objectID = par1;
	}


	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 1), new ItemStack(objectID, 1, 0)));
	}

}