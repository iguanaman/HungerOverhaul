package iguanaman.hungeroverhaul.blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IguanaCropVegetable extends IguanaCrop {

	public IguanaCropVegetable(int par1, String veg) {
		super(par1, veg);
	}


	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2)
	{
		if (par2 < 7)
		{
			if (par2 == 6) par2 = 5;
			return iconArray[par2 >> 1];
		} else
			return iconArray[3];
	}

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		iconArray = new Icon[4];

		for (int i = 0; i < iconArray.length; ++i)
			iconArray[i] = par1IconRegister.registerIcon(getTextureName() + "_stage_" + i);
	}
}
