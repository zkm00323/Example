package ModSoul_of_Ashes.Particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleIcesmoke extends Particle{
    public static final ResourceLocation icon = new ResourceLocation("soa:particle/icesmoke");

    public ParticleIcesmoke(World worldIn, double posXIn, double posYIn, double posZIn, double velocityX, double velocityY, double velocityZ) {
            super(worldIn, posXIn, posYIn, posZIn);
            motionX = velocityX;            
            motionY = velocityY;            
            motionZ = velocityZ;            
            particleMaxAge = 10;           
            particleAlpha = 1f;               
            particleScale = 1f;                
            particleGravity = -0.001f;      
            TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(icon.toString());
            setParticleTexture(sprite);    
    }
    
    public int getFXLayer(){
        return 1;
    }
    
    @Override
    public void onUpdate(){
      prevPosX = posX;
      prevPosY = posY;
      prevPosZ = posZ;
      particleScale -= particleScale/particleMaxAge; 
      particleAlpha -= particleAlpha/particleMaxAge;
      motionY -= particleGravity;
      moveEntity(motionX, motionY, motionZ); 


      if (isCollided) {
        this.setExpired();
      }


      if (this.particleMaxAge-- <= 0) {
        this.setExpired();
      }
    }
    
    @Override
    public void renderParticle(VertexBuffer vertexBuffer, Entity entity, float partialTick,float edgeLRdirectionX, float edgeUDdirectionY, float edgeLRdirectionZ,float edgeUDdirectionX, float edgeUDdirectionZ){
        double minU = particleTexture.getMinU();         
        double maxU = particleTexture.getMaxU();
        double minV = particleTexture.getMinV();
        double maxV = particleTexture.getMaxV();

        double scale = 0.1F * particleScale;
        final double scaleLR = scale;
        final double scaleUD = scale;
        double x = prevPosX + (posX - prevPosX) * partialTick - interpPosX;
        double y = prevPosY + (posY - prevPosY) * partialTick - interpPosY;
        double z = prevPosZ + (posZ - prevPosZ) * partialTick - interpPosZ;

        int combinedBrightness = getBrightnessForRender(partialTick);
        int skyLightTimes16 = combinedBrightness >> 16 & 65535;
        int blockLightTimes16 = combinedBrightness & 65535;

        vertexBuffer.pos(
                    x - edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
                y - edgeUDdirectionY * scaleUD,
                z - edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
                .tex(maxU, maxV)
                .color(particleRed, particleGreen, particleBlue, particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(
                    x - edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
                y + edgeUDdirectionY * scaleUD,
                z - edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
                .tex(maxU, minV)
                .color(particleRed, particleGreen, particleBlue, particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(
                x + edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,
                y + edgeUDdirectionY * scaleUD,
                z + edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)
                .tex(minU, minV)
                .color(particleRed, particleGreen, particleBlue, particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
        vertexBuffer.pos(
                    x + edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,
                y - edgeUDdirectionY * scaleUD,
                z + edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)
                .tex(minU, maxV)
                .color(particleRed, particleGreen, particleBlue, particleAlpha)
                .lightmap(skyLightTimes16, blockLightTimes16)
                .endVertex();
    }

}