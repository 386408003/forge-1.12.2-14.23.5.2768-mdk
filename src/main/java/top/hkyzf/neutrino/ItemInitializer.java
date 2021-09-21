package top.hkyzf.neutrino;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.hkyzf.neutrino.item.ItemGoldenEgg;
import top.hkyzf.neutrino.item.ItemObsidianIngot;

/**
 * 物品注册器
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-20 0:47
 */
@Mod.EventBusSubscriber(modid = Neutrino.MODID)
public final class ItemInitializer {

    public static Item goldenEgg = new ItemGoldenEgg();
    public static Item obsidianIngot = new ItemObsidianIngot();

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        // 每一个物品都对应唯一一个注册名，用于和其他物品区分开来。这个注册名不能含有大写字母。
        // 此方法返回被注册的 Item 对象。
        event.getRegistry().registerAll(goldenEgg, obsidianIngot);
    }
}
