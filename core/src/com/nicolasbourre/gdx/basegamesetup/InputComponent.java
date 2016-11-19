package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by zaktan on 16-11-18.
 */

public class InputComponent extends Component {
    private Command sauter;
    private Command marcher;
    private Command courir;

    private float elapsedTime = 0;

    private boolean isFacingLeft = false;
    private boolean isJumping = false;

    boolean activeKeys[];


    InputComponent(){
        sauter = new CSauter();
        marcher = new CMarcher();
        courir = new CCourir();

    }

    @Override
    void update(float deltaTime, Actor a) {

        elapsedTime += deltaTime;

        if (activeKeys[a.getRunKey()]) {
            //command courir
            courir.execute(a);
        }
        else
        {
            //command marcher
            marcher.execute(a);
        }

        if (activeKeys[a.getJumpKey()]) {
            //command sauter
            sauter.execute(a);
            isJumping=true;
        }

        if (activeKeys[a.getGoLeftKey()]) {
            //va gauche
            isFacingLeft=true;
        }
        else if (activeKeys[a.getGoRightKey()]) {
            //va droite
            isFacingLeft=false;
        }
        else {
            //bouge pas
            //marcher.execute(a);
            //a.setState(new StateMarcher());
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
    public void setActiveKeys(boolean k[]) {
        activeKeys=k;
    }

}
