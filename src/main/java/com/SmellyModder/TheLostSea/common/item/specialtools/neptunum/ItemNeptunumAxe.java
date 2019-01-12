package com.SmellyModder.TheLostSea.common.item.specialtools.neptunum;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNeptunumAxe extends ItemAxe implements IHasModel {
	
	public ItemNeptunumAxe(String name, ToolMaterial material) 
	{ 
		super(material, 11.0F, -2.7F);
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(TheLostSea.TLS_GEAR);
		TLSItems.ITEMS.add(this);
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
	}
	
	@Override
	public void registerModels() {
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
