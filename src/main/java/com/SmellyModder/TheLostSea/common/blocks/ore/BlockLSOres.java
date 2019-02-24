package com.SmellyModder.TheLostSea.common.blocks.ore;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLSOres extends BlockBase{

	private boolean deep;
	public BlockLSOres(String name, Material material, boolean isDeep, int meta) {
		super(name, material);
		this.deep = isDeep;
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(TheLostSea.TLS_ORES);
		
		if(meta == 1) {
			setHardness(-0.5F + getHardness());
			setResistance(-0.5F + getResistance());
		}
		else if(meta == 2){
			setHardness(getHardness());
			setResistance(getResistance());
		}
		else {
			setHardness(getHardness() - 0.3F);
			setResistance(getResistance() - 0.3F);
			setLightLevel(0.25F);
		}
	}
	
	float getHardness() {
		return deep ? 4.7F : 4.3F;
	}
	
	float getResistance() {
		return deep ? 5.7F : 4.7F;
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == TLSBlocks.SEA_COBALTORE)
            {
                i = MathHelper.getInt(rand, 0, 2);
            }
            else if (this == TLSBlocks.DEEPSEA_COBALTORE)
            {
                i = MathHelper.getInt(rand, 2, 5);
            }
            else if(this == TLSBlocks.DEEPSEA_VANADIUMORE) {
            	i = MathHelper.getInt(rand, 0, 0);
            }
            else if (this == TLSBlocks.SEA_VANADIUMORE)
            {
            	i = MathHelper.getInt(rand, 0, 0);
            }
            else if (this == TLSBlocks.AQUAMARINE_ORE)
            {
            	i = MathHelper.getInt(rand, 2, 4);
            }
            return i;
        }
        return 0;
    }

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		
	   return new ItemStack(this);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		Item item = null;
		
		if (this == TLSBlocks.SEA_COBALTORE || this == TLSBlocks.DEEPSEA_COBALTORE)
        {
            item = TLSItems.NEPTUNUM;
        }
		else if(this == TLSBlocks.DEEPSEA_VANADIUMORE || this == TLSBlocks.SEA_VANADIUMORE) {
			item = Item.getItemFromBlock(this);
		}
		
		return item;
	}

}
