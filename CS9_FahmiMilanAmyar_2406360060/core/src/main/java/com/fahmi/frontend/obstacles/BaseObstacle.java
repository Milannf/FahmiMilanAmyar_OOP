package com.fahmi.frontend.obstacles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    protected Vector2 position;
    protected Rectangle collider;
    protected float length;

    protected final float WIDTH = 10f;
    protected boolean active = false;

    public BaseObstacle(Vector2 startPosition, int length) {
        this.position = new Vector2(startPosition);
        this.length = length;
        updateCollider();
    }

    public void initialize(Vector2 startPosition, int length) {
        this.position.set(startPosition);
        this.length = length;
        updateCollider();
    }

    public void render(ShapeRenderer shapeRenderer) {
        if (active) {
            drawShape(shapeRenderer);
        }
    }
    public void render(SpriteBatch batch) {
    }

    public void update(float delta) {
        position.x -= 300 * delta;
        updateCollider();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isColliding(Rectangle playerCollider) {
        return active && collider.overlaps(playerCollider);
    }

    public boolean isOffScreenCamera(float cameraLeftEdge) {
        return (position.x + getRenderWidth() < cameraLeftEdge);
    }

    protected abstract void updateCollider();

    protected abstract void drawShape(ShapeRenderer shapeRenderer);

    public abstract float getRenderWidth();

    public abstract float getRenderHeight();

    public void setPosition(float x, float y) {
        position.set(x, y);
        updateCollider();
    }

    public Rectangle getCollider() {
        return collider;
    }

    public Vector2 getPosition() {
        return position;
    }
}
