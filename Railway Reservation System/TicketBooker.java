class TicketBooker 
{

	TicketManager tm = new TicketManager();

	void bookTicket(Passenger p)
	{
		if(p.getPreferedBerth().toUpperCase().equals("L") && tm.isLowerBerthAvailable()) 
		{
			tm.getLowerBerthPosition(p);
			tm.decreAvailableLowerBerth();
			tm.insertPassengersList(p);
		}
		else if(p.getPreferedBerth().toUpperCase().equals("M") && tm.isMiddleBerthAvailable()) 
		{
			tm.getMiddleBerthPosition(p);
			tm.decreAvailableMiddleBerth();
			tm.insertPassengersList(p);
		}
		else if(p.getPreferedBerth().toUpperCase().equals("U") && tm.isUpperBerthAvailable()) 
		{
			tm.getUpperBerthPosition(p);
			tm.decreAvailableUpperBerth();
			tm.insertPassengersList(p);
		}
		else if(tm.isLowerBerthAvailable() || tm.isMiddleBerthAvailable() || tm.isUpperBerthAvailable())
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
		else if(tm.isRACAvailable())
		{
			tm.getRACPosition(p);
			tm.decreAvailableRAC();
			tm.insertPassengersList(p);
			tm.pushRACQueue(p);
		}
		else if(tm.isWLAvailable())
		{
			tm.getWLPosition(p);
			tm.decreAvailableWL();
			tm.insertPassengersList(p);
			tm.pushWLQueue(p);
		}
	}

	void cancelTicket(int id)
	{
		Passenger p = null;
		if(!tm.getPassengerById(id,p)) {
			System.out.println("Id is invalid");
			return;
		}

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

		if(tm.racQSize() > 0) 
		{
			Passenger pFromRAC = null;
			int idrac = tm.pollRACQueue();
			tm.getPassengerById(idrac, pFromRAC);

			tm.putRACPosition(pFromRAC);
			tm.increAvailableRAC();
			tm.racQRemove(pFromRAC);

			bookTicket(pFromRAC);
		
			if(tm.wlQSize() > 0)
			{
				Passenger pFromWL = null;
				int idwl = tm.pollWLQueue();
				tm.getPassengerById(idwl, pFromWL);

				tm.putWLPosition(pFromWL);
				tm.increAvailableWL();
				tm.wlQRemove(pFromWL);

				bookTicket(pFromWL);
			}
		}
	}

}