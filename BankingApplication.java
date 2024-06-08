package codeAlpha;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        BankAccount myAccount = new BankAccount();

        int userChoice;
        double amount;

        do {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            userChoice = scan.nextInt();

            switch(userChoice) {
                case 1:
                    System.out.println("Your current balance is: " + myAccount.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    amount = scan.nextDouble();
                    myAccount.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ");
                    amount = scan.nextDouble();
                    myAccount.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using our Banking Application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 4.");
            }
        } while(userChoice != 4);

        scan.close();
    }
}
