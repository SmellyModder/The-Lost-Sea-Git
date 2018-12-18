package com.SmellyModder.TheLostSea.common.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAnchor extends BlockBase{
	public BlockAnchor(String name, Material material) {
		super(name, material);
	}
	
	@Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		EntityPlayer entity = Minecraft.getMinecraft().player;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = world;
		Random par5Random = random;
		if (true)
			for (int la = 0; la < 1; ++la) {
				double d0 = (double) ((float) x + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.09999999850988389D;
				double d1 = ((double) ((float) y + 0.7F) + (double) (par5Random.nextFloat() - 0.5F) * 0.09999999850988389D * 100) + 0.5D;
				double d2 = (double) ((float) z + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.09999999850988389D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;
				par1World.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			}

	}
}
