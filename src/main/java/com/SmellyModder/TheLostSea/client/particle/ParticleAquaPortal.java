package com.SmellyModder.TheLostSea.client.particle;

import com.SmellyModder.TheLostSea.core.util.Reference;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class ParticleAquaPortal extends ParticleAtlasFrames {
    private static TextureAtlasSprite[] sprites;

    private final float scale;
    float oScale = (float) (rand.nextInt(6) * 0.5D + 0.2D);
    public ParticleAquaPortal(World world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.setSize(0.1F, 0.1F);

        this.motionX = speedX;
        this.motionY = speedY;
        this.motionZ = speedZ;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        float f = this.rand.nextFloat() * 0.6F + 0.4F;
        this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
        this.scale = this.rand.nextFloat() * 0.3F + 1.0F;
        

        this.particleMaxAge = (int) (8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge = (int) (this.particleMaxAge * this.scale);
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        sprites = stitchSprites(event.getMap(), new ResourceLocation[] {
                new ResourceLocation("thelostsea:particles/aqua_magic")
        });
    }

    @Override
    protected TextureAtlasSprite[] getSprites() {
        return sprites;
    }

    @Override
    public void renderParticle(BufferBuilder worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
    	float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge * 32.0F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        this.particleScale = this.oScale * f;

        super.renderParticle(worldRendererIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }

        this.frame = this.particleAge * sprites.length / this.particleMaxAge;

        this.motionY += 0.004;
        this.move(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }

        this.motionX *= 0.95;
        this.motionY *= 0.95;
        this.motionZ *= 0.95;

        if (this.onGround) {
            this.motionX *= 0.7;
            this.motionZ *= 0.7;
        }
    }

    public static class Factory implements IParticleFactory {
        @Nullable
        @Override
        public Particle createParticle(int particleID, World world, double x, double y, double z, double speedX, double speedY, double speedZ, int... p_178902_15_) {
            return new ParticleAquaPortal(world, x, y, z, speedX, speedY, speedZ);
        }
    }
}
