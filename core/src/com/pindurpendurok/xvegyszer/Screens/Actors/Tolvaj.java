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
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;


public class Tolvaj extends OneSpriteStaticActor {
    static AssetList list = new AssetList();
    static final String[] texturak = new String[]{"test/blue_move.png"};

    private SimpleWorldHelper item;
    public static int pos;

    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public Tolvaj(final MyGame game, final SimpleWorld world,SimpleWorldStage gs) {
        super(game, texturak[0]);

        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        item.body.setSize(255,255);
        setActorWorldHelper(item);
    }

    public void MoveTo(final int pozició){
        if(this.pos == 0){
            if(pozició == 1)
                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],2f, PositionRule.Center);
            if(pozició == 2){
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],1.5f, PositionRule.Center);
                addTimer(new TickTimer(1.5f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],0.5f, PositionRule.Center);
                    }
                }));
            }
            if(pozició == 3){
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],1.5f, PositionRule.Center);
                addTimer(new TickTimer(1.5f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],0.5f, PositionRule.Center);
                    }
                }));
            }
        }
        if(this.pos == 1){
            if(pozició == 0)
                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],2f, PositionRule.Center);
            if(pozició == 2){
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],1f, PositionRule.Center);
                addTimer(new TickTimer(1f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],1f, PositionRule.Center);
                    }
                }));
            }
            if(pozició == 3){
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],1.5f, PositionRule.Center);

                addTimer(new TickTimer(1.5f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],0.5f, PositionRule.Center);
                    }
                }));

            }
        }
        if(this.pos == 2){
            if(pozició == 0){
                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[2],0.5f, PositionRule.Center);
                addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],1.5f, PositionRule.Center);
                    }
                }));
            }
            if(pozició == 1)
                item.body.moveToFixTime(RandomGomb.x[1],1280-RandomGomb.y[2],1f, PositionRule.Center);
            addTimer(new TickTimer(1f, false, new TickTimerListener() {
                @Override
                public void onStop(Timer sender) {
                    super.onStop(sender);
                    item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],1f, PositionRule.Center);
                }
            }));

            if(pozició == 3){
                //BUGGOS
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[2],0.6f, PositionRule.Center);
                addTimer(new TickTimer(0.6f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(0,1280-RandomGomb.y[2],1f, PositionRule.Center);
                        addTimer(new TickTimer(0.4f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],0.4f, PositionRule.Center);
                            }
                        }));
                    }
                }));
            }
        }
        if(this.pos == 3){
            if(pozició == 0){
                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[3],0.5f, PositionRule.Center);
                addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],1.5f, PositionRule.Center);
                    }
                }));
            }
            if(pozició == 1)
                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[3],1f, PositionRule.Center);
            addTimer(new TickTimer(1f, false, new TickTimerListener() {
                @Override
                public void onStop(Timer sender) {
                    super.onStop(sender);
                    item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],1f, PositionRule.Center);
                }
            }));

            if(pozició == 2){
                item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],0.6f, PositionRule.Center);

                addTimer(new TickTimer(1.6f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[0],1280-RandomGomb.y[pozició],1f, PositionRule.Center);
                        addTimer(new TickTimer(1f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],0.4f, PositionRule.Center);
                            }
                        }));
                    }
                }));
            }
        }
        //item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],ido, PositionRule.Center);
        pos = pozició;
    }
    public void Move(int pos){
        item.body.moveToFixTime(RandomGomb.x[pos],1280-RandomGomb.y[pos],0, PositionRule.Center);
        Tolvaj.pos = pos;
    }
}