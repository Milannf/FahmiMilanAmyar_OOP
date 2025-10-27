package com.fahmi.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class Ground {
    static float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    public Ground() {
        collider = new Rectangle(0, 0, 2 * Gdx.graphics.getWidth(), (int)GROUND_HEIGHT);
    }

    public void update(float cameraX){
        float one = cameraX - Gdx.graphics.getWidth() / 2f - 500;

        collider.x = (int) one;
        collider.y = 0;
    }

    public boolean isColliding(Rectangle playerCollider){
        if (collider.overlaps(playerCollider)){
            return true;
        }
        return false;
    }

    public float getTopY(){
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shapeRenderer){

        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(collider.x, collider.y, Gdx.graphics.getWidth(), GROUND_HEIGHT);
    }

}
