package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
    @Query(nativeQuery = true, value = "select * from security where book_id = :id")
    Security findSecurityByBookId(int id);

    @Query(nativeQuery = true, value = "select s.* from security s, book b, bookuser bk where s.book_id =b.book_id and s.book_id=bk.book_id and b.book_id=bk.book_id and bk.user_id=:id ")
    List<Security> findSecurityByUserId(int id);
}

