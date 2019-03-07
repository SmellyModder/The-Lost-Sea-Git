package com.SmellyModder.TheLostSea.common.blocks.fluid;

import com.SmellyModder.TheLostSea.common.init.TLSFluids;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

import javax.annotation.Nonnull;

public class BlockDarkwaterFluid extends BlockFluidClassic implements IHasModel {
    public BlockDarkwaterFluid() {
        super(TLSFluids.DARKWATER, Material.WATER);
        setRegistryName("darkwater");
    }

    @Override
    public int getLightValue(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        return 1;
    }

    @Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
