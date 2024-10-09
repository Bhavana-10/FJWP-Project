package com.bank.service;

import com.bank.entity.Account;

public interface AccountService {
    void addAccount(Account account);
    Account getAccount(String accountNumber);
    void updateAccount(Account account);
    void deleteAccount(String accountNumber);
}
