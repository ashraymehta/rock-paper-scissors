package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;

import java.util.Map;

public class Game {
    private final PlayerSelectionComparator playerSelectionComparator;

    public Game(PlayerSelectionComparator playerSelectionComparator) {
        this.playerSelectionComparator = playerSelectionComparator;
    }

    public GameSummary start(Player firstPlayer, Player secondPlayer) {
        final var selections = Map.of(firstPlayer, firstPlayer.play(), secondPlayer, secondPlayer.play());

        final var comparisonResult = playerSelectionComparator.compare(selections.get(firstPlayer),
                selections.get(secondPlayer));
        if (comparisonResult > 0) {
            return new GameSummary(selections, firstPlayer);
        } else if (comparisonResult < 0) {
            return new GameSummary(selections, secondPlayer);
        } else {
            return new GameSummary(selections, null);
        }
    }
}