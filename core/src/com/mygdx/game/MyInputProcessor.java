package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
    float x;
    float y;
    float moveSpeed = 0;
    int x_hover;
    int y_hover;
    int yMissel;
    int xMissel;
    boolean missel;

    @Override
    public boolean keyDown(int i) {
        System.out.println( "Button: " + i);
        if (i == 45) {
            if(missel) return false;
            xMissel = x_hover;
            yMissel = y_hover;
            missel = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        moveSpeed = 4;
        x = i;
        y = -i1 + 720;
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        x = i;
        y = -i1 + 720;
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        x_hover = i;
        y_hover = -i1 + 720;
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
