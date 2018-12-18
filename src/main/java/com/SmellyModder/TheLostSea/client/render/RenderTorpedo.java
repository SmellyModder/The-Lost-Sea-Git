package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.model.ModelTorpedo;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntityTorpedo;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTorpedo extends Render<EntityTorpedo>{
	
	private static final ResourceLocation TORPEDO = new ResourceLocation(Reference.MOD_ID + ":textures/entity/torpedo_entity.png");
	private ModelTorpedo model = new ModelTorpedo();
	
	public RenderTorpedo(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTorpedo entity) {
		return TORPEDO;
	}
	
	@Override
	public void doRender(EntityTorpedo entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GL11.glPushMatrix();
		bindTexture(TORPEDO);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
		GL11.glPopMatrix();
	}

}
