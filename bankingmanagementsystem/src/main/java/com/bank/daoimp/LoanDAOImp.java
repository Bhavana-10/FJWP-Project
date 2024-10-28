package com.bank.daoimp;

import com.bank.dao.LoanDAO;
import com.bank.entity.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoanDAOImp implements LoanDAO {
    private SessionFactory sessionFactory;

    public LoanDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveLoan(Loan loan) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loan);
        transaction.commit();
        session.close();
    }

    @Override
    public Loan getLoanById(int loanID) {
        Session session = sessionFactory.openSession();
        Loan loan = session.get(Loan.class, loanID);
        session.close();
        return loan;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateLoan(Loan loan) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(loan);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void deleteLoan(int loanID) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Loan loan = session.get(Loan.class, loanID);
        if (loan != null) {
            session.delete(loan);
        }
        transaction.commit();
        session.close();
    }
}
