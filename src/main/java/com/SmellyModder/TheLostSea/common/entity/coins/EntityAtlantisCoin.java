package com.SmellyModder.TheLostSea.common.entity.coins;

import com.SmellyModder.TheLostSea.client.particle.LostSeaParticles;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.MessageRequestCoins;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.swing.TextComponent;

public class EntityAtlantisCoin extends EntityLiving {
	
	public int score() {
		switch(this.getCoinType()) {
		case SMALL:
			default:
				return 1;
			case NORMAL:
				return this.getRNG().nextInt(3);
			case LARGE:
				return this.getRNG().nextInt(5) + 10;
			case BIG:
				return this.getRNG().nextInt(10) + 20;
			case GIANT:
				return this.getRNG().nextInt(20) + 30;
		}
	}
	
	public int pickupDelay;
	private int age;
	private int blink;
	
    private EntityPlayer closestPlayer;

	private static final DataParameter<Integer> BLINK_TIME = EntityDataManager.<Integer>createKey(EntityAtlantisCoin.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> COIN_SIZE = EntityDataManager.<Integer>createKey(EntityAtlantisCoin.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> IS_BOUNCING = EntityDataManager.<Boolean>createKey(EntityAtlantisCoin.class, DataSerializers.BOOLEAN);
	public EntityAtlantisCoin(World worldIn) {
		super(worldIn);
		this.setSize(0.45F, 0.45F);
		this.rotationYaw = (float)(Math.random() * 360.0D);
        this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
        this.motionY = (double)((float)(Math.random() * 0.2D) * 2.0F);
        this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
	}
	
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(COIN_SIZE, Integer.valueOf(0));
        this.dataManager.register(BLINK_TIME, Integer.valueOf(0));
        this.dataManager.register(IS_BOUNCING, Boolean.valueOf(false));
    }
	
	public boolean isBouncing()
	{
	    return ((Boolean)this.dataManager.get(IS_BOUNCING)).booleanValue();
	}

	private void setBouncing(boolean bounce)
	{
	    this.dataManager.set(IS_BOUNCING, Boolean.valueOf(bounce));
	}
	
	public int getBlinkSpeed() {
		return this.dataManager.get(BLINK_TIME).intValue();
	}
	
	public void setBlinkSpeed(int speed) {
		this.dataManager.set(BLINK_TIME, speed);;
	}
	
	protected boolean canTriggerWalking()
    {
        return false;
    }
	
	public boolean canBeAttackedWithItem()
    {
        return false;
    }
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	public void onCollideWithPlayer(EntityPlayer player) {
		
		ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null);
		if (!this.world.isRemote)
        {
            if (this.pickupDelay == 0)
            {
                coins.fill(score());
                if(player instanceof EntityPlayerMP) {
        			TheLostSea.NETWORK.sendTo(new MessageCoins(coins.getCoins()), (EntityPlayerMP) player);
        		}
                pickupDelay++;
                this.playSound(TLSSounds.COIN_COLLECT, 0.25F, rand.nextInt(2) * 0.50F);
                player.onItemPickup(this, 1);
                
                this.setDead();
                
            }
        }
	}
	@Override
	protected void collideWithNearbyEntities() {
		return;
	}
	
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        if (!this.isInWater())
        {
            this.handleWaterMovement();
        }
        if (onGroundIn)
        {
            if (this.fallDistance > 0.0F)
            {
                state.getBlock().onFallenUpon(this.world, pos, this, this.fallDistance);
            }

            this.fallDistance = 0.0F;
        }
        else if (y < 0.0D)
        {
            this.fallDistance = (float)((double)this.fallDistance - y);
        }
    }
	
	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return null;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return null;
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		if(!this.hasNoGravity()) {
			if(rand.nextInt(2) == 1) {
				this.motionX = -(double)((float)(Math.random() * 0.22000000298023224D - 0.10000000149011612D) * 2.0F);
				this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
				this.setBouncing(true);
			}else {
				this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
				this.motionZ = -(double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
			}
			
		
		}
		return super.onInitialSpawn(difficulty, livingdata);
	}
	
	@Override
	public void fall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
		
		if (this.motionY < 0.0D && this.isBouncing())
        {
            this.motionY = -this.motionY;

            if (!(this instanceof EntityLivingBase))
            {
                this.motionY *= 0.8D;
            }
        }
	}
	
	@Override
	protected void createRunningParticles() {
		return;
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		
		++this.age;
		
		if(age > 0) {
			if(age >= 500) {
				++this.blink;
				if(blink > 8) {
					this.setBlinkSpeed(3);
				} else {
					this.setBlinkSpeed(0);
				}
			}
			if(age >= 600) {
				this.setDead();
			}
		}		
		if(blink >= 12) {
			blink = 0;
		}
        
        if (this.world.isRemote && this.getCoinType() == EntityAtlantisCoin.Size.GIANT)
            {
                for (int i = 0; i < 2; ++i)
                {
                    LostSeaParticles.AQUA_PORTAL.spawn(getEntityWorld(), posX, posY, posZ, this.motionX * Math.random() * 2.222F, this.motionY, this.motionZ);
                }
            }
	}
	
	public void onUpdate()
    {
        super.onUpdate();
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.pickupDelay > 0)
        {
            --this.pickupDelay;
        }
       

        //this.prevPosX = this.posX;
        //this.prevPosY = this.posY;
        //this.prevPosZ = this.posZ;

        if (!this.hasNoGravity())
        {
            this.motionY -= 0.026999999329447746D;
        }
        this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D, this.posZ);
        
        if (this.closestPlayer == null || this.closestPlayer.getDistanceSq(this) > 64.0D)
        {
            this.closestPlayer = this.world.getClosestPlayerToEntity(this, 8.0D);
        }

        if (this.closestPlayer != null && this.closestPlayer.isSpectator())
        {
        	this.closestPlayer = null;
        }
        
        if (this.closestPlayer != null)
        {
            double d1 = (this.closestPlayer.posX - this.posX) / 8.0D;
            double d2 = (this.closestPlayer.posY + (double)this.closestPlayer.getEyeHeight() / 2.0D - this.posY) / 8.0D;
            double d3 = (this.closestPlayer.posZ - this.posZ) / 8.0D;
            double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 1.0D - d4;

            if (d5 > 0.0D)
            {
                d5 = d5 * d5;
                this.motionX += d1 / d4 * d5 * 0.08D;
                this.motionY += d2 / d4 * d5 * 0.08D;
                this.motionZ += d3 / d4 * d5 * 0.08D;
            }
        }
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        
        
        float f = 0.98F;

        if (this.onGround)
        {
            BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
            net.minecraft.block.state.IBlockState underState = this.world.getBlockState(underPos);
            f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.98F;
        }

        this.motionX *= (double)f;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= (double)f;

        if (this.onGround)
        {
            //this.motionY *= -0.8999999761581421D;
        }
    }
	
	public void randSpray(int randomness) {
		this.motionX = (double)((float)(Math.random() * 0.22000000298023224D - 0.10000000149011612D) * 2.0F);
		this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
		this.motionY = (double)((float)(Math.random() * 0.2D) * 2.0F);
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override
	public boolean canRenderOnFire() {
	    return false;
	}
	
	@Override
	public float getBrightness() {
		return 1.0F;
	}
	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        float f = 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        int i = super.getBrightnessForRender();
        int j = i & 255;
        int k = i >> 16 & 255;
        j = j + (int)(f * 15.0F * 16.0F);

        if (j > 240)
        {
            j = 240;
        }

        return j | k << 16;
    }
	
	public void setCoinType(EntityAtlantisCoin.Size type)
    {
        this.dataManager.set(COIN_SIZE, Integer.valueOf(type.ordinal()));
    }

    public EntityAtlantisCoin.Size getCoinType()
    {
        return EntityAtlantisCoin.Size.byId(((Integer)this.dataManager.get(COIN_SIZE)).intValue());
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setString("Size", this.getCoinType().getName());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("Size", 8))
        {
            this.setCoinType(EntityAtlantisCoin.Size.getTypeFromString(compound.getString("Size")));
        }
    }
	
	 public static enum Size
	    {
	        SMALL(BlockPlanks.EnumType.OAK.getMetadata(), "small"),
	        NORMAL(BlockPlanks.EnumType.SPRUCE.getMetadata(), "normal"),
	        LARGE(BlockPlanks.EnumType.BIRCH.getMetadata(), "large"),
	        BIG(BlockPlanks.EnumType.JUNGLE.getMetadata(), "big"),
	        GIANT(BlockPlanks.EnumType.ACACIA.getMetadata(), "giant");

	        private final String name;
	        private final int metadata;

	        private Size(int metadataIn, String nameIn)
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

	        
	        public static EntityAtlantisCoin.Size byId(int id)
	        {
	            if (id < 0 || id >= values().length)
	            {
	                id = 0;
	            }

	            return values()[id];
	        }

	        public static EntityAtlantisCoin.Size getTypeFromString(String nameIn)
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
}
