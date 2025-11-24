package com.fahmi.frontend.factories;

import com.badlogic.gdx.utils.Array;
import com.fahmi.frontend.Coin;
import com.fahmi.frontend.pools.CoinPool;
import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;
    private Array<Coin> activeCoins;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.random = new Random();
        this.activeCoins = new Array<>();
    }

    public void createCoinPattern(float spawnX, float groundTopY) {
        if (random.nextFloat() < 0.3f) {
            float randomHeight = 100f + random.nextInt(200);
            float spawnY = groundTopY + randomHeight;

            for (int i = 0; i < 3; i++) {
                Coin coin = coinPool.obtain(spawnX + (i * 40f), spawnY);
                activeCoins.add(coin);
            }
        }
    }

    public Array<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        activeCoins.removeValue(coin, true);
        coinPool.release(coin);
    }

    public void releaseAll() {
        for (Coin coin : activeCoins) {
            coinPool.release(coin);
        }
        activeCoins.clear();
    }
}


