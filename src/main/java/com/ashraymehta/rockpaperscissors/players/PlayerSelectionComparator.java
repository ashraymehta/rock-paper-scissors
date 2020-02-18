package com.ashraymehta.rockpaperscissors.players;

import java.util.Comparator;
import java.util.Map;

public class PlayerSelectionComparator implements Comparator<PlayerSelection> {
    private final static int EQUALS = 0;
    private final static int LESS_THAN = -1;
    private final static int GREATER_THAN = 1;
    private static final Map<PlayerSelection, PlayerSelection> WHO_BEATS_WHOM = Map.of(
            PlayerSelection.ROCK, PlayerSelection.SCISSORS,
            PlayerSelection.PAPER, PlayerSelection.ROCK,
            PlayerSelection.SCISSORS, PlayerSelection.PAPER
    );

    @Override
    public int compare(PlayerSelection selection, PlayerSelection anotherSelection) {
        if (selection == anotherSelection) {
            return EQUALS;
        }
        return WHO_BEATS_WHOM.get(selection) == anotherSelection ? GREATER_THAN : LESS_THAN;
    }
}
