package com.bank.serviceimp;

import com.bank.dao.AdminDAO;
import com.bank.daoimp.AdminDAOImp;
import com.bank.entity.Admin;
import com.bank.service.AdminService;
public class AdminServiceImp implements AdminService {
	private AdminDAO adminDAO;

    public AdminServiceImp() {
        this.adminDAO = new AdminDAOImp();
        setupAdmin("Bhavana", "sys@123"); // Insert admin credentials if not already present
    }

    @Override
    public Admin verifyCredentials(String username, String password) {
    	Admin admin = adminDAO.getAdminByUsername(username);

        // Check if the admin exists and password matches
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null; // Return null if username or password is incorrect
    }
    
 // Method to check and insert admin credentials if they don't exist
    private void setupAdmin(String username, String password) {
        Admin admin = adminDAO.getAdminByUsername(username);

        // Add admin if it doesn't exist
        if (admin == null) {
            Admin newAdmin = new Admin();
            newAdmin.setUsername(username);
            newAdmin.setPassword(password);
            ((AdminDAOImp) adminDAO).saveAdmin(newAdmin); // Save using AdminDAOImp
            System.out.println("Admin user created.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }
}
