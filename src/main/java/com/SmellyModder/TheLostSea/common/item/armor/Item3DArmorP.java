package com.SmellyModder.TheLostSea.common.item.armor;

import java.util.List;

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

public class Item3DArmorP extends ItemArmor implements IHasModel{


		public Item3DArmorP(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
			super(materialIn, renderIndexIn, equipmentSlotIn);
			this.setCreativeTab(TheLostSea.TLS_GEAR);
			this.setMaxStackSize(1);
			setTranslationKey(name);
			setRegistryName(name);
			TLSItems.ITEMS.add(this);
		}
		
		@Override
		public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
			if (isInCreativeTab(tab)) {
				ItemStack istack = new ItemStack(this);
				switch (this.armorType) {
					case HEAD:
						istack.addEnchantment(Enchantments.RESPIRATION, 1);
						break;
					case CHEST:
						istack.addEnchantment(Enchantments.PROTECTION, 10);
						break;
					case LEGS:
						istack.addEnchantment(Enchantments.THORNS, 10);
						break;
					case FEET:
						istack.addEnchantment(Enchantments.DEPTH_STRIDER, 8);
						break;
					default:
						break;
				}
				list.add(istack);
			}
		}
		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
				((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 160, 0));
				super.onArmorTick(world, player, itemStack);
		}
		
		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			list.add("Rarity:" + " §5§lLegendary§r");
		}
		
		@Override
		@SideOnly(Side.CLIENT)
		public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
			if(!itemStack.isEmpty()) {
				if(itemStack.getItem() instanceof ItemArmor) {
					
					ModelPrismarineArmor armorModel = new ModelPrismarineArmor(1.0f);
					ModelPrismarineArmor armorModelLegs = new ModelPrismarineArmor(0.5f);
					
					
					armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
					armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
					armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);

					armorModel.isSneak = _default.isSneak;
					armorModel.isRiding = _default.isRiding;
					armorModel.isChild = _default.isChild;
					armorModel.rightArmPose = _default.rightArmPose;
					armorModel.leftArmPose = _default.leftArmPose;
					
					armorModelLegs.isSneak = _default.isSneak;
					armorModelLegs.isRiding = _default.isRiding;
					armorModelLegs.isChild = _default.isChild;
					armorModelLegs.rightArmPose = _default.rightArmPose;
					armorModelLegs.leftArmPose = _default.leftArmPose;

					return armorModel;
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
	        return true;
	    }
}
