package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Book> bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", 1995, false, "JK Rowling"));
        bookList.put("The Shining", new Book("The Shining", 1970, false, "Stephen King"));

        Map<String,Movie> movieList = new HashMap<String,Movie>();
        movieList.put("Titanic", new Movie("Titanic", 1998, false, "James Cameron", 7));
        movieList.put("Harry Potter", new Movie("Harry Potter", 1998, false, "Christopher Columbus", 8));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Library library = new Library(System.out, reader, bookList, movieList);

        Map<String, User> users = new HashMap<String, User>();
        users.put("123-4567", new User("123-4567", "password"));
        users.put("012-3456", new User("012-3456", "mybirthday"));

        Authenticator auth = new Authenticator(users);
        Session session = new Session(System.out, reader, auth);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        commands.put("list books", new ListBooksCommand(library));
        commands.put("checkout book", new CheckoutBookCommand(library));
        commands.put("return book", new ReturnBookCommand(library));

        commands.put("list movies", new ListMoviesCommand(library));
        commands.put("checkout movie", new CheckoutMovieCommand(library));
        commands.put("return movie", new ReturnMovieCommand(library));

        commands.put("quit", new QuitCommand(System.out));

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(menu, System.out, session);
        bibliotechaApp.start();

  }

}
