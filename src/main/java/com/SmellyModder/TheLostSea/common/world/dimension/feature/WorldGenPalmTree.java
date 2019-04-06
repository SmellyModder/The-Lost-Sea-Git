package com.SmellyModder.TheLostSea.common.world.dimension.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.bases.BlockAdvancedLeaves;
import com.SmellyModder.TheLostSea.common.blocks.plants.BlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenPalmTree extends WorldGenAbstractLSTree {
	protected static final IBlockState WOOD = TLSBlocks.PALM_LOG.getDefaultState();
	protected static final IBlockState BARK = TLSBlocks.PALM_BARK.getDefaultState();
	protected static final IBlockState LEAVES = TLSBlocks.PALM_LEAVES.getDefaultState();
	protected static final IBlockState LEAVES_3X = TLSBlocks.PALM_LEAVES_X.getDefaultState();
	protected static final IBlockState LEAVES_3X_UP = TLSBlocks.PALM_LEAVES_U.getDefaultState();
	protected static final IBlockState LEAVES_3X_DOWN = TLSBlocks.PALM_LEAVES_D.getDefaultState();
	
	public WorldGenPalmTree(boolean notify) {
		super(notify);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = rand.nextInt(4) + 8;
		
		boolean flag = true;
		
		if(pos.getY() >= 1 && pos.getY() + height + 1 <= 256) {
			
			for (int j = pos.getY(); j <= pos.getY() + 1 + height; ++j) {
                int k = 1;

                if (j == pos.getY()) {
                    k = 0;
                }

                if (j >= pos.getY() + 1 + height - 2) {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < world.getHeight())
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
			
			if(!flag) {
				return false;
			} else {
				BlockPos down = pos.down();
	            IBlockState state = world.getBlockState(down);
	            boolean isSoil = state.getBlock().canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING);
	             
	            if (isSoil && pos.getY() < world.getHeight() - height - 1) {
	            	 
	            	 for (int j2 = 0; j2 < height; ++j2) {
	            		 
	                    BlockPos upN = pos.up(j2);
	                    IBlockState state2 = world.getBlockState(upN);

	                    if (state2.getBlock().isAir(state2, world, upN) || state2.getBlock().isLeaves(state2, world, upN)) {
	                       this.setBlockAndNotifyAdequately(world, pos.up(j2), WOOD);
	                       if(j2 == height - 1) {
	                    	   	this.createPalmTop(world, upN, 0);
	                       }
	                    }
	                 }
	            	 
	            	 return true;
	            } else {
	            	return false;
	            }
			}
		} else {
			return false;
		}
	}
	
	protected void createPalmTop(World world, BlockPos pos, int direction) {
		int palmType = world.rand.nextInt(100);
		if(palmType > 50 && palmType < 90) {
			createPalmLeavesBase(world, pos, LEAVES, WOOD, 0);
		} else if(palmType < 50 && palmType > 10) {
			createPalmLeavesBase(world, pos, LEAVES, WOOD, 1);
		} else {
			createPalmLeavesBase(world, pos, LEAVES, WOOD, 2);
		}
		if(direction != 3) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).north(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.SOUTH).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
		}
		if(direction != 2) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).south(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.NORTH).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
		}
		if(direction != 4) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).east(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.WEST).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
		}
		if(direction != 5) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).west(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.EAST).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
		}
	}
	
	/*
	 * A method used to access the different leave generations for palm variants
	 * @param {int} palmType - The value used to determine the palm tree's leave generation type, goes from 0-2
	 * For more detail on the palmType variants, 0 = Basic, 1 = Bigger/Flowery looking palm leave shape, 2 = A longer hanging leaf version of 1
	 */
	protected void createPalmLeavesBase(World world, BlockPos pos, IBlockState block, IBlockState wood, int palmType) {
		if(palmType == 0) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(1, 0, 0), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(-1, 0, 0), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(0, 0, 1), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(0, 0, -1), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).north(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).south(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).west(), block);
					
			this.fillWithBlocks(world, createStartPos(pos).down(), -1, 0, -1, 1, 0, 1, block, block, false);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(), wood);
			
			this.setBlockAndNotifyAdequately(world, pos.north(2), block);
			this.setBlockAndNotifyAdequately(world, pos.north(3), block);
			this.setBlockAndNotifyAdequately(world, pos.down(1).north(4), LEAVES_3X_UP);
			
			this.setBlockAndNotifyAdequately(world, pos.south(2), block);
			this.setBlockAndNotifyAdequately(world, pos.south(3), block);
			this.setBlockAndNotifyAdequately(world, pos.down(1).south(4), LEAVES_3X_UP);
			
			this.setBlockAndNotifyAdequately(world, pos.west(2), block);
			this.setBlockAndNotifyAdequately(world, pos.west(3), block);
			this.setBlockAndNotifyAdequately(world, pos.down(1).west(4), LEAVES_3X_UP);
			
			this.setBlockAndNotifyAdequately(world, pos.east(2), block);
			this.setBlockAndNotifyAdequately(world, pos.east(3), block);
			this.setBlockAndNotifyAdequately(world, pos.down(1).east(4), LEAVES_3X_UP);
			
			if(world.rand.nextInt(2) == 1) {
				this.setBlockAndNotifyAdequately(world, pos.north(2).west(2).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.north(2).east(2).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(2).west(2).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(2).east(2).down(), LEAVES_3X_UP);
			} else {
				this.setBlockAndNotifyAdequately(world, pos.north(2).west(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.north(2).east(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.south(2).west(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.south(2).east(2), LEAVES_3X);
				
				this.setBlockAndNotifyAdequately(world, pos.north(3).west(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.north(3).east(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(3).west(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(3).east(3).down(), LEAVES_3X_UP);
			}
		} else if(palmType == 1) {
			//Topest part
			this.fillWithBlocks(world, createStartPos(pos).down(), -1, 0, -1, 1, 0, 1, block, block, false);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).north(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).south(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).west(), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south().west(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south().east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north().west(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north().east(), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(2), block);
			
			//Leave Branches
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3), LEAVES_3X_DOWN);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(4), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(5).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3), LEAVES_3X_DOWN);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(4), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(5).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(3), LEAVES_3X_DOWN);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(4), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(5).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(3), LEAVES_3X_DOWN);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(4), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(5).down(), LEAVES_3X_UP);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).east(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).east(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).east(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).east(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).west(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).west(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).west(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).west(3).down(), LEAVES_3X_UP);
			
			if(world.rand.nextInt(2) == 1) {
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).north(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).south(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).east(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).west(2), LEAVES_3X_UP);
			}
		} else if(palmType == 2) {
			//Base part
			this.fillWithBlocks(world, createStartPos(pos).down(), -1, 0, -1, 1, 0, 1, block, block, false);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).north(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).south(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).west(), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south().west(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south().east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north().west(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north().east(), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(2).down(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(2), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(2), block);
			
			//Diagonal Leave Branches
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).east(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).east(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).east(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).east(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).east(3).down(2), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).east(3).down(2), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(2).west(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(2).west(2), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).west(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).west(3).down(), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3).west(3).down(2), LEAVES_3X_UP);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3).west(3).down(2), LEAVES_3X_UP);
			
			//Hanging Leave Branches
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(3), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(3), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(3), LEAVES_3X);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(3), LEAVES_3X);
			for(int i = 1; i <= 2; i++) {
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).north(4).down(i), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).east(4).down(i), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).south(4).down(i), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).west(4).down(i), LEAVES_3X_UP);
			}
			if(world.rand.nextInt(2) == 1) {
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).north(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).south(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).east(2), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).west(2), LEAVES_3X_UP);
			}
		}
	}
}
