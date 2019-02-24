package com.SmellyModder.TheLostSea.common.world.biome.layer;

import com.SmellyModder.TheLostSea.common.init.TLSBiomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTropicalIsland extends GenLayer {
	   private static final int CHANCE = 20;

	   public GenLayerTropicalIsland(long seed, GenLayer parent) {
	       super(seed);
	       this.parent = parent;
	   }

	   @Override
	   public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
	       int outerWidth = areaWidth + 2;

	       int[] biomeIds = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
	       int[] out = IntCache.getIntCache(areaWidth * areaHeight);

	       for (int z = 0; z < areaHeight; ++z) {
	           for (int x = 0; x < areaWidth; ++x) {
	               int centerVal = biomeIds[x + 1 + (z + 1) * outerWidth];

	               this.initChunkSeed((long) (x + areaX), (long) (z + areaY));

	               if (isSurroundedByOcean(x, z, biomeIds, outerWidth) && isBiomeOceanic(centerVal) && this.nextInt(CHANCE) == 0) {
	                   out[x + z * areaWidth] = Biome.getIdForBiome(TLSBiomes.TROPICAL_ISLAND);
	               } else {
	                   out[x + z * areaWidth] = centerVal;
	               }
	           }
	       }

	       return out;
	   }

	   private boolean isSurroundedByOcean(int x, int z, int[] biomeIds, int outerWidth) {
	       return isBiomeOceanic(biomeIds[x + 1 + (z + 1 - 1) * outerWidth])
	               && isBiomeOceanic(biomeIds[x + 1 + 1 + (z + 1) * outerWidth])
	               && isBiomeOceanic(biomeIds[x + 1 - 1 + (z + 1) * outerWidth])
	               && isBiomeOceanic(biomeIds[x + 1 + (z + 1 + 1) * outerWidth]);
	   }

}
