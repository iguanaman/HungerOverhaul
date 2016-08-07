package iguanaman.hungeroverhaul.util;

import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientHelper
{
    public static void sendRightClickPacket(int x, int y, int z, int side, ItemStack currentItem, float hitX, float hitY, float hitZ)
    {
        FMLClientHandler.instance().getClientPlayerEntity().sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(x, y, z, side, currentItem, hitX, hitY, hitZ));
    }
}
