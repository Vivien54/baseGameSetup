package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class BaseGame extends ApplicationAdapter {

    SpriteBatch batch;

    float deltaTime;
    float elapsedTime = 0;

    Actor h;
    Actor m;

    @Override
    public void create() {
        batch = new SpriteBatch();
        h = new HomerActor();
        //m = new MarioActor();
        //m.getPhysic().setPosition(new Vector2(25,0));



    }

    @Override
    public void render() {
        deltaTime = Gdx.graphics.getDeltaTime();
        elapsedTime += deltaTime;

        update(deltaTime);
        draw(elapsedTime);
    }

    private void update(float deltaTime) {
        h.update(deltaTime);
        //m.update(deltaTime);
    }

    private void draw(float elapsedTime) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        h.display(batch);
        //m.display(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}