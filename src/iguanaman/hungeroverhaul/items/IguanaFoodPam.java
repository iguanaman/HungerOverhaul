package iguanaman.hungeroverhaul.items;

import net.minecraft.client.renderer.texture.IconRegister;
import assets.pamharvestcraft.PamHarvestCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaFoodPam extends IguanaFood {

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4) {
		this(par1, par2, par3, par4, false);
	}

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4, boolean integrate) {
		super(par1, par2, par3, par4, integrate);
		setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir)
	{
		itemIcon = ir.registerIcon(this.getUnlocalizedName().substring(5));
	}
}
