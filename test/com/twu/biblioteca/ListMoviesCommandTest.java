package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ListMoviesCommandTest {

    @Test
    public void shouldDisplayMovieList() throws IOException {
        Library library = mock(Library.class);
        Command listMoviesCommand = new ListMoviesCommand(library, false);
        listMoviesCommand.execute();
        verify(library).displayMovies();
    }

}