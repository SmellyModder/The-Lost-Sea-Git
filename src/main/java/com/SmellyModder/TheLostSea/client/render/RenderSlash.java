package com.SmellyModder.TheLostSea.client.render;

import com.SmellyModder.TheLostSea.client.model.ModelDisc;
import com.SmellyModder.TheLostSea.client.model.ModelSlash;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntitySlash;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSlash extends Render<EntitySlash>{
	
	private static final ResourceLocation TEXTURES = new ResourceLocation("yuh");
	private static final ResourceLocation DISC = new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc_p.png");
	private ModelSlash model = new ModelSlash();
	
	public RenderSlash(RenderManager manager) {
		super(manager);
	}

	protected ResourceLocation getEntityTexture(EntitySlash entity)
    {
        return TEXTURES;
    }
	
	public void doRender(EntitySlash entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		float f1 = (float)entity.ticksExisted;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y - 0.65F, (float)z);
        this.bindEntityTexture(entity);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.model.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
