package com.pindurpendurok.xvegyszer.Screens.Labor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.xvegyszer.Screens.Actors.RandomGomb;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
import com.pindurpendurok.xvegyszer.Screens.House.HouseStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class LaborStage extends SimpleWorldStage {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"Textures/Labor1.png","Textures/Labor2.png","test/red_move.png"};

    static {
        for (int i = 0; i < texturak.length; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public LaborStage(final MyGame game){
        super(new ResponseViewport(720f),game);

        final OneSpriteStaticActor background = new OneSpriteStaticActor(game,texturak[0]);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        OneSpriteStaticActor helye = new OneSpriteStaticActor(game,texturak[2]);

        helye.setSize(getViewport().getWorldWidth()/4,getViewport().getWorldHeight()/8);
        float x = getViewport().getWorldWidth()/2-helye.getWidth()/2-getViewport().getWorldWidth()/11;
        float y = getViewport().getWorldHeight()/2-helye.getHeight()/2-getViewport().getWorldHeight()/10;

        helye.setPosition(x,y);
        addActor(helye);
        helye.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                background.remove();
                OneSpriteStaticActor background = new OneSpriteStaticActor(game,texturak[1]);
                background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
                addActor(background);
                addTimer(new TickTimer(2, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        System.out.println("szia, végeztél");
                    }
                }));
            }
        });
        helye.setAlpha(0);
    }
}
