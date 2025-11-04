package com.fahmi.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.fahmi.frontend.Player;

public class HomingMissile extends BaseObstacle{
    Player target;
    Vector2 velocity;
    float speed = 200f;
    float width = 40f;
    float height = 20f;

    public HomingMissile(Vector2 startPosition, int length) {
        super(startPosition, length);
        this.velocity = velocity;
    }

    public void initialie(Vector2 startPosition, int length){
        velocity.set(0, 0);
    }

    public void setTarget(Player target){

    }



    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
    }
    @Override
    public float getRenderWidth() {
        return 0;
    }
    @Override
    public float getRenderHeight() {
        return 0;
    }
    @Override
    public void updateCollider() {
    }
}
