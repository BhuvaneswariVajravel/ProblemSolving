package com.wm_practice.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Employee {
	private String name;
	private Integer id;
	private Integer salary;

	public Employee(String name, Integer id, Integer salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public Employee(Employee e ){
		this.name=e.getName();
		this.id=e.getId();
		this.salary=e.getSalary();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

}

public class DeepcopyVsShallowcopy {

	public static void main(String[] args) {

		Employee emp = new Employee("Maya", 1, 10000);
		System.out.println("====original emp===");
		System.out.println("====emp =hashCode=====" + emp.hashCode());
		System.out.println("====emp value===" + emp.toString());

		//Employee deepEmployee = new Employee(emp.getName(), emp.getId(), emp.getSalary());
		Employee deepEmployee = new Employee(emp);
		System.out.println("====Deep emp===");
		System.err.println("====Deep copy hascode==" + deepEmployee.hashCode());
		System.out.println("====Deep emp value===" + deepEmployee.toString());

		deepEmployee.setSalary(20000);
		System.err.println("====Deep copy hascode==" + deepEmployee.hashCode());

		System.out.println("====Deep emp value===" + deepEmployee.toString());
		System.out.println("====emp value after change===" + emp.toString());
		System.out.println();

		Employee shallowEmployee = emp;
		System.out.println("====shallow emp===");
		System.err.println("====shallow copy hascode==" + shallowEmployee.hashCode());
		shallowEmployee.setSalary(30000);
		System.out.println("====shallowEmployee emp value===" + shallowEmployee.toString());
		System.out.println("====shallowEmployee value after change===" + emp.toString());

	}
}
