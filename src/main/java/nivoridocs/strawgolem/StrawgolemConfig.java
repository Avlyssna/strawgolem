package nivoridocs.strawgolem;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.PostConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Strawgolem.MODID)
@Config.LangKey("strawgolem.config.title")
@EventBusSubscriber
public class StrawgolemConfig {
	
	@Config.Comment("Allow the straw golems to replant a crop when they haverst it.")
	public static boolean replantEnabled = false;
	
	@Config.Comment("Set the lifespan, in tick, of new created straw golems.")
	@Config.RangeInt(min = -1, max = Integer.MAX_VALUE)
	public static int lifespan = 168000;
	
	@Config.Comment("Make the straw golems run for a shelter while rining.")
	public static boolean escapeRainEnbled = true;
	
	public static boolean isReplantEnabled() {
		return replantEnabled;
	}
	
	public static int getLifespan() {
		return lifespan;
	}
	
	public static boolean isEscapeRainEnbled() {
		return escapeRainEnbled;
	}
	
	@SubscribeEvent
	public static void onConfigChange(PostConfigChangedEvent event) {
		if (event.getModID().equals(Strawgolem.MODID))
			ConfigManager.sync(Strawgolem.MODID, Config.Type.INSTANCE);
	}
	
	private StrawgolemConfig() {}

}
