package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class BibliotechaAppTest {

    @Test
    public void testLibraryStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        BibliotechaApp bibliotechaApp = new BibliotechaApp(commandMenu);
        when(commandMenu.promptUser()).thenReturn("list").thenReturn("quit");

        bibliotechaApp.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu, atLeastOnce()).promptUser();
        verify(commandMenu).executeCommand("list");
    }
}
