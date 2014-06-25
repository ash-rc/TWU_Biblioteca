package com.twu.biblioteca;

import java.io.IOException;

public class LoginCommand implements Command {
    private Session session;

    public LoginCommand(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        try {
            session.login();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivate() {
        return false;
    }
}
