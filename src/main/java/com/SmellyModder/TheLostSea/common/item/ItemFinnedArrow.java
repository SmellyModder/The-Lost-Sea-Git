package com.SmellyModder.TheLostSea.common.item;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrow;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityFinnedArrowTest;
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

public class ItemFinnedArrow extends ItemArrow implements IHasModel
{
	
	public ItemFinnedArrow(String name) {
		setRegistryName(name);
		setTranslationKey(name);
		setMaxStackSize(1);
		setMaxDamage(1000);
		setCreativeTab(TheLostSea.TLS_GEAR);
		
		TLSItems.ITEMS.add(this);
		
	}
	
	public EntityFinnedArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
		EntityFinnedArrow entitytippedarrow = new EntityFinnedArrow(worldIn, shooter);
        return entitytippedarrow;
    }

	@Override
	public void registerModels() {
		
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
}
