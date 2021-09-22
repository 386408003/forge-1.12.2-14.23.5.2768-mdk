package top.hkyzf.neutrino.init;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.hkyzf.neutrino.Neutrino;
import top.hkyzf.neutrino.enchantment.EnchantmentFireBurn;

/**
 * @author 朱峰
 * @date 2021-9-22 12:54
 */
@Mod.EventBusSubscriber(modid = Neutrino.MODID)
public class EnchantmentInitializer {

    /**
     * 火焰灼烧，镐子挖矿直接出锭
     */
    public static final Enchantment ENCHANTMENT_FIRE_BURN = new EnchantmentFireBurn();

    /**
     * 注册附魔属性
     * @param event 付魔注册的事件
     */
    @SubscribeEvent
    public static void onEnchantmentRegistration(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(ENCHANTMENT_FIRE_BURN);
    }

    /**
     * 附魔事件生效
     * @param event 方块掉落事件
     */
    @SubscribeEvent
    public void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        // 客户端 并且 User 不为空
        if (!event.getWorld().isRemote && event.getHarvester() != null) {
            ItemStack itemStack = event.getHarvester().getHeldItem(EnumHand.MAIN_HAND);
            // 付魔等级 > 0 并且 不是剪刀
            if (EnchantmentHelper.getEnchantmentLevel(ENCHANTMENT_FIRE_BURN, itemStack) > 0
                    && itemStack.getItem() != Items.SHEARS) {
                for (int i = 0; i < event.getDrops().size(); ++i) {
                    ItemStack stack = event.getDrops().get(i);
                    // 炉子烧掉落物获得锭
                    ItemStack newStack = FurnaceRecipes.instance().getSmeltingResult(stack);
                    if (!newStack.isEmpty()) {
                        event.getDrops().set(i, newStack);
                    } else if (!stack.isEmpty()) {
                        Block block = Block.getBlockFromItem(stack.getItem());
                        boolean b = (block == Blocks.AIR);
                        if (!b && (block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.DOWN)
                                || block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.EAST)
                                || block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.NORTH)
                                || block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.SOUTH)
                                || block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.UP)
                                || block.isFlammable(event.getWorld(), event.getPos(), EnumFacing.WEST))) {
                            event.getDrops().remove(i);
                            i--;
                        }
                    }
                }
            }
        }
    }
}
