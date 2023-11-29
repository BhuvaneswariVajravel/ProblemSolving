package com.wm_practice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Employee1 {
	private String name;
	private Integer salary;
	private String dept;

	public Employee1(String name, Integer salary, String dept) {
		this.name = name;
		this.salary = salary;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "[Name: " + name + ", Salary: " + salary + ", Dept: " + dept + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return Objects.equals(dept, other.dept) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}

}

public class FilterEmployee {

	public static void printList() {
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		System.out.println("original list: " + numbers);

		numbers.stream().map(s -> Integer.valueOf(s)).filter(number -> number % 2 == 0).forEach(System.out::println);

	}

	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("test");
		StringBuffer s2 = new StringBuffer("test");

		Set<StringBuffer> data = new HashSet<>();
		data.add(s1);
		data.add(s2);
		System.out.println("==s1===" + s1.hashCode());
		System.out.println("==s2===" + s2.hashCode());
		System.out.println(data);

		// List<Employee1> emp = new ArrayList<>();
		Employee1 emp1 = new Employee1("emp6", 10000, "HR");
		Employee1 emp2 = new Employee1("emp7", 50000, "HR");
		Set<Employee1> emp = new HashSet<>();
		emp.add(emp1);
		emp.add(emp2);
		emp.add(new Employee1("emp2", 50000, "HR"));
		emp.add(new Employee1("emp3", 70000, "Development"));
		emp.add(new Employee1("emp4", 100000, "Developement"));
		emp.add(new Employee1("emp5", 8000, "Testing"));
		System.out.println("==emp1===" + emp1.hashCode());
		System.out.println("==emp2===" + emp2.hashCode());

		System.out.println(emp.size());
		System.out.println(emp);
		emp.stream().map(e -> {
			e.setSalary(e.getSalary() + 10000);
			return e;
		}).filter(i -> i.getSalary() > 50000).forEach(System.out::println);

		System.out.println("=================filter employee and return names======");

		List<String> names = emp.stream().filter(e -> e.getSalary() > 60000).map(e -> e.getName())
				.collect(Collectors.toList());
		System.out.println(names);
		printList();

		System.out.println("============hashmap null insertion==========");
		Map<String, Employee1> map = new HashMap<>();
		String i = "1";
		map.put(i, emp1);
		map.put(null, emp2);
		map.put(null, emp1);
		map.put(null, new Employee1("emp25", 8000, "Testing"));

		System.out.println(map);

		System.out.println("============hashset null insertion==========");
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(3);
		System.out.println("first null" + set.add(null));
		set.add(4);
		System.out.println("second null" + set.add(null));
		System.out.println(set);
	}

}
