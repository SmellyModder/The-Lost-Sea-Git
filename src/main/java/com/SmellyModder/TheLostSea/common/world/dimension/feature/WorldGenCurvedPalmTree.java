package com.SmellyModder.TheLostSea.common.world.dimension.feature;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.plants.BlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenCurvedPalmTree extends WorldGenPalmTree {

	public WorldGenCurvedPalmTree(boolean notify) {
		super(notify);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = rand.nextInt(4) + 9;
		boolean flag = true;

		if(pos.getY() >= 1 && pos.getY() + height + 1 <= 256) {
			
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
                boolean isSoil = state.getBlock().canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP, ((net.minecraft.block.BlockSapling)Blocks.SAPLING)) || state.getBlock() == Blocks.SAND.getDefaultState();
                
            	if(isSoil && pos.getY() < world.getHeight() - height - 1) {
            		state.getBlock().onPlantGrow(state, world, down, pos);
                    EnumFacing direction = EnumFacing.random(world.rand);
                    
                    if(direction == EnumFacing.UP || direction == EnumFacing.DOWN) {
                    	direction = rand.nextInt(2) == 1 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                    }
                    
                    // 2 - North, 3 - South, 4 - West, 5 - East
                    if (direction.getIndex() == 2) {
                    	this.createCurvedPalmWithDirection(world, pos, 2);
                    	this.generatePalmRoots(world, pos, 2);
	                }
                    else if(direction.getIndex() == 3) {
                    	this.createCurvedPalmWithDirection(world, pos, 3);
                    	this.generatePalmRoots(world, pos, 3);
                    }
	                else if(direction.getIndex() == 4) {
                    	this.createCurvedPalmWithDirection(world, pos, 4);
                    	this.generatePalmRoots(world, pos, 4);
                    }
                    else if(direction.getIndex() == 5) {
                    	this.createCurvedPalmWithDirection(world, pos, 5);
                    	this.generatePalmRoots(world, pos, 5);
                    }
            	}
                return true;
            }
        } else {
        	return false;
        }
	}
	
	private boolean canGrowInto(IBlockState state) {
		return state.getMaterial() == Material.AIR || state.getMaterial() == Material.WOOD;
	}
	
	private void createCurvedPalmWithDirection(World world, BlockPos pos, int dir) {
		int[] heightForBranch = {world.rand.nextInt(3) + 2, world.rand.nextInt(3) + 2, world.rand.nextInt(3) + 2, world.rand.nextInt(1) + 2};
		
		if(dir == 5) {
			for(int i = 0; i < heightForBranch[0]; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightForBranch[1]; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(i2).east(), WOOD);
			}
			for(int i3 = 0; i3 < heightForBranch[2]; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(i3).east(2), WOOD);
			}
			for(int i4 = 0; i4 < heightForBranch[3]; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(i4).east(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(heightForBranch[3]).east(3), 5);
		} else if(dir == 4) {
			for(int i = 0; i < heightForBranch[0]; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightForBranch[1]; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(i2).west(), WOOD);
			}
			for(int i3 = 0; i3 < heightForBranch[2]; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(i3).west(2), WOOD);
			}
			for(int i4 = 0; i4 < heightForBranch[3]; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(i4).west(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(heightForBranch[3]).west(3), 4);
		} else if(dir == 2) {
			for(int i = 0; i < heightForBranch[0]; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightForBranch[1]; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(i2).north(), WOOD);
			}
			for(int i3 = 0; i3 < heightForBranch[2]; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(i3).north(2), WOOD);
			}
			for(int i4 = 0; i4 < heightForBranch[3]; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(i4).north(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(heightForBranch[3]).north(3), 2);
		} else if(dir == 3) {
			for(int i = 0; i < heightForBranch[0]; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightForBranch[1]; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(i2).south(), WOOD);
			}
			for(int i3 = 0; i3 < heightForBranch[2]; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(i3).south(2), WOOD);
			}
			for(int i4 = 0; i4 < heightForBranch[3]; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(i4).south(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightForBranch[0]).up(heightForBranch[1]).up(heightForBranch[2]).up(heightForBranch[3]).south(3), 3);
		}
	}
	
	private void generatePalmRoots(World world, BlockPos pos, int direction) {
        IBlockState[] directionState = {
        	world.getBlockState(pos.north()), 
        	world.getBlockState(pos.south()), 
        	world.getBlockState(pos.west()), 						
        	world.getBlockState(pos.east())
        };
        Random rand = world.rand;
        if(rand.nextInt(3) != 0) return;
        
        if(direction == 2) {
        	if(canGrowInto(directionState[1])) {
        		if(canGrowInto(directionState[3])) {
        			this.setBlockAndNotifyAdequately(world, pos.east(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.south(), BARK);
        		} else if(canGrowInto(directionState[2])) {
        			this.setBlockAndNotifyAdequately(world, pos.west(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.south(), BARK);
        		} else { return; }
        	} else { return; }
        } else if(direction == 3) {
        	if(canGrowInto(directionState[0])) {
        		if(canGrowInto(directionState[3])) {
        			this.setBlockAndNotifyAdequately(world, pos.east(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.north(), BARK);
        		} else if(canGrowInto(directionState[2])){
        			this.setBlockAndNotifyAdequately(world, pos.west(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.north(), BARK);
        		} else { return; }
        	} else { return; }
        } else if(direction == 4) {
        	if(canGrowInto(directionState[3])) {
        		if(canGrowInto(directionState[0])) {
        			this.setBlockAndNotifyAdequately(world, pos.north(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.east(), BARK);
        		} else if(canGrowInto(directionState[1])){
        			this.setBlockAndNotifyAdequately(world, pos.south(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.east(), BARK);
        		} else { return; }
        	} else { return; }
        } else if(direction == 5) {
        	if(canGrowInto(directionState[2])) {
        		if(canGrowInto(directionState[0])) {
        			this.setBlockAndNotifyAdequately(world, pos.north(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.west(), BARK);
        		} else if(canGrowInto(directionState[1])){
        			this.setBlockAndNotifyAdequately(world, pos.south(), BARK);
        			this.setBlockAndNotifyAdequately(world, pos.west(), BARK);
        		} else { return; }
        	} else { return; }
        }
	}
}
