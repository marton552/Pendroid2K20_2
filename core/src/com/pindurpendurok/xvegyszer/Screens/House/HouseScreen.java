package com.pindurpendurok.xvegyszer.Screens.House;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class HouseScreen extends MyScreen {
    public HouseScreen(MyGame game){
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new HouseStage(game), 1, true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(HouseStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {

    }
}
