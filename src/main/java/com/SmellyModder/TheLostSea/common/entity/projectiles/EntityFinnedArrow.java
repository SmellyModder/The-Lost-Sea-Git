package com.SmellyModder.TheLostSea.common.entity.projectiles;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.client.render.RenderDisc;
import com.SmellyModder.TheLostSea.common.init.TLSItems;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityFinnedArrow extends EntityArrow
{
	
	private static final DataParameter<Integer> ARROW_TYPE = EntityDataManager.<Integer>createKey(EntityDisc.class, DataSerializers.VARINT);
	
	public EntityFinnedArrow(World worldIn, double x, double y, double z)
	{
		super(worldIn);
		this.setPosition(x, y, z);
	}
	
	public EntityFinnedArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

	
	public EntityFinnedArrow(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0F);
		this.setVelocity(this.speedForType(), this.speedForType(), this.speedForType());
	}
	
	@Override
	protected ItemStack getArrowStack() 
	{
		return this.arrowType();
	}
	
	@Override
	public double getDamage() {
		return this.damageToDeal();
	}
	
	protected void entityInit()
    {
        this.dataManager.register(ARROW_TYPE, Integer.valueOf(EntityFinnedArrow.TypeOfArrow.NORMAL.ordinal()));
    }
	
	@Override
	public void onEntityUpdate() 
	{
		if(this.isInWater())
		{
			this.setVelocity(this.speedForType() * 2, this.speedForType() * 2, this.speedForType() * 2);
		}
		super.onEntityUpdate();
	}
	
	private int damageToDeal() {
		switch (this.getFinnedArrowType())
        {
		case NORMAL:
			default:
			return 6;
		case COBALT:
			return 9;
        }
    }
	
	private ItemStack arrowType()
	{
		switch(this.getFinnedArrowType())
		{
		case NORMAL:
			default:
			return new ItemStack(TLSItems.FINNED_ARROW);
		case COBALT:
			return new ItemStack(TLSItems.COBALT_FINNED_ARROW);
		}
	}
	
	//When out of water, its this
	//When IN water, it is the values x 2
	private int speedForType() {
		switch (this.getFinnedArrowType())
        {
        case NORMAL:
		default:
			//water speed = 12
		return 6;
		case COBALT:
			//water speed = 18
		return 9;
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
	
	@Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setString("Type", this.getFinnedArrowType().getName());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("Type", 8))
        {
            this.setArrowType(EntityFinnedArrow.TypeOfArrow.getTypeFromString(compound.getString("Type")));
        }
    }
	
	public static enum TypeOfArrow
    {
        NORMAL(BlockPlanks.EnumType.OAK.getMetadata(), "n"),
        COBALT(BlockPlanks.EnumType.OAK.getMetadata(), "c");

        /**
         * Get a boat type by it's enum ordinal
         */
		
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
	
}
