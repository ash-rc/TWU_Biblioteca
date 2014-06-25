package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class CheckoutMovieCommand implements Command {

    private Library library;

    public CheckoutMovieCommand(Library library) {
        this.library = library;
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
        return true;
    }
}
