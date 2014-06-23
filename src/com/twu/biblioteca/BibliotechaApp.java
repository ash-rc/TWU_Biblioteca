package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class BibliotechaApp {

    private CommandMenu commandMenu;

    public BibliotechaApp(CommandMenu commandMenu){

        this.commandMenu = commandMenu;
    }

    public void start() throws IOException {
        commandMenu.displayWelcome();
        commandMenu.listOptions();

        String userCommand = "";
        while(!userCommand.equals("quit")){
            userCommand = commandMenu.promptUser();
            commandMenu.executeCommand(userCommand);
        }
    }
}
