package com.pindurpendurok.xvegyszer.Screens.Finish;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.xvegyszer.Elements.SimpleButton;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class FinishStage extends MyStage {

    public static final String BG = "";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BG);
    }

    public FinishStage(MyGame game) {
        super(new ResponseViewport(720), game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, BG);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        SimpleLabel l = new SimpleLabel(game, "Sikeresen vissza\nszolgálatattad az X-VEGYSZERT!");
        l.setAlignment(Align.center);
        l.setPosition(getViewport().getWorldWidth() / 2 - l.getWidth() / 2, getViewport().getWorldHeight() / 2 + 50);
        addActor(l);

        SimpleButton back = new SimpleButton(game, "Menübe");
        back.setWidth(getViewport().getWorldWidth() - 100);
        back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, 50);
        addActor(back);

    }
}
