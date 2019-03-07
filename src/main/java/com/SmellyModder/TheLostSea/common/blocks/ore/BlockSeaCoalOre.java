package com.SmellyModder.TheLostSea.common.blocks.ore;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.core.TheLostSea;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSeaCoalOre extends BlockBase{

	private boolean deep;
	public BlockSeaCoalOre(String name, Material material, boolean isDeepStone) {
		super(name, material);
		deep = isDeepStone;
		float h = deep ? 3.5F : 3F;
		float r = deep ? 4.5F : 3.5F;
		int x = deep ? 2 : 1;
		setHardness(h);
		setResistance(r);
		setHarvestLevel("pickaxe", x);
		this.setCreativeTab(TheLostSea.TLS_BLOCKS);
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

            if (this == TLSBlocks.SEA_COALORE)
            {
                i = MathHelper.getInt(rand, 0, 2);
            }
            else if (this == TLSBlocks.DEEPSEA_COALORE)
            {
                i = MathHelper.getInt(rand, 1, 3);
            }

            return i;
        }
        return 0;
    }
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return Items.COAL;
    }

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
	   return new ItemStack(this);
	}

}
