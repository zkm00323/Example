package ModSoul_of_Ashes.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ModSoul_of_Ashes.Name;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) {}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return ModGuiConfig.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}

	public static class ModGuiConfig extends GuiConfig{

		public ModGuiConfig(GuiScreen parentScreen) {
			super(parentScreen, getConfigElements(), Name.MOD_ID, false, false, I18n.format("gui.config.main_title"));

		}

		private static List<IConfigElement> getConfigElements() {
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			list.add(new DummyCategoryElement(I18n.format("gui.config.category.skills"), "gui.config.category.skills", CategoryEntrySetting.class));
			return list;
		}
		
		public static class CategoryEntrySetting extends CategoryEntry{
			public CategoryEntrySetting(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement) {super(owningScreen, owningEntryList, configElement);}
			@Override
			protected GuiScreen buildChildScreen() {
				List<IConfigElement> list = new ArrayList<IConfigElement>();
				list.add(new DummyCategoryElement(I18n.format("gui.config.category.Ice"), "gui.config.category.Ice", CategorySkillsSetting.class));
				String windowTitle = I18n.format("gui.config.category.Ice");
				return new GuiConfig(owningScreen, list, owningScreen.modID, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
			}
			
			public static class CategorySkillsSetting extends CategoryEntry{
				public CategorySkillsSetting(GuiConfig owningScreen, GuiConfigEntries owningEntryList,IConfigElement configElement){super(owningScreen, owningEntryList, configElement);}
				@Override
				protected GuiScreen buildChildScreen() {
					List<IConfigElement> list = new ArrayList<IConfigElement>();					
					list.addAll(new ConfigElement(ModConfig.getConfig().getCategory(ModConfig.ICE)).getChildElements());
					String windowTitle = I18n.format("gui.config.category.icebullet");		
					return new GuiConfig(owningScreen, list, owningScreen.modID, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, windowTitle);
				}
			}
		}
	}
}