package com.ashraymehta.rockpaperscissors.players;

public abstract class Player {
    private final String name;

    protected Player(String name) {
        this.name = name;
    }

    public abstract PlayerSelection play();

    @Override
    public String toString() {
        return name;
    }
}