package com.pindurpendurok.xvegyszer;

import com.pindurpendurok.xvegyszer.Screens.Copyright.CopyrightScreen;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;
import com.pindurpendurok.xvegyszer.Screens.ProfDoor.ProfDoorScreen;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {
    public MyGdxGame(boolean debug) {
        super(debug);
    }

    public MyGdxGame() {
        super();
    }

    @Override
    public void create() {
        super.create();
        setLoadingStage(new SimpleLoadingStage(this));
        setScreen(new ProfDoorScreen(this));

    }
}
