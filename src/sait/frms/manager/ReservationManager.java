package sait.frms.manager;

import java.util.ArrayList;
import java.util.Random;

import sait.frms.problemdomain.*;

public class ReservationManager {
	private ArrayList<Reservation> reservations;

	public ReservationManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation makeReservation(Flight flight, String name, String citizenship) {
		String randomCode= generateReservationCode(flight);
		Reservation reservation=new Reservation(randomCode, flight.getCode(),flight.getAirlineName(),name,citizenship,flight.getCostPerSeat());
		return reservation;
	}
	//tweaking
	public ArrayList<Reservation> findReservations(String code, String airline, String name) {
		//Check if atleast one input is not null. Else, throw Exception (Optional)
		
		ArrayList<Reservation> matchingReservations = new ArrayList<Reservation>();
		for(int i=0;i<this.reservations.size();i++) {
			if((this.reservations.get(i).getCode().equals(code) || code==null) && (this.reservations.get(i).getAirline().equals(airline)|| airline==null)  && (this.reservations.get(i).getName().contains(name) || name==null)  ) {
				matchingReservations.add(reservations.get(i));
			}
		}
		return matchingReservations;
	}
	public Reservation findReservationByCode(String code){
		for(int i=0;i<this.reservations.size();i++) {
			if(this.reservations.get(i).getCode().equals(code)) {
				return this.reservations.get(i);
			}
		}
		return null;
	}
	/**
	public void persist() {
		
	}
	*/
	private int getAvaliableSeats(Flight flight){
		return flight.getSeats();
	}
	private String generateReservationCode(Flight flight){
		String code="";
		if(flight.isDomestic()==true){
			code=code+"D";
		}else{
			code=code+"I";
		}
		int randomNumber= new Random().nextInt(9000) + 1000;
		return code+randomNumber;
	}
	/**
	private void populateFromBinary(){
		
	}
	*/
}
