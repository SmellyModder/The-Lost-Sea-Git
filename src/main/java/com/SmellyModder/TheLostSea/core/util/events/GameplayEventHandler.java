package com.SmellyModder.TheLostSea.core.util.events;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.armor.ItemNeptunumArmor;
import com.SmellyModder.TheLostSea.common.world.overworld.village.VillageGenNurmShop;
import com.SmellyModder.TheLostSea.core.api.capabilites.IOverworldData;
import com.SmellyModder.TheLostSea.core.api.capabilites.LostSeaWorldCapabilties;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.mojang.realmsclient.util.RealmsTasks.WorldCreationTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class GameplayEventHandler {

	@SubscribeEvent
	public void onTick(PlayerTickEvent event) {
//		EntityPlayer player = event.player;
//		ItemStack boots = player.inventory.armorItemInSlot(0);
//		ItemStack chest = player.inventory.armorItemInSlot(2);
//		ItemStack legs = player.inventory.armorItemInSlot(1);
//		ItemStack helmet = player.inventory.armorItemInSlot(3);
//		if ((legs != null) && (legs.getItem() == TLSItems.NEPTUNUM_LEGGINGS) && (helmet != null) && (helmet.getItem() == TLSItems.NEPTUNUM_HELMET) && (chest != null) && (chest.getItem() == TLSItems.NEPTUNUM_CHESTPLATE) && 
//	    		(boots != null) && (boots.getItem() == TLSItems.NEPTUNUM_BOOTS)) {
//			
//			double d0 = 0.0D;
//		    double d1 = 0.02D;
//		    double d2 = 0.0D;
//		    double a = Math.toRadians(player.renderYawOffset);
//		    double dx = -Math.sin(a - 1.5D);
//		    double dz = Math.cos(a - 1.5D);
//		    double dx2 = -Math.sin(a + 1.5D);
//		    double dz2 = Math.cos(a + 1.5D);
//		    player.getEntityWorld().spawnParticle(EnumParticleTypes.WATER_WAKE, player.posX + dx, player.posY + 1.8D, player.posZ + dz, d0, d1, d2, new int[0]);
//		    player.getEntityWorld().spawnParticle(EnumParticleTypes.WATER_WAKE, player.posX + dx2, player.posY + 1.8D, player.posZ + dz2, d0, d1, d2, new int[0]);
//		
		
//		IOverworldData data = event.player.getEntityWorld().getCapability(LostSeaWorldCapabilties.NURM_SHOP_CAP, null); 
//		if(data.getNurmShopGenerated() == 1) {
//			i++;
//			if(i > 25) {
//				data.setNurmShopGenerated(0);
//			}
//		}
	}

}
