package cn.ksmcbrigade.tmm.gui.featureList;

import cn.ksmcbrigade.tmm.config.Config;
import cn.ksmcbrigade.tmm.gui.group.Group;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class FeatureList {

    public final Group group;
    public FeatureListRenderer renderer;

    public FeatureList(Group group){
        this.group = group;
        this.renderer = new FeatureListRenderer(group.renderer.x+group.renderer.width,group.renderer.y,group.renderer.height,group.renderer.backgroundColor,group.renderer.curBackgroundColor, Config.MODULE_DISABLED_COLOR.get(),Config.MODULE_ENABLED_COLOR.get(),group);
    }

    public void render(DrawContext context, TextRenderer textRenderer){
        this.renderer.render(context, textRenderer);
    }
}
