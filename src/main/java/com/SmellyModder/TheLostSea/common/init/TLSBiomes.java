package com.SmellyModder.TheLostSea.common.init;



import com.SmellyModder.TheLostSea.common.world.biome.BiomeTropicalBeach;
import com.SmellyModder.TheLostSea.common.world.biome.BiomeTropicalIsland;

import net.minecraft.command.CommandLocate;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary.Type;

public class TLSBiomes {

	public static final Biome TROPICAL_BEACH = new BiomeTropicalBeach();
	public static final Biome TROPICAL_ISLAND = new BiomeTropicalIsland();

	public static void registerBiomes() {
		initBiome(TROPICAL_BEACH, "tropical_beach", BiomeType.WARM, Type.JUNGLE, Type.BEACH);
		initBiome(TROPICAL_ISLAND, "tropical_island", BiomeType.WARM, Type.JUNGLE, Type.BEACH);
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
