package com.curse.udemy.joo.section14;

import com.curse.udemy.joo.section14.model.entities.Client;

public class HashCodeEquals {
	
	public static void main(String[] args) {
		
		Client c1 = new Client("Maria","maria@gmail.com");
		Client c2 = new Client("Alex","alex@gmail.com");
		Client c3 = new Client("Maria","maria2@gmail.com");
		Client c4 = new Client("Maria","maria2@gmail.com");
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		System.out.println("c4: " + c4);
		System.out.println();
		System.out.println("c1.hashCode() : " + c1.hashCode());
		System.out.println("c2.hashCode() : " + c2.hashCode());
		System.out.println("c3.hashCode() : " + c3.hashCode());
		System.out.println("c4.hashCode() : " + c4.hashCode());
		System.out.println();
		System.out.println("c1 == c3 : " + (c1 ==c3));
		System.out.println("c1.hashCode() == c3.hashCode() : " + (c1.hashCode() ==c3.hashCode()));
		System.out.println("c1.equals(c3) : " +  (c1.equals(c3)));
		System.out.println();
		System.out.println("c4 == c3 : " + (c4 ==c3));
		System.out.println("c4.hashCode() == c3.hashCode() : " + (c4.hashCode() ==c3.hashCode()));
		System.out.println("c4.equals(c3) : " +  (c4.equals(c3)));
		System.out.println();
		
		String s1 = "Test";
		String s2 = "Test";
		String s3 = new String("Test");
		
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("s3: " + s3);
		System.out.println();
		System.out.println("s1.hashCode() : " + s1.hashCode());
		System.out.println("s2.hashCode() : " + s2.hashCode());
		System.out.println("s3.hashCode() : " + s3.hashCode());
		System.out.println();
		System.out.println("s1 == s2 : " + (s1 ==s2));
		System.out.println("s1.hashCode() == s2.hashCode() : " + (s1.hashCode() ==s2.hashCode()));
		System.out.println("s1.equals(s2) : " +  (s1.equals(s2)));
		System.out.println();
		System.out.println("s1 == s3 : " + (s1 ==s3));
		System.out.println("s1.hashCode() == s3.hashCode() : " + (s1.hashCode() ==s3.hashCode()));
		System.out.println("s1.equals(s3) : " +  (s1.equals(s3)));
		System.out.println();
		
		
	}

}
