package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.players.Player;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GameTest {

    @Test
    void shouldAskFirstPlayerAndSecondPlayerToPlay() {
        final var firstPlayer = mock(Player.class);
        final var secondPlayer = mock(Player.class);
        final var game = new Game(firstPlayer, secondPlayer);

        game.start();

        verify(firstPlayer, times(1)).play();
        verify(secondPlayer, times(1)).play();
    }
}