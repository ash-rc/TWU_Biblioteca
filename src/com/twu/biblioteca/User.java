package com.twu.biblioteca;

public class User {

    private final String name;
    private final String email;
    private final String phonenumber;
    private String password;

    public User(String name, String email, String phonenumber, String password) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public boolean passwordDoesMatch(String password) {
        return this.password.equals(password);
    }

    public String getDetailString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phonenumber + "\n";
    }
}
