package com.fahmi.frontend;

import java.io.Console;

public class GameManager {
    private static GameManager instance;

    int score;
    boolean gameActive;

    private int SetScore(){
        return score = 0;
    }

    private boolean ActiveGame(){
        return gameActive = false;
    }

    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame(){
        score = 0;
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore){
        if (gameActive == true){
            score = newScore;
        }
    }

    public int getScore(){
        return score;
    }

    public boolean isGameActive() {
        return gameActive;
    }

}
