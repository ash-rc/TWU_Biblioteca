package com.twu.biblioteca;

import java.util.Map;

public class Authenticator {

    private Map<String, User> users;

    public Authenticator(Map<String, User> users) {
        this.users = users;
    }

    public boolean accountNumIsValid(String accountNum) {
        return users.containsKey(accountNum);
    }

    public boolean passwordIsValid(String accountNum, String password) {
        return users.get(accountNum).passwordDoesMatch(password);
    }

    public User getUser(String accountNum) {
        return users.get(accountNum);
    }
}
