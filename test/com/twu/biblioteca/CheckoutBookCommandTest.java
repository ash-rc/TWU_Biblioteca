package com.twu.biblioteca;

import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookCommandTest {

    @Test
    public void shouldCheckoutBookCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command checkoutBookCommand = new CheckoutBookCommand(library, true);
        checkoutBookCommand.execute();
        verify(library).checkOutBook();
    }

}