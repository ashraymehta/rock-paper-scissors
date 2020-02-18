package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

public class GameSummary {
    private final Player winner;
    private final Map<Player, PlayerSelection> selections;

    public GameSummary(Map<Player, PlayerSelection> selections, @Nullable Player winner) {
        this.selections = selections;
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSummary that = (GameSummary) o;
        return Objects.equals(winner, that.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winner);
    }
}
