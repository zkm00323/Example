package ModSoul_of_Ashes.Item;

import java.util.List;
import java.util.Random;

import ModSoul_of_Ashes.Main;
import ModSoul_of_Ashes.Item.TexturesGetter.ItemBloodsaveTextures;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemBloodsave extends Item{
	public ItemBloodsave(){
		setUnlocalizedName("itembloodsave");
		setRegistryName("itembloodsave");
		setCreativeTab(CreativeTabs.MATERIALS);
		setMaxStackSize(1);
		
		if(!Main.proxy.isServerSider())this.addPropertyOverride(new ResourceLocation("bloodsave"), new ItemBloodsaveTextures());
	}
	
	   @Override
	    public ItemStack onItemUseFinish(ItemStack item, World world, EntityLivingBase player) {
	    	if(!world.isRemote){
		    	if(item.getTagCompound().getInteger("bloodsave")>0 && !(player.getMaxHealth() == player.getHealth())){
					if(player.getMaxHealth()-player.getHealth()>item.getTagCompound().getInteger("bloodsave")){
						player.heal(item.getTagCompound().getInteger("bloodsave"));  
						item.getTagCompound().setInteger("bloodsave", 0);
					}else{
						item.getTagCompound().setInteger("bloodsave",(item.getTagCompound().getInteger("bloodsave")-(int)(player.getMaxHealth()-player.getHealth())));
						player.setHealth(player.getMaxHealth()); 
					}	
					((EntityPlayer) player).addChatComponentMessage(new TextComponentString("bloodsave:"+item.getTagCompound().getInteger("bloodsave")), true);
				}  
	    	}
	    	return super.onItemUseFinish(item, world, player);
	    }
	    
	    public int getMaxItemUseDuration(ItemStack stack){
	        return 32;
	    }

	    public EnumAction getItemUseAction(ItemStack stack){
	        return EnumAction.DRINK;
	    }
	    
	    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn){
		   	if(!world.isRemote){
	        	ItemStack item = player.getHeldItemMainhand();
	    		if(item.getTagCompound()==null){
	    			item.setTagCompound(new NBTTagCompound());
	    			NBTTagCompound nbt = new NBTTagCompound();
	    			nbt.setInteger("bloodsave", 20);
	    			item.getTagCompound().setTag("blood", nbt); 
	    		}
	    		if(player.isSneaking() && item.getTagCompound().getInteger("bloodsave")<20){
	    			player.setActiveHand(handIn);
	    			int damage = new Random().nextInt(10)+1;      		
	    			int save = item.getTagCompound().getInteger("bloodsave");
	    			player.setHealth(player.isCreative() ? player.getHealth()-0: player.getHealth()-damage);
	    			((EntityPlayer) player).addChatComponentMessage(new TextComponentString("bloodsave:"+item.getTagCompound().getInteger("bloodsave")+"+"+damage/2), true);
	    			item.getTagCompound().setInteger("bloodsave", save + damage/2 > 20 ? 20 : save + damage/2);     
	    			player.stopActiveHand();
	    			if(item.getTagCompound().getInteger("bloodsave")==20){
	    				((EntityPlayer) player).addChatComponentMessage(new TextComponentString("bloodsave:20"), true);
	    			}
	    		}else if(!player.isSneaking() && item.getTagCompound().getInteger("bloodsave")>0){
	    			player.setActiveHand(handIn);
	    		}
	     	}
		   	return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
	    }
	    
	    @Override
	    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	        NBTTagCompound nbt = stack.getTagCompound();
	        if (nbt != null && nbt.hasKey("bloodsave"))
	        tooltip.add("bloodsave: " + nbt.getInteger("bloodsave"));
	    	super.addInformation(stack, playerIn, tooltip, advanced);
	    }
}
