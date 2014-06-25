package com.twu.biblioteca;

public class User {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private String password;

    public User(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public boolean passwordDoesMatch(String password) {
        return this.password.equals(password);
    }

    public String getDetailString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber;
    }
}
