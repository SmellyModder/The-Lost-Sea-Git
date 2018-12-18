package com.SmellyModder.TheLostSea.client.model.npc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelNurm extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer l_arm;
    public ModelRenderer r_arm;
    public ModelRenderer arm;
    public ModelRenderer l_leg;
    public ModelRenderer body;
    public ModelRenderer body_o;
    public ModelRenderer r_leg;
    public ModelRenderer nose;
    public ModelRenderer b_hat;
    public ModelRenderer hat;
    public ModelRenderer t_hat;
    public ModelRenderer tt_hat;
    public ModelRenderer f_feather;
    public ModelRenderer b_feather;

    public ModelNurm() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.l_arm = new ModelRenderer(this, 44, 22);
        this.l_arm.mirror = true;
        this.l_arm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.l_arm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(l_arm, -0.7499679795819634F, 0.0F, 0.0F);
        this.l_leg = new ModelRenderer(this, 0, 22);
        this.l_leg.mirror = true;
        this.l_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.l_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.nose = new ModelRenderer(this, 24, 0);
        this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.arm = new ModelRenderer(this, 40, 38);
        this.arm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.arm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(arm, -0.7499679795819634F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 20);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.t_hat = new ModelRenderer(this, 70, 0);
        this.t_hat.mirror = true;
        this.t_hat.setRotationPoint(-0.5F, -1.0F, -0.5F);
        this.t_hat.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.hat = new ModelRenderer(this, 70, 15);
        this.hat.setRotationPoint(0.5F, -1.0F, 0.5F);
        this.hat.addBox(0.0F, 0.0F, 0.0F, 9, 1, 9, 0.0F);
        this.r_arm = new ModelRenderer(this, 44, 22);
        this.r_arm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.r_arm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(r_arm, -0.7499679795819634F, 0.0F, 0.0F);
        this.body_o = new ModelRenderer(this, 0, 38);
        this.body_o.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body_o.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.b_feather = new ModelRenderer(this, 0, 0);
        this.b_feather.setRotationPoint(-0.8F, -1.0F, 1.0F);
        this.b_feather.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.f_feather = new ModelRenderer(this, 0, 0);
        this.f_feather.setRotationPoint(-1.0F, -0.9F, 0.9F);
        this.f_feather.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.tt_hat = new ModelRenderer(this, 40, 50);
        this.tt_hat.setRotationPoint(2.0F, -0.7F, 2.0F);
        this.tt_hat.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.r_leg = new ModelRenderer(this, 0, 22);
        this.r_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.r_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.b_hat = new ModelRenderer(this, 70, 0);
        this.b_hat.setRotationPoint(-5.0F, -11.0F, -5.0F);
        this.b_hat.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.setRotateAngle(b_hat, 0.0F, 0.01727875959474386F, 0.0F);
        this.head.addChild(this.nose);
        this.hat.addChild(this.t_hat);
        this.b_hat.addChild(this.hat);
        this.f_feather.addChild(this.b_feather);
        this.tt_hat.addChild(this.f_feather);
        this.t_hat.addChild(this.tt_hat);
        this.head.addChild(this.b_hat);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	float aF = 1.0F;
        this.l_arm.render(f5);
        this.l_leg.render(f5);
        this.arm.render(f5);
        this.body.render(f5);
        this.r_arm.render(f5);
        this.body_o.render(f5);
        this.head.render(f5);
        this.r_leg.render(f5);
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
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    		this.head.rotateAngleX = headPitch * 0.017453292F;
    		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	
    }
}
