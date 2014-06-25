package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksCommandTest {

    private PrintStream printStream;
    private BufferedReader reader;
    private Session session;
    private CommandMenu commandMenu;
    private HashMap<String, Command> commands;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        session = mock(Session.class);
        commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands, session);
    }

    @Test
    public void shouldDisplayBookList() throws IOException {
        Library library = mock(Library.class);
        Command command = new ListBooksCommand(library);
        commands.put("list",command);
        when(reader.readLine()).thenReturn("list");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);

        verify(library).displayBooks();
    }

}