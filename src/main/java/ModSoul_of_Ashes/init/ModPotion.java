package ModSoul_of_Ashes.init;

import ModSoul_of_Ashes.Potion.Frostbite.PotionFrostbite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModPotion {
	public static Potion frostbite = new PotionFrostbite();
	
	public static void init(){
		GameRegistry.register(frostbite);
		new ModPotion();
	}
	
//	public ModPotion () {
//		MinecraftForge.EVENT_BUS.register(this);
//	}
//	
//	@SubscribeEvent
//	public void onEntityUpdate(LivingUpdateEvent event){
//		EntityLivingBase player = event.getEntityLiving();
//		if(!player.worldObj.isRemote){
//			if(player.isPotionActive(ModPotion.frostbite)){
//				if(player.isSprinting()){
//					float Damage = ((float)(1+player.getActivePotionEffect(ModPotion.frostbite).getAmplifier())/4);
//					player.attackEntityFrom(ModDamagecause.causeFrostbiteDamage(player, null), Damage);
//				}            
//			}
//		}
//	}
}
