package com.SmellyModder.TheLostSea.common.world.overworld.village;

import java.util.List;
import java.util.Random;

import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.common.world.overworld.WorldGenStructure;
import com.SmellyModder.TheLostSea.core.api.LostSeaLootTables;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBanner;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumHingePosition;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockLever.EnumOrientation;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockRail;
import net.minecraft.block.BlockRailBase.EnumRailDirection;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.BlockPrismarine.EnumType;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

/*
 * SmellyModder
 */
public class VillageGenNurmShop extends Village
{
	
	public static final WorldGenStructure NURM_SHOP = new WorldGenStructure("nurm_shop_new");
	
	public static final ResourceLocation rowChestLoot = register("loot/nurm/rowchest");
	
	private static ResourceLocation register(String id) {
        return LootTableList.register(new ResourceLocation(Reference.MOD_ID, id));
    }
	
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
		
		//Tells me where it starts on the bottom corner and ends on the top corner.
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 0, 0, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 26, 19, 17, box);
		
		/*
		 * ###########
		 * # BOTTOM  #
		 * ###########
		 */
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 0, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 0, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 9, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 0, 5, box);
		
		this.fillWithBlocks(world, box, 9, 0, 5, 9, 0, 11, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 9, 0, 4, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 9, 0, 12, box);
		
		this.fillWithBlocks(world, box, 17, 0, 5, 17, 0, 11, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 0, 4, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 0, 12, box);
		
		this.fillWithBlocks(world, box, 10, 0, 5, 16, 0, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 10, 0, 12, 16, 0, 12, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , false);
		this.fillWithBlocks(world, box, 10, 0, 4, 16, 0, 4, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE) , false);
		
		this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 10, 0, 5, box);
		this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 10, 0, 11, box);
		this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 16, 0, 11, box);
		this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 16, 0, 5, box);
		
		this.fillWithBlocks(world, box, 10, 0, 3, 19, 0, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 17, 0, 2, 18, 0, 2, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 18, 0, 4, 22, 0, 12, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 23, 0, 5, 23, 0, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 11, 0, 13, 21, 0, 14, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 9, 0, 13, 11, 0, 13, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		
		
		
		//Carpet
		//Black
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 11, 1, 5, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 10, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 10, 1, 10, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 11, 1, 11, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 16, 1, 10, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 15, 1, 11, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 16, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 15, 1, 5, box);
		
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 13, 1, 8, box);
		
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 12, 1, 7, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 12, 1, 9, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 14, 1, 7, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.BLACK), 14, 1, 9, box);
		
		//White
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 14, 1, 8, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 12, 1, 8, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 13, 1, 9, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 13, 1, 7, box);
		
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 11, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 11, 1, 10, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 15, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.WHITE), 15, 1, 10, box);
		
		//Red
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 11, 1, 7, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 12, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 12, 1, 10, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 11, 1, 9, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 14, 1, 6, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 15, 1, 7, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 15, 1, 9, box);
		this.setBlockState(world, Blocks.CARPET.getDefaultState().withProperty(BlockCarpet.COLOR, EnumDyeColor.RED), 14, 1, 10, box);
		
		/*
		 * ##############
		 * #SECOND LAYER#
		 * ##############
		 */
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 1, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 1, 6, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 1, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 1, 4, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 1, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 1, 9, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 1, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 1, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 1, 14, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 10, 1, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 10, 1, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 1, 15, box);
		this.fillWithBlocks(world, box, 11, 1, 15, 21, 1, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 1, 15, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 1, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 1, 13, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 1, 12, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 1, 12, box);
		this.setBlockState(world, Blocks.DIAMOND_BLOCK.getDefaultState(), 22, 1, 11, box);
		this.setBlockState(world, Blocks.DIAMOND_BLOCK.getDefaultState(), 23, 1, 11, box);
		this.setBlockState(world, Blocks.DIAMOND_BLOCK.getDefaultState(), 23, 1, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 1, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 1, 4, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 1, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 1, 6, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 1, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 1, 6, box);
		
		this.fillWithBlocks(world, box, 19, 1, 3, 19, 1, 14, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.SPRUCE_FENCE.getDefaultState(), false);
		this.placeFencePillar(world, box, rand, 19, 1, 3);
		this.placeFencePillar(world, box, rand, 19, 1, 6);
		this.placeFencePillar(world, box, rand, 19, 1, 14);
		this.placeFencePillar(world, box, rand, 19, 1, 11);
		
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 16, 1, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 14, 1, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 12, 1, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 16, 2, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 14, 2, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 12, 2, 14, box);
		this.setBlockState(world, Blocks.ENDER_CHEST.getDefaultState().withProperty(BlockEnderChest.FACING, EnumFacing.SOUTH), 13, 2, 14, box);
		this.setBlockState(world, Blocks.FLOWER_POT.getDefaultState().withProperty(BlockFlowerPot.CONTENTS, BlockFlowerPot.EnumFlowerType.POPPY).withProperty(BlockFlowerPot.LEGACY_DATA, Integer.valueOf(1)), 15, 2, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 15, 1, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 13, 1, 14, box);

		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 1, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 21, 1, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 1, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 1, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 19, 1, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 18, 1, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 1, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 16, 1, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 15, 1, 2, box);
		
		this.placeDoor(world, box, rand, 14, 1, 2, EnumFacing.NORTH, EnumHingePosition.RIGHT);
		this.placeDoor(world, box, rand, 13, 1, 2, EnumFacing.NORTH, EnumHingePosition.LEFT);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 14, 0, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 13, 0, 2, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 12, 1, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 11, 1, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 10, 1, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 1, 1, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 1, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 3, box);
		this.setBlockState(world, Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, BlockPrismarine.EnumType.DARK), 8, 1, 4, box);
		
		Block juke = Blocks.JUKEBOX;
		BlockPos blockpos = new BlockPos(this.getXWithOffset(9, 11), this.getYWithOffset(1), this.getZWithOffset(9, 11));
		((BlockJukebox)juke).insertRecord(world, blockpos, juke.getDefaultState(), new ItemStack(Items.RECORD_CHIRP));
		this.setBlockState(world, juke.getDefaultState().withProperty(BlockJukebox.HAS_RECORD, Boolean.valueOf(true)), 9, 1, 11, box);
		
		
		/***
		 * ###############
		 * ##3rd Layer####
		 * ###############
		 */
		this.fillWithBlocks(world, box, 10, 2, 15, 21, 2, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 9, 2, 15, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 2, 14, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 2, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 2, 14, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 2, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 2, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 2, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 2, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 2, 9, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 2, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 2, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 2, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 2, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 2, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 2, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 2, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 2, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 2, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 2, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 11, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 12, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 15, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 16, 2, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 2, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 18, 2, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 19, 2, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 21, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 2, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 2, 3, box);
		this.fillWithBlocks(world, box, 24, 2, 3, 24, 2, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		
		this.setBlockState(world, Blocks.DIAMOND_BLOCK.getDefaultState(), 23, 2, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 2, 12, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 2, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 2, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 2, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 2, 15, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 2, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 2, 6, box);
		
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 2, 4, box);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 3, 4, box);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 4, 4, box);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 5, 4, box);
		
		/*
		 * #############
		 * ## LAYER 4 ##
		 * #############
		 */
		this.setBlockState(world, Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockHalfWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP), 13, 3, 14, box);
		this.setBlockState(world, Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockHalfWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP), 15, 3, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 14, 3, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 16, 3, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 12, 3, 14, box);
		this.fillWithBlocks(world, box, 9, 3, 15, 14, 3, 15, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 8, 3, 15, box);
		this.fillWithBlocks(world, box, 15, 3, 15, 21, 3, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 3, 15, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 3, 14, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 3, 13, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 3, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 3, 12, box);
		this.fillWithBlocks(world, box, 24, 3, 2, 24, 3, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 3, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 3, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 3, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 3, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 21, 3, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 19, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 18, 3, 1, box);
		this.fillWithBlocks(world, box, 11, 3, 2, 16, 3, 2, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 3, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 3, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 3, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 3, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 3, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 3, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 3, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 3, 8, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 3, 9, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 3, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 3, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 3, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 3, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 3, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 3, 13, box);

		Block creeper = Blocks.SKULL;
		
		this.setBlockState(world, Blocks.SPONGE.getDefaultState(), 8, 2, 3, box);
		this.setBlockState(world, Blocks.PRISMARINE.getDefaultState(), 7, 3, 3, box);
		this.setBlockState(world, Blocks.PRISMARINE.getDefaultState().withProperty(BlockPrismarine.VARIANT, EnumType.BRICKS), 7, 2, 4, box);
		
		
		/*
		 * ##################
		 * 5TH LAYER
		 * ##################
		 */
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 2, 4, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 2, 4, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 4, 5, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 4, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 4, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 4, 2, box);
		this.setBlockState(world, Blocks.WEB.getDefaultState(), 6, 4, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 7, 4, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 4, 1, box);
		this.fillWithBlocks(world, box, 9, 4, 1, 19, 4, 1, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 11, 4, 2, 16, 4, 2, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LEVER.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty(BlockLever.POWERED, Boolean.valueOf(true)), 10, 4, 2, box);
		this.setBlockState(world, Blocks.LEVER.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty(BlockLever.POWERED, Boolean.valueOf(true)), 17, 4, 2, box);
		this.setBlockState(world, Blocks.REDSTONE_LAMP.getDefaultState(), 10, 4, 0, box);
		this.setBlockState(world, Blocks.REDSTONE_LAMP.getDefaultState(), 17, 4, 0, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 19, 4, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 4, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 21, 4, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 4, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 4, 1, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 4, 2, box);

		this.fillWithBlocks(world, box, 24, 4, 3, 24, 4, 11, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 4, 4, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 24, 4, 6, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 24, 4, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 4, 12, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 4, 12, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 4, 13, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 4, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 4, 15, box);
		
		this.fillWithBlocks(world, box, 15, 4, 15, 21, 4, 15, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 9, 4, 15, 14, 4, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 8, 4, 15, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 3, 14, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 4, 14, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 4, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 4, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 4, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 6, 4, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 4, 10, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 4, 4, 9, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 4, 8, box);
		
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 12, 4, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 14, 4, 14, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 16, 4, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 15, 4, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 13, 4, 14, box);
		
		Block banner = Blocks.WALL_BANNER;
		BlockPos blockpos2 = new BlockPos(this.getXWithOffset(8, 0), this.getYWithOffset(4), this.getZWithOffset(8, 0));
		this.setBlockState(world, banner.getDefaultState().withProperty(BlockBanner.FACING, EnumFacing.SOUTH), 8, 4, 0, box);
		TileEntity tileentity = world.getTileEntity(blockpos2);
		ItemStack itemstack = new ItemStack(Items.BANNER, 1, EnumDyeColor.LIME.getDyeDamage());
		if (itemstack.getTagCompound() != null && !itemstack.getTagCompound().isEmpty())
	    {
	        itemstack.getOrCreateSubCompound("BlockEntityTag").setTag("Patterns", itemstack.getTagCompound().getTagList("Patterns", 2).copy());
	    }
		
		if (tileentity instanceof TileEntityBanner)
        {
            ((TileEntityBanner)tileentity).setItemValues(itemstack, false);
        }

		
		
		/*
		 * ###################
		 * ##LAYER 6#########
		 * ###################
		 */
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 5, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 5, 12, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 5, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 5, 14, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 5, 11, box);
		this.fillWithBlocks(world, box, 24, 5, 2, 24, 5, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 5, 6, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 5, 9, box);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 5, 4, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 23, 5, 1, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 22, 5, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 21, 5, 1, box);
		this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 20, 5, 1, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 19, 5, 1, box);
		this.fillWithBlocks(world, box, 10, 5, 1, 18, 5, 1, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.SPRUCE_FENCE.getDefaultState(), false);
		this.fillWithBlocks(world, box, 6, 5, 1, 9, 5, 1, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 5, 5, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 4, 5, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 3, 5, 4, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 2, 5, 5, box);
		
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 3, 5, 5, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 4, 5, 4, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 5, 5, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 6, 5, 2, box);
		
		
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 2, 5, 8, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 3, 5, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 4, 5, 10, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 5, 5, 11, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 6, 5, 12, box);
		
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 3, 5, 8, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 4, 5, 9, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 5, 5, 10, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 6, 5, 11, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 7, 5, 12, box);
		
		this.setBlockState(world, Blocks.REDSTONE_LAMP.getDefaultState(), 8, 5, 12, box);
		this.setBlockState(world, Blocks.LEVER.getDefaultState().withProperty(BlockLever.POWERED, Boolean.valueOf(true)).withProperty(BlockLever.FACING, EnumOrientation.SOUTH), 8, 5, 11, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 5, 13, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 5, 14, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 5, 15, box);
		
		
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 0, 5, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 1, 5, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 1, 5, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 0, 5, 6, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 2, 5, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 5, 7, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 3, 5, 6, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 2, 5, 6, box);
		
		this.fillWithBlocks(world, box, 4, 5, 5, 4, 5, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 5, 5, 4, 5, 5, 9, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 6, 5, 3, 6, 5, 10, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 7, 5, 2, 7, 5, 11, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 5, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 9, 5, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 10, 5, 2, box);
		this.fillWithBlocks(world, box, 10, 5, 3, 19, 5, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 19, 5, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 16, 5, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 12, 5, 3, box);
		
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 17, 5, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 18, 5, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 19, 5, 2, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 10, 5, 0, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 17, 5, 0, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 5, 15, box);
		
		this.fillWithBlocks(world, box, 14, 5, 15, 21, 5, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.fillWithBlocks(world, box, 9, 5, 15, 14, 5, 15, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.REDSTONE_LAMP.getDefaultState(), 15, 5, 14, box);
		this.setBlockState(world, Blocks.LIT_REDSTONE_LAMP.getDefaultState(), 13, 5, 14, box);
		this.setBlockState(world, Blocks.LEVER.getDefaultState().withProperty(BlockLever.POWERED, Boolean.valueOf(false)).withProperty(BlockLever.FACING, EnumOrientation.SOUTH), 14, 5, 14, box);
		this.setBlockState(world, Blocks.FLOWER_POT.getDefaultState().withProperty(BlockFlowerPot.CONTENTS, BlockFlowerPot.EnumFlowerType.MUSHROOM_BROWN).withProperty(BlockFlowerPot.LEGACY_DATA, Integer.valueOf(8)), 12, 5, 14, box);
		this.setBlockState(world, Blocks.RAIL.getDefaultState().withProperty(BlockRail.SHAPE, EnumRailDirection.NORTH_WEST), 16, 5, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 17, 5, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 19, 5, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 21, 5, 14, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 20, 5, 14, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 18, 5, 14, box);
		this.setBlockState(world, Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockHalfWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP), 20, 4, 14, box);
		this.setBlockState(world, Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockHalfWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP), 18, 4, 14, box);

		
		/*
		 * ###################
		 * # LAYER 7##########
		 * ###################
		 */
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 2, 6, 6, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 2, 6, 7, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 2, 6, 5, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 3, 6, 5, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 3, 6, 4, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 4, 6, 4, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 4, 6, 3, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 5, 6, 3, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 5, 6, 2, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 6, 6, 2, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 6, 6, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 7, 6, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 8, 6, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 9, 6, 1, box);
		
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 2, 6, 8, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 3, 6, 8, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 3, 6, 9, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 4, 6, 9, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 4, 6, 10, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 5, 6, 10, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 5, 6, 11, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 6, 6, 11, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 6, 6, 12, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 7, 6, 12, box);
		
		this.fillWithBlocks(world, box, 8, 6, 4, 8, 6, 14, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 15, 6, 4, 15, 6, 14, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 8, 6, 3, 15, 6, 3, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 8, 6, 15, 21, 6, 15, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 9, 6, 16, 14, 6, 16, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);

		this.fillWithBlocks(world, box, 9, 6, 4, 14, 6, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 13, 6, 11, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 13, 6, 8, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 6, 8, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 10, 6, 11, box);
		this.setBlockState(world, Blocks.AIR.getDefaultState(), 11, 6, 10, box);
		this.setBlockState(world, Blocks.AIR.getDefaultState(), 12, 6, 10, box);
		this.setBlockState(world, Blocks.AIR.getDefaultState(), 12, 6, 9, box);
		this.setBlockState(world, Blocks.AIR.getDefaultState(), 11, 6, 9, box);
		
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 16, 6, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 19, 6, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 18, 6, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 17, 6, 3, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 20, 6, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 21, 6, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 22, 6, 2, box);
		this.setBlockState(world, Blocks.LEVER.getDefaultState().withProperty(BlockLever.FACING, EnumOrientation.NORTH).withProperty(BlockLever.POWERED, Boolean.valueOf(true)), 23, 6, 3, box);
		this.setBlockState(world, Blocks.REDSTONE_LAMP.getDefaultState(), 23, 6, 2, box);
		this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 24, 6, 2, box);
		
		this.fillWithBlocks(world, box, 20, 6, 1, 23, 6, 1, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 24, 6, 3, 24, 6, 11, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.WEB.getDefaultState(), 23, 6, 11, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 6, 12, box);
		this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 22, 6, 12, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 6, 13, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 6, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 22, 6, 15, box);
		
		this.placeChest(world, boundingBox, rand, 21, 6, 14, EnumFacing.SOUTH, this.rowChestLoot);
		this.placeChest(world, boundingBox, rand, 19, 6, 14, EnumFacing.SOUTH, this.rowChestLoot);
		this.placeChest(world, boundingBox, rand, 17, 6, 14, EnumFacing.SOUTH, this.rowChestLoot);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 18, 6, 14, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 20, 6, 14, box);
		this.setBlockState(world, Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE), 16, 6, 14, box);

		/*
		 * ###############
		 * # LAYER 8######
		 * ##############
		 */
		this.setBlockState(world, Blocks.TRAPDOOR.getDefaultState().withProperty(BlockTrapDoor.FACING, EnumFacing.SOUTH), 11, 7, 10, box);
		this.setBlockState(world, Blocks.TRAPDOOR.getDefaultState().withProperty(BlockTrapDoor.FACING, EnumFacing.SOUTH), 12, 7, 10, box);
		this.setBlockState(world, Blocks.TRAPDOOR.getDefaultState(), 12, 7, 9, box);
		this.setBlockState(world, Blocks.TRAPDOOR.getDefaultState(), 11, 7, 9, box);
		
		this.fillWithBlocks(world, box, 8, 7, 3, 8, 7, 15, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		this.fillWithBlocks(world, box, 8, 7, 3, 14, 7, 3, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		this.fillWithBlocks(world, box, 8, 7, 15, 15, 7, 15, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		this.fillWithBlocks(world, box, 15, 7, 3, 15, 7, 15, Blocks.SPRUCE_FENCE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
		this.fillWithBlocks(world, box, 15, 7, 4, 22, 7, 15, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		
		this.fillWithBlocks(world, box, 15, 7, 3, 22, 7, 3, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 25, 7, 3, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 7, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 24, 7, 2, box);
		this.setBlockState(world, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), 23, 7, 1, box);
		
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 22, 7, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 21, 7, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 20, 7, 1, box);
		this.setBlockState(world, Blocks.SPRUCE_FENCE.getDefaultState(), 19, 6, 1, box);
		this.fillWithBlocks(world, box, 25, 7, 3, 25, 7, 11, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), false);
		this.fillWithBlocks(world, box, 23, 7, 4, 24, 7, 12, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 6, 4, box);
		this.setBlockState(world, Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST), 23, 7, 4, box);
		
		///Places Blocks so that it doesn't float, will fix later due to it being a bit weird
		for(int zz = 0; zz <= 17; zz++)
			for(int xx = 0; xx <= 25; xx++)
			{
				this.clearCurrentPositionBlocksUpwards(world, xx, 10, zz, box);
				this.replaceAirAndLiquidDownwards(world, Blocks.COBBLESTONE.getDefaultState(), xx, -1, zz, box);
			}
		
		return true;
	}
	
	protected void placeDoor(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z, EnumFacing facing, EnumHingePosition hinge)
	{
		this.setBlockState(worldIn, Blocks.SPRUCE_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HINGE, hinge), x, y, z, boundingBoxIn);
		this.setBlockState(worldIn, Blocks.SPRUCE_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGE, hinge), x, y+1, z, boundingBoxIn);
	}
	
	protected void placeChest(World world, StructureBoundingBox box, Random rand, int x, int y, int z, EnumFacing facing, ResourceLocation loot) {
		BlockPos blockpos = new BlockPos(this.getXWithOffset(x, z), this.getYWithOffset(y), this.getZWithOffset(x, z)); 
		this.setBlockState(world, Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, facing), x, y, z, box);
		TileEntity tileentityC = world.getTileEntity(blockpos);
		if(tileentityC instanceof TileEntityChest) {
			((TileEntityChest)tileentityC).setLootTable(loot, rand.nextLong());
		}
	}

	protected void placeFencePillar(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z) {
		IBlockState woodSlab = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockWoodSlab.VARIANT, BlockPlanks.EnumType.SPRUCE);
		this.setBlockState(worldIn, Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y).withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), x, y, z, boundingBoxIn);
		this.setBlockState(worldIn, woodSlab, x, y + 1, z, boundingBoxIn);
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
