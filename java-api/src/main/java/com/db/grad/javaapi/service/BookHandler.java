package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookHandler {
    private BookRepository BookRepository;
    @Autowired
    public BookHandler( BookRepository BookRepository )
    {
        this.BookRepository = BookRepository;
    }

    public List<Book> getAllBook()
    {
        return BookRepository.findAll();
    }
    public Book addBook(Book theBook)
    {
        return BookRepository.save( theBook );
    }
    public long getNoOfBook()
    {
        return BookRepository.count();
    }

    public boolean removeBook(long uniqueId)
    {
        boolean result = false;

        Optional<Book> theBook = BookRepository.findById(uniqueId);
        if(theBook.isPresent())
        {
            BookRepository.delete(theBook.get());
            result = true;
        }

        return  result;
    }

    public Book getBookById(long uniqueId)
    {
        return BookRepository.findById(uniqueId).get();
    }


    public Book getBookByName(String BookName )
    {
        List<Book> Books = BookRepository.findByName(BookName);
        Book result = null;

        if( Books.size() == 1)
            result = Books.get(0);

        return result;
    }

    public Book updateBookDetails(Book BookToUpdate)
    {
        return BookRepository.save( BookToUpdate );
    }
}
