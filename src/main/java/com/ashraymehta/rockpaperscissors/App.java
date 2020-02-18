package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.game.Game;
import com.ashraymehta.rockpaperscissors.game.GameRunner;
import com.ashraymehta.rockpaperscissors.io.Console;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;
import com.ashraymehta.rockpaperscissors.players.RandomPlayer;
import com.ashraymehta.rockpaperscissors.players.RockingPlayer;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        final var gameRunner = new GameRunner(new Game(new PlayerSelectionComparator()), new Console());
        gameRunner.run(new RockingPlayer("Player 1"), new RandomPlayer("Player 2", new Random()));
    }
}
