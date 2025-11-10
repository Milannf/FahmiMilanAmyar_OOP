package com.fahmi.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.fahmi.frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser> {

    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(new Vector2(getScreenWidth(), 0), 100);
    }

    @Override
    protected void resetObject(VerticalLaser laser) {
        laser.setPosition(getScreenWidth(), 0);
        laser.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }

    private float getScreenWidth() {
        return 800f;
    }
}



