package com.fahmi.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.fahmi.frontend.obstacles.BaseObstacle;
import com.fahmi.frontend.obstacles.HorizontalLaser;
import com.fahmi.frontend.pools.HorizontalLaserPool;

import java.util.List;
import java.util.Random;

public class HorizontalLaserCreator implements ObstacleFactory.ObstacleCreator {

    private static final float MIN_LENGTH = 100f;
    private static final float MAX_LENGTH = 300f;

    private final HorizontalLaserPool pool = new HorizontalLaserPool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float length = MIN_LENGTH + rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH);

        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;

        float randomY = minY + rng.nextFloat() * (maxY - minY);

        HorizontalLaser laser = pool.obtain(new Vector2(spawnX, randomY), (int) length);

        return laser;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof HorizontalLaser) {
            pool.release((HorizontalLaser) obstacle);
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
        return obstacle instanceof HorizontalLaser;
    }

    @Override
    public String getName() {
        return "HorizontalLaser";
    }
}
