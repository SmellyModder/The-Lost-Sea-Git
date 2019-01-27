package com.SmellyModder.TheLostSea.common.world.overworld.village;

import java.util.List;
import java.util.Random;

import com.SmellyModder.TheLostSea.common.world.overworld.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumHingePosition;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;


public class VillageGenNurmShop extends Village
{
	
	public static final WorldGenStructure NURM_SHOP = new WorldGenStructure("nurm_shop_new");
	
	public VillageGenNurmShop()
	{
	}

	public VillageGenNurmShop(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing facing)
	{
		super(villagePiece, par2);
		this.setCoordBaseMode(facing);
		this.boundingBox = par4StructureBoundingBox;
	}
	
	private int groundLevel = -1;

	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
	{
		if(groundLevel < 0)
		{
			groundLevel = this.getAverageGroundLevel(world, box);
			if(groundLevel < 0)
				return true;
			boundingBox.offset(0, groundLevel - boundingBox.maxY + 20 - 1, 0);
		}
		
		this.fillWithBlocks(world, box, 0, 0, 0, 25, 4, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		
		this.fillWithBlocks(world, box, 3, 2, 8, 5, 2, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 0, 0, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 26, 10, 17, box);
		
		for(int zz = 0; zz <= 17; zz++)
			for(int xx = 0; xx <= 25; xx++)
			{
				this.clearCurrentPositionBlocksUpwards(world, xx, 10, zz, box);
				this.replaceAirAndLiquidDownwards(world, Blocks.COBBLESTONE.getDefaultState(), xx, -1, zz, box);
			}
		
		return true;
	}

	public static class VillageManager implements IVillageCreationHandler
	{
		@Override
		public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
		{
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 26, 19, 17, facing);
			return (!canVillageGoDeeper(box)) || (StructureComponent.findIntersecting(pieces, box) != null) ? null : new VillageGenNurmShop(startPiece, p5, random, box, facing);
		}


		@Override
		public PieceWeight getVillagePieceWeight(Random random, int i)
		{
			return new PieceWeight(VillageGenNurmShop.class, 100, 1);
		}

		@Override
		public Class<?> getComponentClass()
		{
			return VillageGenNurmShop.class;
		}
	}

}
