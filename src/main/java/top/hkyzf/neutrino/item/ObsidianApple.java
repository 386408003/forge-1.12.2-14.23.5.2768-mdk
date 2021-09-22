package top.hkyzf.neutrino.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import top.hkyzf.neutrino.Neutrino;
import top.hkyzf.neutrino.creativetab.NeutrinoCreativeTabs;

/**
 * @author 朱峰
 * @date 2021-9-22 9:57
 */
public class ObsidianApple extends ItemFood {

    public ObsidianApple() {
        // @param hungerHeal 设置了回复的饥饿度
        // @param saturation 方法设置了饱食度
        // @param isWolfFood 是不是狼的食物
        super(20, 10, true);
        this.setPotionEffect(new PotionEffect(MobEffects.POISON), 0.8F)
                .setRegistryName("obsidian_apple")
                .setTranslationKey(Neutrino.MODID + ".obsidian_apple")
                .setCreativeTab(NeutrinoCreativeTabs.NEUTRINO_CREATIVE_TAB);

        // ItemFood 的默认实现中，只有在玩家饥饿条不满的时候才能吃东西。
        // 用这个可以解除此限制。
        // this.setAlwaysEdible();
    }

    /**
     * 会在玩家食用之后被调用，原版金苹果在这里追加多种药水效果
     * @param stack 当前物品
     * @param world 当前世界，客户端 或 服务端
     * @param player 当前玩家
     */
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

    }
}
