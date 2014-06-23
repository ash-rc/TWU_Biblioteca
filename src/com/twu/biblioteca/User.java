package com.twu.biblioteca;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class User {

    private String accountNumber;
    private String password;

    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public boolean passwordDoesMatch(String password) {
        return this.password.equals(password);
    }
}
