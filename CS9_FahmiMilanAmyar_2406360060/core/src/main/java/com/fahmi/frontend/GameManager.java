package com.fahmi.frontend;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.fahmi.frontend.observers.ScoreManager;
import com.fahmi.frontend.services.BackendService;

import java.io.Console;

public class GameManager {
    private static GameManager instance;

    private ScoreManager scoreManager;
    private boolean gameActive;
    private BackendService backendService;
    private String currentPlayerId = null;
    private int coinsCollected;

    private GameManager() {
        scoreManager = new ScoreManager();
        gameActive = false;
        backendService = new BackendService();
    }

    public registerPlayer(String username){
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    new JsonReader().parse(response);
                    currentPlayerId = response;
                    Gdx.app.log(String(response));

                } catch(Exception e){
                    Gdx.app.error;



                }

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public endGame(){
        if(currentPlayerId == null){
            return System.out.println("Cannot submit score");

        }
        scoreManager += coinsCollected;

    }

    public addCoin(){
        ++ coinsCollected;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        scoreManager.setScore(0);
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore) {
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    // Getters
    public int getScore() { return scoreManager.getScore(); }

    // Delegate observer methods to ScoreManager
    public void addObserver(com.fahmi.frontend.observers.Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(com.fahmi.frontend.observers.Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
