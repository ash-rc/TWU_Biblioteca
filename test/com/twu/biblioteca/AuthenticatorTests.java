package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticatorTests {

    private Map<String, User> users;
    private Authenticator authenticator;
    private User user;

    @Before
    public void setUp() {
        user = mock(User.class);
        users = new HashMap<String, User>();
        authenticator = new Authenticator(users);
    }

    @Test
    public void shouldReturnTrueWhenAccountNumberIsValid() {
        users.put("test_account_num", user);
        boolean accountNumberIsValid = authenticator.accountNumIsValid("test_account_num");
        assertThat(accountNumberIsValid, is(true));
    }

    @Test
    public void shouldReturnTrueWhenPasswordIsValid() {
        users.put("test_account_num", user);
        when(user.passwordDoesMatch("test_password")).thenReturn(true);

        boolean passwordIsValid = authenticator.passwordIsValid("test_account_num", "test_password");
        assertThat(passwordIsValid, is(true));
    }

    @Test
    public void shouldReturnFalseWhenAccountNumberIsInvalid() {
        users.put("test_account_num", user);
        boolean accountNumberIsValid = authenticator.accountNumIsValid("incorrect_account_num");
        assertThat(accountNumberIsValid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsInvalid() {
        users.put("test_account_num", user);
        when(user.passwordDoesMatch("incorrect_password")).thenReturn(false);

        boolean passwordIsValid = authenticator.passwordIsValid("test_account_num", "incorrect_password");
        assertThat(passwordIsValid, is(false));
    }
}
