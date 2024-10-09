package com.bank.serviceimp;

import com.bank.dao.AccountDAO;
import com.bank.daoimp.AccountDAOImp;
import com.bank.entity.Account;
import com.bank.service.AccountService;

public class AccountServiceImp implements AccountService {
    private AccountDAO accountDAO = new AccountDAOImp();

    @Override
    public void addAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.getAccount(accountNumber);
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        accountDAO.deleteAccount(accountNumber);
    }
}
