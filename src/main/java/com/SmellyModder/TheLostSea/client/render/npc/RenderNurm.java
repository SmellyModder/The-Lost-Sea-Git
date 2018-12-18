package com.SmellyModder.TheLostSea.client.render.npc;

import com.SmellyModder.TheLostSea.client.model.npc.ModelNurm;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityNurm;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNurm extends RenderLiving<EntityNurm>{
	
	private static final ResourceLocation NURM = new ResourceLocation(Reference.MOD_ID + ":textures/entity/npc/nurm_n.png");
	public RenderNurm(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelNurm(), 0.45F);
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityNurm entity) {
		return NURM;
	}
}
