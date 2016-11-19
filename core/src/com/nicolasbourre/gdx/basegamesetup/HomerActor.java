package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by zaktan on 16-11-18.
 */

public class HomerActor extends Actor {

    TextureAtlas atlasWalking;
    Animation walkAnimation;

    TextureAtlas atlasRunning;
    Animation runAnimation;

    //TextureAtlas atlasStanding;
    //Animation standAnimation;

    HomerActor() {

        //input.setActiveKeys(input.getActiveKeys());
        initTextures();

        graphic.addAnimation("walking", walkAnimation);
        graphic.addAnimation("running", runAnimation);

        state = new StateMarcher();
    }

    public void initTextures(){
        atlasWalking = new TextureAtlas("homer_walking.txt");
        walkAnimation = new Animation(1 / 8f, atlasWalking.getRegions());
        walkAnimation.setPlayMode(Animation.PlayMode.LOOP);


        atlasRunning = new TextureAtlas("homer_running.txt");
        runAnimation = new Animation(1 / 8f, atlasRunning.getRegions());
        runAnimation.setPlayMode(Animation.PlayMode.LOOP);

        /*atlasStanding = new TextureAtlas("homer_standing.txt");
        standAnimation = new Animation(1 / 8f, atlasStanding.getRegions());
        standAnimation.setPlayMode(Animation.PlayMode.NORMAL);*/
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


}
