package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class TestLibrary {


    private PrintStream printStream;
    private BufferedReader reader;
    Map<String,Book> bookList;
    private Library library;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new HashMap<String,Book>();
        library = new Library(printStream, reader, bookList);
    }

    @Test
    public void shouldCheckoutBookAndPrintMessageOnCheckout() throws IOException {
        Book book = mock(Book.class);
        bookList.put("", book);

        when(reader.readLine()).thenReturn("");
        library.checkOutBook();

        verify(book).checkOut();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldUncheckoutBookAndPrintMessageOnReturn() throws IOException {
        Book book = mock(Book.class);
        bookList.put("", book);

        when(reader.readLine()).thenReturn("");
        when(book.isCheckedOut()).thenReturn(true);
        library.returnBook();

        verify(book).returnItem();
        verify(printStream).println("Thank you for returning the book");
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.put("Harry Potter", book);
        int longestBook = "Harry Potter".length() + 4;
        int longestAuthor = "J.K. Rowling".length() + 4;

        library.display();

        String format = "%-" + longestBook + "s" + "%-" + longestAuthor + "s" + "%s\n";
        verify(printStream, never()).printf(format, "Harry Potter", "J.K. Rowling", 1995);
    }

    @Test
    public void shouldDisplayErrorForBooksNotInTheLibrary() throws IOException {
        when(reader.readLine()).thenReturn("");
        library.checkOutBook();
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayErrorForCheckedOutBooks() throws IOException {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.put("Harry Potter", book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.checkOutBook();

        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "J.K. Rowling");
        bookList.put("Harry Potter", book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.checkOutBook();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldDisplayReturnedBookMessageOnReturn() throws IOException {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.put("Harry Potter", book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.returnBook();
        verify(printStream).println("Thank you for returning the book");
    }

    @Test
     public void shouldDisplayErrorWhenReturningBooksNotInTheLibrarySystem() throws IOException {
        when(reader.readLine()).thenReturn("");
        library.returnBook();
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayErrorForBooksThatAreAlreadyReturned() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "J.K. Rowling");
        bookList.put("Harry Potter", book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.returnBook();
        verify(printStream).println("That is not a valid book to return.");
    }


}
