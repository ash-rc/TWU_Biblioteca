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
    private BufferedReader reader;
    private Authenticator auth;

    public BibliotechaApp(CommandMenu commandMenu, Authenticator auth, BufferedReader reader, PrintStream out) {
        this.commandMenu = commandMenu;
        this.auth = auth;
        this.out = out;
        this.reader = reader;
    }

    public void start() throws IOException {
        out.println("Welcome to the library!");

        boolean accountNumIsValid = false;
        String accountNum = "";
        while (!accountNumIsValid) {
            out.println("Enter your library account number:");
            accountNum = reader.readLine();
            accountNumIsValid = auth.accountNumIsValid(accountNum);

            if (!accountNumIsValid) out.println("Invalid account number.");
        }

        boolean validLogin = false;
        String password = "";
        while (!validLogin) {
            out.println("Enter your password:");
            password = reader.readLine();
            validLogin = auth.loginIsValid(accountNum, password);

            if(!validLogin) out.println("Login failed.");
        }

        commandMenu.listOptions();

        String userCommand = "";
        while (!userCommand.equals("quit")) {
            userCommand = commandMenu.promptUser();
            commandMenu.executeCommand(userCommand);
        }
    }

}
