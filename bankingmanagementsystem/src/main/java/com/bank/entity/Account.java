package com.bank.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Account {
	
    @Id
    private String accountNumber;   // Primary Key
    private String accountType;
    private double balance;

    // ManyToOne relationship to Customer entity
    @ManyToOne
    @JoinColumn(name = "customerID")	// Foreign key in the account table
    private Customer customer;

    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL)
    private Set<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL)
    private Set<Transaction> incomingTransactions;

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(Set<Transaction> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public Set<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(Set<Transaction> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }
}
