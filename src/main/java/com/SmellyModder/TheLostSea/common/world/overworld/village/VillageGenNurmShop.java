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
	
	public static final WorldGenStructure NURM_SHOP = new WorldGenStructure("nurm_shop_s");
	
	public VillageGenNurmShop()
	{
	}

	public VillageGenNurmShop(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing facing)
	{
		super(villagePiece, par2);
		this.setCoordBaseMode(facing);
		this.boundingBox = par4StructureBoundingBox;
	}
	
	private int groundLevel = 0;

	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
	{
		if(groundLevel < 0)
		{
			groundLevel = this.getAverageGroundLevel(world, box);
			if(groundLevel < 0)
				return true;
			boundingBox.offset(0, groundLevel-boundingBox.maxY + 10 - 1, 0);
		}
		
		int i = 0;
		int k = 0;
		int j = 0;
		
		BlockPos blockpos = new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(-11), this.getZWithOffset(0, 0));
		
		this.NURM_SHOP.generate(world, rand, blockpos);
		
		this.fillWithBlocks(world, box, 0, 0, 0, 10, 9, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		this.fillWithBlocks(world, box, 6, 0, 1, 9, 0, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		
//		this.fillWithBlocks(world, box, 2, 1, 3, 8, 3, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 7, 5, 3, 8, 6, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 7, 3, box);
//		this.fillWithBlocks(world, box, 6, 5, 4, 6, 7, 4, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 2, 5, 5, 5, 6, 5, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 3, 7, 5, 5, 7, 5, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 8, 5, box);
//		//Back
//		this.fillWithBlocks(world, box, 2, 1, 8, 8, 3, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 2, 5, 8, 8, 6, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 3, 7, 8, 7, 7, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 8, 8, box);
//		//Left
//		this.fillWithBlocks(world, box, 1, 1, 4, 1, 3, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 1, 5, 6, 1, 5, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		//Right
//		this.fillWithBlocks(world, box, 9, 1, 4, 9, 3, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 9, 5, 4, 9, 6, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
//
//		//Windows
//		//Front
//		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 3, box);
//		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 3, box);
//		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, box);
//		this.fillWithBlocks(world, box, 7, 6, 3, 8, 6, 3, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		//Back
//		this.fillWithBlocks(world, box, 3, 2, 8, 5, 2, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 3, 6, 8, 4, 6, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 6, 6, 8, 7, 6, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		//Left
//		this.fillWithBlocks(world, box, 1, 2, 5, 1, 2, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 1, 6, 6, 1, 6, 7, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		//Right
//		this.fillWithBlocks(world, box, 9, 2, 5, 9, 2, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		this.fillWithBlocks(world, box, 9, 6, 5, 9, 6, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
//		
		
		return true;
	}

	public void placeItemframe(Random random, World world, int x, int y, int z, EnumFacing side, ItemStack stack)
	{
		int i1 = this.getXWithOffset(x, z);
		int j1 = this.getYWithOffset(y);
		int k1 = this.getZWithOffset(x, z);

		EntityItemFrame e = new EntityItemFrame(world, new BlockPos(i1, j1, k1), side);
		e.setDisplayedItem(stack);
		if(e.onValidSurface()&&world.getEntitiesWithinAABB(EntityHanging.class, new AxisAlignedBB(i1-.125, j1, k1-.125, i1+1.125, j1+1, k1+1.125)).isEmpty())
			if(!world.isRemote)
				world.spawnEntity(e);
	}

	public static class VillageManager implements IVillageCreationHandler
	{
		@Override
		public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
		{
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1 + 5, p2 + 5, p3 + 5, 0, 0, 0, 21, 20, 19, facing);
			return (!canVillageGoDeeper(box))||(StructureComponent.findIntersecting(pieces, box) != null) ? null : new VillageGenNurmShop(startPiece, p5, random, box, facing);
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
