package ModSoul_of_Ashes.init;

import java.util.Random;

import ModSoul_of_Ashes.Particle.ParticleIcesmoke;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModParticle {

	public static void init() {
		new ModParticle();
	}

	public ModParticle() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void TexturestitcherEventPre(TextureStitchEvent.Pre event) {
		ResourceLocation icon = new ResourceLocation("soa:particle/icesmoke");
		event.getMap().registerSprite(icon);
	}

	public static void Icesmoke(int amount,Entity entity,double deviationX,double deviationY,double deviationZ,double velocityX,double velocityY,double velocityZ){
		for (int i = 0; i < amount; ++i){
			double posX = (new Random().nextDouble()-0.5)*deviationX+entity.posX;
			double posY = (new Random().nextDouble()-0.5)*deviationY+entity.posY;
			double PosZ= (new Random().nextDouble()-0.5)*deviationZ+entity.posZ;
			double velX = (new Random().nextDouble()-0.5)*velocityX;
			double velY = (new Random().nextDouble()-0.5)*velocityY;
			double velZ = (new Random().nextDouble()-0.5)*velocityZ;
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleIcesmoke(entity.worldObj, posX, posY, PosZ, velX, velY, velZ));
		}
	}
}

