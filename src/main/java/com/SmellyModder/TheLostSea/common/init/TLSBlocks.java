package com.SmellyModder.TheLostSea.common.init;

import java.util.ArrayList;
import java.util.List;

import com.SmellyModder.TheLostSea.common.blocks.BlockAnchor;
import com.SmellyModder.TheLostSea.common.blocks.BlockLSPortal;
import com.SmellyModder.TheLostSea.common.blocks.BlockLiquidack;
import com.SmellyModder.TheLostSea.common.blocks.BlockRock;
import com.SmellyModder.TheLostSea.common.blocks.fluid.BlockDarkwaterFluid;
import com.SmellyModder.TheLostSea.common.blocks.furnaces.BlockSeaFurnace;
import com.SmellyModder.TheLostSea.common.blocks.ore.BlockSeaGOre;
import com.SmellyModder.TheLostSea.common.blocks.rewards.BlockStarterChest;
import com.SmellyModder.TheLostSea.common.blocks.rewards.BlockStarterChestFull;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPillarBase;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPortalKey;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockPortalKeyDormant;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockRotatableDeco;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockRuin;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockTempleBase;
import com.SmellyModder.TheLostSea.common.blocks.temple.BlockTempleBaseStone;
import com.SmellyModder.TheLostSea.common.blocks.temple.DummyAirBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;

public class TLSBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Environment
	//public static final Block LIQUIDACK = new BlockLiquidack("liquidack", Material.ROCK);
	public static final Block SEA_ROCK = new BlockRock("sea_rock", Material.ROCK, 1.9F, false);
	public static final Block DEEP_SEA_ROCK = new BlockRock("deepsea_rock", Material.ROCK, 2.2F, false);
	//public static final Block SEA_COBBLE = new BlockRock("sea_cobble", Material.ROCK, 1.85F, true);
	//public static final Block DEEPSEA_COBBLE = new BlockRock("deepsea_cobble", Material.ROCK, 2.2F, true);
	public static final Block POLISHED_SEASTONE = new BlockRock("p_sea_stone", Material.ROCK, 2.2F, true);
	public static final Block POLISHED_DEEPSEASTONE = new BlockRock("p_deepsea_stone", Material.ROCK, 2.2F, true);
	
	//Ores
	public static final Block DEEPSEA_GOLDORE = new BlockSeaGOre("deepsea_goldore", Material.ROCK, true);
	public static final Block SEA_GOLDORE = new BlockSeaGOre("sea_goldore", Material.ROCK, false);
	
	//Temple
	public static final Block CARVED_PRISMARINE_EYE = new BlockRuin("carved_eye", Material.ROCK);
	//public static final Block RUNIC_PRISMARINE_EYE = new BlockRuin("runic_eye", Material.ROCK);
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
	
	//Fluids
	//public static final Block DARK_WATER = new BlockDarkwaterFluid();
}
