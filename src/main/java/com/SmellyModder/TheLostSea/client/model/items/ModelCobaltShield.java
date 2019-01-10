package  com.SmellyModder.TheLostSea.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCobaltShield - beethoven
 * Created using Tabula 7.0.0
 */
public class ModelCobaltShield extends ModelLSShield {
    public ModelRenderer handle;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape10_1;
    public ModelRenderer base;
    public ModelRenderer base_1;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer shape13;
    public ModelRenderer shape13_1;
    public ModelRenderer shape3_2;
    public ModelRenderer shape3_3;
    public ModelRenderer shape13_2;
    public ModelRenderer shape13_3;

    public ModelCobaltShield() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape10 = new ModelRenderer(this, 46, 0);
        this.shape10.setRotationPoint(4.5F, 0.0F, 0.5F);
        this.shape10.addBox(-3.5F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotateAngle(shape10, 0.0F, -0.17453292519943295F, 0.0F);
        this.shape3 = new ModelRenderer(this, 10, 21);
        this.shape3.setRotationPoint(1.0F, -1.5F, -0.5F);
        this.shape3.addBox(0.0F, -4.0F, -0.5F, 7, 10, 1, 0.0F);
        this.setRotateAngle(shape3, 0.0F, -0.17453292519943295F, 0.0F);
        this.shape13_2 = new ModelRenderer(this, 0, 15);
        this.shape13_2.setRotationPoint(7.5F, -4.5F, 0.1F);
        this.shape13_2.addBox(-1.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape13_2, 0.0F, 0.0F, -0.7853981633974483F);
        this.base = new ModelRenderer(this, 0, 19);
        this.base.setRotationPoint(0.0F, 5.5F, 1.0F);
        this.base.addBox(-1.5F, -4.4F, -1.5F, 3, 11, 2, 0.0F);
        this.setRotateAngle(base, 0.17453292519943295F, 0.0F, 0.0F);
        this.shape9 = new ModelRenderer(this, 52, 26);
        this.shape9.setRotationPoint(1.0F, 2.8F, -1.5F);
        this.shape9.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.shape3_3 = new ModelRenderer(this, 10, 0);
        this.shape3_3.setRotationPoint(-1.0F, 1.5F, -0.5F);
        this.shape3_3.addBox(-7.0F, -4.0F, -0.5F, 7, 8, 1, 0.0F);
        this.setRotateAngle(shape3_3, 0.0F, 0.17453292519943295F, 0.0F);
        this.shape10_1 = new ModelRenderer(this, 46, 3);
        this.shape10_1.setRotationPoint(-4.5F, 0.0F, 0.5F);
        this.shape10_1.addBox(-3.5F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotateAngle(shape10_1, 0.0F, 0.17453292519943295F, 0.0F);
        this.shape13 = new ModelRenderer(this, 6, 15);
        this.shape13.setRotationPoint(7.5F, 6.5F, 0.1F);
        this.shape13.addBox(-1.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape13, 0.0F, 0.0F, 0.7853981633974483F);
        this.shape3_2 = new ModelRenderer(this, 26, 0);
        this.shape3_2.setRotationPoint(1.0F, 1.5F, -0.5F);
        this.shape3_2.addBox(0.0F, -4.0F, -0.5F, 7, 8, 1, 0.0F);
        this.setRotateAngle(shape3_2, 0.0F, -0.17453292519943295F, 0.0F);
        this.shape13_3 = new ModelRenderer(this, 0, 17);
        this.shape13_3.setRotationPoint(-7.5F, -4.5F, 0.1F);
        this.shape13_3.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape13_3, 0.0F, 0.0F, 0.7853981633974483F);
        this.shape3_1 = new ModelRenderer(this, 26, 21);
        this.shape3_1.setRotationPoint(-1.0F, -1.5F, -0.5F);
        this.shape3_1.addBox(-7.0F, -4.0F, -0.5F, 7, 10, 1, 0.0F);
        this.setRotateAngle(shape3_1, 0.0F, 0.17453292519943295F, 0.0F);
        this.handle = new ModelRenderer(this, 48, 6);
        this.handle.setRotationPoint(-1.0F, -3.0F, -1.0F);
        this.handle.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
        this.base_1 = new ModelRenderer(this, 0, 0);
        this.base_1.setRotationPoint(0.0F, -5.5F, 1.0F);
        this.base_1.addBox(-1.5F, -6.6F, -1.5F, 3, 11, 2, 0.0F);
        this.setRotateAngle(base_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.shape13_1 = new ModelRenderer(this, 6, 17);
        this.shape13_1.setRotationPoint(-7.5F, 6.5F, 0.1F);
        this.shape13_1.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape13_1, 0.0F, 0.0F, -0.7853981633974483F);
        this.shape9.addChild(this.shape10);
        this.base.addChild(this.shape3);
        this.shape3_2.addChild(this.shape13_2);
        this.shape9.addChild(this.base);
        this.handle.addChild(this.shape9);
        this.base_1.addChild(this.shape3_3);
        this.shape9.addChild(this.shape10_1);
        this.shape3.addChild(this.shape13);
        this.base_1.addChild(this.shape3_2);
        this.shape3_3.addChild(this.shape13_3);
        this.base.addChild(this.shape3_1);
        this.shape9.addChild(this.base_1);
        this.shape3_1.addChild(this.shape13_1);
    }
    
    @Override
    public void render() { 
        this.handle.render(0.0625F);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
