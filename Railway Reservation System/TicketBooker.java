class TicketBooker 
{

	TicketManager tm = new TicketManager();

	void bookTicket(Passenger p)
	{
		if(p.preferedBerth.toUpperCase().equals("L") && tm.isLowerBerthAvailable()) 
		{
			tm.getLowerBerthPosition(p);
			tm.decreAvailableLowerBerth();
			tm.insertPassengersList(p);
		}
		else if(p.preferedBerth.toUpperCase().equals("M") && tm.isMiddleBerthAvailable()) 
		{
			tm.getMiddleBerthPosition(p);
			tm.decreAvailableMiddleBerth();
			tm.insertPassengersList(p);
		}
		else if(p.preferedBerth.toUpperCase().equals("U") && tm.isUpperBerthAvailable()) 
		{
			tm.getUpperBerthPosition(p);
			tm.decreAvailableUpperBerth();
			tm.insertPassengersList(p);
		}
		else 
		{
			if(tm.isLowerBerthAvailable()) 
			{
				tm.getLowerBerthPosition(p);
				tm.decreAvailableLowerBerth();
				tm.insertPassengersList(p);
			}
			else if(tm.isMiddleBerthAvailable()) 
			{
				tm.getMiddleBerthPosition(p);
				tm.decreAvailableMiddleBerth();
				tm.insertPassengersList(p);
			}
			else if(tm.isUpperBerthAvailable()) 
			{
				tm.getUpperBerthPosition(p);
				tm.decreAvailableUpperBerth();
				tm.insertPassengersList(p);
			}
		}
	}

	void cancelTicket(int id)
	{
		Passenger p = null;
		if(!getPassengerById(id,p)) {
			System.out.println("Id is invalid");
			return;
		}

		int seatNumber = p.seatNumber;
		String allotedBerth = p.allotedBerth;

		if(allotedBerth.equals("L")) {
			tm.putLowerBerthPosition(Passenger);
			tm.increAvailableLowerBerth();
		}
		else if(allotedBerth.equals("M")) {
			tm.putMiddleBerthPosition(Passenger);
			tm.increAvailableLowerBerth();
		}
		else if(allotedBerth.equals("U")) {
			tm.putUpperBerthPosition(Passenger);
			tm.increAvailableLowerBerth();
		}

		if(getAvailableRAC() > 0) 
		{
			
		}
	
	}

}