package com.fahmi.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy {

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 1);
        weights.put("HorizontalLaser", 1);
        return weights;
    }

    @Override
    public float getSpawnInterval() {
        return 2.0f;
    }

    @Override
    public float getDensity() {
        return 1.0f;
    }

    @Override
    public float getMinGap() {
        return 200f;
    }
}
