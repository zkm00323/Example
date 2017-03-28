package ModSoul_of_Ashes.init;

import ModSoul_of_Ashes.Main;
import ModSoul_of_Ashes.Name;
import ModSoul_of_Ashes.Throwable.Entity.*;
import ModSoul_of_Ashes.Throwable.Render.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity {
	public static void init(){
		initregister("icebullet", EntityIcebullet.class, 64, 10, true);

	}
	

	public static void register(){
    	RenderingRegistry.registerEntityRenderingHandler(EntityIcebullet.class, renderManager -> new RenderIcebullet(renderManager));

	}
	
	private static int entityID = 0;
	
	public static void initregister(String name,Class<? extends Entity> entityClass ,int r,int tick ,boolean sendupdata){
		final ResourceLocation registryName = new ResourceLocation(Name.MOD_ID, name);
		EntityRegistry.registerModEntity(registryName, entityClass, registryName.toString(), entityID++, Main.instance, r, tick, sendupdata);

	}
}
