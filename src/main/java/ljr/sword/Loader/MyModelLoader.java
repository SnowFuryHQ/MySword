package ljr.sword.Loader;

import ljr.sword.MySword;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class MyModelLoader {
	
	@SubscribeEvent
	public static void LoadModel(ModelRegistryEvent event){
		MySword.getLogger().info("Prepareing to load model(s)");
		Load(ItemLoader.normalsword);
		MySword.getLogger().info("the model(s) has loaded");
	}
	
	
	
private static void Load(Item i){
	MySword.getLogger().info("Model_Loading:"+i.getRegistryName().toString());
	ModelLoader.setCustomModelResourceLocation(i,0,new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}
	}
