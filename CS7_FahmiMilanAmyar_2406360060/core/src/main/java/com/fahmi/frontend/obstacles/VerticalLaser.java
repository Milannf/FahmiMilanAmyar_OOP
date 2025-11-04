package com.fahmi.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class VerticalLaser extends BaseObstacle{
    public VerticalLaser(Vector2 startPosition, int length){
        super(startPosition, length);
    }
    public void initialize(Vector2 startPosition, int length){
        initialize(startPosition, length);
    }
    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
        poistion.set(poistion.x, poistion.y);
        poistion.setLength(length);
    }
    @Override
    public float getRenderWidth() {
        return WIDTH;
    }
    @Override
    public float getRenderHeight() {
        return length;
    }

    @Override
    public void updateCollider(){
        collider.set(poistion.x, poistion.y, length, WIDTH);
    }

}
