package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.bases.AbstractSubmarine;
import com.SmellyModder.TheLostSea.common.entity.bases.LSProjectile;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntityTorpedo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelTorpedo - Luke Tonon
 * Created using Tabula 7.0.0
 */
public class ModelTorpedo extends ModelBase {
    public ModelRenderer BODY;
    public ModelRenderer NOSE_T;
    public ModelRenderer NOSE_B;
    public ModelRenderer NOSE_R;
    public ModelRenderer NOSE_L;
    public ModelRenderer SPINE;
    public ModelRenderer BACK;
    public ModelRenderer BACK_S;
    public ModelRenderer FIN_T_L;
    public ModelRenderer FIN_T_R;
    public ModelRenderer FIN_B_R;
    public ModelRenderer FIN_B_L;
    public ModelRenderer BACK_B;
    public ModelRenderer FINNER_L;
    public ModelRenderer FINNER_R;
    public ModelRenderer FINNER_B;
    public ModelRenderer FINNER_T;

    public ModelTorpedo() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.FIN_T_R = new ModelRenderer(this, 0, 45);
        this.FIN_T_R.setRotationPoint(1.0F, 1.0F, 2.8F);
        this.FIN_T_R.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(FIN_T_R, 0.0F, 0.5585053606381855F, -1.5707963267948966F);
        this.BACK_S = new ModelRenderer(this, 45, 25);
        this.BACK_S.setRotationPoint(0.5F, 0.5F, 2.0F);
        this.BACK_S.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.NOSE_R = new ModelRenderer(this, 45, 10);
        this.NOSE_R.setRotationPoint(0.1F, 0.6F, -0.7F);
        this.NOSE_R.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(NOSE_R, -0.6108652381980153F, 0.0F, 0.0F);
        this.NOSE_T = new ModelRenderer(this, 35, 0);
        this.NOSE_T.setRotationPoint(0.0F, 1.6F, -2.4F);
        this.NOSE_T.addBox(0.0F, 0.0F, 0.0F, 6, 2, 4, 0.0F);
        this.setRotateAngle(NOSE_T, 0.6108652381980153F, 0.0F, 0.0F);
        this.FINNER_B = new ModelRenderer(this, 0, 25);
        this.FINNER_B.setRotationPoint(-0.5F, 0.5F, 1.4F);
        this.FINNER_B.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.NOSE_B = new ModelRenderer(this, 35, 0);
        this.NOSE_B.setRotationPoint(0.0F, 1.6F, -2.4F);
        this.NOSE_B.addBox(0.0F, 0.0F, 0.0F, 6, 2, 4, 0.0F);
        this.setRotateAngle(NOSE_B, -0.6108652381980153F, 0.0F, 0.0F);
        this.FIN_B_R = new ModelRenderer(this, 0, 45);
        this.FIN_B_R.mirror = true;
        this.FIN_B_R.setRotationPoint(1.0F, 3.0F, 2.8F);
        this.FIN_B_R.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(FIN_B_R, 0.0F, 0.5585053606381855F, 3.141592653589793F);
        this.BACK = new ModelRenderer(this, 25, 25);
        this.BACK.setRotationPoint(0.0F, 3.0F, 16.5F);
        this.BACK.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(BACK, 0.0F, 0.0F, -0.7853981633974483F);
        this.FINNER_T = new ModelRenderer(this, 0, 25);
        this.FINNER_T.setRotationPoint(-0.5F, -4.5F, 1.4F);
        this.FINNER_T.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.FIN_T_L = new ModelRenderer(this, 0, 45);
        this.FIN_T_L.setRotationPoint(3.1F, 1.0F, 2.8F);
        this.FIN_T_L.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(FIN_T_L, 0.0F, 0.5585053606381855F, 0.0F);
        this.FIN_B_L = new ModelRenderer(this, 0, 45);
        this.FIN_B_L.mirror = true;
        this.FIN_B_L.setRotationPoint(3.0F, 3.0F, 2.8F);
        this.FIN_B_L.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(FIN_B_L, 0.0F, 0.5585053606381855F, 1.5707963267948966F);
        this.SPINE = new ModelRenderer(this, 0, 25);
        this.SPINE.setRotationPoint(2.5F, -0.4F, 1.0F);
        this.SPINE.addBox(0.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F);
        this.FINNER_L = new ModelRenderer(this, 0, 35);
        this.FINNER_L.setRotationPoint(0.5F, -0.5F, 1.4F);
        this.FINNER_L.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.FINNER_R = new ModelRenderer(this, 0, 35);
        this.FINNER_R.setRotationPoint(-4.5F, -0.5F, 1.4F);
        this.FINNER_R.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.BODY = new ModelRenderer(this, 0, 0);
        this.BODY.setRotationPoint(-3.0F, 17.5F, -10.5F);
        this.BODY.addBox(0.0F, 0.0F, 0.0F, 6, 6, 18, 0.0F);
        this.setRotateAngle(BODY, 0.0F, 0.0F, 0.007330382858376183F);
        this.NOSE_L = new ModelRenderer(this, 45, 10);
        this.NOSE_L.setRotationPoint(4.8F, 0.6F, -0.7F);
        this.NOSE_L.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(NOSE_L, -0.6108652381980153F, 0.0F, 0.0F);
        this.BACK_B = new ModelRenderer(this, 45, 35);
        this.BACK_B.setRotationPoint(1.5F, 1.5F, 4.5F);
        this.BACK_B.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.BACK.addChild(this.FIN_T_R);
        this.BACK.addChild(this.BACK_S);
        this.BODY.addChild(this.NOSE_R);
        this.BODY.addChild(this.NOSE_T);
        this.BACK_B.addChild(this.FINNER_B);
        this.BODY.addChild(this.NOSE_B);
        this.BACK.addChild(this.FIN_B_R);
        this.BODY.addChild(this.BACK);
        this.BACK_B.addChild(this.FINNER_T);
        this.BACK.addChild(this.FIN_T_L);
        this.BACK.addChild(this.FIN_B_L);
        this.BODY.addChild(this.SPINE);
        this.BACK_B.addChild(this.FINNER_L);
        this.BACK_B.addChild(this.FINNER_R);
        this.BODY.addChild(this.NOSE_L);
        this.BACK_S.addChild(this.BACK_B);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BODY.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.BODY.rotateAngleY = netHeadYaw * 0.017453292F;
    }
    
    public void setLivingAnimations(EntityTorpedo entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
    	EntityTorpedo torpedo = (EntityTorpedo)entitylivingbaseIn;
    	float f7 = 1.0F;
    	float f9 = (float)entitylivingbaseIn.ticksExisted + partialTickTime;
    	float f9_2 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 0.4F;
    	float f9_3 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 2.6F;
    	float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
    	float f11 = f10 * 0.8F * limbSwingAmount;
   
    	this.BACK_B.rotateAngleZ = f9_2;
    }
}
