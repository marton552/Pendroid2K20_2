package com.pindurpendurok.xvegyszer.Screens.Copyright;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class CopyrightScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        AssetList.collectAssetDescriptor(CopyrightStage.class, list);
    }

    public CopyrightScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        CopyrightStage stage = new CopyrightStage(game);
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
