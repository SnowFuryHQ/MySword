package ljr.sword.CreativeTabs;


import ljr.sword.Loader.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MySwordCreativeTabs extends CreativeTabs{

	public MySwordCreativeTabs() {
		super("MySword");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemLoader.normalsword);
	}
	
}
