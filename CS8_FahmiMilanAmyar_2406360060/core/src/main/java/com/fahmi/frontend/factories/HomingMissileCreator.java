package com.fahmi.frontend.factories;

import com.fahmi.frontend.obstacles.BaseObstacle;
import com.fahmi.frontend.obstacles.HomingMissile;
import com.fahmi.frontend.pools.HomingMissilePool;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Random;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator {

    private final HomingMissilePool pool = new HomingMissilePool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float randomY = groundTopY + rng.nextFloat() * (800 - groundTopY);
        HomingMissile missile = pool.obtain(new Vector2(spawnX, randomY));
        return missile;
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof HomingMissile) {
            pool.release((HomingMissile) obstacle);
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
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
