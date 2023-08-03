package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>
{
    @Query(nativeQuery = true, value = "select * from trade where security_id = :id")
    List<Trade> findBySecurityId(int id);

    @Query(nativeQuery = true, value = "select * from trade where trade_id = :id")
    List<Trade> findById(int id);
}