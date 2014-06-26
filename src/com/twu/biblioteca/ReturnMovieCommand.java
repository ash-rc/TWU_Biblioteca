package com.twu.biblioteca;

import java.io.IOException;

public class ReturnMovieCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public ReturnMovieCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        try {
            library.returnMovie();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
