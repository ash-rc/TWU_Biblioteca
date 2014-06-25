package com.twu.biblioteca;

import java.io.IOException;

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

    @Override
    public boolean isPrivate() {
        return true;
    }
}
