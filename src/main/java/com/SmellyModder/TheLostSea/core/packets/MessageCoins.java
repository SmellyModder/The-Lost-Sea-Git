package com.SmellyModder.TheLostSea.core.packets;

import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;

import akka.io.Tcp.Message;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCoins implements IMessage{

	int coin;
	public MessageCoins() {
	}
	
	public MessageCoins(int coins) {
		coin = coins;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		coin = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(coin);
	}

	public static class HandleMessageCoins implements IMessageHandler<MessageCoins, IMessage>{

		@Override
		public IMessage onMessage(MessageCoins message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(() -> {
				Minecraft.getMinecraft().player.getCapability(CoinProvider.COIN_CAP, null).set(message.coin);
				
			});
				
			return null;
		}
	}
}
