package cn.ksmcbrigade.tmm.config;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraftforge.common.ForgeConfigSpec;

import java.awt.*;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //Group1
    public static final ForgeConfigSpec.ConfigValue<String> GROUP1_TITLE = BUILDER.comment("For group1").define("group1_title","Disable");
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP1_BACKGROUND_COLOR = BUILDER.define("group1_background_color", Color.BLUE.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP1_CUR_BACKGROUND_COLOR = BUILDER.define("group1_cur_background_color", Color.RED.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP1_TEXT_COLOR = BUILDER.define("group1_text_color", Color.WHITE.getRGB());

    //Group2
    public static final ForgeConfigSpec.ConfigValue<String> GROUP2_TITLE = BUILDER.comment("For group2").define("group2_title","Fixes");
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP2_BACKGROUND_COLOR = BUILDER.define("group2_background_color", Color.BLUE.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP2_CUR_BACKGROUND_COLOR = BUILDER.define("group2_cur_background_color", Color.RED.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP2_TEXT_COLOR = BUILDER.define("group2_text_color", Color.WHITE.getRGB());

    //Group3
    public static final ForgeConfigSpec.ConfigValue<String> GROUP3_TITLE = BUILDER.comment("For group3").define("group3_title","Generic");
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP3_BACKGROUND_COLOR = BUILDER.define("group3_background_color", Color.BLUE.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP3_CUR_BACKGROUND_COLOR = BUILDER.define("group3_cur_background_color", Color.RED.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP3_TEXT_COLOR = BUILDER.define("group3_text_color", Color.WHITE.getRGB());

    //Group4
    public static final ForgeConfigSpec.ConfigValue<String> GROUP4_TITLE = BUILDER.comment("For group4").define("group4_title","Tweaks");
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP4_BACKGROUND_COLOR = BUILDER.define("group4_background_color", Color.BLUE.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP4_CUR_BACKGROUND_COLOR = BUILDER.define("group4_cur_background_color", Color.RED.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP4_TEXT_COLOR = BUILDER.define("group4_text_color", Color.WHITE.getRGB());

    //Group4
    public static final ForgeConfigSpec.ConfigValue<String> GROUP5_TITLE = BUILDER.comment("For group5").define("group5_title","Ex");
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP5_BACKGROUND_COLOR = BUILDER.define("group5_background_color", Color.BLUE.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP5_CUR_BACKGROUND_COLOR = BUILDER.define("group5_cur_background_color", Color.RED.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> GROUP5_TEXT_COLOR = BUILDER.define("group5_text_color", Color.WHITE.getRGB());

    public static final ForgeConfigSpec.ConfigValue<Integer> MODULE_ENABLED_COLOR = BUILDER.comment("For features").define("enabled_text_color",Color.YELLOW.getRGB());
    public static final ForgeConfigSpec.ConfigValue<Integer> MODULE_DISABLED_COLOR = BUILDER.define("disabled_text_color",Color.WHITE.getRGB());

    public static final ForgeConfigSpec CONFIG_SPEC = BUILDER.build();

    public static final KeyBinding UP = new KeyBinding("UpTurnTheFeaturesList", InputUtil.GLFW_KEY_UP,KeyBinding.MISC_CATEGORY);
    public static final KeyBinding DOWN = new KeyBinding("DownTurnTheFeaturesList", InputUtil.GLFW_KEY_DOWN,KeyBinding.MISC_CATEGORY);

    public static final KeyBinding LEFT = new KeyBinding("LeftTurnTheFeaturesList", InputUtil.GLFW_KEY_LEFT,KeyBinding.MISC_CATEGORY);
    public static final KeyBinding RIGHT = new KeyBinding("RightTurnTheFeaturesList", InputUtil.GLFW_KEY_RIGHT,KeyBinding.MISC_CATEGORY);

    public static final KeyBinding SET = new KeyBinding("SetTurnTheFeaturesList", InputUtil.GLFW_KEY_ENTER,KeyBinding.MISC_CATEGORY);
}
