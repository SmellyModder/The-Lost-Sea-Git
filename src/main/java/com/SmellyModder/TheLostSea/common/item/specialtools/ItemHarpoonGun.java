package com.SmellyModder.TheLostSea.common.item.specialtools;

import java.util.Set;

import javax.annotation.Nullable;

import com.SmellyModder.TheLostSea.common.entity.EntityHarpoon;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHarpoonGun extends ItemTool implements IHasModel{
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PRISMARINE);

	public ItemHarpoonGun(String name, float attackDamageIn, float attackSpeedIn, ToolMaterial materialIn) {
			super(materialIn, EFFECTIVE_ON);
	        this.setMaxStackSize(1);
	        this.setCreativeTab(TheLostSea.TLS_GEAR);
			setRegistryName(name);
			setTranslationKey(name);
			
			TLSItems.ITEMS.add(this);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityHarpoon orb = new EntityHarpoon(worldIn, playerIn);
            orb.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 0.0F);
            worldIn.spawnEntity(orb);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
    }
    

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
