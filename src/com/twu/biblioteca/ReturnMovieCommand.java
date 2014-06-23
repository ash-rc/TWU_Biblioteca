package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class ReturnMovieCommand implements Command {
    private Library library;

    public ReturnMovieCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        try {
            library.returnMovie();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
