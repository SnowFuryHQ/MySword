package ljr.sword;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ljr.sword.Proxy.CommonProxy;

//主类标记符*1
@Mod(modid = MySword.MODID, name = MySword.NAME, version = MySword.VERSION)
public class MySword {
		//各种信息
		public static final String MODID = "mysword";
	    public static final String NAME = "a simple sword";
	    public static final String VERSION = "1.1";
	    
	    //初始化logger							    		方框中的名字
	    public static Logger logger = LogManager.getLogger("MySword");
	    
	    @Mod.Instance //主类标记符*2
	    public static MySword instance;
	    
	    //代理		客户端用client									服务端用common
		@SidedProxy(clientSide = "ljr.sword.Proxy.ClientProxy", serverSide = "ljr.sword.Proxy.CommonProxy")
		public static CommonProxy proxy;


	    //事件
	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {

	    	getLogger().info("MySword Version:" + VERSION);
	    	getLogger().info("FMLPreInitialization at Root event");
	    	proxy.preInit(event);
	    }

	    @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
	    	getLogger().info("FMLInitialization at Root event");
	        proxy.init(event);
	    }
	    @EventHandler
	    public void postInit(FMLPostInitializationEvent event)
	    {
	    	getLogger().info("FMLPostInitialization at Root event");
	       proxy.postInit(event);
	    }

		public static Logger getLogger() {
			return logger;
		}
}
