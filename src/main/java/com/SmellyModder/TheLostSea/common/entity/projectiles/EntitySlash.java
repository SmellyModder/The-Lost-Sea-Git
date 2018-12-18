package com.SmellyModder.TheLostSea.common.entity.projectiles;

import com.SmellyModder.TheLostSea.common.entity.bases.LSProjectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySlash extends LSProjectile{
	
	int turnX, turnY;
	
	public EntitySlash(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0f);
	}
	
	public EntitySlash(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }
	
	public EntitySlash(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
	
	public static void registerFixesSlash(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Slash");
    }

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.entityHit != null)
        {
		 
		 Entity entity = result.entityHit;
		 
            int i = rand.nextInt(9) + 15;
            
            result.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.getThrower()), (float)i);
        }
		
		if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		makeSlashEffect();
		if(this.ticksExisted > 12.0F) {
			this.setDead();
		}
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }
    public float getBrightness()
    {
        return 1.0F;
    }
    
    private void makeSlashEffect() {
		for (int i = 0; i < 1; i++) {
			double dx = posX + 0.2 * (rand.nextDouble() - rand.nextDouble());
			double dy = posY + 0.2 * (rand.nextDouble() - rand.nextDouble());
			double dz = posZ + 0.2 * (rand.nextDouble() - rand.nextDouble());
			world.spawnParticle(EnumParticleTypes.SWEEP_ATTACK, dx, dy, dz, 0.0D, 0.0D, 0.0D);
		}
	}

}
