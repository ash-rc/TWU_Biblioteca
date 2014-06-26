package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class QuitCommand implements Command {
    private PrintStream out;
    private boolean isPrivate;

    public QuitCommand(PrintStream out, boolean isPrivate) {
        this.out = out;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        out.println("Quitting Biblioteca");
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
