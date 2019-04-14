package com.SmellyModder.TheLostSea.core.packets.npc;

import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageVerseN implements IMessage{

	int verse;
	public MessageVerseN() {
	}
	
	public MessageVerseN(int verse) {
		this.verse = verse;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.verse = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(verse);
	}

	public static class HandleMessageVerse implements IMessageHandler<MessageVerseN, IMessage>{

		@Override
		public IMessage onMessage(MessageVerseN message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(() -> {
				Minecraft.getMinecraft().player.getCapability(DialogueProviderN.DIALOGUE_CAP, null).setVerse(message.verse);
				
			});
				
			return null;
		}
	}

}
