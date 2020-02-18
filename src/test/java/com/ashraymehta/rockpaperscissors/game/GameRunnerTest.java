package com.ashraymehta.rockpaperscissors.game;

import com.ashraymehta.rockpaperscissors.players.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameRunnerTest {

    @InjectMocks
    private GameRunner gameRunner;

    @Mock
    private Game game;

    @Test
    void shouldRunHundredIterationsOfGame() {
        final var firstPlayer = mock(Player.class);
        final var secondPlayer = mock(Player.class);

        gameRunner.run(firstPlayer, secondPlayer);

        verify(game, times(100)).start(firstPlayer, secondPlayer);
    }
}