package com.SmellyModder.TheLostSea.common.biome;

import net.minecraft.world.biome.Biome;

public class BiomeLostSea extends Biome{
	public BiomeLostSea()
    {
		super(new BiomeProperties("Lost Sea").setTemperature(0.8F).setRainfall(0.8F));
        this.spawnableCreatureList.clear();
    }

    public Biome.TempCategory getTempCategory()
    {
        return Biome.TempCategory.OCEAN;
    }

}
