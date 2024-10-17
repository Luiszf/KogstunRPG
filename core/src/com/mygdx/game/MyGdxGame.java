package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture img2;
    Pixmap character;
    Pixmap missel;
    float x = 1280 / 2;
    float y = 720 / 2;
    float xMissel= 1280 / 2;
    float yMissel= 720 / 2;
    float xOrigin = 0;
    float yOrigin = 0;
    float y1;
    float x1;
    MyInputProcessor ip = new MyInputProcessor();

    @Override
    public void create() {
        batch = new SpriteBatch();

        character = new Pixmap(150, 150, Pixmap.Format.RGBA8888);
        character.setColor(Color.CYAN);
        character.fillCircle(75, 75, 50);
        img = new Texture(character);

        missel = new Pixmap(50, 50, Pixmap.Format.RGBA8888);
        missel.setColor(Color.GOLD);
        missel.fillCircle(25, 25, 12);
        img2 = new Texture(missel);

        Gdx.input.setInputProcessor(ip);

    }

    @Override
    public void render() {
        ScreenUtils.clear(255, 0, 0, 1);
        batch.begin();
        batch.draw(img,  x - 75, y - 75);
        batch.draw(img2, xMissel - 25, yMissel - 25);

        if (!ip.missel){
            xMissel = x;
            yMissel = y;
            xOrigin = x;
            yOrigin = y;
        }
        if (ip.missel) {
            if (xMissel < 0 | xMissel > 1280 | yMissel < 0|yMissel > 720){
                ip.missel = false;
            }

            float MaxVelocity = 10f;
            float yVelocity = ((float) (ip.yMissel - yOrigin) /25) ;
            float xVelocity = ((float) (ip.xMissel - xOrigin) /25) ;
            System.out.println(xVelocity+ "---" + yVelocity);

            xMissel += xVelocity;
            yMissel += yVelocity;
        }

        float yVelocity = ((ip.y - y));
        float xVelocity = ((ip.x - x));
        float sum = Math.abs(xVelocity) + Math.abs(yVelocity);
        float oi = 0;
        if (sum != 0) oi = ( ip.moveSpeed / sum);

        System.out.println(ip.moveSpeed);
        if (Math.abs(Math.abs(ip.x) - Math.abs(x)) < ip.moveSpeed + 2){
            ip.moveSpeed -= 0.5f;
            if(ip.moveSpeed < 1.5f) ip.moveSpeed = 0;
        } else {
            ip.moveSpeed = 4;
        }

        y1 = (oi * yVelocity);
        x1 = (oi * xVelocity);
        x += x1;
        y += y1;
        batch.end();


    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        img2.dispose();
    }
}
