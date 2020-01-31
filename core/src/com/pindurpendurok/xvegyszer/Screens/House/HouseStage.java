package com.pindurpendurok.xvegyszer.Screens.House;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Screens.Actors.RandomGomb;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;

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
    static public Tolvaj t;
    static public int hanyadik;
    static public List<RandomGomb> g = new ArrayList<>();
    public HouseStage(final MyGame game){
        super(new ResponseViewport(720f),game);
        RandomGomb.Arany(getViewport().getWorldWidth(),getViewport().getWorldHeight());

        OneSpriteStaticActor background = new OneSpriteStaticActor(game,texturak[0]);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        t = new Tolvaj(game,world,this);
        t.setSize(170,170);
        t.Move(3);
        addActor(t);
        System.out.println(RandomGomb.y[0]);
        Ajtok();
    }
    public void Ajtok(){
        for (int i = 0; i < RandomGomb.x.length; i++) {
            if(i != Tolvaj.pos){
                final int a = i;
                final RandomGomb g = new RandomGomb(game,world,this,a);
                g.setSize(200,200);
                g.Mozgat(RandomGomb.x[a],RandomGomb.y[a]);
                addActor(g);
                this.g.add(g);
                g.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        DelAjtok();
                        final int b = Tolvaj.pos;
                        HouseStage.t.MoveTo(a);
                        addTimer(new TickTimer(HouseStage.t.Ido(b), false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                Ajtok();
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
