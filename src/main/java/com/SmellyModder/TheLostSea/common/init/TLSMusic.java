package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Reference.MOD_ID)
public class TLSMusic {
	
	public static final SoundEvent PIRATE_CREW = new SoundEvent(new ResourceLocation(Reference.MOD_ID, "pirate_crew")).setRegistryName(new ResourceLocation(Reference.MOD_ID, "pirate_crew"));
	
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class SoundEventRegistration {
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
			final SoundEvent[] sounds = {
					PIRATE_CREW
			};
			
			event.getRegistry().registerAll(sounds);
		}
	}
}