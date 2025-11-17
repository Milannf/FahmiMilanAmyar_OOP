package com.fahmi.frontend.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fahmi.frontend.strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState {
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;
    private final BitmapFont font;
    private float timer;

    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
        this.timer = 2.0f;
    }

    @Override
    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        playingState.render(batch);

        batch.begin();
        font.draw(batch, "DIFFICULTY INCREASED!", Gdx.graphics.getWidth() / 2f - 70, Gdx.graphics.getHeight() / 2f + 20);
        font.draw(batch, newStrategy.getClass().getSimpleName(), Gdx.graphics.getWidth() / 2f - 50, Gdx.graphics.getHeight() / 2f - 20);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
