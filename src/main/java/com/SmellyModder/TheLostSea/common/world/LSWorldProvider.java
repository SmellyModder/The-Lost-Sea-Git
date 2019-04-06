package com.SmellyModder.TheLostSea.common.world;

import com.SmellyModder.TheLostSea.common.init.DimensionInit;
import com.SmellyModder.TheLostSea.common.init.TLSBiomes;
import com.SmellyModder.TheLostSea.common.world.gen.chunk.ChunkGenLS;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class LSWorldProvider extends WorldProvider {
	
	protected void init() {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderSingle(TLSBiomes.TROPICAL_ISLAND);
    }
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionInit.LS;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		//super.createChunkGenerator();
		return new ChunkGenLS(world, true, world.getSeed());
	}
	
	@Override
	public String getSaveFolder() {
		return Reference.MOD_ID + "lost_sea_dim";
	}
	
	@Override
	protected void generateLightBrightnessTable() {
        float f = 0.0F;
        	
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 1.0F + 1.2F;
        }
    }
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

}
