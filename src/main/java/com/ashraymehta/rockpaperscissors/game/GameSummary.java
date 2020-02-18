package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;

public class GameSummary {
    private final Player winner;
    private final Map<Player, PlayerSelection> selections;

    public GameSummary(@NotNull Map<Player, PlayerSelection> selections, @Nullable Player winner) {
        this.selections = selections;
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSummary that = (GameSummary) o;
        return Objects.equals(winner, that.winner) &&
                selections.equals(that.selections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winner, selections);
    }

    @Override
    public String toString() {
        final var stringBuilder = new StringBuilder();

        selections.forEach((key, value) -> {
            final var playerName = key.toString();
            stringBuilder.append(playerName)
                    .append(" selected: ")
                    .append(value)
                    .append(System.lineSeparator());
        });

        stringBuilder.append("Winner: ")
                .append(winner.toString())
                .append("!");

        return stringBuilder.toString();
    }
}
