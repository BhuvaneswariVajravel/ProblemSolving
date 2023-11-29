package com.wm_practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * Program: Sorting of Employee class with id, Name, Salary
 * 
 * Algorithm
 * 
 * Time Complexity
 * 
 * Auxilary Space 
 */

class Employee implements Comparable<Employee> {

	String id;
	String name;
	Integer salary;

	public Employee(String i, String n, Integer s) {
		id = i;
		name = n;
		salary = s;
	}

	public String toString() {
		return "Employee [Employee id : " + id + ", name : " + name + ". salary: " + salary + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	

	@Override
	public int compareTo(Employee o) {
//		System.out.println(this.id.compareTo(o.id));
//		System.out.println((this.name.compareTo(o.name)));
//		System.out.println((this.salary.compareTo(o.salary)));System.out.println("=======");
//		System.out.println(this.id.compareTo(o.id) + (this.name.compareTo(o.name)) + (this.salary.compareTo(o.salary)));
//;
		return this.id.compareTo(o.id) + (this.name.compareTo(o.name)) + (this.salary.compareTo(o.salary));
	}

}

public class SortEmployee {

	public static void main(String[] args) {

		Employee emp1 = new Employee("102", "maya", 25000);

		Employee emp2 = new Employee("100", "buvi", 35000);

		Employee emp3 = new Employee("101", "deena", 20000);

		Employee emp4 = new Employee("103", "gayu", 40000);

		Set<Employee> empList = new TreeSet<>();

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);

		
		List<Employee> empList1 = new ArrayList<>();
		empList1.add(emp1);
		empList1.add(emp2);
		empList1.add(emp3);
		empList1.add(emp4);
		
		// sort the employee based on salary in descending order using java 8
		List<Employee> list = empList1.stream().sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary())).collect(Collectors.toList());
		System.out.println(list);

	}
}
