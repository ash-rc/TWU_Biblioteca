package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class BibliotechaApp {

    private CommandMenu commandMenu;
    private PrintStream out;
    private Session session;

    public BibliotechaApp(CommandMenu commandMenu, PrintStream out, Session session) {
        this.commandMenu = commandMenu;
        this.out = out;
        this.session = session;
    }

    public void start() throws IOException {
        out.println("Welcome to the library!");

        boolean validLogin = false;
        while(!validLogin) {
            validLogin = session.login();
        }

        commandMenu.listOptions();

        String userCommand = "";
        while (!userCommand.equals("quit")) {
            userCommand = commandMenu.promptUser();
            commandMenu.executeCommand(userCommand);
        }
    }

}
