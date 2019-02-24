package com.SmellyModder.TheLostSea.core.util.player.events;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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
		
		if (world.isRemote || block != TLSBlocks.PALM_LOG || player == null) return;
		
		ItemStack stack = player.getHeldItemMainhand();
		
		if(stack != null && stack.getItem() instanceof ItemSword) {
			
			world.setBlockToAir(event.getPos());
			
			if(world.getGameRules().getBoolean("doTileDrops")) {
				EntityItem entityitem = new EntityItem(world, (double)event.getPos().getX() + world.rand.nextFloat() * 0.65F, event.getPos().getY() + world.rand.nextFloat() * 0.65F, event.getPos().getZ() + world.rand.nextFloat() * 0.65F, stack);
				entityitem.setPickupDelay(world.rand.nextInt(6) + 4);
				world.spawnEntity(entityitem);
			}
		}
	}
}
