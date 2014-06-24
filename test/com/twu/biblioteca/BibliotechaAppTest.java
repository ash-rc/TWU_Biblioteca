package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.InOrder;

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
        PrintStream printStream = mock(PrintStream.class);
        Session session = mock(Session.class);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(commandMenu, printStream, session);
        when(session.login()).thenReturn(true);
        when(commandMenu.promptUser()).thenReturn("list").thenReturn("quit");

        bibliotechaApp.start();

        InOrder inOrder = inOrder(commandMenu, session);

        /*inOrder.verify(session).login();
        inOrder.verify(commandMenu).listOptions();
        inOrder.verify(commandMenu, atLeastOnce()).promptUser();
        inOrder.verify(commandMenu).executeCommand("list");
        inOrder.verify(commandMenu).executeCommand("quit");*/
    }
}
