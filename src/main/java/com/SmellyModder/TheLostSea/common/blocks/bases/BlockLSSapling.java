package com.SmellyModder.TheLostSea.common.blocks.bases;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.world.dimension.feature.WorldGenCurvedPalmTree;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockLSSapling extends BlockBush implements IGrowable, IHasModel {

	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
	WorldGenerator saplingGenerator;
	boolean isPalm;
	
	public BlockLSSapling(String name, WorldGenerator saplingGenerator, boolean isPalm) {
		setRegistryName(name);
		setTranslationKey(name);
		
		setSoundType(SoundType.PLANT);
        setDefaultState(this.blockState.getBaseState().withProperty(BlockSapling.STAGE, 0));
        setCreativeTab(TheLostSea.TLS_PLANTS);
        this.saplingGenerator = saplingGenerator;
        this.isPalm = isPalm;
        
        TLSBlocks.BLOCKS.add(this);
		TLSItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            super.updateTick(world, pos, state, rand);

            if (!world.isBlockLoaded(pos)) {
                return;
            }

            if (world.getLightFromNeighbors(pos.up()) < 9 && rand.nextInt(7) == 0) {
                this.grow(world, rand, pos, state);
            }
        }
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		 if (state.getValue(BlockSapling.STAGE) == 0) {
			 world.setBlockState(pos, state.cycleProperty(BlockSapling.STAGE), 4);
		 }
		 else if(TerrainGen.saplingGrowTree(world, rand, pos)) {
			 WorldGenerator generator = this.saplingGenerator;
			 if(isPalm) {
				 generator = world.rand.nextInt(6) == 1 ? new WorldGenCurvedPalmTree(false, world.rand.nextInt(4)) : this.saplingGenerator;
			 }
			 world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
			 
			 if (!generator.generate(world, rand, pos)) {
	             world.setBlockState(pos, state, 4);
			 }
		 }
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = this.saplingGenerator;
		world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
		
		if (!gen.generate(world, rand, pos)) {
            world.setBlockState(pos, state, 4);
        }
	}
	
	@Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(BlockSapling.STAGE, meta & 1);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(BlockSapling.STAGE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BlockSapling.STAGE);
    }

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
