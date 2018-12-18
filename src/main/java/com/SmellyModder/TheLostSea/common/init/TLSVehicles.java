package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineII;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class TLSVehicles {

	public static void registerVehicles() {
		registerVehicle("submarine", EntitySubmarineI.class, Reference.SUBMARINE, 50);
		registerVehicle("submarineII", EntitySubmarineII.class, Reference.SUBMARINEII, 50);
	}
	
	private static void registerVehicle(String entityName, Class<? extends Entity> entityClass, int id, int range) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + entityName), entityClass, entityName, id, TheLostSea.instance, range, 1, true);
		
	}
}
