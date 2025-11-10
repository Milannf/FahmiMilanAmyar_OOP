package com.fahmi.frontend.factories;

import com.badlogic.gdx.math.Vector2;
import com.fahmi.frontend.obstacles.BaseObstacle;
import com.fahmi.frontend.obstacles.VerticalLaser;
import com.fahmi.frontend.pools.VerticalLaserPool;

import java.util.List;
import java.util.Random;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {

    private static final float MIN_LENGTH = 100f;
    private static final float MAX_LENGTH = 300f;

    private final VerticalLaserPool pool = new VerticalLaserPool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random randomSeed) {
        Random rng = (randomSeed != null) ? randomSeed : new Random();

        float length = MIN_LENGTH + rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH);

        Vector2 position = new Vector2(spawnX, groundTopY + playerHeight);

        VerticalLaser laser = pool.obtain(position, (int) length);

        laser.setActive(true);

        return laser;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof VerticalLaser) {
            pool.release((VerticalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<? extends BaseObstacle> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
