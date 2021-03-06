package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.tileentity.TileEntitySeaStoneFurnace;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChestFull;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TLSTileEntities {
	
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySeaStoneFurnace.class, new ResourceLocation(Reference.MOD_ID + ":seastone_furnace"));
		GameRegistry.registerTileEntity(TileEntityStarterChestFull.class, new ResourceLocation(Reference.MOD_ID + ":starter_chest_full"));
		GameRegistry.registerTileEntity(TileEntityStarterChest.class, new ResourceLocation(Reference.MOD_ID + ":starter_chest"));
	}
}
