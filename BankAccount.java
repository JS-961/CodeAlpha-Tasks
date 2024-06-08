package codeAlpha;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit of " + amount + " made. New Balance is: " + balance);
        } else {
            System.out.println("Amount must be greater than zero");
        }
    }

    public void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " processed. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Only " + balance + " available.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}
