package com.SmellyModder.TheLostSea.core.api.capabilites;

import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IWorldHolder {
	public static final WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);
}
