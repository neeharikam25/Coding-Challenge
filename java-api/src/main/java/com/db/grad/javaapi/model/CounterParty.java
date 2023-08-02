package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counter_party")
public class CounterParty
{
    @Id
    private long counterparty_id;
    private String name;

    @Id
    @Column(name = "counterparty_id", nullable = false)
    public long getCounterparty_id() {
        return counterparty_id;
    }

    public void setCounterparty_id(long counterparty_id) {
        this.counterparty_id = counterparty_id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
