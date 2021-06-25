package sait.frms.manager;

import java.util.ArrayList;
import sait.frms.problemdomain.*;

public class FlightManager {
	public final static String WEEKDAY_ANY="ANY";
	public final static String WEEKDAY_SUNDAY="SUNDAY";
	public final static String WEEKDAY_MONDAY="MONDAY";
	public final static String WEEKDAY_TUESDAY="TUESDAY";
	public final static String WEEKDAY_WEDNESDAY="WEDNESDAY";
	public final static String WEEKDAY_THURSDAY="THURSDAY";
	public final static String WEEKDAY_FRIDAY="FRIDAY";
	public final static String WEEKDAY_SATURDAY="SATURDAY";

	private ArrayList<Flight> flights;
	private ArrayList<String> airports;
	
	public FlightManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public ArrayList<String> getAirports() {
		return airports;
	}
	
	public String findAirportByCode(String code) {
		return "";
	}
	public Flight findFlightByCode(String code) {

	}
	public ArrayList<Flight> findFlights(String from, String to, String weekday){ 
	}
	private void populateFlights() {
		
	}
	private void populateAirports() {
		
	}
	
}
