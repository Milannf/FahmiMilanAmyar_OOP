package com.fahmi.frontend.strategies;

import com.fahmi.frontend.Coin;
import com.fahmi.frontend.factories.CoinFactory;
import java.util.List;

public interface CoinPattern {
    List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight);

    String getName();
}
