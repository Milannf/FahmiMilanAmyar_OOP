package com.fahmi.frontend.observers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer {

    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver() {
        this.font = new BitmapFont();
        this.font.setColor(Color.WHITE);
        this.font.getData().setScale(1.5f);
        this.batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        Gdx.app.log("ScoreUI", "Score updated: " + score);
    }

    public void render(int score, int coins) {
        batch.begin();

        font.setColor(Color.WHITE);
        font.draw(batch, "Distance: " + score + "m", 20, Gdx.graphics.getHeight() - 20);

        font.setColor(Color.WHITE);
        font.draw(batch, "Coins: " + coins, 20, Gdx.graphics.getHeight() - 50);

        font.setColor(Color.WHITE);
        batch.end();
    }

    public void dispose() {
        if (font != null) {
            font.dispose();
        }
        if (batch != null) {
            batch.dispose();
        }
    }
}
