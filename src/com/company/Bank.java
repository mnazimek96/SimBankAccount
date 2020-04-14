package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Branch> branches;

    public Bank(){
        this.branches = new ArrayList<Branch>();
    }

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    public void open(){
        Branch vip = new Branch("VIP");
        Branch business = new Branch("BUSINESS");
        Branch regular = new Branch("REGULAR");

        branches.add(vip);
        branches.add(business);
        branches.add(regular);

        Scanner scanner = new Scanner(System.in);
        boolean isOn = true;
        while (true){
            if(isOn){
                System.out.println("Press 0 - add branch");
                System.out.println("Press 1 - add customer to branch");
                System.out.println("Press 2 - make transaction");
                System.out.println("Press 3 - show transaction");
                System.out.println("Press 4 - exit");
                int chose = scanner.nextInt();
                switch (chose){
                    case 0:
                        String password = "1234";
                        System.out.print("Password: ");
                        scanner.nextLine();
                        String enteredPass = scanner.nextLine();
                        if(enteredPass.equals(password)){
                            System.out.print("Branch name: ");
                            String branchName = scanner.nextLine().toUpperCase();
                            branches.add(new Branch(branchName));
                        } else {
                            System.out.println("Access denied!");
                        }
                        break;
                    case 1:
                        scanner.nextLine();
                        System.out.print("Customer name: ");
                        String customerName = scanner.nextLine();
                        Customer newCustomer = new Customer(customerName);

                        System.out.print("To witch branch?: ");
                        String branchName = scanner.nextLine().toUpperCase();
                        for(int i=0; i < branches.size(); i++){
                            if(branchName.equals(branches.get(i).getBranchName())){
                                branches.get(i).addCustomerToBranch(newCustomer);
                            }
                        }
                        System.out.println("#####################");
                        for (int i=0; i < branches.size(); i++){
                            String branchN = branches.get(i).getBranchName();
                            System.out.println(branchN);
                            for(int j=0; j < branches.get(i).getCustomers().size(); j++){
                                String customerN = branches.get(i).getCustomers().get(j).getName();
                                System.out.println((j + 1) + "# " + customerN);
                            }
                            System.out.println("------------------");
                        }
                        System.out.println("#####################");
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.print("Customer name: ");
                        String custName = scanner.nextLine();
                        for (int i=0; i < branches.size(); i++){
                            for(int j=0; j < branches.get(i).getCustomers().size(); j++){
                                if(custName.equals(branches.get(i).getCustomers().get(j).getName())){
                                    System.out.println("(D)posit / (W)ithdraw");
                                    String transaction = scanner.nextLine().toUpperCase();
                                    if(transaction.equals("D")){
                                        System.out.print("+: ");
                                        double transactionValue = scanner.nextDouble();
                                        branches.get(i).getCustomers().get(j).addTransaction(transactionValue);
                                        break;
                                    } else if(transaction.equals("W")){
                                        System.out.print("-: ");
                                        double transactionValue = scanner.nextDouble() * -1;
                                        branches.get(i).getCustomers().get(j).addTransaction(transactionValue);
                                        break;
                                    } else {
                                        System.out.println("Wrong transaction!");
                                        break;
                                    }
                                } else {
                                    System.out.println("Customer " + custName + " not found!");
                                }
                            }
                        }
                        break;
                    case 3:
                        for (int i=0; i < branches.size(); i++){
                            String branchN = branches.get(i).getBranchName();
                            System.out.println(branchN);
                            for(int j=0; j < branches.get(i).getCustomers().size(); j++){
                                String customerN = branches.get(i).getCustomers().get(j).getName();
                                System.out.println((j + 1) + "# " + customerN);
                                branches.get(i).getCustomers().get(j).showTransactions();
                            }
                            System.out.println("------------------");
                        }
                        System.out.println("#####################");
                        break;
                    case 4:
                        System.out.println("See you soon :)");
                        isOn = false;
                        break;
                }
            } else {
                break;
            }
        }
    }
}
