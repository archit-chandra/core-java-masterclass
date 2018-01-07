package com.gemalto.OO9.autoboxingUnboxing;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private String customerName;
    private List<Double> transactions;
    
    public Customer(String customerName, Double transaction) {
        this.customerName = customerName;
        transactions = new ArrayList<>();
        transactions.add(transaction);
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public List<Double> getTransactions() {
        return transactions;
    }
    
    public void addTransaction(Double transaction) {
        transactions.add(transaction);
    }
    
    @Override
    public String toString() {
        return customerName;
    }
    
}
