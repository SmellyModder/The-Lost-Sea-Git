package com.SmellyModder.TheLostSea.common.init.client;

import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestFullRenderer;
import com.SmellyModder.TheLostSea.client.render.tile.TileEntityStarterChestRenderer;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRenders {
	
	public static void register() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStarterChestFull.class, new TileEntityStarterChestFullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStarterChest.class, new TileEntityStarterChestRenderer());
	}
}
