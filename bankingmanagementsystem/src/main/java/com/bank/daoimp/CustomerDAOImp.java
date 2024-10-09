package com.bank.daoimp;

import com.bank.dao.CustomerDAO;
import com.bank.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDAOImp implements CustomerDAO {
    private SessionFactory sessionFactory;

    public CustomerDAOImp() {
        sessionFactory = new Configuration().configure("/com/bank/hibernate.cfg.xml").buildSessionFactory();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer getCustomer(int customerID) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, customerID);
        session.close();
        return customer;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
	@Override
    public void deleteCustomer(int customerID) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, customerID);
        if (customer != null) {
            session.delete(customer);
        }
        transaction.commit();
        session.close();
    }
}
