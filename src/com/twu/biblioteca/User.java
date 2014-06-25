package com.twu.biblioteca;

public class User {

    private String password;

    public User(String password) {
        this.password = password;
    }

    public boolean passwordDoesMatch(String password) {
        return this.password.equals(password);
    }
}
