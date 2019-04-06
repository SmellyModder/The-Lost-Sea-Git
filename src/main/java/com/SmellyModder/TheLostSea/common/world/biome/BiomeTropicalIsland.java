package com.SmellyModder.TheLostSea.common.world.biome;

import java.util.ArrayList;
import java.util.Random;

import com.SmellyModder.TheLostSea.common.world.dimension.feature.WorldGenCurvedPalmTree;
import com.SmellyModder.TheLostSea.common.world.dimension.feature.WorldGenPalmTree;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeTropicalIsland extends Biome {

	public BiomeTropicalIsland() {
		super(new BiomeProperties("tropical_island")
				.setTemperature(0.7F)
				.setRainfall(0.1F)
				.setBaseHeight(0.10f)
				.setHeightVariation(0.24f)
				.setWaterColor(3133951));
		
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock =  Blocks.DIRT.getDefaultState();
	    
		this.decorator.treesPerChunk = 5;
		this.decorator.flowersPerChunk = 4;
		this.decorator.grassPerChunk = 20;
		this.decorator.mushroomsPerChunk = 5;
		this.decorator.sandPatchesPerChunk = 2;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) 
	{
		if(rand.nextInt(2) == 0) {
			return new WorldGenPalmTree(false);
		} else if(rand.nextInt(2) == 1) {
			return new WorldGenPalmTree(false);
		} else {
			return new WorldGenCurvedPalmTree(false);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2211335;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 2211335;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getSkyColorByTemp(float currentTemperature) {
		return 0x66ccff;
	}

}
