package com.SmellyModder.TheLostSea.client.lighting;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ILightProvider {

	@SideOnly(Side.CLIENT)
	public BasicLight provideLight();
}
