package com.pindurpendurok.xvegyszer;

import com.badlogic.gdx.math.MathUtils;
import com.pindurpendurok.xvegyszer.Screens.Draw.DrawScreen;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

    public static String PASS;
    static {
        for (int i = 0; i < 6; i++) PASS += MathUtils.random(0, 9);
    }
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
