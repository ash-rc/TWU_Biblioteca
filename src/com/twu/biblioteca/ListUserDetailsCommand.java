package com.twu.biblioteca;

/**
 * Created by melissamarshall on 6/25/14.
 */
public class ListUserDetailsCommand implements Command {
    private Session session;
    private boolean isPrivate;

    public ListUserDetailsCommand(Session session, boolean isPrivate) {
        this.session = session;
        this.isPrivate = isPrivate;
    }

    @Override
    public void execute() {
        session.printUserDetails();
    }

    @Override
    public boolean isPrivate() {
        return isPrivate;
    }
}
