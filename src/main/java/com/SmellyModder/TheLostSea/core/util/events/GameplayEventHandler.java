package com.SmellyModder.TheLostSea.core.util.events;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.armor.ItemNeptunumArmor;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class GameplayEventHandler {

	@SubscribeEvent
	public void onTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ItemStack boots = player.inventory.armorItemInSlot(0);
		ItemStack chest = player.inventory.armorItemInSlot(2);
		ItemStack legs = player.inventory.armorItemInSlot(1);
		ItemStack helmet = player.inventory.armorItemInSlot(3);
		if ((legs != null) && (legs.getItem() == TLSItems.NEPTUNUM_LEGGINGS) && (helmet != null) && (helmet.getItem() == TLSItems.NEPTUNUM_HELMET) && (chest != null) && (chest.getItem() == TLSItems.NEPTUNUM_CHESTPLATE) && 
	    		(boots != null) && (boots.getItem() == TLSItems.NEPTUNUM_BOOTS)) {
			
			player.getEntityAttribute(player.SWIM_SPEED).setBaseValue(2.2D);
			
		} else {
			player.getEntityAttribute(player.SWIM_SPEED).setBaseValue(1);
		}
	}
	
	public int size(EntityPlayer p) {
		return p.inventory.armorInventory.size();
	}
	protected boolean isNeptunumArmor(ItemStack stack)
    {
        return stack.getItem() instanceof ItemNeptunumArmor;
    }
}
