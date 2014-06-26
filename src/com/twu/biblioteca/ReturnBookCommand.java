package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class ReturnBookCommand implements Command {
    private Library library;
    private boolean isPrivate;

    public ReturnBookCommand(Library library, boolean isPrivate) {
        this.library = library;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        try {
            library.returnBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
