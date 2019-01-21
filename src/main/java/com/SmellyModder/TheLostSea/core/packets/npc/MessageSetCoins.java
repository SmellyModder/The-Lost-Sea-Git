package com.SmellyModder.TheLostSea.core.packets.npc;

import com.SmellyModder.TheLostSea.core.packets.MessageSetVerse;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSetCoins implements IMessage {

	protected int coins;

	public MessageSetCoins(int coins) {
		this.coins = coins;
	}

	public MessageSetCoins() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.coins = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.coins);
	}

	public static class HandleMessageSetCoins implements IMessageHandler<MessageSetCoins, IMessage> {

		@Override
		public IMessage onMessage(MessageSetCoins message, MessageContext ctx) {

			EntityPlayerMP mp = ctx.getServerHandler().player;
			ICurrency data = mp.getCapability(CoinProvider.COIN_CAP, null);
			data.set(message.coins);
			return null;
		}
	}

}
