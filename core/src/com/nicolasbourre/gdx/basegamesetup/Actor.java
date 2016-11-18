package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class Actor {
   protected StateActor state;
   protected Component graphic = new GraphComponent();
   protected Component physic = new PhysicComponent();
   protected Component input = new InputComponent();

    Actor(String img){

    }

    void update(){

    }

    void display(){

    }

}
