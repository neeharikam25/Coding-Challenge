package com.db.grad.javaapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "trade")
public class Trade
{
    @Id
    private int trade_id;
    private String currency;

    private String status;

    private String type;
    private float quantity;

    private float unit_price;

    private Date trade_settlement_date;

    private Date trade_date;
    private int security_id;

    private int counterparty_id;

@Id
@Column(name = "trade_id", nullable = false)
    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }

    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "quantity", nullable = false)
    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Column(name = "unit_price", nullable = false)
    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    @Column(name = "trade_settlement_date", nullable = false)
    public Date getTrade_settlement_date() {
        return trade_settlement_date;
    }

    public void setTrade_settlement_date(Date trade_settlement_date) {
        this.trade_settlement_date = trade_settlement_date;
    }

    @Column(name = "trade_date", nullable = false)
    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    @Column(name = "security_id", nullable = false)
    public int getSecurity_id() {
        return security_id;
    }

    public void setSecurity_id(int security_id) {
        this.security_id = security_id;
    }

    @Column(name = "counterparty_id", nullable = false)
    public int getCounterparty_id() {
        return counterparty_id;
    }

    public void setCounterparty_id(int counterparty_id) {
        this.counterparty_id = counterparty_id;
    }
}

