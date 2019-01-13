package com.SmellyModder.TheLostSea.client.model.armor;

import com.SmellyModder.TheLostSea.common.init.TLSItems;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;


public class ModelNeptunumArmor extends ModelBiped {
    public ModelRenderer field_178736_x;
    public ModelRenderer field_178723_h;
    public ModelRenderer field_178721_j;
    public ModelRenderer head;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_178724_i;
    public ModelRenderer field_178722_k;
    public ModelRenderer shape30;
    public ModelRenderer shape32;
    public ModelRenderer shape43;
    public ModelRenderer shape29;
    public ModelRenderer shape36;
    public ModelRenderer shape37;
    public ModelRenderer shape30_1;
    public ModelRenderer shape32_1;
    public ModelRenderer shape43_1;

    public ModelNeptunumArmor(float modelSize) {
    	super(modelSize, 0.0F, 128, 64);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.shape32 = new ModelRenderer(this, 70, 6);
        this.shape32.setRotationPoint(1.0F, -0.5F, -0.5F);
        this.shape32.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6, 0.0F);
        this.shape36 = new ModelRenderer(this, 78, 32);
        this.shape36.setRotationPoint(-4.5F, -0.01F, -3.0F);
        this.shape36.addBox(0.0F, 0.0F, 0.0F, 9, 6, 6, 0.0F);
        this.shape43 = new ModelRenderer(this, 69, 54);
        this.shape43.mirror = true;
        this.shape43.setRotationPoint(-2.5F, 7.0F, -2.5F);
        this.shape43.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.3F);
        this.shape43_1 = new ModelRenderer(this, 69, 54);
        this.shape43_1.setRotationPoint(-2.5F, 7.0F, -2.5F);
        this.shape43_1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.3F);
        this.shape32_1 = new ModelRenderer(this, 70, 6);
        this.shape32_1.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.shape32_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 6, 0.0F);
        this.shape30 = new ModelRenderer(this, 0, 32);
        this.shape30.mirror = true;
        this.shape30.setRotationPoint(-3.7F, -2.1F, -2.5F);
        this.shape30.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
        this.shape29 = new ModelRenderer(this, 45, 48);
        this.shape29.setRotationPoint(0.0F, -9.0F, -5.1F);
        this.shape29.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 10, 0.0F);
        this.setRotateAngle(shape29, 0.06981317007977318F, 0.0F, 0.0F);
        this.shape37 = new ModelRenderer(this, 89, 54);
        this.shape37.setRotationPoint(-4.5F, 11.0F, -2.5F);
        this.shape37.addBox(0.0F, 0.0F, 0.0F, 9, 3, 5, 0.00F);
        this.shape30_1 = new ModelRenderer(this, 0, 32);
        this.shape30_1.setRotationPoint(-1.3F, -2.1F, -2.5F);
        this.shape30_1.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
       
        
        this.bipedRightArm.addChild(this.shape30);
        this.bipedLeftArm.addChild(this.shape30_1);
         
        this.bipedRightLeg.addChild(this.shape43);
        this.bipedLeftLeg.addChild(this.shape43_1);
        
        this.shape30_1.addChild(this.shape32_1);
        this.shape30.addChild(this.shape32);
        
        this.bipedHead.addChild(this.shape29);
        
        this.bipedBody.addChild(this.shape37);
        this.bipedBody.addChild(this.shape36);
       
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    @Override
   	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
