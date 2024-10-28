package com.bank.service;

import com.bank.entity.Branch;

public interface BranchService {
    void addBranch(Branch branch);
    Branch getBranch(int branchID);
    void updateBranch(Branch branch);
    void deleteBranch(int branchID);
}
