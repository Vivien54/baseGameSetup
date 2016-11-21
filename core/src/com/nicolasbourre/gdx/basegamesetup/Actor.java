package com.nicolasbourre.gdx.basegamesetup;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by zaktan on 16-11-18.
 */

public class Actor {
   protected StateActor state;
   protected GraphComponent graphic = new GraphComponent();
   protected PhysicComponent physic = new PhysicComponent();
   protected InputComponent input = new InputComponent();

    private int RunKey;
    private int GoLeftKey;
    private int GoRightKey;
    private int JumpKey;

    Actor(){
        RunKey = Input.Keys.SHIFT_LEFT;
        GoLeftKey = Input.Keys.LEFT;
        GoRightKey = Input.Keys.RIGHT;
        JumpKey = Input.Keys.SPACE;
    }

    void update(float deltaTime){
    }

    void display(SpriteBatch batch){
    }

    public StateActor getState() {
        return state;
    }

    public void setState(StateActor state) {
        this.state = state;
    }

    public GraphComponent getGraphic() {
        return graphic;
    }

    public PhysicComponent getPhysic() {
        return physic;
    }

    public InputComponent getInput() {
        return input;
    }

    void SetInputKey(boolean key[]){
        input.setActiveKeys(key);
    }

    public int getRunKey() {
        return RunKey;
    }

    public int getGoLeftKey() {
        return GoLeftKey;
    }

    public int getGoRightKey() {
        return GoRightKey;
    }

    public int getJumpKey() {
        return JumpKey;
    }

    public void setAllKey(int left, int right, int run, int jump){
        this.GoLeftKey = left;
        this.GoRightKey=right;
        this.RunKey=run;
        this.JumpKey=jump;
    }

    public String ActorName(){
        return "ACTOR";
    }
}
