package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by zaktan on 16-11-18.
 */

public class MarioActor extends Actor {

    TextureAtlas atlasWalking;
    Animation walkAnimation;

    TextureAtlas atlasRunning;
    Animation runAnimation;

    TextureAtlas atlasStanding;
    Animation standAnimation;

    MarioActor() {

        //input.initActiveKeys();
        initTextures();
        graphic.addAnimation("walking", walkAnimation);
        graphic.addAnimation("running", runAnimation);
        graphic.addAnimation("standing", standAnimation);

        state = new StateCourir();
    }

    public void initTextures(){
        atlasWalking = new TextureAtlas("mario.txt");
        walkAnimation = new Animation(1 / 8f, atlasWalking.getRegions());
        walkAnimation.setPlayMode(Animation.PlayMode.LOOP);

        atlasRunning = new TextureAtlas("mario.txt");
        runAnimation = new Animation(1 / 8f, atlasRunning.getRegions());
        runAnimation.setPlayMode(Animation.PlayMode.LOOP);

        atlasStanding = new TextureAtlas("mario.txt");
        standAnimation = new Animation(1 / 8f, atlasStanding.getRegions());
        standAnimation.setPlayMode(Animation.PlayMode.NORMAL);
    }

    @Override
    void update(float deltaTime){
        input.update( deltaTime, this);
        state.execute(this);
        physic.update(deltaTime, this);
        graphic.update(deltaTime, this);
    }

    @Override
    void display(SpriteBatch batch){
        graphic.draw(batch, this);
    }
    @Override
    public String ActorName(){
        return "MARIO";
    }
}
