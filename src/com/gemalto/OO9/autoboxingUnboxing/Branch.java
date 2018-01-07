package com.gemalto.OO9.autoboxingUnboxing;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    
    private String branchName;
    private List<Customer> customerList;
    
    public Branch(String branchName) {
        this.branchName = branchName;
        customerList = new ArrayList<>();
    }
    
    public String getBranchName() {
        return branchName;
    }
    
    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    // add customer (name, transaction)
    public void addCustomer(Customer customer) {
        getCustomerList().add(customer);
    }
    
    // add transaction (customer, transaction)
    public void addTransaction(Customer customer, Double transaction) {
        customer.addTransaction(transaction);
    }
    
    public Customer findCustomerByName(String customerName) {
        for (Customer customer : getCustomerList()) {
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }
    
}
