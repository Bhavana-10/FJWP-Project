package com.bank.serviceimp;

import com.bank.dao.CustomerDAO;
import com.bank.daoimp.CustomerDAOImp;
import com.bank.entity.Customer;
import com.bank.service.CustomerService;

public class CustomerServiceImp implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAOImp();

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(int customerID) {
        return customerDAO.getCustomer(customerID);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int customerID) {
        customerDAO.deleteCustomer(customerID);
    }
}
