package com.SmellyModder.TheLostSea.common.entity.bases;

import java.util.UUID;


import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.container.ContainerSubUpgrades;
import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.core.util.handlers.SoundHandler;
import com.google.common.base.Optional;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ContainerHorseChest;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author Luke Tonon
 *
 */
public abstract class AbstractSubmarine extends EntityCreature implements IJumpingMount, IInventoryChangedListener
{
	protected static final IAttribute BOOST_STRENGTH = (new RangedAttribute((IAttribute)null, "sub.boost", 0.7D, 0.0D, 2.0D)).setDescription("Boost's the subs speed").setShouldWatch(true);
	private static final DataParameter<Byte> STATUS = EntityDataManager.<Byte>createKey(AbstractSubmarine.class, DataSerializers.BYTE);
    private static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(AbstractSubmarine.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    
    public int boostCounter;
    public int jumpRearingCounter;
    protected boolean yBoost;
    protected float jumpPower;
    protected boolean isUp;
    protected boolean canBoost = true;
    private boolean boosting;
    private int totalBoostTime;
    protected ContainerSubUpgrades subChest;
    /** Used to determine the sound that the sub should make when it steps */
    protected int boostTime;
    
    /*
     * Animator values
     */
    protected float clientSideBoostAnimation;
    protected float clientSideBoostAnimationO;
    protected float clientSideBoostAnimationSpeed;
    private static final DataParameter<Boolean> MOVING = EntityDataManager.<Boolean>createKey(AbstractSubmarine.class, DataSerializers.BOOLEAN);
    
    public AbstractSubmarine(World worldIn)
    {
        super(worldIn);
        this.experienceValue = 5;
        this.clientSideBoostAnimation = this.rand.nextFloat();
        this.clientSideBoostAnimationO = this.clientSideBoostAnimation;
    }
    
    
    public SoundCategory getSoundCategory()
    {
        return SoundCategory.PLAYERS;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(STATUS, Byte.valueOf((byte)0));
        this.dataManager.register(OWNER_UNIQUE_ID, Optional.absent());
        this.dataManager.register(MOVING, Boolean.valueOf(false));
    }
    public boolean isMoving()
    {
        return ((Boolean)this.dataManager.get(MOVING)).booleanValue();
    }

    private void setMoving(boolean moving)
    {
        this.dataManager.set(MOVING, Boolean.valueOf(moving));
    }
   
    
    public boolean isSubBoostingUp()
    {
        return this.isUp;
    }
    
    public void setSubBoostingUp(boolean jumping)
    {
        this.isUp = jumping;
    }
    
    public boolean canBePushed()
    {
        return !this.isBeingRidden();
    }
    
    public double getBoostStrength()
    {
        return this.getEntityAttribute(BOOST_STRENGTH).getAttributeValue();
    }
    
    public void onUpdate()
    {
        super.onUpdate();
        if (this.canPassengerSteer() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20)
        {
            this.jumpRearingCounter = 0;
        }


        if (this.boostCounter > 0)
        {
            ++this.boostCounter;

            if (this.boostCounter > 300)
            {
                this.boostCounter = 0;
            }
        }
    }

    protected SoundEvent getSwimSound()
    {
        return SoundEvents.ENTITY_HOSTILE_SWIM;
    }

    protected SoundEvent getSplashSound()
    {
        return SoundEvents.ENTITY_HOSTILE_SPLASH;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return this.isEntityInvulnerable(source) ? false : super.attackEntityFrom(source, amount);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.BLOCK_METAL_HIT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }

    protected SoundEvent getFallSound(int heightIn)
    {
        return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
    }

    public float getBlockPathWeight(BlockPos pos)
    {
        return 0.5F - this.world.getLightBrightness(pos);
    }
    
   
    public int getTalkInterval() {
    	return 235;
    }
    
    protected SoundEvent getAmbientSound()
    {
        return this.isInWater() ? SoundHandler.SONAR_WAVE : SoundEvents.ENTITY_MINECART_INSIDE;
    }
    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering())
            {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttributeMap().registerAttribute(BOOST_STRENGTH);
    }

    protected void mountTo(EntityPlayer player)
    {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;

        if (!this.world.isRemote)
        {
            player.startRiding(this);
        }
    }
    
    protected boolean isMovementBlocked()
    {
        return super.isMovementBlocked() && this.isBeingRidden();
    }
    
    protected boolean canDropLoot()
    {
        return true;
    }

    public boolean isPreventingPlayerRest(EntityPlayer playerIn)
    {
        return false;
    }
	
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        if (!super.processInteract(player, hand))
        {
            ItemStack itemstack = player.getHeldItem(hand);

            if (itemstack.getItem() == Items.NAME_TAG)
            {
                itemstack.interactWithEntity(player, this, hand);
                return true;
            }
            else if (!this.isBeingRidden())
            {
                if (!this.world.isRemote)
                {
                    player.startRiding(this);
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    @Override
    public double getMountedYOffset()
    {
        return (double)this.height * 0.35D;
    }
    
	public void onLivingUpdate()
    {
		this.updateArmSwingProgress();
        float f = this.getBrightness();

        if (f > 0.5F)
        {
            this.idleTime += 2;
        }
		if (this.inWater)
        {
            this.setAir(300);
        } 
		if (this.world.isRemote)
	    {
	       this.clientSideBoostAnimationO = this.clientSideBoostAnimation;

	            if (!this.isInWater())
	            {
	                this.clientSideBoostAnimationSpeed = 2.0F;
	            }
	            else if (this.isMoving())
	            {
	                if (this.clientSideBoostAnimationSpeed < 0.5F)
	                {
	                    this.clientSideBoostAnimationSpeed = 4.0F;
	                }
	                else
	                {
	                    this.clientSideBoostAnimationSpeed += (0.5F - this.clientSideBoostAnimationSpeed) * 0.1F;
	                }
	            }
	            else
	            {
	                this.clientSideBoostAnimationSpeed += (0.125F - this.clientSideBoostAnimationSpeed) * 0.2F;
	            }

	            this.clientSideBoostAnimation += this.clientSideBoostAnimationSpeed;

	            if (this.isMoving() && this.isInWater())
	            {
	                Vec3d vec3d = this.getLook(0.0F);

	                for (int i = 0; i < 2; ++i)
	                {
	                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.height - vec3d.x * 1.5D, this.posY + this.rand.nextDouble() * (double)this.height - vec3d.y * 1.5D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
	                }
	            }
	    }
		
		super.onLivingUpdate();
    }
	
	@SideOnly(Side.CLIENT)
    public float getBoosterAnimation(float p_175471_1_)
    {
        return this.clientSideBoostAnimationO + (this.clientSideBoostAnimation - this.clientSideBoostAnimationO) * p_175471_1_;
    }
	
	@Nullable
    public Entity getControllingPassenger()
    {
        return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
    }
	
	public boolean canBeSteered()
    {
		return this.getControllingPassenger() instanceof EntityLivingBase;
    }
	
	public void travel(float strafe, float vertical, float forward)
    {
		if (this.isBeingRidden() && this.canBeSteered())
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            strafe = entitylivingbase.moveStrafing * 0.5F;
            forward = entitylivingbase.moveForward;
            
            entitylivingbase.setAir(300);
            
            if (forward <= 0.0F)
            {
                forward *= 0.25F;
                this.setMoving(true);
            }

            if (this.onGround && this.jumpPower == 0.0F)
            {
                strafe = 0.0F;
                forward = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isSubBoostingUp() && this.isInWater())
            {
                this.motionY = this.getBoostStrength() * (double)this.jumpPower;

                if (this.isPotionActive(MobEffects.JUMP_BOOST))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
                }

                this.setSubBoostingUp(true);
                this.isAirBorne = true;

                if (forward > 0.0F)
                {
                    float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
                    float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                    this.motionX += (double)(-0.4F * f * this.jumpPower);
                    this.motionZ += (double)(0.4F * f1 * this.jumpPower);
                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (this.canPassengerSteer())
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                super.travel(strafe, vertical, forward);
            }
            else if (entitylivingbase instanceof EntityPlayer)
            {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }

            if (this.isWet())
            {
                this.jumpPower = 0.0F;
                this.setSubBoostingUp(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

            if (f2 > 1.0F)
            {
                f2 = 1.0F;
            }

            this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.jumpMovementFactor = 0.02F;
            super.travel(strafe, vertical, forward);
        }
    }
	
	@Override
    protected float getWaterSlowDown() {
    	return 0.84F;
	}
	
	 public static void registerFixesAbstracSub(DataFixer fixer, Class<?> entityClass)
	    {
	        EntityLiving.registerFixesMob(fixer, entityClass);
	    }
	 
	 @SideOnly(Side.CLIENT)
	    public void setJumpPower(int jumpPowerIn)
	    {
	        if (this.isInWater())
	        {
	            if (jumpPowerIn < 0)
	            {
	                jumpPowerIn = 0;
	            }
	            else
	            {
	               
	            }

	            if (jumpPowerIn >= 90)
	            {
	                this.jumpPower = 1.0F;
	            }
	            else
	            {
	                this.jumpPower = 0.4F + 0.4F * (float)jumpPowerIn / 90.0F;
	            }
	        }
	    }

	    public boolean canJump()
	    {
	        return this.isInWater();
	    }

	    public void handleStartJump(int p_184775_1_)
	    {
	    }

	    public void handleStopJump()
	    {
	    }
	
}
