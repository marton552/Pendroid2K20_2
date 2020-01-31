package com.pindurpendurok.xvegyszer.Screens.House;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.xvegyszer.Screens.Actors.RandomGomb;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

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
    public HouseStage(final MyGame game){
        super(new ResponseViewport(720f),game);
        OneSpriteStaticActor background = new OneSpriteStaticActor(game,Background);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        //actor: 330,1260
        //gomb helyek:
        /*
        20,105
        700,980
        */
        t = new Tolvaj(game,world,this);
        t.setSize(100,100);

        t.Megy(330,1130,0);
        addActor(t);

        RandomGomb g = new RandomGomb(game,world,this);
        g.setSize(100,100);
        g.Megy(Tolvaj.x[0],Tolvaj.y[0],0);
        addActor(g);
        g.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                HouseStage.t.OdaMegy(0,3);
            }
        });

        RandomGomb gg = new RandomGomb(game,world,this);
        gg.setSize(100,100);
        gg.Megy(Tolvaj.x[1],Tolvaj.y[1],0);
        addActor(gg);
        gg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                HouseStage.t.OdaMegy(1,3);
            }
        });
    }
}
