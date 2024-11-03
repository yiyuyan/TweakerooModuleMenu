package cn.ksmcbrigade.tmm.gui.group;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class GroupRenderer {

    public final int x;
    public final int y;
    public final int width;
    public final int height;
    public int backgroundColor;
    public int curBackgroundColor;
    public int textColor;
    public final String title;

    public boolean cur = false;

    public GroupRenderer(int x, int y, int width, int height, int backgroundColor, int curBackgroundColor, int textColor, String title){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.curBackgroundColor = curBackgroundColor;
        this.textColor = textColor;
        this.title = title;
    }

    public void render(DrawContext context, TextRenderer renderer){
        context.fillGradient(x,y,x+width,y+height,cur?curBackgroundColor:backgroundColor,cur?curBackgroundColor:backgroundColor);
        context.drawCenteredTextWithShadow(renderer,title,(x+width)/2,y+2, textColor);
    }
}
