package com.SmellyModder.TheLostSea.common.blocks.ore;

import java.util.Random;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;
import com.SmellyModder.TheLostSea.common.init.TLSBlocks;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockSeaOres extends BlockBase{
	private boolean deep;
	int ID;
	public BlockSeaOres(String name, Material material, boolean isDeepStone, int ID) {
		super(name, material);
		deep = isDeepStone;
		float h = deep ? 4.5F : 4F;
		float r = deep ? 5.5F : 4.5F;
		int x = deep ? 3 : 2;
		this.ID = ID;
		setHardness(h);
		setResistance(r);
		setHarvestLevel("pickaxe", x);
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
	
	@Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
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
}
