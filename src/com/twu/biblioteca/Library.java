package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<? extends LibraryItem> bookList;
    private List<? extends LibraryItem> movieList;

    private PrintStream printStream;
    private BufferedReader reader;
    private Session session;

    public Library(PrintStream printStream, BufferedReader reader, List<? extends LibraryItem> bookList,
                   List<? extends LibraryItem> movieList, Session session) {
        this.bookList = bookList;
        this.movieList = movieList;
        this.printStream = printStream;
        this.reader = reader;
        this.session = session;
    }

    public void display(List<? extends LibraryItem> itemList) {
        int padding = 4;
        int maxTitleLength = returnLongestTitle(itemList) + padding;
        int maxCreatorLength = returnLongestCreator(itemList) + padding;

        for (LibraryItem item : itemList) {
            if (!item.isCheckedOut()) {
                String output = item.getFormattedListItem(maxTitleLength, maxCreatorLength);
                printStream.println(output);
            }
        }
    }

    private int returnLongestTitle(List<? extends LibraryItem> itemList) {
        int maxTitleLength = 0;
        for (LibraryItem item : itemList) {
            if (!item.isCheckedOut() && item.getTitle().length() > maxTitleLength) {
                maxTitleLength = item.getTitle().length();
            }
        }
        return maxTitleLength;
    }

    private int returnLongestCreator(List<? extends LibraryItem> itemList) {
        int maxCreatorLength = 0;
        for (LibraryItem item : itemList) {
            if (!item.isCheckedOut() && item.getCreatorLength() > maxCreatorLength) {
                maxCreatorLength = item.getCreatorLength();
            }
        }
        return maxCreatorLength;
    }


    public void checkOutItem(List<? extends LibraryItem> itemList) throws IOException {
        LibraryItem item = findItemByUserRequest(itemList);
        if (item != null && !item.isCheckedOut()) {
            item.checkOut();
            session.getUser().checkoutItem(item);
            printStream.println("Thank you! Enjoy the item");
        } else {
            printStream.println("That item is not available.");
        }
    }

    public void returnItem(List<? extends LibraryItem> itemList) throws IOException {
        LibraryItem item = findItemByUserRequest(itemList);
        if (item != null && item.isCheckedOut()) {
            item.returnItem();
            session.getUser().returnItem(item);
            printStream.println("Thank you for returning the item");
        } else {
            printStream.println("That is not a valid item to return.");
        }
    }

    private LibraryItem findItemByUserRequest(List<? extends LibraryItem> itemList) throws IOException {
        printStream.println("What is the name of the item?");
        String itemName = reader.readLine();

        for (LibraryItem item : itemList) {
            if(item.getTitle().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void displayBooks() {
        display(bookList);
    }

    public void displayMovies() {
        display(movieList);
    }

    public void checkOutBook() throws IOException {
        checkOutItem(bookList);
    }

    public void checkOutMovie() throws IOException {
        checkOutItem(movieList);
    }

    public void returnBook() throws IOException {
        returnItem(bookList);
    }

    public void returnMovie() throws IOException {
        returnItem(movieList);
    }
}
