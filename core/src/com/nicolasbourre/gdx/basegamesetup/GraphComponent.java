package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by zaktan on 16-11-18.
 */

public class GraphComponent extends Component {

    private HashMap<String, Animation> animations;
    private TextureRegion currentFrame;

    GraphComponent(){
        animations = new HashMap<String, Animation>();
    }

    @Override
    void update(float deltaTime, Actor a) {

    }

    void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }
}
