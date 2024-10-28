package com.bank.daoimp;

import com.bank.dao.AdminDAO;
import com.bank.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminDAOImp implements AdminDAO {
	private SessionFactory sessionFactory;

    public AdminDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    /**
     * Retrieves an Admin entity by username.
     * @param username The username of the Admin to retrieve.
     * @return The Admin entity if found; otherwise, null.
     */
    @Override
    public Admin getAdminByUsername(String username) {
        Session session = sessionFactory.openSession();
        Admin admin = session.createQuery("FROM Admin WHERE username = :username", Admin.class)
                .setParameter("username", username)
                .uniqueResult();
        session.close();
        return admin;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveAdmin(Admin admin) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
        session.close();
    }
}
