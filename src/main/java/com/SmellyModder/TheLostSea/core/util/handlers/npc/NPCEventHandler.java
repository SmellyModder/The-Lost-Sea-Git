package com.SmellyModder.TheLostSea.core.util.handlers.npc;

import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IStepGetterN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.StepProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class NPCEventHandler {

	@SubscribeEvent 
	public void onPlayerLogsIn(PlayerLoggedInEvent event) 
	{ 
		EntityPlayer player = event.player; 
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
		IStepGetterN dataNPC2 = player.getCapability(StepProviderN.CAP_S, null);
		if(player instanceof EntityPlayerMP) {
			TheLostSea.NETWORK.sendTo(new MessageVerseN(dataNPC.getVerse()), (EntityPlayerMP) player);
		}
	}
}
