package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "security")
public class Security {
    @Id
    private int securityId;
    private String isin;
    private String cusip;

    private String issuerName;
    private float coupon;

    private String securityType;
    private float faceValue;
    private String securityCurrency;
    private String securityStatus;
    private LocalDate bondMaturityDate;

    private int bookId;

    @Id
    @Column(name = "security_id", nullable = false)
    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "cusip", nullable = false)
    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @Column(name = "issuer_name", nullable = false)
    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    @Column(name = "coupon", nullable = false)
    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    @Column(name = "security_type", nullable = false)
    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    @Column(name = "face_value", nullable = false)
    public float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(float faceValue) {
        this.faceValue = faceValue;
    }

    @Column(name = "security_currency", nullable = false)
    public String getSecurityCurrency() {
        return securityCurrency;
    }

    public void setSecurityCurrency(String securityCurrency) {
        this.securityCurrency = securityCurrency;
    }

    @Column(name = "security_status", nullable = false)
    public String getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    @Column(name = "bond_maturity_date", nullable = false)
    public LocalDate getBondMaturityDate() {
        return bondMaturityDate;
    }

    public void setBondMaturityDate(LocalDate bondMaturityDate) {
        this.bondMaturityDate = bondMaturityDate;
    }

    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}

