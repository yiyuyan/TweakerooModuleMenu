package cn.ksmcbrigade.tmm.gui.group;

import cn.ksmcbrigade.tmm.gui.featureList.FeatureList;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.IConfigBase;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Group {

    public final GroupRenderer renderer;
    public ImmutableList<IConfigBase> features;
    public FeatureList featureList;

    public boolean cur = false;

    public Group(GroupRenderer renderer, ImmutableList<IConfigBase> features){
        this.renderer = renderer;
        this.features = features;
        this.featureList = new FeatureList(this);
    }

    public void render(DrawContext context, TextRenderer textRenderer){
        this.renderer.render(context, textRenderer);
    }

    public void cur(boolean cur){
        this.cur = cur;
        this.renderer.cur = this.cur;
    }
}
