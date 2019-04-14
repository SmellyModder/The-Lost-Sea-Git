package com.SmellyModder.TheLostSea.common.world.overworld.handler;

import com.SmellyModder.TheLostSea.common.world.overworld.village.VillageGenNurmShop;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class LSVillageHandler {
	private static final VillagerRegistry VILLAGER_REGISTRY = VillagerRegistry.instance();

	public static void initNurmShop() {
		VILLAGER_REGISTRY.registerVillageCreationHandler(new VillageGenNurmShop.VillageManager());
		MapGenStructureIO.registerStructureComponent(VillageGenNurmShop.class, Reference.MOD_ID + ":nurm_shop");
	}
}
