package com.pindurpendurok.xvegyszer.Screens.ProfDoor;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ProfDoorScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        AssetList.collectAssetDescriptor(ProfDoorStage.class, list);
    }

    public ProfDoorScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        ProfDoorStage stage = new ProfDoorStage(game);
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
