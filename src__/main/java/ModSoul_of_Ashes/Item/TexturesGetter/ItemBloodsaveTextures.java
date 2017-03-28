package ModSoul_of_Ashes.Item.TexturesGetter;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemBloodsaveTextures implements IItemPropertyGetter{
	@Override
	public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
		if(worldIn == null && entityIn != null)
			worldIn = entityIn.getEntityWorld();//��ұ����ȵ���Ʒ�]������
	    if (worldIn != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey("blood")){//�������ģʽ��Ʒ��
	       	return stack.getTagCompound().getInteger("bloodsave");
        }
		return 0;
	}
}
