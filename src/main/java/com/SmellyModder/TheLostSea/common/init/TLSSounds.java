package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TLSSounds {
	
public static SoundEvent ENTITY_TITAN_IDLE, ENTITY_TITAN_DEATH, ENTITY_TITAN_STEP, ENTITY_TITAN_ATTACK, PAGE_FLIP, BOOK_OPEN, BOOK_CLOSE, PORTAL_AMBIENT, PORTAL_AMBIENT_2,
		PORTAL_OPENING, AEGAEON_LAUGH, ANGLER_BITE, BOIL1, BOIL2, COIN_COLLECT;
	
	public static void registerSounds() {
		
		//Titan
		ENTITY_TITAN_IDLE = registerSound("entity.titan.idle");
		ENTITY_TITAN_DEATH = registerSound("entity.titan.death");
		ENTITY_TITAN_STEP = registerSound("entity.titan.step");
		ENTITY_TITAN_ATTACK = registerSound("entity.titan.attack");
		
		PAGE_FLIP = registerSound("item.pageflip");
		BOOK_OPEN = registerSound("item.bookopen");
		BOOK_CLOSE = registerSound("item.bookclose");
		
		//Temples
		PORTAL_AMBIENT = registerSound("ambient.portal_1");
		PORTAL_AMBIENT_2 = registerSound("ambient.portal_2");
		PORTAL_OPENING = registerSound("ambient.portal_open");
		AEGAEON_LAUGH = registerSound("ambient.portal_laugh");
		
		//Boil
		BOIL1 = registerSound("block.boil_1");
		BOIL2 = registerSound("block.boil_2");
		
		//Attacks
		ANGLER_BITE = registerSound("entity.anglerbite");
		
		//Coins
		COIN_COLLECT = registerSound("entity.coin.collect");
	}
	
	public static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
	
}
