package com.pindurpendurok.xvegyszer.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.MyGdxGame;
import com.pindurpendurok.xvegyszer.Screens.About.AboutScreen;
import com.pindurpendurok.xvegyszer.Screens.Actors.Tolvaj;
import com.pindurpendurok.xvegyszer.Screens.End.EndScreen;
import com.pindurpendurok.xvegyszer.Screens.Entrance.EntranceScreen;
import com.pindurpendurok.xvegyszer.Screens.StoryStage;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

import java.security.AlgorithmConstraints;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {

    public static final String WBG = "ui_textures/black.png";
    public static final String BG = "Screens/Menu_Screen.png";


    public static String[] sounds = {"Tutorial/sound1.ogg", "Tutorial/sound2.ogg", "Tutorial/sound3.ogg", "Tutorial/sound4.ogg", "Tutorial/sound5.ogg", "Tutorial/sound6.ogg", "Tutorial/sound7.ogg", "Tutorial/sound8.ogg"};
    public static String[] images = {"Tutorial/tutorial1.png", "Tutorial/tutorial2.png", "Tutorial/tutorial3.png","Tutorial/tutorial8.png", "Tutorial/tutorial5.png", "Tutorial/tutorial6.png","Tutorial/tutorial4.png","Tutorial/tutorial7.png"};


    public static AssetList list = new AssetList();
    static {
        list.addTexture(WBG);
        list.addTexture(BG);

        for(int i = 0; i < sounds.length; i++) list.addMusic(sounds[i]);
        for(int i = 0; i < images.length; i++) list.addTexture(images[i]);

    }

    SimpleButton playBtn;
    SimpleButton aboutBtn;
    SimpleButton quitBtn;
    SimpleButton realAboutBtn;

    SimpleLabel azthitted;

    SimpleLabel endLabel;
    OneSpriteStaticActor endBg;
    SimpleButton endBtn;


    public MenuStage(final MyGame game) {
        super(new ResponseViewport(720), game);
        setCameraResetToLeftBottomOfScreen();

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        Tolvaj.pos = 0;

        playBtn = new SimpleButton(game, "Quit");
        playBtn.setWidth(getViewport().getWorldWidth() - 100);
        playBtn.setPosition(getViewport().getWorldWidth() / 2 - playBtn.getWidth() / 2, getViewport().getWorldHeight() / 2 + 80);

        playBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playBtn.setVisible(false);
                quitBtn.setVisible(false);
                aboutBtn.setVisible(true);
                azthitted.setVisible(true);
                realAboutBtn.setVisible(true);
            }
        });
        addActor(playBtn);

        quitBtn = new SimpleButton(game, "Play");
        quitBtn.setWidth(getViewport().getWorldWidth() - 100);
        quitBtn.setPosition(getViewport().getWorldWidth() / 2 - quitBtn.getWidth() / 2, playBtn.getY() - quitBtn.getHeight() - 10);
        quitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                endBg.setVisible(true);
                endLabel.setVisible(true);
                endBtn.setVisible(true);
            }
        });
        addActor(quitBtn);

        azthitted = new SimpleLabel(game, "Azt hitted mi?");
        azthitted.setAlignment(Align.center);
        azthitted.setVisible(false);
        azthitted.setPosition(getViewport().getWorldWidth() / 2 - azthitted.getWidth() / 2, getViewport().getWorldHeight() / 2 + 160);
        addActor(azthitted);

        aboutBtn = new SimpleButton(game, "About");
        aboutBtn.setWidth(getViewport().getWorldWidth() - 100);
        aboutBtn.setPosition(getViewport().getWorldWidth() / 2 - aboutBtn.getWidth() / 2, playBtn.getY());
        aboutBtn.setVisible(false);
        aboutBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                MyGdxGame.PASS = MyGdxGame.newPass();
                game.setScreenWithPreloadAssets(EntranceScreen.class, new SimpleLoadingStage(game));
            }
        });
        addActor(aboutBtn);

        realAboutBtn = new SimpleButton(game, "Az igazi About");
        realAboutBtn.setWidth(getViewport().getWorldWidth() - 100);
        realAboutBtn.setPosition(getViewport().getWorldWidth() / 2 - realAboutBtn.getWidth() / 2, aboutBtn.getY() - realAboutBtn.getHeight() - 10);
        realAboutBtn.setVisible(false);
        realAboutBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //game.setScreenWithPreloadAssets(AboutScreen.class, new SimpleLoadingStage(game));

                ((MyScreen)getGame().getScreen()).addStage(new StoryStage(game, images, sounds) {
                    @Override
                    public void storyEnded(StoryStage sender) {
                        super.storyEnded(sender);
                        ((MyScreen)getGame().getScreen()).removeStage(sender);

                    }
                }, 10, true);

            }
        });
        addActor(realAboutBtn);

        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        endBg.setVisible(false);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Biztos ki akarsz lépni?");
        endLabel.setAlignment(Align.center);
        endLabel.setPosition(getViewport().getWorldWidth() / 2 - endLabel.getWidth() / 2, getViewport().getWorldHeight() / 2 + 50);
        endLabel.setVisible(false);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Igen! <3");
        endBtn.setWidth(getViewport().getWorldWidth() - 100);
        endBtn.setVisible(false);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBtn.getWidth() / 2, getViewport().getWorldHeight() / 2 - endBtn.getHeight() - 10);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });

        addActor(endBtn);

        addActor(new SimpleLabel(game, "Ha előszőr hallgasd\nmeg az About-ot") {
            @Override
            public void init() {
                super.init();
                setAlignment(Align.center);
                setPosition(getViewport().getWorldWidth() / 2 - getWidth() / 2, 10);
            }
        });

    }
}
