package com.pindurpendurok.xvegyszer.Screens.Game;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(GameStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
    }

    public GameScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        GameStage stage = new GameStage(game);
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
