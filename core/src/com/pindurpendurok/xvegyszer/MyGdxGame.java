package com.pindurpendurok.xvegyszer;

import com.badlogic.gdx.math.MathUtils;
import com.pindurpendurok.xvegyszer.Screens.Entrance.EntranceScreen;
import com.pindurpendurok.xvegyszer.Screens.ProfDoor.ProfDoorScreen;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

    public static String PASS = newPass();
    public static String newPass(){
        String s = "";
        for(int i = 0; i < 6; i++) {
            s += MathUtils.random(0, 9);
        }

        return s;
    }

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
