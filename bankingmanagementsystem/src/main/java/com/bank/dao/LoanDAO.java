package com.bank.dao;

import com.bank.entity.Loan;

public interface LoanDAO {
    void saveLoan(Loan loan);
    Loan getLoanById(int loanID);
    void updateLoan(Loan loan);
    void deleteLoan(int loanID);
}
