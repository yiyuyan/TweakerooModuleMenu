package cn.ksmcbrigade.tmm;

import cn.ksmcbrigade.tmm.config.Config;
import cn.ksmcbrigade.tmm.ex.ExGroupUtil;
import cn.ksmcbrigade.tmm.info.CurGroupInfo;
import cn.ksmcbrigade.tmm.gui.group.Group;
import cn.ksmcbrigade.tmm.gui.group.GroupRenderer;
import cn.ksmcbrigade.tmm.info.Info;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import fuzs.forgeconfigapiport.fabric.api.forge.v4.ForgeConfigRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.neoforged.fml.config.ModConfig;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TweakerooModuleMenu implements ClientModInitializer {

    public static Group Disable;
    public static Group Fixes;
    public static Group Generic;
    public static Group Tweaks;
    public static Group Ex;

    public static Info info;

    @Override
    public void onInitializeClient() {
        ForgeConfigRegistry.INSTANCE.register("tmm", ModConfig.Type.CLIENT, Config.CONFIG_SPEC,"tmm-client.toml");

        KeyBindingHelper.registerKeyBinding(Config.UP);
        KeyBindingHelper.registerKeyBinding(Config.DOWN);
        KeyBindingHelper.registerKeyBinding(Config.LEFT);
        KeyBindingHelper.registerKeyBinding(Config.RIGHT);
        KeyBindingHelper.registerKeyBinding(Config.SET);

        new Thread(()->{
            while (!Config.CONFIG_SPEC.isLoaded()){
                Thread.yield();
            }
            while (MinecraftClient.getInstance().textRenderer==null){
                Thread.yield();
            }
            Disable = new Group(new GroupRenderer(0,0,50,12,Config.GROUP1_BACKGROUND_COLOR.get(),Config.GROUP1_CUR_BACKGROUND_COLOR.get(),Config.GROUP1_TEXT_COLOR.get(),Config.GROUP1_TITLE.get()), to(Configs.Disable.OPTIONS));
            Fixes = new Group(new GroupRenderer(0,12,50,12,Config.GROUP2_BACKGROUND_COLOR.get(),Config.GROUP2_CUR_BACKGROUND_COLOR.get(),Config.GROUP2_TEXT_COLOR.get(),Config.GROUP2_TITLE.get()), Configs.Fixes.OPTIONS);
            Generic = new Group(new GroupRenderer(0,24,50,12,Config.GROUP3_BACKGROUND_COLOR.get(),Config.GROUP3_CUR_BACKGROUND_COLOR.get(),Config.GROUP3_TEXT_COLOR.get(),Config.GROUP3_TITLE.get()), Configs.Generic.OPTIONS);
            try {
                Tweaks = new Group(new GroupRenderer(0,36,50,12,Config.GROUP4_BACKGROUND_COLOR.get(),Config.GROUP4_CUR_BACKGROUND_COLOR.get(),Config.GROUP4_TEXT_COLOR.get(),Config.GROUP4_TITLE.get()), get(FeatureToggle.class));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            Ex = new Group(new GroupRenderer(0,48,50,12,Config.GROUP5_BACKGROUND_COLOR.get(),Config.GROUP5_CUR_BACKGROUND_COLOR.get(),Config.GROUP5_TEXT_COLOR.get(),Config.GROUP5_TITLE.get()), ImmutableList.<IConfigBase>builder().build());
            info = new Info(new CurGroupInfo(Disable));
            ExGroupUtil.init();
            System.out.println("TMM mod loaded.");
        }).start();
    }

    public static ImmutableList<IConfigBase> to(ImmutableList<IHotkeyTogglable> target){
        ArrayList<IConfigBase> bases = new ArrayList<>();
        for (IHotkeyTogglable iHotkeyTogglable : target) {
            bases.add(new ConfigBoolean(iHotkeyTogglable.getName(),iHotkeyTogglable.getDefaultBooleanValue(),iHotkeyTogglable.getComment(),iHotkeyTogglable.getPrettyName()));
        }
        return ImmutableList.copyOf(bases);
    }

    public static ImmutableList<IConfigBase> get(Class<?> clazz) throws IllegalAccessException {
        ArrayList<IConfigBase> configs = new ArrayList<>();
        for (Field declaredField : clazz.getDeclaredFields()) {
            if(declaredField.getType().equals(FeatureToggle.class)){
                declaredField.setAccessible(true);
                FeatureToggle featureToggle = (FeatureToggle) declaredField.get(null);
                configs.add(featureToggle);
            }
        }
        return ImmutableList.copyOf(configs);
    }
}
