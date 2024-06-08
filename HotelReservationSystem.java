package codeAlpha;

import java.util.Scanner;

public class HotelReservationSystem {
	
	private int totalRooms = 50;
	private int availableRooms = 50;
	private int price  = 12000;
	private int bookedRooms = 0;
	private int x = 0;
	String name;
	
	HotelReservationSystem(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\t____________________Welcome to our Hotel Service____________________");
		System.out.println("What is your name: ");
		name = scan.nextLine();
		System.out.println("\tHello" + name + ".");
	}
	
	boolean bookRoom(int room) {
		if (room == 0) {
			System.out.println("\tNo rooms available!");
		}
		else if(room <= availableRooms) {
			x = room;
			availableRooms -= room;
			bookedRooms += room;
			return true;
		}
		return false;
	}
	
	void reverseBooking(int room) {
		availableRooms += room;
		bookedRooms += room;
	}
	
	void billing() {
		System.out.println("\t\t\t_______________Bill_______________");
		System.out.println("\t\t\tBooking for " + x + "rooms");
		System.out.println("\t\t\tAmount payable: " + price + " * " + x + " : " + (price * x));
		System.out.println("\t\t\t__________________________________");
	}
	
	void hotelDetails() {
		System.out.println("\t_________________Hotel Details_________________");
		System.out.println("\tAvailable rooms: " + availableRooms());
		System.out.println("\tPrice of a room: " + price);
	}
	
	int availableRooms() {
		return availableRooms;
	}
	
static class Menus extends HotelReservationSystem{
		Scanner scan = new Scanner(System.in);
		String strComm;
		int intComm;
		
		void inputStr() {
			System.out.print(">>> ");
			strComm = scan.nextLine();
			scan.reset();
		}
		
		void inputInt() {
			System.out.print(">>> ");
			intComm = scan.nextInt();
			scan.reset();
		}
		
		Menus(){
			System.out.println("\tAvailable options...");
			System.out.println("\tdetails\t\tbookRoom\t\texit");
			while (true) {
				inputStr();
				if (strComm.equalsIgnoreCase("details") || strComm.equalsIgnoreCase("details ")) {
					hotelDetails();
				}
				else if(strComm.equalsIgnoreCase("exit") || strComm.equalsIgnoreCase("exit ")) {
					System.out.println("Thank You!");
					break;
				}
				else if(strComm.equalsIgnoreCase("bookRoom") || strComm.equalsIgnoreCase("bookRoom ")) {
					System.out.println("\tNumber of rooms to book: ");
					inputInt();
					Boolean x = bookRoom(intComm);
					if (x) {
						billing();
						System.out.print("\tAre you sure you want to book: ");
						inputStr();
						if (strComm.equalsIgnoreCase("yes") || strComm.equalsIgnoreCase("yes ")) {
							System.out.println("Bill");
							billing();
						}
						else if (strComm.equalsIgnoreCase("no") || strComm.equalsIgnoreCase("no ")) {
							reverseBooking(intComm);
							System.out.println("Booking canceled.");
						}
					} else {
						System.out.println("\tSorry! Only " + availableRooms() + " rooms are available.");
					}
				}
			}
		}
	}
	
static class Head{
	public static void main(String[] args) {
		Menus m = new Menus();
	}
}
}
