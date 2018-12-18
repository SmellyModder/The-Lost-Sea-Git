package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.common.entity.bases.ThrowableOrb;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderOrb extends Render<ThrowableOrb>{
	
	private static final ResourceLocation ROCK = new ResourceLocation(Reference.MOD_ID + ":textures/entity/rock.png");
	private ModelBook model = new ModelBook();
	
	public RenderOrb(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(ThrowableOrb entity) {
		return ROCK;
	}
	
	@Override
	public void doRender(ThrowableOrb entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GL11.glPushMatrix();
		bindTexture(ROCK);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
		GL11.glPopMatrix();
	}

}
