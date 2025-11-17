package com.fahmi.frontend.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState {
    private final GameStateManager gsm;
    private final BitmapFont font;

    public GameOverState(GameStateManager gsm) {
        this.gsm = gsm;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gsm.set(new PlayingState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        font.draw(batch, "GAME OVER", Gdx.graphics.getWidth() / 2f - 40, Gdx.graphics.getHeight() / 2f);
        font.draw(batch, "Press SPACE to restart", Gdx.graphics.getWidth() / 2f - 80, Gdx.graphics.getHeight() / 2f - 40);
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
