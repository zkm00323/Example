package ModSoul_of_Ashes.Throwable.Render;

import java.util.Random;

import ModSoul_of_Ashes.Name;
import ModSoul_of_Ashes.Throwable.Entity.EntityIcebullet;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderIcebullet extends Render<EntityIcebullet>{

	public RenderIcebullet(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityIcebullet entity) {
		return new ResourceLocation(Name.MOD_ID, "textures/entity/ice.png");
	}

	   @Override
	    public void doRender(EntityIcebullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
	        this.bindEntityTexture(entity);
	        //GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        GlStateManager.pushMatrix();//����
	        GlStateManager.disableLighting();//�P�]�Ԏ���Դ
	        //GlStateManager.disableCull();//�_���p���@ʾ
	        GlStateManager.enableBlend();//�_����͸����
	        GlStateManager.translate((float)x, (float)y, (float)z);//����
	        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);//���D�O���ڶ�������
	        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);//���D�O������������
	        Tessellator tessellator = Tessellator.getInstance();
	        VertexBuffer vertexbuffer = tessellator.getBuffer();
	        GlStateManager.enableRescaleNormal();

	        GlStateManager.scale(0.05625F, 0.05625F, 0.05625F);//�O�ô�С
	        GlStateManager.translate(-3.0F, 0.0F, 0.0F);//���O�õ�Ԓ���������һ����L��̫����,�҂�Ҫ׌���@¶��һ�c
	        
	        float f9 = (float)entity.throwableShake - partialTicks;
	        if (f9 > 0.0F)
	        {
	            float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
	            GlStateManager.rotate(f10, 0.0F, 0.0F, 1.0F);
	        }

	        if (this.renderOutlines)
	        {
	            GlStateManager.enableColorMaterial();
	            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
	        }
	        
	      for (int j = 0; j < 4; ++j)
	      {
				double random = new Random().nextInt(10)*0.03125; 
	      	//GlStateManager.rotate:��һ������,�ƺ������ϴΈ��еĽǶȻ��A���������@�εĽǶ�
	      	//GlStateManager.rotate:�ڶ�,��,�Ă������O��Ҫ���Ă��S�����D,�ƺ�ֻ��0�����к�!=0���ЃɷN�Y��,����ݔ����ٶ�һ��
	          GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
	          //GlStateManager.glNormal3f(0.0F, 0.0F, 0.05625F);
	          vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
	          vertexbuffer.pos(-3.0D, -3.0D, 3.0D).tex(random+0.0D, random+0.0D).endVertex();
	          vertexbuffer.pos(3.0D, -3.0D, 3.0D).tex(random+0.1875D, random+0.0D).endVertex();
	          vertexbuffer.pos(3.0D, 3.0D, 3.0D).tex(random+0.1875D, random+0.1875D).endVertex();
	          vertexbuffer.pos(-3.0D, 3.0D, 3.0D).tex(random+0.0D, random+0.1875D).endVertex();
	          tessellator.draw();
	          
	          random = new Random().nextInt(10)*0.03125;
	          
	          vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
	          vertexbuffer.pos(-9.0D, 0.0D, 0.0D).tex(random+0.0D, random+0.0D).endVertex();
	          vertexbuffer.pos(-3.0D, -3.0D, 3.0D).tex(random+0.1875D, random+0.0D).endVertex();
	          vertexbuffer.pos(-3.0D, 3.0D, 3.0D).tex(random+0.1875D, random+0.1875D).endVertex();
	          vertexbuffer.pos(-9.0D, 0.0D, 0.0D).tex(random+0.0D, random+0.1875D).endVertex();
	          tessellator.draw();
	          
	          random = new Random().nextInt(10)*0.03125;
	          
	          vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
	          vertexbuffer.pos(9.0D, 0.0D, 0.0D).tex(random+0.0D, random+0.0D).endVertex();
	          vertexbuffer.pos(3.0D, 3.0D, 3.0D).tex(random+0.1875D, random+0.0D).endVertex();
	          vertexbuffer.pos(3.0D, -3.0D, 3.0D).tex(random+0.1875D, random+0.1875D).endVertex();
	          vertexbuffer.pos(9.0D, 0.0D, 0.0D).tex(random+0.0D, random+0.1875D).endVertex();
	          tessellator.draw();
	      }
	///////////////////////////////////////////////////////////////////////////////////////
//	        //GlStateManager.glNormal3f(0.05625F, 0.0F, 0.0F);
//	        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//	        //tex(����,����):�DƬ�����c(��λ,16�����؞�0.5,һ������0.03125)
//	        //pos:�[�������c
//	        //�_��4���c�����һ����߅���L�D
//	        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex(0.0D, 0.15625D).endVertex();
//	        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex(0.15625D, 0.15625D).endVertex();
//	        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex(0.15625D, 0.3125D).endVertex();
//	        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex(0.0D, 0.3125D).endVertex();
//	        //draw:�L�u�Y��
//	        tessellator.draw();
	//
//	        for (int j = 0; j < 2; ++j)
//	        {
//	        	//GlStateManager.rotate:��һ������,�ƺ������ϴΈ��еĽǶȻ��A���������@�εĽǶ�
//	        	//GlStateManager.rotate:�ڶ�,��,�Ă������O��Ҫ���Ă��S�����D,�ƺ�ֻ��0�����к�!=0���ЃɷN�Y��,����ݔ����ٶ�һ��
//	            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
//	            //GlStateManager.glNormal3f(0.0F, 0.0F, 0.05625F);
//	            vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//	            vertexbuffer.pos(-8.0D, -2.0D, 0.0D).tex(0.0D, 0.0D).endVertex();
//	            vertexbuffer.pos(8.0D, -2.0D, 0.0D).tex(0.5D, 0.0D).endVertex();
//	            vertexbuffer.pos(8.0D, 2.0D, 0.0D).tex(0.5D, 0.15625D).endVertex();
//	            vertexbuffer.pos(-8.0D, 2.0D, 0.0D).tex(0.0D, 0.15625D).endVertex();
//	            tessellator.draw();
//	        }
	///////////////////////////////////////////////////////////////////////////////////////

	        if (this.renderOutlines)
	        {
	            GlStateManager.disableOutlineMode();
	            GlStateManager.disableColorMaterial();
	        }

	        GlStateManager.disableRescaleNormal();
	        GlStateManager.enableLighting();//�_���Ԏ���Դ
	        //GlStateManager.enableCull();//�P�]�p���@ʾ
	        GlStateManager.disableBlend();//�P�]��͸����
	        GlStateManager.popMatrix();//����
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }

}
