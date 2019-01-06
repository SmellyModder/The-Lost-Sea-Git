package com.SmellyModder.TheLostSea.core.util.handlers;

import com.SmellyModder.TheLostSea.client.render.RenderAnglerfish;
import com.SmellyModder.TheLostSea.client.render.RenderCoin;
import com.SmellyModder.TheLostSea.client.render.RenderDisc;
import com.SmellyModder.TheLostSea.client.render.RenderFinnedArrow;
import com.SmellyModder.TheLostSea.client.render.RenderFinnedTestArrow;
import com.SmellyModder.TheLostSea.client.render.RenderJellyfish;
import com.SmellyModder.TheLostSea.client.render.RenderOrb;
import com.SmellyModder.TheLostSea.client.render.RenderShark;
import com.SmellyModder.TheLostSea.client.render.RenderSlash;
import com.SmellyModder.TheLostSea.client.render.RenderSubmarine;
import com.SmellyModder.TheLostSea.client.render.RenderSubmarineII;
import com.SmellyModder.TheLostSea.client.render.RenderTorpedo;
import com.SmellyModder.TheLostSea.client.render.RenderTriGuardian;
import com.SmellyModder.TheLostSea.client.render.RenderVampireSquid;
import com.SmellyModder.TheLostSea.client.render.atlantis.RenderTitan;
import com.SmellyModder.TheLostSea.client.render.npc.RenderLunete;
import com.SmellyModder.TheLostSea.client.render.npc.RenderNurm;
import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.bases.ThrowableOrb;
import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityLunete;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityNurm;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityJellyfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrow;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrowTest;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntitySlash;
import com.SmellyModder.TheLostSea.common.entity.raid.EntityTitanGuardian;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineII;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntityTorpedo;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTriGuardian.class, new IRenderFactory<EntityTriGuardian>()
		{
			
			@Override
			public Render<? super EntityTriGuardian> createRenderFor(RenderManager manager){
				
				return new RenderTriGuardian(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVampireSquid.class, new IRenderFactory<EntityVampireSquid>()
		{
			
			@Override
			public Render<? super EntityVampireSquid> createRenderFor(RenderManager manager){
				
				return new RenderVampireSquid(manager);
			
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFinnedArrow.class, new IRenderFactory<EntityFinnedArrow>()
		{
			
			@Override
			public Render<? super EntityFinnedArrow> createRenderFor(RenderManager manager){
				
				return new RenderFinnedArrow<>(manager);
				
			}
			
		});
		
		/*RenderingRegistry.registerEntityRenderingHandler(EntityFinnedArrowTest.class, new IRenderFactory<EntityFinnedArrowTest>()
		{
			
			@Override
			public Render<? super EntityFinnedArrowTest> createRenderFor(RenderManager manager){
				
				return new RenderFinnedTestArrow(manager);
				
			}
			
		});*/
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySubmarineI.class, new IRenderFactory<EntitySubmarineI>()
		{
			
			@Override
			public Render<? super EntitySubmarineI> createRenderFor(RenderManager manager){
				
				return new RenderSubmarine(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySubmarineII.class, new IRenderFactory<EntitySubmarineII>()
		{
			
			@Override
			public Render<? super EntitySubmarineII> createRenderFor(RenderManager manager){
				
				return new RenderSubmarineII(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, new IRenderFactory<EntityJellyfish>()
		{
			
			@Override
			public Render<? super EntityJellyfish> createRenderFor(RenderManager manager){
				
				return new RenderJellyfish(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(ThrowableOrb.class, new IRenderFactory<ThrowableOrb>()
		{
			
			@Override
			public Render<? super ThrowableOrb> createRenderFor(RenderManager manager){
				
				return new RenderOrb(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTorpedo.class, new IRenderFactory<EntityTorpedo>()
		{
			
			@Override
			public Render<? super EntityTorpedo> createRenderFor(RenderManager manager){
				
				return new RenderTorpedo(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDisc.class, new IRenderFactory<EntityDisc>()
		{
			
			@Override
			public Render<? super EntityDisc> createRenderFor(RenderManager manager){
				
				return new RenderDisc(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAnglerfish.class, new IRenderFactory<EntityAnglerfish>()
		{
			
			@Override
			public Render<? super EntityAnglerfish> createRenderFor(RenderManager manager){
				
				return new RenderAnglerfish(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new IRenderFactory<EntityShark>()
		{
			
			@Override
			public Render<? super EntityShark> createRenderFor(RenderManager manager){
				
				return new RenderShark(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTitanGuardian.class, new IRenderFactory<EntityTitanGuardian>()
		{
			
			@Override
			public Render<? super EntityTitanGuardian> createRenderFor(RenderManager manager){
				
				return new RenderTitan(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNurm.class, new IRenderFactory<EntityNurm>()
		{
			@Override
			public Render<? super EntityNurm> createRenderFor(RenderManager manager){
				
				return new RenderNurm(manager);
				
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityLunete.class, new IRenderFactory<EntityLunete>()
		{
			@Override
			public Render<? super EntityLunete> createRenderFor(RenderManager manager){
				
				return new RenderLunete(manager);
				
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySlash.class, new IRenderFactory<EntitySlash>()
		{
			@Override
			public Render<? super EntitySlash> createRenderFor(RenderManager manager){
				
				return new RenderSlash(manager);
				
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityAtlantisCoin.class, new IRenderFactory<EntityAtlantisCoin>()
		{
			@Override
			public Render<? super EntityAtlantisCoin> createRenderFor(RenderManager manager){
				
				return new RenderCoin(manager);
				
			}
		});
}
}
