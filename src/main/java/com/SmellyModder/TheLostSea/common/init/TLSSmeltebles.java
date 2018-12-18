package com.SmellyModder.TheLostSea.common.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TLSSmeltebles {

	public static void init() {
		GameRegistry.addSmelting(TLSItems.ANGLER_FISH, new ItemStack(TLSItems.ANGLER_FISHC, 1), 1.1F);
		GameRegistry.addSmelting(TLSBlocks.SEA_GOLDORE, new ItemStack(Items.GOLD_INGOT, 1), 1.3F);
		GameRegistry.addSmelting(TLSBlocks.DEEPSEA_GOLDORE, new ItemStack(Items.GOLD_INGOT, 1), 1.3F);
	}
}
