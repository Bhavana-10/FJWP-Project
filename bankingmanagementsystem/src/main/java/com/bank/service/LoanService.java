package com.bank.service;

import com.bank.entity.Loan;

public interface LoanService {
    void addLoan(Loan loan);
    Loan getLoan(int loanID);
    void updateLoan(Loan loan);
    void deleteLoan(int loanID);
}
