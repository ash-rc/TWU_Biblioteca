package com.twu.biblioteca;

public abstract class LibraryItem {

    protected String title;
    protected int year;
    protected boolean checkedOut;

    protected LibraryItem(String title, int year, boolean checkedOut) {
        this.title = title;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getFormattedListItem(int maxTitleLength, int maxAuthorLength) { return ""; }

    public int getCreatorLength() { return 0; }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnItem() {
        checkedOut = false;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
}
