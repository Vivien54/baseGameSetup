package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class StateCourir extends StateActor {
    @Override
    void execute(Actor a) {
        a.getPhysic().setSpeedFactor(2f);

        if (a.getInput().getActiveKeys()[a.getGoLeftKey()]) {
            a.getPhysic().setVelocity(new Vector2( -1 * a.getPhysic().getSpeedFactor(), a.getPhysic().getVelocity().y));
        }
        else if (a.getInput().getActiveKeys()[a.getGoRightKey()]) {
            a.getPhysic().setVelocity(new Vector2( 1 * a.getPhysic().getSpeedFactor(), a.getPhysic().getVelocity().y));
        }
        else {
            a.getPhysic().setVelocity(new Vector2( 0, a.getPhysic().getVelocity().y));
        }
    }

    @Override
    void exit(Actor a) {

    }

    @Override
    String ToString() {
        return "running";
    }
}
