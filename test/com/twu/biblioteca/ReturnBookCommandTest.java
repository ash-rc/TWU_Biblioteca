package com.twu.biblioteca;

import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnBookCommandTest {

    @Test
    public void shouldReturnBookCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command returnBookCommand = new ReturnBookCommand(library);
        returnBookCommand.execute();
        verify(library).returnBook();
    }

}