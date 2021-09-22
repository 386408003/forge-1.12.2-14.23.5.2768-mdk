package top.hkyzf.neutrino;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Objects;

/**
 * 模型注册器
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-20 1:23
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Neutrino.MODID)
public final class ModelMapper {
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        // 注册金蛋模型
        ModelLoader.setCustomModelResourceLocation(ItemInitializer.GOLDEN_EGG, 0,
                new ModelResourceLocation(Objects.requireNonNull(ItemInitializer.GOLDEN_EGG.getRegistryName()), "inventory"));
        // 注册黑曜石锭模型
        ModelLoader.setCustomModelResourceLocation(ItemInitializer.OBSIDIAN_INGOT, 0,
                new ModelResourceLocation(Objects.requireNonNull(ItemInitializer.OBSIDIAN_INGOT.getRegistryName()), "inventory"));
    }
}
