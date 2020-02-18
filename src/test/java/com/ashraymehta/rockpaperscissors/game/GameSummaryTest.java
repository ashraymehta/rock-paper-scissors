package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import com.ashraymehta.rockpaperscissors.players.RandomPlayer;
import com.ashraymehta.rockpaperscissors.players.RockingPlayer;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

class GameSummaryTest {

    @Test
    void shouldEquateGameSummaryWithAnotherGameSummary() {
        final var winner = new RockingPlayer("Player 1");
        final var anotherPlayer = new RockingPlayer("Player 2");
        final var selections = Map.of(
                ((Player) winner), PlayerSelection.ROCK,
                anotherPlayer, PlayerSelection.SCISSORS
        );
        final var aGameSummary = new GameSummary(selections, winner);
        final var anotherGameSummary = new GameSummary(selections, winner);

        assertEquals(aGameSummary, anotherGameSummary);
        assertEquals(aGameSummary, aGameSummary);
        assertThat(aGameSummary.hashCode(), is(anotherGameSummary.hashCode()));

        assertNotEquals(aGameSummary, new Object());
        assertNotEquals(aGameSummary, null);
        assertNotEquals(aGameSummary, new GameSummary(Map.of(), winner));
        assertNotEquals(aGameSummary, new GameSummary(Map.of(), anotherPlayer));
        assertNotEquals(aGameSummary.hashCode(), new GameSummary(Map.of(), winner).hashCode());
    }

    @Test
    void shouldHaveAStringRepresentationOfGameSummary() {
        final var winner = new RockingPlayer("Player 1");
        final var anotherPlayer = new RandomPlayer("Player 2", mock(Random.class));

        final var summary = new GameSummary(Map.of(winner, PlayerSelection.ROCK,
                anotherPlayer, PlayerSelection.SCISSORS), winner);

        assertThat(summary.toString(), is("Player 1 selected: ROCK" + System.lineSeparator() +
                "Player 2 selected: SCISSORS" + System.lineSeparator() +
                "Winner: Player 1!"));
    }
}