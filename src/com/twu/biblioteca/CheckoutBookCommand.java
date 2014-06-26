package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class CheckoutBookCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public CheckoutBookCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        try {
            library.checkOutBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
