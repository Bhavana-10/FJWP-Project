package com.bank.dao;

import com.bank.entity.Branch;

public interface BranchDAO {
    void saveBranch(Branch branch);
    Branch getBranchById(int branchID);
    void updateBranch(Branch branch);
    void deleteBranch(int branchID);
}
