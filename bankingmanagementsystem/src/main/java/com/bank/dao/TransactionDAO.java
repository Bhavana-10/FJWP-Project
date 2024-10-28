package com.bank.dao;

import com.bank.entity.Transaction;

public interface TransactionDAO {
    void saveTransaction(Transaction transaction);
    Transaction getTransactionById(int transactionID);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int transactionID);
}
