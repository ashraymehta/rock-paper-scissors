package com.ashraymehta.rockpaperscissors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppIntegrationTest {
    private PrintStream originalOut;

    @Mock
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(printStream);
    }

    @Test
    void shouldPlayRockPaperScissorsHundredTimes() {
        App.main(new String[]{});

        verify(printStream, times(100)).println(anyString());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
