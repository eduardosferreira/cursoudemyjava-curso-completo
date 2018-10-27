package com.curse.udemy.joo.section10;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section10.model.entities.Reservation;
import com.curse.udemy.joo.section10.model.exception.DomainReservationException;
import com.curse.udemy.joo.section10.model.exception.DomainReservationRunTimeException;

public final class ProgramReservation {

	
	private ProgramReservation() {
		Locale.setDefault(Locale.US);
	}
	
	private static void Ex1() throws ParseException {
		new ProgramReservation();
		
		Scanner sc = new Scanner(System.in);
		String alternative = "N";
		int    error = 0;
		int    count = 0;
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Reservation> list = new ArrayList<>();
		
		do {
		
			list.clear();
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Reservation entidade = null;
				Long roomNumber;
				Date checkIn, checkOut;
				
				do {
					
					System.out.println("Reservation #" + i + " data [ " + Reservation.sdf.format(new Date())  + " ]");
					System.out.print("Room: ");
					roomNumber = sc.nextLong();
					sc.nextLine();
					count = 0;
					
					do {
					
						error = 1;
						System.out.print("Check In (DD/MM/YYYY): ");
						checkIn = Reservation.sdf.parse(sc.nextLine());
						System.out.print("Check Out (DD/MM/YYYY): ");
						checkOut = Reservation.sdf.parse(sc.nextLine());
						
						if (count == 0) 
							entidade = new Reservation(roomNumber, checkIn, checkOut);
						else
							entidade.updateDates(checkIn, checkOut);	
						
						 if  (checkIn.after(checkOut))  
							System.out.println("Error in reservation: Check-out date must be after check-in date");
						 else if (checkIn.before(new Date())) 
							System.out.println("Error in reservation: Reservation dates for update must be future dates");
						 else if (checkIn.equals(new Date())) 
							System.out.println("Error in reservation: Check-in equal today's date. ");
						 else 
						   error = 0;		
						
						System.out.print("Do you want to change the dates(Y/N)? ");
						alternative = sc.nextLine();
						
						count++;
						
					} while (alternative.trim().toUpperCase().charAt(0) == 'Y');
	
					System.out.print((error == 0 ? entidade + " \nConfirme the reservation (Y - Yes [Reserved] | N - No [canceled] | R - Repeat the reservation)?  ":" Repeat the reservation  ? (R - Repeat or any letter for cancellation) ? "));
					alternative = sc.nextLine();
					
					if ((error == 0) && (alternative.trim().toUpperCase().charAt(0) == 'Y')) 
						list.add(entidade);
					 
					
				} while ((alternative.trim().toUpperCase().charAt(0) == 'R'));
				
				System.out.println();
			}
			
			System.out.println("LIST: ");
			for (Reservation e : list) {
				System.out.println(e);
			}
			
			
			try  {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			
			System.out.println();
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		sc.close();
			
	}

	private static void Ex2() throws ParseException {
		new ProgramReservation();
		
		Scanner sc = new Scanner(System.in);
		String alternative = "N";
		int    error = 0;
		int    count = 0;
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Reservation> list = new ArrayList<>();
		
		do {
		
			list.clear();
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Reservation entidade = null;
				Long roomNumber;
				Date checkIn, checkOut;
				
				do {
					
					System.out.println("Reservation #" + i + " data [ " + Reservation.sdf.format(new Date())  + " ]");
					System.out.print("Room: ");
					roomNumber = sc.nextLong();
					sc.nextLine();
					count = 0;
					
					do {
					
						error = 0;
						System.out.print("Check In (DD/MM/YYYY): ");
						checkIn = Reservation.sdf.parse(sc.nextLine());
						System.out.print("Check Out (DD/MM/YYYY): ");
						checkOut = Reservation.sdf.parse(sc.nextLine());
						
						if (count == 0) 
							entidade = new Reservation(roomNumber, checkIn, checkOut);
						
						alternative = entidade.validateChangeDates(checkIn, checkOut);
							 
						if (alternative != null ) {
							error = 1;
							System.out.println(alternative);
						} 
						
						System.out.print("Do you want to change the dates(Y/N)? ");
						alternative = sc.nextLine();
						
						count++;
						
					} while (alternative.trim().toUpperCase().charAt(0) == 'Y');
	
					System.out.print((error == 0 ? entidade + " \nConfirme the reservation (Y - Yes [Reserved] | N - No [canceled] | R - Repeat the reservation)?  ":" Repeat the reservation  ? (R - Repeat or any letter for cancellation) ? "));
					alternative = sc.nextLine();
					
					if ((error == 0) && (alternative.trim().toUpperCase().charAt(0) == 'Y')) 
						list.add(entidade);
					 
					
				} while ((alternative.trim().toUpperCase().charAt(0) == 'R'));
				
				System.out.println();
			}
			
			System.out.println("LIST: ");
			for (Reservation e : list) {
				System.out.println(e);
			}
			
			
			try  {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			
			System.out.println();
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		sc.close();
			
	}

	private static void Ex3()  {
		new ProgramReservation();
		
		Scanner sc = new Scanner(System.in);
		String alternative = "N";
		int    error = 0;
		int    count = 0;
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Reservation> list = new ArrayList<>();
		
		do {
		
			list.clear();
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Reservation entidade = null;
				Long roomNumber;
				Date checkIn, checkOut;
				
				do {
					
					System.out.println("Reservation #" + i + " data [ " + Reservation.sdf.format(new Date())  + " ]");
					System.out.print("Room: ");
					roomNumber = sc.nextLong();
					sc.nextLine();
					count = 0;
					
					do {
					
						error = 0;
						try {
							System.out.print("Check In (DD/MM/YYYY): ");
							checkIn = Reservation.sdf.parse(sc.nextLine());
							System.out.print("Check Out (DD/MM/YYYY): ");
							checkOut = Reservation.sdf.parse(sc.nextLine());
							if (count == 0) 
								entidade = new Reservation(Reservation.getAutoIncrementId().longValue(), roomNumber, checkIn, checkOut);
							else
								entidade.changeDateException(checkIn, checkOut); 
						} catch (ParseException e) {
							System.out.println("Invalid Date Form " + e.getMessage());
							error = 1;
						} catch (DomainReservationException e) {
							System.out.println(e.getMessage());
							error = 1;
						}
						System.out.print("Do you want to change the dates(Y/N)? ");
						alternative = sc.nextLine();
						
						count++;
						
					} while (alternative.trim().toUpperCase().charAt(0) == 'Y');
	
					System.out.print((error == 0 ? entidade + " \nConfirme the reservation (Y - Yes [Reserved] | N - No [canceled] | R - Repeat the reservation)?  ":" Repeat the reservation  ? (R - Repeat or any letter for cancellation) ? "));
					alternative = sc.nextLine();
					
					if ((error == 0) && (alternative.trim().toUpperCase().charAt(0) == 'Y')) 
						list.add(entidade);
					 
					
				} while ((alternative.trim().toUpperCase().charAt(0) == 'R'));
				
				System.out.println();
			}
			
			System.out.println("LIST: ");
			for (Reservation e : list) {
				System.out.println(e);
			}
			
			
			try  {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			
			System.out.println();
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		sc.close();
			
	}
	

	private static void Ex4()  {
		new ProgramReservation();
		
		Scanner sc = new Scanner(System.in);
		String alternative = "N";
		int    error = 0;
		int    count = 0;
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Reservation> list = new ArrayList<>();
		
		do {
		
			list.clear();
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Reservation entidade = null;
				Long roomNumber;
				Date checkIn, checkOut;
				
				do {
					
					System.out.println("Reservation #" + i + " data [ " + Reservation.sdf.format(new Date())  + " ]");
					System.out.print("Room: ");
					roomNumber = sc.nextLong();
					sc.nextLine();
					count = 0;
					
					do {
					
						error = 0;
						try {
							System.out.print("Check In (DD/MM/YYYY): ");
							checkIn = Reservation.sdf.parse(sc.nextLine());
							System.out.print("Check Out (DD/MM/YYYY): ");
							checkOut = Reservation.sdf.parse(sc.nextLine());
							if (count == 0) 
								entidade = new Reservation(Reservation.getAutoIncrementId().doubleValue(), roomNumber, checkIn, checkOut);
							else
								entidade.changeDateRunTimeException(checkIn, checkOut); 
						} catch (ParseException e) {
							System.out.println("Invalid Date Form " + e.getMessage());
							error = 1;
						} catch (DomainReservationRunTimeException e) {
							System.out.println(e.getMessage());
							error = 1;
						}
						System.out.print("Do you want to change the dates(Y/N)? ");
						alternative = sc.nextLine();
						
						count++;
						
					} while (alternative.trim().toUpperCase().charAt(0) == 'Y');
	
					System.out.print((error == 0 ? entidade + " \nConfirme the reservation (Y - Yes [Reserved] | N - No [canceled] | R - Repeat the reservation)?  ":" Repeat the reservation  ? (R - Repeat or any letter for cancellation) ? "));
					alternative = sc.nextLine();
					
					if ((error == 0) && (alternative.trim().toUpperCase().charAt(0) == 'Y')) 
						list.add(entidade);
					 
					
				} while ((alternative.trim().toUpperCase().charAt(0) == 'R'));
				
				System.out.println();
			}
			
			System.out.println("LIST: ");
			for (Reservation e : list) {
				System.out.println(e);
			}
			
			
			try  {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			
			System.out.println();
			
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		sc.close();
			
	}
	
	
	public static void main(String[] args)  {
		Ex4();
		Ex3();
		
		
		try {
			Ex2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Ex1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	
	
}
