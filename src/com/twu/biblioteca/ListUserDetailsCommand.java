package com.twu.biblioteca;

/**
 * Created by melissamarshall on 6/25/14.
 */
public class ListUserDetailsCommand implements Command {

    private Session session;

    public ListUserDetailsCommand(Session session) {
        this.session = session;
    }

    @Override
    public void execute() {
        session.printUserDetails();
    }

    @Override
    public boolean isPrivate() {
        return true;
    }
}
