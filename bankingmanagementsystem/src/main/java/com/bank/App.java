package com.bank;

/* import com.bank.entity.Account;

import com.bank.entity.Transaction;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import com.bank.serviceimp.AccountServiceImp;
import com.bank.serviceimp.TransactionServiceImp;
import java.util.Date;
import java.util.*; */


/* import com.bank.entity.Loan;
import com.bank.entity.Customer;
import com.bank.service.LoanService;
import com.bank.service.CustomerService;
import com.bank.serviceimp.LoanServiceImp;
import com.bank.serviceimp.CustomerServiceImp;
import java.util.*;
import java.util.Date; */


/* import com.bank.entity.Branch;
import com.bank.service.BranchService;
import com.bank.serviceimp.BranchServiceImp; 
import java.util.*; */

import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.service.AccountService;
import com.bank.service.CustomerService; 
import com.bank.serviceimp.AccountServiceImp;
import com.bank.serviceimp.CustomerServiceImp; 
import java.util.*; 

/**
 * 
 * Hello World
 * 
 **/
public class App {
    public static void main(String[] args) {
    	
// --- Transaction Entity Operations ---
        
        // Create an instance of TransactionService and AccountService
      /*  TransactionService transactionService = new TransactionServiceImp();
        AccountService accountService = new AccountServiceImp(); 
        //CustomerService customerService = new CustomerServiceImp();
        Scanner scanner = new Scanner(System.in);

        // --- ADD Operation ---
        System.out.println("Adding a new transaction...");
        
        System.out.print("Enter From Account Number: ");
        String fromAccountNo = scanner.next();
        // Check if from account exists
        Account fromAccount = accountService.getAccount(fromAccountNo);

        // Handle non-existent from account
        if (fromAccount == null) {
            System.out.println("Error: From account number not found. Do you want to create a new one? (y/n)");
            String createFromAccount = scanner.next().toLowerCase();
            if (createFromAccount.equals("y")) {
                // Create a new account with customer information
                Account account = new Account();
                account.setAccountNumber("AC345678901");    // Primary Key
                account.setAccountType("Savings");
                account.setBalance(5000.0);
                                
                // Save the new account using the service
                accountService.addAccount(account);
                System.out.println("New account created successfully!");
                fromAccount = account; // Set the newly created account to fromAccount
            } else {
                System.out.println("Transaction cancelled.");
                //return; // Exit if user doesn't want to create a new account
            }
        }
    
        System.out.print("Enter To Account Number: ");
        String toAccountNo = scanner.next();
        // Check if to account exists
        Account toAccount = accountService.getAccount(toAccountNo);

        // Handle non-existent to account (similar logic as above)
        if (toAccount == null) {
        	System.out.println("Error: To account number not found. Do you want to create a new one? (y/n)");
            String createToAccount = scanner.next().toLowerCase();
            if (createToAccount.equals("y")) {
                // Create a new account with customer information
                Account account = new Account();
                account.setAccountNumber("AC123789023");    // Primary Key
                account.setAccountType("Savings");
                account.setBalance(7000.0);                
                // Save the new account using the service
                accountService.addAccount(account);
                System.out.println("New account created successfully!");
                toAccount = account; // Set the newly created account to toAccount
            }
            // ... (repeat logic for creating a new toAccount if needed)
        } else {
            System.out.println("Transaction cancelled.");
            //return; // Exit if user doesn't want to create a new account
        }
            
        // Create a new transaction
        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);  // Set Account entity (now holds the newly created account)
        transaction.setToAccount(toAccount);     // Set Account entity
        transaction.setTransactionDate(new Date()); // Set current date
        transaction.setAmount(1500.0);
        transaction.setTransactionType("Deposit");

        // Save the transaction and print success message
        transactionService.addTransaction(transaction);
        System.out.println("Transaction added successfully!");  */

        // --- GET Operation ---
        /* System.out.println("\nRetrieving transaction...");
        System.out.print("Enter Transaction ID: ");
        int transactionId = scanner.nextInt();
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
        } */
        
        // --- UPDATE Operation ---
       /* System.out.println("\nUpdating account...");
        System.out.print("Enter new amount: ");
        double newAmount = scanner.nextDouble();
        transaction.setAmount(newAmount);
        // Ask for the new transaction type
        System.out.print("Enter new transaction type (Deposit/Withdrawal/Transfer): ");
        String newTransactionType = scanner.next();

        // Validate the transaction type
        if (newTransactionType.equalsIgnoreCase("Deposit") || 
            newTransactionType.equalsIgnoreCase("Withdrawal") || 
            newTransactionType.equalsIgnoreCase("Transfer")) {
            
            // Update the transaction type in the transaction object
            transaction.setTransactionType(newTransactionType);
            transactionService.updateTransaction(transaction);
            System.out.println("Transaction updated successfully!");
        } else {
            System.out.println("Invalid transaction type. Update cancelled."); 
        } */
        
        // --- DELETE Operation ---
       /* System.out.println("\nDeleting transaction...");
        System.out.print("Enter Transaction ID to delete: ");
        int deleteTransactionID = scanner.nextInt();
        transactionService.deleteTransaction(deleteTransactionID );
        System.out.println("Transaction deleted successfully!"); */
    	
    	// --- Loan Entity Operations ---
    	
    	// Create an instance of LoanService
        /* LoanService loanService = new LoanServiceImp();
        CustomerService customerService = new CustomerServiceImp();
        
        Scanner scanner = new Scanner(System.in);

        // --- ADD OPERATION ---
        System.out.println("Adding a new loan...");
        
        // Fetch or create a customer
        Customer customer = customerService.getCustomer(1);  // Fetch or assume a customer already exists
        if (customer == null) {
            customer = new Customer();
            customer.setCustomerID(1); // Set the correct ID
            customer.setName("Sita"); // Set other details as needed
            customer.setPhone("0987654321");
            customer.setAddress("Bangalore");
            customerService.addCustomer(customer);
        }
        
        // Create a new Loan
        Loan loan = new Loan();
        loan.setLoanType("Home Loan");
        loan.setLoanAmount(250000.0);
        Date startDate = new Date();		// Set start date as the current date
        loan.setStartDate(new Date());  
        
        // Set end date by adding 5 year to the start date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1);  // Adding 5 years
        Date endDate = calendar.getTime();
        loan.setEndDate(endDate); 
        loan.setCustomer(customer);         // Foreign key referencing CustomerID

        // Save the loan and print a success message
        loanService.addLoan(loan);
        System.out.println("Loan of type " + loan.getLoanType() + " added successfully!");
        System.out.println("Loan End Date: " + loan.getEndDate()); */

        // --- GET OPERATION (Retrieve Loan by ID) ---
       /* System.out.println("\nRetrieving loan...");
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
        } */

        // --- UPDATE OPERATION ---
        /* System.out.println("\nUpdating loan...");
        System.out.print("Enter new loan amount: ");
        double newLoanAmount = scanner.nextDouble();
        loan.setLoanAmount(newLoanAmount);
		loanService.updateLoan(loan);
		System.out.println("Loan " + loan.getLoanType() + " updated successfully!"); */

        // --- DELETE OPERATION ---
       /* System.out.println("\nDeleting loan...");
        System.out.print("Enter Loan ID to delete: ");
        int deleteLoanID = scanner.nextInt();
        loanService.deleteLoan(deleteLoanID);
        System.out.println("Loan with ID " + deleteLoanID + " deleted successfully!"); */

    	// --- Branch Entity Operations ---
    	
    	// Create an instance of BranchService
        /* BranchService branchService = new BranchServiceImp();
        Scanner scanner = new Scanner(System.in);
        
        // --- ADD Operation ---
        // Add a new Branch
        System.out.println("Adding a new branch...");
        Branch branch = new Branch();
        branch.setBranchName("Main Branch");
        branch.setAddress("Hyderabad");

        // Save branch and print success message
        branchService.addBranch(branch);
        System.out.println("Branch added successfully!");  */

        // --- GET Operation ---
        /* System.out.println("\nFetching branch by ID...");
        System.out.print("Enter Branch ID: ");
        int branchId = scanner.nextInt();
        Branch fetchedBranch = branchService.getBranch(branchId);
        if (fetchedBranch != null) {
        	System.out.println("Branch Details:");
            System.out.println("Branch ID: " + fetchedBranch.getBranchID());
            System.out.println("Branch Name: " + fetchedBranch.getBranchName());
            System.out.println("Branch Address: " + fetchedBranch.getAddress());
        } else {
            System.out.println("Branch not found.");
        } */

        // --- UPDATE Operation ---
        // Fetch Branch by ID to update details
        /* Branch existingBranch = branchService.getBranch(1);  // Assuming ID 1 exists
        if (existingBranch != null) {
            existingBranch.setBranchName("1town");
            existingBranch.setAddress("Vijayawada");
            
         // Update Branch Details
            branchService.updateBranch(existingBranch);
            System.out.println("Branch " + existingBranch.getBranchName() + " updated successfully!");
        } else {
            System.out.println("Branch not found for update.");
        } */

        // --- DELETE Operation ---
        /* System.out.println("\nDeleting branch...");
        System.out.print("Enter Branch ID to delete: ");
        int deleteBranchId = scanner.nextInt();
        branchService.deleteBranch(deleteBranchId);
        System.out.println("Branch deleted successfully!"); */
        
    	// --- Account Entity Operations ---
    	
    	// Create an instance of AccountService
        /* AccountService accountService = new AccountServiceImp();
        CustomerService customerService = new CustomerServiceImp();
        
        Scanner scanner = new Scanner(System.in);

        // --- ADD OPERATION ---
        System.out.println("Adding a new account...");
        
        // Fetch or create a customer
        Customer customer = customerService.getCustomer(1);  // Fetch or assume a customer already exists
        if (customer == null) {
            customer = new Customer();
            customer.setCustomerID(1); // Set the correct ID
            customer.setName("Sita"); // Set other details as needed
            customer.setPhone("0987654321");
            customer.setAddress("Bangalore");
            customerService.addCustomer(customer);
        } 
        
        // Create a new account
        Account account = new Account();
        account.setAccountNumber("AC345678901");    // Primary Key
        account.setAccountType("Savings");
        account.setBalance(5000.0);
        account.setCustomer(customer);   // Foreign key referencing CustomerID

        // Save the account and print a success message
        accountService.addAccount(account);
        System.out.println("Account " + account.getAccountNumber() + " added successfully!");  */

        // --- GET OPERATION ---
       /* System.out.println("\nFetching account...");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account fetchedAccount = accountService.getAccount(accountNumber);
        if (fetchedAccount != null) {
        	System.out.println("Account Details:");
            System.out.println("Account Retrieved: " + fetchedAccount.getAccountNumber());
            System.out.println("Account Type: " + fetchedAccount.getAccountType());
            System.out.println("Account Balance: " + fetchedAccount.getBalance());
        } else {
            System.out.println("Account not found.");
        }  */

        // --- Update Operation ---
       /* System.out.println("\nUpdating account...");
        System.out.print("Enter new balance: ");
        double newBalance = scanner.nextDouble();
        account.setBalance(newBalance);
        accountService.updateAccount(account);
        System.out.println("Account " + account.getAccountNumber() + " updated successfully!");  */

        // --- Delete Operation ---
        /* System.out.println("\nDeleting account...");
        System.out.print("Enter Account Number to delete: ");
        String deleteAccountNum = scanner.next();
        accountService.deleteAccount(deleteAccountNum);
        System.out.println("Account " + deleteAccountNum + " deleted successfully!");  */

    	//scanner.close(); 
    	
    	// --- Customer Entity Operations ---
    	
        // Create an instance of CustomerService
        CustomerService customerService = new CustomerServiceImp();

        // --- ADD OPERATION ---
        // Add a new customer
        Customer customer = new Customer();
        customer.setName("Bhavana");
        customer.setPhone("1234567890");
        customer.setAddress("Hyderabad");

        // Save the customer and print a success message
        customerService.addCustomer(customer);
        System.out.println("Customer " + customer.getName() + " added successfully!"); 

        // --- GET OPERATION (Retrieve a Customer by ID) ---
        // Fetch customer by ID and display details
        /* Customer fetchedCustomer = customerService.getCustomer(1);  // Assuming ID 1 exists
        if (fetchedCustomer != null) {
            System.out.println("Customer Details:");
            System.out.println("ID: " + fetchedCustomer.getCustomerID());
            System.out.println("Name: " + fetchedCustomer.getName());
            System.out.println("Phone: " + fetchedCustomer.getPhone());
            System.out.println("Address: " + fetchedCustomer.getAddress());
        } else {
            System.out.println("Customer not found.");
        }  */

        // --- UPDATE OPERATION ---
        // Fetch customer by ID to update details
        /* Customer existingCustomer = customerService.getCustomer(1);  // Assuming ID 1 exists
        if (existingCustomer != null) {
            existingCustomer.setName("Bhavana Borra");
            existingCustomer.setPhone("0987654321");
            existingCustomer.setAddress("Bangalore");

            // Update customer details
            customerService.updateCustomer(existingCustomer);
            System.out.println("Customer " + existingCustomer.getName() + " updated successfully!");
        } else {
            System.out.println("Customer not found for update.");
        } */

        // --- DELETE OPERATION ---
        // Fetch customer by ID to delete
       /* Customer customerToDelete = customerService.getCustomer(1);  // Assuming ID 1 exists
        if (customerToDelete != null) {
            // Delete the customer
            customerService.deleteCustomer(customerToDelete.getCustomerID());
            System.out.println("Customer " + customerToDelete.getName() + " deleted successfully!");
        } else {
            System.out.println("Customer not found for deletion."); 
        } */ 
    }
}