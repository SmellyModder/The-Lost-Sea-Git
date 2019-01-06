package com.SmellyModder.TheLostSea.core.mob_events;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FinDropEvent {
	
		Random rand = new Random();
	    @SubscribeEvent
	    public void onMobDrops(LivingDropsEvent event)
	    {
	        if (event.getEntity() instanceof EntityGuardian && rand.nextInt(4) <= 2)
	        {
	        	World world = event.getEntity().getEntityWorld();
	            
	            ItemStack stack = new ItemStack(TLSItems.GUARDIAN_FIN);
	            EntityItem drop = new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
	            event.getDrops().add(drop);
	    }}
	    
	    
}
