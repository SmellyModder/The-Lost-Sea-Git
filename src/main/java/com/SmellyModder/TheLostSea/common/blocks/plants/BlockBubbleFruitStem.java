package com.SmellyModder.TheLostSea.common.blocks.plants;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.discovery.ContainerType;

public class BlockBubbleFruitStem extends BlockBase implements IGrowable, IPlantable{

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);
	
	public BlockBubbleFruitStem(String name, Material material) {
		super(name, material);
		this.setHardness(0.3F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
		this.setSoundType(SoundType.PLANT);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(TLSItems.BUBBLE_FRUIT);
	}
	
	public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
	
	protected PropertyInteger getAgeProperty()
    {
        return AGE;
    }
	
	private int getMaxAge() {
		return 5;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Water;
	}
	
	protected int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }

    public IBlockState withAge(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }

    public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
	
	public IBlockState getStateFromMeta(int meta)
	{
	   return this.withAge(meta);
	}

	public int getMetaFromState(IBlockState state)
	{
	   return this.getAge(state);
	}

	protected BlockStateContainer createBlockState()
	{
	        return new BlockStateContainer(this, new IProperty[] {AGE});
	}

	@Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }

//	@Override
//	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
//		return pos.up() == Blocks.WATER.getDefaultState() && pos.up() != TLSBlocks.BUBBLE_FRUIT_STEM.getDefaultState();
//	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
	}
}
