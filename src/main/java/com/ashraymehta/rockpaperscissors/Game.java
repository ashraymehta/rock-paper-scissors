package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;

import java.util.Optional;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer, PlayerSelectionComparator playerSelectionComparator) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Optional<Player> start() {
        firstPlayer.play();
        secondPlayer.play();
        return Optional.empty();
    }
}