package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterPartyRepository extends JpaRepository<CounterParty, Long>
{
    @Query(nativeQuery = true, value = "select * from counter_party where name = :name")
    List<CounterParty> findByName(String name);
}