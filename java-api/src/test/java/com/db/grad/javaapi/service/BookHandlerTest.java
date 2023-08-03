package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
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

class BookHandlerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookHandler bookHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllBook() {
        List<Book> Bookstest = new ArrayList<>();
        Bookstest.add(new Book(1, "Teodora"));
        Bookstest.add(new Book(2, "Xizhen"));

        when(bookRepository.findAll()).thenReturn(Bookstest);

        List<Book> result = bookHandler.getAllBook();

        assertEquals(2, result.size());
        assertEquals("Teodora", result.get(0).getName());
        assertEquals("Xizhen", result.get(1).getName());

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void addBook() {
        Book newBook = new Book(1,"Malina");

        when(bookRepository.save(any())).thenReturn(newBook);

        Book result = bookHandler.addBook(newBook);

        assertEquals(newBook, result);
    }

    @Test
    void getNoOfBook() {
        long expectedNoOfBooks = 5;

        when(bookRepository.count()).thenReturn(expectedNoOfBooks);

        long result = bookHandler.getNoOfBook();

        assertEquals(expectedNoOfBooks, result);
        verify(bookRepository, times(1)).count();
    }

    @Test
    void removeBook() {
        int uniqueIdToRemove = 1;
        Book bookToRemove = new Book(uniqueIdToRemove, "Virginia");

        when(bookRepository.findById((long) uniqueIdToRemove)).thenReturn(Optional.of(bookToRemove));

        boolean result = bookHandler.removeBook(uniqueIdToRemove);

        assertTrue(result);
        verify(bookRepository, times(1)).delete(bookToRemove);
    }

    @Test
    void getBookById() {
        int uniqueId = 1;
        Book expectedBook = new Book(uniqueId, "Virginia");

        when(bookRepository.findById((long) uniqueId)).thenReturn(Optional.of(expectedBook));

        Book result = bookHandler.getBookById(uniqueId);

        assertEquals(expectedBook, result);
    }

    @Test
    void getBookByName() {
        String bookName = "Chirca";
        Book expectedBook = new Book(1,bookName);
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(expectedBook);

        when(bookRepository.findByName(bookName)).thenReturn(testBooks);

        Book result = bookHandler.getBookByName(bookName);

        assertEquals(expectedBook, result);
    }

    @Test
    void updateBookDetails() {
        Book bookToUpdate = new Book(1, "Freedom");

        when(bookRepository.save(any())).thenReturn(bookToUpdate);

        Book result = bookHandler.updateBookDetails(bookToUpdate);

        assertEquals(bookToUpdate, result);
    }
}