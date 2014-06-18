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
public class TestCommandMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private CommandMenu commandMenu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
    }

    @Test
    public void shouldListAllMenuOptions() {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        Command command = mock(Command.class);
        commands.put("list", command);
        commandMenu = new CommandMenu(printStream, reader, commands);

        commandMenu.listOptions();
        verify(printStream).println("list");
    }

    @Test
    public void shouldAcceptAndExecuteCommand() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("zzzz");

        commandMenu.selectAndExecuteOption();
        verify(command).execute();
    }
}
