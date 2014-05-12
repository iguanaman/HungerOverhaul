package iguanaman.hungeroverhaul.items;

import com.pam.harvestcraft.harvestcraft;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaFoodPam extends IguanaFood {

	public IguanaFoodPam(int par2, float par3, boolean par4) {
		this(par2, par3, par4, false);
	}

	public IguanaFoodPam(int par2, float par3, boolean par4, boolean integrate) {
		super(par2, par3, par4, integrate);
		setCreativeTab(harvestcraft.tabHarvestCraft);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		itemIcon = ir.registerIcon(this.getUnlocalizedName().substring(5));
	}
}
