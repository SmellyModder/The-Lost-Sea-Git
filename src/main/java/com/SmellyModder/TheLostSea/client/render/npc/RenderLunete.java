package com.SmellyModder.TheLostSea.client.render.npc;

import com.SmellyModder.TheLostSea.client.model.npc.ModelLunete;
import com.SmellyModder.TheLostSea.client.model.npc.ModelNurm;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityLunete;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityNurm;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLunete extends RenderLiving<EntityLunete>{
	
	private static final ResourceLocation NURM = new ResourceLocation(Reference.MOD_ID + ":textures/entity/npc/lunete.png");
	public RenderLunete(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelLunete(), 0.45F);
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityLunete entity) {
		return NURM;
	}

}
