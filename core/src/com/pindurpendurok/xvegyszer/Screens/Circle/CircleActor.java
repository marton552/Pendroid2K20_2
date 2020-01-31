package com.pindurpendurok.xvegyszer.Screens.Circle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.xvegyszer.Screens.Draw.DrawStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class CircleActor extends OneSpriteStaticActor {
    public SimpleWorldHelper sw;

    public static final String[] CIRCLE = {"circle_lock/Lock_Asd.png","circle_lock/Lock_Middle.png","circle_lock/Lock_Side.png",};
    public static AssetList list = new AssetList();
    static {
        for (int i = 0; i < CIRCLE.length; i++) {
            list.addTexture(CIRCLE[i]);
        }
    }

    float kezdX;
    float vegeX;
    float kezdY;
    float vegeY;
    public boolean get = false;
    boolean elsokattint = true;
    public static int check = 5;
    public static int mennyi = 0;
    float iksz;
    float why;


    SimpleWorldStage gs2;

    public CircleActor(MyGame game, SimpleWorld world, SimpleWorldStage gs,int i) {
        super(game, CIRCLE[i]);
        if(i == 0){
        sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setSize(gs.getViewport().getWorldWidth()/4,gs.getViewport().getWorldWidth()/4);
        sw.body.setPosition(gs.getViewport().getWorldWidth()/2-sw.body.getWidth()/2,gs.getViewport().getWorldHeight()/2-sw.body.getHeight()/2);
        setActorWorldHelper(sw);
}
        else if(i == 1){
            sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
            sw.body.setSize(gs.getViewport().getWorldWidth()/2.3f,gs.getViewport().getWorldWidth()/2.3f);
            sw.body.setPosition(gs.getViewport().getWorldWidth()/2-sw.body.getWidth()/2,gs.getViewport().getWorldHeight()/2-sw.body.getHeight()/2);
            setActorWorldHelper(sw);
}
        else{
            sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
            sw.body.setSize(gs.getViewport().getWorldWidth()/1.8f,gs.getViewport().getWorldWidth()/1.8f);
            sw.body.setPosition(gs.getViewport().getWorldWidth()/2-sw.body.getWidth()/2,gs.getViewport().getWorldHeight()/2-sw.body.getHeight()/2);
            setActorWorldHelper(sw);
}
    }
}
