package com.pindurpendurok.xvegyszer.Screens.Labor;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class LaborStage extends SimpleWorldStage {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"Textures/house_background.png","test/red_move.png"};

    static {
        for (int i = 0; i < texturak.length; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public LaborStage(final MyGame game){
        super(new ResponseViewport(720f),game);

        OneSpriteStaticActor background = new OneSpriteStaticActor(game,texturak[0]);
        background.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(background);

        OneSpriteStaticActor helye = new OneSpriteStaticActor(game,texturak[1]);

        helye.setSize(100,100);
        float x = getViewport().getWorldWidth()/2-helye.getWidth()/2;
        float y = getViewport().getWorldHeight()/2-helye.getHeight()/2;

        helye.setPosition(x,y);
        addActor(helye);
    }
}
