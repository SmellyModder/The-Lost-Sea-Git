package com.SmellyModder.TheLostSea.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCoconut - SmellyModder
 */
public class ModelCoconut extends ModelBase {
    public ModelRenderer coconut;

    public ModelCoconut() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.coconut = new ModelRenderer(this, 0, 0);
        this.coconut.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.coconut.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.coconut.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
