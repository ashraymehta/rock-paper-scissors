package com.ashraymehta.rockpaperscissors.players;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomPlayerTest {

    @InjectMocks
    private RandomPlayer randomPlayer;

    @Mock
    private Random random;

    @Test
    void shouldPlayRandomly() {
        when(random.nextInt(3)).thenReturn(1);

        final var playedValue = randomPlayer.play();

        assertThat(playedValue, is(PlayerSelection.PAPER));
    }
}