package com.bank.service;
import com.bank.entity.Admin;
public interface AdminService {
	Admin verifyCredentials(String username, String password);
}
