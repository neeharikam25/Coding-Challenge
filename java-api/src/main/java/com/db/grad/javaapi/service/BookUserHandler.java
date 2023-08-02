package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUserHandler {

    private BookUserRepository BookUserRepository;
    @Autowired
    public BookUserHandler( BookUserRepository BookUserRepository )
    {
        BookUserRepository = BookUserRepository;
    }
    public List<BookUser> getAllBookUser()
    {
        return BookUserRepository.findAll();
    }
    public BookUser addBookUser(BookUser theBookUser)
    {
        return BookUserRepository.save( theBookUser );
    }
    public long getNoOfBookUser()
    {
        return BookUserRepository.count();
    }

    public boolean removeBookUser(long uniqueId)
    {
        boolean result = false;

        Optional<BookUser> theBookUser = BookUserRepository.findById(uniqueId);
        if(theBookUser.isPresent())
        {
            BookUserRepository.delete(theBookUser.get());
            result = true;
        }

        return  result;
    }

    public BookUser getBookUserById(long uniqueId)
    {
        return BookUserRepository.findById(uniqueId).get();
    }


    public BookUser getBookUserById(int BookUserId )
    {
        List<BookUser> BookUser = BookUserRepository.findByIdd(BookUserId);
        BookUser result = null;

        if( BookUser.size() == 1)
            result = BookUser.get(0);

        return result;
    }

    public BookUser updateBookUserDetails(BookUser BookUserToUpdate)
    {
        return BookUserRepository.save( BookUserToUpdate );
    }
}
