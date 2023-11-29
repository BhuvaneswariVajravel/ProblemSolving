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
final class Employee1 {

	private final String name;

	private final String id;

	public Employee1(String name, String id) {

		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
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
		Employee1 other = (Employee1) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}

public class ImmutableHashMapKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Map<Employee1, String> map = new HashMap<>();

		Employee1 key = new Employee1("name1", "id1");

		map.put(key, "some value");

		map.entrySet().stream().forEach(e -> {
			System.out.println("===key==" + e.getKey().getName());
			System.out.println("===hashcode===" + e.getKey().hashCode());
		});
		
	//key.setName("new name");
		
		System.out.println("===map ===" + map);

	}

}
