package com.SmellyModder.TheLostSea.common.entity.passive;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;
import com.SmellyModder.TheLostSea.core.util.handlers.LootTableHandler;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShark extends EntityMob{

	private static final DataParameter<Boolean> MOVING = EntityDataManager.<Boolean>createKey(EntityShark.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TARGETED_ENTITY = EntityDataManager.<Integer>createKey(EntityShark.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> ISINWATER = EntityDataManager.<Boolean>createKey(EntityShark.class, DataSerializers.BOOLEAN);
	protected EntityAIWander wander;
	private EntityLivingBase targetedEntity;
	private int attackTimer;
	
	public EntityShark(World worldIn) {
		super(worldIn);
		setSize(1.65F, 0.87F);
		this.experienceValue = 6;
		moveHelper = new EntityShark.SharkMoveHelper(this);
		this.setPathPriority(PathNodeType.BLOCKED, -8.0F);
		this.setPathPriority(PathNodeType.WATER, 17.0F);
		this.setPathPriority(PathNodeType.WALKABLE, -8.0F);
	}
	
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAIAttackMelee(this, 0.8D, true) {
            @Override
            protected double getAttackReachSqr(EntityLivingBase attackTarget) {
                return 2.12D + attackTarget.width;
            }
        });
		this.wander = new EntityAIWander(this, 1.0D, 3);
		this.tasks.addTask(4, this.wander);
		this.wander.setMutexBits(3);
		tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 0.4D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityLivingBase.class, 8.0F));
	    tasks.addTask(8, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAnglerfish.class, false));
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

				if (getAttackTarget() == null) {
					motionY -= 0.001D;
				}
			} else {
				super.travel(strafe, up, forward);
			}
		} else {
			super.travel(strafe, up, forward);
		}
	}
	
	@Override
	public float getEyeHeight() {
		return this.height * 0.76F;
	}
	
	protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateSwimmer(this, worldIn);
    }
	
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableHandler.SHARK;
	}
	
	public float getBlockPathWeight(BlockPos pos)
    {
        return this.world.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.world.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.isInWater()) {
			this.setAir(300);
			if (this.isMoving())
            {
                Vec3d vec3d = this.getLook(0.0F);

                for (int i = 0; i < 2; ++i)
                {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3d.x * 1.5D, this.posY + this.rand.nextDouble() * (double)this.height - vec3d.y * 1.5D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width - vec3d.z * 1.5D, 0.0D, 0.0D, 0.0D);
                }
            }
		}
		if(!this.isInWater()) {
			this.setAIMoveSpeed(0.1F);
		}
	}
	public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
    }
	
	public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte) 4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (12 + this.rand.nextInt(3)));

        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.BLOCK_WOOD_BREAK, 10.0F, 0.90F);
        return flag;
    }
	
	 	@SideOnly(Side.CLIENT)
	    public void handleStatusUpdate(byte id)
	    {
	        if (id == 4)
	        {
	            this.attackTimer = 10;
	            this.playSound(SoundEvents.ENTITY_GENERIC_SPLASH, 1.0F, 1.0F);
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
	
	 protected void applyEntityAttributes(){
	     super.applyEntityAttributes();
	     this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
	     this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.64000000298023224D);
	 }
	 
	 protected void entityInit()
	 {
	    super.entityInit();
	    this.dataManager.register(MOVING, Boolean.valueOf(false));
	    this.dataManager.register(TARGETED_ENTITY, Integer.valueOf(0));
	 }
	 
	 private void setTargetedEntity(int entityId)
	 {
	        this.dataManager.set(TARGETED_ENTITY, Integer.valueOf(entityId));
	 }

	 public boolean hasTargetedEntity()
	 {
	        return ((Integer)this.dataManager.get(TARGETED_ENTITY)).intValue() != 0;
	 }
	 
	 public boolean isMoving()
	 {
	    return ((Boolean)this.dataManager.get(MOVING)).booleanValue();
	 }

	 private void setMoving(boolean moving)
	 {
	    this.dataManager.set(MOVING, Boolean.valueOf(moving));
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
	                Entity entity = this.world.getEntityByID(((Integer)this.dataManager.get(TARGETED_ENTITY)).intValue());

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

	        if (TARGETED_ENTITY.equals(key))
	        {
	            this.targetedEntity = null;
	        }
	    }
	
	static class SharkMoveHelper extends EntityMoveHelper {
        private final EntityShark shark;

        public SharkMoveHelper(EntityShark shark) {
            super(shark);
            this.shark = shark;
        }

        @Override
		public void onUpdateMoveHelper() {
            if (action == EntityMoveHelper.Action.MOVE_TO && !shark.getNavigator().noPath()){
            	double d0 = this.posX - this.shark.posX;
                double d1 = this.posY - this.shark.posY;
                double d2 = this.posZ - this.shark.posZ;
                double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float)(MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
                this.shark.rotationYaw = this.limitAngle(this.shark.rotationYaw, f, 90.0F);
                this.shark.renderYawOffset = this.shark.rotationYaw;
                float f1 = (float)(this.speed * this.shark.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.shark.setAIMoveSpeed(this.shark.getAIMoveSpeed() + (f1 - this.shark.getAIMoveSpeed()) * 0.125F);
                double d4 = Math.sin((double)(this.shark.ticksExisted + this.shark.getEntityId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.shark.rotationYaw * 0.017453292F));
                double d6 = Math.sin((double)(this.shark.rotationYaw * 0.017453292F));
                this.shark.motionX += d4 * d5;
                this.shark.motionZ += d4 * d6;
                d4 = Math.sin((double)(this.shark.ticksExisted + this.shark.getEntityId()) * 0.75D) * 0.05D;
                this.shark.motionY += d4 * (d6 + d5) * 0.25D;
                this.shark.motionY += (double)this.shark.getAIMoveSpeed() * d1 * 0.1D;
                EntityLookHelper entitylookhelper = this.shark.getLookHelper();
                double d7 = this.shark.posX + d0 / d3 * 2.0D;
                double d8 = (double)this.shark.getEyeHeight() + this.shark.posY + d1 / d3;
                double d9 = this.shark.posZ + d2 / d3 * 2.0D;
                double d10 = entitylookhelper.getLookPosX();
                double d11 = entitylookhelper.getLookPosY();
                double d12 = entitylookhelper.getLookPosZ();

                if (!entitylookhelper.getIsLooking())
                {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }
                
                this.shark.setMoving(true);
                shark.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
            } else {
                shark.setAIMoveSpeed(0.0F);
                this.shark.setMoving(false);
            }
        }
    }

}
