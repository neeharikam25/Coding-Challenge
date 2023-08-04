package com.db.grad.javaapi.repository;


import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from users where name = :name")
    List<User> findByName(String name);

    @Query(nativeQuery = true, value = "select user_id from users where email = :email")
    List<Integer> findIdByEmail(String email);
}
