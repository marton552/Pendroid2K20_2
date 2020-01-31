package com.pindurpendurok.xvegyszer.Screens.ProfDoor;

import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class ProfDoorStage extends MyStage {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CodeConsole.class, list);
    }


    public ProfDoorStage(MyGame game) {
        super(new ResponseViewport(720), game);

        addActor(new CodeConsole(game));
    }
}
