package com.fahmi.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    Vector2 poistion;
    Rectangle collider;
    float length;
    final float WIDTH = 50;
    boolean active = false;

    public BaseObstacle(Vector2 startPosition, int length){
        this.poistion = startPosition;
        this.length = length;
        updateCollider();
    }

    public void initialize(Vector2 startPosition, int length){

    }

    public void render(ShapeRenderer shapeRenderer){
        if (active){
            drawShape(shapeRenderer);
        }
    }

    public boolean isActive(){
        return active;
    }

    public boolean isOffScreenCamera(float cameraLeftEdge){
        if (cameraLeftEdge.getRenderWidth() < WIDTH){
            return active = true;
        }
        else{return false;}
    }
    public abstract void drawShape(ShapeRenderer shapeRenderer);

    public abstract float getRenderWidth();

    public abstract float getRenderHeight();

    public boolean setActive(boolean active){
        return active = true;
    }

    public float setPosition(float x, float y){
        collider.setX(x);
        collider.setY(y);
    }

    public abstract void updateCollider();

    public Vector2 getPosition(){
        return poistion;
    }

}
