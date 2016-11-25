package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by zaktan on 16-11-18.
 */

public class GraphComponent extends Component {

    private HashMap<String, Animation> animations;
    private TextureRegion currentFrame;
    private String currentAnimation;

    private float elapsedTime = 0;

    public GraphComponent(){
        animations = new HashMap<String, Animation>();
    }

    @Override
    void update(float deltaTime, Actor a) {
        elapsedTime+=deltaTime;
        if(a.getState().ToString().equals("jumping"))
            currentAnimation="running";
        else
            currentAnimation=a.getState().ToString();
        //System.out.println(a.ActorName() + "  " + currentAnimation);
        currentFrame = animations.get(currentAnimation).getKeyFrame(elapsedTime);
    }

    public void draw(SpriteBatch batch, Actor a) {
        if(!a.getInput().isFacingLeft()) {
            batch.draw(currentFrame, a.getPhysic().getPosition().x, a.getPhysic().getPosition().y);
        }
        else {

            batch.draw(currentFrame, a.getPhysic().getPosition().x + currentFrame.getRegionWidth(), a.getPhysic().getPosition().y, -currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        }
    }

    public void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }
}
