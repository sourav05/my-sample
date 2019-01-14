package com.java8.sample.streamapi;

public class Employee implements Comparable<Employee>{

	private String name;
	private long salary;
	
	public Employee(String name, long salary){
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee emp) {
		return this.getName().compareTo(emp.getName());
	}
	
	@Override
	public boolean equals(final Object obj){
		Employee employee = (Employee) obj;
		
		if(employee == null)
			return false;
		if(this == employee)
			return true;
		return (this.getName().equals(employee.getName()) && this.getSalary() == employee.getSalary());
	}
	
	@Override
	public int hashCode(){
		int hashNo = 9;
		hashNo = (19 * hashNo) + (name == null ? 0 : name.hashCode()) + (salary == 0 ? 0 : ((Long) salary).hashCode()); 
		return hashNo;
	}
}
