package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class ReturnBookCommand implements Command {
    private Library library;

    public ReturnBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        try {
            library.returnBook();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
