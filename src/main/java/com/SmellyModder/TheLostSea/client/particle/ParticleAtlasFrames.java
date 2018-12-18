package com.SmellyModder.TheLostSea.client.particle;

import java.util.Random;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ParticleAtlasFrames extends Particle {
    private final TextureAtlasSprite[] sprites = this.getSprites();

    protected int frame;
    Random rand = new Random();

    protected ParticleAtlasFrames(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ParticleAtlasFrames(World world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        super(world, x, y, z, speedX, speedY, speedZ);
    }

    @Override
    public int getFXLayer() {
        return 1;
    }

    @Override
    public void renderParticle(BufferBuilder builder, Entity entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        this.setParticleTexture(this.sprites[(int) (this.frame % this.sprites.length * rand.nextFloat())]);
        super.renderParticle(builder, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    protected abstract TextureAtlasSprite[] getSprites();

    protected static TextureAtlasSprite[] stitchSprites(TextureMap textureMap, ResourceLocation[] frames) {
        TextureAtlasSprite[] sprites = new TextureAtlasSprite[frames.length];
        for (int i = 0; i < frames.length; i++) {
            ResourceLocation frame = frames[i];
            sprites[i] = textureMap.registerSprite(frame);
        }
        return sprites;
    }
}
