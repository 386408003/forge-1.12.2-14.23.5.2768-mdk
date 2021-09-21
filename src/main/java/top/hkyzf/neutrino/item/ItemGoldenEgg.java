package top.hkyzf.neutrino.item;

import net.minecraft.item.Item;
import top.hkyzf.neutrino.Neutrino;

/**
 * 金蛋
 * /give @a neutrino:golden_egg
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-20 1:11
 */
public class ItemGoldenEgg extends Item {
    public ItemGoldenEgg() {
        super();
        this.setRegistryName("golden_egg")
                .setTranslationKey(Neutrino.MODID + ".golden_egg")
                .setCreativeTab(Neutrino.NEUTRINO_CREATIVE_TAB);
    }
}