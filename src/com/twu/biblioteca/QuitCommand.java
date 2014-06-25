package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class QuitCommand implements Command {

    PrintStream out;

    public QuitCommand(PrintStream out) {
        this.out = out;
    }

    @Override
    public void execute() {
        out.println("Quitting Bibliotecha");
    }

    @Override
    public boolean isPrivate() {
        return false;
    }
}
