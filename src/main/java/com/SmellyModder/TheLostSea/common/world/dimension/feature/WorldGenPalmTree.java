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
	             boolean isSoil = state.getBlock().canSustainPlant(state, world, down, net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING);
	             
	             if (isSoil && pos.getY() < world.getHeight() - height - 1)
	             {
	            	 for (int j2 = 0; j2 < height; ++j2)
	                 {
	                     BlockPos upN = pos.up(j2);
	                     IBlockState state2 = world.getBlockState(upN);

	                     if (state2.getBlock().isAir(state2, world, upN) || state2.getBlock().isLeaves(state2, world, upN))
	                     {
	                        this.setBlockAndNotifyAdequately(world, pos.up(j2), WOOD);
	                        if(j2 == height - 1) {
	                        	this.createPalmTop(world, upN, rand.nextInt(3));
	                        }
	                     }
	                 }
	            	 
	            	 return true;
	             }
	             else
	             {
	            	 return false;
	             }
			}
		}
		else {
			return false;
		}
	}
	
	/*
	 * This all testing purposes :P, some may be final though
	 */
	public void createPalmTop(World world, BlockPos pos, int type) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		if(type == 1) 
		{
			createPalmLeavesBase(world, pos, LEAVES, WOOD, true);
		}
		else 
		{
			createPalmLeavesBase(world, pos, LEAVES, WOOD, false);
		}
	}
	
	protected void createPalmLeavesBase(World world, BlockPos pos, IBlockState block, IBlockState wood, boolean bigShape) {
		if(!bigShape) {
			this.setBlockAndNotifyAdequately(world, createStartPos(pos), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(1, 0, 0), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(-1, 0, 0), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(0, 0, 1), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).add(0, 0, -1), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).north(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).south(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).east(), block);
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(2).west(), block);
			
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).north(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.SOUTH).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).south(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.NORTH).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).east(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.WEST).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
			this.setBlockAndNotifyAdequately(world, createStartPos(pos).down(3).west(), TLSBlocks.COCONUT.getDefaultState().withProperty(BlockCoconut.FACING, EnumFacing.EAST).withProperty(BlockCoconut.AGE, Integer.valueOf(world.rand.nextInt(2))));
					
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
			}
			else {
				this.setBlockAndNotifyAdequately(world, pos.north(2).west(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.north(2).east(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.south(2).west(2), LEAVES_3X);
				this.setBlockAndNotifyAdequately(world, pos.south(2).east(2), LEAVES_3X);
				
				this.setBlockAndNotifyAdequately(world, pos.north(3).west(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.north(3).east(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(3).west(3).down(), LEAVES_3X_UP);
				this.setBlockAndNotifyAdequately(world, pos.south(3).east(3).down(), LEAVES_3X_UP);
			}
		} else {
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
		}
	}
	
	public static class generateClass implements IWorldGenerator {

		private final WorldGenerator WorldGen = new WorldGenPalmTree(false);
		
		@Override
		public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
			switch(world.provider.getDimension()) {
				case 0:
					runGenerator(WorldGen, world, random, chunkX, chunkZ, 3, -1, 0, BiomePlains.class);
					break;
				case 1:
					
					break;
				case 2:
					
					break;
			}
		}
		
		private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chancesToSpawn, int minHeight, int maxHeight, Class<?>... classes)
		{
			if(chancesToSpawn < 1) 
			{
				if(random.nextDouble() < chancesToSpawn) chancesToSpawn = 1;
				else chancesToSpawn = 0;
			}
			
			ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
			int heightDiff = maxHeight - minHeight + 1;
			for(int i = 0; i < chancesToSpawn; i++)
			{
				BlockPos pos = new BlockPos(chunkX * 16 + 10 + random.nextInt(15), minHeight + random.nextInt(heightDiff), chunkZ * 16 + 10 + random.nextInt(15));
				if(minHeight < 0) pos = world.getHeight(pos);
				Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
				if(classesList.contains(biome) || classes.length == 0) generator.generate(world, random, pos);
			}
		}
		
		public static void register() {
			GameRegistry.registerWorldGenerator(new WorldGenPalmTree.generateClass(), 0);
		}
	}
}
