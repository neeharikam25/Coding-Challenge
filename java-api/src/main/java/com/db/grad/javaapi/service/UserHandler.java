package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHandler {

    private UserRepository UserRepository;
    @Autowired
    public UserHandler( UserRepository UserRepository )
    {
        this.UserRepository = UserRepository;
    }

    public List<User> getAllUser()
    {
        return UserRepository.findAll();
    }
    public User addUser(User theUser)
    {
        return UserRepository.save( theUser );
    }
    public long getNoOfUser()
    {
        return UserRepository.count();
    }

    public boolean removeUser(long uniqueId)
    {
        boolean result = false;

        Optional<User> thetheUser = UserRepository.findById(uniqueId);
        if(thetheUser.isPresent())
        {
            UserRepository.delete(thetheUser.get());
            result = true;
        }

        return  result;
    }

    public User gettheUserById(long uniqueId)
    {
        return UserRepository.findById(uniqueId).get();
    }


    public User getUserByName(String UserName )
    {

        User UserToFind = new User();
        UserToFind.setName(UserName);

        List<User> User = UserRepository.findByName(UserName);
        User result = null;

        if( User.size() == 1)
            result = User.get(0);

        return result;
    }

    public int getUserIdByEmail(String email )
    {

        List<Integer> User = UserRepository.findIdByEmail(email);
        Integer result = null;

        if( User.size() == 1)
            result = User.get(0);

        return result;
    }



    public User updateUserDetails(User UserToUpdate)
    {
        return UserRepository.save( UserToUpdate );
    }
}
