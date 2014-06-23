package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Library {
    private Map<String, ? extends LibraryItem> bookList;
    private Map<String, ? extends LibraryItem> movieList;

    private PrintStream printStream;
    private BufferedReader reader;

    public Library(PrintStream printStream, BufferedReader reader, Map<String, ? extends LibraryItem> bookList, Map<String, ? extends LibraryItem> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void display(Map<String, ? extends LibraryItem> itemList) {
        int padding = 4;
        int maxTitleLength = returnLongestTitle(itemList) + padding;
        int maxCreatorLength = returnLongestCreator(itemList) + padding;

        for (LibraryItem item : itemList.values()) {
            if (!item.isCheckedOut()) {
                String output = item.getFormattedListItem(maxTitleLength, maxCreatorLength);
                printStream.println(output);
            }
        }
    }

    private int returnLongestTitle(Map<String, ? extends LibraryItem> itemList) {
        int maxTitleLength = 0;
        for (LibraryItem item : itemList.values()) {
            if (!item.isCheckedOut() && item.getTitle().length() > maxTitleLength) {
                maxTitleLength = item.getTitle().length();
            }
        }
        return maxTitleLength;
    }

    private int returnLongestCreator(Map<String, ? extends LibraryItem> itemList) {
        int maxCreatorLength = 0;
        for (LibraryItem item : itemList.values()) {
            if (!item.isCheckedOut() && item.getCreatorLength() > maxCreatorLength) {
                maxCreatorLength = item.getCreatorLength();
            }
        }
        return maxCreatorLength;
    }


    public void checkOutItem(Map<String, ? extends LibraryItem> itemList) throws IOException {
        LibraryItem item = findItem(itemList);
        if (item != null && !item.isCheckedOut()) {
            item.checkOut();
            printStream.println("Thank you! Enjoy the item");
        } else {
            printStream.println("That item is not available.");
        }

    }

    public void returnItem(Map<String, ? extends LibraryItem> itemList) throws IOException {
        LibraryItem item = findItem(itemList);
        if (item != null && item.isCheckedOut()) {
            item.returnItem();
            printStream.println("Thank you for returning the item");
        } else {
            printStream.println("That is not a valid item to return.");
        }
    }

    private LibraryItem findItem(Map<String, ? extends LibraryItem> itemList) throws IOException {
        printStream.println("What is the name of the item?");
        String itemName = reader.readLine();

        if (itemList.containsKey(itemName))
            return itemList.get(itemName);
        else
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
