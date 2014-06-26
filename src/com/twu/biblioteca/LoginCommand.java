package com.twu.biblioteca;

import java.io.IOException;

public class LoginCommand implements Command {
    private Session session;
    private boolean isPrivate;

    public LoginCommand(Session session, boolean isPrivate) {
        this.session = session;
        this.isPrivate = isPrivate;
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
        return isPrivate;
    }
}
