package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class StateSauter extends StateActor {
    StateSauter(){
        System.out.println(ToString());
    }
    @Override
    void execute(Actor a) {
        a.getPhysic().setVelocity(new Vector2(a.getPhysic().getVelocity().x, 2 * a.getPhysic().getSpeedFactor()));
    }

    @Override
    String ToString() {
        return "jumping";
    }
}
