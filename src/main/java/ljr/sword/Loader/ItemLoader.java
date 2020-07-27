package ljr.sword.Loader;

import ljr.sword.MySword;
import ljr.sword.Swords.NormalSword;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber
public class ItemLoader {

public static NormalSword normalsword;
	 @SubscribeEvent
	    public static void registerItem(RegistryEvent.Register<Item> event){
	    	MySword.getLogger().info("Registering things");
	    	registering(event);
	    	MySword.getLogger().info("registered");
	    }

private static void registering(RegistryEvent.Register<Item> event) {
			normalsword= new NormalSword();
	    	event.getRegistry().register(normalsword);
}
}
