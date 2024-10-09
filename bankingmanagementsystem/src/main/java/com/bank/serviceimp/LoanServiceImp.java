package com.bank.serviceimp;

import com.bank.dao.LoanDAO;
import com.bank.daoimp.LoanDAOImp;
import com.bank.entity.Loan;
import com.bank.service.LoanService;

public class LoanServiceImp implements LoanService {
    private LoanDAO loanDAO = new LoanDAOImp();

    @Override
    public void addLoan(Loan loan) {
        loanDAO.saveLoan(loan);
    }

    @Override
    public Loan getLoan(int loanID) {
        return loanDAO.getLoanById(loanID);
    }

    @Override
    public void updateLoan(Loan loan) {
        loanDAO.updateLoan(loan);
    }

    @Override
    public void deleteLoan(int loanID) {
        loanDAO.deleteLoan(loanID);
    }
}
