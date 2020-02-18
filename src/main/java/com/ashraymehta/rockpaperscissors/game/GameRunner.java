package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.io.Console;
import com.ashraymehta.rockpaperscissors.players.Player;

public class GameRunner {
    private final Game game;
    private final Console console;

    public GameRunner(Game game, Console console) {
        this.game = game;
        this.console = console;
    }

    public void run(Player firstPlayer, Player secondPlayer) {
        for (int counter = 0; counter < 100; counter++) {
            final var gameSummary = game.start(firstPlayer, secondPlayer);
            console.writeLine(gameSummary.toString());
        }
    }
}
