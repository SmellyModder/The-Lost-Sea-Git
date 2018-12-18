package com.SmellyModder.TheLostSea.common.blocks.temple;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.util.WorldBoolHandler;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRuin extends BlockTempleBase{

	public BlockRuin(String name, Material material) {
		super(name, material);
		setHardness(3.0F);
		setResistance(1.12F);		
	}
}
