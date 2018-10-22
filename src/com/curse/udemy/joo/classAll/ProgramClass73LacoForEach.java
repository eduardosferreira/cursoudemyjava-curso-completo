package com.curse.udemy.joo.classAll;

import com.curse.udemy.joo.classAll.entities.Student;

public class ProgramClass73LacoForEach {

	public static void main(String[] args) {

		Student    s1 = new Student("Maria","email");
		
		String[]    vet = new String[] {"Eduardo","Pollyana","Thyago",s1.getName()};
		Student[]  vetS = new Student[] {new Student("Eduardo","email")
										,new Student("Pollyana","email")
										,new Student("Thyago","email")
										,s1
		};
		
		for (Student s : vetS) {
			System.out.println(s);
		}
		
		for (String s : vet) {
			System.out.println(s);
		}
		
		for (int i = 0; i < vetS.length; i++) {
			System.out.println(vetS[i]);
		}
		for (int i = 0; i < vetS.length; i++) {
			Student student = vetS[i];
			System.out.println(student);
		}
		
	}	

}
