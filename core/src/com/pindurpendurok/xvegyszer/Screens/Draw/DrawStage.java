package com.pindurpendurok.xvegyszer.Screens.Draw;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.MyGdxGame;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
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

public class DrawStage extends SimpleWorldStage {

    public static boolean waitfor = true;
    public String eredmeny = "";
    public boolean vege =true;
    public static final String BORDER = "draw/border.png";
    public static final String BACK1 = "draw/Iron_Door_Covering.png";
    public static final String AJTO = "draw/Room1_Door.png";
    public String[] peldak = {"21","10","03","32","210","103","032","321","2103","1032","0321","3210"};
    public final static String[] KEPEK = {"draw/Arrow_Uptoright.png","draw/Arrow_NotCircle.png","draw/Arrow_Nemkelnev.png"};
    public static AssetList list = new AssetList();
    static {
        for (int i = 0; i < KEPEK.length; i++) {
            list.addTexture(KEPEK[0]);
            list.addTexture(BORDER);
            list.addTexture(BACK1);
            list.addTexture(AJTO);
        }
    }
    public boolean end = false;
    public String elozo = "";
    OneSpriteStaticActor kep;
    OneSpriteStaticActor border;
    public int toss_a_coint_to_your_witcher = 0;
    public int plus = 0;
    float szeles = 0;
    public boolean nyert = false;
    OneSpriteStaticActor ajto1;
    SimpleLabel text1;

    public DrawStage(MyGame game) {
        super(new ResponseViewport(1080f), game);

        final Huzas asd = new Huzas(game,this);
        SimpleLabel text = new SimpleLabel(game,"5/"+asd.mennyi);
        text.setFontScale(5f);
        text.setPosition(getWidth()/2,getHeight()*0.9f);
        addActor(text);

        text1 = new SimpleLabel(game,"");
        text1.setFontScale(2.5f);
        text1.setPosition(getWidth()*0.5f,getHeight()*0.45f);
        addActor(text1,-1);
        text1.setAlignment(Align.center);

        ajto1 = new OneSpriteStaticActor(game,AJTO);
        ajto1.setSize(getWidth(),getHeight());
        ajto1.setPosition(0,0);
        addActor(ajto1,0);

        OneSpriteStaticActor back = new OneSpriteStaticActor(game,BACK1);
        back.setSize(getWidth(),getHeight());
        back.setPosition(0,0);
        addActor(back,0);

        System.out.println(peldak[toss_a_coint_to_your_witcher]);

        lerak();

        TickTimer h = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                if(vege){
                    plus++;
                    kep.setSizeByOrigin(kep.getWidth()+szeles,kep.getWidth()+szeles);
                    if(plus > 200){
                        vege = false;
                    }
                if (asd.check == 0){ //System.out.println("le");
                    //asd.del();
                    if(!eredmeny.contains("0")) eredmeny+="0";
                }
                else if (asd.check == 1){ //System.out.println("jobb");
                    //asd.del();
                    if(!eredmeny.contains("1")) eredmeny+="1";
                }
                else if (asd.check == 2){ //System.out.println("fel");
                    //asd.del();
                    if(!eredmeny.contains("2")) eredmeny+="2";
                }
                else if (asd.check == 3){ //System.out.println("bal");
                    //asd.del();
                    if(!eredmeny.contains("3")) eredmeny+="3";
                }
                    //System.out.println(eredmeny);
                    //System.out.println(eredmeny+"   "+peldak[toss_a_coint_to_your_witcher]);
                if(eredmeny.length()==peldak[toss_a_coint_to_your_witcher].length()) {
                    if (eredmeny.contains(peldak[toss_a_coint_to_your_witcher])) {
                        nyert = true;
                        vege = false;
                    }
                    else{
                        vege = false;
                        getGame().setScreenWithPreloadAssets(EndScreen.class, new SimpleLoadingStage(getGame()));
                    }
                }
                }
            else{
                if(nyert){
                    if(asd.mennyi >=5){
                        end = true;
                        System.out.println("asd");
                        asd.mennyi =0;
                    }
                    else{
                   ujjon();
                   asd.mennyi++;
                }}
                else{//System.out.println("VEGE");
                    vege=false;
                    getGame().setScreenWithPreloadAssets(EndScreen.class, new SimpleLoadingStage(getGame()));
                    }
                }
            if(end){
                TickTimer x = new TickTimer(1, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        vege();
                    }
                });
                addTimer(x);
            }
            }
        });
        addTimer(h);
    }

    void lerak(){
        plus=0;
        vege = true;
        nyert = false;
        toss_a_coint_to_your_witcher = MathUtils.random(0,peldak.length-1);
        //System.out.println(peldak[toss_a_coint_to_your_witcher]);
        if(toss_a_coint_to_your_witcher == 0){
            kep = new OneSpriteStaticActor(game,KEPEK[0]);
            kep.setOrigintoCenter();
            kep.setRotation(0);
        }
        else if(toss_a_coint_to_your_witcher == 1){
            kep = new OneSpriteStaticActor(game,KEPEK[0]);
            kep.setOrigintoCenter();
            kep.setRotation(-90);
        }
        else if(toss_a_coint_to_your_witcher == 2){
            kep = new OneSpriteStaticActor(game,KEPEK[0]);
            kep.setOrigintoCenter();
            kep.setRotation(180);
        }
        else if(toss_a_coint_to_your_witcher == 3){
            kep = new OneSpriteStaticActor(game,KEPEK[0]);
            kep.setOrigintoCenter();
            kep.setRotation(90);
        }
        else if(toss_a_coint_to_your_witcher == 4){
            kep = new OneSpriteStaticActor(game,KEPEK[1]);
            kep.setOrigintoCenter();
            kep.setRotation(0);
        }
        else if(toss_a_coint_to_your_witcher == 5){
            kep = new OneSpriteStaticActor(game,KEPEK[1]);
            kep.setOrigintoCenter();
            kep.setRotation(-90);
        }
        else if(toss_a_coint_to_your_witcher == 6){
            kep = new OneSpriteStaticActor(game,KEPEK[1]);
            kep.setOrigintoCenter();
            kep.setRotation(180);
        }
        else if(toss_a_coint_to_your_witcher == 7){
            kep = new OneSpriteStaticActor(game,KEPEK[1]);
            kep.setOrigintoCenter();
            kep.setRotation(90);
        }
        else if(toss_a_coint_to_your_witcher == 8){
            kep = new OneSpriteStaticActor(game,KEPEK[2]);
            kep.setOrigintoCenter();
            kep.setRotation(0);
        }
        else if(toss_a_coint_to_your_witcher == 9){
            kep = new OneSpriteStaticActor(game,KEPEK[2]);
            kep.setOrigintoCenter();
            kep.setRotation(-90);
        }
        else if(toss_a_coint_to_your_witcher == 10){
            kep = new OneSpriteStaticActor(game,KEPEK[2]);
            kep.setOrigintoCenter();
            kep.setRotation(180);
        }
        else{
            kep = new OneSpriteStaticActor(game,KEPEK[2]);
            kep.setOrigintoCenter();
            kep.setRotation(90);
        }
        kep.setSize(getWidth()/2f,getWidth()/2f);
        kep.setPosition(getWidth()/2-kep.getWidth()/2,getHeight()/2-kep.getHeight()/2);
        addActor(kep);

        border = new OneSpriteStaticActor(game,BORDER);
        border.setSize(getWidth()/1.4f,getWidth()/1.4f);
        border.setPosition(getWidth()/2-border.getWidth()/2,getHeight()/2-border.getHeight()/2);
        addActor(border);

        szeles = (border.getWidth()-kep.getWidth())/200;
    }

    void ujjon(){
        if(!end) {
            kep.remove();
            border.remove();
            game.setScreenWithPreloadAssets(DrawScreen.class, new SimpleLoadingStage(game));
            //lerak();
        }
        else{

        }
    }

    void vege(){
        text1.setText("Kód második része:\r\n"+ MyGdxGame.getPassPart(2));
        TickTimer w = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                ajto1.setX(ajto1.getX() - 1);
                if (ajto1.getX() + ajto1.getWidth() * 1.8f < 0) {

                    TickTimer w = new TickTimer(3, false, new TickTimerListener() {
                        @Override
                        public void onStop(Timer sender) {
                            super.onStop(sender);
                            Tolvaj.pos = 3;
                            getGame().setScreenWithPreloadAssets(HouseScreen.class, new SimpleLoadingStage(getGame()));

                        }
                    });
                    addTimer(w);
                }
            }
        });
        addTimer(w);
    }
}
