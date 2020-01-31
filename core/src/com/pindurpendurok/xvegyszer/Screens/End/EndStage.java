package com.pindurpendurok.xvegyszer.Screens.End;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Screens.Menu.MenuScreen;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class EndStage extends MyStage {

    public static final String BG = "Screens/End_End_Screen.png";

    public static final String LOSESOUND = "Tutorial/sound9.ogg";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BG);
        list.addMusic(LOSESOUND);
    }

    public EndStage(final MyGame game) {
        super(new ResponseViewport(720f), game);


        Music m = game.getMyAssetManager().getMusic(LOSESOUND);
        m.play();
        m.setVolume(1);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        SimpleButton back = new SimpleButton(game, "Menübe");
        back.setWidth(getViewport().getWorldWidth() - 100);
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 50);
        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenWithPreloadAssets(MenuScreen.class, new SimpleLoadingStage(game));
            }
        });
        addActor(back);

    }
}
