package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import com.ashraymehta.rockpaperscissors.players.PlayerSelectionComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
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
        game = new Game(playerSelectionComparator);
    }

    @Test
    void shouldAskFirstPlayerAndSecondPlayerToPlayInThatOrder() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.PAPER);
        when(secondPlayer.play()).thenReturn(PlayerSelection.ROCK);

        final var summary = game.start(firstPlayer, secondPlayer);

        verify(firstPlayer, times(1)).play();
        verify(secondPlayer, times(1)).play();
        final var selections = new LinkedHashMap<Player, PlayerSelection>();
        selections.put(firstPlayer, PlayerSelection.PAPER);
        selections.put(secondPlayer, PlayerSelection.ROCK);
        assertThat(summary, is(new GameSummary(selections, firstPlayer)));
    }

    @Test
    void shouldDetermineTheWinnerAsNobodyIfTheFirstPlayerAndSecondPlayerPlayTheSameThing() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(secondPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.ROCK)).thenReturn(0);

        final var gameSummary = game.start(firstPlayer, secondPlayer);

        final var expectedGameSummary = new GameSummary(Map.of(
                firstPlayer, PlayerSelection.ROCK,
                secondPlayer, PlayerSelection.ROCK
        ), null);
        assertThat(gameSummary, is(expectedGameSummary));
    }

    @Test
    void shouldDetermineTheWinnerAsFirstPlayerIfTheFirstPlayerBeatsTheSecondPlayer() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(secondPlayer.play()).thenReturn(PlayerSelection.SCISSORS);
        when(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.SCISSORS)).thenReturn(1);

        final var gameSummary = game.start(firstPlayer, secondPlayer);

        final var expectedGameSummary = new GameSummary(Map.of(
                firstPlayer, PlayerSelection.ROCK,
                secondPlayer, PlayerSelection.SCISSORS
        ), firstPlayer);
        assertThat(gameSummary, is(expectedGameSummary));
    }

    @Test
    void shouldDetermineTheWinnerAsSecondPlayerIfTheSecondPlayerBeatsTheFirstPlayer() {
        when(firstPlayer.play()).thenReturn(PlayerSelection.SCISSORS);
        when(secondPlayer.play()).thenReturn(PlayerSelection.ROCK);
        when(playerSelectionComparator.compare(PlayerSelection.SCISSORS, PlayerSelection.ROCK)).thenReturn(-1);

        final var gameSummary = game.start(firstPlayer, secondPlayer);

        final var expectedGameSummary = new GameSummary(Map.of(
                firstPlayer, PlayerSelection.SCISSORS,
                secondPlayer, PlayerSelection.ROCK
        ), secondPlayer);
        assertThat(gameSummary, is(expectedGameSummary));
    }
}