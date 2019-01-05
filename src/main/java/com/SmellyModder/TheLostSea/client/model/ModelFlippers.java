package com.SmellyModder.TheLostSea.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelFlippers extends ModelBiped {
    public ModelRenderer rightboot;
    public ModelRenderer leftboot;
    public ModelRenderer shape16;
    public ModelRenderer shape16_1;

    public ModelFlippers(float scale) {
    	super(scale, 0, 64, 64);
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.shape16_1 = new ModelRenderer(this, 0, 179);
        this.shape16_1.setRotationPoint(1.3F, 2.6F, -5.8F);
        this.shape16_1.addBox(0.0F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(shape16_1, 0.08726646259971647F, -0.22689280275926282F, 0.0F);
        this.leftboot = new ModelRenderer(this, 4, 187);
        this.leftboot.setRotationPoint(-0.3F, 21.0F, -2.3F);
        this.leftboot.addBox(0.0F, 0.0F, 0.0F, 5, 3, 5, 0.0F);
        this.rightboot = new ModelRenderer(this, 4, 187);
        this.rightboot.setRotationPoint(-4.8F, 21.0F, -2.3F);
        this.rightboot.addBox(0.0F, 0.0F, 0.0F, 5, 3, 5, 0.0F);
        this.shape16 = new ModelRenderer(this, 0, 179);
        this.shape16.setRotationPoint(-1.6F, 2.7F, -4.7F);
        this.shape16.addBox(0.0F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.setRotateAngle(shape16, 0.08726646259971647F, 0.22689280275926282F, 0.0F);
        this.leftboot.addChild(this.shape16_1);
        this.rightboot.addChild(this.shape16);
        
        bipedLeftLeg.addChild(leftboot);
        bipedRightLeg.addChild(rightboot);
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }
    
    /*@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// this prevents helmets from always facing south, and the armor "breathing" on the stand
		if (entityIn instanceof EntityArmorStand) {
			EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
			
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
	}*/

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
