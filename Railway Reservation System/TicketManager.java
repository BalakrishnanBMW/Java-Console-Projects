import java.util.*;

class TicketManager
{

	private static int availableLowerBerth = 3;
	private static int availableUpperBerth = 3;
	private static int availableMiddleBerth = 3;
	private static int availableRAC = 1;
	private static int availableWL = 1;

	private static ArrayList<Integer> bookedTicketList = new ArrayList<Integer>();
	private static Queue<Integer> racQueue = new LinkedList<>();
	private static Queue<Integer> wlQueue = new LinkedList<>();

	private static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1,2));
	private static List<Integer> wlPositions = new ArrayList<>(Arrays.asList(1));

	private static HashMap<Integer, Passenger> passengersList = new HashMap<>();

	int getAvailableLowerBerth()
	{
		return this.availableLowerBerth;
	}
	void increAvailableLowerBerth()
	{
		this.availableLowerBerth++;
	}
	void decreAvailableLowerBerth()
	{
		this.availableLowerBerth--;
	}
	boolean isLowerBerthAvailable()
	{
		return this.availableLowerBerth!=0;
	}
	
	int getAvailableUpperBerth()
	{
		return this.availableUpperBerth;
	}
	void increAvailableUpperBerth()
	{
		this.availableUpperBerth++;
	}
	void decreAvailableUpperBerth()
	{
		this.availableUpperBerth--;
	}
	boolean isUpperBerthAvailable()
	{
		return this.availableUpperBerth!=0;
	}
	
	int getAvailableMiddleBerth()
	{
		return this.availableMiddleBerth;
	}
	void increAvailableMiddleBerth()
	{
		this.availableMiddleBerth++;
	}
	void decreAvailableMiddleBerth()
	{
		this.availableMiddleBerth--;
	}
	boolean isMiddleBerthAvailable()
	{
		return this.availableMiddleBerth!=0;
	}
	
	int getAvailableRAC()
	{
		return this.availableRAC;
	}
	void increAvailableRAC()
	{
		this.availableRAC++;
	}
	void decreAvailableRAC()
	{
		this.availableRAC--;
	}
	boolean isRACAvailable()
	{
		return this.availableRAC!=0;
	}
	
	int getAvailableWL()
	{
		return this.availableWL;
	}
	void increAvailableWL()
	{
		this.availableWL++;
	}
	void decreAvailableWL()
	{
		this.availableWL--;
	}
	boolean isWLAvailable()
	{
		return this.availableWL!=0;
	}

	void getLowerBerthPosition(Passenger p)
	{
		p.setSeatNumber(lowerBerthPositions.get(0));
		p.setAllotedBerth("L");
		lowerBerthPositions.remove(0);
	}

	void getMiddleBerthPosition(Passenger p)
	{
		p.setSeatNumber(middleBerthPositions.get(0));
		p.setAllotedBerth("M");
		middleBerthPositions.remove(0);
	}

	void getUpperBerthPosition(Passenger p)
	{
		p.setSeatNumber(upperBerthPositions.get(0));
		p.setAllotedBerth("U");
		upperBerthPositions.remove(0);
	}

	void getRACPosition(Passenger p)
	{
		p.setSeatNumber(racPositions.get(0));
		p.setAllotedBerth("RAC");
		racPositions.remove(0);
	}

	void getWLPosition(Passenger p)
	{
		p.setSeatNumber(wlPositions.get(0));
		p.setAllotedBerth("WL");
		wlPositions.remove(0);
	}

	void putLowerBerthPosition(Passenger p)
	{
		lowerBerthPositions.add(p.getSeatNumber());
		p.setSeatNumber(-1);
	}

	void putMiddleBerthPosition(Passenger p)
	{
		middleBerthPositions.add(p.getSeatNumber());
		p.setSeatNumber(-1);
	}

	void putUpperBerthPosition(Passenger p)
	{
		upperBerthPositions.add(p.getSeatNumber());
		p.setSeatNumber(-1);
	}

	void putRACPosition(Passenger p)
	{
		racPositions.add(p.getSeatNumber());
		p.setSeatNumber(-1);
	}

	void putWLPosition(Passenger p)
	{
		wlPositions.add(p.getSeatNumber());
		p.setSeatNumber(-1);
	}

	void insertToPassengersList(Passenger p)
	{
		passengersList.put(p.getPassengerId(), p);
	}
	void deleteFromPassengersList(Passenger p)
	{
		passengersList.remove(p.getPassengerId());
	}
	
	HashMap<Integer, Passenger> getPassengersList()
	{
		return passengersList;
	}

	Passenger getPassengerById(int id)
	{
		if(passengersList.containsKey(id)) 
		{
			return passengersList.get(id);
		}
	return null;
	}


	void pushRACQueue(Passenger p)
	{
		racQueue.add(p.getPassengerId());
	}
	void pushWLQueue(Passenger p)
	{
		wlQueue.add(p.getPassengerId());
	}
	int racQSize()
	{
		return racQueue.size();
	}
	int wlQSize()
	{
		return wlQueue.size();
	}
	int pollRACQueue()
	{
		return racQueue.poll();
	}
	int pollWLQueue()
	{
		return wlQueue.poll();
	}
	void racQRemove(Passenger p)
	{
		racQueue.remove(p.getPassengerId());
	}
	void wlQRemove(Passenger p)
	{
		wlQueue.remove(p.getPassengerId());
	}

}