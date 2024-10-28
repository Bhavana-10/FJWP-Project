package com.bank.dao;

import com.bank.entity.Admin;

public interface AdminDAO {
	Admin getAdminByUsername(String username);
	void saveAdmin(Admin admin); // New method to save an admin
}
