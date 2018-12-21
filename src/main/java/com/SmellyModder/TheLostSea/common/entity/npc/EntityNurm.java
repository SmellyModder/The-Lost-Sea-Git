package com.SmellyModder.TheLostSea.common.entity.npc;

import com.SmellyModder.TheLostSea.common.init.TLSSounds;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.packets.npc.MessageVerseN;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.provider.DialogueProviderN;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.CoinCurrency;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityNurm extends EntityLSNpcBase {

	public EntityNurm(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
	}
	
	@Override
	public boolean canBeHitWithPotion() {
		return false;
	}
	@Override
	public boolean canBeAttackedWithItem() {
		return false;
	}
	
	protected void applyEntityAttributes()
    {
		super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10101010D);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10000000D);
    }
	
	@Override
	protected boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		boolean flag = itemstack.getItem() == Items.NAME_TAG;
		
		
		IDialogueNurm dataNPC = player.getCapability(DialogueProviderN.DIALOGUE_CAP, null); 
        if (flag)
        {
            itemstack.interactWithEntity(player, this, hand);
            return true;
        }
		else if (this.isEntityAlive() && !player.isSneaking())
        {
			ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null);
			
			
			TheLostSea.proxy.OpenNurmGUI(player);
            return true;
        }
		else 
		{
        	return super.processInteract(player, hand);
        }
		
	}
	
}
