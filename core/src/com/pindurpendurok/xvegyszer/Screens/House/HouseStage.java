package com.pindurpendurok.xvegyszer.Screens.House;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Screens.Actors.RandomGomb;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
import com.pindurpendurok.xvegyszer.Screens.Circle.CircleScreen;
import com.pindurpendurok.xvegyszer.Screens.Draw.DrawScreen;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;
import com.pindurpendurok.xvegyszer.Screens.ProfDoor.ProfDoorScreen;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class HouseStage extends SimpleWorldStage {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"Textures/house_background.png"};
    public static AssetList assetList = new AssetList();

    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    static float magassag;
    static float szelesseg;
    public static final float[] x = new float[]{330f/720f,330f/720f,650f/720f,130f/720f};
    public static final float[] y = new float[]{1180f/1280f,110f/1280f,340f/1280f,660f/1280f};
    //lent, fent, bal,jobb

    public static float getX(int pos){
        return szelesseg*x[pos];
    }
    public static float getY(int pos){
        return magassag-magassag*y[pos];
    }

    static public Tolvaj t;
    static public int hanyadik;
    static public List<RandomGomb> g = new ArrayList<>();
    public HouseStage(final MyGame game){
        super(new ResponseViewport(720f),game);
        magassag = getViewport().getWorldHeight();
        szelesseg = getViewport().getWorldWidth();


        OneSpriteStaticActor background = new OneSpriteStaticActor(game,texturak[0]);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        t = new Tolvaj(game,world,this);
        t.setSize(170,170);

        t.Move(t.pos);
        System.out.println("X:"+getX(Tolvaj.pos)+"Y:"+getY(Tolvaj.pos));
        //System.out.println(330f/720f);
        //t.setPosition(300,300);
        addActor(t);
        Ajtok();
    }

    public void Ajtok(){
        for (int i = 0; i < this.x.length; i++) {
            if(i != Tolvaj.pos){
                final int a = i;
                final RandomGomb g = new RandomGomb(game,world,this);
                g.setSize(200,200);
                g.Move(a);
                addActor(g);
                this.g.add(g);
                g.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        DelAjtok();
                        addTimer(new TickTimer(HouseStage.t.MoveNice(a), false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                if(a == 1) {game.setScreenWithPreloadAssets(ProfDoorScreen.class,new SimpleLoadingStage(game));}
                                if(a == 2) {game.setScreenWithPreloadAssets(CircleScreen.class,new SimpleLoadingStage(game));}
                                if(a == 3) {game.setScreenWithPreloadAssets(DrawScreen.class,new SimpleLoadingStage(game));}
                                if(a == 0) {game.setScreenWithPreloadAssets(MenuScreen.class,new SimpleLoadingStage(game));}
                            }
                        }));
                    }
                });
                this.g.add(g);
            }
        }
    }
    public void DelAjtok(){
        for (int i = 0; i < HouseStage.g.size(); i++) {
            g.get(i).remove();
        }
    }

}
