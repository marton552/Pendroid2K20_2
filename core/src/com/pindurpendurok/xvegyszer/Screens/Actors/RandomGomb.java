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
    static final String[] texturak = new String[]{"Textures/Door_icon.png"};
    public static final int[] x = new int[]{330,330,650,130};
    public static final int[] y = new int[]{1180,110,340,660};
    //lent, fent, bal,jobb
    private SimpleWorldHelper item;
    public int pos;
    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public RandomGomb(final MyGame game, final SimpleWorld world,SimpleWorldStage gs, int pos) {
        super(game, texturak[0]);
        this.pos = pos;

        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(item);
    }
    public void Mozgat(int x, int y){
        item.body.moveToFixTime(x,1280-y,0, PositionRule.Center);
    }
}