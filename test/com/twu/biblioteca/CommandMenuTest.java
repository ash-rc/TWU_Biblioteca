package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/17/14.
 */
public class CommandMenuTest {

    private PrintStream printStream;
    private BufferedReader reader;
    private CommandMenu commandMenu;
    private HashMap<String, Command> commands;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
    }

    @Test
    public void shouldListAllMenuOptions() {
        Session session = mock(Session.class);
        when(session.hasLoggedInUser()).thenReturn(true);

        Command command = mock(Command.class);
        commands.put("list", command);

        commandMenu.listOptions(session.hasLoggedInUser());
        verify(printStream).println("list");
    }

    @Test
    public void shouldAcceptAndExecuteCommand() throws IOException {
        Command command = mock(Command.class);
        commands.put("test", command);
        when(reader.readLine()).thenReturn("test");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand, true);
        verify(command).execute();
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() throws IOException {
        when(reader.readLine()).thenReturn("Invalid option");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand, true);
        verify(printStream).println("Select a valid option");
    }

}
