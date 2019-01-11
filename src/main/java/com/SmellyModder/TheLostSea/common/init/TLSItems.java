package com.SmellyModder.TheLostSea.common.init;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.common.item.ItemElderEye;
import com.SmellyModder.TheLostSea.common.item.ItemFinnedArrow;
import com.SmellyModder.TheLostSea.common.item.ItemOrb;
import com.SmellyModder.TheLostSea.common.item.ItemPearl;
import com.SmellyModder.TheLostSea.common.item.ItemShieldBase;
import com.SmellyModder.TheLostSea.common.item.ItemTempleFinder;
import com.SmellyModder.TheLostSea.common.item.TLS_Rarities;
import com.SmellyModder.TheLostSea.common.item.armor.ArmorItemBaseP;
import com.SmellyModder.TheLostSea.common.item.armor.Item3DArmorP;
import com.SmellyModder.TheLostSea.common.item.armor.ItemArmorBaseV;
import com.SmellyModder.TheLostSea.common.item.devutils.ItemScreen;
import com.SmellyModder.TheLostSea.common.item.food.ItemBubbleFruit;
import com.SmellyModder.TheLostSea.common.item.food.ItemFishFoodBase;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemConvolutionDisc;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemGodSlayerDisc;
import com.SmellyModder.TheLostSea.common.item.musicdiscs.ItemPirateCrewDisc;
import com.SmellyModder.TheLostSea.common.item.shield.ItemCobaltShield;
import com.SmellyModder.TheLostSea.common.item.shield.ItemVanadiumShield;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemBowBase;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemCobaltSword;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemFishBucket;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemHarpoonGun;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemLoreBook;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemLorePage;
import com.SmellyModder.TheLostSea.common.item.specialtools.ItemToolDisc;
import com.SmellyModder.TheLostSea.common.item.specialtools.exotics.ItemCutlass;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSpeedUpgrade;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSubB;
import com.SmellyModder.TheLostSea.common.item.submarine.ItemSubPart;
import com.SmellyModder.TheLostSea.common.item.tools.ItemAxeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemHoeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemPickaxeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemSpadeBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.ItemSwordBaseP;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemAxeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemPickaxeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemSpadeBase;
import com.SmellyModder.TheLostSea.common.item.tools.base.ItemSwordBase;
import com.SmellyModder.TheLostSea.common.item.tools.cobalt.ItemCobaltAxe;
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
	}
	
	public static final ToolMaterial PRISMARINE_MAT = EnumHelper.addToolMaterial("prismarine", 3, 1876, 8.2F, 6.5F, 33);
	public static final ToolMaterial CUTLASS_MAT = EnumHelper.addToolMaterial("cutlass", 5, -1, 1.0F, 18F, 55);
	public static final ToolMaterial PRISMARINE_MAT_DISC = EnumHelper.addToolMaterial("prismarine_disc", 3, 1876, 8.2F, 3F, 33);
	public static final ToolMaterial COBALT_MAT = EnumHelper.addToolMaterial("cobaltmat", 4, 2000, 9F, 7.0F, 33);
	public static final ToolMaterial COBALT_MAT_S = EnumHelper.addToolMaterial("cobaltmats", 4, 2000, 9F, 9.0F, 33);
	public static final ToolMaterial AQUAMARINE_MAT = EnumHelper.addToolMaterial("aquamarinemat", 4, 1800, 4.0F, 4.0F, 33);
	public static final ToolMaterial VANADIUM_MAT = EnumHelper.addToolMaterial("vanadiummat", 3, 1661, 8F, 3.0F, 13);
	public static final ArmorMaterial ARMOR_MATERIAL_PRIS = EnumHelper.addArmorMaterial("armor_material_prismarine", Reference.MOD_ID + ":prismarinew", 11, new int[] {2, 10, 12, 6}, 34, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 2.6F);
	
	//Armor
	public static final Item PRISMARINE_HELMET = new Item3DArmorP("prismarine_helmet", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item PRISMARINE_CHESTPLATE = new Item3DArmorP("prismarine_chestplate", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item PRISMARINE_LEGGINGS = new ArmorItemBaseP("prismarine_leggings", ARMOR_MATERIAL_PRIS, 2, EntityEquipmentSlot.LEGS);
	public static final Item PRISMARINE_BOOTS = new Item3DArmorP("prismarine_boots", ArmorMaterials.PRISMARINE_ARMOR, 1, EntityEquipmentSlot.FEET);
	
	//Vehicles
//	public static Item RED_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.RED, "sub_red");
//	public static Item ORANGE_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.ORANGE, "sub_orange");
//	public static Item YELLOW_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.YELLOW, "sub_yellow");
//	public static Item LIME_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.LIME, "sub_lime");
//	public static Item GREEN_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.GREEN, "sub_green");
//	public static Item BLUE_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.BLUE, "sub_blue");
//	public static Item LIGHTBLUE_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.LIGHTBLUE, "sub_lightblue");
//	public static Item CYAN_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.CYAN, "sub_cyan");
//	public static Item PURPLE_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.PURPLE, "sub_purple");
//	public static Item MAGENTA_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.MAGENTA, "sub_magenta");
//	public static Item PINK_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.PINK, "sub_pink");
//	public static Item BROWN_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.BROWN, "sub_brown");
//	public static Item BLACK_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.BLACK, "sub_black");
//	public static Item GRAY_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.GRAY, "sub_gray");
//	public static Item LIGHTGRAY_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.LIGHTGRAY, "sub_lightgray");
//	public static Item WHITE_SUBMARINE = new ItemSubB(EntitySubmarineI.Type.WHITE, "sub_white");
//	
	//Parts
//	public static Item SUB_ENGINEI = new ItemSubPart("engine_1");
//	public static Item SUB_PROPELLERI = new ItemSubPart("propeller_1");
//	public static Item SUB_LIGHTSI = new ItemSubPart("lights_1");
	
	//Collectables
	public static Item PEARL = new ItemPearl("pearl");
	public static Item ELDER_EYE = new ItemElderEye("elder_eye");
	public static Item COBALT = new ItemBase("cobalt");
	public static Item VANADIUM_INGOT = new ItemBase("vanadium_ingot");
	public static Item GOLDEN_ELDER_EYE = new ItemTempleFinder("golden_elder_eye");
	public static Item PRISMARINE_BALL = new ItemBase("elastic_prismarine");
	public static Item SHARK_TOOTH = new ItemBase("shark_tooth");
	public static Item LORE_BOOK = new ItemLoreBook("lore_book");
	public static Item LORE_BOOK_PAGE = new ItemLorePage("lore_book_page");
	public static Item GUARDIAN_FIN = new ItemBase("fin");
	public static Item AQUAMARINE = new ItemBase("aquamarine");
	
	
	//Finned Arrows
	public static Item FINNED_ARROW = new ItemFinnedArrow("finnedarrow");
	public static Item COBALT_FINNED_ARROW = new ItemFinnedArrow("cobaltfinnedarrow");
	
	//Tools Prismarine
	public static Item PRISMARINE_PICKAXE = new ItemPickaxeBaseP("prismarine_pickaxe", PRISMARINE_MAT);
	public static Item PRISMARINE_AXE = new ItemAxeBaseP("prismarine_axe", PRISMARINE_MAT);
	public static Item PRISMARINE_SWORD = new ItemSwordBaseP("prismarine_sword", PRISMARINE_MAT);
	public static Item PRISMARINE_SPADE = new ItemSpadeBaseP("prismarine_spade", PRISMARINE_MAT);
	public static Item PRISMARINE_HOE = new ItemHoeBaseP("prismarine_hoe", PRISMARINE_MAT);
	
	//Tools Cobalt
	public static Item COBALT_SWORD = new ItemCobaltSword("cobalt_sword", COBALT_MAT_S);
	public static Item COBALT_SHOVEL = new ItemSpadeBase("cobalt_shovel", COBALT_MAT);
	public static Item COBALT_PICKAXE = new ItemPickaxeBase("cobalt_pickaxe", COBALT_MAT);
	public static Item COBALT_AXE = new ItemCobaltAxe("cobalt_axe", COBALT_MAT);
	public static Item COBALT_BOW = new ItemBowBase("cobaltbow");
	public static Item COBALT_SHIELD = new ItemCobaltShield("cobalt_shield");
	
	//Tools Vanadium
	public static Item VANADIUM_SWORD = new ItemSwordBase("vanadium_sword", VANADIUM_MAT);
	public static Item VANADIUM_SHOVEL = new ItemSpadeBase("vanadium_shovel", VANADIUM_MAT);
	public static Item VANADIUM_PICKAXE = new ItemPickaxeBase("vanadium_pickaxe", VANADIUM_MAT);
	public static Item VANADIUM_AXE = new ItemAxeBase("vanadium_axe", VANADIUM_MAT);
	public static Item VANADIUM_SHIELD = new ItemVanadiumShield("vanadium_shield");
	public static final Item VANADIUM_HELMET = new ItemArmorBaseV("vanadium_helmet", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.HEAD);
	public static final Item VANADIUM_CHESTPLATE = new ItemArmorBaseV("vanadium_chestplate", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.CHEST);
	public static final Item VANADIUM_LEGGINGS = new ItemArmorBaseV("vanadium_leggings", ArmorMaterials.VANADIUM_ARMOR, 2, EntityEquipmentSlot.LEGS);
	public static final Item VANADIUM_BOOTS = new ItemArmorBaseV("vanadium_boots", ArmorMaterials.VANADIUM_ARMOR, 1, EntityEquipmentSlot.FEET);
	
	
	//Tools Aquamarine
	public static Item AQUAMARINE_SWORD = new ItemSwordBase("aquamarine_sword", AQUAMARINE_MAT);
	public static Item AQUAMARINE_SHOVEL = new ItemSpadeBase("aquamarine_shovel", AQUAMARINE_MAT);
	public static Item AQUAMARINE_PICKAXE = new ItemPickaxeBase("aquamarine_pickaxe", AQUAMARINE_MAT);
	public static Item AQUAMARINE_AXE = new ItemAxeBase("aquamarine_axe", AQUAMARINE_MAT);
	
	//Foods
	public static ItemFood BUBBLE_FRUIT = new ItemBubbleFruit("bubble_berry", 2, false).setAlwaysEdible();
	public static ItemFishFoodBase ANGLER_FISH = new ItemFishFoodBase("angler_fish", 1);
	public static ItemFishFoodBase ANGLER_FISHC = new ItemFishFoodBase("angler_fish_cooked", 3);
	public static ItemFishFoodBase SHARK_MEAT = new ItemFishFoodBase("shark_meat", 4);
	public static ItemFishFoodBase SHARK_MEATC = new ItemFishFoodBase("shark_meat_cooked", 9);
	
	
	//Fish Buckets
	//public static Item ANGLER_BUKCET = new ItemFishBucket("angler_fish_bucket");
	
	//Throwables
	//public static Item ORB = new ItemOrb("orb");
	//public static ItemHarpoonGun HARPOON_GUN = new ItemHarpoonGun("harpoon_gun", 2, 0.3F, ToolMaterial.IRON);
	
	//Discs
	public static ItemToolDisc DISC_PRISMARINE = new ItemToolDisc("prismarine_disc", 6, 3, EntityDisc.TypeOfDisc.PRISMARINE, SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, PRISMARINE_MAT_DISC);
	public static ItemToolDisc DISC_DIAMOND = new ItemToolDisc("diamond_disc", 9, 2, EntityDisc.TypeOfDisc.DIAMOND, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, ToolMaterial.DIAMOND);
	public static ItemToolDisc DISC_GOLD = new ItemToolDisc("gold_disc", 5, 1, EntityDisc.TypeOfDisc.GOLD, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, ToolMaterial.GOLD);
	public static ItemToolDisc DISC_IRON = new ItemToolDisc("iron_disc", 7, 2, EntityDisc.TypeOfDisc.IRON, SoundEvents.ITEM_ARMOR_EQUIP_IRON, ToolMaterial.IRON);
	public static ItemToolDisc DISC_STONE = new ItemToolDisc("stone_disc", 6, 2, EntityDisc.TypeOfDisc.STONE, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, ToolMaterial.STONE);
	public static ItemToolDisc DISC_WOOD = new ItemToolDisc("wood_disc", 5, 3, EntityDisc.TypeOfDisc.WOOD, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, ToolMaterial.WOOD);
	
	//Music Discs
	public static ItemPirateCrewDisc PIRATE_CREW_DISC = new ItemPirateCrewDisc("pirate_crew", TLSMusic.PIRATE_CREW);
	public static ItemConvolutionDisc OMAN_DISC = new ItemConvolutionDisc("ocean_man", TLSMusic.OCEAN_MAN);
	//public static ItemGodSlayerDisc GOD_SLAYER_DISC = new ItemGodSlayerDisc("god_slayer", TLSMusic.PIRATE_CREW);
	//public static ItemConvolutionDisc CONVOLUTION_DISC = new ItemConvolutionDisc("convolution", TLSMusic.PIRATE_CREW);
	//public static ItemConvolutionDisc BEDAZZLE_DISC = new ItemConvolutionDisc("bedazzle", TLSMusic.PIRATE_CREW);
	
	
	//Upgrades
	public static Item SPEED_UPGRADE = new ItemSpeedUpgrade("speed_upgrade");
	
	/**
	 * All the Quest Items
	 * @param boolean(Is Special) - makes it enchanted, highlights text, will be marked as a *Special* rarity
	 */
	public static Item CUTLASS = new ItemCutlass("cutlass", CUTLASS_MAT, true);
	
	//Util
	public static Item GS = new ItemScreen("gs");
}
