package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ListBooksCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public ListBooksCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        library.displayBooks();
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
