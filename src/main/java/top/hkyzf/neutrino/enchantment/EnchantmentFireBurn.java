package top.hkyzf.neutrino.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import top.hkyzf.neutrino.Neutrino;

/**
 * 付魔
 * @author 朱峰
 * @date 2021-9-22 9:39
 */
public class EnchantmentFireBurn extends Enchantment {

    /**
     * 自定义付魔
     */
    public EnchantmentFireBurn() {
        // rarity 代表了这个附魔的稀有程度，可以是 COMMON、UNCOMMON、RARE 或 VERY_RARE。
        // type 代表了这个附魔可以加在什么工具/武器/装备上。
        // slots 代表了“这个附魔加在什么格子里装的工具/武器/装备上才有效果”，例如荆棘只在盔甲四件套上有效。
        // slots 会影响 getEnchantedItem（func_92099_a）的返回值，这个方法用于获取某个实体上有指定附魔的物品。
        // setName（func_77322_b）用于组成附魔名称的本地化键，和注册名无关。本地化相关的内容请参考第 13 章。
        super(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        this.setRegistryName("fire_burn").setName(Neutrino.MODID + ".fire_burn");
    }

    /**
     * 可以获取到此附魔的最低等级
     * @param enchantmentLevel 附魔等级
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    /**
     * 可以获取到此附魔的最低等级
     * @param enchantmentLevel 附魔等级
     */
    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * func_77319_d，决定了附魔的最低可能等级
     * @return int 类型的数值
     */
    @Override
    public int getMinLevel() {
        return 1;
    }

    /**
     * func_77325_b，决定了附魔的最高可能等级
     * @return int 类型的数值
     */
    @Override
    public int getMaxLevel() {
        return 1;
    }

    /**
     * 不能与时运和精准采集共存
     * @param ench 当前附魔
     */
    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.FORTUNE && ench != Enchantments.SILK_TOUCH;
    }

}
