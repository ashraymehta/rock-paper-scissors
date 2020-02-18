package com.ashraymehta.rockpaperscissors.players;

public class RockingPlayer extends Player {
    public RockingPlayer(String name) {
        super(name);
    }

    @Override
    public PlayerSelection play() {
        return PlayerSelection.ROCK;
    }
}
