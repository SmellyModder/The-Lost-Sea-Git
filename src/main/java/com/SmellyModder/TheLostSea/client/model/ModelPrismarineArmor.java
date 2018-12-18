package com.SmellyModder.TheLostSea.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPrismarineArmor extends ModelBiped {
    
    public ModelRenderer LEFT_SHOULDER;
    public ModelRenderer RIGHT_SHOULDER;
    public ModelRenderer PEARL;
    public ModelRenderer FORE_HORN;
    public ModelRenderer PEARL_L;
    public ModelRenderer PEARL_F_2;
    public ModelRenderer PEARL_F;
    public ModelRenderer PEARL_L_2;
    public ModelRenderer PEARL_FORE;
    public ModelRenderer LEFT_PEARL;
    public ModelRenderer LEFT_PEARL_B;
    public ModelRenderer LEFT_PEARL_T;
    public ModelRenderer LEFT_PEARL_S;
    public ModelRenderer RIGHT_PEARL;
    public ModelRenderer RIGHT_PEARL_B;
    public ModelRenderer RIGHT_PEARL_T;
    public ModelRenderer RIGHT_PEARL_S;
    public ModelRenderer FORE_HORN_T;

    public ModelPrismarineArmor(float scale) {
    	super(scale, 0, 64, 64);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.PEARL_L_2 = new ModelRenderer(this, 16, 44);
        this.PEARL_L_2.setRotationPoint(-3.0F, 16.5F, -2.5F);
        this.PEARL_L_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RIGHT_PEARL = new ModelRenderer(this, 30, 0);
        this.RIGHT_PEARL.setRotationPoint(1.5F, 1.5F, -0.8F);
        this.RIGHT_PEARL.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.RIGHT_PEARL_B = new ModelRenderer(this, 30, 0);
        this.RIGHT_PEARL_B.setRotationPoint(1.5F, 1.5F, 4.8F);
        this.RIGHT_PEARL_B.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.PEARL_F_2 = new ModelRenderer(this, 16, 44);
        this.PEARL_F_2.setRotationPoint(-2.1F, 9.0F, -3.30F);
        this.PEARL_F_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RIGHT_PEARL_T = new ModelRenderer(this, 0, 44);
        this.RIGHT_PEARL_T.setRotationPoint(1.5F, -0.8F, 1.5F);
        this.RIGHT_PEARL_T.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.LEFT_SHOULDER = new ModelRenderer(this, 0, 32);
        this.LEFT_SHOULDER.setRotationPoint(-1.65F, -3.2F, -3.10F);
        this.LEFT_SHOULDER.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.LEFT_PEARL = new ModelRenderer(this, 30, 0);
        this.LEFT_PEARL.setRotationPoint(1.5F, 1.5F, -0.8F);
        this.LEFT_PEARL.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.PEARL_L = new ModelRenderer(this, 16, 44);
        this.PEARL_L.setRotationPoint(1.0F, 16.5F, -2.5F);
        this.PEARL_L.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.FORE_HORN = new ModelRenderer(this, 40, 50);
        this.FORE_HORN.setRotationPoint(-1.0F, -9.6F, -3.2F);
        this.FORE_HORN.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.PEARL = new ModelRenderer(this, 16, 44);
        this.PEARL.setRotationPoint(-1.0F, 2.0F, -3.2F);
        this.PEARL.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.PEARL_F = new ModelRenderer(this, 16, 44);
        this.PEARL_F.setRotationPoint(-0.2F, 9.0F, -3.30F);
        this.PEARL_F.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.LEFT_PEARL_T = new ModelRenderer(this, 0, 44);
        this.LEFT_PEARL_T.setRotationPoint(1.5F, -0.8F, 1.5F);
        this.LEFT_PEARL_T.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.FORE_HORN_T = new ModelRenderer(this, 50, 50);
        this.FORE_HORN_T.setRotationPoint(0.0F, -2.1F, -1.4F);
        this.FORE_HORN_T.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.PEARL_FORE = new ModelRenderer(this, 16, 44);
        this.PEARL_FORE.setRotationPoint(-1.0F, -6.5F, -5.2F);
        this.PEARL_FORE.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.RIGHT_PEARL_S = new ModelRenderer(this, 46, 37);
        this.RIGHT_PEARL_S.setRotationPoint(-0.8F, 1.5F, 1.5F);
        this.RIGHT_PEARL_S.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
        this.LEFT_PEARL_S = new ModelRenderer(this, 46, 37);
        this.LEFT_PEARL_S.setRotationPoint(4.8F, 1.5F, 1.5F);
        this.LEFT_PEARL_S.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
        this.LEFT_PEARL_B = new ModelRenderer(this, 30, 0);
        this.LEFT_PEARL_B.setRotationPoint(1.5F, 1.5F, 4.8F);
        this.LEFT_PEARL_B.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.RIGHT_SHOULDER = new ModelRenderer(this, 0, 32);
        this.RIGHT_SHOULDER.mirror = true;
        this.RIGHT_SHOULDER.setRotationPoint(-4.65F, -3.2F, -3.10F);
        this.RIGHT_SHOULDER.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.RIGHT_SHOULDER.addChild(this.RIGHT_PEARL);
        this.RIGHT_SHOULDER.addChild(this.RIGHT_PEARL_B);
        this.RIGHT_SHOULDER.addChild(this.RIGHT_PEARL_T);
        this.LEFT_SHOULDER.addChild(this.LEFT_PEARL);
        this.LEFT_SHOULDER.addChild(this.LEFT_PEARL_T);
        this.FORE_HORN.addChild(this.FORE_HORN_T);
        this.RIGHT_SHOULDER.addChild(this.RIGHT_PEARL_S);
        this.LEFT_SHOULDER.addChild(this.LEFT_PEARL_S);
        this.LEFT_SHOULDER.addChild(this.LEFT_PEARL_B);
        
        bipedHead.addChild(FORE_HORN);
        bipedHead.addChild(FORE_HORN_T);
        bipedHead.addChild(PEARL_FORE);
        
        
        bipedLeftArm.addChild(LEFT_SHOULDER);
        bipedRightArm.addChild(RIGHT_SHOULDER);
        
        bipedBody.addChild(PEARL);
        
        
        bipedLeftLeg.addChild(PEARL_F);
        
        bipedRightLeg.addChild(PEARL_F_2);
    }
   
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// this prevents helmets from always facing south, and the armor "breathing" on the stand
		if (entityIn instanceof EntityArmorStand) {
			EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
			this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			
			this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
			
			this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
			
			this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
			
			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			
			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			copyModelAngles(this.bipedHead, this.bipedHeadwear);
		} else super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
