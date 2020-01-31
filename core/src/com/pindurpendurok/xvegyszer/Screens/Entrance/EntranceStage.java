package com.pindurpendurok.xvegyszer.Screens.Entrance;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.Screens.End.EndScreen;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class EntranceStage extends MyStage {

    public static final String BG = "Textures/Room1_NoDoor.png";
    public static final String DOOR = "Textures/Room1_Door.png";
    public static final String XRAY_M = "Textures/Xray_Machine.png";
    public static final String XRAY = "Textures/Xray_GreenScene.png";
    public static final String HOLE = "Textures/Red_Dot.png";

    public static final String BROKE1 = "Textures/Door_Broked1.png";
    public static final String BROKE2 = "Textures/Door_Broked2.png";
    public static final String BROKE3 = "Textures/Door_Broked3.png";

    public static String[] brokeArray = new String[]{BROKE1, BROKE2, BROKE3};

    public static final String BROKEN = "Textures/Room1_BrokenDoor.png";

    public static final String WBG = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static{
        list.addTexture(BG);
        list.addTexture(DOOR);
        list.addTexture(XRAY_M);
        list.addTexture(XRAY);
        list.addTexture(HOLE);
        for(int i = 0; i < brokeArray.length; i++) list.addTexture(brokeArray[i]);

        list.addTexture(WBG);
        list.addTexture(BROKEN);
    }

    OneSpriteStaticActor door;
    ArrayList<OneSpriteStaticActor> breakInSpots = new ArrayList<>();
    ArrayList<OneSpriteStaticActor> brokeIn = new ArrayList<>();

    int SCORE = MathUtils.random(4, 5);

    boolean xray = false;
    OneSpriteStaticActor xrayActor;


    SimpleLabel endLabel;
    OneSpriteStaticActor endBg;
    SimpleButton endBtn;

    boolean canUseXray = true;

    public EntranceStage(final MyGame game) {
        super(new ResponseViewport(720), game);
        setCameraResetToLeftBottomOfScreen();

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        SimpleButton next = new SimpleButton(game, "A házba");
        next.setWidth(next.getWidth() + 20);
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                System.out.println("BEMEGY A HÁZBAAAA");
            }
        });
        addActor(next);

       door = new OneSpriteStaticActor(game, DOOR);
       door.setPosition(119, 107);
       door.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               super.clicked(event, x, y);
                doorTapped(x, y);
           }
       });

       next.setPosition(door.getX() + door.getWidth() / 2 - next.getWidth() / 2, next.getY() + door.getHeight() / 2 -  next.getHeight() / 2);
       addActor(door);

        for(int i = 0; i < SCORE; i++) {
            final OneSpriteStaticActor hole = new OneSpriteStaticActor(game, HOLE);
            float randomX = MathUtils.random(door.getX() + 50, door.getX() + door.getWidth() - 50);
            float randomY = MathUtils.random(door.getY() + 50, door.getY() + door.getHeight() - 50);

            hole.setPosition(randomX - hole.getWidth() / 2, randomY - hole.getHeight() / 2);
            hole.setAlpha(0);
            hole.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    holePunch(hole.getX(), hole.getY());
                    hole.remove();
                }
            });
            addActor(hole, 300+i);
            breakInSpots.add(hole);
        }


        xrayActor = new OneSpriteStaticActor(game, XRAY);
        xrayActor.setPosition(door.getX(), door.getY());
        xrayActor.setSize(door.getWidth(), door.getHeight());
        xrayActor.setVisible(false);
        xrayActor.setZIndex(1000);
        xrayActor.setAlpha(0.7f);

        addActor(xrayActor);

        OneSpriteStaticActor xrayMach = new OneSpriteStaticActor(game, XRAY_M);
        xrayMach.setPosition(10, 10);
        xrayMach.setSize(xrayMach.getWidth() / 2, xrayMach.getHeight() / 2);
        xrayMach.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                if(canUseXray) {
                    canUseXray = false;
                    showXray(true);
                    addTimer(new TickTimer(1, false, new TickTimerListener() {
                        @Override
                        public void onStop(Timer sender) {
                            super.onStop(sender);
                            showXray(false);
                            canUseXray = true;
                        }
                    }));
                };
            }
        });
        addActor(xrayMach);

        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        endBg.setVisible(false);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Ní-nó!\nMegszólalt a riasztó");
        endLabel.setAlignment(Align.center);
        endLabel.setPosition(getViewport().getWorldWidth() / 2 - endLabel.getWidth() / 2, getViewport().getWorldHeight() / 2 + 50);
        endLabel.setVisible(false);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Az örsre");
        endBtn.setVisible(false);
        endBtn.setWidth(getViewport().getWorldWidth() - 100);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBtn.getWidth() / 2, getViewport().getWorldHeight() / 2 - endBtn.getHeight() - 50);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new EndScreen(game));
            }
        });

        addActor(endBtn);
    }

    public void breakDoor() {
        door.remove();
        for(int i = 0; i < breakInSpots.size(); i++) breakInSpots.get(i).remove();
        for(int i = 0; i < brokeIn.size(); i++) brokeIn.get(i).remove();

        door = new OneSpriteStaticActor(game, BROKEN);
        door.setPosition(119, 107);
        door.setSize(465, 903);
        addActor(door, 1);
    }

    public void holePunch(float x, float y) {
        if(xray) return;

        OneSpriteStaticActor spot = new OneSpriteStaticActor(game, brokeArray[MathUtils.random(0, brokeArray.length-1)]);
        spot.setSize(spot.getWidth() / 2, spot.getHeight() / 2);
        spot.setPosition(x - spot.getWidth() / 2 + 20, y - spot.getHeight() / 2);
        addActor(spot, 100);

        brokeIn.add(spot);

        SCORE--;

        if(SCORE <= 0) {
            breakDoor();
        }
    }

    public void showXray(boolean show) {
        xray = show;
        xrayActor.setVisible(xray);

        for (int i = 0; i < breakInSpots.size(); i++) {
            breakInSpots.get(i).setAlpha(xray == true ? 1 : 0);
        }
    }

    public void soundAlarm(){
        endBg.setVisible(true);
        endLabel.setVisible(true);
        endBtn.setVisible(true);

        //door.remove();
        for(int i = 0; i < breakInSpots.size(); i++) breakInSpots.get(i).remove();
        for(int i = 0; i < brokeIn.size(); i++) brokeIn.get(i).remove();
    }

    public void doorTapped(float x, float y) {
        soundAlarm();
    }
}
