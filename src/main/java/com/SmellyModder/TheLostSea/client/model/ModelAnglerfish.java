package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelAnglerfish - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelAnglerfish extends ModelBase {
    public ModelRenderer FORE_HEAD;
    public ModelRenderer JAW_BACK;
    public ModelRenderer ANT_B;
    public ModelRenderer T_FIN;
    public ModelRenderer B_FIN;
    public ModelRenderer JAW;
    public ModelRenderer FIN_R;
    public ModelRenderer FIN_L;
    public ModelRenderer B_TEETH;
    public ModelRenderer ANT;
    public ModelRenderer ANGLER;
    public ModelRenderer GLOW;

    public ModelAnglerfish() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.FIN_R = new ModelRenderer(this, 40, 0);
        this.FIN_R.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.FIN_R.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(FIN_R, -0.5009094953223726F, -0.5462880558742251F, 0.0F);
        this.JAW_BACK = new ModelRenderer(this, 35, 10);
        this.JAW_BACK.setRotationPoint(0.0F, 5.0F, 6.0F);
        this.JAW_BACK.addBox(0.0F, 0.0F, 0.0F, 5, 2, 4, 0.0F);
        this.ANT_B = new ModelRenderer(this, 0, 25);
        this.ANT_B.setRotationPoint(2.4F, 0.5F, 0.4F);
        this.ANT_B.addBox(-0.4F, -3.5F, -0.3F, 1, 4, 1, 0.0F);
        this.setRotateAngle(ANT_B, 0.36425021489121656F, 0.0F, -0.0F);
        this.T_FIN = new ModelRenderer(this, 24, 0);
        this.T_FIN.setRotationPoint(2.0F, 1.6F, 8.5F);
        this.T_FIN.addBox(0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(T_FIN, 0.45378560551852565F, 0.0F, 0.0F);
        this.B_FIN = new ModelRenderer(this, 24, 0);
        this.B_FIN.setRotationPoint(2.0F, 3.0F, 9.2F);
        this.B_FIN.addBox(0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(B_FIN, -0.45378560551852565F, 0.0F, 0.0F);
        this.FIN_L = new ModelRenderer(this, 40, 0);
        this.FIN_L.setRotationPoint(4.2F, 0.0F, 3.6F);
        this.FIN_L.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(FIN_L, -0.5009094953223726F, 0.5462880558742251F, 0.0F);
        this.B_TEETH = new ModelRenderer(this, 8, 21);
        this.B_TEETH.setRotationPoint(-3.0F, -1.0F, -10.0F);
        this.B_TEETH.addBox(0.0F, 0.0F, 0.0F, 6, 1, 10, 0.0F);
        this.ANGLER = new ModelRenderer(this, 14, 16);
        this.ANGLER.setRotationPoint(-0.5F, -0.5F, -1.0F);
        this.ANGLER.addBox(-0.4F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.FORE_HEAD = new ModelRenderer(this, 0, 0);
        this.FORE_HEAD.setRotationPoint(-2.5F, 8.0F, -3.5F);
        this.FORE_HEAD.addBox(0.0F, 0.0F, 0.0F, 5, 5, 10, 0.0F);
        this.ANT = new ModelRenderer(this, 0, 17);
        this.ANT.setRotationPoint(0.0F, -3.5F, -5.0F);
        this.ANT.addBox(-0.4F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.JAW = new ModelRenderer(this, 30, 18);
        this.JAW.setRotationPoint(2.5F, -0.7F, 2.5F);
        this.JAW.addBox(-3.0F, 0.0F, -10.0F, 6, 3, 10, 0.0F);
        this.setRotateAngle(JAW, -0.3141592653589793F, 0.0F, 0.0F);
        this.GLOW = new ModelRenderer(this, 13, 45);
        this.GLOW.setRotationPoint(-4.30F, -4.0F, 0.20F);
        this.GLOW.addBox(0.0F, 0.0F, 0.0F, 10, 10, 0, 0.0F);
        this.setRotateAngle(GLOW, -0.3141592653589793F, 0.0F, 0.0F);
        this.JAW_BACK.addChild(this.FIN_R);
        this.FORE_HEAD.addChild(this.JAW_BACK);
        this.FORE_HEAD.addChild(this.ANT_B);
        this.FORE_HEAD.addChild(this.T_FIN);
        this.FORE_HEAD.addChild(this.B_FIN);
        this.JAW_BACK.addChild(this.FIN_L);
        this.JAW.addChild(this.B_TEETH);
        this.ANT.addChild(this.ANGLER);
        this.ANT_B.addChild(this.ANT);
        this.JAW_BACK.addChild(this.JAW);
        this.ANGLER.addChild(this.GLOW);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.FORE_HEAD.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entity, float swing, float speed, float partialRenderTicks) {
    		EntityAnglerfish angler = (EntityAnglerfish) entity;

            float flap = MathHelper.sin((angler.ticksExisted + partialRenderTicks) * 0.5F) * 0.6F;
            if (angler.isGrounded())
            	flap = MathHelper.cos((angler.ticksExisted + partialRenderTicks) * 1.5F) * 0.6F;
            
            this.B_FIN.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.05F;
            this.B_FIN.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.1F;
            this.B_FIN.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.15F;
            
            this.T_FIN.rotateAngleY = -MathHelper.sin(flap) * (float)Math.PI * 0.05F;
            this.T_FIN.rotateAngleY = -MathHelper.sin(flap) * (float)Math.PI * 0.1F;
            this.T_FIN.rotateAngleY = -MathHelper.sin(flap) * (float)Math.PI * 0.15F;
            
            this.ANT_B.rotateAngleX = MathHelper.sin(flap / 2) * (float)Math.PI * 0.11F;
            
            if(angler.isLightOn()) {
            	this.ANT_B.rotateAngleX = -MathHelper.sin(flap * 2) * (float)Math.PI * 0.11F;
            	this.GLOW.showModel = true;
            	JAW.rotateAngleX = 0.36F - flap*0.5F;
            }
            else if(!angler.isLightOn()) {
            	this.GLOW.showModel = false;
            	JAW.rotateAngleX = -0.0f;
            	this.ANT_B.rotateAngleX = 0.36425021489121656F;
            }
            
            if(!angler.isInWater()) {
            	this.FORE_HEAD.rotateAngleY = -MathHelper.cos(flap) * (float)Math.PI * 0.2F;
            	this.FORE_HEAD.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.1F;
            	JAW.rotateAngleX = 0.36F - flap*0.4F;
            }
            
            if(angler.isMoving()) {
            	JAW.rotateAngleX = 0.30F - flap*0.30F;
            }
    }
}
