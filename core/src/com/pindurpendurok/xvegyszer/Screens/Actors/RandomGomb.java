package com.pindurpendurok.xvegyszer.Screens.Actors;

import com.pindurpendurok.xvegyszer.Screens.House.HouseStage;

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
    static final String[] texturak = new String[]{"Textures/Door_icon.png"};


    private SimpleWorldHelper item;
    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public RandomGomb(final MyGame game, final SimpleWorld world,SimpleWorldStage gs) {
        super(game, texturak[0]);

        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(item);
    }
    public void Move(int pos){
        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
        item.body.moveToFixTime(HouseStage.getX(pos),HouseStage.getY(pos),0, PositionRule.Center);
    }

}