package com.twu.biblioteca;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class ListMoviesCommand implements Command {
    private Library library;

    public ListMoviesCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.displayMovies();
    }

    @Override
    public boolean isPrivate() {
        return false;
    }
}
