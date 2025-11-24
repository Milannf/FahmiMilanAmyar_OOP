package com.fahmi.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.fahmi.frontend.Coin;

public class CoinPool extends ObjectPool<Coin>{
    @Override
    protected Coin createObject() {
        return new Coin(new Vector2(0,0));
    }

    @Override
    protected void resetObject(Coin object) {
        return Coin.setActive(false);
    }
    public Coin obtain(float x, float y){
        return super.obtain();
    }
}
