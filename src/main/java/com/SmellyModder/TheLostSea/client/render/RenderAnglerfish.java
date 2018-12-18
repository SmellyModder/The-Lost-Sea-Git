package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.layer.LayerGlow;
import com.SmellyModder.TheLostSea.client.model.ModelAnglerfish;
import com.SmellyModder.TheLostSea.client.model.ModelVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAnglerfish extends RenderLiving<EntityAnglerfish> {

    public static final ResourceLocation[] TEXTURES = new ResourceLocation[]{new ResourceLocation(Reference.MOD_ID + ":textures/entity/anglerfish/anglerfish_b.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/anglerfish/anglerfish_g.png")};

    public RenderAnglerfish(RenderManager manager) {
        super(manager, new ModelAnglerfish(), 0.4F);
        this.addLayer(new LayerGlow<EntityAnglerfish>(this, new ResourceLocation("thelostsea:textures/entity/layer/anglerfish_overlay.png")));
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityAnglerfish entity) {
		return TEXTURES[entity.getVariant()];
	}
	
	@Override
	protected void preRenderCallback(EntityAnglerfish entity, float f) {
		GL11.glTranslatef(0F, 0.5F, 0F);
		if(entity.isFlipped) {
			if (!entity.isInWater()) {
			GL11.glRotatef(90F, 0F, 0F, 1F);
			GL11.glTranslatef(-0.7F, 0.7F, 0F);
			}
		}
	}
}