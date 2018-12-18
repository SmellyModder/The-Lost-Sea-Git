package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.math.MathHelper;

/**
 * VampireSquid - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelVampireSquid extends ModelBase {
    public ModelRenderer BASE;
    public ModelRenderer BASE_A;
    public ModelRenderer BASE_B;
    public ModelRenderer BASE_C;
    public ModelRenderer BASE_D;
    public ModelRenderer TOUNGE;
    public ModelRenderer TOP_LEFT_JAW;
    public ModelRenderer TOP_RIGHT_JAW;
    public ModelRenderer RIGHT_JAW;
    public ModelRenderer LEFT_JAW;
    public ModelRenderer TENTACLE;
    public ModelRenderer TENTACLE_L;
    public ModelRenderer TENTACLE_R;

    public ModelVampireSquid() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.BASE_D = new ModelRenderer(this, 69, 10);
        this.BASE_D.setRotationPoint(-4.5F, -4.0F, -3.0F);
        this.BASE_D.addBox(-2.0F, 0.0F, 0.0F, 2, 8, 8, 0.0F);
        this.TOP_RIGHT_JAW = new ModelRenderer(this, -3, 26);
        this.TOP_RIGHT_JAW.setRotationPoint(2.5F, -3.0F, 1.0F);
        this.TOP_RIGHT_JAW.addBox(-2.5F, -2.5F, -19.5F, 6, 6, 20, 0.0F);
        this.BASE_C = new ModelRenderer(this, 69, 10);
        this.BASE_C.mirror = true;
        this.BASE_C.setRotationPoint(4.5F, -4.0F, -3.0F);
        this.BASE_C.addBox(0.0F, 0.0F, 0.0F, 2, 8, 8, 0.0F);
        this.BASE_B = new ModelRenderer(this, 68, 27);
        this.BASE_B.setRotationPoint(0.0F, 4.5F, -3.0F);
        this.BASE_B.addBox(-4.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.TOUNGE = new ModelRenderer(this, 40, 0);
        this.TOUNGE.setRotationPoint(0.0F, 0.0F, -4.7F);
        this.TOUNGE.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 9, 0.0F);
        this.BASE_A = new ModelRenderer(this, 68, 27);
        this.BASE_A.setRotationPoint(0.0F, -6.5F, -3.0F);
        this.BASE_A.addBox(-4.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.LEFT_JAW = new ModelRenderer(this, 47, 38);
        this.LEFT_JAW.mirror = true;
        this.LEFT_JAW.setRotationPoint(-3.5F, 3.0F, 1.0F);
        this.LEFT_JAW.addBox(-2.5F, -2.5F, -19.5F, 6, 6, 20, 0.0F);
        this.TENTACLE = new ModelRenderer(this, 93, 0);
        this.TENTACLE.setRotationPoint(0.0F, -6.0F, 8.0F);
        this.TENTACLE.addBox(-3.0F, 3.0F, 0.0F, 6, 6, 10, 0.0F);
        this.TENTACLE_R = new ModelRenderer(this, 93, 0);
        this.TENTACLE_R.mirror = true;
        this.TENTACLE_R.setRotationPoint(-4.0F, -6.0F, 5.0F);
        this.TENTACLE_R.addBox(-3.0F, 3.0F, 0.0F, 6, 6, 10, 0.0F);
        this.setRotateAngle(TENTACLE_R, 0.0F, -0.6283185307179586F, 0.0F);
        this.BASE = new ModelRenderer(this, 0, 0);
        this.BASE.setRotationPoint(0.0F, 12.0F, 4.0F);
        this.BASE.addBox(-5.0F, -5.0F, -3.0F, 10, 10, 12, 0.0F);
        this.setRotateAngle(BASE, 0.0F, 0.009599310885968812F, 0.0F);
        this.TENTACLE_L = new ModelRenderer(this, 93, 0);
        this.TENTACLE_L.setRotationPoint(4.0F, -6.0F, 5.0F);
        this.TENTACLE_L.addBox(-3.0F, 3.0F, 0.0F, 6, 6, 10, 0.0F);
        this.setRotateAngle(TENTACLE_L, 0.0F, 0.6283185307179586F, 0.0F);
        this.TOP_LEFT_JAW = new ModelRenderer(this, -3, 26);
        this.TOP_LEFT_JAW.mirror = true;
        this.TOP_LEFT_JAW.setRotationPoint(-3.5F, -3.0F, 1.0F);
        this.TOP_LEFT_JAW.addBox(-2.5F, -2.5F, -19.5F, 6, 6, 20, 0.0F);
        this.RIGHT_JAW = new ModelRenderer(this, 47, 38);
        this.RIGHT_JAW.setRotationPoint(2.5F, 3.0F, 1.0F);
        this.RIGHT_JAW.addBox(-2.5F, -2.5F, -19.5F, 6, 6, 20, 0.0F);
        this.BASE.addChild(this.BASE_D);
        this.BASE.addChild(this.TOP_RIGHT_JAW);
        this.BASE.addChild(this.BASE_C);
        this.BASE.addChild(this.BASE_B);
        this.BASE.addChild(this.TOUNGE);
        this.BASE.addChild(this.BASE_A);
        this.BASE.addChild(this.LEFT_JAW);
        this.BASE.addChild(this.TENTACLE);
        this.BASE.addChild(this.TENTACLE_R);
        this.BASE.addChild(this.TENTACLE_L);
        this.BASE.addChild(this.TOP_LEFT_JAW);
        this.BASE.addChild(this.RIGHT_JAW);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BASE.render(f5);
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
    	this.BASE.rotateAngleY = netHeadYaw * 0.016453292F;
    	this.BASE.rotateAngleX = headPitch * 0.017453292F;
    	
    	EntityVampireSquid entitysquid = (EntityVampireSquid)entityIn;
        float f = ageInTicks - (float)entitysquid.ticksExisted;
        
        float f2 = entitysquid.getTailAnimation(f);
        float f3 = entitysquid.getMouthAnimation(f);
        int i = entitysquid.getAttackTimer();
         
        this.TENTACLE.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.05F;
        this.TENTACLE.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.1F;
        this.TENTACLE.rotationPointX = -6F;
        this.TENTACLE.rotationPointY = 0.5F;
        this.TENTACLE.rotationPointZ = 10.0F;
        this.TENTACLE.rotateAngleY = MathHelper.cos(f2) * (float)Math.PI * -0.15F;
        this.TENTACLE.rotationPointX = 0.0F;
        this.TENTACLE.rotationPointY = -6.0F;
        this.TENTACLE.rotationPointZ = 8.0F;
        
        this.TENTACLE_L.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * -0.05F;
        this.TENTACLE_L.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * -0.1F;
        this.TENTACLE_L.rotationPointX = -6F;
        this.TENTACLE_L.rotationPointY = 0.5F;
        this.TENTACLE_L.rotationPointZ = 10.0F;
        this.TENTACLE_L.rotateAngleX = MathHelper.sin(f2) * (float)Math.PI * -0.15F;
        this.TENTACLE_L.rotationPointX = 4.0F;
        this.TENTACLE_L.rotationPointY = -6.0F;
        this.TENTACLE_L.rotationPointZ = 5.0F;
      
        this.TENTACLE_R.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * -0.05F;
        this.TENTACLE_R.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * -0.1F;
        this.TENTACLE_R.rotationPointX = -6F;
        this.TENTACLE_R.rotationPointY = 0.5F;
        this.TENTACLE_R.rotationPointZ = 10.0F;
        this.TENTACLE_R.rotateAngleX = MathHelper.sin(f2) * (float)Math.PI * 0.15F;
        this.TENTACLE_R.rotationPointX = -4.0F;
        this.TENTACLE_R.rotationPointY = -6.0F;
        this.TENTACLE_R.rotationPointZ = 5.0F;
        
        
       

        
        
        if (entitysquid.hasTargetedEntity())
        {
            entityIn = entitysquid.getTargetedEntity();
            this.LEFT_JAW.rotateAngleX = 0.6108652381980153F;
            this.LEFT_JAW.rotateAngleY = 0.5235987755982988F;
            
            this.RIGHT_JAW.rotateAngleX = 0.6108652381980153F;
            this.RIGHT_JAW.rotateAngleY = -0.5235987755982988F;
            
            this.TOP_LEFT_JAW.rotateAngleX = -0.6108652381980153F;
            this.TOP_LEFT_JAW.rotateAngleY = 0.5235987755982988F;
            
            this.TOP_RIGHT_JAW.rotateAngleX = -0.6108652381980153F;
            this.TOP_RIGHT_JAW.rotateAngleY = -0.5235987755982988F;
            
        }
        
        if (!entitysquid.hasTargetedEntity())
        {
        	this.LEFT_JAW.rotateAngleX = 0.0F;
            this.LEFT_JAW.rotateAngleY = 0.0F;
            
            this.RIGHT_JAW.rotateAngleX = 0.0F;
            this.RIGHT_JAW.rotateAngleY = 0.0F;
            
            this.TOP_LEFT_JAW.rotateAngleX = 0.0F;
            this.TOP_LEFT_JAW.rotateAngleY = 0.0F;
            
            this.TOP_RIGHT_JAW.rotateAngleX = 0.0F;
            this.TOP_RIGHT_JAW.rotateAngleY = 0.0F;
            if (i > 0) {
        
        	this.LEFT_JAW.rotateAngleX = 0.6108652381980153F;
            this.LEFT_JAW.rotateAngleY = 0.5235987755982988F;
            
            this.RIGHT_JAW.rotateAngleX = 0.6108652381980153F;
            this.RIGHT_JAW.rotateAngleY = -0.5235987755982988F;
            
            this.TOP_LEFT_JAW.rotateAngleX = -0.6108652381980153F;
            this.TOP_LEFT_JAW.rotateAngleY = 0.5235987755982988F;
            
            this.TOP_RIGHT_JAW.rotateAngleX = -0.6108652381980153F;
            this.TOP_RIGHT_JAW.rotateAngleY = -0.5235987755982988F;
            }
            
            
        }
    }
}
