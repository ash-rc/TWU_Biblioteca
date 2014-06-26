package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutMovieCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public CheckoutMovieCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        try {
            library.checkOutMovie();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
