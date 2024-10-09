package com.bank.dao;

import com.bank.entity.Account;

public interface AccountDAO {
    void saveAccount(Account account);
    Account getAccount(String accountNumber);
    void updateAccount(Account account);
    void deleteAccount(String accountNumber);
}
