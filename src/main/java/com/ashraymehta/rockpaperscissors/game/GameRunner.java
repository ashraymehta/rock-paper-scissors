package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;

public class GameRunner {
    private final Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    public void run(Player firstPlayer, Player secondPlayer) {
        for (int counter = 0; counter < 100; counter++) {
            game.start(firstPlayer, secondPlayer);
        }
    }
}
