package com.pindurpendurok.xvegyszer.Screens.Circle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class CircleStage extends SimpleWorldStage {

    public static final String LABDA = "draw/null.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(LABDA);
    }

    public float rotation = 0;
    public float rotation2 = 0;
    public float rotation3 = 0;
    public static int melyik = 0;
    CircleActor asd;
    CircleActor asd2;
    CircleActor asd3;

    public CircleStage(MyGame game) {
        super(new ResponseViewport(1080f), game);

        asd = new CircleActor(game,world,this,0);
        addActor(asd);
        asd2 = new CircleActor(game,world,this,1);
        addActor(asd2);
        asd3 = new CircleActor(game,world,this,2);
        addActor(asd3);

        TickTimer x = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                if(melyik == 0){
                    asd.setRotation(asd.getRotation()-4);
                }
                else if(melyik == 1){
                    asd2.setRotation(asd2.getRotation()-3);
                }
                else if(melyik == 2){
                    asd3.setRotation(asd3.getRotation()-2);
                }
                else if(melyik == 3 && (asd3.getRotation() == asd2.getRotation() && asd3.getRotation() == asd.getRotation() || asd3.getRotation()%60==0 && asd2.getRotation()%60==0 &&asd.getRotation()%60==0 )){
                    asd.setRotation(asd.getRotation()-2);
                    asd2.setRotation(asd2.getRotation()-2);
                    asd3.setRotation(asd3.getRotation()-2);
                }
                System.out.println(asd.getRotation()%360);
                System.out.println(asd2.getRotation()%360);
                System.out.println(asd3.getRotation()%360);
            }
        });
        addTimer(x);

        OneSpriteStaticActor lol = new OneSpriteStaticActor(game,LABDA);
        lol.setSize(getWidth(),getHeight());
        lol.setPosition(0,0);
        addActor(lol,1000);
        lol.addListener( new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(melyik == 0){
                    System.out.println(rotation);
                    asd.setRotation((int)Math.floor(asd.getRotation()/40)*40);
                }
                if(melyik == 1){
                    asd2.setRotation((int)Math.floor(asd2.getRotation()/30)*30);
                }
                if(melyik == 2){
                    asd3.setRotation((int)Math.floor(asd3.getRotation()/20)*20);
                }
                if(melyik == 3 ){
                    asd.setRotation((int)Math.floor(asd.getRotation()/30)*30);
                    asd2.setRotation(asd.getRotation());
                    asd3.setRotation(asd.getRotation());
                }
                melyik++;
            }
        });
    }
}
