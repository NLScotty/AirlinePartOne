package sait.frms.manager;

import java.util.ArrayList;
import java.util.Random;

import java.io.*;
import sait.frms.problemdomain.*;

public class ReservationManager {
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private RandomAccessFile raf; 
	private final long RECORD_SIZE=181;

	public ReservationManager() throws IOException{
		this.raf = new RandomAccessFile("res/Reservations.bin", "rw");
		this.populateFromBinary();
		// TODO Auto-generated constructor stub
	}
	public Reservation makeReservation(Flight flight, String name, String citizenship) throws IOException {
		String randomCode= generateReservationCode(flight);
		Reservation reservation=new Reservation(randomCode, flight.getCode(),flight.getAirlineName(),name,citizenship,flight.getCostPerSeat(),true);
		reservations.add(reservation);
		this.persist(reservation);
		return reservation;
	}
	
	private void persist(Reservation reservation) throws IOException {
		this.raf.writeUTF(reservation.getCode());
		this.raf.writeUTF(reservation.getFlightCode());
		this.raf.writeUTF(String.format("%-50s", reservation.getAirline()));
		this.raf.writeUTF(String.format("%-50s", reservation.getName()));
		this.raf.writeUTF(String.format("%-50s", reservation.getCitizenship()));
		this.raf.writeDouble(reservation.getCost());
		this.raf.writeBoolean(reservation.isActive());
	}
	//tweaking
	public ArrayList<Reservation> findReservations(String code, String airline, String name) {
		//Check if atleast one input is not null. Else, throw Exception (Optional)
		
		ArrayList<Reservation> matchingReservations = new ArrayList<Reservation>();
		for(int i=0;i<this.reservations.size();i++) {
			if((this.reservations.get(i).getCode().toUpperCase().equals(code.toUpperCase()) || code.equals("")) && (this.reservations.get(i).getAirline().toUpperCase().equals(airline.toUpperCase())|| airline.equals(""))  && (this.reservations.get(i).getName().toUpperCase().contains(name.toUpperCase()) || name.equals(""))  ) {
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
	
	private int getAvaliableSeats(Flight flight){
		return flight.getSeats();
	}
	private String generateReservationCode(Flight flight){
		String code="";
		if(flight.isDomestic()){
			code=code+"D";
		}else{
			code=code+"I";
		}
		int randomNumber= new Random().nextInt(9000) + 1000;
		return code+randomNumber;
	}
	
	public void updateReservation(Reservation r1) throws IOException {
		for (long position = 0; position < this.raf.length(); position += RECORD_SIZE) {
			this.raf.seek(position);
			Reservation r2 = new Reservation(this.raf.readUTF(),this.raf.readUTF(),this.raf.readUTF().trim(),this.raf.readUTF().trim(),this.raf.readUTF().trim(),this.raf.readDouble(),this.raf.readBoolean());
			
			if (r2.getCode().equals(r1.getCode()) && r2.getFlightCode().equals(r1.getFlightCode())) {
				this.raf.seek(position);
				persist(r1);
				break;
			}
		}
		if(!r1.isActive()) {
			for(int i=0; i<reservations.size();i++) {
				if(reservations.get(i).getCode().equals(r1.getCode()) && reservations.get(i).getFlightCode().equals(r1.getFlightCode())) {
					reservations.remove(i);
				}
			}
		}else {
			for(int i=0; i<reservations.size();i++) {
				if(reservations.get(i).getCode().equals(r1.getCode()) && reservations.get(i).getFlightCode().equals(r1.getFlightCode())) {
					reservations.remove(i);
				}
			}
			reservations.add(r1);
		}
	}
	
	private void populateFromBinary() throws IOException{
		for (long position = 0; position < this.raf.length(); position += RECORD_SIZE) {
			this.raf.seek(position);
			Reservation r = new Reservation(this.raf.readUTF(),this.raf.readUTF(),this.raf.readUTF().trim(),this.raf.readUTF().trim(),this.raf.readUTF().trim(),this.raf.readDouble(),this.raf.readBoolean());
			if (r.isActive())
				this.reservations.add(r);
		}
	}
	public boolean seatAvailable(Flight flight) {
		int reservedSeats=0;
		for(Reservation reservation: reservations) {
			if(reservation.getFlightCode().equals(flight.getCode()) && reservation.isActive()) {
				reservedSeats++;
			}
		}
		return reservedSeats<flight.getSeats();
	}
}
