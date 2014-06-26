package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Authenticator auth = new Authenticator(generateUsers());
        Session session = new Session(System.out, reader, auth);
        Library library = new Library(System.out, reader, generateBooks(), generateMovies());
        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                generateCommands(library, session), session);

        BibliotecaApp bibliotechaApp = new BibliotecaApp(menu, System.out);
        bibliotechaApp.start();
  }


    //TODO: These are static, should it actually be? Look into this @acampo
    public static Map<String, Command> generateCommands(Library library, Session session) {
        Map<String, Command> commandMap = new HashMap<String, Command>();

        commandMap.put("list books", new ListBooksCommand(library, false));
        commandMap.put("checkout book", new CheckoutBookCommand(library, true));
        commandMap.put("return book", new ReturnBookCommand(library, true));

        commandMap.put("list movies", new ListMoviesCommand(library, false));
        commandMap.put("checkout movie", new CheckoutMovieCommand(library, true));
        commandMap.put("return movie", new ReturnMovieCommand(library, true));

        commandMap.put("list user details", new ListUserDetailsCommand(session, true));
        commandMap.put("quit", new QuitCommand(System.out, false));
        commandMap.put("login", new LoginCommand(session, false));

        return commandMap;
    }

    public static Map<String, User> generateUsers() {
        Map<String, User> usersMap = new HashMap<String, User>();
        usersMap.put("123-4567", new User("Ashley", "ashley.r.campo@gmail.com", "555-404-9999", "password"));
        usersMap.put("012-3456", new User("Melissa", "mmelissahh@gmail.com", "123-456-7890", "my_birthday"));

        return usersMap;
    }

    public static List<Movie> generateMovies() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Titanic", 1998, false, "James Cameron", 7));
        movieList.add(new Movie("Harry Potter", 1998, false, "Christopher Columbus", 8));

        return movieList;
    }

    public static List<Book> generateBooks() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", 1995, false, "JK Rowling"));
        bookList.add(new Book("The Shining", 1970, false, "Stephen King"));

        return bookList;
    }
}
