package com.SmellyModder.TheLostSea.common.entity.projectiles;

import java.util.List;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.client.render.RenderDisc;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFinnedArrow extends EntityLSArrow
{
	private static final DataParameter<Integer> ARROW_TYPE = EntityDataManager.<Integer>createKey(EntityFinnedArrow.class, DataSerializers.VARINT);
   
	public EntityFinnedArrow(World world) {
		super(world);
	}

	public EntityFinnedArrow(World world, EntityLivingBase player) {
		super(world, player);
	}

	protected void entityInit()
    {
		super.entityInit();
        this.dataManager.register(ARROW_TYPE, Integer.valueOf(EntityFinnedArrow.TypeOfArrow.NORMAL.ordinal()));
    }
	
	public static void registerFixesArrow(DataFixer fixer)
    {
        registerFixesArrow(fixer, "FinnedArrow");
    }

	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.isInWater() && this.getFinnedArrowType() == EntityFinnedArrow.TypeOfArrow.COBALT) {
			this.motionX *= (double)1.7F;
			this.motionY *= (double)1.7;
        	this.motionZ *= (double)1.7F;
        	this.setDamage(this.getDamage() * 1.05F);
		}
		else if(this.isInWater() && this.getFinnedArrowType() == EntityFinnedArrow.TypeOfArrow.NORMAL){
			this.motionX *= (double)1.55F;
			this.motionY *= (double)1.55;
        	this.motionZ *= (double)1.55F;
		}
	}
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setString("arrowType", this.getFinnedArrowType().getName());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        if (compound.hasKey("arrowType", 8))
        {
            this.setArrowType(EntityFinnedArrow.TypeOfArrow.getTypeFromString(compound.getString("arrowType")));
        }
    }
    public void setArrowType(EntityFinnedArrow.TypeOfArrow type)
    {
        this.dataManager.set(ARROW_TYPE, Integer.valueOf(type.ordinal()));
    }

    public EntityFinnedArrow.TypeOfArrow getFinnedArrowType()
    {
        return EntityFinnedArrow.TypeOfArrow.byId(((Integer)this.dataManager.get(ARROW_TYPE)).intValue());
    }
    
    public static enum TypeOfArrow
    {
        NORMAL(BlockPlanks.EnumType.OAK.getMetadata(), "normal"),
        COBALT(BlockPlanks.EnumType.SPRUCE.getMetadata(), "cobalt");
        private final String name;
        private final int metadata;

        private TypeOfArrow(int metadataIn, String nameIn)
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
        public static EntityFinnedArrow.TypeOfArrow byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }

            return values()[id];
        }

        public static EntityFinnedArrow.TypeOfArrow getTypeFromString(String nameIn)
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

	@Override
	protected ItemStack getArrowStack() {
		switch(this.getFinnedArrowType()) {
		case NORMAL:
			return new ItemStack(TLSItems.FINNED_ARROW);
		case COBALT:
			return new ItemStack(TLSItems.NEPTUNUM_FINNED_ARROW);
		}
		return null;
	}
}
