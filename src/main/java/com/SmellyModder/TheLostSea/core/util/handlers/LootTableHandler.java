package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	
	public static final ResourceLocation ANGLER_FISH = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "angler_fish"));
	public static final ResourceLocation SHARK = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "shark"));
}
