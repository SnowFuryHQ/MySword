package ljr.sword.Swords;


import java.util.List;


import ljr.sword.MySword;
import ljr.sword.Loader.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NormalSword extends ItemSword{

	private static final String name = "normalsword";
	private static final int HarvestLevel = 10;//挖掘等级

	public NormalSword() {
		super(EnumHelper.addToolMaterial("Normal", HarvestLevel, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 30));
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
    	this.setHarvestLevel("pickaxel", HarvestLevel);
    	this.setHarvestLevel("axe", HarvestLevel);
    	this.setHarvestLevel("sword", HarvestLevel);
        this.setCreativeTab(CreativeTabsLoader.MySwordCreativeTabs);
	}
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
	try {
		 KillEntity(entity);
		 KillEntityLivingBase((EntityLivingBase) entity);
		entity.attackEntityFrom(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 return true;
    }
	
	   public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        ItemStack itemstack = playerIn.getHeldItem(handIn);
	        MySword.getLogger().info("onItemRightClick");

	        BlockPos playerpos = playerIn.getPosition();
	        int playerX = playerpos.getX();
	        int playerY = playerpos.getY();
	        int playerZ = playerpos.getZ();
	        AxisAlignedBB bb =new AxisAlignedBB(playerX-10,playerY-10,playerZ-10,playerX+10,playerY+10,playerZ+10);
	        List<Entity> Entities =worldIn.getEntitiesWithinAABBExcludingEntity(playerIn,bb);
	        for (Entity entity : Entities) {
	        	MySword.getLogger().info(String.format("Find %d entities to kill", Entities.size()));
	        	if (entity instanceof EntityLivingBase) {
	        		KillEntityLivingBase((EntityLivingBase) entity);
				}else {
			        KillEntity(entity);
				}
			}

	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	    }
	    
	    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	    {
	    	MySword.getLogger().info("onhitEntity");
	    	attacker.setHealth(Float.MAX_VALUE);
	    	KillEntityLivingBase(target);
	        return true;
	    }
	    private void KillEntityLivingBase(EntityLivingBase target) {
	    	MySword.getLogger().info("onKillEntityLivingBase");
	    	try {
				target.performHurtAnimation();
			} catch (Exception e) {
			}
	    	try {
				if (org.lwjgl.input.Keyboard.isKeyDown(org.lwjgl.input.Keyboard.KEY_LSHIFT)) {
					if (target instanceof EntityPlayerMP) {
						MySword.getLogger().info("Lshift to kick player");
						EntityPlayerMP entityPlayerMP = (EntityPlayerMP) target;
						entityPlayerMP.onDeath(new EntityDamageSource(target.getName(),target ));
						entityPlayerMP.connection.disconnect(null);
					} else {
					MySword.getLogger().info("Lshift to remove entity");
					Remove_entity(target);
					}
				}
			} catch (Exception e) {
			}
	    	target.setFire(20);
	    	target.setInvisible(false);
	    	target.setSprinting(false); 
	    	target.handleWaterMovement();
	    	target.setNoGravity(false);
	    	target.stopActiveHand();
	    	target.setAbsorptionAmount(0);
	    	target.setJumping(true);
	    	target.attackEntityFrom(DamageSource.OUT_OF_WORLD,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.ANVIL,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.LIGHTNING_BOLT,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.ON_FIRE,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.LAVA,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.IN_WALL,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.CRAMMING,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.DROWN,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.STARVE,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.CACTUS,Float.MAX_VALUE);
			target.attackEntityFrom(DamageSource.FALL,Float.MAX_VALUE);
			target.attackEntityFrom(DamageSource.WITHER,Float.MAX_VALUE);
			target.attackEntityFrom(DamageSource.DRAGON_BREATH,Float.MAX_VALUE);
			target.attackEntityFrom(DamageSource.FALLING_BLOCK,Float.MAX_VALUE);
			target.attackEntityFrom(DamageSource.FIREWORKS,Float.MAX_VALUE);
	    	target.attackEntityFrom(DamageSource.MAGIC,Float.MAX_VALUE);
	    	target.onDeath(DamageSource.MAGIC);
	    	target.setHealth(0f);
	    	if ((!target.isDead) || target.isEntityUndead() ) {
	    		MySword.getLogger().info("unDead,Prepare to onKillCommand");
	    		target.onKillCommand();
			}
	    	if ((!target.isDead) || target.isEntityUndead()) {
	    		MySword.getLogger().info("unDead,Prepare to setDead");
				target.setDead();
			}
		}
	    private void KillEntity(Entity target) {
	    	MySword.getLogger().info("onKillEntity");
	    	try {
				target.performHurtAnimation();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	try {
				target.performHurtAnimation();
			} catch (Exception e) {
			}
	    		target.setNoGravity(false);
	    		target.setInvisible(false);
	    		target.onKillCommand();
	    		target.setDead();
		}
	    private void Remove_entity(Entity target) {
	    	try {
	    		final int Deep = 10000;
		        BlockPos targPos = target.getPosition();
		        int targPosX = targPos.getX();
		        int targPosY = targPos.getY()-Deep;
		        int targPosZ = targPos.getZ();
		    MySword.getLogger().info(String.format("Moving entity to %d %d %d",targPosX,targPosY,targPosZ));
			target.move(MoverType.SHULKER_BOX, targPosX, targPosY, targPosZ);
			target.move(MoverType.PISTON, targPosX, targPosY, targPosZ);
			target.move(MoverType.PLAYER, targPosX, targPosY, targPosZ);
			target.move(MoverType.SELF, targPosX, targPosY, targPosZ);
	    	target.move(MoverType.SHULKER, targPosX, targPosY, targPosZ);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
	    
	    
	    
	    
	    
	    
	    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	    {
	        return false;
	    }

	    @SideOnly(Side.CLIENT)
	    public boolean hasEffect(ItemStack stack)
	    {
	        return true;
	    }

	    public boolean isDamageable()
	    {
	        return false;
	    }
	    public float getDestroySpeed(ItemStack stack, IBlockState state)
	    {
	        Block block = state.getBlock();

	        if (block == Blocks.WEB)
	        {
	            return 15.0F;
	        }
	        else
	        {
	            return 10F;
	        }
	    }	
	    public float getAttackDamage()
	    {
	        return Float.MAX_VALUE;
	    }
		
	    
}
