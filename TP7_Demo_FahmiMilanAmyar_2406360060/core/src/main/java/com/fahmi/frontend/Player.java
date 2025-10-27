package com.fahmi.frontend;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    Vector2 position;
    Vector2 velocity;
    float gravity = 2000f;
    float maxVertical = 700f;
    Rectangle collider;
    float width = 64f;
    float height = 64f;
    float baseSpeed = 300f;
    float distanceTraveled = 0f;

    public Player(Vector2 position, Vector2 velocity, Rectangle collider){
        this.position = position;
        this.velocity = velocity;
        this.collider = collider;
    }
    public void update(float delta, boolean isFlying){

    }
    private void updateDistanceAndSpeed(float delta){
        baseSpeed = baseSpeed * delta;
    }
    private void updatePosition(float delta){
        position.x = velocity.x * delta;
        position.y = velocity.y * delta;
    }

    private void applyGravity(float delta){
        velocity.y = gravity - delta;
        velocity.x = baseSpeed;
    }

}

