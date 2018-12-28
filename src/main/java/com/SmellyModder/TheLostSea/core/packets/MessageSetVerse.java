package com.SmellyModder.TheLostSea.core.packets;

import com.SmellyModder.TheLostSea.core.packets.npc.MessageRequestVerseN;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSetVerse implements IMessage {

	protected int verse;

	public MessageSetVerse(int verse) {
		this.verse = verse;
	}

	public MessageSetVerse() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.verse = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.verse);
	}

	public static class HandleMessageSetVerse implements IMessageHandler<MessageSetVerse, IMessage> {

		@Override
		public IMessage onMessage(MessageSetVerse message, MessageContext ctx) {

			EntityPlayerMP mp = ctx.getServerHandler().player;
			IDialogueNurm dataNPC = mp.getCapability(DialogueProviderN.DIALOGUE_CAP, null);
			dataNPC.setVerse(message.verse);
			return null;
		}
	}
}
