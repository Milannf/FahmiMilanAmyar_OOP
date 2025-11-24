package com.fahmi.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    boolean active;
    private float bobOffset;
    private float bobSpeed;

    public Coin(Vector2 startPosition){
        this.collider = collider;

    }
    public void update(float delta){
        collider.y = bobSpeed * delta;
    }
    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.circle(collider.x, collider.y, radius);
        shapeRenderer.setColor(Color.YELLOW);
    }
    public boolean isColliding(Rectangle playerCollider){
        if (isColliding(playerCollider) && active == true){
            return true;
        }
        return false;
    }




}
