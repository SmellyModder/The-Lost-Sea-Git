package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IStepGetterN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.StepProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class CoinEventHandler {

	@SubscribeEvent 
	public void onPlayerLogsIn(PlayerLoggedInEvent event) 
	{ 
		EntityPlayer player = event.player; 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageCoins(coins.getCoins()), (EntityPlayerMP) player);
		}
	}
	
	@SubscribeEvent
	public void onPlayerTravelLS(PlayerChangedDimensionEvent event) {
		int ID = event.toDim;
		EntityPlayer player = event.player;
		if(ID == -9) {
		}
	}
	
	@SubscribeEvent 
	public void onPlayerClone(PlayerEvent.Clone event) 
	{ 
		EntityPlayer player = event.getEntityPlayer(); 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		ICurrency coins_ad = event.getOriginal().getCapability(CoinProvider.COIN_CAP, null); 
		coins.set(coins_ad.getCoins()); 
		
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		IDialogueNurm dataNPC_AD = event.getOriginal().getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		dataNPC.setVerse(dataNPC_AD.getVerse());
		
		IStepGetterN dataNPC2 = player.getCapability(StepProviderN.CAP_S, null); 
		IStepGetterN dataNPC2_AD = event.getOriginal().getCapability(StepProviderN.CAP_S, null); 
		dataNPC2.setStep(dataNPC2_AD.getStep());
	}
	
	@SubscribeEvent 
	public void onPlayerTick(PlayerTickEvent event) 
	{ 
		EntityPlayer player = event.player; 
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
		
		if(coins.getCoins() > 9999999) {
			coins.set(9999999);
		}
	}
}
