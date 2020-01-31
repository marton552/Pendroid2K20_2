package com.pindurpendurok.xvegyszer.Screens.ProfDoor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pindurpendurok.xvegyszer.Elements.SimpleLabel;
import com.pindurpendurok.xvegyszer.MyGdxGame;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;


public class CodeConsole extends MyGroup {
    public static final String BTN = "Textures/codeBtn.png";
    public static final String DBG = "ui_textures/gray.png";
    public static final String FONT = "8-bit.ttf";
    public static final String TERMINAL = "Textures/terminal.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(BTN);
        list.addTexture(DBG);
        list.addFont(FONT, 30);
        list.addTexture(TERMINAL);
    }


    public String pass = "";

    SimpleLabel digitLabel;


    public CodeConsole(MyGame game) {
        super(game);

        float theX = 0;
        float theY = 0;
        setSize(320, 550);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, TERMINAL);
        bg.setSize(getWidth() + 50, getHeight() + 50);
        bg.setPosition(getWidth() / 2 - bg.getWidth() / 2, getHeight() / 2 - bg.getHeight() / 2);
        addActor(bg);


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



        digitLabel = new SimpleLabel(game, pass, FONT);
        digitLabel.setColor(Color.GREEN);
        OneSpriteStaticActor digitBg = new OneSpriteStaticActor(game, DBG);
        digitBg.setSize(110*3 - 10, 100);
        digitBg.setPosition(0, 110*4);

        digitLabel.setAlignment(Align.center);
        digitLabel.setPosition(digitBg.getX() + digitBg.getWidth() / 2 - digitLabel.getWidth() / 2, digitBg.getY() + digitBg.getHeight() / 2 - digitLabel.getHeight() / 2);

        addActor(digitBg);
        addActor(digitLabel);


    }

    public void correctCode(){
        System.out.println("Jó jelszó");
    }

    public void badCode() {
        System.out.println("Rossz jelszó");
    }


    public void pressedButton(String btn) {
        System.out.println("PASS: "+MyGdxGame.PASS);
        if("C".compareTo(btn) == 0) {
            if(pass.length() > 0){
                System.out.println("C pressed");
                pass = pass.substring(0, pass.length() - 1);
                digitLabel.setText(pass);

            }
        }

        if("A".compareTo(btn) == 0) {
            System.out.println(MyGdxGame.PASS);
            System.out.println(pass +"=="+ MyGdxGame.PASS);
            if(pass.compareTo(MyGdxGame.PASS) == 0) {
                correctCode();
                return;
            }else {
                badCode();
                return;
            }
        }


        if(btn.compareTo("A") != 0 && btn.compareTo("C") != 0 && pass.length() < 6) {
            pass += btn;
            digitLabel.setText(pass);
        }


    }
}
