package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.RockingPlayer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameSummaryTest {

    @Test
    void shouldEquateGameSummaryWithAnotherGameSummary() {
        final var winner = new RockingPlayer();
        final var aGameSummary = new GameSummary(winner);
        final var anotherGameSummary = new GameSummary(winner);

        assertEquals(aGameSummary, anotherGameSummary);
        assertThat(aGameSummary.hashCode(), is(anotherGameSummary.hashCode()));
    }
}