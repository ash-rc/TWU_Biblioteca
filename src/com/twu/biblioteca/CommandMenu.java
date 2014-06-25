package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class CommandMenu {
    private HashMap<String, Command> commands;
    private PrintStream printStream;
    private BufferedReader reader;
    private Session session;

    public CommandMenu(PrintStream printStream, BufferedReader reader, HashMap<String, Command> commands, Session session) {
        this.printStream = printStream;
        this.reader = reader;
        this.commands = commands;
        this.session = session;
    }

    public void listOptions() {
        for (String commandName : commands.keySet()) {
            if (!commandIsAccessible(commandName) || loginCommandCalledButUserIsLoggedIn(commandName))
                continue;
            printStream.println(commandName);
        }
    }

    public String promptUser() throws IOException {
        return reader.readLine();
    }

    public void executeCommand(String commandName) {
        if (commands.containsKey(commandName) && commandIsAccessible(commandName)) {
            commands.get(commandName).execute();
        } else {
            printStream.println("Select a valid option");
            return;
        }
    }

    private boolean loginCommandCalledButUserIsLoggedIn(String commandName) {
        return session.hasLoggedInUser() && commands.get(commandName) instanceof LoginCommand;
    }

    private boolean commandIsAccessible(String commandName) {
        return session.hasLoggedInUser() || !commands.get(commandName).isPrivate();
    }

    public boolean loginCommandCompletedSuccessfully(String userCommand) {
        return commands.get(userCommand) instanceof LoginCommand && session.hasLoggedInUser();
    }
}
