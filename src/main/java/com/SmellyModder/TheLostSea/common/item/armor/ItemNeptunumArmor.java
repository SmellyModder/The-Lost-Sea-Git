package com.SmellyModder.TheLostSea.common.item.armor;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.client.model.armor.ModelNeptunumArmor;
import com.SmellyModder.TheLostSea.client.model.armor.ModelPrismarineArmor;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.ItemFinnedArrow;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentWaterWalker;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNeptunumArmor extends ItemArmor implements IHasModel{

	public ItemNeptunumArmor(String name, String path, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setCreativeTab(TheLostSea.TLS_GEAR);
		this.setMaxStackSize(1);
		setTranslationKey(name);
		setRegistryName(name);
		TLSItems.ITEMS.add(this);
	}
	
	/*
	 * TODO - Armor Ability 
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
			tooltip.add(TextFormatting.BLUE + "Water-Bound:" + TextFormatting.GRAY + " This item is more powerful when your elements are bound to water");
        }
		else {
			tooltip.add(TextFormatting.BLUE + "Water-Bound" + TextFormatting.GRAY + " [SHIFT]");
		}
		tooltip.add(TextFormatting.LIGHT_PURPLE + "Full Armor Ability:" + TextFormatting.DARK_AQUA + " Neptune's Might");
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
    	if(!itemStack.isEmpty()) {
			if(itemStack.getItem() instanceof ItemArmor) {
				ModelNeptunumArmor model = new ModelNeptunumArmor(0.01f);
           
            	model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	model.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            
            	model.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	model.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	model.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS;
            	model.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS;
            
            	model.isChild = _default.isChild;
            	model.isRiding = _default.isRiding;
            	model.isSneak = _default.isSneak;
            	model.rightArmPose = _default.rightArmPose;
            	model.leftArmPose = _default.leftArmPose;
            
            	return model;
			}
    	}
        return null;
    }
    
	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
