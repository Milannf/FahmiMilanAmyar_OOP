package com.fahmi.frontend.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fahmi.frontend.GameManager;

public class GameOverState implements GameState {
    private GameStateManager gsm;
    private BitmapFont font;
    private GlyphLayout layout;

    public GameOverState(GameStateManager gsm) {
        this.gsm = gsm;
        this.font = new BitmapFont();
        this.font.setColor(Color.WHITE);
        this.font.getData().setScale(2f);
        this.layout = new GlyphLayout();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();

        String gameOverText = "GAME OVER";
        String scoreText = "Score: " + GameManager.getInstance().getScore();
        String tapText = "Tap to Restart";

        layout.setText(font, gameOverText);
        float w = layout.width;
        font.setColor(Color.RED);
        font.draw(batch, gameOverText, (Gdx.graphics.getWidth() - w) / 2, Gdx.graphics.getHeight() / 2 + 50);

        layout.setText(font, scoreText);
        w = layout.width;
        font.setColor(Color.YELLOW);
        font.draw(batch, scoreText, (Gdx.graphics.getWidth() - w) / 2, Gdx.graphics.getHeight() / 2);

        layout.setText(font, tapText);
        w = layout.width;
        font.setColor(Color.WHITE);
        font.draw(batch, tapText, (Gdx.graphics.getWidth() - w) / 2, Gdx.graphics.getHeight() / 2 - 50);

        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
