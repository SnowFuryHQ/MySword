package ljr.sword.Loader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ljr.sword.MySword;
import ljr.sword.CreativeTabs.MySwordCreativeTabs;

//@Mod.EventBusSubscriber(Side.CLIENT)
public class CreativeTabsLoader {
    public static CreativeTabs MySwordCreativeTabs;
    
    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	MySword.getLogger().info("Loading_CreativeTabs");
    	MySwordCreativeTabs = new MySwordCreativeTabs();
    	MySword.getLogger().info("Finish_loading_CreativeTabs");
    }
}
