package cn.ksmcbrigade.tmm.info;

import cn.ksmcbrigade.tmm.gui.group.Group;

import java.util.Objects;

import static cn.ksmcbrigade.tmm.TweakerooModuleMenu.*;

public class CurGroupInfo {

    public Group cur;

    public CurGroupInfo(Group cur){
        this.cur = cur;
        cur(cur);
    }

    public void cur(Group group){
        group.cur(true);
        if(!Objects.equals(Disable.renderer.title, group.renderer.title)){
            Disable.cur(false);
        }
        if(!Objects.equals(Fixes.renderer.title, group.renderer.title)){
            Fixes.cur(false);
        }
        if(!Objects.equals(Generic.renderer.title, group.renderer.title)){
            Generic.cur(false);
        }
        if(!Objects.equals(Tweaks.renderer.title, group.renderer.title)){
            Tweaks.cur(false);
        }
        if(!Objects.equals(Ex.renderer.title, group.renderer.title)){
            Ex.cur(false);
        }

        this.cur = group;
    }

    public void next(){
        if(cur.equals(Disable)){
            cur(Fixes);
            return;
        }
        if(cur.equals(Fixes)){
            cur(Generic);
            return;
        }
        if(cur.equals(Generic)){
            cur(Tweaks);
            return;
        }
        if(cur.equals(Tweaks)){
            cur(Ex);
            return;
        }
        if(cur.equals(Ex)){
            cur(Disable);
            return;
        }
        cur(cur);
    }

    public void last(){
        if(cur.equals(Disable)){
            cur(Ex);
            return;
        }
        if(cur.equals(Fixes)){
            cur(Disable);
            return;
        }
        if(cur.equals(Generic)){
            cur(Fixes);
            return;
        }
        if(cur.equals(Tweaks)){
            cur(Generic);
            return;
        }
        if(cur.equals(Ex)){
            cur(Tweaks);
            return;
        }
        cur(cur);
    }
}
