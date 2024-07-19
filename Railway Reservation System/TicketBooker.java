import java.util.*;

class TicketBooker 
{

	TicketManager tm = new TicketManager();

	void bookTicket(Passenger p)
	{
		if(p.getPreferedBerth().toUpperCase().equals("L") && tm.isLowerBerthAvailable()) 
		{
			tm.getLowerBerthPosition(p);
			tm.decreAvailableLowerBerth();
			tm.insertToPassengersList(p);
		}
		else if(p.getPreferedBerth().toUpperCase().equals("M") && tm.isMiddleBerthAvailable()) 
		{
			tm.getMiddleBerthPosition(p);
			tm.decreAvailableMiddleBerth();
			tm.insertToPassengersList(p);
		}
		else if(p.getPreferedBerth().toUpperCase().equals("U") && tm.isUpperBerthAvailable()) 
		{
			tm.getUpperBerthPosition(p);
			tm.decreAvailableUpperBerth();
			tm.insertToPassengersList(p);
		}
		else if(tm.isLowerBerthAvailable() || tm.isMiddleBerthAvailable() || tm.isUpperBerthAvailable())
		{
			if(tm.isLowerBerthAvailable()) 
			{
				tm.getLowerBerthPosition(p);
				tm.decreAvailableLowerBerth();
				tm.insertToPassengersList(p);
			}
			else if(tm.isMiddleBerthAvailable()) 
			{
				tm.getMiddleBerthPosition(p);
				tm.decreAvailableMiddleBerth();
				tm.insertToPassengersList(p);
			}
			else if(tm.isUpperBerthAvailable()) 
			{
				tm.getUpperBerthPosition(p);
				tm.decreAvailableUpperBerth();
				tm.insertToPassengersList(p);
			}
		}
		else if(tm.isRACAvailable())
		{
			tm.getRACPosition(p);
			tm.decreAvailableRAC();
			tm.insertToPassengersList(p);
			tm.pushRACQueue(p);
		}
		else if(tm.isWLAvailable())
		{
			tm.getWLPosition(p);
			tm.decreAvailableWL();
			tm.insertToPassengersList(p);
			tm.pushWLQueue(p);
		}
	}

	void cancelTicket(int id)
	{
		Passenger p = tm.getPassengerById(id);

		int seatNumber = p.getSeatNumber();
		String allotedBerth = p.getAllotedBerth();

		if(allotedBerth.equals("L")) {
			tm.putLowerBerthPosition(p);
			tm.increAvailableLowerBerth();
		}
		else if(allotedBerth.equals("M")) {
			tm.putMiddleBerthPosition(p);
			tm.increAvailableLowerBerth();
		}
		else if(allotedBerth.equals("U")) {
			tm.putUpperBerthPosition(p);
			tm.increAvailableLowerBerth();
		}
		tm.deleteFromPassengersList(p);

		if(tm.racQSize() > 0) 
		{
			Passenger pFromRAC = tm.getPassengerById(tm.pollRACQueue());

			tm.putRACPosition(pFromRAC);
			tm.increAvailableRAC();
			tm.racQRemove(pFromRAC);
			tm.deleteFromPassengersList(pFromRAC);

			bookTicket(pFromRAC);
		
			if(tm.wlQSize() > 0)
			{
				Passenger pFromWL = tm.getPassengerById(tm.pollWLQueue());

				tm.putWLPosition(pFromWL);
				tm.increAvailableWL();
				tm.wlQRemove(pFromWL);
				tm.deleteFromPassengersList(pFromWL);

				bookTicket(pFromWL);
			}
		}
	}

	HashMap<Integer, Passenger> getBookedList() 
	{
		return tm.getPassengersList();
	}

}