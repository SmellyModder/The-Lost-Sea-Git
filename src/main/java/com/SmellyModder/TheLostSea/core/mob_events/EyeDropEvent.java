package com.SmellyModder.TheLostSea.core.mob_events;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EyeDropEvent {
	
		Random rand = new Random();
	    @SubscribeEvent
	    public void onMobDrops(LivingDropsEvent event)
	    {
	        if (event.getEntity() instanceof EntityElderGuardian)
	        {
	        	World world = event.getEntity().getEntityWorld();
	            event.getDrops().clear();
	            
	            ItemStack stack = new ItemStack(TLSItems.ELDER_EYE);
	            EntityItem drop = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
	            event.getDrops().add(drop);
	            
	            Entity e = event.getEntity();
	            
	        	int i = e.getPosition().getX();
				int j = e.getPosition().getY();
				int k = e.getPosition().getZ();
	            EntityAtlantisCoin coin = new EntityAtlantisCoin(world);
	            EntityAtlantisCoin coin2 = new EntityAtlantisCoin(world);
	            EntityAtlantisCoin coin3 = new EntityAtlantisCoin(world);
	            EntityAtlantisCoin coin4 = new EntityAtlantisCoin(world);
	            EntityAtlantisCoin coin5 = new EntityAtlantisCoin(world);
	            EntityAtlantisCoin coin6 = new EntityAtlantisCoin(world);
	            
	            if (coin != null && !world.isRemote){
	            	 coin.setLocationAndAngles(i, j + 2, k, world.rand.nextFloat() * 360F, 0.0F);
	            	 coin.setCoinType(EntityAtlantisCoin.Size.SMALL);
	            	 world.spawnEntity(coin);
	            	 coin2.setLocationAndAngles(i, j + 2, k, world.rand.nextFloat() * 360F, 0.0F);
	            	 world.spawnEntity(coin2);
	            	 coin3.setLocationAndAngles(i, j + 2, k, world.rand.nextFloat() * 360F, 0.0F);
	            	 world.spawnEntity(coin3);
	            }
	    }}
	    
}
