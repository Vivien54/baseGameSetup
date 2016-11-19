package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.math.Vector2;

import javax.swing.plaf.nimbus.State;

/**
 * Created by zaktan on 16-11-18.
 */

public class StateSauter extends StateActor {
    @Override
    void execute(Actor a) {
        a.getPhysic().setVelocity(new Vector2(a.getPhysic().getVelocity().x, 2 * a.getPhysic().getSpeedFactor()));
    }

    @Override
    void exit(Actor a) {

    }

    @Override
    String ToString() {
        return "jumping";
    }
}
