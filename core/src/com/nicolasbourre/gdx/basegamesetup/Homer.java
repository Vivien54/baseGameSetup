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
    private Vector2 velocity;
    private Vector2 position;
    private HashMap<String, Animation> animations;


    private TextureRegion currentFrame;

    private float elapsedTime = 0;

    private boolean isFacingLeft = false;
    private boolean isJumping = false;

    private boolean activeKeys[];

    private float speedFactor = 1;

    private String currentAnimation = "walking";

    Homer() {
        velocity = new Vector2(0, 0);
        position = new Vector2(0, 0);

        animations = new HashMap<String, Animation>();
    }

    void update(float deltaTime) {
        elapsedTime += deltaTime;

        if (activeKeys[Input.Keys.SHIFT_LEFT]) {
            currentAnimation = "running";
            speedFactor = 2f;
        }
        else
        {
            currentAnimation = "walking";
            speedFactor = 1f;
        }

        if (activeKeys[Input.Keys.SPACE]) {
            isJumping = true;

            currentAnimation = "running";
            velocity.y = 2 * speedFactor;
        }

        if (activeKeys[Input.Keys.LEFT]) {
            isFacingLeft = true;
            velocity.x = -1 * speedFactor;

        }
        else if (activeKeys[Input.Keys.RIGHT]) {
            isFacingLeft = false;
            velocity.x = 1* speedFactor;
        }
        else {
            velocity.x = 0;
            currentAnimation = "walking";
        }

        currentFrame = animations.get(currentAnimation).getKeyFrame(elapsedTime);

        position.add(velocity);

        if (isJumping) {
            velocity.y -= 0.1;

            if (position.y < 1) {
                isJumping = false;
                velocity.y = 0;
            }
        }

    }

    public void draw(SpriteBatch batch) {

        if(!isFacingLeft) {
            batch.draw(currentFrame, position.x, position.y);
        }
        else {

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
