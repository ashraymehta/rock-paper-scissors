package com.ashraymehta.rockpaperscissors.players;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PlayerTest {
    @Test
    void shouldHaveStringRepresentationAsItsName() {
        final var name = "Rocking Player";

        assertThat(new RockingPlayer(name).toString(), is(name));
    }
}