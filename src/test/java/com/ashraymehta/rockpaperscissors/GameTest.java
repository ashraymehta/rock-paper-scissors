package com.ashraymehta.rockpaperscissors;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static com.spotify.hamcrest.optional.OptionalMatchers.optionalWithValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class GameTest {
    private Game game;
    private Player firstPlayer;
    private Player secondPlayer;
    private PlayerSelectionComparator playerSelectionComparator;

    @BeforeEach
    void setUp() {
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        playerSelectionComparator = mock(PlayerSelectionComparator.class);
        game = new Game(firstPlayer, secondPlayer, playerSelectionComparator);
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
        when(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.ROCK)).thenReturn(0);

        final var winner = game.start();

        assertThat(winner, is(emptyOptional()));
    }

    @Test
    void shouldDetermineTheWinnerAsFirstPlayerIfTheFirstPlayerBeatsTheSecondPlayer() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(secondPlayer.play()).thenReturn(PlayerSelection.SCISSORS);
        when(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.SCISSORS)).thenReturn(1);

        final var winner = game.start();

        assertThat(winner, is(optionalWithValue(equalTo(firstPlayer))));
    }
}