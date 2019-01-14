package com.java8.sample.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatExample {

	public static void main(String[] args) {
		new StreamConcatExample().concatStream();
		new StreamConcatExample().arrayStream();
		new StreamConcatExample().listStream();
	}

	public void concatStream(){
		Stream<String> stream1 = Stream.of("name", "address", "eyecolor", "Other");
		Stream<String> stream2 = Stream.of("title", "author", "release", "Address");
		Stream<String> sortedStream2 = stream2.parallel();
		Stream<String> sortedStream1 = stream1;

		Stream<String> finalStream = Stream.concat(sortedStream1, sortedStream2);
		Stream<String> sortedStream = finalStream/*.sorted().distinct()*/;
		
		
//		System.out.println(sortedStream.filter(w -> w.startsWith("a")).count());//
		sortedStream.forEachOrdered(e -> System.out.println(e));
		
		System.out.println(sortedStream.isParallel());
		
		
	}
	
	public void arrayStream(){
		Employee[] employees = new Employee[4];
		employees[0] = new Employee("A", 20000);
		employees[1] = new Employee("B", 25000);
		employees[2] = new Employee("C", 35000);
		employees[3] = new Employee("D", 30000);
		
		Stream<Employee> empStream = Stream.of(employees);
		Stream<Employee> sortedEmployee = empStream.sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary() < o2.getSalary())
					return 1;
				else if (o1.getSalary() > o2.getSalary())
					return -1;
				else
					return 0;
			}
		});
		
		sortedEmployee.forEach(e -> System.out.println("Name : " + e.getName() + " :: " +"Salary : " + e.getSalary()));
		
		Stream<Employee> empStream1 = Stream.of(employees);
		Stream<Employee> sortedEmployee1 = empStream1/*.sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary() > o2.getSalary())
					return 1;
				else if (o1.getSalary() < o2.getSalary())
					return -1;
				else
					return 0;
			}
		})*/;
		System.out.println("----------------------------------------");
		sortedEmployee1.filter(e -> e.getSalary() > 20000).sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(w -> System.out.println("Name : " + w.getName() + " :: " +"Salary : " + w.getSalary()));
	}
	
	public void listStream(){
		List<Employee> employees = new ArrayList<>();
		{
			employees.add(new Employee("A", 15000));
			employees.add(new Employee("B", 20000));
			employees.add(new Employee("F", 40000));
			employees.add(new Employee("D", 30000));
			employees.add(new Employee("C", 25000));
			employees.add(new Employee("E", 35000));
			employees.add(new Employee("G", 45000));
		}
		System.out.println("------------- List Stream ---------------");
		Stream<Employee> empStream = employees.stream().filter(w -> w.getSalary() > 15000);
//		empStream.forEach(p -> System.out.println("Name : " + p.getName() + " :: " +"Salary : " + p.getSalary()));
		
		List<Employee> finalEmpList = empStream.collect(Collectors.toList());
		finalEmpList.forEach(p -> System.out.println("Name : " + p.getName() + " :: " +"Salary : " + p.getSalary()));
		
	}
}
