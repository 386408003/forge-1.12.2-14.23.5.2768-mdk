package top.hkyzf.neutrino.item;

import net.minecraft.item.Item;
import top.hkyzf.neutrino.Neutrino;

/**
 * 黑曜石锭
 * /give @a neutrino:obsidian_ingot
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-20 0:35
 */
public class ItemObsidianIngot extends Item {
    public ItemObsidianIngot() {
        super();
        this.setRegistryName("obsidian_ingot")
                .setTranslationKey(Neutrino.MODID + ".obsidian_ingot")
                .setCreativeTab(Neutrino.NEUTRINO_CREATIVE_TAB);
    }
}
