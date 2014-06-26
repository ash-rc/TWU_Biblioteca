package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by melissamarshall on 6/25/14.
 */
public class ListUserDetailsCommandTest {

    @Test
    public void shouldCallPrintsDetailsOnExecute() {
        Session session = mock(Session.class);
        Command listUserDetailsCommand = new ListUserDetailsCommand(session, true);

        listUserDetailsCommand.execute();
        verify(session).printUserDetails();

    }


}

