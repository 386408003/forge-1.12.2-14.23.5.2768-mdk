package top.hkyzf.neutrino;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * Mod 主类的标记。其中只有 modid 是必填项。
 *
 * modid 指的就是该Mod的唯一标识符，不允许使用大写字母，最大长度 64，不能为空。
 * 推荐在 modid 中只使用小写字母、数字、连字符和下划线，换言之即只使用满足正则表达式
 * [a-z0-9\-_]{1,64} 的 modid。
 * 发现不符合要求的 modid 时，会抛出 IllegalArgumentException 阻止游戏启动。
 *
 * name 指的是该Mod的名称，没有限制。若不填则直接使用 modid 充当 name，但仍然会产生警告。
 * 一般来说，name 都满足正则表达式 [\w ]+。但也有少许例外。
 *
 * version 指的是该Mod的版本号，在Mod间的依赖关系时可能会用作识别，没有限制，若不填则使用 1.0，并产生警告。
 * 对于 version 来说，***强烈***推荐只用数字和点，比如只有 MAJOR.MINOR.PATCH 的 SemVer。
 *
 * useMetadata = true 让 Forge 以 mcmod.info 里的信息为准。它的格式在“Mod 的元数据”一节会有详细说明。
 *
 * [01:02:22] [main/ERROR] [FML]: FML appears to be missing any signature data. This is not a good thing
 * 在开发环境中出现这条消息属于正常现象，因为 Forge 本身在非开发环境中是有指纹校验的
 * 但是在开发环境中因为需要反混淆等各种操作，指纹不可能与非开发环境中的一致，所以删除了校验信息
 * 然后就会出现这条消息。
 *
 * @author zhufeng
 * @version 1.0
 * @date 2021-9-18 23:35
 */
@Mod(modid = Neutrino.MODID, name = Neutrino.NAME, version = Neutrino.VERSION, useMetadata = true)
public class Neutrino {
    public static final String MODID = "neutrino";
    public static final String NAME = "Neutrino";
    public static final String VERSION = "1.0";

    /**
     * 日志类
     */
    private static Logger logger;
    /**
     * Mod 主类的实例。
     */
    @Mod.Instance(Neutrino.MODID)
    public static Neutrino instance;

    /**
     * 获取 Mod 日志记录器
     * @param event FML 初始化前的事件
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    /**
     * 一个入口方法。
     * Mod的加载大致分为 6 个阶段，每个阶段均有一个事件代表，而 @EventHandler 注解则标记该方法将订阅此事件。
     * Mod 加载时的六个阶段对应的事件，以时间顺序排列：
     *     FMLConstructionEvent
     *     FMLPreInitializationEvent
     *     FMLInitializationEvent
     *     FMLInterModComms.IMCEvent
     *     FMLPostInitializationEvent
     *     FMLLoadCompleteEvent
     * 其中，PreInit.、Init.、IMCEvent 和 PostInit. 是最常用的四个事件。
     * 剩下两个事件只有在相当少见的情况下才会用到，大可暂时无视。
     *
     * @param event FML 初始化的事件
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("ZhuFeng's First Mod Loaded!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
