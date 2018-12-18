package com.SmellyModder.TheLostSea.common.entity.bases;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThrowableOrb extends EntityThrowable {
	
	public ThrowableOrb(World worldIn) {
		super(worldIn);
	}
	
	public ThrowableOrb(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	@SideOnly(Side.CLIENT)
	public ThrowableOrb(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}
	
	public static void registerFixesOrb(DataFixer fixer) {
		EntityThrowable.registerFixesThrowable(fixer, "ThrownOrb");
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		EntityLivingBase thrower = this.getThrower();
		
		if(result.entityHit != null)
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower), 3.0f);
	}
	
	@Override
	public void onUpdate() {
		EntityLivingBase thrower = this.getThrower();
		
		this.makeTrail();
		
		if(thrower != null && thrower instanceof EntityPlayer && !thrower.isEntityAlive())
			this.setDead();
		else
			super.onUpdate();
		}

	public void makeTrail() {
	for (int i = 0; i < 2; i++) {
		double dx = posX + 0.5 * (rand.nextDouble() - rand.nextDouble());
		double dy = posY + 0.5 * (rand.nextDouble() - rand.nextDouble());
		double dz = posZ + 0.5 * (rand.nextDouble() - rand.nextDouble());
		world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, dx, dy, dz, 0.0D, 0.0D, 0.0D);
	}
}
}