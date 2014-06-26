package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.InOrder;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void shouldPrintWelcomeListOptionsAndTakeCommandsOnStart() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        PrintStream printStream = mock(PrintStream.class);
        BibliotecaApp bibliotechaApp = new BibliotecaApp(commandMenu, printStream);
        when(commandMenu.promptUser()).thenReturn("list books").thenReturn("quit");

        bibliotechaApp.start();

        InOrder inOrder = inOrder(printStream, commandMenu);
        inOrder.verify(printStream).println("Welcome to the library!");
        inOrder.verify(commandMenu).listOptions();
        inOrder.verify(commandMenu, times(2)).promptUser();
        inOrder.verify(commandMenu, times(1)).executeCommand(anyString());
    }
}
