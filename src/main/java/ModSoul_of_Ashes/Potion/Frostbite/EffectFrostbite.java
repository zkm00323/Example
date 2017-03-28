package ModSoul_of_Ashes.Potion;

import ModSoul_of_Ashes.init.ModDamagecause;
import ModSoul_of_Ashes.init.ModPotion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

public class EffectFrostbite extends PotionEffect{
    public EffectFrostbite(EntityLivingBase entity){
        this(entity, 0);
    }
    
    public EffectFrostbite(EntityLivingBase entity, int durationIn){
        this(entity, durationIn, 0);
    }

    public EffectFrostbite(EntityLivingBase entity, int durationIn, int amplifierIn){
        this(entity, durationIn, amplifierIn, false, true);
    }
    
    public EffectFrostbite(EntityLivingBase entity, int durationIn, int amplifierIn, boolean ambientIn, boolean showParticlesIn){
        super(ModPotion.frostbite, durationIn, amplifierIn, ambientIn, showParticlesIn);
    }
	
    @Override
    public boolean onUpdate(EntityLivingBase entity) {
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			if(player.isSprinting()){
				float Damage = ((float)(1+player.getActivePotionEffect(ModPotion.frostbite).getAmplifier())/4);
				player.attackEntityFrom(ModDamagecause.causeFrostbiteDamage(player, null), Damage);
			}      
		}
    	return super.onUpdate(entity);
    }
}
