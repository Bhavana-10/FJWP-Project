package com.bank.service;

import com.bank.entity.Transaction;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    Transaction getTransaction(int transactionID);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transactionID);
}
