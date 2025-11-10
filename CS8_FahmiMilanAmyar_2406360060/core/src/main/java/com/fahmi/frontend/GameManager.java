package com.fahmi.frontend;

import com.fahmi.frontend.observers.Observer;
import com.fahmi.frontend.observers.ScoreManager;

public class GameManager {

    private static GameManager instance;
    private ScoreManager scoreManager;

    private GameManager() {
        scoreManager = new ScoreManager();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void setScore(int score) {
        scoreManager.setScore(score);
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
