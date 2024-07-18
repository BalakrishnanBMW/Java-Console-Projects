class TicketBooker
{

	private static int availableLowerBerth = 5;
	private static int availableUpperBerth = 5;
	private static int availableMiddleBerth = 5;
	private static int availableRAC = 2;
	private static int availableWL = 1;

	private static ArrayList<Integer> bookedTicketList = new ArrayList<Integer>();
	private static Queue<Integer> racQueue = new Queue<>();
	private static Queue<Integer> wlQueue = new Queue<>();

	private static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	private static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1,2));
	private static List<Integer> wlPositions = new ArrayList<>(Arrays.asList(1));

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
		p.seatNumber = lowerBerthPositions.get(0);
		p.allotedBerth = "L";
		lowerBerthPositions.remove(0);
	}

	void getMiddleBerthPosition(Passenger p)
	{
		p.seatNumber = middleBerthPositions.get(0);
		p.allotedBerth = "M";
		middleBerthPositions.remove(0);
	}

	void getUpperBerthPosition(Passenger p)
	{
		p.seatNumber = upperBerthPositions.get(0);
		p.allotedBerth = "U";
		upperBerthPositions.remove(0);
	}

	void getRACPosition(Passenger p)
	{
		p.seatNumber = racPositions.get(0);
		p.allotedBerth = "RAC";
		RACPositions.remove(0);
	}

	void getWLPosition(Passenger p)
	{
		p.seatNumber = wlPositions.get(0);
		p.allotedBerth = "WL";
		wlPositions.remove(0);
	}

}