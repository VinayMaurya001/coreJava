package _21javaVersions._8version;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * 1.Write a program to print employee details working in each department
 * 
 * 2.Write a program to print employees count working in each department
 * 
 * 3.Write a program to print active and inactive employees in the given
 * collection
 * 
 * 4.Write a program to print Max/Min employee salary from the given collection
 * 
 * 5.Write a program to print the max salary of an employee from each department
 * 
 */
public class StreamInterviewQuestions1 {

	public static void main(String[] args) {

		List<Employee2> list = createEmployeeList();
		// m1();
		// m101();
		// m102();
		// m103();
		// m104();
//		m105();
//		m2();
//		m201();
//		
		m4();

	//	m5();
	}

	private static void m5() {
		System.out.println("m4()");
		List<Employee2> list = createEmployeeList();
		
		Map<String, Optional<Employee2>> map = list.stream().collect(Collectors.groupingBy(Employee2::getDepartment,
				Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(emp -> ((Employee2) emp).getSalary())))));
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		System.out.println(Comparator.comparing(emp -> ((Employee2) emp).getSalary()));
		// System.out.println((emp1, emp2) -> ((Employee2)
		// emp1).getSalary().compareTo(((Employee2) emp1).getSalary());
	}

	private static void m4() {
		System.out.println("m4()");
		List<Employee2> list = createEmployeeList();
		//Optional<Employee2> minEmp = list.stream().min(Comparator.comparing(emp -> emp.getSalary()));
		Optional<Employee2> minEmp = list.stream().min((emp1,emp2)->((Double)emp1.getSalary()).compareTo((Double)emp1.getSalary()));
		Optional<Employee2> maxEmp = list.stream().max(Comparator.comparing(emp -> emp.getSalary()));
		System.out.println("Min " + minEmp.get().getSalary());
		System.out.println("Max" + maxEmp.get().getSalary());
	}

	private static void m201() {
		System.out.println("m201()");
		List<Employee2> list = createEmployeeList();
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.counting()));
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println();
		map.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}

	private static void m2() {
		System.out.println("m2()");
		List<Employee2> list = createEmployeeList();
		Map<String, List<Employee2>> map = list.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.toList()));
		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key).size());
		}
		System.out.println();
		map.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue().size());
		});
	}

	private static void m105() {
		System.out.println("m105()");
		List<Employee2> list = createEmployeeList();
		Map<String, List<Employee2>> map = list.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.toList()));
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		map.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
	}

	private static void m104() {

		System.out.println("m104()");
		List<Employee2> list = createEmployeeList();
		Map<String, List<Employee2>> map = list.stream()
				.collect(Collectors.groupingBy(Employee2::getDepartment, Collectors.toList()));
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}

	}

	private static void m103() {
		System.out.println("m103()");
		List<Employee2> list = createEmployeeList();
		Map<String, List<Employee2>> map = list.stream().collect(Collectors.groupingBy(Employee2::getDepartment));
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}

	private static List<Employee2> createEmployeeList() {
		List<Employee2> list = new ArrayList<>();
		list.add(new Employee2("A", "D-A", true, 10000));
		list.add(new Employee2("B", "D-B", true, 20000));
		list.add(new Employee2("C", "D-A", false, 30000));
		list.add(new Employee2("D", "D-D", false, 40000));
		return list;
	}

	private static void m1() {
		System.out.println("m1()");

		List<Employee2> list = createEmployeeList();
		list.stream().sorted((emp1, emp2) -> {
			return emp1.getDepartment().compareTo(emp2.getDepartment());
		}).forEach((emp) -> {
			System.out.println(emp);
		});
	}

	private static void m101() {
		System.out.println("m101()");
		List<Employee2> list = createEmployeeList();
		List<String> depList = list.stream().map(emp -> emp.getDepartment()).collect(Collectors.toList());
		depList.stream().forEach(dep -> {
			System.out.println("Department: " + dep);
			list.stream().filter(emp -> dep.equals(emp.getDepartment())).forEach(emp -> {
				System.out.println(emp);
			});
			System.out.println();
		});

	}

	private static void m102() {
		System.out.println("m102()");

		List<Employee2> list = createEmployeeList();
		Set<String> depSet = list.stream().map(emp -> emp.getDepartment()).collect(Collectors.toSet());

		depSet.forEach(dep -> {
			System.out.println("Department: " + dep);
			list.stream().filter(emp -> dep.equals(emp.getDepartment())).forEach(emp -> {
				System.out.println(emp);
			});
			System.out.println();
		});

	}

}

class Employee2 {

	private String name;
	private String department;
	private Boolean isActive;
	private double salary;

	public Employee2(String name, String department, Boolean isActive, double salary) {
		super();
		this.name = name;
		this.department = department;
		this.isActive = isActive;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", department=" + department + ", isActive=" + isActive + ", salary="
				+ salary + "]";
	}

}
