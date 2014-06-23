package com.twu.biblioteca;

public class Movie extends LibraryItem {

    private int rating;
    private String director;

    public Movie(String title, int year, boolean checkedOut, String director, int rating) {
        super(title, year, checkedOut);
        this.director = director;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int getCreatorLength() {
        return director.length();
    }

    @Override
    public String getFormattedListItem(int maxTitleLength, int maxCreatorLength) {
        String format = "%-" + maxTitleLength + "s" + "%-" + maxCreatorLength + "s" + "%s\t%s";
        return String.format(format, title, director, year, rating);
    }
}

