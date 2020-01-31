package com.pindurpendurok.xvegyszer.Screens.Entrance;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class EntranceScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(EntranceStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);

    }

    public EntranceScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        EntranceStage stage = new EntranceStage(game);
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
