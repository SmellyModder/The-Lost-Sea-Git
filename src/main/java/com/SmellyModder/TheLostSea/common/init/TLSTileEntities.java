package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.tileentity.TileEntitySeaStoneFurnace;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TLSTileEntities {
	
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySeaStoneFurnace.class, new ResourceLocation(Reference.MOD_ID + ":seastone_furnace"));
	}
}
