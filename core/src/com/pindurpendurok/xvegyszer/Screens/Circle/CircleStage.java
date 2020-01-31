package com.pindurpendurok.xvegyszer.Screens.Circle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.MyGdxGame;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
import com.pindurpendurok.xvegyszer.Screens.Draw.DrawScreen;
import com.pindurpendurok.xvegyszer.Screens.End.EndScreen;
import com.pindurpendurok.xvegyszer.Screens.House.HouseScreen;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

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
    public static final String BACK = "circle_lock/Iron_Door_Covering.png";
    public static final String AJTO1 = "circle_lock/Iron_Door_TwoColor.png";
    public static final String AJTO2 = "circle_lock/Iron_Door_Red.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(LABDA);
        list.addTexture(BACK);
        list.addTexture(AJTO1);
        list.addTexture(AJTO2);
    }

    public float rotation = 0;
    public float rotation2 = 0;
    public float rotation3 = 0;
    public static int melyik = 0;
    CircleActor asd;
    CircleActor asd2;
    CircleActor asd3;
    public boolean first = true;

    public CircleStage(MyGame game) {
        super(new ResponseViewport(1080f), game);

        final SimpleLabel text = new SimpleLabel(game,"");
        text.setFontScale(3f);
        text.setPosition(getWidth()*0.5f,getHeight()*0.45f);
        addActor(text,-1);
        text.setAlignment(Align.center);
        asd = new CircleActor(game,world,this,0);
        addActor(asd);
        asd2 = new CircleActor(game,world,this,1);
        addActor(asd2);
        asd3 = new CircleActor(game,world,this,2);
        addActor(asd3);

        final OneSpriteStaticActor ajto1 = new OneSpriteStaticActor(game,AJTO1);
        ajto1.setSize(getWidth(),getHeight());
        ajto1.setPosition(0,0);
        addActor(ajto1,0);

        final OneSpriteStaticActor ajto2 = new OneSpriteStaticActor(game,AJTO2);
        ajto2.setSize(getWidth(),getHeight());
        ajto2.setPosition(0,0);
        addActor(ajto2,0);
        ajto2.setVisible(false);

        OneSpriteStaticActor back = new OneSpriteStaticActor(game,BACK);
        back.setSize(getWidth(),getHeight());
        back.setPosition(0,0);
        addActor(back,0);

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
                else if(melyik == 3 && Math.abs(asd.getRotation()%360 - asd2.getRotation()%360) < 20 && Math.abs(asd3.getRotation()%360 - asd2.getRotation()%360) < 20){
                    if(first){
                    asd.setRotation((int)Math.floor(asd.getRotation()/30)*30);
                    asd2.setRotation(asd.getRotation());
                    asd3.setRotation(asd.getRotation());
                    first = false;}
                    asd.setRotation(asd.getRotation()-2);
                    asd2.setRotation(asd.getRotation());
                    asd3.setRotation(asd.getRotation());
                }
                else {
                    getGame().setScreenWithPreloadAssets(EndScreen.class, new SimpleLoadingStage(getGame()));
                }
                //System.out.println(asd.getRotation()%360);
                //System.out.println(asd2.getRotation()%360);
                //System.out.println(asd3.getRotation()%360);
                System.out.println(melyik);
                if(melyik > 3) {
                    System.out.println(asd.getRotation()%360);
                    if ((asd.getRotation()%360 < -265 && asd.getRotation()%360 > -275) || (asd.getRotation()%360 < -85 && asd.getRotation()%360 > -95)) {
                        System.out.println(melyik+" és "+asd.getRotation());
                        ajto1.setVisible(false);
                        ajto2.setVisible(true);
                        TickTimer w = new TickTimer(0.7f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                asd.setVisible(false);
                                asd2.setVisible(false);
                                asd3.setVisible(false);
                                text.setText("Kód első része:\r\n"+MyGdxGame.getPassPart(1));
                                TickTimer w = new TickTimer(0, true, new TickTimerListener() {
                                    @Override
                                    public void onTick(Timer sender, float correction) {
                                        super.onTick(sender, correction);
                                        ajto2.setX(ajto2.getX() - 1);
                                        if (ajto2.getX() + ajto2.getWidth() * 1.8f < 0) {

                                            TickTimer w = new TickTimer(3, false, new TickTimerListener() {
                                                @Override
                                                public void onStop(Timer sender) {
                                                    super.onStop(sender);
                                                    Tolvaj.pos = 2;
                                                    getGame().setScreenWithPreloadAssets(HouseScreen.class, new SimpleLoadingStage(getGame()));

                                                }
                                            });
                                            addTimer(w);
                                        }
                                    }
                                });
                                addTimer(w);
                            }
                        });
                        addTimer(w);
                    } else {
                        System.out.println("vesztés");
                        getGame().setScreenWithPreloadAssets(EndScreen.class, new SimpleLoadingStage(getGame()));
                    }
                }            }
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
                    asd.setRotation((int)Math.floor(asd.getRotation()/30)*30);
                }
                if(melyik == 1){
                    asd2.setRotation((int)Math.floor(asd2.getRotation()/30)*30);
                }
                if(melyik == 2){
                    asd3.setRotation((int)Math.floor(asd3.getRotation()/30)*30);
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
