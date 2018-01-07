package com.gemalto.OO9.autoboxingUnboxing;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private List<Branch> branchList;
    
    public Bank() {
        branchList = new ArrayList<>();
    }
    
    public List<Branch> getBranchList() {
        return branchList;
    }
    
    // add branch
    
    public void addBranch(Branch branch) {
        getBranchList().add(branch);
    }
    
    public Branch findBranchByName(String branchName) {
        for (Branch branch : getBranchList()) {
            if (branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }
    
    // add customer to that branch with transaction
    // public void addCustomerToBranch(String branchName, String customerName,
    // Double transaction) {
    // // if branch exists
    // for (Branch branch : getBranchList()) {
    // if (branch.getBranchName().equals(branchName)) {
    // branch.addCustomer(new Customer(customerName, transaction));
    // }
    // }
    // }
    
    // add customer to that branch with transaction
    public void addCustomerToBranch(Branch branch, String customerName, Double transaction) {
        if (branch != null) {
            branch.addCustomer(new Customer(customerName, transaction));
        }
        
    }
    // add transaction for existing customer for that branch
    // public void addTransactionToCustomer(String branchName, String customerName,
    // Double transaction) {
    // // if branch exists
    // for (Branch branch : getBranchList()) {
    // if (branch.getBranchName().equals(branchName)) {
    // // if customer exists
    // for (Customer customer : branch.getCustomerList()) {
    // if (customer.getCustomerName().equals(customerName)) {
    // customer.addTransaction(transaction);
    // }
    // }
    // }
    // }
    // }
    
    // add transaction for existing customer for that branch
    public void addTransactionToCustomer(Branch branch, Customer customer, Double transaction) {
        if (branch.getCustomerList().contains(customer)) {
            customer.addTransaction(transaction);
        }
    }
    
    // show customer list with their transactions for a branch
    public void showCustomerAndTransactions(Branch branch) {
        for (Customer customer : branch.getCustomerList()) {
            System.out.println("Customer : " + customer);
            for (Double transaction : customer.getTransactions()) {
                System.out.println("Transaction : " + transaction);
            }
            System.out.println("============================");
        }
    }
    
    public static void main(String[] args) {
        
        Bank bank = new Bank();
        
        // Branch pragueBranch = new Branch("Prague");
        // Branch delhiBranch = new Branch("Delhi");
        // Branch varanasiBranch = new Branch("Varanasi");
        
        bank.addBranch(new Branch("Prague"));
        bank.addBranch(new Branch("Delhi"));
        bank.addBranch(new Branch("Varanasi"));
        
        bank.addCustomerToBranch(bank.findBranchByName("Prague"), "Archit Chandra", 480000.32);
        bank.addCustomerToBranch(bank.findBranchByName("Prague"), "Kiki Kol", 780000.32);
        
        bank.addTransactionToCustomer(bank.findBranchByName("Prague"),
                bank.findBranchByName("Prague").findCustomerByName("Archit Chandra"), 47500.67);
        
        bank.addTransactionToCustomer(bank.findBranchByName("Prague"),
                bank.findBranchByName("Prague").findCustomerByName("Archit Chandra"), 5000.00);
        
        bank.showCustomerAndTransactions(bank.findBranchByName("Prague"));
        
    }
    
}
