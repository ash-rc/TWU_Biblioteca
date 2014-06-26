package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {

    @Test
    public void shouldDisplayBookList() throws IOException {
        Library library = mock(Library.class);
        Command listBooksCommand = new ListBooksCommand(library, false);
        listBooksCommand.execute();
        verify(library).displayBooks();
    }

}