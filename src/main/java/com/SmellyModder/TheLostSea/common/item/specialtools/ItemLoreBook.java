package com.SmellyModder.TheLostSea.common.item.specialtools;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.SmellyModder.TheLostSea.client.gui.GUILoreBook;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityLunete;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.advancements.critereon.NBTPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.Style;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoreBook extends ItemBase {
	
	public int thiccness = 0;
	public ItemLoreBook(String name) {
		super(name);
		this.setMaxStackSize(1);
		this.addPropertyOverride(new ResourceLocation("thiccness"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return thiccness;
                }
            }
        });
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
			tooltip.add("§oAn old journal that contains some of the old writings from a legendary adventurer§r");
			tooltip.add("§eCollect more pages to complete the book!§r");
			tooltip.add("§l[§6Shift + RightClick§l]§r - §7to collect more pages§r");
        }else {
        	tooltip.add("by Jack");
        	tooltip.add("Obscured");
        	tooltip.add("Press §aSHIFT§r for more info!");
        }
    }
	
	private ItemStack findPages(EntityPlayer player)
    {
		for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = player.inventory.getStackInSlot(i);

            if (itemstack.getItem() instanceof ItemLorePage)
            {
                return itemstack;
            }
        }
		return ItemStack.EMPTY;
    }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		Random rand = new Random();
		
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
        	ItemStack stack = this.findPages(playerIn);
        	if(!stack.isEmpty()) {
        		int randS = rand.nextInt((120) + 1);
        		boolean done = false;
        		NBTTagCompound nbt = itemstack.getTagCompound();
        		if(nbt == null) {
        			nbt = new NBTTagCompound();
        		}
        		nbt = nbt.getCompoundTag("pages");
        		int unlocked_pages = 0; 
        		if(nbt.hasKey("unlocked_pages"))
        		{
        		    unlocked_pages = nbt.getInteger("unlocked_pages");
        		    this.thiccness = nbt.getInteger("unlocked_pages");
        		}
        		//System.out.println(unlocked_pages);
        		int i = 0;
        		do {
        			i++;
        			if(nbt.hasKey("page_" + randS)) {
        				randS = rand.nextInt(120) + 1;
        			}else {
        				done = true;
        			}
        		} while(!done && unlocked_pages < 120 && i < 1200);
        			if(unlocked_pages < 120) {
                    nbt.setBoolean("page_" + randS, true);
                    nbt.setInteger("unlocked_pages", (unlocked_pages + 1));
                    itemstack.setTagInfo("pages", nbt);
                    worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.6F, 0.5F);
                    stack.shrink(1);
        		}
        	}
        }else {
        	TheLostSea.proxy.openMyGui(itemstack);
        	worldIn.playSound(playerIn, playerIn.getPosition(), TLSSounds.BOOK_OPEN, SoundCategory.PLAYERS, 1.2F, 0.9F * (itemRand.nextInt(5) * 0.7F - 0.8F));
        	playerIn.openBook(itemstack, handIn);
        	playerIn.addStat(StatList.getObjectUseStats(this));
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
