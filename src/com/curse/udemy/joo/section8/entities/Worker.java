package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.curse.udemy.joo.section8.entities.enums.WorkerLevel;

public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;
 	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}
	
	
	private Long id;	
	private String name;
	private Long level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	private Worker() {
		super();
		Locale.setDefault(Locale.US);
		autoIncrementId++;
	}

	
	
	public Worker(String name, WorkerLevel level, Double baseSalary,Department department) {
		this();
		this.id = Worker.getAutoIncrementId();
		this.name = name;
		this.level = level.getId();
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return WorkerLevel.toEnum(this.level);
	}

	public void setLevel(WorkerLevel level) {
		this.level = level.getId();
	}


	public Double getBaseSalary() {
		return baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		Integer y; 
		Integer m;
		Double  sum = this.getBaseSalary();
		Calendar cal = Calendar.getInstance();
		for (HourContract hourContract : contracts) {
			cal.setTime(hourContract.getDate());
			y = cal.get(Calendar.YEAR);
			m = cal.get(Calendar.MONTH)+1;
			if (year.equals(y) && month.equals(m)) {
				sum += hourContract.totalValue();	
			}			
		}
		return sum;
	}



	public Double incomeFilterYear(String year) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Double sum = this.getBaseSalary();
		List<HourContract> result =  contracts.stream().filter(x -> sdf.format(x.getDate()).trim().substring(6, 10).equals(year)).collect(Collectors.toList());
		for (HourContract hourContract : result) {
			sum += hourContract.totalValue();
		}
		return sum;
	}	

	public Double incomeFilterYearMonth(String year, String month) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Double sum = this.getBaseSalary();
		List<HourContract> result =  contracts.stream()
									.filter(x -> sdf.format(x.getDate()).trim().substring(6, 10).equals(year))
									.filter(x -> sdf.format(x.getDate()).trim().substring(3, 5).equals(month))
									.collect(Collectors.toList());
		for (HourContract hourContract : result) {
			sum += hourContract.totalValue();
		}
		return sum;
	}	
	
	
	public void income(String year) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Double sum = this.getBaseSalary();
		System.out.println("* " + year);
		System.out.println("* Salaray : " +   String.format("%.2f",sum));
		for (HourContract hourContract : contracts) {
			sum += hourContract.totalValue();
			System.out.println(hourContract + " SUM = " +  String.format("%.2f",sum));
			System.out.println(sdf.format(hourContract.getDate()).trim().substring(6, 10));
			System.out.println(sdf.format(hourContract.getDate()).trim().substring(3, 5));
		}
		
		System.out.println();
		
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Worker [id= " + id 
				   + ", name= " + name 
				   + ", level= " + WorkerLevel.toEnum(this.level) + " [ " + WorkerLevel.toEnum(this.level).getName() + " ] "
				   + ", baseSalary= " + String.format("%.2f", baseSalary)
				   + ", " + this.department
				   + "]";
	}



	
	
}
