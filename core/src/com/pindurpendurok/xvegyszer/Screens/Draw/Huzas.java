package com.pindurpendurok.xvegyszer.Screens.Draw;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class Huzas {
    public static final String LABDA = "draw/null.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(LABDA);
    }

    float kezdX;
    float vegeX;
    float kezdY;
    float vegeY;
    public boolean get = false;
    boolean elsokattint = true;
    SimpleWorldStage gs;
    public OneSpriteStaticActor kocka;
    public static int check = 5;
    public static int mennyi = 0;

    public Huzas(MyGame game, SimpleWorldStage gs2){
        check = 5;
        elsokattint = true;
        gs = gs2;
        kocka = new OneSpriteStaticActor(game,LABDA);
        kocka.setPosition(0,0);
        kocka.setSize(gs.getViewport().getWorldWidth(), gs.getViewport().getWorldHeight());
        gs.addActor(kocka,19000);


        //A stagere rakjuk a listenert mert ha kockára rakod bugool
        gs.addListener(new ClickListener() {

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if(elsokattint) {kezdY = y; kezdX = x; elsokattint=false;}
                //megnézzük hogy a kockára kattintintunk-e (opcionális)
                if(x >= kocka.getX() && x <= kocka.getX() + kocka.getWidth()) {
                    if(y >= kocka.getY() && y <= kocka.getY() + kocka.getHeight()) {

                        //Itt pedig középre pozícionáljuk a kockát rá az x,y koordinátára
                        //kocka.setPosition(x - kocka.getWidth() / 2, y - kocka.getHeight() / 2);

                        float iksz = Math.abs(kezdX-x);
                        float why = Math.abs(kezdY-y);

                        if(DrawStage.waitfor){
                            if(kezdX>x+20 && iksz > why)check = 3;
                            else if(kezdX+20<x && iksz > why)check = 1;
                            else if(kezdY>y+20 && why > iksz)check = 0;
                            else if(kezdY+20<y && why > iksz)check = 2;

                            if(y != kezdX)kezdX = x;
                            if(y != kezdY)kezdY = y;
                        }
                    }
                }
            }


            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //del();
            }
        });
    }

    public void del(){
        kocka.setPosition(0,0);
        elsokattint = true;
    }
}
