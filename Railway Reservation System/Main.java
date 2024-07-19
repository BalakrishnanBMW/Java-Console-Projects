import java.util.Scanner;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		TicketBooker tb = new TicketBooker();
		int choice = 0;
		System.out.println("\n\tWelcome To Train Ticker Booking System.\n");

		do {
			System.out.println("\tMenu");
			System.out.println("1.Book Ticket\n2. Cancel Ticket\n3.View Booked List\n4.View Availability\n5.Exit");
			choice = sc.nextInt();
			sc.nextLine();
			

	switch(choice) {
		case 1 -> {
			System.out.println("Booking Ticket");
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
			System.out.println("Enter your age : ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter gender : ");
			String gender = sc.nextLine();
			System.out.println("Enter Prefered Berth: ");
			String preferedBerth = sc.nextLine();
			Passenger p = new Passenger(name, age, gender, preferedBerth);
			tb.bookTicket(p);
			System.out.println(" - Ticket booked - "); 
		}
		case 2 -> {
			System.out.println("Cancelling Ticket");
			System.out.print("Enter the Passenger id : ");
			int id = sc.nextInt();
			tb.cancelTicket(id);
			// System.out.println(" - Booked ticket cancelled - ");
		}
		case 3 -> {
			System.out.println("Booked Ticket List");
		}
		case 4 -> {
			System.out.println("Available Ticket Counts");
		}
		case 5 -> {
			System.out.println("Exit");
		}
		
	}


		}while(choice<5);


	}
}