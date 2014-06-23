package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> bookList;
    private Map<String, Movie> movieList;

    private PrintStream printStream;
    private BufferedReader reader;

    public Library(PrintStream printStream, BufferedReader reader, Map<String, Book> bookList, Map<String, Movie> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void display() {
        int padding = 4;
        int maxTitleLength = returnLongestTitle() + padding;
        int maxAuthorLength = returnLongestAuthor() + padding;

        String format = "%-" + maxTitleLength + "s" + "%-" + maxAuthorLength + "s" + "%s\n";

        for (Book book : bookList.values()) {
            if (!book.isCheckedOut())
                printStream.printf(format, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private int returnLongestTitle() {
        int maxTitleLength = 0;
        for (Book book : bookList.values()) {
            if (!book.isCheckedOut() && book.getTitle().length() > maxTitleLength) {
                maxTitleLength = book.getTitle().length();
            }
        }
        return maxTitleLength;
    }

    private int returnLongestAuthor() {
        int maxAuthorLength = 0;
        for (Book book : bookList.values()) {
            if (!book.isCheckedOut() && book.getAuthor().length() > maxAuthorLength) {
                maxAuthorLength = book.getAuthor().length();
            }
        }
        return maxAuthorLength;
    }


    public void checkOutBook() throws IOException {
        Book book = findBook();
        if (book != null && !book.isCheckedOut()) {
            book.checkOut();
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }

    }

    public void returnBook() throws IOException {
        Book book = findBook();
        if (book != null && book.isCheckedOut()) {
            book.returnItem();
            printStream.println("Thank you for returning the book");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private Book findBook() throws IOException {
        printStream.println("What is the title of the book?");
        String bookString = reader.readLine();

        if (bookList.containsKey(bookString))
            return bookList.get(bookString);
        else
            return null;
    }

    public void displayBooks() {
        display();
    }
}
