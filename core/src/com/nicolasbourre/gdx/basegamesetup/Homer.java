package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

/**
 * Created by nbourre on 2016-11-11.
 */

public class Homer {
    Vector2 velocity;
    Vector2 position;
    HashMap<String, Animation> animations;


    TextureRegion currentFrame;

    float elapsedTime = 0;

    boolean isFacingLeft = false;

    boolean activeKeys[];

    String currentAnimation = "walking";

    Homer() {
        velocity = new Vector2(0, 0);
        position = new Vector2(0, 0);

        animations = new HashMap<String, Animation>();


    }

    void update (float deltaTime) {
        elapsedTime += deltaTime;

        if (activeKeys[Input.Keys.SHIFT_LEFT]) {
            currentAnimation = "running";
        } else
        {
            currentAnimation = "walking";

        }

        if (activeKeys[Input.Keys.LEFT]) {
            isFacingLeft = true;
            velocity.x = -1;

        } else if (activeKeys[Input.Keys.RIGHT]) {
            isFacingLeft = false;
            velocity.x = 1;
        } else {
            velocity.x = 0;
            currentAnimation = "walking";
        }

        currentFrame = animations.get(currentAnimation).getKeyFrame(elapsedTime);



        position.add(velocity);

    //TODO : Convert to component based

    }

    void draw(SpriteBatch batch) {


        if(!isFacingLeft) {
            batch.draw(currentFrame, position.x, position.y);
        } else {

            batch.draw(currentFrame, position.x + currentFrame.getRegionWidth() , position.y, -currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        }
    }

    public void setActiveKeys(boolean[] activeKeys) {
        this.activeKeys = activeKeys;
    }

    void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }


}
