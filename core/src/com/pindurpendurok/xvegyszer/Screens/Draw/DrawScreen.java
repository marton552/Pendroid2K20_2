package com.pindurpendurok.xvegyszer.Screens.Draw;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class DrawScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(DrawStage.class, list);
    }

    public DrawScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        DrawStage stage = new DrawStage(game);
        addStage(stage, 1, true);
    }

    @Override
    public AssetList getAssetList() {
        return list;
    }

    @Override
    public void init() {

    }
}
