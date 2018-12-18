package com.SmellyModder.TheLostSea.common.entity;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.util.handlers.LootTableHandler;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAnglerfish extends EntityMob {
	
	private static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntityAnglerfish.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> LIGHT_ON = EntityDataManager.<Boolean>createKey(EntityAnglerfish.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> AMOVING = EntityDataManager.<Boolean>createKey(EntityAnglerfish.class, DataSerializers.BOOLEAN);
	
	protected EntityAIWander wander;
	protected double damage;
	public boolean isFlipped = true;
	
	public EntityAnglerfish(World worldIn) {
		super(worldIn);
		setSize(0.55F, 0.55F);
		this.experienceValue = (int) 2.7F;
		this.damage = 2.0D;
		moveHelper = new EntityAnglerfish.AnglerMoveHelper(this);
//		this.setPathPriority(PathNodeType.BLOCKED, -8.0F);
//		this.setPathPriority(PathNodeType.WALKABLE, 0.0F);
//		this.setPathPriority(PathNodeType.WATER, 16F);
	}
	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAIAttackMelee(this, 0.8D, true) {
            @Override
            protected double getAttackReachSqr(EntityLivingBase attackTarget) {
                return 0.75D + attackTarget.width;
            }
        });
		tasks.addTask(2, new EntityAIWander(this, 0.5D, 20));
		tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 0.4D));
		tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	    tasks.addTask(8, new EntityAILookIdle(this));
	    this.tasks.addTask(4, new EntityAnglerfish.AIGlowLure(this, 1));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	public boolean isGrounded() {
        return !isInWater() && world.isAirBlock(new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY + 1), MathHelper.floor(posZ))) && world.getBlockState(new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY - 1), MathHelper.floor(posZ))).getBlock().isCollidable();
    }
	public boolean isMoving()
	{
	    return ((Boolean)this.dataManager.get(AMOVING)).booleanValue();
	}

	private void setMoving(boolean moving)
	{
	    this.dataManager.set(AMOVING, Boolean.valueOf(moving));
	}
	@Override
	public void travel(float strafe, float up, float forward) {
		if (isServerWorld()) {
			if (isInWater()) {
				moveRelative(strafe, up,  forward, 0.1F);
				move(MoverType.SELF, motionX, motionY, motionZ);
				motionX *= 0.7999999761581421D;
				motionY *= 0.9D;
				motionZ *= 0.8799999761581421D;

			} else {
				super.travel(strafe, up, forward);
			}
		} else {
			super.travel(strafe, up, forward);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		
		this.playSound(TLSSounds.ANGLER_BITE, 1.0F, 0.9F);
		return super.attackEntityAsMob(entityIn);
		
	}
	
	@Override
    protected PathNavigate createNavigator(World world){
        return new PathNavigateSwimmer(this, world);
    }
	public float getBlockPathWeight(BlockPos pos)
    {
        return this.world.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.world.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
    }
	
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        this.setVariant(this.rand.nextInt(2));
        return super.onInitialSpawn(difficulty, livingdata);
    }
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(13.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.65D);
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.isLightOn() == true && this.getRNG().nextFloat() < 0.001F){
			this.setLightOn(false);
		}
		if(this.isLightOn() == true) {
			this.damage = 15;
		}
		if(!this.isLightOn()) {
			this.damage = 2;
		}
	}
	
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return this.isLightOn() ? 15728880 : super.getBrightnessForRender();
    }
	/**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return this.isLightOn() ? 1.0F : super.getBrightness();
    }
	
	@Override
	public void onLivingUpdate() {
		if (inWater) {
			setAir(300);
		} else if (onGround) {
			motionY += 0.34D;
			motionX += (double) ((rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
			motionZ += (double) ((rand.nextFloat() * 2.1F - 1.0F) * 0.3F);
			rotationYaw = rand.nextFloat() * 360.0F;
			if(getEntityWorld().getTotalWorldTime() % 5 == 0)
				getEntityWorld().playSound((EntityPlayer) null, posX, posY, posZ, SoundEvents.ENTITY_GUARDIAN_FLOP, SoundCategory.HOSTILE, 1F, 1F);
				damageEntity(DamageSource.DROWN, 0.5F);
		}
		super.onLivingUpdate();
	}
	
	
	@Override
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
	}
	
	@Override
	protected ResourceLocation getLootTable() 
	{
		return LootTableHandler.ANGLER_FISH;
	}
	@Override
	public float getEyeHeight() {
		
		return this.height * 0.78F;
	}
	
	public int getVariant()
    {
        return MathHelper.clamp(((Integer)this.dataManager.get(VARIANT)).intValue(), 0, 4);
    }

    public void setVariant(int p_191997_1_)
    {
        this.dataManager.set(VARIANT, Integer.valueOf(p_191997_1_));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(VARIANT, Integer.valueOf(0));
	    this.dataManager.register(LIGHT_ON, Boolean.valueOf(false));
	    this.dataManager.register(AMOVING, Boolean.valueOf(false));
    }
    
    public boolean isLightOn()
    {
        return ((Boolean)this.dataManager.get(LIGHT_ON)).booleanValue();
    }

    private void setLightOn(boolean light)
    {
        this.dataManager.set(LIGHT_ON, Boolean.valueOf(light));
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
    
    static class AnglerMoveHelper extends EntityMoveHelper {
        private final EntityAnglerfish angler;

        public AnglerMoveHelper(EntityAnglerfish angler) {
            super(angler);
            this.angler = angler;
        }

        @Override
		public void onUpdateMoveHelper() {
        	if (action == EntityMoveHelper.Action.MOVE_TO && !angler.getNavigator().noPath() && !angler.isLightOn()){
            	double d0 = this.posX - this.angler.posX;
                double d1 = this.posY - this.angler.posY;
                double d2 = this.posZ - this.angler.posZ;
                double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float)(MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
                this.angler.rotationYaw = this.limitAngle(this.angler.rotationYaw, f, 90.0F);
                this.angler.renderYawOffset = this.angler.rotationYaw;
                float f1 = (float)(this.speed * this.angler.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.angler.setAIMoveSpeed(this.angler.getAIMoveSpeed() + (f1 - this.angler.getAIMoveSpeed()) * 0.125F);
                double d4 = Math.sin((double)(this.angler.ticksExisted + this.angler.getEntityId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.angler.rotationYaw * 0.017553292F));
                double d6 = Math.sin((double)(this.angler.rotationYaw * 0.017453292F));
                this.angler.motionX += d4 * d5;
                this.angler.motionZ += d4 * d6;
                d4 = Math.sin((double)(this.angler.ticksExisted + this.angler.getEntityId()) * 0.75D) * 0.05D;
                this.angler.motionY += d4 * (d6 + d5) * 0.25D;
                this.angler.motionY += (double)this.angler.getAIMoveSpeed() * d1 * 0.1D;
                EntityLookHelper entitylookhelper = this.angler.getLookHelper();
                double d7 = this.angler.posX + d0 / d3 * 2.0D;
                double d8 = (double)this.angler.getEyeHeight() + this.angler.posY + d1 / d3;
                double d9 = this.angler.posZ + d2 / d3 * 2.0D;
                double d10 = entitylookhelper.getLookPosX();
                double d11 = entitylookhelper.getLookPosY();
                double d12 = entitylookhelper.getLookPosZ();

                if (!entitylookhelper.getIsLooking())
                {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }
                angler.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                this.angler.setMoving(true);
            } else {
                angler.setAIMoveSpeed(0.0F);
                this.angler.setMoving(false);
            }
        }
    }
    static class AIGlowLure extends EntityAIBase{

    	 private final EntityAnglerfish angler;
    	 protected int chance;

         public AIGlowLure(EntityAnglerfish angler, int chanceOf) {
             super();
             this.angler = angler;
             this.chance = chanceOf;
             this.setMutexBits(4);
         }
    	
		@Override
		public boolean shouldExecute() {
			return angler.isLightOn() ? false : true;
		}
		
		public void updateTask()
	    {
	        if (this.angler.getRNG().nextInt(6200) + 1 < 4)
	        {
	        	if(!angler.isMoving() && angler.getHealth() == angler.getMaxHealth()){
	        		this.angler.setLightOn(true);
	        	}
	        }
	    }
    	
    }
}
