package com.SmellyModder.TheLostSea.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityJellyfish;

/**
 * Jellyfish - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelJellyfish extends ModelBase {
    public ModelRenderer BASE;
    public ModelRenderer TOP_B;
    public ModelRenderer TENT_1;
    public ModelRenderer TENT_2;
    public ModelRenderer TENT_3;
    public ModelRenderer TOP_A;
    public ModelRenderer TOP_B_1;

    public ModelJellyfish() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TOP_B = new ModelRenderer(this, 0, 20);
        this.TOP_B.setRotationPoint(-4.5F, -3.5F, -3.5F);
        this.TOP_B.addBox(0.0F, 0.0F, 0.0F, 15, 4, 15, 0.0F);
        this.TOP_A = new ModelRenderer(this, 22, 5);
        this.TOP_A.setRotationPoint(2.5F, -1.5F, 2.5F);
        this.TOP_A.addBox(0.0F, 0.0F, 0.0F, 10, 4, 10, 0.0F);
        this.BASE = new ModelRenderer(this, 0, 0);
        this.BASE.setRotationPoint(-3.0F, 12.0F, -4.0F);
        this.BASE.addBox(-1.0F, 0.0F, 0.0F, 8, 4, 8, 0.0F);
        this.TENT_1 = new ModelRenderer(this, 0, 18);
        this.TENT_1.mirror = true;
        this.TENT_1.setRotationPoint(0.0F, 2.6F, 2.6F);
        this.TENT_1.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(TENT_1, 0.0F, 0.0F, 0.20943951023931953F);
        this.TENT_3 = new ModelRenderer(this, 0, 18);
        this.TENT_3.mirror = true;
        this.TENT_3.setRotationPoint(4.0F, 2.7F, 1.6F);
        this.TENT_3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(TENT_3, -0.27314402793711257F, 0.0F, 0.0F);
        this.TOP_B_1 = new ModelRenderer(this, 0, 39);
        this.TOP_B_1.setRotationPoint(1.0F, 3.5F, 1.0F);
        this.TOP_B_1.addBox(0.0F, 0.0F, 0.0F, 13, 12, 13, 0.0F);
        this.TENT_2 = new ModelRenderer(this, 0, 18);
        this.TENT_2.setRotationPoint(2.5F, 2.7F, 4.5F);
        this.TENT_2.addBox(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(TENT_2, 0.22759093446006054F, 0.0F, 0.0F);
        this.BASE.addChild(this.TOP_B);
        this.TOP_B.addChild(this.TOP_A);
        this.BASE.addChild(this.TENT_1);
        this.BASE.addChild(this.TENT_3);
        this.TOP_B.addChild(this.TOP_B_1);
        this.BASE.addChild(this.TENT_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.75F);
        this.BASE.render(f5);
        GlStateManager.disableBlend();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	EntityJellyfish jelly = (EntityJellyfish)entityIn;
    	this.BASE.rotateAngleY = netHeadYaw * 0.0097453292F;
        this.BASE.rotateAngleX = MathHelper.cos(headPitch) * 0.0097453292F;
        this.BASE.rotateAngleZ = headPitch * MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        float f = ((float)Math.PI / 2F);
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        float f20 = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f21 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        float f9 = (float)entityIn.ticksExisted + ageInTicks;
        //this.TENT_1.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
        //this.TENT_2.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
        //this.TENT_3.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
    }
}
