package com.SmellyModder.TheLostSea.core.util.client_events;

import com.SmellyModder.TheLostSea.common.item.ItemBase;

import com.SmellyModder.TheLostSea.common.item.specialtools.ItemBowBase;
import com.SmellyModder.TheLostSea.common.item.tools.cobalt.ItemCobaltAxe;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class FovUpdater {

	@SubscribeEvent
	public static void fovUpdate(FOVUpdateEvent event) {
		if (event.getEntity().isHandActive() && (event.getEntity().getHeldItem(event.getEntity().getActiveHand()).getItem() instanceof ItemBowBase)) {
			int i = event.getEntity().getItemInUseCount();
			float f1 = (float) i / 20.0F;

			f1 = (float)(event.getEntity().getHeldItem(event.getEntity().getActiveHand()).getMaxItemUseDuration() - event.getEntity().getItemInUseCount()) / 20.0F;

	        if (f1 > 1.0F)
	        {
	            f1 = 1.0F;
	        }

			event.setNewfov(event.getNewfov() * (1.0F - f1 * 0.15F));
		}
	}
}
