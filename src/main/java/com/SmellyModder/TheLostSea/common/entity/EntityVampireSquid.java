package com.SmellyModder.TheLostSea.common.entity;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
/**
 * 
 * @author SmellyModder
 *
 */
public class EntityVampireSquid extends EntityMob{
	
	private EntityLivingBase targetedEntity;
	private int clientSideAttackTime;
	protected EntityAIWander wander;
	protected float clientSideTailAnimation;
	protected float clientSideMouthAnimation;
	protected float clientSideTailAnimationO;
	protected float clientSideTailAnimationSpeed;
	protected float clientSideMouthGrab;
	protected float clientSideMouthGrabO;
	private int attackTimer;
	public boolean isFlipped = true;

	//Data
	private static final DataParameter<Boolean> MOVING = EntityDataManager.<Boolean>createKey(EntityVampireSquid.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> FEEDING = EntityDataManager.<Boolean>createKey(EntityVampireSquid.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.<Integer>createKey(EntityVampireSquid.class, DataSerializers.VARINT);
	
	 public EntityVampireSquid(World worldIn)
	 {
	   super(worldIn);
	   this.experienceValue = 10;
	   this.setSize(0.9F, 0.8F);
	   this.experienceValue = 23;
	   this.clientSideTailAnimation = this.rand.nextFloat();
	   this.moveHelper = new EntityVampireSquid.SquidMoveHelper(this);
	 }
	 
	 protected void initEntityAI()
	 {
	  EntityAIMoveTowardsRestriction entityaimovetowardsrestriction = new EntityAIMoveTowardsRestriction(this, 1.1D);
	  entityaimovetowardsrestriction.setMutexBits(3);
	  this.wander = new EntityAIWander(this, 1.0D, 90);
	  this.tasks.addTask(5, entityaimovetowardsrestriction);
      this.tasks.addTask(5, this.wander);
      this.wander.setMutexBits(3);
      this.tasks.addTask(9, new EntityAILookIdle(this));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityGuardian.class, 12.0F, 0.01F));
      this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityVampireSquid.class, 12.0F, 0.02F));
      this.tasks.addTask(4, new EntityVampireSquid.AISquidMeleeAttack(this));
      this.tasks.addTask(3, new EntityVampireSquid.AISquidAttack(this));
      this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, true, false, new EntityVampireSquid.TargetSelector(this)));
	 }
	 
	 protected void applyEntityAttributes()
	 {
	  super.applyEntityAttributes();
	  this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	  this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	  this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.2D);
	 }
	 
	 public static void registerFixesGuardian(DataFixer fixer)
	 {
	   EntityLiving.registerFixesMob(fixer, EntityVampireSquid.class);
	 }
	    
	 protected PathNavigate createNavigator(World worldIn)
	 {
	   return new PathNavigateSwimmer(this, worldIn);
	 }
	 
	 protected void entityInit()
	 {
		 super.entityInit();
		 this.dataManager.register(MOVING, Boolean.valueOf(false));
		 this.dataManager.register(TARGET_ENTITY, Integer.valueOf(0));
		 this.dataManager.register(FEEDING, Boolean.valueOf(false));
	 }
	 
	 public boolean isMoving()
	 {
	   return ((Boolean)this.dataManager.get(MOVING)).booleanValue();
	 }
	 
	 public boolean isFeeding() {
		 return ((Boolean)this.dataManager.get(FEEDING)).booleanValue();
	 }

	 private void setFeeding(boolean feed)
	 {
	    this.dataManager.set(FEEDING, Boolean.valueOf(feed));
	 }
	 
	 private void setMoving(boolean moving)
	 {
	    this.dataManager.set(MOVING, Boolean.valueOf(moving));
	 }
	 
	 public int getAttackDuration()
	    {
	        return 64;
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
	            this.clientSideAttackTime = 0;
	            this.targetedEntity = null;
	        }
	   }
	  
	protected boolean canTriggerWalking()
	{
	        return false;
	}
	
	public float getBlockPathWeight(BlockPos pos)
    {
        return this.world.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.world.getLightBrightness(pos) - 0.3F : super.getBlockPathWeight(pos);
    }
	
	protected boolean isValidLightLevel()
    {
        return true;
    }
	
	public boolean isNotColliding()
    {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return (this.rand.nextInt(20) == 0 || !this.world.canBlockSeeSky(new BlockPos(this))) && super.getCanSpawnHere();
    }
    
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (!this.isMoving() && !source.isMagicDamage() && source.getImmediateSource() instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)source.getImmediateSource();
        }

        if (this.wander != null)
        {
            this.wander.makeUpdate();
        }

        return super.attackEntityFrom(source, amount);
    }
    
    public boolean attackEntityAsMob(Entity entityIn)
    {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(8)));

        if (flag)
        {
            entityIn.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, 1.0F, 1.0F);
        return flag;
    }
    
    public int getVerticalFaceSpeed()
    {
        return 160;
    }

    public void travel(float strafe, float vertical, float forward)
    {
        if (this.isServerWorld() && this.isInWater())
        {
            this.moveRelative(strafe, vertical, forward, 0.1F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.7999999761581421D;
            this.motionY *= 0.7999999761581421D;
            this.motionZ *= 0.7999999761581421D;

            if (!this.isMoving() && this.getAttackTarget() == null)
            {
                this.motionY -= 0.001D;
            }
        }
        else
        {
            super.travel(strafe, vertical, forward);
        }
    }
   
    protected SoundEvent getFlopSound()
    {
        return SoundEvents.ENTITY_SMALL_SLIME_SQUISH;
    }
    
    
    public void onLivingUpdate()
    { 
    	if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
    	
        if (this.world.isRemote)
        {
            this.clientSideTailAnimationO = this.clientSideTailAnimation;

            if (!this.isInWater())
            {
                this.clientSideTailAnimationSpeed = 2.0F;

                if (this.motionY > 0.0D && !this.isSilent())
                {
                    this.world.playSound(this.posX, this.posY, this.posZ, this.getFlopSound(), this.getSoundCategory(), 1.0F, 1.0F, false);
                }
            }
            else if (this.isMoving())
            {
                if (this.clientSideTailAnimationSpeed < 0.5F)
                {
                    this.clientSideTailAnimationSpeed = 4.0F;
                }
                else
                {
                    this.clientSideTailAnimationSpeed += (0.5F - this.clientSideTailAnimationSpeed) * 0.1F;
                }
            }
            else
            {
                this.clientSideTailAnimationSpeed += (0.125F - this.clientSideTailAnimationSpeed) * 0.2F;
            }

            this.clientSideTailAnimation += this.clientSideTailAnimationSpeed;

            if (this.isMoving() && this.isInWater())
            {
                Vec3d vec3d = this.getLook(0.0F);

                for (int i = 0; i < 2; ++i)
                {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3d.x * 1.3D, this.posY + this.rand.nextDouble() * (double)this.height - vec3d.y * 1.5D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
                }
            }

            if (this.hasTargetedEntity())
            {
                if (this.clientSideAttackTime < this.getAttackDuration())
                {
                    ++this.clientSideAttackTime;
                }

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

                    while (d4 < d3)
                    {
                        d4 += 1.8D - d5 + this.rand.nextDouble() * (1.7D - d5);
                        this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + d0 * d4, this.posY + d1 * d4 + (double)this.getEyeHeight(), this.posZ + d2 * d4, 0.0D, 0.0D, 0.0D);
                    }
                }
            }
        }

        if (this.inWater)
        {
            this.setAir(300);
        }
        else if (this.onGround)
        {
            this.motionY += 0.5D;
            this.motionX += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.rotationYaw = this.rand.nextFloat() * 360.0F;
            this.onGround = false;
            this.isAirBorne = true;
        }

        if (this.hasTargetedEntity())
        {
            this.rotationYaw = this.rotationYawHead;
        }
        super.onLivingUpdate();
    }
    
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 4)
        {
            this.attackTimer = 10;
            this.playSound(SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, 1.0F, 1.0F);
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }
	 
	 public float getEyeHeight()
	 {
	  return this.height * 0.4F;
	 }
	 
	 public float getAttackAnimationScale(float p_175477_1_)
	 {
	        return ((float)this.clientSideAttackTime + p_175477_1_) / (float)this.getAttackDuration();
	 }
	 
	 public int getTalkInterval()
	 {
	  return 211;
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public float getTailAnimation(float p_175471_1_)
	 {
	        return this.clientSideTailAnimationO + (this.clientSideTailAnimation - this.clientSideTailAnimationO) * p_175471_1_;
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public float getMouthAnimation(float p_175471_1_)
	 {
	        return this.clientSideMouthGrabO + (this.clientSideMouthGrab - this.clientSideMouthGrabO) * p_175471_1_;
	 }
	 
	 protected SoundEvent getAmbientSound()
	 {
	        return this.isInWater() ? SoundEvents.ENTITY_SQUID_DEATH : SoundEvents.BLOCK_WATER_AMBIENT;
	 }

	    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	    {
	        return this.isInWater() ? SoundEvents.ENTITY_SQUID_HURT : SoundEvents.ENTITY_SQUID_HURT;
	    }

	    protected SoundEvent getDeathSound()
	    {
	        return this.isInWater() ? SoundEvents.ENTITY_SQUID_DEATH : SoundEvents.ENTITY_SQUID_DEATH;
	    }
	    
	    @Override
	    public void onUpdate() {
	    	EntityLivingBase e = this.getTargetedEntity();
	    	if(this.hasTargetedEntity()) {
	    		this.pullInEntity(e);
	    		this.playSound(SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, 1.0F, 1.0F);
	    	}
	    	super.onUpdate();
	    }
	    
	    public void pullInEntity(EntityLivingBase e) {
	    	e = this.getTargetedEntity();
	    	
	    	
	    	if(e != null) {
	    		Vec3d tongue = this.getTargetedEntity().getPositionVector().subtract(this.getPositionVector()).scale(-0.06);if(e != null) {
	    		e.motionX = tongue.x;
	    		e.motionY = tongue.y;
	    		e.motionZ = tongue.z;
	    	}
	    	}
	    }
	    
	    static class SquidMoveHelper extends EntityMoveHelper
        {
            private final EntityVampireSquid entityGuardian;

            public SquidMoveHelper(EntityVampireSquid guardian)
            {
                super(guardian);
                this.entityGuardian = guardian;
            }

            public void onUpdateMoveHelper()
            {
                if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.entityGuardian.getNavigator().noPath())
                {
                    double d0 = this.posX - this.entityGuardian.posX;
                    double d1 = this.posY - this.entityGuardian.posY;
                    double d2 = this.posZ - this.entityGuardian.posZ;
                    double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    d1 = d1 / d3;
                    float f = (float)(MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
                    this.entityGuardian.rotationYaw = this.limitAngle(this.entityGuardian.rotationYaw, f, 90.0F);
                    this.entityGuardian.renderYawOffset = this.entityGuardian.rotationYaw;
                    float f1 = (float)(this.speed * this.entityGuardian.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                    this.entityGuardian.setAIMoveSpeed(this.entityGuardian.getAIMoveSpeed() + (f1 - this.entityGuardian.getAIMoveSpeed()) * 0.125F);
                    double d4 = Math.sin((double)(this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.5D) * 0.05D;
                    double d5 = Math.cos((double)(this.entityGuardian.rotationYaw * 0.017453292F));
                    double d6 = Math.sin((double)(this.entityGuardian.rotationYaw * 0.017453292F));
                    
                    this.entityGuardian.motionX += d4 * d5 * d1;
                    this.entityGuardian.motionZ += d4 * d6;
                    
                    d4 = Math.sin((double)(this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.75D) * 0.05D;
                    this.entityGuardian.motionY += d4 * (d6 + d5) * 0.99D;
                    this.entityGuardian.motionY += (double)this.entityGuardian.getAIMoveSpeed() * d1 * 0.1D;
                    EntityLookHelper entitylookhelper = this.entityGuardian.getLookHelper();
                    double d7 = this.entityGuardian.posX + d0 / d3 * 2.0D;
                    double d8 = (double)this.entityGuardian.getEyeHeight() + this.entityGuardian.posY + d1 / d3;
                    double d9 = this.entityGuardian.posZ + d2 / d3 * 2.0D;
                    double d10 = entitylookhelper.getLookPosX();
                    double d11 = entitylookhelper.getLookPosY();
                    double d12 = entitylookhelper.getLookPosZ();

                    if (!entitylookhelper.getIsLooking())
                    {
                        d10 = d7;
                        d11 = d8;
                        d12 = d9;
                    }

                    this.entityGuardian.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                    this.entityGuardian.setMoving(true);
                }
                else
                {
                    this.entityGuardian.setAIMoveSpeed(0.0F);
                    this.entityGuardian.setMoving(false);
                }
            }
        }
	    
	    
	    static class AISquidAttack extends EntityAIBase
        {
            private final EntityVampireSquid guardian;
            private int tickCounter;

            public AISquidAttack(EntityVampireSquid guardian)
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
                return super.shouldContinueExecuting() && this.guardian.getDistanceSq(this.guardian.getAttackTarget()) > 0.0D;
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
                    else if (this.tickCounter >= this.guardian.getAttackDuration())
                    {
                        float f = 1.0F;
                        
                        
                        if (this.guardian.world.getDifficulty() == EnumDifficulty.HARD)
                        {
                            f += 2.0F;
                        } 
                        
                        entitylivingbase.attackEntityFrom(DamageSource.causeThrownDamage(this.guardian, this.guardian), f);
                        entitylivingbase.attackEntityFrom(DamageSource.causeMobDamage(this.guardian), (float)this.guardian.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
                        this.guardian.setAttackTarget((EntityLivingBase)null);
                    }
                    
                    super.updateTask();
                }
            }
        }
	    
	    static class AISquidMeleeAttack extends EntityAIAttackMelee
        {
	    	private final EntityVampireSquid entityGuardian;
	    	
            public AISquidMeleeAttack(EntityVampireSquid spider)
            {
                super(spider, 1.0D, true);
                this.entityGuardian = spider;
            }

            /**
             * Returns whether an in-progress EntityAIBase should continue executing
             */
            public boolean shouldContinueExecuting()
            {
                float f = this.attacker.getBrightness();

                if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0)
                {
                	
                    this.attacker.setAttackTarget((EntityLivingBase)null);
                    return false;
                }
                else
                {
                	this.entityGuardian.setMoving(true);
                    return super.shouldContinueExecuting();
                }
            }
            

            protected double getAttackReachSqr(EntityLivingBase attackTarget)
            {
                return (double)(1.0F + attackTarget.width);
            }
        }
	    
	    static class TargetSelector implements Predicate<EntityLivingBase>{
	        
	    	private final EntityVampireSquid parentEntity;

	            public TargetSelector(EntityVampireSquid guardian)
	            {
	                this.parentEntity = guardian;
	            }

	            public boolean apply(@Nullable EntityLivingBase p_apply_1_)
	            {
	                return (p_apply_1_ instanceof EntityPlayer || p_apply_1_ instanceof EntitySquid || p_apply_1_ instanceof EntityIronGolem) && p_apply_1_.getDistanceSq(this.parentEntity) > 9.0D;
	            }
	        }
}
