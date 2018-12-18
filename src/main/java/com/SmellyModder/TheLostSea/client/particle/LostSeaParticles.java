package com.SmellyModder.TheLostSea.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public enum LostSeaParticles {
    AQUA_PORTAL(new ParticleAquaPortal.Factory());

    private final IParticleFactory factory;

    LostSeaParticles(IParticleFactory factory) {
        this.factory = factory;
    }

    public void spawn(World world, double x, double y, double z, double speedX, double speedY, double speedZ) {
        Particle particle = this.factory.createParticle(-1, world, x, y, z, speedX, speedY, speedZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(particle);
    }
}
