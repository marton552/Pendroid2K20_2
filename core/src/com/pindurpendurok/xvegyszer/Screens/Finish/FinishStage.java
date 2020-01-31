package com.pindurpendurok.xvegyszer.Screens.Finish;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.SimpleLoadingStage;

import hu.csanyzeg.master.Demos.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class FinishStage extends MyStage {

    public static final String BG = "Screens/End_Screen_Yeye.png";
    public static final String WINSOUND = "Tutorail/sound10.ogg";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BG);
        list.addTexture(WINSOUND);

    }

    public FinishStage(final MyGame game) {
        super(new ResponseViewport(720), game);


        Music m = game.getMyAssetManager().getMusic(WINSOUND);
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
