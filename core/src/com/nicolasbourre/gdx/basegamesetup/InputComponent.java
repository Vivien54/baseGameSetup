package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Input;

/**
 * Created by zaktan on 16-11-18.
 */

public class InputComponent extends Component{
    private Command sauter;
    private Command marcher;
    private Command courir;

    private float elapsedTime = 0;

    private boolean isFacingLeft = false;
    private boolean isJumping = false;

    private boolean activeKeys[];

    InputComponent(){
        sauter = new CSauter();
        marcher = new CMarcher();
        courir = new CCourir();
    }

    @Override
    void update(float deltaTime) {
        elapsedTime += deltaTime;

        if (activeKeys[Input.Keys.SHIFT_LEFT]) {
            //command courir
        }
        else
        {
            //command marcher
        }

        if (activeKeys[Input.Keys.SPACE]) {
            //command sauter
        }

        if (activeKeys[Input.Keys.LEFT]) {
            //va gauche
        }
        else if (activeKeys[Input.Keys.RIGHT]) {
            //va droite
        }
        else {
            //bouge pas
        }

    }
}
