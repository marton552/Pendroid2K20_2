package com.pindurpendurok.xvegyszer.Screens.Actors;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;


public class RandomGomb extends OneSpriteStaticActor {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"test/red_move.png"};
    private SimpleWorldHelper item;


    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public RandomGomb(final MyGame game, final SimpleWorld world,SimpleWorldStage gs) {
        super(game, texturak[0]);

        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        item.body.setSize(255,255);
        setActorWorldHelper(item);
    }
    public void Megy(int x, int y, float ido){
        //item.setBodyPosition(x-item.getActorWidth()/2,1280-y);
        item.body.moveToFixTime(x,1280-y,ido, PositionRule.Center);
    }
}