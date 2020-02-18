package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;

import java.util.Optional;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final PlayerSelectionComparator playerSelectionComparator;

    public Game(Player firstPlayer, Player secondPlayer, PlayerSelectionComparator playerSelectionComparator) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.playerSelectionComparator = playerSelectionComparator;
    }

    public Optional<Player> start() {
        final var comparisonResult = playerSelectionComparator.compare(firstPlayer.play(), secondPlayer.play());
        if (comparisonResult > 0) {
            return Optional.of(firstPlayer);
        }
        return Optional.empty();
    }
}