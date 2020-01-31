package com.pindurpendurok.xvegyszer.Screens.House;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
    static final String[] texturak = new String[]{"test/background_move.png"};
    static final String Background = "test/background_move.png";
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
        OneSpriteStaticActor background = new OneSpriteStaticActor(game,Background);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        t = new Tolvaj(game,world,this);
        t.setSize(100,100);
        t.Move(3);
        addActor(t);
        for (int i = 0; i < RandomGomb.x.length; i++) {
            if(i != Tolvaj.pos)
                Ajto(i);
        }
    }

    public void Ajto(final int a){
        final RandomGomb g = new RandomGomb(game,world,this,a);
        g.setSize(100,100);
        g.Mozgat(RandomGomb.x[a],RandomGomb.y[a]);
        addActor(g);
        this.g.add(g);
        g.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println(a);
                Ajto(HouseStage.t.pos);
                HouseStage.t.MoveTo(a);

                TickTimer t = new TickTimer(2, false, new TickTimerListener() {

                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        g.remove();
                    }
                });
                addTimer(t);
            }
        });
        this.g.add(g);
    }
}
