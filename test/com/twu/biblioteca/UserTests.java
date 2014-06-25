package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserTests {

    @Test
    public void shouldAddLibraryItemToListOnCheckOut() {
        List<LibraryItem> checkedOutItems = new ArrayList<LibraryItem>();
        LibraryItem item = mock(LibraryItem.class);
        User user = new User("test_password", checkedOutItems);

        user.checkoutItem(item);
        assertThat(checkedOutItems.size(), is(1));
    }

    @Test
    public void shouldRemoveLibraryItemFromListOnCheckout() {
        List<LibraryItem> checkedOutItems = new ArrayList<LibraryItem>();
        LibraryItem item = mock(LibraryItem.class);
        User user = new User("test_password", checkedOutItems);
        checkedOutItems.add(item);
        when(item.getTitle()).thenReturn("test_item");

        user.returnItem("test_item", LibraryItem.class);
        assertThat(checkedOutItems.size(), is(0));
    }
}
