package com.SmellyModder.TheLostSea.core.packets;

import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestCoins implements IMessage{

	public MessageRequestCoins() {
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}
	
	public static class HandleRequestCoins implements IMessageHandler<MessageRequestCoins, MessageCoins>{

		@Override
		public MessageCoins onMessage(MessageRequestCoins message, MessageContext ctx) {
			
			EntityPlayerMP mp = ctx.getServerHandler().player;
			ICurrency coins = mp.getCapability(CoinProvider.COIN_CAP, null);
			return new MessageCoins(coins.getCoins());
		}
	}

}
