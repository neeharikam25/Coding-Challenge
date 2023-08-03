package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class UserHandlerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserHandler userHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllUser() {
        List<User> mockUsers = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> result = userHandler.getAllUser();

        assertEquals(mockUsers.size(), result.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    void addUser() {
        User newUser = new User(1, "John Doe", "john@example.com");

        when(userRepository.save(any())).thenReturn(newUser);

        User result = userHandler.addUser(newUser);

        assertEquals(newUser, result);

        verify(userRepository, times(1)).save(any());
    }

    @Test
    void getNoOfUser() {

        long expectedNoOfUsers = 5;

        when(userRepository.count()).thenReturn(expectedNoOfUsers);

        long result = userHandler.getNoOfUser();

        assertEquals(expectedNoOfUsers, result);

        verify(userRepository, times(1)).count();
    }

    @Test
    void removeUser() {
        int userIdToRemove = 1;
        User userToRemove = new User(userIdToRemove, "Malina", "malina@example.com");

        when(userRepository.findById((long) userIdToRemove)).thenReturn(Optional.of(userToRemove));

        boolean result = userHandler.removeUser(userIdToRemove);

        assertTrue(result);

        verify(userRepository, times(1)).delete(userToRemove);
    }

    @Test
    void gettheUserById() {
        long userId = 1;
        User expectedUser = new User((int) userId, "Malina", "malina@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User result = userHandler.gettheUserById(userId);

        assertEquals(expectedUser, result);

        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void getUserByName() {
        String userName = "Malina";
        User expectedUser = new User(1, userName, "malina@example.com");
        List<User> usersByName = new ArrayList<>();
        usersByName.add(expectedUser);

        when(userRepository.findByName(userName)).thenReturn(usersByName);

        User result = userHandler.getUserByName(userName);

        assertEquals(expectedUser, result);

        verify(userRepository, times(1)).findByName(userName);
    }

    @Test
    void updateUserDetails() {
        User userToUpdate = new User(1, "Malina", "malina@example.com");

        when(userRepository.save(userToUpdate)).thenReturn(userToUpdate);

        User result = userHandler.updateUserDetails(userToUpdate);

        assertEquals(userToUpdate, result);

        verify(userRepository, times(1)).save(userToUpdate);
    }
}