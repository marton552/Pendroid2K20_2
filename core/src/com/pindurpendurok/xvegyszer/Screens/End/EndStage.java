package com.pindurpendurok.xvegyszer.Screens.End;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class EndStage extends MyStage {
    public EndStage(MyGame game) {
        super(new ResponseViewport(720f), game);


        //Írja ki hogy: "Mivel megszólalt a risztó ezért itt van 10 coin" (amit igazából nem kap meg)
    }
}
