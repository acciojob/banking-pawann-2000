package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name, balance, 0);
        //minimum balance is 0 by default
        this.institutionName = institutionName;
    }

    public String getName() {
        return super.getName();
    }

    public double getBalance() {
        return super.getBalance();
    }

    public double getMinBalance() {
        return super.getMinBalance();
    }

    public String getInstitutionName() {
        return institutionName;
    }

}
