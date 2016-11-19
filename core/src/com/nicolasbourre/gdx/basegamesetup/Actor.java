package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class Actor {
   protected StateActor state;
   protected GraphComponent graphic = new GraphComponent();
   protected PhysicComponent physic = new PhysicComponent();
   protected InputComponent input = new InputComponent();

    Actor(){
    }

    void update(float deltaTime){
    }

    void display(SpriteBatch batch){
    }

    public StateActor getState() {
        return state;
    }

    public void setState(StateActor state) {
        this.state = state;
    }

    public GraphComponent getGraphic() {
        return graphic;
    }

    public PhysicComponent getPhysic() {
        return physic;
    }

    public InputComponent getInput() {
        return input;
    }
}
