package com.twu.biblioteca;

import java.util.List;

public class User {

    private String password;
    private List<LibraryItem> checkedOutItems;

    public User(String password, List<LibraryItem> checkedOutItems) {
        this.password = password;
        this.checkedOutItems = checkedOutItems;
    }

    public boolean passwordDoesMatch(String password) {
        return this.password.equals(password);
    }

    public void checkoutItem(LibraryItem item) {
        checkedOutItems.add(item);
    }
    
    public void returnItem(LibraryItem item) {
        checkedOutItems.remove(item);
    }
}
