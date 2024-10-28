package com.bank.daoimp;

import com.bank.dao.TransactionDAO;
import com.bank.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransactionDAOImp implements TransactionDAO {
    private SessionFactory sessionFactory;

    public TransactionDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveTransaction(Transaction transaction) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();  // Corrected import
        session.save(transaction);
        tx.commit();
        session.close();
    }

    @Override
    public Transaction getTransactionById(int transactionID) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.get(Transaction.class, transactionID);
        session.close();
        return transaction;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateTransaction(Transaction transaction) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction(); // Corrected import
        session.update(transaction);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void deleteTransaction(int transactionID) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction(); // Corrected import
        Transaction transaction = session.get(Transaction.class, transactionID);
        if (transaction != null) {
            session.delete(transaction);
        }
        tx.commit();
        session.close();
    }
}