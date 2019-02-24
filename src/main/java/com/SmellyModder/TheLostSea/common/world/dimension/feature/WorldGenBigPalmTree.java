package com.SmellyModder.TheLostSea.common.world.dimension.feature;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenBigPalmTree extends WorldGenPalmTree {

	public WorldGenBigPalmTree(boolean notify) {
		super(notify);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = rand.nextInt(4) + 9;
		boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256)
        {
            for (int j = pos.getY(); j <= pos.getY() + 1 + height; ++j)
            {
                int k = 1;

                if (j == pos.getY())
                {
                    k = 0;
                }

                if (j >= pos.getY() + 1 + height - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(world, blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }
            
            if(flag) 
            {
            	return false;
            }
            else 
            {
            	return true;
            }
        }
        else 
        {
        	return false;
        }
	}
	
}
