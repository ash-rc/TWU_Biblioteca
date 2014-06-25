package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Session {

    private PrintStream out;
    private BufferedReader reader;
    private Authenticator authenticator;
    private User user;

    public Session(PrintStream out, BufferedReader reader, Authenticator authenticator) {
        this.out = out;
        this.reader = reader;
        this.authenticator = authenticator;
        this.user = null;
    }

    public boolean login() throws IOException {

        out.println("Enter your library account number:");
        String accountNum = reader.readLine();
        if (!authenticator.accountNumIsValid(accountNum)) {
            out.println("Invalid account number.");
            return false;
        }

        out.println("Enter your password:");
        String password = reader.readLine();
        if (!authenticator.passwordIsValid(accountNum, password)) {
            out.println("Login failed.");
            return false;
        }

        user = authenticator.getUser(accountNum);
        return true;
    }

    public boolean hasLoggedInUser() {
        return user != null;
    }
}
