package com.ashraymehta.rockpaperscissors.players;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random;

    public RandomPlayer(Random random) {
        this.random = random;
    }

    @Override
    public PlayerSelection play() {
        final var playerSelections = PlayerSelection.values();
        return playerSelections[random.nextInt(playerSelections.length)];
    }
}