package com.pindurpendurok.xvegyszer.Screens.Draw;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
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
    public static final String BACK = "ui_textures/gold.png";
    public String[] peldak = {"21","10","03","32","210","103","032","321","2103","1032","0321","3210"};
    public final static String[] KEPEK = {"draw/Arrow_Uptoright.png","draw/Arrow_NotCircle.png","draw/Arrow_Nemkelnev.png"};
    public static AssetList list = new AssetList();
    static {
        for (int i = 0; i < KEPEK.length; i++) {
            list.addTexture(KEPEK[0]);
            list.addTexture(BORDER);
            list.addTexture(BACK);
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

    public DrawStage(MyGame game) {
        super(new ResponseViewport(1080f), game);
        OneSpriteStaticActor lol = new OneSpriteStaticActor(game,BACK);
        lol.setSize(getWidth(),getHeight());
        lol.setPosition(0,0);
        addActor(lol);

        final Huzas asd = new Huzas(game,this);

        SimpleLabel text = new SimpleLabel(game,"5/"+asd.mennyi);
        text.setFontScale(5f);
        text.setPosition(getWidth()/2,getHeight()*0.9f);
        addActor(text);

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
                    }
                }
            if(end){
                TickTimer x = new TickTimer(1, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        System.out.println("kövi");
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
    }
}
