package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.blocks.itemblocks.ItemBlockCoconut;
import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.common.item.ItemElderEye;
import com.SmellyModder.TheLostSea.common.item.ItemFinnedArrow;
import com.SmellyModder.TheLostSea.common.item.ItemPearl;
import com.SmellyModder.TheLostSea.common.item.ItemShieldBase;
import com.SmellyModder.TheLostSea.common.item.ItemTempleFinder;
import com.SmellyModder.TheLostSea.common.item.TLS_Rarities;
import com.SmellyModder.TheLostSea.common.item.armor.ArmorItemBaseP;
import com.SmellyModder.TheLostSea.common.item.armor.Item3DArmorP;
import com.SmellyModder.TheLostSea.common.item.armor.ItemArmorBase;
import com.SmellyModder.TheLostSea.common.item.armor.ItemNeptunumArmor;
import com.SmellyModder.TheLostSea.common.item.food.ItemBubbleFruit;
import com.SmellyModder.TheLostSea.common.item.food.ItemCoconutChunk;
import com.SmellyModder.TheLostSea.common.item.food.ItemFishFoodBase;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemConvolutionDisc;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemGodSlayerDisc;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemPirateCrewDisc;
import com.SmellyModder.TheLostSea.common.item.shield.ItemNeptunumShield;
import com.SmellyModder.TheLostSea.common.item.shield.ItemVanadiumShield;
import com.SmellyModder.TheLostSea.common.item.shop.ItemWayfinderCompass;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemBowBase;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemFishBucket;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemHarpoonGun;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemLoreBook;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemLorePage;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemToolDisc;
import com.SmellyModder.TheLostSea.common.item.specialtools.exotics.ItemCutlass;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumAxe;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumPickaxe;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumSpade;
import com.SmellyModder.TheLostSea.common.item.specialtools.neptunum.ItemNeptunumSword;
import com.SmellyModder.TheLostSea.common.item.tools.ItemAxeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemHoeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemPickaxeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemSpadeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemSwordBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemAxeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemPickaxeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemSpadeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemSwordBase;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemShield;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class TLSItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static class ArmorMaterials {
		public static final ArmorMaterial PRISMARINE_ARMOR = EnumHelper.addArmorMaterial("prismarineArmor", "thelostsea:prismarine", 40, new int[]{2, 10, 12, 6}, 34, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 3.0f);
		public static final ArmorMaterial VANADIUM_ARMOR = EnumHelper.addArmorMaterial("vanadiumArmor", "thelostsea:vanadium", 35, new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.5f);
		public static final ArmorMaterial NEPTUNUM_ARMOR = EnumHelper.addArmorMaterial("cobaltArmor", "thelostsea:neptunum", 45, new int[]{4, 8, 10, 4}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3f);
	}
	
	public static final ToolMaterial PRISMARINE_MAT = EnumHelper.addToolMaterial("prismarine", 3, 1876, 8.2F, 6.5F, 33);
	public static final ToolMaterial CUTLASS_MAT = EnumHelper.addToolMaterial("cutlass", 5, -1, 1.0F, 18F, 55);
	public static final ToolMaterial PRISMARINE_MAT_DISC = EnumHelper.addToolMaterial("prismarine_disc", 3, 1876, 8.2F, 3F, 33);
	public static final ToolMaterial NEPTUNUM_MAT = EnumHelper.addToolMaterial("cobaltmat", 4, 2000, 10F, 7.0F, 20);
	public static final ToolMaterial NEPTUNUM_MAT_S = EnumHelper.addToolMaterial("cobaltmats", 4, 2000, 9F, 9.0F, 20);
	public static final ToolMaterial VANADIUM_MAT = EnumHelper.addToolMaterial("vanadiummat", 3, 1661, 8F, 3.0F, 13);
	public static final ArmorMaterial ARMOR_MATERIAL_PRIS = EnumHelper.addArmorMaterial("armor_material_prismarine", Reference.MOD_ID + ":prismarinew", 11, new int[] {2, 10, 12, 6}, 34, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 2.6F);
	
	//Armor
	//public static final Item PRISMARINE_HELMET = new Item3DArmorP("prismarine_helmet", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.HEAD);
	//public static final Item PRISMARINE_CHESTPLATE = new Item3DArmorP("prismarine_chestplate", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.CHEST);
	//public static final Item PRISMARINE_LEGGINGS = new ArmorItemBaseP("prismarine_leggings", ARMOR_MATERIAL_PRIS, 2, EntityEquipmentSlot.LEGS);
	//public static final Item PRISMARINE_BOOTS = new Item3DArmorP("prismarine_boots", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.FEET);
	
	//Collectables
	public static final Item PEARL = new ItemPearl("pearl");
	public static final Item ELDER_EYE = new ItemElderEye("elder_eye");
	public static final Item NEPTUNUM = new ItemBase("neptunum");
	public static final Item VANADIUM_INGOT = new ItemBase("vanadium_ingot");
	public static final Item GOLDEN_ELDER_EYE = new ItemTempleFinder("golden_elder_eye");
	public static final Item SHARK_TOOTH = new ItemBase("shark_tooth");
	public static final Item LORE_BOOK = new ItemLoreBook("lore_book");
	public static final Item LORE_BOOK_PAGE = new ItemLorePage("lore_book_page");
	public static final Item GUARDIAN_FIN = new ItemBase("fin");
	
	/**
	 * Shop Exclusives
	 */
	public static final Item WAYFINDER_COMPASS = new ItemWayfinderCompass("wayfinder");
	
	//Finned Arrows
	public static final Item FINNED_ARROW = new ItemFinnedArrow("finnedarrow", false);
	public static final Item NEPTUNUM_FINNED_ARROW = new ItemFinnedArrow("neptunum_finnedarrow", true);
	
	//Tools Prismarine
	//public static final Item PRISMARINE_PICKAXE = new ItemPickaxeBaseP("prismarine_pickaxe", PRISMARINE_MAT);
	//public static final Item PRISMARINE_AXE = new ItemAxeBaseP("prismarine_axe", PRISMARINE_MAT);
	//public static final Item PRISMARINE_SWORD = new ItemSwordBaseP("prismarine_sword", PRISMARINE_MAT);
	//public static final Item PRISMARINE_SPADE = new ItemSpadeBaseP("prismarine_spade", PRISMARINE_MAT);
	//public static final Item PRISMARINE_HOE = new ItemHoeBaseP("prismarine_hoe", PRISMARINE_MAT);
	
	//Tools Neptunum
	public static final Item NEPTUNUM_SWORD = new ItemNeptunumSword("neptunum_sword", NEPTUNUM_MAT_S);
	public static final Item NEPTUNUM_SHOVEL = new ItemNeptunumSpade("neptunum_shovel", NEPTUNUM_MAT);
	public static final Item NEPTUNUM_PICKAXE = new ItemNeptunumPickaxe("neptunum_pickaxe", NEPTUNUM_MAT);
	public static final Item NEPTUNUM_AXE = new ItemNeptunumAxe("neptunum_axe", NEPTUNUM_MAT);
	public static final Item NEPTUNUM_BOW = new ItemBowBase("neptunum_bow");
	public static final Item NEPTUNUM_SHIELD = new ItemNeptunumShield("neptunum_shield");
	public static final Item NEPTUNUM_HELMET = new ItemNeptunumArmor("neptunum_helmet", "neptunum", ArmorMaterials.NEPTUNUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item NEPTUNUM_CHESTPLATE = new ItemNeptunumArmor("neptunum_chestplate", "neptunum", ArmorMaterials.NEPTUNUM_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item NEPTUNUM_LEGGINGS = new ItemNeptunumArmor("neptunum_leggings", "neptunum", ArmorMaterials.NEPTUNUM_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item NEPTUNUM_BOOTS = new ItemNeptunumArmor("neptunum_boots", "neptunum", ArmorMaterials.NEPTUNUM_ARMOR, 1, EntityEquipmentSlot.FEET);
	
	//Tools Vanadium
	public static final Item VANADIUM_SWORD = new ItemSwordBase("vanadium_sword", VANADIUM_MAT);
	public static final Item VANADIUM_SHOVEL = new ItemSpadeBase("vanadium_shovel", VANADIUM_MAT);
	public static final Item VANADIUM_PICKAXE = new ItemPickaxeBase("vanadium_pickaxe", VANADIUM_MAT);
	public static final Item VANADIUM_AXE = new ItemAxeBase("vanadium_axe", VANADIUM_MAT);
	public static final Item VANADIUM_SHIELD = new ItemVanadiumShield("vanadium_shield");
	public static final Item VANADIUM_HELMET = new ItemArmorBase("vanadium_helmet", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item VANADIUM_CHESTPLATE = new ItemArmorBase("vanadium_chestplate", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item VANADIUM_LEGGINGS = new ItemArmorBase("vanadium_leggings", ArmorMaterials.VANADIUM_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item VANADIUM_BOOTS = new ItemArmorBase("vanadium_boots", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.FEET);
	
	//Foods
	public static final ItemFood BUBBLE_FRUIT = new ItemBubbleFruit("bubble_berry", 2, false).setAlwaysEdible();
	public static final ItemFishFoodBase ANGLER_FISH = new ItemFishFoodBase("angler_fish", 1);
	public static final ItemFishFoodBase ANGLER_FISHC = new ItemFishFoodBase("angler_fish_cooked", 3);
	public static final ItemFishFoodBase SHARK_MEAT = new ItemFishFoodBase("shark_meat", 4);
	public static final ItemFishFoodBase SHARK_MEATC = new ItemFishFoodBase("shark_meat_cooked", 9);
	public static final Item COCONUT = new ItemBlockCoconut("coconut_item");
	public static final Item COCONUT_CHUNK = new ItemCoconutChunk();
	
	//Discs
	public static final ItemToolDisc DISC_PRISMARINE = new ItemToolDisc("prismarine_disc", 6, 3, EntityDisc.TypeOfDisc.PRISMARINE, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, PRISMARINE_MAT_DISC);
	public static final ItemToolDisc DISC_DIAMOND = new ItemToolDisc("diamond_disc", 9, 2, EntityDisc.TypeOfDisc.DIAMOND, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, ToolMaterial.DIAMOND);
	public static final ItemToolDisc DISC_GOLD = new ItemToolDisc("gold_disc", 5, 1, EntityDisc.TypeOfDisc.GOLD, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, ToolMaterial.GOLD);
	public static final ItemToolDisc DISC_IRON = new ItemToolDisc("iron_disc", 7, 2, EntityDisc.TypeOfDisc.IRON, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ToolMaterial.IRON);
	public static final ItemToolDisc DISC_STONE = new ItemToolDisc("stone_disc", 6, 2, EntityDisc.TypeOfDisc.STONE, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, ToolMaterial.STONE);
	public static final ItemToolDisc DISC_WOOD = new ItemToolDisc("wood_disc", 5, 3, EntityDisc.TypeOfDisc.WOOD, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, ToolMaterial.WOOD);
	public static final ItemToolDisc DISC_VANADIUM = new ItemToolDisc("vanadium_disc", 9, 2, EntityDisc.TypeOfDisc.VANDIUM, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ToolMaterial.DIAMOND);
	public static final ItemToolDisc DISC_NEPTUNUM = new ItemToolDisc("neptunum_disc", 11, 3, EntityDisc.TypeOfDisc.NEPTUNUM, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, NEPTUNUM_MAT);

	//Music Discs
	public static final ItemPirateCrewDisc PIRATE_CREW_DISC = new ItemPirateCrewDisc("pirate_crew", TLSMusic.PIRATE_CREW);
	public static final ItemConvolutionDisc OMAN_DISC = new ItemConvolutionDisc("ocean_man", TLSMusic.OCEAN_MAN);
	//public static ItemGodSlayerDisc GOD_SLAYER_DISC = new ItemGodSlayerDisc("god_slayer", TLSMusic.PIRATE_CREW);
	//public static ItemConvolutionDisc CONVOLUTION_DISC = new ItemConvolutionDisc("convolution", TLSMusic.PIRATE_CREW);
	//public static ItemConvolutionDisc BEDAZZLE_DISC = new ItemConvolutionDisc("bedazzle", TLSMusic.PIRATE_CREW);
	
	/**
	 * All the Quest Items
	 * @param boolean(Is Special) - makes it enchanted, highlights text, will be marked as a *Special* rarity
	 */
	//public static final Item CUTLASS = new ItemCutlass("cutlass", CUTLASS_MAT, true);
}
