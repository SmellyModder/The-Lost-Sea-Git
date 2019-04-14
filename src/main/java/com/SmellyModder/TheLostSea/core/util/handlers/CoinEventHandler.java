package com.SmellyModder.TheLostSea.core.util.handlers;

import java.io.IOException;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class CoinEventHandler{
	@SubscribeEvent 
	public void onPlayerLogsIn(PlayerLoggedInEvent event) { 
		EntityPlayer player = event.player; 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageCoins(coins.getCoins()), (EntityPlayerMP) player);
			TheLostSea.NETWORK.sendTo(new MessageVerseN(dataNPC.getVerse()), (EntityPlayerMP) player);
		}
	}
	
	
	@SubscribeEvent
	public void onPlayerTravelLS(PlayerChangedDimensionEvent event) {
		int ID = event.toDim;
		EntityPlayer player = event.player;
		ICurrency coins2 = player.getCapability(CoinProvider.COIN_CAP, null); 

		if(ID == -9) {
			if(player instanceof EntityPlayerMP) {
				TheLostSea.NETWORK.sendTo(new MessageCoins(coins2.getCoins()), (EntityPlayerMP) player);
			}
		}
	}
	
	@SubscribeEvent 
	public void onPlayerClone(PlayerEvent.Clone event) { 
		EntityPlayer player = event.getEntityPlayer(); 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		ICurrency coins_ad = event.getOriginal().getCapability(CoinProvider.COIN_CAP, null); 
		coins.set(coins_ad.getCoins()); 
		
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		IDialogueNurm dataNPC_AD = event.getOriginal().getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		dataNPC.setVerse(dataNPC_AD.getVerse());
	}
	
	@SubscribeEvent 
	public void onPlayerTick(PlayerTickEvent event) { 
		EntityPlayer player = event.player; 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		
		
		if(coins.getCoins() > 9999999) {
			coins.set(9999999);
		}
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageCoins(coins.getCoins()), (EntityPlayerMP) player);
		}
	}
	
	@SubscribeEvent
	public void onGuardianTick(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof EntityGuardian && event.getEntity().dimension == -9) {
			((EntityGuardian)event.getEntity()).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 10E10, 1));
		}
	}
}
