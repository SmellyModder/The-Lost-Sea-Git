package com.SmellyModder.TheLostSea.common.item;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrow;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFinnedArrow extends ItemBase implements IHasModel
{
	
	public ItemFinnedArrow(String name) {
		super(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		
	}
	
	public EntityFinnedArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityFinnedArrow entitytippedarrow = new EntityFinnedArrow(worldIn, shooter);
        
        
        
        return entitytippedarrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemFinnedArrow.class;
    }
	
}
