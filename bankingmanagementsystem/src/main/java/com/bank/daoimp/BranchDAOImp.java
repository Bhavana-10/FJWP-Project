package com.bank.daoimp;

import com.bank.dao.BranchDAO;
import com.bank.entity.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BranchDAOImp implements BranchDAO {
    private SessionFactory sessionFactory;

    public BranchDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveBranch(Branch branch) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(branch);
        transaction.commit();
        session.close();
    }

    @Override
    public Branch getBranchById(int branchID) {
        Session session = sessionFactory.openSession();
        Branch branch = session.get(Branch.class, branchID);
        session.close();
        return branch;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateBranch(Branch branch) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(branch);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void deleteBranch(int branchID) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Branch branch = session.get(Branch.class, branchID);
        if (branch != null) {
            session.delete(branch);
        }
        transaction.commit();
        session.close();
    }
}
