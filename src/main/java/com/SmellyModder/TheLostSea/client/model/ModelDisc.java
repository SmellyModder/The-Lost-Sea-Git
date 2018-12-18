package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntityTorpedo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Disc - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelDisc extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer shape2;

    public ModelDisc() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape2 = new ModelRenderer(this, 0, 17);
        this.shape2.setRotationPoint(-6.0F, -0.5F, -6.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.Base.addChild(this.shape2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Base.render(f5);
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
    	EntityDisc disc = (EntityDisc)entityIn;
    	float f1 = (float)disc.ticksExisted;
    	this.Base.rotateAngleY += MathHelper.cos(f1 + ageInTicks/3);
    }
}
