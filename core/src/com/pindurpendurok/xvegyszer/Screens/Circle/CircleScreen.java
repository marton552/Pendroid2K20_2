package com.pindurpendurok.xvegyszer.Screens.Circle;

import com.pindurpendurok.xvegyszer.Screens.Draw.DrawStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CircleScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleStage.class, list);
    }

    public CircleScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        CircleStage stage = new CircleStage(game);
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
