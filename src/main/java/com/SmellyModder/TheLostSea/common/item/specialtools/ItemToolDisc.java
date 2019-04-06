package com.SmellyModder.TheLostSea.common.item.specialtools;

import java.util.List;
import java.util.Set;

import com.SmellyModder.TheLostSea.common.entity.projectiles.EntityDisc;
import com.SmellyModder.TheLostSea.common.init.TLSEnchants;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.common.item.ItemBase;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemToolDisc extends ItemTool {
		public int shot = 0;
		public int damage = 1;
		private float speed = 1.5F;
		public SoundEvent events;
		private boolean shouldLowerRecharge = false;
		private boolean shouldLowerRechargeII = false;
		private boolean shouldLowerRechargeIII = false;
		private ItemStack disc;
		
		private final EntityDisc.TypeOfDisc type;
		private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PRISMARINE);
		
		public ItemToolDisc(String name, int damageRanged, float speed, EntityDisc.TypeOfDisc typeIn, SoundEvent event, Item.ToolMaterial material) {
			super(material, EFFECTIVE_ON);
			setRegistryName(name);
			setTranslationKey(name);
			this.type = typeIn;
			this.damage = damageRanged;
			this.speed = speed;
			this.events = event;
	        this.maxStackSize = 1;
	        setCreativeTab(TheLostSea.TLS_GEAR);
	        
	        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, new DispenserBehavior());
	        TLSItems.ITEMS.add(this);
		}
		
		public final EnumAction getItemUseAction(ItemStack stack) {
	        return EnumAction.BOW;
	    }
		
		private int rechargeBase() {
			return this.shouldLowerRecharge == true ? 5 : 15;
		}
		
		private int rechargeBaseII() {
			return this.shouldLowerRechargeII == true ? -5 : 0;
		}
		
		private int rechargeBaseIII() {
			return this.shouldLowerRechargeIII == true ? -10 : 0;
		}
		
		@Override
		public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
			ItemStack stack = playerIn.getHeldItem(handIn);
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, events, SoundCategory.BLOCKS, 0.8F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if(!playerIn.capabilities.isCreativeMode)
				shot++;
			
				if(shot == 1) {
					playerIn.getCooldownTracker().setCooldown(this, rechargeBase() + rechargeBaseII() + rechargeBaseIII());
				}
				if(shot == 2) {
					playerIn.getCooldownTracker().setCooldown(this, rechargeBase() + rechargeBaseII() + rechargeBaseIII() + 5);
				}	
				if(shot >= 3 || shot == 3) {
					playerIn.getCooldownTracker().setCooldown(this, rechargeBase() + rechargeBaseII() + rechargeBaseIII() + 340);
					shot -= 3;
				}
				if(EnchantmentHelper.getEnchantmentLevel(TLSEnchants.RECHARGE, stack) > 0) {
					shouldLowerRecharge = true;
				}
				if(EnchantmentHelper.getEnchantmentLevel(TLSEnchants.RECHARGE, stack) > 1) {
					shouldLowerRechargeII = true;
				}
				if(EnchantmentHelper.getEnchantmentLevel(TLSEnchants.RECHARGE, stack) > 2) {
					shouldLowerRechargeIII = true;
				}
			
				if(!worldIn.isRemote) {
					EntityDisc disc = new EntityDisc(worldIn, playerIn);
					disc.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, speed, 1.0F);
					worldIn.spawnEntity(disc);
					disc.setDiscType(this.type);
					if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
						disc.setFire(100);
					}
					if (EnchantmentHelper.getEnchantmentLevel(TLSEnchants.ZEUS_THROWER, stack) > 0) {
						disc.createBolts = true;
					}
				}
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
		
		@Override
		public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if(!worldIn.isRemote) {
				if(worldIn.getBlockState(pos.up()).equals(Blocks.AIR.getDefaultState())) {
					
					return EnumActionResult.SUCCESS;
				}
			}
			return EnumActionResult.PASS;
		}
		
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
	        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
	        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
	            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0D, 0));
	        }
	        return multimap;
	    }
		
		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			list.add("Rarity: " + TextFormatting.GREEN + "Uncommon");
			list.add("Ranged Damage: " + damage);
			list.add("Speed: " + speed);
		}
		
	    public final int getItemEnchantability() {
	        return 9;
	    }
	    
        private static class DispenserBehavior extends BehaviorProjectileDispense {
	    	
	        @Override
	        protected IProjectile getProjectileEntity(World world, IPosition pos, ItemStack stack) {
	        	EntityDisc cap = new EntityDisc(world, pos.getX(), pos.getY(), pos.getZ());
	        	if(stack.getItem() == TLSItems.DISC_PRISMARINE) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.PRISMARINE);
		        }
	        	else if(stack.getItem() == TLSItems.DISC_DIAMOND) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.DIAMOND);
		        }
		        else if(stack.getItem() == TLSItems.DISC_GOLD) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.GOLD);
		        }
		        else if(stack.getItem() == TLSItems.DISC_WOOD) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.WOOD);
		        }
		        else if(stack.getItem() == TLSItems.DISC_STONE) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.STONE);
		        }
		        else if(stack.getItem() == TLSItems.DISC_IRON) {
		        	cap.setDiscType(EntityDisc.TypeOfDisc.IRON);
		        }
	            return cap;
	        }
	    
	        @Override
	        public ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
	        	World world = source.getWorld();
	        	IPosition iposition = BlockDispenser.getDispensePosition(source);
	        	EnumFacing enumfacing = (EnumFacing)source.getBlockState().getValue(BlockDispenser.FACING);
	        	IProjectile iprojectile = this.getProjectileEntity(world, iposition, stack);
	        	
	        	iprojectile.shoot((double)enumfacing.getXOffset(), (double)((float)enumfacing.getYOffset() + 0.1F), (double)enumfacing.getZOffset(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
	        	world.spawnEntity((Entity)iprojectile);
	        	stack.shrink(1);
	        	return stack;
	        }
        }
}
