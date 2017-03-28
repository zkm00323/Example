package ModSoul_of_Ashes.init;


import ModSoul_of_Ashes.Name;
import ModSoul_of_Ashes.Item.ItemBloodsave;
import ModSoul_of_Ashes.Item.ItemIceicon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemBloodsave itembloodsave = new ItemBloodsave();
	public static ItemIceicon itemiceicon = new ItemIceicon();

	public static void init(){
		GameRegistry.register(itembloodsave);
		GameRegistry.register(itemiceicon);
	}
	
	public static void register(){
		registerinit(itembloodsave);
		for(int i = 0;i < ItemIceicon.IceSkillTypes.values().length; i++)
			registerinit(itemiceicon,i,ItemIceicon.IceSkillTypes.values()[i].getName());
	}
	
	public static void registerinit(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() , "inventory"));
	}
	
	public static void registerinit(Item item,int meta,String name){
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName()+"_"+ name , "inventory"));
	}
	
}
