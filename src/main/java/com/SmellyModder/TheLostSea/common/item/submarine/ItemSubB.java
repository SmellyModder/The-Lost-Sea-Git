package com.SmellyModder.TheLostSea.common.item.submarine;

import java.util.List;

import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemSubB extends Item implements IHasModel{

	
	private final EntitySubmarineI.Type type;
	
    public ItemSubB(EntitySubmarineI.Type typeIn, String name)
    {
        this.type = typeIn;
        this.maxStackSize = 1;
        this.setCreativeTab(TheLostSea.TLS_VEHICLES);
        this.setTranslationKey("sub." + typeIn.getName());
        this.setRegistryName(name);
        
        TLSItems.ITEMS.add(this);
	}
    
    @Override
	public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
		list.add("Rarity:" + " §a§lUncommon§r");
		list.add("Tier:" + " §8§oI§r");
		list.add("Health:" + " §a125§r");
		list.add("Speed:" + " §95§r");
	}

	@Override
	public void registerModels() {
		
		
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

    /**
     * Called when the equipped item is right clicked.
     */
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer entity, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ,
			EnumHand hand) {
		float var4 = 1.0F;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		if (true) {
			world.playSound((EntityPlayer) null, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(("block.anvil.land"))),
					SoundCategory.NEUTRAL, 1.0F, 1.0F);
		}

		if (true) {
			EntitySubmarineI sentity = new EntitySubmarineI(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(i, j + 2, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
				sentity.setBoatType(this.type);
			}
		}

		return EnumActionResult.PASS;
	}
}
