package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReturnMovieCommandTest {

    @Test
    public void shouldReturnMovieCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command returnMovieCommand = new ReturnMovieCommand(library);
        returnMovieCommand.execute();
        verify(library).returnMovie();
    }

}