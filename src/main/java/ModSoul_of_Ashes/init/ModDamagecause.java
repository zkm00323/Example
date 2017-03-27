package ModSoul_of_Ashes.init;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class ModDamagecause {
    public static DamageSource causeFrostbiteDamage(Entity source, @Nullable Entity indirectEntityIn){
        return (new EntityDamageSourceIndirect("Frostbite", source, indirectEntityIn)).setDamageBypassesArmor();
    }
}
