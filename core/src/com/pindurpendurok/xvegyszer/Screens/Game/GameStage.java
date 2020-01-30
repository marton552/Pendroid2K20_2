package com.pindurpendurok.xvegyszer.Screens.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class GameStage extends SimpleWorldStage {
    public static AssetList list = new AssetList();
    public GameStage(MyGame game) {
        super(new ResponseViewport(720), game);
    }
}
