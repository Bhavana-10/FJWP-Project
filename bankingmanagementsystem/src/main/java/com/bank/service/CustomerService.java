package com.bank.service;

import com.bank.entity.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);
    Customer getCustomer(int customerID);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerID);
}
