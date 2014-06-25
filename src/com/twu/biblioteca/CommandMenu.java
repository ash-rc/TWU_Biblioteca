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

    public CommandMenu(PrintStream printStream, BufferedReader reader, HashMap<String, Command> commands) {
        this.printStream = printStream;
        this.reader = reader;
        this.commands = commands;
    }

    public void listOptions(boolean sessionHasLoggedInUser) {
        for (String commandName : commands.keySet()) {
            if (!commandIsAccessible(commandName, sessionHasLoggedInUser))
                continue;
            else if (sessionHasLoggedInUser && commands.get(commandName) instanceof LoginCommand)
                continue;

            printStream.println(commandName);
        }
    }

    public String promptUser() throws IOException {
        return reader.readLine();
    }

    public void executeCommand(String commandName, boolean sessionHasLoggedInUser) {
        if(commands.containsKey(commandName) && commandIsAccessible(commandName, sessionHasLoggedInUser)){
            commands.get(commandName).execute();
        } else {
            printStream.println("Select a valid option");
            return;
        }
    }

    private boolean commandIsAccessible(String commandName, boolean sessionHasLoggedInUser) {
        if (!sessionHasLoggedInUser && commands.get(commandName).isPrivate()) return false;
        return true;
    }
}
