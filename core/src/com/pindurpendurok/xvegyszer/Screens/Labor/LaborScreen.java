package com.pindurpendurok.xvegyszer.Screens.Labor;

import com.pindurpendurok.xvegyszer.Screens.House.HouseStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class LaborScreen extends MyScreen {
    public LaborScreen(MyGame game){
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new LaborStage(game), 1, true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(LaborStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {
    }
}
