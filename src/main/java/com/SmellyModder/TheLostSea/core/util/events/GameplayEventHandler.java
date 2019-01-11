package com.SmellyModder.TheLostSea.core.util.events;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class GameplayEventHandler {

	@SubscribeEvent
	public void onBrineTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
	}
}
