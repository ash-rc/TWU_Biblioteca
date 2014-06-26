package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutMovieCommandTest {

    @Test
    public void shouldCheckoutBookCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command checkoutMovieCommand = new CheckoutMovieCommand(library, true);
        checkoutMovieCommand.execute();
        verify(library).checkOutMovie();
    }

}