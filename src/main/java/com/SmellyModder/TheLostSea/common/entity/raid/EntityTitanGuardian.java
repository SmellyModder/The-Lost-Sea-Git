package com.SmellyModder.TheLostSea.common.entity.raid;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.NodeProcessor;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
/**
 * 
 * @author SmellyModder
 *
 */
public class EntityTitanGuardian extends EntityMob{
	
	
	private static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntityTitanGuardian.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> MOVING = EntityDataManager.<Boolean>createKey(EntityTitanGuardian.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SHOULD_SHOOT = EntityDataManager.<Boolean>createKey(EntityTitanGuardian.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.<Integer>createKey(EntityTitanGuardian.class, DataSerializers.VARINT);
	private PathNavigateGround groundPath;
	private PathNavigateSwimmer waterPath;
	private EntityMoveHelper moveHelperWater;
    private EntityMoveHelper moveHelperLand;
	protected EntityAIWander wander;
	protected EntityAIBase attack;
	private EntityLivingBase targetedEntity;
	private int clientSideAttackTime;
	public EntityTitanGuardian(World worldIn) {
		super(worldIn);
		this.setSize(1.55F, 5.45F);
		this.experienceValue = 25;
		this.stepHeight = 1.5F;
		
		this.moveHelperWater = new EntityTitanGuardian.GuardianMoveHelper(this);
        this.moveHelperLand = new EntityTitanGuardian.GuardianMoveHelper(this);
		
		this.groundPath = new PathNavigateGround(this, this.world);
        this.groundPath.setCanSwim(true);
        
        this.waterPath = new PathNavigateSwimmer(this, this.world);
        
	}
	
	protected void initEntityAI()
    {
		this.wander = new EntityAIWander(this, 1.0D, 80);
		this.attack = new EntityTitanGuardian.AIGuardianAttack(this);
		this.tasks.addTask(7, this.wander);
		this.wander.setMutexBits(3);
		this.tasks.addTask(2, attack);
		this.attack.setMutexBits(3);
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.2D, true) {
			@Override
			protected double getAttackReachSqr(EntityLivingBase attackTarget) {
				return (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + attackTarget.width) / 5;
			}
		});
	    this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
	    this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
	    this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
	    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, true, false, new EntityTitanGuardian.GuardianTargetSelector(this)));
    }
	
	public void checkForMovement()
	{
		float f1 = this.limbSwingAmount;
		
		if(f1 > 1) {
			this.setMoving(true);
		}else if(f1 < 1) {
			this.setMoving(false);
		}
	}
	
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0)
        {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY - 0.20000000298023224D);
            int k = MathHelper.floor(this.posZ);
            IBlockState iblockstate = this.world.getBlockState(new BlockPos(i, j, k));

            if (iblockstate.getMaterial() != Material.AIR)
            {
            	if(this.rand.nextFloat() <= 5.0F){
            		this.world.playSound(this.posX, this.posY, this.posZ, this.getStepSound(), SoundCategory.BLOCKS, 0.9F, this.getRNG().nextFloat() + 0.2f, true);
            	}
            	
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
            }
        
            if (this.hasTargetedEntity())
            {
            
             ++this.clientSideAttackTime;
               
                EntityLivingBase entitylivingbase = this.getTargetedEntity();

                if (entitylivingbase != null)
                {
                    this.getLookHelper().setLookPositionWithEntity(entitylivingbase, 90.0F, 90.0F);
                    this.getLookHelper().onUpdateLook();
                    double d5 = (double)this.getAttackAnimationScale(0.0F);
                    double d0 = entitylivingbase.posX - this.posX;
                    double d1 = entitylivingbase.posY + (double)(entitylivingbase.height * 0.5F) - (this.posY + (double)this.getEyeHeight());
                    double d2 = entitylivingbase.posZ - this.posZ;
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    d0 = d0 / d3;
                    d1 = d1 / d3;
                    d2 = d2 / d3;
                    double d4 = this.rand.nextDouble();
                    }
            }else {
            	 this.clientSideAttackTime--;
            }
        }
    }
	
	protected SoundEvent getAmbientSound()
    {
        return this.isInWater() ? TLSSounds.ENTITY_TITAN_IDLE : SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND;
    }
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ELDER_GUARDIAN_HURT;
	}
	
	protected SoundEvent getStepSound() {
		return TLSSounds.ENTITY_TITAN_STEP;
	}
	
	@Override
	protected SoundEvent getSwimSound() {
		return getStepSound();
	}
	
	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return TLSSounds.ENTITY_TITAN_STEP;
	}
	
	@Override
	protected SoundEvent getSplashSound() {
		return TLSSounds.ENTITY_TITAN_STEP;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.isInWater()) {
			this.motionY -= 0.015;
			this.moveHelper = this.moveHelperWater;
			this.setAir(300);
		}else {
            this.moveHelper = this.moveHelperLand;
        }
		this.checkForMovement();
		if(this.isMoving()) {
			if(this.getRNG().nextInt(5) == 1) {
				this.world.playSound(this.posX, this.posY, this.posZ, this.getStepSound(), this.getSoundCategory(), 1.0F, 1.0F, false);
			}
		}
	}
	@Override
	public void travel(float strafe, float vertical, float forward) {
		if (isServerWorld()) {
			if (isInWater()) {
				moveRelative(strafe, vertical,  forward, 0.1F);
				move(MoverType.SELF, motionX, motionY, motionZ);
				motionX *= 0.7999999761581421D;
				motionY *= 0.79999994645D;
				motionZ *= 0.79799999761581421D;

				if (getAttackTarget() == null) {
					motionY -= 0.003D;
				}
			} else {
				super.travel(strafe, vertical, forward);
			}
		} else {
			super.travel(strafe, vertical, forward);
		}
	}

	public float getBlockPathWeight(BlockPos pos)
    {
        return this.world.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.world.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
    }
	
	@Override
	public float getEyeHeight() {
		return this.height * 0.90F;
	}
	
	public int getVariant()
    {
        return MathHelper.clamp(((Integer)this.dataManager.get(VARIANT)).intValue(), 0, 4);
    }

    public void setVariant(int p_191997_1_)
    {
        this.dataManager.set(VARIANT, Integer.valueOf(p_191997_1_));
    }
    
    public boolean isMoving()
    {
        return ((Boolean)this.dataManager.get(MOVING)).booleanValue();
    }

    private void setMoving(boolean moving)
    {
        this.dataManager.set(MOVING, Boolean.valueOf(moving));
    }
    
    public boolean isLaser()
    {
        return ((Boolean)this.dataManager.get(SHOULD_SHOOT)).booleanValue();
    }

    private void setLaser(boolean moving)
    {
        this.dataManager.set(SHOULD_SHOOT, Boolean.valueOf(moving));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(VARIANT, Integer.valueOf(0));
	    this.dataManager.register(MOVING, Boolean.valueOf(false));
	    this.dataManager.register(SHOULD_SHOOT, Boolean.valueOf(true));
	    this.dataManager.register(TARGET_ENTITY, Integer.valueOf(0));
    }
    
    private void setTargetedEntity(int entityId)
    {
        this.dataManager.set(TARGET_ENTITY, Integer.valueOf(entityId));
    }

    public boolean hasTargetedEntity()
    {
        return ((Integer)this.dataManager.get(TARGET_ENTITY)).intValue() != 0;
    }

    @Nullable
    public EntityLivingBase getTargetedEntity()
    {
        if (!this.hasTargetedEntity())
        {
            return null;
        }
        else if (this.world.isRemote)
        {
            if (this.targetedEntity != null)
            {
                return this.targetedEntity;
            }
            else
            {
                Entity entity = this.world.getEntityByID(((Integer)this.dataManager.get(TARGET_ENTITY)).intValue());

                if (entity instanceof EntityLivingBase)
                {
                    this.targetedEntity = (EntityLivingBase)entity;
                    return this.targetedEntity;
                }
                else
                {
                    return null;
                }
            }
        }
        else
        {
            return this.getAttackTarget();
        }
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);

        if (TARGET_ENTITY.equals(key))
        {
            this.targetedEntity = null;
        }
    }
    
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        this.setVariant(this.rand.nextInt(3));
        return super.onInitialSpawn(difficulty, livingdata);
    }
    
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Variant", this.getVariant());
    }

    
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setVariant(compound.getInteger("Variant"));
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(55.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.5D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(215.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.65D);
    }
	
	public boolean attackEntityAsMob(Entity entityIn)
    {
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(22)));

        if (flag)
        {
        	Vec3d vec3d = entityIn.getPositionVector().add(entityIn.getPositionVector()).scale(-0.64);
            entityIn.motionY += 0.3000000059604645D;
            entityIn.motionX += vec3d.x * 0.00230;
            entityIn.motionZ += vec3d.z * 0.00230;
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.EVOCATION_FANGS_ATTACK, 1.0F, 1.0F);
        return flag;
    }
	
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.isMoving() && !source.isMagicDamage() && source.getImmediateSource() instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)source.getImmediateSource();

            if (!source.isExplosion())
            {
                entitylivingbase.attackEntityFrom(DamageSource.causeThornsDamage(this), this.getRNG().nextInt((int) 6.0F));
            }
        }

        if (this.wander != null)
        {
            this.wander.makeUpdate();
        }

        return super.attackEntityFrom(source, amount);
    }
	
	@Override
	public boolean isPushedByWater() {
		return false;
	}
	
	private int attackTimerForLaser() {
		return 70;
	}
	
	public static enum TitanWeaponType
    {
        SWORD(BlockPlanks.EnumType.OAK.getMetadata(), "sword"),
        GUANTLET(BlockPlanks.EnumType.SPRUCE.getMetadata(), "fists"),
        BOW(BlockPlanks.EnumType.BIRCH.getMetadata(), "bow");

        private final String name;
        private final int metadata;

        private TitanWeaponType(int metadataIn, String nameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
        }

        public String getName()
        {
            return this.name;
        }

        public int getMetadata()
        {
            return this.metadata;
        }

        public String toString()
        {
            return this.name;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntityTitanGuardian.TitanWeaponType byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }

            return values()[id];
        }

        public static EntityTitanGuardian.TitanWeaponType getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }

            return values()[0];
        }
    }
	
	static class GuardianMoveHelper extends EntityMoveHelper
    {
        private final EntityTitanGuardian entityGuardian;

        public GuardianMoveHelper(EntityTitanGuardian guardian)
        {
            super(guardian);
            this.entityGuardian = guardian;
        }

        public void onUpdateMoveHelper()
        {
        	if (this.action == EntityMoveHelper.Action.STRAFE)
            {
                float f = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
                float f1 = (float)this.speed * f;
                float f2 = this.moveForward;
                float f3 = this.moveStrafe;
                float f4 = MathHelper.sqrt(f2 * f2 + f3 * f3);

                if (f4 < 1.0F)
                {
                    f4 = 1.0F;
                }

                f4 = f1 / f4;
                f2 = f2 * f4;
                f3 = f3 * f4;
                float f5 = MathHelper.sin(this.entity.rotationYaw * 0.017453292F);
                float f6 = MathHelper.cos(this.entity.rotationYaw * 0.017453292F);
                float f7 = f2 * f6 - f3 * f5;
                float f8 = f3 * f6 + f2 * f5;
                PathNavigate pathnavigate = this.entity.getNavigator();

                if (pathnavigate != null)
                {
                    NodeProcessor nodeprocessor = pathnavigate.getNodeProcessor();

                    if (nodeprocessor != null && nodeprocessor.getPathNodeType(this.entity.world, MathHelper.floor(this.entity.posX + (double)f7), MathHelper.floor(this.entity.posY), MathHelper.floor(this.entity.posZ + (double)f8)) != PathNodeType.WALKABLE)
                    {
                        this.moveForward = 1.0F;
                        this.moveStrafe = 0.0F;
                        f1 = f;
                    }
                }

                this.entity.setAIMoveSpeed(f1);
                this.entity.setMoveForward(this.moveForward);
                this.entity.setMoveStrafing(this.moveStrafe);
                this.action = EntityMoveHelper.Action.WAIT;
            }
            else if (this.action == EntityMoveHelper.Action.MOVE_TO)
            {
                this.action = EntityMoveHelper.Action.WAIT;
                double d0 = this.posX - this.entity.posX;
                double d1 = this.posZ - this.entity.posZ;
                double d2 = this.posY - this.entity.posY;
                double d3 = d0 * d0 + d2 * d2 + d1 * d1;

                if (d3 < 2.500000277905201E-7D)
                {
                    this.entity.setMoveForward(0.0F);
                    return;
                }

                float f9 = (float)(MathHelper.atan2(d1, d0) * (180D / Math.PI)) - 90.0F;
                this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, f9, 90.0F);
                this.entityGuardian.setMoving(true);
                this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                if (d2 > (double)this.entity.stepHeight && d0 * d0 + d1 * d1 < (double)Math.max(1.0F, this.entity.width))
                {
                    this.entity.getJumpHelper().setJumping();
                    this.action = EntityMoveHelper.Action.JUMPING;
                }
            }
            else if (this.action == EntityMoveHelper.Action.JUMPING)
            {
                this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                if (this.entity.onGround)
                {
                    this.action = EntityMoveHelper.Action.WAIT;
                }
            }
            else
            {
                this.entity.setMoveForward(0.0F);
            }
    }
    }
	static class GuardianTargetSelector implements Predicate<EntityLivingBase>
    {
        private final EntityTitanGuardian parentEntity;

        public GuardianTargetSelector(EntityTitanGuardian entityTitanGuardian)
        {
            this.parentEntity = entityTitanGuardian;
        }

        public boolean apply(@Nullable EntityLivingBase p_apply_1_)
        {
            return (p_apply_1_ instanceof EntityPlayer || p_apply_1_ instanceof EntitySquid) && p_apply_1_.getDistanceSq(this.parentEntity) > 9.0D;
        }
    }
	
	static class AIGuardianAttack extends EntityAIBase
    {
        private final EntityTitanGuardian guardian;
        private int tickCounter;

        public AIGuardianAttack(EntityTitanGuardian guardian)
        {
            this.guardian = guardian;
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityLivingBase entitylivingbase = this.guardian.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return super.shouldContinueExecuting() && (this.guardian.getDistanceSq(this.guardian.getAttackTarget()) > 9.0D);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.tickCounter = -10;
            this.guardian.getNavigator().clearPath();
            this.guardian.getLookHelper().setLookPositionWithEntity(this.guardian.getAttackTarget(), 90.0F, 90.0F);
            this.guardian.isAirBorne = true;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            this.guardian.setTargetedEntity(0);
            this.guardian.setAttackTarget((EntityLivingBase)null);
            this.guardian.wander.makeUpdate();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            EntityLivingBase entitylivingbase = this.guardian.getAttackTarget();
            this.guardian.getNavigator().clearPath();
            this.guardian.getLookHelper().setLookPositionWithEntity(entitylivingbase, 90.0F, 90.0F);

            if (!this.guardian.canEntityBeSeen(entitylivingbase))
            {
                this.guardian.setAttackTarget((EntityLivingBase)null);
            }
            else
            {
                ++this.tickCounter;

                if (this.tickCounter == 0)
                {
                    this.guardian.setTargetedEntity(this.guardian.getAttackTarget().getEntityId());
                    this.guardian.world.setEntityState(this.guardian, (byte)21);
                }
                else if (this.tickCounter >= this.guardian.attackTimerForLaser())
                {
                    float f = 4.0F;

                    if (this.guardian.world.getDifficulty() == EnumDifficulty.HARD)
                    {
                        f += 6.0F;
                    }

                    entitylivingbase.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.guardian, this.guardian), f);
                    entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(this.guardian), (float)this.guardian.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
                    this.guardian.setAttackTarget((EntityLivingBase)null);
                    this.guardian.setLaser(false);
                }

                super.updateTask();
            }
        }
    }

	public float getAttackAnimationScale(float partialTicks) {
		return ((float)this.clientSideAttackTime * (rand.nextInt(100) + 5) + partialTicks) / (float)this.attackTimerForLaser();
	}
}
