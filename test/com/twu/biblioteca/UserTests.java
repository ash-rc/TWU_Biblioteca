package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class UserTests {

    private LibraryItem item;
    private List<LibraryItem> checkedOutItems;
    private User user;

    @Before
    public void setUp() {
        checkedOutItems = new ArrayList<LibraryItem>();
        item = mock(LibraryItem.class);
        user = new User("test_password", checkedOutItems);
    }

    @Test
    public void shouldAddLibraryItemToListOnCheckOut() {
        user.checkoutItem(item);
        assertThat(checkedOutItems.size(), is(1));
    }

    @Test
    public void shouldRemoveLibraryItemFromListOnCheckout() {
        checkedOutItems.add(item);
        user.returnItem(item);
        assertThat(checkedOutItems.size(), is(0));
    }
}
