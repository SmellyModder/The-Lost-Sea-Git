package com.SmellyModder.TheLostSea.common.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * TESTS
 */
public class BiomeTropicalBeach extends Biome {

	public BiomeTropicalBeach() {
		super(new BiomeProperties("Galapagos_Beach")
				.setTemperature(0.7F)
				.setRainfall(0.1F)
				.setBaseHeight(0.06f)
				.setHeightVariation(0f)
				.setWaterColor(3133951));
		
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.SAND.getDefaultState();
		this.fillerBlock =  Blocks.SANDSTONE.getDefaultState();
	      
	    this.decorator.treesPerChunk = -999;
	    this.decorator.deadBushPerChunk = 0;
	    this.decorator.reedsPerChunk = 0;
	    this.decorator.cactiPerChunk = 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 2948896;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 2948896;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getSkyColorByTemp(float currentTemperature) {
		return 0x66ccff;
	}
	
}
