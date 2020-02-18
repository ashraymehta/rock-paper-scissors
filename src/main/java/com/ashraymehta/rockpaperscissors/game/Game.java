package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;

public class Game {
    private final PlayerSelectionComparator playerSelectionComparator;

    public Game(PlayerSelectionComparator playerSelectionComparator) {
        this.playerSelectionComparator = playerSelectionComparator;
    }

    public GameSummary start(Player firstPlayer, Player secondPlayer) {
        final var comparisonResult = playerSelectionComparator.compare(firstPlayer.play(), secondPlayer.play());
        if (comparisonResult > 0) {
            return new GameSummary(firstPlayer);
        } else if (comparisonResult < 0) {
            return new GameSummary(secondPlayer);
        } else {
            return new GameSummary(null);
        }
    }
}