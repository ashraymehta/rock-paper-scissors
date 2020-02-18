package com.ashraymehta.rockpaperscissors.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleTest {

    @Mock
    private PrintStream printStream;

    @Test
    void shouldWriteToSystemOut() {
        final var originalOut = System.out;
        System.setOut(printStream);
        final var message = "Some text";

        new Console().writeLine(message);

        verify(printStream, times(1)).println(message);
        System.setOut(originalOut);
    }
}