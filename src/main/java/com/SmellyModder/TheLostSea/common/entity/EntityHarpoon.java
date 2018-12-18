package com.SmellyModder.TheLostSea.common.entity;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHarpoon extends EntityThrowable{
	
	private static final DataParameter<Integer> DATA_HOOKED_ENTITY = EntityDataManager.<Integer>createKey(EntityHarpoon.class, DataSerializers.VARINT);
    public boolean foundEntity;
    private int ticksInGround;
    private EntityPlayer angler;
    public Entity caughtEntity;
    private int ticksLived;
    private EntityPlayer shooter;
    private EntityHarpoon.State currentState = EntityHarpoon.State.SHOOTING;
	
    public EntityHarpoon(World worldIn)
    {
        super(worldIn);
        setSize(0.25F, 0.25F);
    }

    public EntityHarpoon(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        shooter = (EntityPlayer) throwerIn;
    }

    public EntityHarpoon(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    private void shoot()
    {
        float f = this.angler.prevRotationPitch + (this.angler.rotationPitch - this.angler.prevRotationPitch);
        float f1 = this.angler.prevRotationYaw + (this.angler.rotationYaw - this.angler.prevRotationYaw);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        double d0 = this.angler.prevPosX + (this.angler.posX - this.angler.prevPosX) - (double)f3 * 0.3D;
        double d1 = this.angler.prevPosY + (this.angler.posY - this.angler.prevPosY) + (double)this.angler.getEyeHeight();
        double d2 = this.angler.prevPosZ + (this.angler.posZ - this.angler.prevPosZ) - (double)f2 * 0.3D;
        this.setLocationAndAngles(d0, d1, d2, f1, f);
        this.motionX = (double)(-f3);
        this.motionY = (double)MathHelper.clamp(-(f5 / f4), -5.0F, 5.0F);
        this.motionZ = (double)(-f2);
        float f6 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX *= 0.6D / (double)f6 + 0.5D + this.rand.nextGaussian() * 0.0045D;
        this.motionY *= 0.6D / (double)f6 + 0.5D + this.rand.nextGaussian() * 0.0045D;
        this.motionZ *= 0.6D / (double)f6 + 0.5D + this.rand.nextGaussian() * 0.0045D;
        float f7 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f7) * (180D / Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }
	
	public static void registerFixesHarpoon(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Harpoon");
    }
	
	@Override
	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy)
    {
        float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
        float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.motionX += entityThrower.motionX;
        this.motionZ += entityThrower.motionZ;

        if (!entityThrower.onGround)
        {
            this.motionY += entityThrower.motionY;
        }
    }
	
	public void onUpdate()
    {
		super.onUpdate();
		
		ticksLived++;
		float f = 0.0F;
        BlockPos blockpos = new BlockPos(this);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        
        if (this.currentState == EntityHarpoon.State.SHOOTING)
        {
            if (this.caughtEntity != null && ticksExisted >= 5)
            {
            	if(this.caughtEntity instanceof EntityPlayer&& !((EntityPlayer)this.caughtEntity).isUser()) {
            		this.setDead();
            	}
            	int i = 1;
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
                this.currentState = EntityHarpoon.State.HOOKED_IN_ENTITY;
                return;
            }
        }
        if (this.currentState == EntityHarpoon.State.HOOKED_IN_ENTITY)
        {
            if (this.caughtEntity != null)
            {
                if (this.caughtEntity.isDead)
                {
                    this.caughtEntity = null;
                    this.currentState = EntityHarpoon.State.SHOOTING;
                }
                else
                {
                	if(this.caughtEntity instanceof EntityPlayer&& !((EntityPlayer)this.caughtEntity).isUser()) {
                		this.setDead();
                	}else {
                    this.posX = this.caughtEntity.posX;
                    double d2 = (double)this.caughtEntity.height;
                    this.posY = this.caughtEntity.getEntityBoundingBox().minY + d2 * 0.8D;
                    this.posZ = this.caughtEntity.posZ;
                    this.setPosition(this.posX, this.posY, this.posZ);
                }
                }
                }
            }
        }
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result != null && result.typeOfHit != RayTraceResult.Type.MISS)
        {
            if (result.typeOfHit == RayTraceResult.Type.ENTITY)
            {
            	int i = 1;
            	result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
                this.caughtEntity = result.entityHit;
                this.setHookedEntity();
            }
            else
            {
                this.inGround = true;
            }
        }
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
	
	@Override
	protected void entityInit()
    {
        this.getDataManager().register(DATA_HOOKED_ENTITY, Integer.valueOf(0));
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        if (DATA_HOOKED_ENTITY.equals(key))
        {
            int i = ((Integer)this.getDataManager().get(DATA_HOOKED_ENTITY)).intValue();
            this.caughtEntity = i > 0 ? this.world.getEntityByID(i - 1) : null;
        }

        super.notifyDataManagerChange(key);
    }
    
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
    }
    
    private void updateRotation()
    {
        float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, (double)f) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
    }

    private void setHookedEntity()
    {
        this.getDataManager().set(DATA_HOOKED_ENTITY, Integer.valueOf(this.caughtEntity.getEntityId() + 1));
    }
    
    protected boolean canBeHooked(Entity ent)
    {
    	if (ent instanceof EntityPlayer) {
    		EntityPlayer plr = (EntityPlayer) ent;
    		
    		if (plr != shooter) {
    			return plr.canBeCollidedWith();
    		}
    		
    		return false;
    	}
    	
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 31 && this.world.isRemote && this.caughtEntity instanceof EntityPlayer && ((EntityPlayer)this.caughtEntity).isUser())
        {
            this.bringInHookedEntity();
        }

        super.handleStatusUpdate(id);
    }

    protected void bringInHookedEntity()
    {
        if (this.angler != null)
        {
            double d0 = this.angler.posX - this.posX;
            double d1 = this.angler.posY - this.posY;
            double d2 = this.angler.posZ - this.posZ;
            double d3 = 0.1D;
            this.caughtEntity.motionX += d0 * 0.1D;
            this.caughtEntity.motionY += d1 * 0.1D;
            this.caughtEntity.motionZ += d2 * 0.1D;
        }
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    public EntityPlayer getAngler()
    {
        return this.angler;
    }

    static enum State
    {
        SHOOTING,
        HOOKED_IN_ENTITY,
    }
}
