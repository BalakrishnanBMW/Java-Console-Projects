import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		TicketBooker tb = new TicketBooker();
		TicketManager tm = new TicketManager();
		int choice = 0;
		System.out.println("\n\tWelcome To Train Ticker Booking System.\n");

		do {
			System.out.println("\tMenu");
			System.out.println("1.Book Ticket\n2.Cancel Ticket\n3.View Booked List\n4.View Availability\n5.Exit");
			System.out.print("Enter the choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			

	switch(choice) {
		case 1 -> {
		    if(tm.isWLAvailable()) {
			System.out.println("Booking Ticket");
			System.out.print("Enter your name : ");
			String name = sc.nextLine();
			System.out.print("Enter your age : ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter gender : ");
			String gender = sc.nextLine();
			System.out.print("Enter Prefered Berth: ");
			String preferedBerth = sc.nextLine();
			Passenger p = new Passenger(name, age, gender, preferedBerth);
			tb.bookTicket(p);
			System.out.println("\n - Ticket booked successfully - "); 
			System.out.println(p+"\n");
		    } else {
			System.out.println("All tickets were sold.");
		    }
		}
		case 2 -> {
			System.out.println("Cancelling Ticket");
			System.out.print("Enter the Passenger id : ");
			int id = sc.nextInt();
			tb.cancelTicket(id);
			// System.out.println(" - Booked ticket cancelled - ");
		}
		case 3 -> {
			System.out.println("Booked Tickets");
			HashMap<Integer, Passenger> bookedList = tb.getBookedList();
			for(Map.Entry<Integer, Passenger> entry : bookedList.entrySet())
			{
				System.out.println(entry.getValue());
			}
		}
		case 4 -> {
			System.out.println("Available Ticket Counts");
			System.out.println("Lower : "+tm.getAvailableLowerBerth());
			System.out.println("Middle : "+tm.getAvailableMiddleBerth());
			System.out.println("Upper : "+tm.getAvailableUpperBerth());
			System.out.println("RAC : "+tm.getAvailableRAC());
			System.out.println("Waiting List : "+tm.getAvailableWL());
		}
		case 5 -> {
			System.out.println("Exit");
		}
		
	}


		}while(choice<5);


	}
}