package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BaseGame extends ApplicationAdapter implements InputProcessor{

    SpriteBatch batch;

    float deltaTime;
    float elapsedTime = 0;

    static final int NB_KEYS = 256;
    boolean activeKeys[] = new boolean[NB_KEYS];

    Actor h;
    Actor m;

    @Override
    public void create() {
        batch = new SpriteBatch();

        this.initActiveKeys();
        h = new HomerActor();
        h.SetInputKey(activeKeys);
        h.setAllKey(Input.Keys.Q,Input.Keys.D,Input.Keys.SHIFT_LEFT, Input.Keys.SPACE);
        m = new MarioActor();
        m.SetInputKey(activeKeys);
        m.setAllKey(Input.Keys.LEFT,Input.Keys.RIGHT,Input.Keys.SHIFT_RIGHT, Input.Keys.UP);
        m.getPhysic().setPosition(new Vector2(25,0));



        Gdx.input.setInputProcessor(this);
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
        m.update(deltaTime);
    }

    private void draw(float elapsedTime) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        h.display(batch);
        m.display(batch);

        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        activeKeys[keycode] = true;
        Gdx.app.log(this.getClass().getSimpleName(), "Key down --> " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        activeKeys[keycode] = false;
        Gdx.app.log(this.getClass().getSimpleName(), "Key up --> " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void initActiveKeys() {
        for (int i = 0; i < activeKeys.length; i++) {
            activeKeys[i] = false;
        }
    }
}