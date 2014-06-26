package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {

    @Test
    public void shouldPrintQuitMessageOnExecute() {
        PrintStream printStream = mock(PrintStream.class);
        Command command = new QuitCommand(printStream, false);
        command.execute();
        verify(printStream).println("Quitting Biblioteca");
    }
}
