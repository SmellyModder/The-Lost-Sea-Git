package com.SmellyModder.TheLostSea.core.util.player.events;

import java.util.Random;

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
	public void registerHarvestDrops(HarvestDropsEvent event) {}
	
	public static void doBlockDrop(World world, int x, int y, int z, ItemStack stack) {
		Random rand = world.rand;
		if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
			float f = 0.6F;
			double D = (rand.nextFloat() * f) + (double)(1.0F - f) * 0.6D;
			double D2 = (rand.nextFloat() * f) + (double)(1.0F - f) * 0.6D;
			double D3 = (rand.nextFloat() * f) + (double)(1.0F - f) * 0.6D;
			EntityItem entityitem = new EntityItem(world, (double)x + D, (double)y + D2, (double)z + D3, stack);
			entityitem.setPickupDelay(10);
			world.spawnEntity(entityitem);
		}
	}
	
	public static boolean isSword(Item item) {
		return item instanceof ItemSword || item instanceof ItemNeptunumSword; 
	}
}
