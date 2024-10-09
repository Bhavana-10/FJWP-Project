package com.bank.dao;

import com.bank.entity.Customer;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    Customer getCustomer(int customerID);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);
}
