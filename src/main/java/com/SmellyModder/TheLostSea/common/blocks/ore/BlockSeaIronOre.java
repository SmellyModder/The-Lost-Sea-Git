package com.SmellyModder.TheLostSea.common.blocks.ore;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSeaIronOre extends BlockBase{

	private boolean deep;
	public BlockSeaIronOre(String name, Material material, boolean isDeepStone) {
		super(name, material);
		deep = isDeepStone;
		float h = deep ? 4.0F : 3.5F;
		float r = deep ? 5.0F : 4.0F;
		float x = deep ? 2.5F : 1.5F;
		setHardness(h);
		setResistance(r);
		setHarvestLevel("pickaxe", (int) x);
		setCreativeTab(TheLostSea.TLS_ORES);
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

            if (this == TLSBlocks.SEA_GOLDORE)
            {
                i = MathHelper.getInt(rand, 0, 2);
            }
            else if (this == TLSBlocks.DEEPSEA_GOLDORE)
            {
                i = MathHelper.getInt(rand, 2, 5);
            }

            return i;
        }
        return 0;
    }
    
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
	   return new ItemStack(this);
	}

}
