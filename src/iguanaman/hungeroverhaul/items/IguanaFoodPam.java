package iguanaman.hungeroverhaul.items;

import assets.pamharvestcraft.PamHarvestCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaFoodPam extends IguanaFood {

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4,
			boolean integrate, boolean isJuicy, boolean isSeedy) {
		super(par1, par2, par3, par4, integrate, isJuicy, isSeedy);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4,
			boolean integrate) {
		super(par1, par2, par3, par4, integrate);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	public IguanaFoodPam(int par1, int par2, float par3, boolean par4,
			boolean integrate, boolean isJuicy) {
		super(par1, par2, par3, par4, integrate, isJuicy);
		this.setCreativeTab(PamHarvestCraft.tabHarvestCraft);
	}

	@Override
	   @SideOnly(Side.CLIENT)
	 	public void registerIcons(IconRegister ir)
	 	{
		   this.itemIcon = ir.registerIcon((this.getUnlocalizedName().substring(5)));
	 	}
}
