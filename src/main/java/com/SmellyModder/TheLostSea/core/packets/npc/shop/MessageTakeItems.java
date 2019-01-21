package com.SmellyModder.TheLostSea.core.packets.npc.shop;

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

public class MessageTakeItems implements IMessage{

	private ItemStack stack;
	private int playerId;
	private int amount;
	public MessageTakeItems(EntityPlayer player, Item stack, int amount) {
		this.stack = new ItemStack(stack, amount);
		this.playerId = player.getEntityId();
		this.amount = amount;
	}
	
	public MessageTakeItems() {
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
	
	public static class HandleTakeItems implements IMessageHandler<MessageTakeItems, IMessage>{

		@Override
		public IMessage onMessage(MessageTakeItems message, MessageContext ctx) {
			EntityPlayerMP mp = ctx.getServerHandler().player;
			World world = mp.getEntityWorld();
			if (world == null) {
				
			} else {
				Entity p = world.getEntityByID(message.playerId);
				if (p != null && p instanceof EntityPlayer) {
					ItemStack itemstack = this.findItem(((EntityPlayer)p), message.stack.getItem());
					itemstack.shrink(message.amount);
				}
			}
			return null;
	 }
		
		private ItemStack findItem(EntityPlayer player, Item item)
		{
         for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
         {
             ItemStack itemstack = player.inventory.getStackInSlot(i);

             if (itemstack.getItem() == item)
             {
                 return itemstack;
             }
         }
         return ItemStack.EMPTY;
		}
	}
}
