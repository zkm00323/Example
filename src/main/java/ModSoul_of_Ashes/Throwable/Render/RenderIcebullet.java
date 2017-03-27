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
	        GlStateManager.pushMatrix();//上膛
	        GlStateManager.disableLighting();//關閉自帶光源
	        //GlStateManager.disableCull();//開啟雙面顯示
	        GlStateManager.enableBlend();//開啟不透明度
	        GlStateManager.translate((float)x, (float)y, (float)z);//坐標
	        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);//旋轉設定第二個參數
	        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);//旋轉設定第三個參數
	        Tessellator tessellator = Tessellator.getInstance();
	        VertexBuffer vertexbuffer = tessellator.getBuffer();
	        GlStateManager.enableRescaleNormal();

	        GlStateManager.scale(0.05625F, 0.05625F, 0.05625F);//設置大小
	        GlStateManager.translate(-3.0F, 0.0F, 0.0F);//不設置的話會插入地面一半的長度太多了,我們要讓他顯露多一點
	        
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
	      	//GlStateManager.rotate:第一個參數,似乎會在上次執行的角度基礎上再增加這次的角度
	      	//GlStateManager.rotate:第二,三,四個參數設置要對哪個軸向旋轉,似乎只有0不執行和!=0執行兩種結果,不管輸入多少都一樣
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
//	        //tex(向右,向下):圖片坐標點(單位,16格像素為0.5,一格像素0.03125)
//	        //pos:遊戲坐標點
//	        //確立4個點可完成一個四邊形繪圖
//	        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex(0.0D, 0.15625D).endVertex();
//	        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex(0.15625D, 0.15625D).endVertex();
//	        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex(0.15625D, 0.3125D).endVertex();
//	        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex(0.0D, 0.3125D).endVertex();
//	        //draw:繪製結束
//	        tessellator.draw();
	//
//	        for (int j = 0; j < 2; ++j)
//	        {
//	        	//GlStateManager.rotate:第一個參數,似乎會在上次執行的角度基礎上再增加這次的角度
//	        	//GlStateManager.rotate:第二,三,四個參數設置要對哪個軸向旋轉,似乎只有0不執行和!=0執行兩種結果,不管輸入多少都一樣
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
	        GlStateManager.enableLighting();//開啟自帶光源
	        //GlStateManager.enableCull();//關閉雙面顯示
	        GlStateManager.disableBlend();//關閉不透明度
	        GlStateManager.popMatrix();//退膛
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }

}
