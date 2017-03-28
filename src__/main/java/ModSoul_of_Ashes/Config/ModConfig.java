package ModSoul_of_Ashes.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ModSoul_of_Ashes.Name;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.GuiConfigEntries.NumberSliderEntry;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {
	private static Configuration config = null;
	
	public static final String ICE = "ice";
	
	public static int iceBulletDamage;
	
	public static void init() {
		File configFile = new File(Loader.instance().getConfigDir(), "SoulOfAshes.cfg");
		config = new Configuration(configFile);
		syncFromFiles();
	}
		
	public static void register() {
		MinecraftForge.EVENT_BUS.register(new ModConfig());
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.getModID().equals(Name.MOD_ID)) {
			syncFromGui();
		}
	}
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static void syncFromFiles(){syncConfig(true, true);}
	public static void syncFromGui(){syncConfig(false, true);}
	public static void syncFromFields(){syncConfig(false, false);}
	
	private static void syncConfig(boolean loadFromConfigFile, boolean readFieldsFromConfig) {
		if(loadFromConfigFile) config.load();
		
		Property IBD = config.get(ICE, "iceBullet Damage", 20, I18n.format("config.skills.ice.ice_bullet_damage.comment"), 5, 40);
		IBD.setConfigEntryClass(NumberSliderEntry.class);
		
		List<String> ListSetting = new ArrayList<String>();
		ListSetting.add(IBD.getName());
		config.setCategoryPropertyOrder(ICE, ListSetting);
		
		if(readFieldsFromConfig){
			iceBulletDamage = IBD.getInt();
		}
		
		IBD.set(iceBulletDamage);

		if(config.hasChanged()) config.save();
	}
}
