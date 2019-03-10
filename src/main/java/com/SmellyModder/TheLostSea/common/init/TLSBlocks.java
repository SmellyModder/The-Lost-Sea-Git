package com.SmellyModder.TheLostSea.common.init;

import java.util.ArrayList;
import java.util.List;

import com.SmellyModder.TheLostSea.common.blocks.BlockLSPortal;
import com.SmellyModder.TheLostSea.common.blocks.BlockLSStair;
import com.SmellyModder.TheLostSea.common.blocks.BlockMetalBase;
import com.SmellyModder.TheLostSea.common.blocks.BlockRock;
import com.SmellyModder.TheLostSea.common.blocks.BlockSeaFurnace;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSBark;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSDoor;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSDoubleSlab;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSFence;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSFenceGate;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSSlabHalf;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSLeaves;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSLog;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSPlank;
import com.SmellyModder.TheLostSea.common.blocks.bases.BlockLSSapling;
import com.SmellyModder.TheLostSea.common.blocks.itemblocks.ItemBlockLSDoor;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockLSOres;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockSeaCoalOre;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockSeaDiamondOre;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockSeaIronOre;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockSeaOres;
import com.SmellyModder.TheLostSea.common.blocks.plants.BlockBubbleFruitStem;
import com.SmellyModder.TheLostSea.common.blocks.plants.tree.crop.BlockCoconut;
import com.SmellyModder.TheLostSea.common.blocks.rewards.BlockStarterChest;
import com.SmellyModder.TheLostSea.common.blocks.rewards.BlockStarterChestFull;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPillarBase;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPortalKey;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPortalKeyDormant;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockRotatableDeco;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockRuin;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockTempleBaseStone;
import com.SmellyModder.TheLostSea.common.blocks.temple.DummyAirBlock;
import com.SmellyModder.TheLostSea.common.world.dimension.feature.WorldGenPalmTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;

public class TLSBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Environment
	public static final Block SEA_ROCK = new BlockRock("sea_rock", Material.ROCK, 1.9F, false);
	public static final Block DEEP_SEA_ROCK = new BlockRock("deepsea_rock", Material.ROCK, 2.2F, false);
	//public static final Block BUBBLE_FRUIT_STEM = new BlockBubbleFruitStem("bubble_fruit_stem", Material.VINE);
	public static final Block POLISHED_SEASTONE = new BlockRock("p_sea_stone", Material.ROCK, 1.9F, true);
	public static final Block POLISHED_DEEPSEASTONE = new BlockRock("p_deepsea_stone", Material.ROCK, 2.2F, true);
	
	public static final Block SEA_PEBBLES = new BlockRock("sea_pebbles", Material.ROCK, 1.4F, false);
	
	//Ores
	public static final Block DEEPSEA_GOLDORE = new BlockSeaOres("deepsea_goldore", Material.ROCK, true, 0);
	public static final Block SEA_GOLDORE = new BlockSeaOres("sea_goldore", Material.ROCK, false, 0);
	public static final Block DEEPSEA_DIAMONDORE = new BlockSeaDiamondOre("deepsea_diamondore", Material.ROCK, true);
	public static final Block SEA_DIAMONDORE = new BlockSeaDiamondOre("sea_diamondore", Material.ROCK, false);
	public static final Block DEEPSEA_IRONORE = new BlockSeaIronOre("deepsea_ironore", Material.ROCK, true);
	public static final Block SEA_IRONORE = new BlockSeaIronOre("sea_ironore", Material.ROCK, false);
	public static final Block DEEPSEA_COALORE = new BlockSeaCoalOre("deepsea_coalore", Material.ROCK, true);
	public static final Block SEA_COALORE = new BlockSeaCoalOre("sea_coalore", Material.ROCK, false);
	public static final Block DEEPSEA_COBALTORE = new BlockLSOres("deepsea_neptunumore", Material.ROCK, true, 0);
	public static final Block SEA_COBALTORE = new BlockLSOres("sea_neptunumore", Material.ROCK, false, 0);
	public static final Block SEA_VANADIUMORE = new BlockLSOres("sea_vanadiumore", Material.ROCK, false, 1);
	public static final Block DEEPSEA_VANADIUMORE = new BlockLSOres("deepsea_vanadiumore", Material.ROCK, false, 1);
	//public static final Block AQUAMARINE_ORE = new BlockLSOres("sea_aquamarineore", Material.ROCK, false, 2);
	
	//Temple
	public static final Block CARVED_PRISMARINE_EYE = new BlockRuin("carved_eye", Material.ROCK);
	public static final Block PRISMARINE_PILLAR = new BlockPillarBase("prismarine_pillar", Material.ROCK);
	public static final Block PRISMARINE_PILLAR_TOP = new BlockPillarBase("prismarine_pillar_top", Material.ROCK);
	public static final Block PRISMARINE_PILLAR_TOP_FANCY = new BlockPillarBase("prismarine_pillar_bottom", Material.ROCK);
	public static final Block PRISMARINE_EYE_TEMPLE = new BlockRuin("prismarine_eye_block", Material.ROCK);
	public static final Block PRISMARINE_TRIANGLE = new BlockRotatableDeco("prismarine_pyramid");
	public static final Block PRISMARINE_TRIANGLE_DARK = new BlockRotatableDeco("prismarine_pyramid_dark");
	public static final Block PRISMARINE_POLISHED = new BlockTempleBaseStone("prismarine_smooth", Material.ROCK);
	public static final Block PRISMARINE_SWIRL = new BlockRotatableDeco("prismarine_swirl");
	public static final Block PRISMARINE_INTERTWINED = new BlockRotatableDeco("prismarine_intertwined");
	public static final Block PRISMARINE_SHELL_BLOCK = new BlockRotatableDeco("prismarine_shell");
	public static final Block PRIS_WAVE = new BlockRotatableDeco("prismarine_wave");
	public static final Block PRIS_CARVING_1 = new BlockRotatableDeco("prismarine_guardian_rock");
	public static final Block PRIS_CARVING_2 = new BlockRotatableDeco("prismarine_rock_aegaeon");
	public static final Block PORTAL_KEY = new BlockPortalKey("portal_key", Material.CIRCUITS);
	public static final Block PORTAL_KEY_DORMANT = new BlockPortalKeyDormant("portal_key_d", Material.CIRCUITS);
	public static final Block DUMMY_AIR = new DummyAirBlock("dummy_air", Material.CIRCUITS);
	
	//Ore Blocks
	public static final Block VANADIUM_BLOCK = new BlockMetalBase("vanadium_block", Material.ROCK, 5.2F, 10F);
	public static final Block NEPTUNUM_BLOCK = new BlockMetalBase("neptunum_block", Material.ROCK, 6.0F, 11F);

	//Portal
	public static final Block PORTAL = new BlockLSPortal("lost_sea_portal", Material.PORTAL);
	
	//Machines
	public static final Block SEASTONE_FURNACE = new BlockSeaFurnace("seastone_furnace", false, true);
	public static final Block SEASTONE_FURNACE_LIT = new BlockSeaFurnace("seastone_furnace_lit", true, false);
	
	/*
	 * Rewards
	 */
	public static final Block STARTER_CHEST_FULL = new BlockStarterChestFull("starter_chest_full");
	public static final Block STARTER_CHEST = new BlockStarterChest("starter_chest");
	
	/*
	 * ##########
	 * #  PALM  #
	 * ##########
	 */
	public static final Block PALM_LOG = new BlockLSLog("palm_log");
	public static final Block PALM_BARK = new BlockLSBark("palm_wood");
	public static final Block PALM_LEAVES = new BlockLSLeaves("palm_leaves", TLSBlocks.PALM_SAPLING, true);
	public static final Block PALM_SAPLING = new BlockLSSapling("palm_sapling", new WorldGenPalmTree(false), true);
	public static final Block PALM_PLANKS = new BlockLSPlank("palm_planks");
	public static final Block PALM_STAIRS = new BlockLSStair("palm_stairs", PALM_PLANKS.getDefaultState());
	public static final BlockSlab PALM_DOUBLE_SLAB = new BlockLSDoubleSlab("palm_double_slab", Material.WOOD, TLSBlocks.PALM_SLAB);
	public static final BlockSlab PALM_SLAB = new BlockLSSlabHalf("palm_slab", Material.WOOD, TLSBlocks.PALM_SLAB, TLSBlocks.PALM_DOUBLE_SLAB);
	
	public static final BlockFence PALM_FENCE = new BlockLSFence("palm_fence", PALM_PLANKS.getDefaultState());
	public static final Block PALM_FENCE_GATE = new BlockLSFenceGate("palm_fence_gate", PALM_PLANKS.getDefaultState());
	public static final Block PALM_DOOR = new BlockLSDoor("palm_door");
	public static final Block COCONUT = new BlockCoconut("coconut");
	
}
