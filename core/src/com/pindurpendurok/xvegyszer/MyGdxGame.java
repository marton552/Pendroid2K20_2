package com.pindurpendurok.xvegyszer;

import com.badlogic.gdx.math.MathUtils;
import com.pindurpendurok.xvegyszer.Screens.Entrance.EntranceScreen;
import com.pindurpendurok.xvegyszer.Screens.House.HouseScreen;
import com.pindurpendurok.xvegyszer.Screens.Labor.LaborScreen;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;
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

    public static String getPassPart(int part) {
        if(part == 1) return PASS.substring(0, 3);
        else return PASS.substring(3, 6);
    }

    public MyGdxGame(boolean debug) {
        super(debug);

    }

    public MyGdxGame() {
        super();
        System.out.println("jelszó: "+getPassPart(1) + " - " +getPassPart(2) + "  =  "+PASS);

    }

    @Override
    public void create() {
        super.create();
        setLoadingStage(new SimpleLoadingStage(this));
        setScreen(new ProfDoorScreen(this));

    }
}
