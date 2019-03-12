package com.SmellyModder.TheLostSea.common.world.dimension.feature;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.plants.BlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenAbstractLSTree extends WorldGenAbstractTree{

	public WorldGenAbstractLSTree(boolean notify) {
		super(notify);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		return false;
	}
	
	protected boolean canGrowInto(Block blockType)
    {
        Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;
    }
	
	protected void fillWithBlocks(World worldIn, BlockPos pos, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, IBlockState boundaryBlockState, IBlockState insideBlockState, boolean existingOnly)
    {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
        for (int i = yMin; i <= yMax; ++i)
        {
            for (int j = xMin; j <= xMax; ++j)
            {
                for (int k = zMin; k <= zMax; ++k)
                {
                    if (!existingOnly || this.isReplaceable(worldIn, new BlockPos(x + j, y + i, z + k)));
                    {
                        if (i != yMin && i != yMax && j != xMin && j != xMax && k != zMin && k != zMax)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, new BlockPos(x + j, y + i, z + k), boundaryBlockState);
                        }
                        else
                        {
                        	this.setBlockAndNotifyAdequately(worldIn, new BlockPos(x + j, y + i, z + k), insideBlockState);
                        }
                    }
                }
            }
        }
    }
	
	public BlockPos createStartPos(BlockPos pos) {
		return new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
	}

}
