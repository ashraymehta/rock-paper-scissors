package com.ashraymehta.rockpaperscissors.players;

import java.util.Comparator;
import java.util.Map;

public class PlayerSelectionComparator implements Comparator<PlayerSelection> {
    private static final Map<PlayerSelection, PlayerSelection> WHO_BEATS_WHOM = Map.of(
            PlayerSelection.ROCK, PlayerSelection.SCISSORS
    );

    @Override
    public int compare(PlayerSelection selection, PlayerSelection anotherSelection) {
        return WHO_BEATS_WHOM.get(selection) == anotherSelection ? 1 : -1;
    }
}
