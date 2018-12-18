package com.SmellyModder.TheLostSea.client.handlers;


import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class KeyBindHandler {
	
	public static KeyBinding BOOST_SEAHORSE = new KeyBinding("key.glide", Keyboard.KEY_G, Reference.MOD_ID);

	public KeyBindHandler() {
		ClientRegistry.registerKeyBinding(BOOST_SEAHORSE);
	}

	@SubscribeEvent
	public void onKey(KeyInputEvent e) {
		
	}
}
