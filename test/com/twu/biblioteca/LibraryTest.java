package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class LibraryTest {


    private PrintStream printStream;
    private BufferedReader reader;
    List<Book> bookList;
    List<Movie> movieList;
    private Library library;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new ArrayList<Book>();
        movieList = new ArrayList<Movie>();
        library = new Library(printStream, reader, bookList, movieList);
    }

    @Test
    public void shouldCheckoutBookAndPrintMessageOnCheckout() throws IOException {
        Book book = mock(Book.class);
        bookList.add(book);

        when(reader.readLine()).thenReturn("");
        when(book.getTitle()).thenReturn("");

        library.checkOutItem(bookList);

        verify(book).checkOut();
        verify(printStream).println("Thank you! Enjoy the item");
    }

    @Test
    public void shouldReturnBookAndPrintMessageOnReturn() throws IOException {
        Book book = mock(Book.class);
        bookList.add(book);

        when(reader.readLine()).thenReturn("");
        when(book.isCheckedOut()).thenReturn(true);
        when(book.getTitle()).thenReturn("");
        library.returnItem(bookList);

        verify(book).returnItem();
        verify(printStream).println("Thank you for returning the item");
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.add(book);
        int longestBook = "Harry Potter".length() + 4;
        int longestAuthor = "J.K. Rowling".length() + 4;

        library.display(bookList);

        String format = "%-" + longestBook + "s" + "%-" + longestAuthor + "s" + "%s\n";
        verify(printStream, never()).printf(format, "Harry Potter", "J.K. Rowling", 1995);
    }

    @Test
    public void shouldDisplayErrorForBooksNotInTheLibrary() throws IOException {
        when(reader.readLine()).thenReturn("");
        library.checkOutItem(bookList);
        verify(printStream).println("That item is not available.");
    }

    @Test
    public void shouldDisplayErrorForCheckedOutBooks() throws IOException {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.add(book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.checkOutItem(bookList);

        verify(printStream).println("That item is not available.");
    }

    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "J.K. Rowling");
        bookList.add(book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.checkOutItem(bookList);
        verify(printStream).println("Thank you! Enjoy the item");
    }

    @Test
    public void shouldDisplayReturnedBookMessageOnReturn() throws IOException {
        Book book = new Book("Harry Potter", 1995, true, "J.K. Rowling");
        bookList.add(book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.returnItem(bookList);
        verify(printStream).println("Thank you for returning the item");
    }

    @Test
     public void shouldDisplayErrorWhenReturningBooksNotInTheLibrarySystem() throws IOException {
        when(reader.readLine()).thenReturn("");
        library.returnBook();
        verify(printStream).println("That is not a valid item to return.");
    }

    @Test
    public void shouldDisplayErrorForBooksThatAreAlreadyReturned() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "J.K. Rowling");
        bookList.add(book);
        when(reader.readLine()).thenReturn("Harry Potter");

        library.returnBook();
        verify(printStream).println("That is not a valid item to return.");
    }

    @Test
    public void shouldDisplayListOfBooks() {
        Book book = new Book("Harry Potter", 1995, false, "J.K. Rowling");
        bookList.add(book);
        int longestBook = "Harry Potter".length() + 4;
        int longestAuthor = "J.K. Rowling".length() + 4;

        library.displayBooks();

        String format = "%-" + longestBook + "s" + "%-" + longestAuthor + "s" + "%s";
        String output = String.format(format, "Harry Potter", "J.K. Rowling", 1995);
        verify(printStream).println(output);
    }


}
