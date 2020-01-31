package com.pindurpendurok.xvegyszer.Screens.About;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class AboutStage extends MyStage {
    public static AssetList list = new AssetList();
    static {

    }


    public AboutStage(MyGame game) {
        super(new ResponseViewport(720), game);
    }
}
