package com.twu.biblioteca;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class ListMoviesCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public ListMoviesCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        library.displayMovies();
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
