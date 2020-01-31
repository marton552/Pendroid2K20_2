package com.pindurpendurok.xvegyszer.Screens.Draw;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class DrawStage extends SimpleWorldStage {

    public static boolean waitfor = true;
    public String eredmeny = "";
    public boolean vege =true;
    public String[] peldak = {"21","10","03","32","210","103","032","321","2103","1032","0321","3210"};

    public DrawStage(MyGame game) {
        super(new ResponseViewport(1080f), game);

        final Huzas asd = new Huzas(game,this);

        final int toss_a_coint_to_your_witcher = MathUtils.random(0,peldak.length-1);
        System.out.println(peldak[toss_a_coint_to_your_witcher]);

        TickTimer h = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                if(vege){
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
                if(eredmeny.length()==peldak[toss_a_coint_to_your_witcher].length()) {
                    if (eredmeny.contains(peldak[toss_a_coint_to_your_witcher])) {
                        System.out.println("VICTORY YEY");
                        vege = false;
                    }
                    else{
                        System.out.println("LOSE");
                        eredmeny="";
                    }
                }}}
        });
        addTimer(h);
    }
}
