package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.world.LSWorldProvider;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {


	public static final DimensionType LS = DimensionType.register(Reference.MOD_ID, "_lostsea", Config.DIM_ID, LSWorldProvider.class, false);
	
	public static void registerDimensions() {
		DimensionManager.registerDimension(Config.DIM_ID, LS);
	}
	
}
