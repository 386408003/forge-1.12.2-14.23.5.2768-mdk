package top.hkyzf.neutrino.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import top.hkyzf.neutrino.ItemInitializer;

/**
 * 新的创造模式物品栏
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-20 1:42
 */
public class NeutrinoCreativeTabs extends CreativeTabs {

    public NeutrinoCreativeTabs() {
        super("neutrino");
        // src/main/resources/assets/minecraft/textures/gui/container/creative_inventory/tab_fmltutor.png
        this.setBackgroundImageName("neutrino.png");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemInitializer.goldenEgg);
    }

    /**
     * 创造模式物品栏上是否显示搜索框
     * @return true 显示，false 不显示
     */
    @Override
    public boolean hasSearchBar() {
        return true;
    }

}
