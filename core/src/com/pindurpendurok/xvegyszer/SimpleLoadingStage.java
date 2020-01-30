package com.pindurpendurok.xvegyszer;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class SimpleLoadingStage extends LoadingStage {

    public static AssetList list = new AssetList();

    public SimpleLoadingStage(MyGame game) {
        super(new ResponseViewport(720), game);
    }

    @Override
    public AssetList getAssetList() {
        return list;
    }
}
