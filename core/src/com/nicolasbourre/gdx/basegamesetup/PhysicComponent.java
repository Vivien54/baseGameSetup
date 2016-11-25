package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class PhysicComponent extends Component {
    private Vector2 velocity;
    private Vector2 position;

    private float speedFactor = 1;

    public PhysicComponent(){
        velocity = new Vector2(0,0);
        position = new Vector2(0,0);
    }

    @Override
    void update(float deltaTime, Actor a) {
        position.add(velocity);

        if (a.getInput().isJumping()) {
            velocity.y -= 0.1;

            if (position.y < 1) {
                a.getInput().setJumping(false);
                velocity.y = 0;
            }
        }
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(float speedFactor) {
        this.speedFactor = speedFactor;
    }
}
