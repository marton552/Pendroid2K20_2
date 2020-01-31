package com.pindurpendurok.xvegyszer.Screens.Actors;

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
    public static int fentrol = 1094;

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
        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
        if(this.pos == 0){
            if(pozició == 1){
                item.body.rotateToFixSpeed(0,720, Direction.Shorter);

                item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],2.75f, PositionRule.Center);
                    }
                }));
            }
            if(pozició == 2){
                item.body.rotateToFixSpeed(0,720, Direction.Shorter);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],1.25f, PositionRule.Center);
                        addTimer(new TickTimer(1.5f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(-90,720, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.75f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));
            }
            if(pozició == 3){

                item.body.rotateToFixSpeed(0,720, Direction.Shorter);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],0.5f, PositionRule.Center);

                        addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(90,720, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.25f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));


            }
        }
        if(this.pos == 1){
            if(pozició == 0){
                item.body.rotateToFixSpeed(180,360, Direction.Shorter);
                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],2.75f, PositionRule.Center);
                    }
                }));

            }

            if(pozició == 2){
                item.body.rotateToFixSpeed(180,720, Direction.Shorter);
                item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],0.25f, PositionRule.Center);

                        addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                item.body.rotateToFixSpeed(-90,360, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);

                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.25f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));


            }
            if(pozició == 3){
                item.body.rotateToFixSpeed(180,720, Direction.Shorter);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],1f, PositionRule.Center);
                        addTimer(new TickTimer(1f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(90,720, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyRotation(90);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.5f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));

            }
        }
        if(this.pos == 2){
            if(pozició == 0){
                item.body.rotateToFixSpeed(90,720, Direction.Shorter);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[2],0.5f, PositionRule.Center);
                        addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(180,360, Direction.Shorter);

                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],1.5f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));

                    }
                }));
            }
            if(pozició == 1){
                item.body.rotateToFixSpeed(90,360, Direction.Shorter);
                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[1],fentrol-RandomGomb.y[2],0.25f, PositionRule.Center);

                        addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(0,360, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.25f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));
            }
            if(pozició == 3){
                item.body.rotateToFixSpeed(90,360, Direction.Shorter);

                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[2],0.35f, PositionRule.Center);

                        addTimer(new TickTimer(0.35f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(180,360, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],0.75f, PositionRule.Center);
                                        addTimer(new TickTimer(0.75f, false, new TickTimerListener() {
                                            @Override
                                            public void onStop(Timer sender) {
                                                super.onStop(sender);
                                                item.body.rotateToFixSpeed(90,360, Direction.Shorter);
                                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                                    @Override
                                                    public void onStop(Timer sender) {
                                                        super.onStop(sender);

                                                        item.setBodyOrigin(item.getActorWidth()/2,item.getActorHeight()/2);
                                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.15f, PositionRule.Center);
                                                    }
                                                }));
                                            }
                                        }));
                                    }
                                }));

                            }
                        }));                    }
                }));
            }
        }
        if(this.pos == 3){
            if(pozició == 0){
                //buggos
                item.body.rotateToFixSpeed(-90,720, Direction.Shorter);
                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[3],0.5f, PositionRule.Center);
                        addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(180,720, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.5f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));


            }
            if(pozició == 1)
            {
                item.body.rotateToFixSpeed(-90,720, Direction.Shorter);
                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[3],0.75f, PositionRule.Center);
                        addTimer(new TickTimer(0.75f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(0,720, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.75f, PositionRule.Center);
                                    }
                                }));
                            }
                        }));
                    }
                }));

            }


            if(pozició == 2){
                item.body.rotateToFixSpeed(-90,360, Direction.Shorter);
                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[3],0.35f, PositionRule.Center);

                        addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                            @Override
                            public void onStop(Timer sender) {
                                super.onStop(sender);
                                item.body.rotateToFixSpeed(0,360, Direction.Shorter);
                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                    @Override
                                    public void onStop(Timer sender) {
                                        super.onStop(sender);
                                        item.body.moveToFixTime(RandomGomb.x[0],fentrol-RandomGomb.y[pozició],0.55f, PositionRule.Center);
                                        addTimer(new TickTimer(0.8f, false, new TickTimerListener() {
                                            @Override
                                            public void onStop(Timer sender) {
                                                super.onStop(sender);
                                                item.body.rotateToFixSpeed(-90,360, Direction.Shorter);
                                                addTimer(new TickTimer(0.25f, false, new TickTimerListener() {
                                                    @Override
                                                    public void onStop(Timer sender) {
                                                        super.onStop(sender);
                                                        item.body.moveToFixTime(RandomGomb.x[pozició],fentrol-RandomGomb.y[pozició],0.35f, PositionRule.Center);
                                                    }
                                                }));
                                            }
                                        }));
                                    }
                                }));
                            }
                        }));                    }
                }));
            }
        }
        //item.body.moveToFixTime(RandomGomb.x[pozició],1280-RandomGomb.y[pozició],ido, PositionRule.Center);
        pos = pozició;
    }
    public float Ido(final int pos){
        float value = 0f;
        if(this.pos == 0){
            if(pos == 1) {return 3f;}
            if(pos == 2) {return 2.5f;}
            if(pos == 3) {return 3f;}
        }
        if(this.pos == 1){
            if(pos == 0) {return 3f;}
            if(pos == 2) {return 1f;}
            if(pos == 3) {return 2f;}
        }
        if(this.pos == 2){
            if(pos == 0) {return 2.5f;}
            if(pos == 1) {return 1f;}
            if(pos == 3) {return 2f;}
        }
        if(this.pos == 3){
            if(pos == 0) {return 1.5f;}
            if(pos == 1) {return 2f;}
            if(pos == 2) {return 2f;}
        }
        //dummy
        return 0f;
    }
    public void Move(int pos){
        item.body.moveToFixTime(RandomGomb.x[pos],fentrol-RandomGomb.y[pos],0, PositionRule.Center);
        Tolvaj.pos = pos;
    }
}