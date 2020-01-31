package com.pindurpendurok.xvegyszer.Screens.Circle;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class CircleStage extends SimpleWorldStage {

    public static AssetList list = new AssetList();
    static {

    }

    public CircleStage(MyGame game) {
        super(new ResponseViewport(1080f), game);
    }
}
