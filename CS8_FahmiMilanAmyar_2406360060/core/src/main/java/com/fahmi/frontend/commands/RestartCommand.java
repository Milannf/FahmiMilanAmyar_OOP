package com.fahmi.frontend.commands;

import com.fahmi.frontend.Player;
import com.fahmi.frontend.GameManager;

public class RestartCommand implements Command {

    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager) {
        this.player = player;
        this.gameManager = gameManager;
    }

    @Override
    public void execute() {
        if (player != null) {
            player.reset();
        }
        if (gameManager != null) {
            gameManager.setScore(0);
        }
    }
}
