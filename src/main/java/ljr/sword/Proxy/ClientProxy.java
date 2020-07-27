package ljr.sword.Proxy;

import ljr.sword.MySword;
import ljr.sword.Loader.CreativeTabsLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    	new CreativeTabsLoader(event);
    	MySword.getLogger().info("FMLPreInitialization at Client event");
       	super.preInit(event);

    }

    public void init(FMLInitializationEvent event)
    {

    	MySword.getLogger().info("FMLInitialization at Client event");
    	super.init(event);
    	
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    	
    	MySword.getLogger().info("FMLPostInitialization at Client event");
    	super.postInit(event);
    	
    }
}
