package com.pindurpendurok.xvegyszer.Screens;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class StoryStage extends MyStage {
    public StoryStage(MyGame game) {
        super(new ResponseViewport(720), game);
    }
}
