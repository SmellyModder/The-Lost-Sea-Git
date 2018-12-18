package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.bases.AbstractSubmarine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.util.math.MathHelper;

/**
 * Submarine - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelSubmarine extends ModelBase {
    public ModelRenderer BASE;
    public ModelRenderer SEAT_BOTTOM;
    public ModelRenderer FRONT_RIGHT_ARM;
    public ModelRenderer FRONT_LEFT_ARM;
    public ModelRenderer BACK_RIGHT_ARM;
    public ModelRenderer BACK_LEFT_ARM;
    public ModelRenderer BACK_BOTTOM;
    public ModelRenderer GLASS;
    public ModelRenderer SEAT_POLL;
    public ModelRenderer SEAT_BASE;
    public ModelRenderer SEAT_HOLDER;
    public ModelRenderer SEAT_HOLDER_CHILD3;
    public ModelRenderer SEAT_HOLDER_CHILD4;
    public ModelRenderer SEAT_HOLDER_CHILD;
    public ModelRenderer SEAT_HOLDER_CHILD2;
    public ModelRenderer LIGHT_LEFT;
    public ModelRenderer BACK_TOP;
    public ModelRenderer LIGHT_LEFT_1;
    public ModelRenderer BOOSTER;
    public ModelRenderer BOOSTER_NECK;
    public ModelRenderer FIN_1;
    public ModelRenderer FIN_2;
    public ModelRenderer FIN_3;
    public ModelRenderer FIN_4;
    public ModelRenderer HEAD_BASE;
    public ModelRenderer HEAD_SECOND;
    public ModelRenderer HEAD_POLE;
    public ModelRenderer HEAD_TOP;
    public ModelRenderer RIGHT_STICK;
    public ModelRenderer LEFT_STICK;
    public ModelRenderer RIGHT_STICK2;
    public ModelRenderer LEFT_STICK2;

    public ModelSubmarine() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.RIGHT_STICK = new ModelRenderer(this, 200, 200);
        this.RIGHT_STICK.setRotationPoint(-2.0F, -0.5F, 1.0F);
        this.RIGHT_STICK.addBox(0.0F, 0.0F, 0.0F, 2, 2, 14, 0.0F);
        this.setRotateAngle(RIGHT_STICK, -0.08726646259971647F, 0.0F, 0.0F);
        this.RIGHT_STICK2 = new ModelRenderer(this, 200, 170);
        this.RIGHT_STICK2.setRotationPoint(0.5F, 0.0F, 12.5F);
        this.RIGHT_STICK2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 17, 0.0F);
        this.setRotateAngle(RIGHT_STICK2, -0.5462880558742251F, 0.0F, 0.0F);
        this.BASE = new ModelRenderer(this, 120, 62);
        this.BASE.setRotationPoint(-16.0F, 20.0F, -16.0F);
        this.BASE.addBox(0.0F, 0.0F, 0.0F, 32, 2, 32, 0.0F);
        this.SEAT_BOTTOM = new ModelRenderer(this, 0, 45);
        this.SEAT_BOTTOM.setRotationPoint(11.0F, -1.0F, 7.0F);
        this.SEAT_BOTTOM.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.GLASS = new ModelRenderer(this, 120, 0);
        this.GLASS.setRotationPoint(0.0F, -30.0F, -1.0F);
        this.GLASS.addBox(0.0F, 0.0F, 0.0F, 32, 30, 32, 0.0F);
        this.HEAD_SECOND = new ModelRenderer(this, 50, 170);
        this.HEAD_SECOND.mirror = true;
        this.HEAD_SECOND.setRotationPoint(1.0F, -1.3F, 1.0F);
        this.HEAD_SECOND.addBox(0.0F, 0.0F, 0.0F, 20, 2, 20, 0.0F);
        this.FIN_4 = new ModelRenderer(this, 0, 15);
        this.FIN_4.setRotationPoint(0.5F, 3.5F, 3.5F);
        this.FIN_4.addBox(-2.0F, -1.5F, 0.0F, 3, 10, 3, 0.0F);
        this.HEAD_TOP = new ModelRenderer(this, 30, 30);
        this.HEAD_TOP.setRotationPoint(-1.0F, -2.0F, -1.0F);
        this.HEAD_TOP.addBox(0.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.FIN_1 = new ModelRenderer(this, 0, 0);
        this.FIN_1.setRotationPoint(3.5F, 0.5F, 3.5F);
        this.FIN_1.addBox(-2.0F, -1.5F, 0.0F, 10, 3, 3, 0.0F);
        this.SEAT_HOLDER_CHILD4 = new ModelRenderer(this, 0, 60);
        this.SEAT_HOLDER_CHILD4.setRotationPoint(-6.8F, 0.5F, -5.5F);
        this.SEAT_HOLDER_CHILD4.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(SEAT_HOLDER_CHILD4, 1.5707963267948966F, 0.0F, 0.0F);
        this.SEAT_HOLDER = new ModelRenderer(this, 0, 90);
        this.SEAT_HOLDER.setRotationPoint(-5.0F, -8.1F, 6.6F);
        this.SEAT_HOLDER.addBox(0.0F, 0.0F, 0.0F, 10, 10, 2, 0.0F);
        this.setRotateAngle(SEAT_HOLDER, -0.3490658503988659F, 0.0F, 0.0F);
        this.SEAT_HOLDER_CHILD3 = new ModelRenderer(this, 0, 60);
        this.SEAT_HOLDER_CHILD3.mirror = true;
        this.SEAT_HOLDER_CHILD3.setRotationPoint(4.8F, 0.5F, -5.5F);
        this.SEAT_HOLDER_CHILD3.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(SEAT_HOLDER_CHILD3, 1.5707963267948966F, 0.0F, 0.0F);
        this.LIGHT_LEFT = new ModelRenderer(this, 0, 200);
        this.LIGHT_LEFT.setRotationPoint(-15.2F, 1.0F, -30.5F);
        this.LIGHT_LEFT.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F);
        this.LEFT_STICK = new ModelRenderer(this, 200, 200);
        this.LEFT_STICK.setRotationPoint(10.0F, -0.5F, 1.0F);
        this.LEFT_STICK.addBox(-2.0F, 0.0F, 0.0F, 2, 2, 14, 0.0F);
        this.setRotateAngle(LEFT_STICK, -0.08726646259971647F, 0.0F, 0.0F);
        this.HEAD_POLE = new ModelRenderer(this, 0, 30);
        this.HEAD_POLE.setRotationPoint(7.0F, -5.0F, 7.0F);
        this.HEAD_POLE.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.BOOSTER = new ModelRenderer(this, 112, 215);
        this.BOOSTER.setRotationPoint(14.0F, 0.0F, 3.1F);
        this.BOOSTER.addBox(0.0F, 0.0F, 0.0F, 18, 18, 12, 0.0F);
        this.setRotateAngle(BOOSTER, 0.3490658503988659F, 0.0F, 0.0F);
        this.HEAD_BASE = new ModelRenderer(this, 112, 150);
        this.HEAD_BASE.setRotationPoint(5.0F, -1.5F, 5.5F);
        this.HEAD_BASE.addBox(0.0F, 0.0F, 0.0F, 22, 2, 22, 0.0F);
        this.LIGHT_LEFT_1 = new ModelRenderer(this, 0, 200);
        this.LIGHT_LEFT_1.setRotationPoint(6.2F, 1.0F, -30.5F);
        this.LIGHT_LEFT_1.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F);
        this.SEAT_HOLDER_CHILD = new ModelRenderer(this, 0, 105);
        this.SEAT_HOLDER_CHILD.setRotationPoint(-1.9F, -0.8F, 0.0F);
        this.SEAT_HOLDER_CHILD.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.SEAT_POLL = new ModelRenderer(this, 85, 45);
        this.SEAT_POLL.setRotationPoint(5.0F, -6.5F, 5.0F);
        this.SEAT_POLL.addBox(-2.5F, -1.0F, -2.5F, 5, 8, 5, 0.0F);
        this.BOOSTER_NECK = new ModelRenderer(this, 40, 0);
        this.BOOSTER_NECK.setRotationPoint(9.0F, 9.0F, 10.0F);
        this.BOOSTER_NECK.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 8, 0.0F);
        this.FRONT_LEFT_ARM = new ModelRenderer(this, 0, 75);
        this.FRONT_LEFT_ARM.mirror = true;
        this.FRONT_LEFT_ARM.setRotationPoint(26.5F, -12.0F, 19.8F);
        this.FRONT_LEFT_ARM.addBox(5.0F, 0.0F, -30.0F, 11, 11, 42, 0.0F);
        this.setRotateAngle(FRONT_LEFT_ARM, 0.0F, 0.0F, 0.08726646259971647F);
        this.SEAT_BASE = new ModelRenderer(this, 45, 45);
        this.SEAT_BASE.setRotationPoint(0.0F, -2.9F, 0.0F);
        this.SEAT_BASE.addBox(-5.0F, 0.0F, -5.0F, 10, 2, 10, 0.0F);
        this.BACK_BOTTOM = new ModelRenderer(this, 122, 104);
        this.BACK_BOTTOM.setRotationPoint(-7.0F, -22.0F, 29.3F);
        this.BACK_BOTTOM.addBox(0.0F, 0.0F, 0.0F, 46, 22, 10, 0.0F);
        this.setRotateAngle(BACK_BOTTOM, -0.3490658503988659F, 0.0F, 0.0F);
        this.BACK_TOP = new ModelRenderer(this, 0, 220);
        this.BACK_TOP.setRotationPoint(-33.5F, -0.5F, -6.0F);
        this.BACK_TOP.addBox(0.0F, 0.0F, 0.0F, 46, 15, 8, 0.0F);
        this.FIN_3 = new ModelRenderer(this, 0, 15);
        this.FIN_3.setRotationPoint(0.5F, -9.5F, 3.5F);
        this.FIN_3.addBox(-2.0F, -1.5F, 0.0F, 3, 10, 3, 0.0F);
        this.BACK_LEFT_ARM = new ModelRenderer(this, 0, 130);
        this.BACK_LEFT_ARM.setRotationPoint(26.5F, -29.0F, 38.0F);
        this.BACK_LEFT_ARM.addBox(5.0F, 0.0F, -30.0F, 8, 8, 24, 0.0F);
        this.setRotateAngle(BACK_LEFT_ARM, 0.08726646259971647F, 0.0F, 0.0F);
        this.BACK_RIGHT_ARM = new ModelRenderer(this, 0, 130);
        this.BACK_RIGHT_ARM.setRotationPoint(8.5F, -29.0F, 38.0F);
        this.BACK_RIGHT_ARM.addBox(-16.0F, 0.0F, -30.0F, 8, 8, 24, 0.0F);
        this.setRotateAngle(BACK_RIGHT_ARM, 0.08726646259971647F, 0.0F, 0.0F);
        this.SEAT_HOLDER_CHILD2 = new ModelRenderer(this, 0, 105);
        this.SEAT_HOLDER_CHILD2.mirror = true;
        this.SEAT_HOLDER_CHILD2.setRotationPoint(9.9F, -0.8F, 0.0F);
        this.SEAT_HOLDER_CHILD2.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.FIN_2 = new ModelRenderer(this, 0, 0);
        this.FIN_2.setRotationPoint(-9.5F, 0.5F, 3.5F);
        this.FIN_2.addBox(-2.0F, -1.5F, 0.0F, 10, 3, 3, 0.0F);
        this.FRONT_RIGHT_ARM = new ModelRenderer(this, 0, 75);
        this.FRONT_RIGHT_ARM.setRotationPoint(5.5F, -12.0F, 19.8F);
        this.FRONT_RIGHT_ARM.addBox(-16.0F, 0.0F, -30.0F, 11, 11, 42, 0.0F);
        this.setRotateAngle(FRONT_RIGHT_ARM, 0.0F, 0.0F, -0.08726646259971647F);
        this.LEFT_STICK2 = new ModelRenderer(this, 200, 170);
        this.LEFT_STICK2.mirror = true;
        this.LEFT_STICK2.setRotationPoint(-2.5F, 0.0F, 12.5F);
        this.LEFT_STICK2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 17, 0.0F);
        this.setRotateAngle(LEFT_STICK2, -0.5462880558742251F, 0.0F, 0.0F);
        this.HEAD_TOP.addChild(this.RIGHT_STICK);
        this.RIGHT_STICK.addChild(this.RIGHT_STICK2);
        this.BASE.addChild(this.SEAT_BOTTOM);
        this.BASE.addChild(this.GLASS);
        this.HEAD_BASE.addChild(this.HEAD_SECOND);
        this.BOOSTER_NECK.addChild(this.FIN_4);
        this.HEAD_POLE.addChild(this.HEAD_TOP);
        this.BOOSTER_NECK.addChild(this.FIN_1);
        this.SEAT_BASE.addChild(this.SEAT_HOLDER_CHILD4);
        this.SEAT_BASE.addChild(this.SEAT_HOLDER);
        this.SEAT_BASE.addChild(this.SEAT_HOLDER_CHILD3);
        this.BACK_RIGHT_ARM.addChild(this.LIGHT_LEFT);
        this.HEAD_TOP.addChild(this.LEFT_STICK);
        this.HEAD_SECOND.addChild(this.HEAD_POLE);
        this.BACK_BOTTOM.addChild(this.BOOSTER);
        this.GLASS.addChild(this.HEAD_BASE);
        this.BACK_LEFT_ARM.addChild(this.LIGHT_LEFT_1);
        this.SEAT_HOLDER.addChild(this.SEAT_HOLDER_CHILD);
        this.SEAT_BOTTOM.addChild(this.SEAT_POLL);
        this.BOOSTER.addChild(this.BOOSTER_NECK);
        this.BASE.addChild(this.FRONT_LEFT_ARM);
        this.SEAT_POLL.addChild(this.SEAT_BASE);
        this.BASE.addChild(this.BACK_BOTTOM);
        this.BACK_LEFT_ARM.addChild(this.BACK_TOP);
        this.BOOSTER_NECK.addChild(this.FIN_3);
        this.BASE.addChild(this.BACK_LEFT_ARM);
        this.BASE.addChild(this.BACK_RIGHT_ARM);
        this.SEAT_HOLDER.addChild(this.SEAT_HOLDER_CHILD2);
        this.BOOSTER_NECK.addChild(this.FIN_2);
        this.BASE.addChild(this.FRONT_RIGHT_ARM);
        this.LEFT_STICK.addChild(this.LEFT_STICK2);
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
    	this.BASE.rotateAngleX = netHeadYaw * 0.017453292F;
    }
    
    private float updateRotations(float p_110683_1_, float p_110683_2_, float p_110683_3_)
    {
        float f;

        for (f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return p_110683_1_ + p_110683_3_ * f;
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
        float f = this.updateRotations(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTickTime);
        float f1 = this.updateRotations(entitylivingbaseIn.prevRotationYawHead, entitylivingbaseIn.rotationYawHead, partialTickTime);
        float f2 = entitylivingbaseIn.prevRotationPitch + (entitylivingbaseIn.rotationPitch - entitylivingbaseIn.prevRotationPitch) * partialTickTime;
        float f3 = f1 - f;
        float f4 = f2 * 0.017453292F;
        
        if (f3 > 20.0F)
        {
            f3 = 20.0F;
        }

        if (f3 < -20.0F)
        {
            f3 = -20.0F;
        }

        if (limbSwingAmount > 0.2F)
        {
            f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }

        AbstractSubmarine sub = (AbstractSubmarine)entitylivingbaseIn;
        float f7 = 1.0F;
        boolean flag2 = sub.isBeingRidden();
        float f9 = (float)entitylivingbaseIn.ticksExisted + partialTickTime;
        float f9_2 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 0.4F;
        float f9_3 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 2.6F;
        float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        float f666 = sub.getBoosterAnimation(f);
       
        
        if(!sub.isMoving()) {
            this.BOOSTER_NECK.rotateAngleZ = 0;
        }
        if(sub.isMoving() && sub.isInWater()) {
        	this.BOOSTER_NECK.rotateAngleZ = f9_2;
        	if(sub.isBeingRidden()) {
        		this.BOOSTER_NECK.rotateAngleZ = f9;
        	}
        }
    }
}
