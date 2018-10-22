package com.curse.udemy.joo.classAll.entities;

import java.io.Serializable;

public class Student implements Serializable {
	/*
	 * Variveis
	 */
	
	private static final long serialVersionUID = 1L;
	private static long instance=0;
	
	/*
	 * Atributos
	 */
	private Long   id;
	private String name, email;
	
	/*
	 * 
	 * Getters e Setters
	 * 
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * Construtores
	 */
	public Student() {
		super();
		instance++;
	}
	public Student(String name, String email) {
		this();
		this.id = instance;
		this.name = name;
		this.email = email;
	}
	
	
	/*
	 * Metodos
	 */
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

	
}
