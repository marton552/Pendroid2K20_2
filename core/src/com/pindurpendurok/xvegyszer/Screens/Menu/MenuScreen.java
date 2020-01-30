package com.pindurpendurok.xvegyszer.Screens.Menu;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class MenuScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(MenuStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
    }

    public MenuScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        MenuStage stage = new MenuStage(game);
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
