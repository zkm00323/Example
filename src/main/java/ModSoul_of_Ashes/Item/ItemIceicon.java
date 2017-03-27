package ModSoul_of_Ashes.Item;

import ModSoul_of_Ashes.Throwable.Entity.EntityIcebullet;
import ModSoul_of_Ashes.init.ModAchivenent;
import ModSoul_of_Ashes.init.ModPotion;
import ModSoul_of_Ashes.init.Potionregiser;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;

public class ItemIceicon extends Item{

	public ItemIceicon(){
		this.setUnlocalizedName("itemiceicon");
		this.setRegistryName("itemiceicon");
		setCreativeTab(CreativeTabs.MATERIALS);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for(int i = 0;i < IceSkillTypes.values().length;i++){
			subItems.add(new ItemStack(itemIn,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack)+ "." + IceSkillTypes.values()[stack.getMetadata()].getName();
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	ItemStack item = player.getHeldItemMainhand();
    	player.addStat(ModAchivenent.iceSkillslist[item.getMetadata()]);
    	
    	if(!world.isRemote){
    		switch (item.getMetadata()) {
			case 0:
	    		EntityIcebullet icebullet = new EntityIcebullet(world, player);
	        	icebullet.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
	            world.spawnEntityInWorld(icebullet);
				break;
			case 1:
				player.addPotionEffect(new PotionEffect(ModPotion.frostbite,30,0));
				System.out.println("hello");
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;

			default:
				break;
			}
    	}
		return super.onItemRightClick(world, player, hand);
	}
	
	public static enum IceSkillTypes implements IStringSerializable {
		ICEBULLETS("icebullets",0),
		ICEFOG("icefog",1),
		ICETHORNS("icethorns",2),
		ICEBLOCK("iceblock",3),
		BLIZZARD("blizzard",4),
		;

		private int ID;
		private String name;
		
		private IceSkillTypes(String nameIn,int IDIn){
			ID = IDIn;
			name = nameIn;
		}
		public String getName() {
			return name;
		}
		
		public int getID() {
			return ID;
		}
	}
}
