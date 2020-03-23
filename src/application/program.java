package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room Number: ");
		int numRoom = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(numRoom, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		

		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("check-in date (dd/MM/yyyy)");
		checkIn = sdf.parse(sc.next());
		System.out.print("check-out date (dd/MM/yyyy)");
		checkOut = sdf.parse(sc.next());
		
		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation:  " +reservation);
		}
		sc.close();
		// TODO Auto-generated method stub

	}

}