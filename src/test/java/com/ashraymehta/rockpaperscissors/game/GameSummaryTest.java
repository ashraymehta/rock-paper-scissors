package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.RockingPlayer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameSummaryTest {

    @Test
    void shouldEquateGameSummaryWithAnotherGameSummary() {
        final var winner = new RockingPlayer();
        final var aGameSummary = new GameSummary(winner);
        final var anotherGameSummary = new GameSummary(winner);

        assertEquals(aGameSummary, anotherGameSummary);
        assertEquals(aGameSummary, aGameSummary);
        assertThat(aGameSummary.hashCode(), is(anotherGameSummary.hashCode()));

        assertNotEquals(aGameSummary, new Object());
        assertNotEquals(aGameSummary, null);
    }
}