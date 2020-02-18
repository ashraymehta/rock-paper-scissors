package com.ashraymehta.rockpaperscissors.players;

import java.util.Random;

public class RandomPlayer extends Player {
    private final Random random;

    public RandomPlayer(String name, Random random) {
        super(name);
        this.random = random;
    }

    @Override
    public PlayerSelection play() {
        final var playerSelections = PlayerSelection.values();
        return playerSelections[random.nextInt(playerSelections.length)];
    }
}