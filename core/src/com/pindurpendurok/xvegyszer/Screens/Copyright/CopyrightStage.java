package com.pindurpendurok.xvegyszer.Screens.Copyright;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class CopyrightStage extends MyStage {

    public static final String PENDROID = "pendroid.jpg";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(PENDROID);
    }

    public CopyrightStage(final MyGame game) {
        super(new ResponseViewport(720), game);

        OneSpriteStaticActor pen = new OneSpriteStaticActor(game, PENDROID);
        pen.setPosition(getViewport().getWorldWidth() / 2 - pen.getWidth() / 2, getViewport().getWorldHeight() / 2 - pen.getHeight() / 2);
        addActor(pen);


        addTimer(new TickTimer(2, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                game.setScreen(new MenuScreen(game));
            }
        }));

    }
}
