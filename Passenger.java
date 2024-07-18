class Passenger
{
	private static int id;
	private int passengerId;
	private String passengerName;
	private int age;
	private String gender;
	private String preferedBerth;
	private String allotedBerth;
	private int seatNumber;



	Passenger(String passengerName, int age, String gender, String preferedBerth)
	{
		this.passengerId = ++id;
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
		this.preferedBerth = preferedBerth;
		this.allotedBerth = "";
		this.number = -1;
	}

	int getPassengerId()
	{
		return this.passengerId;
	}
	// id cannot be changed - no setter.

	String getPassengerName()
	{
		return this.passengerName;
	}
	void setPassengerName(String passengerName)
	{
		this.passengerName = passengerName;
	}

	int getAge()
	{
		return this.age;
	}
	void setAge(int age)
	{
		this.age = age;
	}

	String getGender()
	{
		return this.gender;
	}
	void setGender(String gender)
	{
		this.gender = gender;
	}

	String getPreferedBerth()
	{
		return this.preferedBerth;
	}
	void getPreferedBerth(String preferedBerth)
	{
		this.preferedBerth = preferedBerth;
	}	

	String getSeatNumber()
	{
		return this.seatNumber;
	}
	void setSeatNumber(String seatNumber)
	{
		this.seatNumber = seatNumber;
	}

	String getAllotedBerth()
	{
		return this.allotedBerth;
	}
	void getAllotedBerth(String allotedBerth)
	{
		this.allotedBerth = allotedBerth;
	}
	
	String toString()
	{
		return "Id : " + this.passengerId + ".\nPassenger Name : " + this.passengerName + ". Age : " + this.age + ". "Gender : " + this.gender + ".\nGiven Berth : " + this.allotedBerth + ". Seat Number : " + this.seatNumber;
	}

}