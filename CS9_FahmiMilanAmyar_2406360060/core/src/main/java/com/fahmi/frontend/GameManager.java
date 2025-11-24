package com.fahmi.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.fahmi.frontend.observers.ScoreManager;
import com.fahmi.frontend.services.BackendService;

public class GameManager {
    private static GameManager instance;

    private ScoreManager scoreManager;
    private boolean gameActive;

    private BackendService backendService;
    private String currentPlayerId = null;
    private int coinsCollected = 0;

    private GameManager() {
        scoreManager = new ScoreManager();
        gameActive = false;
        backendService = new BackendService();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void registerPlayer(String username) {
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("GameManager", "Player ID Saved: " + currentPlayerId);
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "JSON Parse Error: " + e.getMessage());
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Registration Error: " + error);
            }
        });
    }

    public void startGame() {
        scoreManager.setScore(0);
        coinsCollected = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void endGame() {

        if (currentPlayerId == null) {
            Gdx.app.error("GameManager", "Cannot submit score: Player ID is null");
            return;
        }

        int distance = scoreManager.getScore();
        int finalScore = distance + (coinsCollected * 10);

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("GameManager", "Score Submitted Successfully: " + response);
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Score Submission Failed: " + error);
            }
        });
    }

    public void addCoin() {
        coinsCollected++;
        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }

    public void setScore(int distance) {
        if (gameActive) {
            scoreManager.setScore(distance);
        }
    }

    public int getScore() { return scoreManager.getScore(); }

    public int getCoins() { return coinsCollected; }

    public void addObserver(com.fahmi.frontend.observers.Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(com.fahmi.frontend.observers.Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
