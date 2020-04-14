package com.company;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName){
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public void addCustomerToBranch(Customer customer){
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " added");
    }

    public String getBranchName(){
        return branchName;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}
