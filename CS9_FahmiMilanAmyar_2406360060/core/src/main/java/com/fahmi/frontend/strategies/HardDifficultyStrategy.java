package com.fahmi.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy {

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 3);
        weights.put("HorizontalLaser", 3);
        weights.put("HomingMissile", 4);
        return weights;
    }

    @Override
    public float getSpawnInterval() {
        return 0.8f;
    }

    @Override
    public float getDensity() {
        return 2.5f;
    }

    @Override
    public float getMinGap() {
        return 100f;
    }
}
