package ModSoul_of_Ashes.Potion;

import java.awt.Color;

import ModSoul_of_Ashes.Name;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.reflect.internal.Trees.New;

public class PotionFrostbite extends Potion{
	
	public PotionFrostbite() {
		super(true, new Color(88,178,220).getRGB());
        this.setPotionName("effect.frostbite");
        this.setRegistryName(Name.MOD_ID, "frostbite");
        
	}
	
	public static final ResourceLocation icon = new ResourceLocation(Name.MOD_ID,"textures/potion/frostbite.png");
	
	@SideOnly(Side.CLIENT)
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		if (mc.currentScreen != null) {
			mc.getTextureManager().bindTexture(icon);
			Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(icon);
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}
}
