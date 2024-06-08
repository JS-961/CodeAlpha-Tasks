package codeAlpha;

import java.util.Scanner;

public class TravelItineraryPlanner {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("1. Select Destination");
			System.out.println("2. Enter Dates");
			System.out.println("3. Choose Preferences");
			System.out.println("4. Calculate Total Budget");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				selectDestination();
				break;
			case 2:
				enterDates();
				break;
			case 3:
				System.out.println("First, you must select the destination");
				selectDestination();
				break;
			case 4:
				System.out.println("First, you must select the destination and preferences");
				break;
			case 5:
				System.out.println("Exiting program. Thank you!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");	
			}
		}
		while (choice != 5);
		scan.close();
	}
	
	private static void selectDestination() {
		int choice;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("1. Paris");
			System.out.println("2. Tokyo");
			System.out.println("3. New York");
			System.out.println("4. Australia");
			System.out.println("0. Back to Main Menu");
			System.out.println("Enter your choice: ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				choosePreferences("Paris");
				break;
			case 2:
				choosePreferences("Tokyo");
				break;
			case 3:
				choosePreferences("New York");
				break;
			case 4:
				choosePreferences("Australia");
				break;
			case 0:
				System.out.println("Going back to the Main Menu.");
				return;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 4 (or 0 to go back).");
			}
		}
		while (true);
	}
	
	private static void enterDates() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date of the trip: ");
		String date = scan.nextLine();
		System.out.println("Dates entered.");
	}
	
	private static void choosePreferences(String destination) {
		Scanner scan = new Scanner(System.in);
		System.out.println("===== Planning trip to " + destination + " =====");
		
		System.out.println("Select your preferences:");
		System.out.println("1. Low-end");
		System.out.println("2. Mid-end");
		System.out.println("3. High-end");
		System.out.println("Enter your preference (1-3): ");
		
		int preference = scan.nextInt();
		getPreferenceName(preference);
		
		double budget = calculateBudget(destination, preference);
		System.out.println("\n===== Trip Itinerary Summary =====");
		System.out.println("Destination: " + destination);
		System.out.println("Preference: " + getPreferenceName(preference));
		System.out.println("Total Budget: $" + budget);
		
		System.out.println("===================================");
	}
	
	private static String getPreferenceName(int preference) {
		switch(preference) {
		case 1:
			return "Low-end";
		case 2:
			return "Mid-end";
		case 3:
			return "High-end";
		default:
			return "Unknown";
		}
	}
	
	private static double calculateBudget(String destination, int preference) {
		double baseBudget;
		
		switch (destination.toLowerCase()) {
		case "paris":
			baseBudget = 1500.0;
			break;
		case "tokyo":
			baseBudget = 2000.0;
			break;
		case "new york":
			baseBudget = 1800.0;
			break;
		case "australia":
			baseBudget = 2800.0;
			break;
		default:
			baseBudget = 0.0;
		}
		
		switch (preference) {
		case 1:
			return baseBudget;
		case 2:
			return baseBudget * 1.5;
		case 3:
			return baseBudget * 2.0;
		default:
			return 0.0;
		}
	}
}