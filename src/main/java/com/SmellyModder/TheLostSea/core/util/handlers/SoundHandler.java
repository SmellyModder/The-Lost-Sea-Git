package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

public static SoundEvent SONAR_WAVE;
	
	public static void registerSounds() {
		
		//Vehicle
		SONAR_WAVE = registerSound("entity.submarine.sonar");
		
	}
	
	public static SoundEvent registerSound(String name) {
		
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
