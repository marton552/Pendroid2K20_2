package com.pindurpendurok.xvegyszer.Screens.Finish;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class FinishStage extends MyStage {

    public static final String BG = "";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BG);
    }

    public FinishStage(MyGame game) {
        super(new ResponseViewport(720), game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        //szia koma buzi vagy?


    }
}
