package basicProblems;

import java.util.Scanner;

class Account {
    private int id;
    private double balance;
    private double interestRate;

    public Account(int id, double balance, double interestRate) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        double balance = scanner.nextDouble();
        double interestRate = scanner.nextDouble();
        int noOfYears = scanner.nextInt();

        Account account = new Account(id, balance, interestRate);

        double interestAmount = calculateInterest(account, noOfYears);


        System.out.printf("%.3f%n", interestAmount);
    }

    public static double calculateInterest(Account account, int noOfYears) {
        double interestRate = account.getInterestRate();
        double additionalRate = (interestRate * noOfYears) / 100;
        double finalInterestRate = interestRate + additionalRate;
        return (account.getBalance() * finalInterestRate) / 100;
    }
}
