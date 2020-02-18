package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.io.Console;
import com.ashraymehta.rockpaperscissors.players.Player;
import com.ashraymehta.rockpaperscissors.players.PlayerSelection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameRunnerTest {

    @InjectMocks
    private GameRunner gameRunner;

    @Mock
    private Game game;

    @Mock
    private Console console;

    @Test
    void shouldPrintResultsForHundredIterationsOfGame() {
        final var firstPlayer = mock(Player.class);
        final var secondPlayer = mock(Player.class);
        final var gameSummary = new GameSummary(Map.of(firstPlayer, PlayerSelection.ROCK,
                secondPlayer, PlayerSelection.PAPER), secondPlayer);
        when(game.start(firstPlayer, secondPlayer)).thenReturn(gameSummary);

        gameRunner.run(firstPlayer, secondPlayer);

        verify(game, times(100)).start(firstPlayer, secondPlayer);
        verify(console, times(100)).writeLine(gameSummary.toString());
    }
}