package ModSoul_of_Ashes.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ModAchivenent {
	public static Achievement achivementicebullets,achivementicefog,achivementicethorns,achivementiceblock,achivementblizzard;
	public static Achievement iceSkillslist[] = {achivementicebullets,achivementicefog,achivementicethorns,achivementiceblock,achivementblizzard};
	
	public static void init(){
		Achivenent();
		Page();
		
	}
	
	public static void Page(){
		AchievementPage.registerAchievementPage(new AchievementPage("Soul of Ashes", iceSkillslist));

	}
	
	public static void Achivenent(){
		iceSkillslist[0] = new Achievement("achivement.icebullets", "icebullets", 0, 0, new ItemStack(ModItems.itemiceicon,1,0), (Achievement)null).initIndependentStat().registerStat();
		iceSkillslist[1] = new Achievement("achivement.icefog", "icefog", 2, 0, new ItemStack(ModItems.itemiceicon,1,1), iceSkillslist[0]).registerStat();
		iceSkillslist[2] = new Achievement("achivement.icethorns", "icethorns", 4, 0, new ItemStack(ModItems.itemiceicon,1,2), iceSkillslist[1]).registerStat();
		iceSkillslist[3] = new Achievement("achivement.iceblock", "iceblock", 6, 0, new ItemStack(ModItems.itemiceicon,1,3), iceSkillslist[2]).registerStat();
		iceSkillslist[4] = new Achievement("achivement.blizzard", "blizzard", 8, 0, new ItemStack(ModItems.itemiceicon,1,4), iceSkillslist[3]).setSpecial().registerStat();
	}
}
