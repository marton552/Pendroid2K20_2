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
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class EntranceStage extends MyStage {

    public static final String BG = "";
    public static final String DOOR = "";
    public static final String XRAY_M = "";
    public static final String XRAY = "";
    public static final String HOLE = "";
    public static final String BROKE = "";

    public static final String WBG = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static{
        list.addTexture(BG);
        list.addTexture(DOOR);
        list.addTexture(XRAY_M);
        list.addTexture(XRAY);
        list.addTexture(HOLE);
        list.addTexture(BROKE);

        list.addTexture(WBG);
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

    public EntranceStage(final MyGame game) {
        super(new ResponseViewport(720), game);
        setCameraResetToLeftBottomOfScreen();

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getScreenWidth(), getViewport().getScreenHeight());
        addActor(bg);

        SimpleButton next = new SimpleButton(game, "A házba");
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                System.out.println("BEMEGY A HÁZBAAAA");
            }
        });
        addActor(next);

       door = new OneSpriteStaticActor(game, DOOR);
       door.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               super.clicked(event, x, y);
                doorTapped(x, y);
           }
       });
       addActor(door);

        for(int i = 0; i < SCORE; i++) {
            final OneSpriteStaticActor hole = new OneSpriteStaticActor(game, HOLE);
            hole.setPosition(MathUtils.random(door.getX() + 10, door.getX() + door.getHeight() - 10) - hole.getWidth() / 2,
                    MathUtils.random(door.getY() + 10, door.getY() + door.getHeight() - 10) - hole.getHeight() / 2 );
            hole.setAlpha(0);
            hole.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    holePunch(hole.getX(), hole.getY());
                }
            });
            addActor(hole);
            breakInSpots.add(hole);
        }


        xrayActor = new OneSpriteStaticActor(game, XRAY);
        xrayActor.setPosition(door.getX(), door.getY());
        xrayActor.setSize(door.getWidth(), door.getHeight());
        xrayActor.setVisible(false);
        xrayActor.setZIndex(1000);

        xrayActor.setVisible(true);


        OneSpriteStaticActor xrayMach = new OneSpriteStaticActor(game, XRAY_M);
        xrayMach.setPosition(10, 10);
        xrayMach.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                showXray(!xray);
            }
        });
        addActor(xrayMach);

        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setSize(getViewport().getScreenWidth(), getViewport().getScreenHeight());
        endBg.setVisible(false);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Ní-nó!\nMegszólalt a riasztó");
        endLabel.setAlignment(Align.center);
        endLabel.setPosition(getViewport().getWorldWidth() / 2 - endLabel.getWidth() / 2, getViewport().getWorldHeight() / 2 + 50);
        endLabel.setVisible(false);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Az örsre");
        endBtn.setVisible(false);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBg.getWidth() / 2, getViewport().getWorldHeight() / 2 - endBg.getHeight() - 50);
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
    }

    public void holePunch(float x, float y) {
        if(xray) return;
        SCORE--;

        if(SCORE <= 0) {
            breakDoor();
        }

        OneSpriteStaticActor spot = new OneSpriteStaticActor(game, BROKE);
        spot.setPosition(x, y);
        addActor(spot);

        brokeIn.add(spot);
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
    }

    public void doorTapped(float x, float y) {
        soundAlarm();
    }
}
