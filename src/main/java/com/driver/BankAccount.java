package com.driver;
import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        try {
            if (sum <= 0 || sum >= Integer.MAX_VALUE) {
                throw new Exception("Account Number can not be generated");
            }

            Random random = new Random();
            StringBuilder accountNumberBuilder = new StringBuilder();

            // Generate digits for the account number
            for (int i = 0; i < digits - 1; i++) {
                int digit = random.nextInt(10); // Generate a random digit between 0 and 9
                // Ensure the sum constraint is maintained
                while (sum - digit < digits - i - 1 || sum - digit > (digits - i - 1) * 9) {
                    digit = random.nextInt(10);
                }
                accountNumberBuilder.append(digit);
                sum -= digit;
            }
            // The last digit is the remaining sum
            accountNumberBuilder.append(sum);

            return accountNumberBuilder.toString();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        try {
            if (this.balance - amount < 0) {
                throw new Exception("Insufficient Balance");
            } else {
                this.balance-=amount;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}