package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class BibliotechaAppTest {

    @Test
    public void testLibraryStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        Authenticator auth = mock(Authenticator.class);
        BufferedReader reader = mock(BufferedReader.class);
        PrintStream printStream = mock(PrintStream.class);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(commandMenu, auth, reader, printStream);
        when(commandMenu.promptUser()).thenReturn("list").thenReturn("quit");

        bibliotechaApp.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu, atLeastOnce()).promptUser();
        verify(commandMenu).executeCommand("list");
    }
}
