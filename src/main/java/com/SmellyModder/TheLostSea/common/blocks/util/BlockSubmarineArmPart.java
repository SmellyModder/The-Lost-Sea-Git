package com.SmellyModder.TheLostSea.common.blocks.util;

import com.SmellyModder.TheLostSea.common.blocks.BlockBase;

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

public class BlockSubmarineArmPart extends Block{
	
	 public static final PropertyEnum<BlockSubmarineArmPart.EnumType> VARIANT = PropertyEnum.<BlockSubmarineArmPart.EnumType>create("variant", BlockSubmarineArmPart.EnumType.class);
	 
	 public BlockSubmarineArmPart()
	 {
		 	super(Material.WOOD);
	        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockSubmarineArmPart.EnumType.BLUE));
	        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	    }

	    /**
	     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	     * returns the metadata of the dropped item based on the old metadata of the block.
	     */
	    public int damageDropped(IBlockState state)
	    {
	        return ((BlockSubmarineArmPart.EnumType)state.getValue(VARIANT)).getMetadata();
	    }

	    /**
	     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	     */
	    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	    {
	        for (BlockSubmarineArmPart.EnumType BlockSubmarineArmPart$enumtype : BlockSubmarineArmPart.EnumType.values())
	        {
	            items.add(new ItemStack(this, 1, BlockSubmarineArmPart$enumtype.getMetadata()));
	        }
	    }

	    /**
	     * Convert the given metadata into a BlockState for this Block
	     */
	    public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(VARIANT, BlockSubmarineArmPart.EnumType.byMetadata(meta));
	    }

	    /**
	     * Get the MapColor for this Block and the given BlockState
	     */
	    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
	        return ((BlockSubmarineArmPart.EnumType)state.getValue(VARIANT)).getMapColor();
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        return ((BlockSubmarineArmPart.EnumType)state.getValue(VARIANT)).getMetadata();
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {VARIANT});
	    }

	    public static enum EnumType implements IStringSerializable
	    {
	        RED(0, "red", MapColor.WOOD),
	        ORANGE(1, "orange", MapColor.OBSIDIAN),
	        YELLOW(2, "yellow", MapColor.SAND),
	        LIMEGREEN(3, "lime", MapColor.DIRT),
	        GREEN(4, "green", MapColor.ADOBE),
	        BLUE(7, "blue", "lapis", MapColor.BROWN),
	        LIGHTBLUE(6, "light_blue", MapColor.BROWN),
	        CYAN(5, "cyan", "cyan_", MapColor.BROWN),
	        PURPLE(8, "purple", MapColor.BROWN),
	        MAGENTA(9, "magenta", MapColor.BROWN),
	        PINK(10, "pink", MapColor.BROWN),
	        BROWN(11, "brown", MapColor.BROWN),
	        BLACK(12, "black", "evil", MapColor.BROWN),
	        GRAY(13, "gray", MapColor.BROWN),
	        LIGHTGRAY(14, "light_gray", MapColor.BROWN),
	        WHITE(15, "white", MapColor.GRAY);
	        private static final BlockSubmarineArmPart.EnumType[] META_LOOKUP = new BlockSubmarineArmPart.EnumType[values().length];
	        private final int meta;
	        private final String name;
	        private final String unlocalizedName;
	        /** The color that represents this entry on a map. */
	        private final MapColor mapColor;

	        private EnumType(int metaIn, String nameIn, MapColor mapColorIn)
	        {
	            this(metaIn, nameIn, nameIn, mapColorIn);
	        }

	        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn)
	        {
	            this.meta = metaIn;
	            this.name = nameIn;
	            this.unlocalizedName = unlocalizedNameIn;
	            this.mapColor = mapColorIn;
	        }

	        public int getMetadata()
	        {
	            return this.meta;
	        }

	        /**
	         * The color which represents this entry on a map.
	         */
	        public MapColor getMapColor()
	        {
	            return this.mapColor;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        public static BlockSubmarineArmPart.EnumType byMetadata(int meta)
	        {
	            if (meta < 0 || meta >= META_LOOKUP.length)
	            {
	                meta = 0;
	            }

	            return META_LOOKUP[meta];
	        }

	        public String getName()
	        {
	            return this.name;
	        }

	        public String getUnlocalizedName()
	        {
	            return this.unlocalizedName;
	        }

	        static
	        {
	            for (BlockSubmarineArmPart.EnumType BlockSubmarineArmPart$enumtype : values())
	            {
	                META_LOOKUP[BlockSubmarineArmPart$enumtype.getMetadata()] = BlockSubmarineArmPart$enumtype;
	            }
	        }
	    }
}
