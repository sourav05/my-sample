package com.java8.sample.streamapi.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.java8.sample.streamapi.Employee;

public class StreamComparatorSample {

	public static void main(String[] args) {
		new StreamComparatorSample().sortBySalaryList();
		new StreamComparatorSample().sortBySalarySet();
	}

	public void sortBySalaryList(){
		List<Employee> employees = new ArrayList<>();
		{
			employees.add(new Employee("A", 15000));
			employees.add(new Employee("B", 20000));
			employees.add(new Employee("C", 40000));
			employees.add(new Employee("D", 30000));
			employees.add(new Employee("F", 25000));
			employees.add(new Employee("E", 35000));
			employees.add(new Employee("G", 45000));
		}
		
		
		Stream<Employee> empStream = employees.stream();
		Stream<Employee> sortedEmp = empStream.sorted(Comparator.reverseOrder()); /** natural Sort */
		System.out.println("Natural Sort List:");
		sortedEmp.forEach(e -> System.out.println("Name : " + e.getName() + " :: " + "Salary : " + e.getSalary()));
		
		Stream<Employee> empStream1 = employees.stream();
		Stream<Employee> sortedEmp1 = empStream1.sorted(Comparator.comparing(Employee::getSalary).reversed()); /** Sort by salary */
		System.out.println("Sort by Salary List:");
		sortedEmp1.forEach(e -> System.out.println("Name : " + e.getName() + " :: " + "Salary : " + e.getSalary()));
	}
	
	public void sortBySalarySet(){
		Set<Employee> employees = new HashSet<>();
		{
			employees.add(new Employee("A", 15000));
			employees.add(new Employee("B", 20000));
			employees.add(new Employee("C", 40000));
			employees.add(new Employee("D", 30000));
			employees.add(new Employee("F", 25000));
			employees.add(new Employee("E", 35000));
			employees.add(new Employee("G", 45000));
		}
		
		
		Stream<Employee> empStream = employees.stream();
		Stream<Employee> sortedEmp = empStream.sorted(Comparator.reverseOrder()); /** natural Sort */
		System.out.println("Natural Sort Set:");
		sortedEmp.forEach(e -> System.out.println("Name : " + e.getName() + " :: " + "Salary : " + e.getSalary()));
		
		Stream<Employee> empStream1 = employees.stream();
		Stream<Employee> sortedEmp1 = empStream1.sorted(Comparator.comparing(Employee::getSalary).reversed()); /** Sort by salary */
		System.out.println("Sort by Salary Set:");
		sortedEmp1.forEach(e -> System.out.println("Name : " + e.getName() + " :: " + "Salary : " + e.getSalary()));
	}
}