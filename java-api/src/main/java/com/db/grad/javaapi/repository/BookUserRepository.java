package com.db.grad.javaapi.repository;


import com.db.grad.javaapi.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, Long> {
    @Query(nativeQuery = true, value = "select * from bookuser where book_id = :id")
    List<BookUser> findByIdd(int id);

    @Query(nativeQuery = true, value = "select book_id from bookuser where user_id = :id")
    List<Integer> findBookIdByUserIdd(int id);
}
