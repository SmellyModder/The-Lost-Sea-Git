package com.SmellyModder.TheLostSea.common.entity.projectiles;

import java.util.List;

import javax.annotation.Nullable;
import javax.vecmath.Vector3d;

import com.SmellyModder.TheLostSea.common.entity.bases.LSProjectile;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDisc extends LSProjectile implements IEntityAdditionalSpawnData {

	protected int tickDeath = 0;
	
	 private boolean bouncing;

	private double newX, newY, newZ;
	
	private int bounceCount;
	
	public float spin, prevSpin;
	
	public boolean shouldSummon2 = false;
	
	private int damageToDeal() {
		switch (this.getDiscType())
        {
		case PRISMARINE:
			default:
			return 6;
		case DIAMOND:
			return 9;
		case GOLD:
			return 5;
		case IRON:
			return 7;
		case STONE:
			return 6;
		case WOOD:
			return 4;
        }
        }
	
	public boolean createBolts = false;
	public int setDiscType;
	public int speedForType() {
		switch (this.getDiscType())
        {
		case PRISMARINE:
			default:
			return 3;
		case DIAMOND:
			return 2;
		case GOLD:
			return 1;
		case IRON:
			return 2;
		case STONE:
			return 2;
		case WOOD:
			return 3;
        }
	}
	
	private float weightForType(){
		switch (this.getDiscType())
        {
		case PRISMARINE:
			default:
			return 0F;
		case DIAMOND:
			return 0.001F;
		case GOLD:
			return 0.002F;
		case IRON:
			return 0.001F;
		case STONE:
			return 0F;
		case WOOD:
			return 0F;
        }
	}
	
	
	
	private static final DataParameter<Integer> DISC_TYPE = EntityDataManager.<Integer>createKey(EntityDisc.class, DataSerializers.VARINT);
	
	public EntityDisc(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0F);
	}
	
	protected void entityInit()
    {
        this.dataManager.register(DISC_TYPE, Integer.valueOf(EntityDisc.TypeOfDisc.PRISMARINE.ordinal()));
    }
	
	

	public EntityDisc(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }
	
	

    public EntityDisc(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesDisc(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Disc");
    }
    
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }
    
    
    
	@Override
	protected void onImpact(RayTraceResult result) {
		 if (result.entityHit != null)
	        {
			 
			 Entity entity = result.entityHit;
			 
	            int i = rand.nextInt(this.damageToDeal()) + 9;
	            
	            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
	            
	            if(isBurning()) {
	            	entity.setFire(100);
	            }
	        }
		 
		 double velSq = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;
	        if (getEntityWorld().isRemote) {
	            getEntityWorld().playSound(this.posX, this.posY, this.posZ, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.HOSTILE, (float) (0.75f * velSq), 0.5f, false);
	        }
	        if (result.typeOfHit == Type.ENTITY) {
	            if (result.entityHit instanceof EntityPlayer && ((EntityPlayer) result.entityHit).capabilities.isCreativeMode) {
	                return;
	            }
	            if (!getEntityWorld().isRemote) {
	               
	                this.setDead();
	            }
	        } else if (result.typeOfHit == Type.BLOCK) {

	            World world = getEntityWorld();
	            
	            BlockPos blockpos = new BlockPos(this);
	            
	            BlockPos hitLoc = result.getBlockPos();
	            if (hitLoc == null) {
	                return;
	            }
	            IBlockState hit = world.getBlockState(hitLoc);
	            float hardness = hit.getBlockHardness(world, hitLoc);
	            if (hardness >= 0 && hardness < velSq * 0.5) {
	                if (!getEntityWorld().isRemote) {
	                    world.destroyBlock(hitLoc, true);
	                }if(createBolts == true) {
	                	int i = hitLoc.getX();
	        			int j = hitLoc.getY();
	        			int k = hitLoc.getZ();
	        			world.addWeatherEffect(new EntityLightningBolt(world, i, j, k, false));
	                }
	                float damping = this.getBounceSpeedFactor() - hardness;
	                this.motionX *= damping;
	                this.motionY *= damping;
	                this.motionZ *= damping;
	            }
	        
	            if (hit.getCollisionBoundingBox(world, hitLoc) != Block.NULL_AABB) {
	                
	                
	                if (velSq < 0.1) {
	                    if (!getEntityWorld().isRemote) {
	                        setDead();
	                        return;
	                    }
	                }
	                Vector3d motionVec = new Vector3d(this.motionX, this.motionY, this.motionZ);
	                Vec3i dirVec = result.sideHit.getDirectionVec();
	                Vector3d bounceVec = new Vector3d(dirVec.getX(), dirVec.getY(), dirVec.getZ());
	                motionVec.x *= bounceVec.x;
	                motionVec.y *= bounceVec.y;
	                motionVec.z *= bounceVec.z;
	                
	                if (motionVec.lengthSquared() < 0.001) {
	                    motionVec.scale(4);
	                    this.motionX += motionVec.x;
	                    this.motionY += motionVec.y;
	                    this.motionZ += motionVec.z;
	                }
	                bounceCount++;
	                bouncing = true;
	                this.newX = this.motionX;
	                this.newY = this.motionY;
	                this.newZ = this.motionZ;
	                switch (result.sideHit.getAxis()) {
	                case X:
	                    this.newX = -this.newX;
	                    break;
	                case Y:
	                    this.newY = -this.newY;
	                    break;
	                case Z:
	                    this.newZ = -this.newZ;
	                    break;
	                }
	                this.motionX = 0;
	                this.motionY = 0;
	                this.motionZ = 0;
	            }
	        }
}
	
	protected float getBounceSpeedFactor() {
		switch (this.getDiscType())
        {
		case PRISMARINE:
			default:
			return 1.2F;
		case DIAMOND:
			return 1.1F;
		case GOLD:
			return 1.4F;
		case IRON:
			return 0.9F;
		case STONE:
			return 1.1F;
		case WOOD:
			return 1.0F;
        }
	}
	
	@Override
	protected float getGravityVelocity() {
		
		return this.weightForType();
	}
	
	@Override
	public void onUpdate() {
		tickDeath++;
		if(tickDeath >= 123) {
			this.setDead();
		}
		makeTrail();
		this.onEntityUpdate();
		
		this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;

        if (this.throwableShake > 0)
        {
            --this.throwableShake;
        }

        if (this.inGround)
        {
        }
        else
        {
        }
        
        if (bouncing) {
            bouncing = false;
            this.motionX = newX;
            this.motionY = newY;
            this.motionZ = newZ;
        }

        super.onUpdate();

        if (bounceCount > 25 && !world.isRemote) {
            setDead();
        }
        
        this.prevSpin = spin;
        if(!this.onGround) {
        	spin += 26F;
        }

        float damping = 0.98f;
        this.motionX *= damping;
        this.motionY *= damping;
        this.motionZ *= damping;

        this.setPosition(this.posX, this.posY, this.posZ);
	}
	
	private void makeTrail() {
		for (int i = 0; i < 3; i++) {
			double dx = posX + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dy = posY + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dz = posZ + 0.5 * (rand.nextDouble() - rand.nextDouble());
			world.spawnParticle(EnumParticleTypes.SWEEP_ATTACK, dx, dy, dz, 0.0D, 0.0D, 0.0D);
			if(createBolts == true) {
				world.spawnParticle(EnumParticleTypes.ITEM_TAKE, dx, dy, dz, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	public void setDiscType(EntityDisc.TypeOfDisc type)
    {
        this.dataManager.set(DISC_TYPE, Integer.valueOf(type.ordinal()));
    }

    public EntityDisc.TypeOfDisc getDiscType()
    {
        return EntityDisc.TypeOfDisc.byId(((Integer)this.dataManager.get(DISC_TYPE)).intValue());
    }
	
	@Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("bounceCount", bounceCount);
        compound.setString("Type", this.getDiscType().getName());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.bounceCount = compound.getInteger("bounceCount");
        if (compound.hasKey("Type", 8))
        {
            this.setDiscType(EntityDisc.TypeOfDisc.getTypeFromString(compound.getString("Type")));
        }
    }

    @Override
    public void writeSpawnData(@Nullable ByteBuf buffer) {
        if (buffer == null) {
            return;
        }
        EntityLivingBase thrower = this.getThrower();
        if (thrower != null) {
            buffer.writeInt(thrower.getEntityId());
        }
    }

    @Override
    public void readSpawnData(@Nullable ByteBuf buffer) {
        if (buffer == null) {
            return;
        }
    }
    
    public static enum TypeOfDisc
    {
        PRISMARINE(BlockPlanks.EnumType.OAK.getMetadata(), "p"),
        DIAMOND(BlockPlanks.EnumType.SPRUCE.getMetadata(), "d"),
        GOLD(BlockPlanks.EnumType.BIRCH.getMetadata(), "g"),
        IRON(BlockPlanks.EnumType.JUNGLE.getMetadata(), "i"),
        STONE(BlockPlanks.EnumType.ACACIA.getMetadata(), "s"),
        WOOD(BlockPlanks.EnumType.DARK_OAK.getMetadata(), "w");

        private final String name;
        private final int metadata;

        private TypeOfDisc(int metadataIn, String nameIn)
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
        public static EntityDisc.TypeOfDisc byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }

            return values()[id];
        }

        public static EntityDisc.TypeOfDisc getTypeFromString(String nameIn)
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