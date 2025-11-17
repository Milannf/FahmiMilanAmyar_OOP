package com.fahmi.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class VerticalLaser extends BaseObstacle {
    public VerticalLaser(Vector2 startPosition, int length) {
        super(startPosition, length);
    }

    @Override
    public void initialize(Vector2 startPosition, int length) {
        super.initialize(startPosition, length);
    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, WIDTH, length);
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
    protected void updateCollider() {
        if (collider == null) {
            collider = new Rectangle(position.x, position.y, WIDTH, length);
        } else {
            collider.set(position.x, position.y, WIDTH, length);
        }
    }
}
