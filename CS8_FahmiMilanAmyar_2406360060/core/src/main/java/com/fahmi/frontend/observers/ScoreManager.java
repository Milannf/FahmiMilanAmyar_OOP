package com.fahmi.frontend.observers;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private int score = 0;

    public ScoreManager() {
        this.observers = new ArrayList<>();
        this.score = 0;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int score) {
        for (Observer observer : observers) {
            observer.update(score);
        }
    }

    public void setScore(int newScore) {
        if (newScore != this.score) {
            this.score = newScore;
            notifyObservers(this.score);
        }
    }

    public int getScore() {
        return this.score;
    }
}
