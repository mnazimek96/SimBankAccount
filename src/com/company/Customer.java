package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name){
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public void addTransaction(double value){
        transactions.add(value);
    }

    public void showTransactions(){
        for(int i=0; i < transactions.size(); i++){
            System.out.println(transactions.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
