package com.SmellyModder.TheLostSea.common.item.shop;

import java.util.List;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWayfinderCompass extends ItemBase {
	public int dimension;
	private int posX, posZ;

	public ItemWayfinderCompass(String name) {
    	super(name);
        this.addPropertyOverride(new ResourceLocation("angle"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            double rotation, rota;
            long lastUpdateTick;
            @SideOnly(Side.CLIENT)
            
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null && !stack.isOnItemFrame()) {
                    return 0.0F;
                } else {
                    boolean flag = entityIn != null;
                    Entity entity = (Entity)(flag ? entityIn : stack.getItemFrame());

                    if (worldIn == null) {
                        worldIn = entity.world;
                    }
                    double d0 = 0;
                    
                    if(!stack.hasTagCompound()) {
            			stack.setTagCompound(new NBTTagCompound());
            		}
                    if (stack.hasTagCompound() && stack.getTagCompound().hasKey("dimension")) {
                    	dimension = stack.getTagCompound().getInteger("dimension");
                    
                    	if (worldIn.provider.getDimension() == dimension) {
                    		double d1 = flag ? (double)entity.rotationYaw : this.getFrameRotation((EntityItemFrame)entity);
                    		d1 = MathHelper.positiveModulo(d1 / 360.0D, 1.0D);
                    		double d2 = this.getSpawnToAngle(worldIn, entity) / (Math.PI * 2D);
                    		d0 = 0.5D - (d1 - 0.25D - d2);
                    	} else {
                    		d0 = Math.random();
                    	}
                    	
                    	if (flag) {
                    		d0 = this.wobble(worldIn, d0);
                    	}
                    	return MathHelper.positiveModulo((float)d0, 1.0F);
                    } else {
                    	return (float) MathHelper.positiveModulo((float)d0 * Math.random() * 5, 1.0F);
                    }
                }
            }
            @SideOnly(Side.CLIENT)
            private double wobble(World worldIn, double p_185093_2_) {
                if (worldIn.getTotalWorldTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = worldIn.getTotalWorldTime();
                    double d0 = p_185093_2_ - this.rotation;
                    d0 = MathHelper.positiveModulo(d0 + 0.5D, 1.0D) - 0.5D;
                    this.rota += d0 * 0.1D;
                    this.rota *= 0.8D;
                    this.rotation = MathHelper.positiveModulo(this.rotation + this.rota, 1.0D);
                }
                return this.rotation;
            }
            
            @SideOnly(Side.CLIENT)
            private double getFrameRotation(EntityItemFrame p_185094_1_) {
                return (double)MathHelper.wrapDegrees(180 + p_185094_1_.facingDirection.getHorizontalIndex() * 90);
            }
            
            @SideOnly(Side.CLIENT)
            private double getSpawnToAngle(World p_185092_1_, Entity p_185092_2_) {
            	if(p_185092_1_ != null && p_185092_2_ instanceof EntityPlayer) {
            		EntityPlayer player = (EntityPlayer)p_185092_2_;
            		ItemStack itemstack = player.inventory.getCurrentItem();
            		if (!itemstack.isEmpty() && itemstack.getItem() == TLSItems.WAYFINDER_COMPASS && itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("dimension")) {
            			posX = itemstack.getTagCompound().getInteger("posX");
            			posZ = itemstack.getTagCompound().getInteger("posZ");
            		}
            	}
                return Math.atan2((double)posZ - p_185092_2_.posZ, (double)posX - p_185092_2_.posX);
            }
        });
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flag) {
		if(!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("dimension")) {
			list.add(TextFormatting.GRAY + new TextComponentTranslation("tooltip.thelostsea.dimension", new Object[0]).getFormattedText() + TextFormatting.WHITE + " " + stack.getTagCompound().getString("dim_name"));
			list.add(TextFormatting.GRAY + new TextComponentTranslation("tooltip.thelostsea.x", new Object[0]).getFormattedText() + TextFormatting.WHITE + " " + stack.getTagCompound().getInteger("posX"));
			list.add(TextFormatting.GRAY + new TextComponentTranslation("tooltip.thelostsea.y", new Object[0]).getFormattedText() + TextFormatting.WHITE + " " + stack.getTagCompound().getInteger("posY"));
		}
	}
    
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		Block block = world.getBlockState(pos).getBlock();
		if (stack.hasTagCompound() && player.isSneaking()) {
			if (!world.isRemote && block != null) {
				stack.getTagCompound().setString("dim_name", player.getEntityWorld().provider.getDimensionType().getName());
				
				stack.getTagCompound().setInteger("dimension", player.getEntityWorld().provider.getDimension());
				
				stack.getTagCompound().setInteger("posX", pos.getX());
				stack.getTagCompound().setInteger("posZ", pos.getZ());
				return EnumActionResult.SUCCESS;
			}
		}
		return EnumActionResult.FAIL;
	}
}
