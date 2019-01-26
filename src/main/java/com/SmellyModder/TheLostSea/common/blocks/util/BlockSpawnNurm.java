package com.SmellyModder.TheLostSea.common.blocks.util;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityNurm;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSpawnNurm extends BlockBase{

	public BlockSpawnNurm(String name, Material material) {
		super(name, material);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		if (true) {
			Entity sentity = new EntityNurm(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(i, j + 1, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
				world.setBlockState(new BlockPos(i, j, k), Blocks.PLANKS.getDefaultState(), 3);
			}
		}
		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));
	}
	
	@Override
	public int tickRate(World world) {
		return 2;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}
}
