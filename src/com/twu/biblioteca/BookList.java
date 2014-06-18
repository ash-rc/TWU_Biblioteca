package com.twu.biblioteca;

/**
 * Created by richiethomas on 6/17/14.
 */
public class BookList {
  Book[] bookList = {new Book("Harry Potter And The Prisoner of Azkaban", "JK Rowling", 1999), new Book("The Shining", "Steven King", 1980)};

    BookListPrinter printer;

    public BookList(BookListPrinter printer) {
        this.printer = printer;
    }

    @Override
  public String toString(){
    String temp = "";
    for(Book book : bookList){
      temp += outputOneLine(book.getTitle()) + "|  ";
      temp += outputOneLine(book.getAuthor()) + "|  ";
      temp += Integer.toString(book.getYear()) + "\n";
    }
    return temp;
  }

  private String outputOneLine(String str) {

    int lengthOfString;
    if(str.length() >= 40) {
      lengthOfString = 40;
    } else {
      lengthOfString = str.length();
    }
    return String.format("%-40s", str.substring(0, lengthOfString));
  }

    public void display() {
        printer.setMessage(this.toString());
        printer.display();
    }
}
