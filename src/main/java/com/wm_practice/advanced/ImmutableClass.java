package com.wm_practice.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

final class Company {

	private final String name;
	private final int size;
	private final List<String> emp;

	Company(String name, int size, List<String> emp) {

		this.name = name;
		this.size = size;
		this.emp=emp.stream().collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public List<String> getEmp() {
		return emp;
	}

}

class ImmutableClass {
	public static void main(String[] args) {

		List<String> emp = new ArrayList<>();
		emp.add("emp1");
		emp.add("emp2");
		emp.add("emp3");


		Company obj = new Company("Company 1", 10000,emp);

		System.out.println("Name: " + obj.getName());
		System.out.println("Size: " + obj.getSize());
		System.out.println("obj hashcode "+obj.hashCode());
	
		emp.add("emp4");
		emp.add("emp5");
		emp.add("emp6");
		
		System.out.println("======="+obj.getEmp().size());

		obj = new Company("Company 2", 20000,emp);

	
		System.out.println("Name: " + obj.getName());
		System.out.println("Size: " + obj.getSize());
		System.out.println("obj hashcode "+obj.hashCode());
		
		StringBuffer sb =new StringBuffer("hi==");
//		System.out.println("===sb==="+sb.toString());
//		System.out.println("===sb==="+sb.hashCode());

		sb.append("===true===");
//		System.out.println("===sb==="+sb.toString());
//		System.out.println("===sb==="+sb.hashCode());


	}
}