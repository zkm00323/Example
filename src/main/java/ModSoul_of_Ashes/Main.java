package ModSoul_of_Ashes;

import ModSoul_of_Ashes.Config.ModConfig;
import ModSoul_of_Ashes.Potion.Frostbite.PotionFrostbite;
import ModSoul_of_Ashes.init.ModAchivenent;
import ModSoul_of_Ashes.init.ModEntity;
import ModSoul_of_Ashes.init.ModItems;
import ModSoul_of_Ashes.init.ModParticle;
import ModSoul_of_Ashes.init.ModPotion;
import ModSoul_of_Ashes.init.Potionregiser;
import ModSoul_of_Ashes.proxy.CommonProxy;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Name.MOD_ID,name = Name.NAME,version = Name.VERSION,acceptedMinecraftVersions = Name.ACCEPT_VRTDION,guiFactory = Name.CONFIG_GUI_CLASS)
public class Main {
	
	@Instance(Name.MOD_ID)
	public static Main instance;
	
	@SidedProxy(clientSide = Name.CLIENT_PROXY_CLASS,serverSide = Name.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModParticle.init();
		ModPotion.init();
		ModItems.init();
		ModEntity.init();
		ModAchivenent.init();
		ModConfig.init();
		proxy.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void Postinit(FMLPostInitializationEvent event){
		
	}

}

