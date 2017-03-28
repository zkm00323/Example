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
			worldIn = entityIn.getEntityWorld();//玩家背包內的物品沒有世界
	    if (worldIn != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey("blood")){//阻擋創造模式物品欄
	       	return stack.getTagCompound().getInteger("bloodsave");
        }
		return 0;
	}
}
