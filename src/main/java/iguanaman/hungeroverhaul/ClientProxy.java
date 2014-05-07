package iguanaman.hungeroverhaul;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerLocalization() {
		LanguageRegistry.instance().addStringLocalization("potion.wellfedPotion", "Well Fed");
		LanguageRegistry.instance().addStringLocalization("potion.newSlowdownPotionHO", "Slowed");
	}

}