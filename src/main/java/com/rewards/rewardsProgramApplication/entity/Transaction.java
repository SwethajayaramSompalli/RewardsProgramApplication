package com.rewards.rewardsProgramApplication.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long id;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "TRANSACTION_DATE")
    private Timestamp transactionDate;
    @Column(name = "AMOUNT")
    private double amt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustId() {
        return customerId;
    }

    public void setCustId(Long custId) {
        this.customerId = custId;
    }

    public Timestamp getTranDate() {
        return transactionDate;
    }

    public void setTranDate(Timestamp tranDate) {
        this.transactionDate = tranDate;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
