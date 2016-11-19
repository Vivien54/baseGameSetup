package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by zaktan on 16-11-18.
 */

public class InputComponent extends Component implements InputProcessor {
    private Command sauter;
    private Command marcher;
    private Command courir;

    private float elapsedTime = 0;

    private boolean isFacingLeft = false;
    private boolean isJumping = false;

    static final int NB_KEYS = 256;
    boolean activeKeys[] = new boolean[NB_KEYS];


    InputComponent(){
        sauter = new CSauter();
        marcher = new CMarcher();
        courir = new CCourir();



        Gdx.input.setInputProcessor(this);
    }

    @Override
    void update(float deltaTime, Actor a) {

        elapsedTime += deltaTime;

        if (activeKeys[Input.Keys.SHIFT_LEFT]) {
            //command courir
            courir.execute(a);
        }
        else
        {
            //command marcher
            marcher.execute(a);
        }

        if (activeKeys[Input.Keys.SPACE]) {
            //command sauter
            sauter.execute(a);
            isJumping=true;
        }

        if (activeKeys[Input.Keys.LEFT]) {
            //va gauche
            isFacingLeft=true;
        }
        else if (activeKeys[Input.Keys.RIGHT]) {
            //va droite
            isFacingLeft=false;
        }
        else {
            //bouge pas
            //marcher.execute(a);
            //a.setState(new StateMarcher());
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        activeKeys[keycode] = true;
        Gdx.app.log(this.getClass().getSimpleName(), "Key down --> " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        activeKeys[keycode] = false;
        Gdx.app.log(this.getClass().getSimpleName(), "Key up --> " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void initActiveKeys() {
        for (int i = 0; i < activeKeys.length; i++) {
            activeKeys[i] = false;
        }
    }


    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        isFacingLeft = facingLeft;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean[] getActiveKeys() {
        return activeKeys;
    }

}
