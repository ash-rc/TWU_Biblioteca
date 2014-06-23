package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by melissamarshall on 6/23/14.
 */
public class AuthenticatorTests {

    @Test
    public void shouldReturnTrueWhenInputMatchesUserPassword() {
        Map<String, User> users = new HashMap<String, User>();
        User user = mock(User.class);
        users.put("123-4567", user);
        Authenticator auth = new Authenticator(users);

        when(users.get("123-4567")).thenReturn(user);
        when(user.passwordDoesMatch("bleh")).thenReturn(true);

        boolean validLogin = auth.loginIsValid("123-4567", "bleh");
        assertThat(validLogin, is(true));
    }
}
