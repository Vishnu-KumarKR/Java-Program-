/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashwi
 */
class BankAccount {
    private final int accountId;
    private final String name;
    private double balance;

    public BankAccount(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public void transferTo(BankAccount destination, double amount) {
        if (balance >= amount) {
            balance -= amount;
            destination.balance += amount;
            printReceipt(destination, amount);
        } else {
            System.out.println("Insufficient funds for transfer from Account " + accountId);
        }
    }

    public void printReceipt(BankAccount destination, double amount) {
        System.out.println("Transaction Receipt:");
        System.out.println("Account id: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Transfer amount: Rs." + amount);
        System.out.println("Account Balance: Rs." + balance);
        System.out.println("Destination Account id: " + destination.accountId);
        System.out.println("Destination Account Balance: Rs." + destination.balance);
        System.out.println("-----------------------------------------");
    }
}

public class AccountTransaction {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount(12344, "Account A", 5000);
        BankAccount accountB = new BankAccount(56789, "Account B", 2500);

        // Transfer 1500 from Account A to B
        accountA.transferTo(accountB, 1500);

        // Transfer 3000 from Account B to A
        accountB.transferTo(accountA, 3000);
    }
}

