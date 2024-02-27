package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount curr = new CurrentAccount("Curr",1000,"AASDAF");
        System.out.println(curr.getBalance());
        curr.validateLicenseId();
    }
}