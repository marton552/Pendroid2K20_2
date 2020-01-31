package com.pindurpendurok.xvegyszer;

import com.pindurpendurok.xvegyszer.Screens.Draw.DrawScreen;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {
    public MyGdxGame(boolean debug) {
        super(debug);
    }

    public MyGdxGame() {
        super();
        debug = true;
    }

    @Override
    public void create() {
        super.create();
        setLoadingStage(new SimpleLoadingStage(this));
        setScreen(new DrawScreen(this));

    }
}
