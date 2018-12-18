package com.SmellyModder.TheLostSea.common.world;

import com.SmellyModder.TheLostSea.common.init.DimensionInit;
import com.SmellyModder.TheLostSea.common.init.TLSBiomes;
import com.SmellyModder.TheLostSea.common.world.gen.chunk.ChunkGenLS;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class LSWorldProvider extends WorldProvider
{
	public LSWorldProvider()
	{
		this.biomeProvider = new BiomeProviderSingle(TLSBiomes.LOST_SEA);
	}
	
	@Override
	public DimensionType getDimensionType() 
	{
		return DimensionInit.LS;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new ChunkGenLS(world, true, world.getSeed());
	}
	
	@Override
	public boolean canRespawnHere() 
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() 
	{
		return false;
	}

}
