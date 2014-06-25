package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginCommandTest {

    @Test
    public void shouldAskSessionToLoginOnExecute() throws IOException {
        Session session = mock(Session.class);
        Command loginCommand = new LoginCommand(session);
        loginCommand.execute();
        verify(session).login();
    }
}
