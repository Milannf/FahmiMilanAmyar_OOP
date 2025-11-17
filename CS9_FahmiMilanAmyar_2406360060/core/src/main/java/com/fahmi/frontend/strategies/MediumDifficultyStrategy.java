package com.fahmi.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class MediumDifficultyStrategy implements DifficultyStrategy {

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 2);
        weights.put("HorizontalLaser", 2);
        weights.put("HomingMissile", 1);
        return weights;
    }

    @Override
    public float getSpawnInterval() {
        return 1.5f;
    }

    @Override
    public float getDensity() {
        return 1.5f;
    }

    @Override
    public float getMinGap() {
        return 150f;
    }
}
