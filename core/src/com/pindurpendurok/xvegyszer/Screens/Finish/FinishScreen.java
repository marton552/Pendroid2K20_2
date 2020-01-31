package com.pindurpendurok.xvegyszer.Screens.Finish;

import com.pindurpendurok.xvegyszer.Elements.ElementAssets;

import java.lang.reflect.Array;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class FinishScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        AssetList.collectAssetDescriptor(FinishStage.class, list);
    }

    public FinishScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        FinishStage stage = new FinishStage(game);
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
