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
	protected void generateLightBrightnessTable()
    {
        float f = 0.0F;
        	
        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 1.0F + 1.2F;
        }
    }
	
	@Override
	public boolean isSurfaceWorld() 
	{
		return false;
	}

}
