package com.SmellyModder.TheLostSea.common.world.biome.layer;

import com.SmellyModder.TheLostSea.common.init.TLSBiomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTropicalShore extends GenLayer {
	
	private static final int BEACH = Biome.getIdForBiome(Biomes.BEACH);
    private static final int TROPICAL_ISLAND = Biome.getIdForBiome(TLSBiomes.TROPICAL_ISLAND);
    private static final int TROPICAL_ISLAND_BEACH = Biome.getIdForBiome(TLSBiomes.TROPICAL_BEACH);

    public GenLayerTropicalShore(long seed, GenLayer parent) {
        super(seed);
        this.parent = parent;
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int parentWidth = areaWidth + 2;
        int parentHeight = areaHeight + 2;

        int[] parent = this.parent.getInts(areaX - 1, areaY - 1, parentWidth, parentHeight);
        int[] result = IntCache.getIntCache(areaWidth * areaHeight);

        for (int localY = 0; localY < areaHeight; ++localY) {
            for (int localX = 0; localX < areaWidth; ++localX) {
                this.initChunkSeed((long) (localX + areaX), (long) (localY + areaY));

                int parentX = localX + 1;
                int parentY = localY + 1;
                int sampled = parent[parentX + parentY * parentWidth];

                if (sampled == BEACH) {
                    int up = parent[parentX + (parentY - 1) * parentWidth];
                    int right = parent[parentX + 1 + parentY * parentWidth];
                    int left = parent[parentX - 1 + parentY * parentWidth];
                    int down = parent[parentX + (parentY + 1) * parentWidth];

                    if (up == TROPICAL_ISLAND || down == TROPICAL_ISLAND || right == TROPICAL_ISLAND || left == TROPICAL_ISLAND) {
                        result[localX + localY * areaWidth] = TROPICAL_ISLAND_BEACH;
                    } else {
                        result[localX + localY * areaWidth] = sampled;
                    }
                } else {
                    result[localX + localY * areaWidth] = sampled;
                }
            }
        }

        return result;
    }

}
