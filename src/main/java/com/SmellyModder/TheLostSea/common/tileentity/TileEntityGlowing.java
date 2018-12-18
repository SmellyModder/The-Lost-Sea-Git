package com.SmellyModder.TheLostSea.common.tileentity;

import com.SmellyModder.TheLostSea.client.lighting.BasicLight;
import com.SmellyModder.TheLostSea.client.lighting.ILightProvider;

import net.minecraft.tileentity.TileEntity;

public class TileEntityGlowing extends TileEntity implements ILightProvider{

	public TileEntityGlowing() {}
	
	@Override
	public BasicLight provideLight() {
		return null;
	}
}
