package com.pindurpendurok.xvegyszer.Screens.Actors;

import com.pindurpendurok.xvegyszer.Screens.House.HouseStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.Direction;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;


public class Tolvaj extends OneSpriteStaticActor {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"Textures/Thief_png.png"};

    private SimpleWorldHelper item;
    public static int pos = 3;

    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public Tolvaj(final MyGame game, final SimpleWorld world,SimpleWorldStage gs) {
        super(game, texturak[0]);

        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(item);
    }
    void MoveDelay(final int xIndex, final int yIndex, float delay, final float duration){
        addTimer(new TickTimer(delay, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                item.body.moveToFixTime(HouseStage.getX(xIndex),HouseStage.getY(yIndex),duration, PositionRule.Center);
            }
        }));
    }
    void RotateDelay(final float degree, float delay){
        addTimer(new TickTimer(delay, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                item.body.rotateToFixSpeed(degree,720, Direction.Shorter);
            }
        }));
    }
    public float MoveNice(final int pos){
        int temp = this.pos;
        this.pos = pos;
        if(temp == 0){
            if(pos == 1) {
                //3f
                RotateDelay(0,0f);
                MoveDelay(1,1,0.25f,2.75f);
                return 3f;
            }
            if(pos == 2) {
                //2.5f
                MoveDelay(0,2,0f,1.5f);
                RotateDelay(-90f,1.5f);
                MoveDelay(2,2,1.75f,0.75f);
                return 2.5f;
            }
            if(pos == 3) {
                //2f
                RotateDelay(0f,1f);
                MoveDelay(0,3,0.25f,0.75f);
                RotateDelay(90f,1.25f);
                MoveDelay(3,3,1.25f,0.75f);
                return 2f;
            }
        }
        if(temp == 1){
            if(pos == 0) {
                //3f
                RotateDelay(180,0f);
                MoveDelay(0,0,0.25f,2.75f);
                return 3f;
            }
            if(pos == 2) {
                //1f
                RotateDelay(180,0f);
                MoveDelay(1,2,0.25f,0.25f);
                RotateDelay(-90f,0.5f);
                MoveDelay(2,2,0.75f,0.25f);
                return 1f;
            }
            if(pos == 3) {
                //2f
                RotateDelay(180,0f);
                MoveDelay(1,3,0.25f,0.90f);
                RotateDelay(90f,1.15f);
                MoveDelay(3,3,1.5f,0.60f);
                return 2f;
            }
        }
        if(temp == 2){
            if(pos == 0) {
                //2.5f
                RotateDelay(90,0f);
                MoveDelay(0,2,0.25f,0.75f);
                RotateDelay(180f,1f);
                MoveDelay(0,0,1.25f,1.25f);
                return 2.5f;
            }
            if(pos == 1) {
                //1f
                RotateDelay(90,0f);
                MoveDelay(1,2,0.25f,0.25f);
                RotateDelay(0f,0.5f);
                MoveDelay(1,1,1f,0.25f);
                return 1f;
            }
            if(pos == 3) {
                //2f
                RotateDelay(90,0f);
                MoveDelay(0,2,0.25f,0.5f);

                RotateDelay(180f,0.75f);
                MoveDelay(1,3,1f,0.5f);

                RotateDelay(90f,1.5f);
                MoveDelay(3,3,1.75f,0.25f);
                return 2f;
            }
        }
        if(temp == 3){
            if(pos == 0) {
                //1.5f
                RotateDelay(-90,0f);
                MoveDelay(0,3,0.25f,0.5f);
                RotateDelay(180f,0.75f);
                MoveDelay(0,0,1f,0.5f);
                return 1.5f;
            }
            if(pos == 1) {
                //2f
                RotateDelay(-90,0f);
                MoveDelay(1,3,0.25f,0.75f);

                RotateDelay(0f,1f);
                MoveDelay(1,1,1.25f,0.75f);
                return 2f;
            }
            if(pos == 2) {
                //2f
                RotateDelay(-90,0f);
                MoveDelay(1,3,0.25f,0.5f);

                RotateDelay(0f,0.75f);
                MoveDelay(1,2,1f,0.5f);

                RotateDelay(-90f,1.5f);
                MoveDelay(2,2,1.75f,0.25f);
                return 2f;
            }
        }
        //dummy
        return 0f;
    }

    public void Move(int pos){
        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
        item.body.moveToFixTime(HouseStage.getX(pos),HouseStage.getY(pos),0, PositionRule.Center);
        Tolvaj.pos = pos;
    }
}