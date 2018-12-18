package com.SmellyModder.TheLostSea.common.init;


import com.SmellyModder.TheLostSea.common.biome.BiomeLostSea;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary.Type;

public class TLSBiomes {

public static final Biome LOST_SEA = new BiomeLostSea();


public static void registerBiomes() {

	initBiome(LOST_SEA, "Lost_Sea", BiomeType.WARM, Type.MAGICAL, Type.FOREST);
}

public static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types)
{
	biome.setRegistryName(name);
	ForgeRegistries.BIOMES.register(biome);
	BiomeDictionary.addTypes(biome, types);
	BiomeManager.addSpawnBiome(biome);
	return biome;
}


private static Biome addBiome(Biome biome) {
    BiomeManager.addSpawnBiome(biome);
    return biome;
}

}
