package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String,Book> bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", 1995, false, "JK Rowling"));
        bookList.put("The Shining", new Book("The Shining", 1970, false, "Stephen King"));
        Map<String,Movie> movieList = new HashMap<String,Movie>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(System.out, reader, bookList, movieList);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        Command listBooksCommand = new ListBooksCommand(library);
        commands.put("list", listBooksCommand);
        commands.put("checkout", new CheckoutBookCommand(library));
        commands.put("return", new ReturnBookCommand(library));

        Command quitCommand = new QuitCommand(System.out);
        commands.put("quit", quitCommand);

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(menu);
        bibliotechaApp.start();

  }

}
