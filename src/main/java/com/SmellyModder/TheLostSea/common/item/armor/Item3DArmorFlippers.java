package com.SmellyModder.TheLostSea.common.item.armor;

import java.util.List;

import com.SmellyModder.TheLostSea.client.model.ModelFlippers;
import com.SmellyModder.TheLostSea.client.model.armor.ModelPrismarineArmor;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item3DArmorFlippers extends ItemArmor implements IHasModel{


		public Item3DArmorFlippers(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
			super(materialIn, renderIndexIn, equipmentSlotIn);
			this.setCreativeTab(TheLostSea.TLS_GEAR);
			this.setMaxStackSize(1);
			setTranslationKey(name);
			setRegistryName(name);
			TLSItems.ITEMS.add(this);
		}
		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
				((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 160, 0));
				super.onArmorTick(world, player, itemStack);
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
			if(!itemStack.isEmpty()) {
				if(itemStack.getItem() instanceof ItemArmor) {
					
					ModelFlippers armorModelLegs = new ModelFlippers(0.5f);
					
					armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
					armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
					
					armorModelLegs.isSneak = _default.isSneak;
					armorModelLegs.isRiding = _default.isRiding;
					armorModelLegs.isChild = _default.isChild;

					return armorModelLegs;
				}
			}
			return null;
		}
		
		@Override
		public void registerModels() {
			
			TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
		}
		
		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
	    {
	        return false;
	    }
}
