package com.curse.udemy.joo.classAll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class ProgramClass81Datas {


	private static Scanner sc;
	private static SimpleDateFormat sdf1;
	private static SimpleDateFormat sdf2;
	private static SimpleDateFormat sdf3;
	
	public ProgramClass81Datas() {
		Locale.setDefault(new Locale("pt","br"));
		sc = new Scanner(System.in);
		sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	private static void Ex1() throws ParseException {
	
		new ProgramClass81Datas();
		Date y1 = sdf1.parse("21/10/2018");
		Date y2 = sdf2.parse("21/10/2018 18:48:00");
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0l);
		Date x4 = new Date(1000l * 60l * 60l* 5l);
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println("x1: " + x1);
		System.out.println("x1: " + sdf1.format(x1));
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x1: " + sdf3.format(x1));

		System.out.println("x2: " + x2);
		System.out.println("x2: " + sdf1.format(x2));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x2: " + sdf3.format(x2));
		
		System.out.println("x3: " + x3);
		System.out.println("x3: " + sdf1.format(x3));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x3: " + sdf3.format(x3));
		
		System.out.println("x4: " + x4);
		System.out.println("x4: " + sdf1.format(x4));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println("x4: " + sdf3.format(x4));
		
		System.out.println("y1: " + y1);
		System.out.println("y1: " + sdf1.format(y1));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y1: " + sdf3.format(y1));
		
		System.out.println("y2: " + y2);
		System.out.println("y2: " + sdf1.format(y2));
		System.out.println("y2: " + sdf2.format(y2));
		System.out.println("y2: " + sdf3.format(y2));
		
		System.out.println("y3: " + y3);
		System.out.println("y3: " + sdf1.format(y3));
		System.out.println("y3: " + sdf2.format(y3));
		System.out.println("y3: " + sdf3.format(y3));
		
		System.out.println();
		
		
		
		sc.close();
	}
	
	private static void Ex2() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf.format(d));
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		d = cal.getTime();
		System.out.println(sdf.format(d));
	
	}
	
	private static void Ex3() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf.format(d));
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH);
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);
	
	}
	
	
	public static void main(String[] args) {
		
		Ex3();
		
		Ex2();
		
		try {
			Ex1();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
