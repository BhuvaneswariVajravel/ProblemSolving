package com.wm_practice.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Problem :
 * 
 * If hash map keys not immutables, if we change the key value after inserting into map hash code of key will get change.
 * hence the map will not able to retrive the entry .
 * 
 * 
 *
 */
class Employee {

	private String name;

	private String id;

	public Employee(String name, String id) {

		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	

	// public getters
	// public setters
	// hashcode using name & id
	// equals using name & id
}

public class mutableHashMapKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hi";
		String s2 = "hello";
		s1 = "new hi";

		Map<Employee, String> map = new HashMap<>();

		Employee key = new Employee("name1", "id1");

		map.put(key, "some value");

		map.entrySet().stream().forEach(e -> {
			System.out.println("===key==" + e.getKey().getName());
			System.out.println("===hashcode===" + e.getKey().hashCode());
		});
		
		key.setName("new name");
		map.entrySet().stream().forEach(e -> {
			System.out.println("===key==" + e.getKey().getName());
			System.out.println("===hashcode===" + e.getKey().hashCode());
		});
		
		
		System.out.println("===map ===" + map);

	}

}

