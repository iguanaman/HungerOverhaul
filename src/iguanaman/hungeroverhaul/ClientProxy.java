package iguanaman.hungeroverhaul;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    
    public void registerLocalization() {
    	LanguageRegistry.instance().addStringLocalization("potion.wellfedPotion", "Well Fed");
    	LanguageRegistry.instance().addStringLocalization("potion.newSlowdownPotionHO", "Slowed");
    }
       
}