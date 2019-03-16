package com.SmellyModder.TheLostSea.core.util.player.events;

import com.SmellyModder.TheLostSea.common.blocks.plants.BlockCoconut;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumSword;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerBreakEvents {
	
	@SubscribeEvent
	public void doCoconutDrops(HarvestDropsEvent event) {
		EntityPlayer player = event.getHarvester();
		World world = event.getWorld();
		Block block = event.getState().getBlock();
		IBlockState state = event.getState();
		
		if (world.isRemote || block != TLSBlocks.COCONUT || ((Integer)state.getValue(BlockCoconut.AGE)).intValue() != 2 || player == null) return;
		
		ItemStack stack = player.getHeldItemMainhand();
		ItemStack chunks = new ItemStack(TLSItems.COCONUT_CHUNK);
		ItemStack coconut = new ItemStack(TLSBlocks.COCONUT_ITEMBLOCK);
		
		if(stack != null && isSword(stack.getItem())) {
			world.setBlockToAir(event.getPos());
			
			for (int i = 0; i < world.rand.nextInt(4) + 2; i++)
			if(!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
				EntityItem entityitem = new EntityItem(world, (double)event.getPos().getX() + world.rand.nextFloat() * 0.65F, event.getPos().getY() + world.rand.nextFloat() * 0.65F, event.getPos().getZ() + world.rand.nextFloat() * 0.65F, chunks);
				entityitem.setPickupDelay(world.rand.nextInt(6) + 4);
				world.spawnEntity(entityitem);
			}
			
		} else if(stack != null && !isSword(stack.getItem())) {
			world.setBlockToAir(event.getPos());
			
			if(!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
				EntityItem entityitem = new EntityItem(world, (double)event.getPos().getX() + world.rand.nextFloat() * 0.65F, event.getPos().getY() + world.rand.nextFloat() * 0.65F, event.getPos().getZ() + world.rand.nextFloat() * 0.65F, coconut);
				entityitem.setPickupDelay(world.rand.nextInt(6) + 4);
				world.spawnEntity(entityitem);
			}
		}
	}
	
	@SubscribeEvent
	public void doCoconutDrops2(HarvestDropsEvent event) {
		EntityPlayer player = event.getHarvester();
		World world = event.getWorld();
		Block block = event.getState().getBlock();
		
		if (world.isRemote || block != TLSBlocks.COCONUT_ITEMBLOCK || player == null) return;
		
		ItemStack stack = player.getHeldItemMainhand();
		ItemStack chunks = new ItemStack(TLSItems.COCONUT_CHUNK);
		ItemStack coconut = new ItemStack(TLSBlocks.COCONUT_ITEMBLOCK);
		
		if(stack != null && isSword(stack.getItem())) {
			world.setBlockToAir(event.getPos());
			
			for (int i = 0; i < world.rand.nextInt(4) + 2; i++)
			if(!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
				EntityItem entityitem = new EntityItem(world, (double)event.getPos().getX() + world.rand.nextFloat() * 0.65F, event.getPos().getY() + world.rand.nextFloat() * 0.65F, event.getPos().getZ() + world.rand.nextFloat() * 0.65F, chunks);
				entityitem.setPickupDelay(world.rand.nextInt(6) + 4);
				world.spawnEntity(entityitem);
			}
			
		} else if(stack != null && !isSword(stack.getItem())) {
			world.setBlockToAir(event.getPos());
			
			if(!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
				EntityItem entityitem = new EntityItem(world, (double)event.getPos().getX() + world.rand.nextFloat() * 0.65F, event.getPos().getY() + world.rand.nextFloat() * 0.65F, event.getPos().getZ() + world.rand.nextFloat() * 0.65F, coconut);
				entityitem.setPickupDelay(world.rand.nextInt(6) + 4);
				world.spawnEntity(entityitem);
			}
		}
	}
	
	boolean isSword(Item item) {
		return item instanceof ItemSword || item instanceof ItemNeptunumSword; 
	}
 }
