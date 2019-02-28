package com.SmellyModder.TheLostSea.common.world.dimension.feature;

import java.util.Random;

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

	int dir;
	public WorldGenCurvedPalmTree(boolean notify, int dir) {
		super(notify);
		this.dir = dir;
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
			
			if(!flag) 
			{
				return false;
			}
            else 
            {
            	BlockPos down = pos.down();
                IBlockState state = world.getBlockState(down);
                boolean isSoil = state.getBlock().canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP, ((net.minecraft.block.BlockSapling)Blocks.SAPLING)) || state.getBlock() == Blocks.SAND.getDefaultState();
                
            	if(isSoil && pos.getY() < world.getHeight() - height - 1) {
            		state.getBlock().onPlantGrow(state, world, down, pos);
                    
                    BlockPos sPos = pos;
                    
                    int dir = this.pickDirection(world, pos, this.dir);
                    
                    if (dir == 1)
	                {
                    	this.setBlockAndNotifyAdequately(world, pos, WOOD);
                    	this.setBlockAndNotifyAdequately(world, pos.south(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z));
                    	this.setBlockAndNotifyAdequately(world, pos.west(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X));
                    	this.createCurvedPalmWithDirection(world, pos, dir);
	                }
                    else if(dir == 2) {
                    	this.setBlockAndNotifyAdequately(world, pos, WOOD);
                    	this.setBlockAndNotifyAdequately(world, pos.east(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X));
                    	this.setBlockAndNotifyAdequately(world, pos.north(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z));
                    	this.createCurvedPalmWithDirection(world, pos, dir);
                    }
                    else if(dir == 3) {
                    	this.setBlockAndNotifyAdequately(world, pos, WOOD);
                    	this.setBlockAndNotifyAdequately(world, pos.west(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X));
                    	this.setBlockAndNotifyAdequately(world, pos.north(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z));
                    	this.createCurvedPalmWithDirection(world, pos, dir);
                    } else if(dir == 4){
                    	this.setBlockAndNotifyAdequately(world, pos, WOOD);
                    	this.setBlockAndNotifyAdequately(world, pos.east(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X));
                    	this.setBlockAndNotifyAdequately(world, pos.south(), WOOD.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z));
                    	this.createCurvedPalmWithDirection(world, pos, dir);
                    } else {
                    	this.setBlockAndNotifyAdequately(world, pos, WOOD);
                    	this.createCurvedPalmWithDirection(world, pos, dir);
                    }
            	}
                return true;
            }
        }
        else
        {
        	return false;
        }
	}
	
	private boolean canGrowInto(IBlockState state) {
		return state.getMaterial() == Material.AIR || state.getMaterial() == Material.WOOD;
	}
	
	private void createCurvedPalmWithDirection(World world, BlockPos pos, int dir) {
		
		int heightFBranch = world.rand.nextInt(3) + 2;
		int heightSBranch = world.rand.nextInt(3) + 2;
		int heightTBranch = world.rand.nextInt(3) + 2;
		int heightMBranch = world.rand.nextInt(1) + 2;
		
		if(dir == 4) {
			for(int i = 0; i < heightFBranch; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightSBranch; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(i2).south(), WOOD);
			}
			for(int i3 = 0; i3 < heightTBranch; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(i3).south(2), WOOD);
			}
			for(int i4 = 0; i4 < heightMBranch; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(i4).south(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(heightMBranch).south(3), 1);
		} else if(dir == 3) {
			for(int i = 0; i < heightFBranch; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightSBranch; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(i2).east(), WOOD);
			}
			for(int i3 = 0; i3 < heightTBranch; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(i3).east(2), WOOD);
			}
			for(int i4 = 0; i4 < heightMBranch; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(i4).east(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(heightMBranch).east(3), 1);
		} else if(dir == 2) {
			for(int i = 0; i < heightFBranch; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightSBranch; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(i2).south(), WOOD);
			}
			for(int i3 = 0; i3 < heightTBranch; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(i3).south(2), WOOD);
			}
			for(int i4 = 0; i4 < heightMBranch; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(i4).south(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(heightMBranch).south(3), 1);
		} else if(dir == 1) {
			for(int i = 0; i < heightFBranch; i++) {
				this.setBlockAndNotifyAdequately(world, pos.up(i), WOOD);
			}
			for(int i2 = 0; i2 < heightSBranch; i2++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(i2).east(), WOOD);
			}
			for(int i3 = 0; i3 < heightTBranch; i3++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(i3).east(2), WOOD);
			}
			for(int i4 = 0; i4 < heightMBranch; i4++) {
				this.setBlockAndNotifyAdequately(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(i4).east(3), WOOD);
			}
			this.createPalmTop(world, pos.up(heightFBranch).up(heightSBranch).up(heightTBranch).up(heightMBranch).east(3), 1);
		} else {
			this.createCurvedPalmWithDirection(world, pos, world.rand.nextInt(4));
		}
	}
	
	private int pickDirection(World world, BlockPos pos, int direction) {
		BlockPos sPos = pos;
        IBlockState stateS = world.getBlockState(sPos.south());
        IBlockState stateW = world.getBlockState(sPos.west());
        IBlockState stateE = world.getBlockState(sPos.east());
        IBlockState stateN = world.getBlockState(sPos.north());
        
        int dir = direction;
        
        if(dir == 1) {
        	if (canGrowInto(stateS) && canGrowInto(stateW)) {
        		return 1;
            } else {
            	dir = 0;
            }
        } else if(dir == 2) {
        	if(canGrowInto(stateE) && canGrowInto(stateN)) {
            	return 2;
            } else {
            	dir = 0;
            }
        } else if(dir == 3) {
        	if(canGrowInto(stateW) && canGrowInto(stateN)) {
            	return 3;
            } else {
            	dir = 0;
            }
        }
        else if(dir == 4) {
        	if(canGrowInto(stateE) && canGrowInto(stateS)) {
            	return 4;
            } else {
            	dir = 0;
            }
        } else {
        	return 0;
        }
        return 0;
	}
	
}
