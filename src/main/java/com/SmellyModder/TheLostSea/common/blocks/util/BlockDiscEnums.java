package com.SmellyModder.TheLostSea.common.blocks.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDiscEnums extends Block {
    public static final PropertyEnum<BlockDiscEnums.EnumType> VARIANT = PropertyEnum.<BlockDiscEnums.EnumType>create("variant", BlockDiscEnums.EnumType.class);

    public BlockDiscEnums() {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockDiscEnums.EnumType.OAK));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public int damageDropped(IBlockState state) {
        return ((BlockDiscEnums.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (BlockDiscEnums.EnumType BlockDiscEnums$enumtype : BlockDiscEnums.EnumType.values()) {
            items.add(new ItemStack(this, 1, BlockDiscEnums$enumtype.getMetadata()));
        }
    }
    
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, BlockDiscEnums.EnumType.byMetadata(meta));
    }

    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return ((BlockDiscEnums.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    public int getMetaFromState(IBlockState state) {
        return ((BlockDiscEnums.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable {
        OAK(0, "oak", MapColor.WOOD),
        SPRUCE(1, "spruce", MapColor.OBSIDIAN),
        BIRCH(2, "birch", MapColor.SAND),
        JUNGLE(3, "jungle", MapColor.DIRT),
        ACACIA(4, "acacia", MapColor.ADOBE),
        DARK_OAK(5, "dark_oak", "big_oak", MapColor.BROWN),
        VANADIUM(5, "vanadium", "v", MapColor.BROWN),
        NEPTUNUM(5, "neptunum", "n", MapColor.BROWN);

        private static final BlockDiscEnums.EnumType[] META_LOOKUP = new BlockDiscEnums.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String translationKey;
        /** The color that represents this entry on a map. */
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor mapColorIn) {
            this(metaIn, nameIn, nameIn, mapColorIn);
        }

        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn) {
            this.meta = metaIn;
            this.name = nameIn;
            this.translationKey = unlocalizedNameIn;
            this.mapColor = mapColorIn;
        }

        public int getMetadata() {
            return this.meta;
        }

        /**
         * The color which represents this entry on a map.
         */
        public MapColor getMapColor() {
            return this.mapColor;
        }

        public String toString() {
            return this.name;
        }

        public static BlockDiscEnums.EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName() {
            return this.name;
        }

        public String getTranslationKey() {
            return this.translationKey;
        }

        static {
            for (BlockDiscEnums.EnumType BlockDiscEnums$enumtype : values()) {
                META_LOOKUP[BlockDiscEnums$enumtype.getMetadata()] = BlockDiscEnums$enumtype;
            }
        }
    }
}
