package com.bank.serviceimp;

import com.bank.dao.TransactionDAO;
import com.bank.daoimp.TransactionDAOImp;
import com.bank.entity.Transaction;
import com.bank.service.TransactionService;

public class TransactionServiceImp implements TransactionService {
    private TransactionDAO transactionDAO = new TransactionDAOImp();

    @Override
    public void addTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    @Override
    public Transaction getTransaction(int transactionID) {
        return transactionDAO.getTransactionById(transactionID);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        transactionDAO.updateTransaction(transaction);
    }

    @Override
    public void deleteTransaction(int transactionID) {
        transactionDAO.deleteTransaction(transactionID);
    }
}
