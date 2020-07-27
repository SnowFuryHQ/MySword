package ljr.sword.Proxy;


import ljr.sword.MySword;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    	MySword.getLogger().info("FMLPreInitialization at Common event");

    }

    public void init(FMLInitializationEvent event)
    {
    	MySword.getLogger().info("FMLInitialization at Common event");
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    	MySword.getLogger().info("FMLPostInitialization at Common event");
    }
}
