package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookUserHandlerTest {

    @Mock
    private BookUserRepository bookUserRepository;

    @InjectMocks
    private BookUserHandler bookUserHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllBookUser() {
        List<BookUser> mockBookUsers = new ArrayList<>();

        when(bookUserRepository.findAll()).thenReturn(mockBookUsers);

        List<BookUser> result = bookUserHandler.getAllBookUser();

        assertEquals(mockBookUsers.size(), result.size());

        verify(bookUserRepository, times(1)).findAll();
    }

    @Test
    void addBookUser() {
        int bookId = 1;
        int userId = 1;
        BookUser newBookUser = new BookUser(bookId, userId);

        when(bookUserRepository.save(any())).thenReturn(newBookUser);

        BookUser result = bookUserHandler.addBookUser(newBookUser);

        assertEquals(newBookUser, result);

        verify(bookUserRepository, times(1)).save(any());
    }

    @Test
    void getNoOfBookUser() {
        long expectedNoOfBookUsers = 5;

        when(bookUserRepository.count()).thenReturn(expectedNoOfBookUsers);

        long result = bookUserHandler.getNoOfBookUser();

        assertEquals(expectedNoOfBookUsers, result);

        verify(bookUserRepository, times(1)).count();
    }

    @Test
    void removeBookUser() {
        long bookUserIdToRemove = 1;
        BookUser bookUserToRemove = new BookUser();

        bookUserToRemove.setBookuser_id((int) bookUserIdToRemove);

        when(bookUserRepository.findById(bookUserIdToRemove)).thenReturn(Optional.of(bookUserToRemove));

        boolean result = bookUserHandler.removeBookUser(bookUserIdToRemove);

        assertTrue(result);

        verify(bookUserRepository, times(1)).delete(bookUserToRemove);
    }

    @Test
    void getBookUserById() {
        long bookUserId = 1;
        BookUser expectedBookUser = new BookUser();

        expectedBookUser.setBookuser_id((int) bookUserId);

        when(bookUserRepository.findById(bookUserId)).thenReturn(Optional.of(expectedBookUser));

        BookUser result = bookUserHandler.getBookUserById(bookUserId);

        assertEquals(expectedBookUser, result);
    }

    @Test
    void updateBookUserDetails() {
        BookUser bookUserToUpdate = new BookUser();

        when(bookUserRepository.save(any())).thenReturn(bookUserToUpdate);

        BookUser result = bookUserHandler.updateBookUserDetails(bookUserToUpdate);

        assertEquals(bookUserToUpdate, result);

        verify(bookUserRepository, times(1)).save(any());
    }
}