package sait.frms.problemdomain;

public class Flight {
	private String code;
	private String airlineName;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private int seats;
	private double costPerSeat;
	
	//Constructor
	
	public Flight(String code, String fromCode, String toCode, String weekday, String time, int seats, double costPerSeat) {
		super();
		this.code = code;
		//this.airlineName = airlineName;
		parseCode(this.code);
		this.from = fromCode;
		this.to = toCode;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}

	//Getters
	
	public String getCode() {
		return code;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getWeekday() {
		return weekday;
	}

	public String getTime() {
		return time;
	}

	public int getSeats() {
		return seats;
	}

	public double getCostPerSeat() {
		return costPerSeat;
	}
	
	//Other Methods
	
	public boolean isDomestic() {
		return false;
	}
	
	private void parseCode(String code) {
		//generate airline name
		//this.airlineName=parsed informaton
	}
	//needs some tweaking
	@Override
	public String toString() {
		return code + airlineName +","+ from + "," + to + ","+ weekday + "," + time + "," + seats + "," + costPerSeat;
	}
}
