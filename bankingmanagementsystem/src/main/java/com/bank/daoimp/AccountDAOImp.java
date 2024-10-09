package com.bank.daoimp;

import com.bank.dao.AccountDAO;
import com.bank.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AccountDAOImp implements AccountDAO {
    private SessionFactory sessionFactory;

    public AccountDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
    }

    @Override
    public Account getAccount(String accountNumber) {
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, accountNumber);
        session.close();
        return account;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(account);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void deleteAccount(String accountNumber) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, accountNumber);
        if (account != null) {
            session.delete(account);
        }
        transaction.commit();
        session.close();
    }
}
