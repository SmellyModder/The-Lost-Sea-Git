package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.bases.ThrowableOrb;
import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityLunete;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityNurm;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityJellyfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrow;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntitySlash;
import com.SmellyModder.TheLostSea.common.entity.raid.EntityTitanGuardian;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class TLSEntities {
	
	public static void registerEntities() {
		//Guardian's
		registerEntity("tri_guardian", EntityTriGuardian.class, Reference.ENTITY_TRIGUARDIAN, 50, 5931634, 3095382);
		registerEntity("titan_guardian", EntityTitanGuardian.class, Reference.ENTITY_TITAN, 50, 5931634, 7811851);
		
		//Squids
		registerEntity("vampire_squid", EntityVampireSquid.class, Reference.ENTITY_VSQUID, 50, 2243405, 14356009);
		
		//Common
		registerEntity("jellyfish", EntityJellyfish.class, Reference.ENTITY_JELLYFISH, 50, 3115775, 3115651);
		registerEntity("shark", EntityShark.class, Reference.ENTITY_SHARK, 50, 9871003, 2895945);
		
		//Dark Creatures
		registerEntity("anglerfish", EntityAnglerfish.class, Reference.ENTITY_ANGLER, 50, 6659840, 3142143);
	}
	
	//Registers stuff that has no egg
	public static void registerEntities2() {
		registerEntity2("throwableorb", ThrowableOrb.class, Reference.ORB, 50);
		registerEntity2("disc", EntityDisc.class, Reference.DISC, 50);
		registerEntity2("slash_hook", EntitySlash.class, Reference.CUTLASS, 50);
		registerEntity2("nurm", EntityNurm.class, Reference.NURM, 50);
		registerEntity2("lunete", EntityLunete.class, Reference.LUNETE, 50);
		registerEntity2("doubloon", EntityAtlantisCoin.class, 9875, 50);
		registerEntity2("finnedarrow", EntityFinnedArrow.class, Reference.FINNEDARROW, 50);
	}
	
	private static void registerEntity2(String entityName, Class<? extends Entity> entityClass, int id, int range) {
		
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + entityName), entityClass, entityName, id, TheLostSea.instance, range, 1, true);
		
		
	}
	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TheLostSea.instance, range, 1, true, color1, color2);
		
		
	}
}
