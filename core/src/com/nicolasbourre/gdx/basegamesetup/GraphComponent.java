package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Created by zaktan on 16-11-18.
 */

public class GraphComponent extends Component {

    private HashMap<String, Animation> animations;
    private TextureRegion currentFrame;
    private String currentAnimation = "walking";//depends of state

    GraphComponent(){

    }

    @Override
    void update(float deltaTime) {

    }
}
