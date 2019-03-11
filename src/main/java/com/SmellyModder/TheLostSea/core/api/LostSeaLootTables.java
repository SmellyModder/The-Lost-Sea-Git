package com.SmellyModder.TheLostSea.core.api;

import org.lwjgl.util.vector.Vector2f;

import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;


public class LostSeaLootTables {
	
	/*
	 * All the loot tables. When adding a new one leave a comment saying what structure/entity it belongs to.
	 */
	public static final ResourceLocation rowChestLoot = register("loot/nurm/rowchest"); //Row chests in Nurm's Shop
	public static final ResourceLocation roofChestLoot = register("loot/nurm/roofchest");// Top of Nurm's Shop
	
	private static ResourceLocation register(String id) {
        return LootTableList.register(new ResourceLocation(Reference.MOD_ID, id));
    }
}
