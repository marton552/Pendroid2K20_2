package com.pindurpendurok.xvegyszer.Screens.ProfDoor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
import com.pindurpendurok.xvegyszer.Screens.End.EndScreen;
import com.pindurpendurok.xvegyszer.Screens.House.HouseScreen;
import com.pindurpendurok.xvegyszer.Screens.Labor.LaborScreen;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class ProfDoorStage extends MyStage {

    public static final String BG = "Textures/Room1_Lab.png";
    public static final String WBG = "ui_textures/black.png";

    //Terminal_Background.png



    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CodeConsole.class, list);
        list.addTexture(BG);
        list.addTexture(WBG);
    }

    CodeConsole c;

    SimpleLabel endLabel;
    OneSpriteStaticActor endBg;
    SimpleButton endBtn;

    SimpleButton goIn;
    SimpleButton back;

    boolean v = false;

    public ProfDoorStage(final MyGame game) {
        super(new ResponseViewport(720), game);


        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        c = new CodeConsole(game) {
            @Override
            public void correctCode() {
                super.correctCode();

                if(v) return;

                goIn.setVisible(true);
                v = true;
                c.setVisible(false);

            }

            @Override
            public void badCode() {
                super.badCode();

                endBg.setVisible(true);
                endLabel.setVisible(true);
                endBtn.setVisible(true);
                c.setVisible(false);
            }
        };

        c.setPosition(getViewport().getWorldWidth() / 2 - c.getWidth() / 2, getViewport().getWorldHeight() / 2 - c.getHeight() / 2);
        c.setVisible(false);
        addActor(c);

        OneSpriteStaticActor console = new OneSpriteStaticActor(game, WBG);
        console.setSize(100, 150);
        console.setPosition(0, getViewport().getWorldHeight() / 2);
        console.setAlpha(0);
        console.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(c.isVisible() == false) {
                    c.setVisible(true);
                }
            }
        });
        addActor(console);

        goIn = new SimpleButton(game, "Be a laborba");
        goIn.setVisible(false);
        goIn.setWidth(getViewport().getWorldWidth() - 100);
        goIn.setPosition(getViewport().getWorldWidth() / 2 - goIn.getWidth() / 2 , goIn.getHeight() + 20);
        goIn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(LaborScreen.class, new SimpleLoadingStage(game));

            }
        });
        addActor(goIn);


        back = new SimpleButton(game, "Vissza");
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 10);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Tolvaj.pos = 1;
                game.setScreen(new HouseScreen(game));
            }
        });
        addActor(back);

        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        endBg.setVisible(false);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Ní-nó!\nRossz kódot írtál be,\nezért megszólalt a riasztó!");
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
}
