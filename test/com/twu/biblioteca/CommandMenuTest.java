package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/17/14.
 */
public class CommandMenuTest {

    private PrintStream printStream;
    private BufferedReader reader;
    private Session session;

    private HashMap<String, Command> commands;
    private CommandMenu commandMenu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        session = mock(Session.class);

        commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands, session);
    }

    @Test
    public void shouldListAllMenuOptionsWhenUserIsLoggedIn() {
        Command publicCommand = mock(Command.class);
        Command privateCommand = mock(Command.class);
        commands.put("public_command", publicCommand);
        commands.put("private_command", privateCommand);

        when(session.hasLoggedInUser()).thenReturn(true);
        when(publicCommand.isPrivate()).thenReturn(false);
        when(privateCommand.isPrivate()).thenReturn(true);

        commandMenu.listOptions();
        verify(printStream).println("public_command");
        verify(printStream).println("private_command");
    }

    @Test
    public void shouldListOnlyPublicMenuOptionsWhenUserIsLoggedOut() {
        Command privateCommand = mock(Command.class);
        commands.put("private_command", privateCommand);

        when(session.hasLoggedInUser()).thenReturn(false);
        when(privateCommand.isPrivate()).thenReturn(true);

        commandMenu.listOptions();
        verify(printStream, never()).println("private_command");
    }

    @Test
    public void shouldNotListLoginMenuOptionWhenUserIsLoggedIn() {
        Command loginCommand = new LoginCommand(session);
        commands.put("login", loginCommand);

        when(session.hasLoggedInUser()).thenReturn(true);

        commandMenu.listOptions();
        verify(printStream, never()).println("login");
    }

    @Test
    public void shouldAcceptAndExecuteCommand() throws IOException {
        Command command = mock(Command.class);
        commands.put("test", command);
        when(reader.readLine()).thenReturn("test");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);
        verify(command).execute();
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() throws IOException {
        when(reader.readLine()).thenReturn("Invalid option");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);
        verify(printStream).println("Select a valid option");
    }

}
