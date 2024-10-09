package com.bank.serviceimp;

import com.bank.dao.BranchDAO;
import com.bank.daoimp.BranchDAOImp;
import com.bank.entity.Branch;
import com.bank.service.BranchService;

public class BranchServiceImp implements BranchService {
    private BranchDAO branchDAO = new BranchDAOImp();

    @Override
    public void addBranch(Branch branch) {
        branchDAO.saveBranch(branch);
    }

    @Override
    public Branch getBranch(int branchID) {
        return branchDAO.getBranchById(branchID);
    }

    @Override
    public void updateBranch(Branch branch) {
        branchDAO.updateBranch(branch);
    }

    @Override
    public void deleteBranch(int branchID) {
        branchDAO.deleteBranch(branchID);
    }
}
