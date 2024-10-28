package com.bank;

import java.util.Scanner;
import com.bank.entity.Admin;
import com.bank.service.AdminService;
import com.bank.serviceimp.AdminServiceImp;

import com.bank.entity.Branch;
import com.bank.service.BranchService;
import com.bank.serviceimp.BranchServiceImp; 
import java.util.*; 

import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.service.AccountService;
import com.bank.service.CustomerService; 
import com.bank.serviceimp.AccountServiceImp;
import com.bank.serviceimp.CustomerServiceImp; 
import java.util.*; 

import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import com.bank.serviceimp.AccountServiceImp;
import com.bank.serviceimp.TransactionServiceImp;
import java.util.Date;
import java.util.*;

import com.bank.entity.Loan;
import com.bank.entity.Customer;
import com.bank.service.LoanService;
import com.bank.service.CustomerService;
import com.bank.serviceimp.LoanServiceImp;
import com.bank.serviceimp.CustomerServiceImp;
import java.util.*;
import java.util.Date; 


/**
 * 
 * Hello World
 * 
 **/
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminServiceImp();
        
        // Admin login
        System.out.println("Admin Login");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        // Verify credentials
        Admin admin = adminService.verifyCredentials(username, password);
        // If admin is null, login failed
        if (admin == null) {
            System.out.println("Invalid username or password. Access denied.");
            scanner.close();
            return; // Exit the application if login fails
        }

        // If login successful
        System.out.println("Login successful!");
    	
    	// --- Branch Entity Operations ---
    	
    	// Create an instance of BranchService
        BranchService branchService = new BranchServiceImp();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n --- Welcome to Banking Management System --- ");
        while (true) {
            System.out.println("\n--- Branch Management System ---");
            System.out.println("1. Add Branch");
            System.out.println("2. Get Branch by ID");
            System.out.println("3. Update Branch");
            System.out.println("4. Delete Branch");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // --- ADD OPERATION ---
                    System.out.println("Adding a new branch...");
                    Branch branch = new Branch();
                    System.out.print("Enter Branch Name: ");
                    branch.setBranchName(scanner.nextLine());
                    System.out.print("Enter Branch Address: ");
                    branch.setAddress(scanner.nextLine());

                    branchService.addBranch(branch);
                    System.out.println("Branch added successfully!");
                    break;

                case 2:
                    // --- GET OPERATION ---
                    System.out.println("Fetching branch by ID...");
                    System.out.print("Enter Branch ID: ");
                    int branchId = scanner.nextInt();
                    scanner.nextLine();

                    Branch fetchedBranch = branchService.getBranch(branchId);
                    if (fetchedBranch != null) {
                        System.out.println("Branch Details:");
                        System.out.println("Branch ID: " + fetchedBranch.getBranchID());
                        System.out.println("Branch Name: " + fetchedBranch.getBranchName());
                        System.out.println("Branch Address: " + fetchedBranch.getAddress());
                    } else {
                        System.out.println("Branch not found.");
                    }
                    break;

                case 3:
                    // --- UPDATE OPERATION ---
                    System.out.println("Updating branch...");
                    System.out.print("Enter Branch ID to update: ");
                    int branchIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    Branch existingBranch = branchService.getBranch(branchIdToUpdate);
                    if (existingBranch != null) {
                        System.out.print("Enter New Branch Name: ");
                        existingBranch.setBranchName(scanner.nextLine());
                        System.out.print("Enter New Branch Address: ");
                        existingBranch.setAddress(scanner.nextLine());

                        branchService.updateBranch(existingBranch);
                        System.out.println("Branch " + existingBranch.getBranchName() + " updated successfully!");
                    } else {
                        System.out.println("Branch not found for update.");
                    }
                    break;

                case 4:
                    // --- DELETE OPERATION ---
                    System.out.println("Deleting branch...");
                    System.out.print("Enter Branch ID to delete: ");
                    int deleteBranchId = scanner.nextInt();
                    scanner.nextLine();

                    Branch branchToDelete = branchService.getBranch(deleteBranchId);
                    if (branchToDelete != null) {
                        branchService.deleteBranch(deleteBranchId);
                        System.out.println("Branch " + branchToDelete.getBranchName() + " deleted successfully!");
                    } else {
                        System.out.println("Branch not found for deletion.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Branch Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    	
        // --- Customer Entity Operations ---
    	
        // Create an instance of CustomerService
        CustomerService customerService = new CustomerServiceImp();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	System.out.println("--- Welcome to Banking Management System---");
            System.out.println("\n--- Customer Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Get Customer by ID");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // --- ADD OPERATION ---
                    Customer newCustomer = new Customer();
                    System.out.print("Enter Customer Name: ");
                    newCustomer.setName(sc.nextLine());
                    System.out.print("Enter Customer Phone: ");
                    newCustomer.setPhone(sc.nextLine());
                    System.out.print("Enter Customer Address: ");
                    newCustomer.setAddress(sc.nextLine());

                    customerService.addCustomer(newCustomer);
                    System.out.println("Customer " + newCustomer.getName() + " added successfully!");
                    break;

                case 2:
                    // --- GET OPERATION ---
                    System.out.print("Enter Customer ID to retrieve: ");
                    int idToGet = sc.nextInt();
                    sc.nextLine();

                    Customer fetchedCustomer = customerService.getCustomer(idToGet);
                    if (fetchedCustomer != null) {
                        System.out.println("Customer Details:");
                        System.out.println("ID: " + fetchedCustomer.getCustomerID());
                        System.out.println("Name: " + fetchedCustomer.getName());
                        System.out.println("Phone: " + fetchedCustomer.getPhone());
                        System.out.println("Address: " + fetchedCustomer.getAddress());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    // --- UPDATE OPERATION ---
                    System.out.print("Enter Customer ID to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();

                    Customer existingCustomer = customerService.getCustomer(idToUpdate);
                    if (existingCustomer != null) {
                        System.out.print("Enter New Name: ");
                        existingCustomer.setName(sc.nextLine());
                        System.out.print("Enter New Phone: ");
                        existingCustomer.setPhone(sc.nextLine());
                        System.out.print("Enter New Address: ");
                        existingCustomer.setAddress(sc.nextLine());

                        customerService.updateCustomer(existingCustomer);
                        System.out.println("Customer " + existingCustomer.getName() + " updated successfully!");
                    } else {
                        System.out.println("Customer not found for update.");
                    }
                    break;

                case 4:
                    // --- DELETE OPERATION ---
                    System.out.print("Enter Customer ID to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();

                    Customer customerToDelete = customerService.getCustomer(idToDelete);
                    if (customerToDelete != null) {
                        customerService.deleteCustomer(idToDelete);
                        System.out.println("Customer " + customerToDelete.getName() + " deleted successfully!");
                    } else {
                        System.out.println("Customer not found for deletion.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Customer Management System. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }  
    	
    	// --- Account Entity Operations ---
    	
    	// Create an instance of AccountService
        AccountService accountService = new AccountServiceImp();
        CustomerService customerService = new CustomerServiceImp();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("\n--- Welcome to Banking Management System ---");
            System.out.println("\n--- Account Management System ---");
            System.out.println("1. Add Account");
            System.out.println("2. Get Account by Number");
            System.out.println("3. Update Account Balance");
            System.out.println("4. Delete Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // --- ADD OPERATION ---
                    System.out.println("Adding a new account...");

                    // Fetch or create a customer
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    
                    Customer customer = customerService.getCustomer(customerId);
                    if (customer == null) {
                        customer = new Customer();
                        customer.setCustomerID(customerId);
                        System.out.print("Enter Customer Name: ");
                        customer.setName(scanner.nextLine());
                        System.out.print("Enter Customer Phone: ");
                        customer.setPhone(scanner.nextLine());
                        System.out.print("Enter Customer Address: ");
                        customer.setAddress(scanner.nextLine());
                        customerService.addCustomer(customer);
                    }

                    // Create a new account
                    Account account = new Account();
                    System.out.print("Enter Account Number: ");
                    account.setAccountNumber(scanner.nextLine());
                    System.out.print("Enter Account Type: ");
                    account.setAccountType(scanner.nextLine());
                    System.out.print("Enter Initial Balance: ");
                    account.setBalance(scanner.nextDouble());
                    scanner.nextLine();  // Consume newline
                    account.setCustomer(customer);

                    // Save the account and print a success message
                    accountService.addAccount(account);
                    System.out.println("Account " + account.getAccountNumber() + " added successfully!");
                    break;

                case 2:
                    // --- GET OPERATION ---
                    System.out.println("Fetching account...");
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();

                    Account fetchedAccount = accountService.getAccount(accountNumber);
                    if (fetchedAccount != null) {
                        System.out.println("Account Details:");
                        System.out.println("Account Number: " + fetchedAccount.getAccountNumber());
                        System.out.println("Account Type: " + fetchedAccount.getAccountType());
                        System.out.println("Account Balance: " + fetchedAccount.getBalance());
                        System.out.println("Customer Name: " + fetchedAccount.getCustomer().getName());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // --- UPDATE OPERATION ---
                    System.out.println("Updating account balance...");
                    System.out.print("Enter Account Number to update: ");
                    String updateAccountNumber = scanner.nextLine();

                    Account accountToUpdate = accountService.getAccount(updateAccountNumber);
                    if (accountToUpdate != null) {
                        System.out.print("Enter New Balance: ");
                        double newBalance = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        accountToUpdate.setBalance(newBalance);
                        accountService.updateAccount(accountToUpdate);
                        System.out.println("Account " + accountToUpdate.getAccountNumber() + " updated successfully!");
                    } else {
                        System.out.println("Account not found for update.");
                    }
                    break;

                case 4:
                    // --- DELETE OPERATION ---
                    System.out.println("Deleting account...");
                    System.out.print("Enter Account Number to delete: ");
                    String deleteAccountNum = scanner.nextLine();

                    Account accountToDelete = accountService.getAccount(deleteAccountNum);
                    if (accountToDelete != null) {
                        accountService.deleteAccount(deleteAccountNum);
                        System.out.println("Account " + deleteAccountNum + " deleted successfully!");
                    } else {
                        System.out.println("Account not found for deletion.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Account Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        
    	// --- Transaction Entity Operations ---
        
        // Create an instance of TransactionService and AccountService
        TransactionService transactionService = new TransactionServiceImp();
        AccountService accountService = new AccountServiceImp(); 
        // CustomerService customerService = new CustomerServiceImp();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
        	System.out.println("\n--- Welcome to Banking Management System ---");
            System.out.println("\n--- Transaction Operations Menu ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. Retrieve Transaction");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // ADD Operation
                    System.out.println("Adding a new transaction...");
                    
                    System.out.print("Enter From Account Number: ");
                    String fromAccountNo = scanner.nextLine();
                    Account fromAccount = accountService.getAccount(fromAccountNo);

                    // Handle non-existent from account
                    if (fromAccount == null) {
                        System.out.println("Error: From account number not found. Do you want to create a new one? (y/n)");
                        String createFromAccount = scanner.nextLine().toLowerCase();
                        if (createFromAccount.equals("y")) {
                            Account account = new Account();
                            System.out.print("Enter New Account Number: ");
                            account.setAccountNumber(scanner.nextLine());
                            System.out.print("Enter Account Type: ");
                            account.setAccountType(scanner.nextLine());
                            System.out.print("Enter Initial Balance: ");
                            account.setBalance(scanner.nextDouble());
                            scanner.nextLine(); // Consume newline
                                                        
                            accountService.addAccount(account);
                            System.out.println("New account created successfully!");
                            fromAccount = account; // Set the newly created account to fromAccount
                        } else {
                            System.out.println("Transaction cancelled.");
                            continue; // Go back to menu
                        }
                    }

                    System.out.print("Enter To Account Number: ");
                    String toAccountNo = scanner.nextLine();
                    Account toAccount = accountService.getAccount(toAccountNo);

                    // Handle non-existent to account
                    if (toAccount == null) {
                        System.out.println("Error: To account number not found. Do you want to create a new one? (y/n)");
                        String createToAccount = scanner.nextLine().toLowerCase();
                        if (createToAccount.equals("y")) {
                            Account account = new Account();
                            System.out.print("Enter New Account Number: ");
                            account.setAccountNumber(scanner.nextLine());
                            System.out.print("Enter Account Type: ");
                            account.setAccountType(scanner.nextLine());
                            System.out.print("Enter Initial Balance: ");
                            account.setBalance(scanner.nextDouble());
                            scanner.nextLine(); // Consume newline
                            
                            accountService.addAccount(account);
                            System.out.println("New account created successfully!");
                            toAccount = account; // Set the newly created account to toAccount
                        } else {
                            System.out.println("Transaction cancelled.");
                            continue; // Go back to menu
                        }
                    }
                    
                    // Create a new transaction
                    Transaction transaction = new Transaction();
                    transaction.setFromAccount(fromAccount);
                    transaction.setToAccount(toAccount);
                    transaction.setTransactionDate(new Date());

                    System.out.print("Enter Transaction Amount: ");
                    transaction.setAmount(scanner.nextDouble());
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Transaction Type (Deposit/Withdrawal/Transfer): ");
                    transaction.setTransactionType(scanner.nextLine());
                    
                    // Save the transaction
                    transactionService.addTransaction(transaction);
                    System.out.println("Transaction added successfully!");
                    break;

                case 2: // GET Operation
                    System.out.print("Enter Transaction ID: ");
                    int transactionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Transaction retrievedTransaction = transactionService.getTransaction(transactionId);
                    if (retrievedTransaction != null) {
                        System.out.println("Transaction Retrieved: ");
                        System.out.println("Transaction ID: " + retrievedTransaction.getTransactionID());
                        System.out.println("Transaction Date: " + retrievedTransaction.getTransactionDate());
                        System.out.println("Transaction Type: " + retrievedTransaction.getTransactionType());
                        System.out.println("Amount: " + retrievedTransaction.getAmount());
                        System.out.println("From Account: " + retrievedTransaction.getFromAccount().getAccountNumber());
                        System.out.println("To Account: " + retrievedTransaction.getToAccount().getAccountNumber());
                    } else {
                        System.out.println("Transaction with ID " + transactionId + " not found."); 
                    }
                    break;

                case 3: // UPDATE Operation
                    System.out.print("Enter Transaction ID to update: ");
                    transactionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Transaction existingTransaction = transactionService.getTransaction(transactionId);
                    if (existingTransaction != null) {
                        System.out.print("Enter new amount: ");
                        double newAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        existingTransaction.setAmount(newAmount);
                        
                        System.out.print("Enter new transaction type (Deposit/Withdrawal/Transfer): ");
                        String newTransactionType = scanner.nextLine();
                        if (newTransactionType.equalsIgnoreCase("Deposit") || 
                            newTransactionType.equalsIgnoreCase("Withdrawal") || 
                            newTransactionType.equalsIgnoreCase("Transfer")) {
                            existingTransaction.setTransactionType(newTransactionType);
                            transactionService.updateTransaction(existingTransaction);
                            System.out.println("Transaction updated successfully!");
                        } else {
                            System.out.println("Invalid transaction type. Update cancelled."); 
                        }
                    } else {
                        System.out.println("Transaction not found.");
                    }
                    break;

                case 4: // DELETE Operation
                    System.out.print("Enter Transaction ID to delete: ");
                    int deleteTransactionID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    transactionService.deleteTransaction(deleteTransactionID);
                    System.out.println("Transaction deleted successfully!");
                    break;

                case 5: // Exit
                    exit = true;
                    System.out.println("Exiting transaction operations. GoodBye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close(); 

    	
    	// --- Loan Entity Operations ---
    	
    	// Create an instance of LoanService
        LoanService loanService = new LoanServiceImp();
        CustomerService customerService = new CustomerServiceImp(); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("\n--- Welcome to Banking Management System ---");
            System.out.println("\n--- Loan Management System ---");
            System.out.println("1. Add Loan");
            System.out.println("2. Retrieve Loan by ID");
            System.out.println("3. Update Loan");
            System.out.println("4. Delete Loan");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // --- ADD OPERATION ---
                    System.out.println("Adding a new loan...");

                    // Fetch or create a customer
                    System.out.print("Enter Customer ID to fetch: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customerService.getCustomer(customerId);  // Fetch or assume a customer already exists

                    if (customer == null) {
                        customer = new Customer();
                        customer.setCustomerID(customerId); // Set the correct ID from user input
                        System.out.print("Enter Customer Name: ");
                        customer.setName(scanner.nextLine()); // Set other details as needed
                        System.out.print("Enter Customer Phone: ");
                        customer.setPhone(scanner.nextLine());
                        System.out.print("Enter Customer Address: ");
                        customer.setAddress(scanner.nextLine());
                        customerService.addCustomer(customer);
                        System.out.println("New customer created with ID: " + customer.getCustomerID());
                    } else {
                    	System.out.println("Customer found: " + customer.getName());
                    }

                    // Create a new Loan
                    Loan loan = new Loan();
                    System.out.print("Enter Loan Type: ");
                    loan.setLoanType(scanner.nextLine());
                    System.out.print("Enter Loan Amount: ");
                    loan.setLoanAmount(scanner.nextDouble());
                    loan.setStartDate(new Date());  // Set start date as the current date

                    // Set end date by adding 1 year to the start date
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(loan.getStartDate());
                    calendar.add(Calendar.YEAR, 1);  // Change this to 5 for a 5-year loan
                    loan.setEndDate(calendar.getTime());
                    loan.setCustomer(customer);         // Foreign key referencing CustomerID

                    // Save the loan and print a success message
                    loanService.addLoan(loan);
                    System.out.println("Loan of type " + loan.getLoanType() + " added successfully!");
                    System.out.println("Loan End Date: " + loan.getEndDate());
                    break;

                case 2:
                    // --- GET OPERATION ---
                    System.out.println("\nRetrieving loan...");
                    System.out.print("Enter Loan ID: ");
                    int loanId = scanner.nextInt();
                    Loan retrievedLoan = loanService.getLoan(loanId);
                    if (retrievedLoan != null) {
                        System.out.println("Loan Retrieved: " + retrievedLoan.getLoanType());
                        System.out.println("Loan Amount: " + retrievedLoan.getLoanAmount());
                        System.out.println("Start Date: " + retrievedLoan.getStartDate());
                        System.out.println("End Date: " + retrievedLoan.getEndDate());
                    } else {
                        System.out.println("Loan with ID " + loanId + " not found.");
                    }
                    break;

                case 3:
                    // --- UPDATE OPERATION ---
                    System.out.println("\nUpdating loan...");
                    System.out.print("Enter Loan ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    Loan existingLoan = loanService.getLoan(idToUpdate);
                    if (existingLoan != null) {
                        System.out.print("Enter new loan amount: ");
                        double newLoanAmount = scanner.nextDouble();
                        existingLoan.setLoanAmount(newLoanAmount);
                        loanService.updateLoan(existingLoan);
                        System.out.println("Loan " + existingLoan.getLoanType() + " updated successfully!");
                    } else {
                        System.out.println("Loan not found for update.");
                    }
                    break;

                case 4:
                    // --- DELETE OPERATION ---
                    System.out.println("\nDeleting loan...");
                    System.out.print("Enter Loan ID to delete: ");
                    int deleteLoanID = scanner.nextInt();
                    loanService.deleteLoan(deleteLoanID);
                    System.out.println("Loan with ID " + deleteLoanID + " deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting Loan Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 	
    } 
}