package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class GameTest {
    private Game game;
    private Player firstPlayer;
    private Player secondPlayer;

    @BeforeEach
    void setUp() {
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        game = new Game(firstPlayer, secondPlayer);
    }

    @Test
    void shouldAskFirstPlayerAndSecondPlayerToPlay() {
        game.start();

        verify(firstPlayer, times(1)).play();
        verify(secondPlayer, times(1)).play();
    }

    @Test
    void shouldDetermineTheWinnerAsNobodyIfTheFirstPlayerAndSecondPlayerPlayTheSameThing() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(secondPlayer.play()).thenReturn(PlayerSelection.ROCK);

        final var winner = game.start();

        assertThat(winner, is(emptyOptional()));
    }
}