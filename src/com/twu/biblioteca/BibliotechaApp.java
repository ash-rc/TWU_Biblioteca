package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class BibliotechaApp {

    private CommandMenu commandMenu;
    private PrintStream out;

    public BibliotechaApp(CommandMenu commandMenu, PrintStream out) {
        this.commandMenu = commandMenu;
        this.out = out;
    }

    public void start() throws IOException {
        out.println("Welcome to the library!");
        commandMenu.listOptions();

        String userCommand = "";
        while (!userCommand.equals("quit")) {
            userCommand = commandMenu.promptUser();
            commandMenu.executeCommand(userCommand);

            if (commandMenu.loginCommandCompletedSuccessfully(userCommand)) {
                commandMenu.listOptions();
            }
        }
    }

}
