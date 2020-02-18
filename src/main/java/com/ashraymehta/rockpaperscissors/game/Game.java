package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;

public class Game {
    private final PlayerSelectionComparator playerSelectionComparator;

    public Game(PlayerSelectionComparator playerSelectionComparator) {
        this.playerSelectionComparator = playerSelectionComparator;
    }

    public GameSummary determineWinner(Player firstPlayer, Player secondPlayer) {
        final var comparisonResult = playerSelectionComparator.compare(firstPlayer.play(), secondPlayer.play());
        if (comparisonResult > 0) {
//            return Optional.of(firstPlayer);
        } else if (comparisonResult < 0) {
//            return Optional.of(secondPlayer);
        } else {
//            return Optional.empty();
        }
        return null;
    }
}