package com.nicolasbourre.gdx.basegamesetup;

/**
 * Created by zaktan on 16-11-18.
 */

public class CCourir extends Command {
    @Override
    void execute(Actor a) {
            a.setState(new StateCourir());
    }
}
