package com.SmellyModder.TheLostSea.common.item.specialtools.exotics;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntitySlash;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.IHasModel;
import com.SmellyModder.TheLostSea.core.util.TheLostSea;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.Set;

public class ItemCutlass extends ItemTool implements IHasModel{
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
	public ItemCutlass(String name, ToolMaterial material, boolean isSpecial) {
		super(material, EFFECTIVE_ON);
		setRegistryName(name);
		setTranslationKey(name);
		this.attackSpeed = 5.0F;
		
		TLSItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		TheLostSea.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
			tooltip.add("§9Cuttin' edge§r:" + " Cut your foes with wind-fast speed and tons of damage, "
					+ "extra long range(+2 blocks), charge up a large slash of attacks!");
			tooltip.add("\"§oNot even the seven seas can handle yee' speed\"§r" + "§8 - Swashblocker§r");
        }else {
        	tooltip.add("Rarity: §6§lSPECIAL§r");
        	tooltip.add("Special Ability, §9Cuttin' edge§r" + "[§aSHIFT§r]");
        }
	}
	
	protected boolean swingItBaby;
	private int swung = 0;
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.PLAYERS, 0.9F, itemRand.nextFloat() * 0.2F + 0.5F);
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.PLAYERS, 0.9F, itemRand.nextFloat() * 0.2F + 0.5F);
		worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.PLAYERS, 0.9F, itemRand.nextFloat() * 0.2F + 0.5F);
		
		
		if(!playerIn.capabilities.isCreativeMode) {
			swung++;
			if(swung >= 3) {
				playerIn.getCooldownTracker().setCooldown(this, 345);
				swung = 0;
		}
		}
		
		playerIn.swingArm(handIn);
		if (!worldIn.isRemote)
        {
			EntitySlash disc = new EntitySlash(worldIn, playerIn);
			disc.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
			worldIn.spawnEntity(disc);
        }
		playerIn.addStat(StatList.getObjectUseStats(this));
			
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (!(entityLiving instanceof EntityPlayer))
		{
			return false;
		}

		EntityPlayer player = (EntityPlayer) entityLiving;

		Vec3d playerVision = player.getLookVec();
		AxisAlignedBB reachDistance = player.getEntityBoundingBox().expand(7.0F, 7.0F, 7.0F);

		List<Entity> locatedEntities = player.world.getEntitiesWithinAABB(Entity.class, reachDistance);

		Entity found = null;
		double foundLen = 0.0D;

		for (Object o : locatedEntities)
		{
			if (o == player)
			{
				continue;
			}

			Entity ent = (Entity) o;

			if (!ent.canBeCollidedWith())
			{
				continue;
			}

			Vec3d vec = new Vec3d(ent.posX - player.posX, ent.getEntityBoundingBox().minY + ent.height / 2f - player.posY - player.getEyeHeight(), ent.posZ - player.posZ);
			double len = vec.length();

			if (len > 10.0F)
			{
				continue;
			}

			vec = vec.normalize();
			double dot = playerVision.dotProduct(vec);

			if (dot < 1.0 - 0.125 / len || !player.canEntityBeSeen(ent))
			{
				continue;
			}

			if (foundLen == 0.0 || len < foundLen)
			{
				found = ent;
				foundLen = len;
			}
		}

		if (found != null && player.getRidingEntity() != found)
		{
			stack.damageItem(1, player);

			player.attackTargetEntityWithCurrentItem(found);
		}

		return false;
	}
	
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return swingItBaby;
	}

}
