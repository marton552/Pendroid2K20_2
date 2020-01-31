package com.pindurpendurok.xvegyszer.Screens.ProfDoor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class CodeConsole extends MyGroup {
    public static final String BTN = "Textures/codeBtn.png";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BTN);
    }


    public CodeConsole(MyGame game) {
        super(game);

        float theX = 0;
        float theY = 0;

        for(int i = 1; i <= 12; i++) {


            OneSpriteStaticActor gomb = new OneSpriteStaticActor(game, BTN);
            gomb.setSize(100, 100);
            gomb.setPosition(theX, theY);

            String gombSz = "";
            if(i == 1) gombSz = "C";
            else if (i == 2) gombSz = "0";
            else if(i == 3) gombSz = "A";
            else gombSz = (i - 3)+"";
            final SimpleLabel gl = new SimpleLabel(game, gombSz);
            gl.setColor(Color.BLACK);
            if(gombSz == "C") gl.setColor(Color.RED);
            else if(gombSz == "A") gl.setColor(Color.GREEN);

            gl.setAlignment(Align.center);
            gl.setSize(gomb.getWidth(), gomb.getHeight());
            gl.setPosition(gomb.getX() + gomb.getWidth() / 2 - gl.getWidth() / 2, gomb.getY() + gomb.getHeight() / 2 - gl.getHeight() / 2);
            gl.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    pressedButton(gl.getText().toString());
                }
            });
            addActor(gomb);
            addActor(gl);

            theX += 110;
            if(i % 3 == 0) {
                theY += (100 + 10);
                theX = 0;
            }
        }
    }

    public void pressedButton(String btn) {
        System.out.println("PRESSED: "+btn);
    }
}
