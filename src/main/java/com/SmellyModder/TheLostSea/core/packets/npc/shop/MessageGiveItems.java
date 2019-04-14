package com.SmellyModder.TheLostSea.core.packets.npc.shop;

import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGiveItems implements IMessage{
	
	private ItemStack stack;
	private int playerId;
	private int amount;
	public MessageGiveItems(EntityPlayer player, Item stack, int amount) {
		this.stack = new ItemStack(stack, amount);
		this.playerId = player.getEntityId();
		this.amount = amount;
	}
	
	public MessageGiveItems() {
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(playerId);
		buf.writeInt(amount);
		ByteBufUtils.writeItemStack(buf, stack);
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		playerId = buf.readInt();
		amount = buf.readInt();
		stack = ByteBufUtils.readItemStack(buf);
	}

	public static class HandleGiveItems implements IMessageHandler<MessageGiveItems, IMessage>{

		@Override
		public IMessage onMessage(MessageGiveItems message, MessageContext ctx) {
			EntityPlayerMP mp = ctx.getServerHandler().player;
			World world = mp.getEntityWorld();
			if (world == null) {
				
			} else {
				Entity p = world.getEntityByID(message.playerId);
				if (p != null && p instanceof EntityPlayer) {
					((EntityPlayer)p).inventory.addItemStackToInventory(message.stack);
				}
			}
			return null;
		}
	}
	
}
