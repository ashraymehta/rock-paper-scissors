package com.ashraymehta.rockpaperscissors.players;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RockingPlayerTest {
    @Test
    void shouldPlayRock() {
        assertThat(new RockingPlayer("Player 1").play(), is(PlayerSelection.ROCK));
    }
}