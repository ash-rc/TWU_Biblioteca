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

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Harry Potter", 1995, false, "JK Rowling"));
        bookList.add(new Book("The Shining", 1970, false, "Stephen King"));

        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Titanic", 1998, false, "James Cameron", 7));
        movieList.add(new Movie("Harry Potter", 1998, false, "Christopher Columbus", 8));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, User> users = new HashMap<String, User>();
        users.put("123-4567", new User("Ashley", "ashley.r.campo@gmail.com", "555-404-9999", "password"));
        users.put("012-3456", new User("Melissa", "mmelissahh@gmail.com", "123-456-7890", "mybirthday"));

        Authenticator auth = new Authenticator(users);
        Session session = new Session(System.out, reader, auth);
        Library library = new Library(System.out, reader, bookList, movieList);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        commands.put("list books", new ListBooksCommand(library));
        commands.put("checkout book", new CheckoutBookCommand(library));
        commands.put("return book", new ReturnBookCommand(library));

        commands.put("list movies", new ListMoviesCommand(library));
        commands.put("checkout movie", new CheckoutMovieCommand(library));
        commands.put("return movie", new ReturnMovieCommand(library));

        commands.put("list user details", new ListUserDetailsCommand(session));
        commands.put("quit", new QuitCommand(System.out));
        commands.put("login", new LoginCommand(session));

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands, session);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(menu, System.out);
        bibliotechaApp.start();

  }

}
