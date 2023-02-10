package _21javaVersions._8version.functionalInterface;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateFunctionalInterface2 {

	public static void main(String[] args) {
		 m1();
		// m2();
		//m3();
	}

	private static void m3() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		populateEmployee(list);
		System.out.println(list);
	}

	public static void populateEmployee(ArrayList<Employee> list) {
		list.add(new Employee("Shila", "CEO", 100000, "Bihar"));
		list.add(new Employee("Bhola", "Java developer", 200000, "up"));
		list.add(new Employee("durga", "Trainer", 50000, "Bihar"));
		list.add(new Employee("Maheshawari", "Trainer", 50000, "Bihar"));
	}

	private static void m2() {
		SoftwareEngineer[] list = { 
				new SoftwareEngineer("Durga", 43, true),
				new SoftwareEngineer("Maheswari", 92, false), 
				new SoftwareEngineer("Bhola", 28, true),
				new SoftwareEngineer("Shiv", 26, true), 
				new SoftwareEngineer("Sankar", 18, true) };
		
		Predicate<SoftwareEngineer> allowed = se -> se.age >= 18 && se.isHavingGF;
		
		System.out.println("The allowed members into Pub are: ");
		for (SoftwareEngineer se : list) {
			if (allowed.test(se)) {
				System.out.println(se);
			}
		}
	}

	private static void m1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user name: ");
		String userName = scanner.next();
		System.out.println("Enter password: ");
		String pwd = scanner.next();

		Predicate<User> p = user -> user.userName.equals("Admin") && user.pwd.equals("admin123");

		User user = new User(userName, pwd);
		if (p.test(user)) {
			System.out.println("Valid user and can avail all services");
		} else {
			System.out.println("Invalid user you cannot avail services");
		}
		scanner.close();
	}

}

class User {
	String userName;
	String pwd;

	User(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}
}

class SoftwareEngineer {
	String name;
	int age;
	boolean isHavingGF;

	public SoftwareEngineer(String name, int age, boolean isHavingGF) {
		this.name = name;
		this.age = age;
		this.isHavingGF = isHavingGF;
	}

	public String toString() {
		return name;
	}
}

class Employee {
	String name;
	String designation;
	double salary;
	String city;

	public Employee(String name, String designation, double salary, String city) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

	public String toString() {
		String s = String.format("%s, %s, %f, %s", name, designation, salary, city);
		// %.2f -After decimal point contain 2 digits
		return s;
	}
}
