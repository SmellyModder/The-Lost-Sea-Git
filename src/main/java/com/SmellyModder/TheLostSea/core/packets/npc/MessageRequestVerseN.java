package com.SmellyModder.TheLostSea.core.packets.npc;

import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestVerseN implements IMessage{

	public MessageRequestVerseN() {
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}
	
	public static class HandleRequestVerse implements IMessageHandler<MessageRequestVerseN, MessageVerseN>{

		@Override
		public MessageVerseN onMessage(MessageRequestVerseN message, MessageContext ctx) {
			
			EntityPlayerMP mp = ctx.getServerHandler().player;
			IDialogueNurm dataNPC = mp.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
			return new MessageVerseN(dataNPC.getVerse());
		}
	}
	

}
