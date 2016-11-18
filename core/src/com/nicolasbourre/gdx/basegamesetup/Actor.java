package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class Actor {
   protected StateActor state;
   protected GraphComponent graphic = new GraphComponent();
   protected PhysicComponent physic = new PhysicComponent();
   protected InputComponent input = new InputComponent();

    Actor(String img){
    }

    void update(float deltaTime){
        input.update( deltaTime, this);
        physic.update(deltaTime, this);
    }

    void display(float deltaTime){
        graphic.update(deltaTime,this);
    }

    public StateActor getState() {
        return state;
    }

    public void setState(StateActor state) {
        this.state = state;
    }

}
