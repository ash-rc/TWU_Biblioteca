package com.twu.biblioteca;

public class Book extends LibraryItem {

    private final String author;

    public Book(String title, int year, boolean checkedOut, String author) {
        super(title, year, checkedOut);
        this.author = author;
    }

    @Override
    public String getFormattedListItem(int maxTitleLength, int maxAuthorLength) {
        String format = "%-" + maxTitleLength + "s" + "%-" + maxAuthorLength + "s" + "%s";
        return String.format(format, title, author, year);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int getCreatorLength() {
        return author.length();
    }
}
