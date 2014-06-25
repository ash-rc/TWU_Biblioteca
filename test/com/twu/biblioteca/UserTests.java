package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTests {
    @Test
    public void shouldReturnStringWhenAskedForUserDetails() {
        String name = "fakeUser";
        String email = "fakeEmail";
        String phoneNumber = "fakePhoneNumber";
        String password = "fakePassword";

        User user = new User(name, email, phoneNumber, password);

        assertEquals(user.getDetailString(), "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\n");
    }


}
