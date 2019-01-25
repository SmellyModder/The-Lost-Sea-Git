package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.model.ModelDisc;
import com.SmellyModder.TheLostSea.client.model.ModelJellyfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityJellyfish;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.core.math.LSMathHelper;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;

public class RenderDisc extends Render<EntityDisc>{
	
	private static final ResourceLocation[] TEXTURES = new ResourceLocation[] {new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_p.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_d.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_g.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_i.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_s.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_w.png")
			, new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_v.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc/disc_n.png")};
	private static final ResourceLocation DISC = new ResourceLocation(Reference.MOD_ID + ":textures/entity/disc_p.png");
	private ModelDisc model = new ModelDisc();
	
	public RenderDisc(RenderManager manager) {
		super(manager);
	}
	

	protected ResourceLocation getEntityTexture(EntityDisc entity)
    {
        return TEXTURES[entity.getDiscType().ordinal()];
    }
	
	public void doRender(EntityDisc entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		float f1 = (float)entity.ticksExisted;
		float spin = entity.prevSpin + ((entity.spin - entity.prevSpin) * 2) * partialTicks;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y - 1.05F, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        //GlStateManager.rotate(entity.rotationYaw, (float)x, f1, (float)z);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(spin, 0.0F, 1.0F, 0.0F);
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
