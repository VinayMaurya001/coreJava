package _21javaVersions._8version.functionalInterface;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEmployeeManagementApplication {

	public static void main(String[] args) {
		m1();
	}

	private static void m1() {
		ArrayList<Employees> list = new ArrayList<Employees>();
		populate(list);
		
		Predicate<Employees> p1 = emp -> emp.designation.equals("Manager");
		System.out.println("Managers Information:");
		display(p1, list);
		
		Predicate<Employees> p2 = emp -> emp.city.equals("Bangalore");
		System.out.println("Bangalore Employees Information:");
		display(p2, list);
		
		Predicate<Employees> p3 = emp -> emp.salary < 20000;
		System.out.println("Employees whose slaray <20000 To Give Increment:");
		display(p3, list);
		
		System.out.println("All Managers from Bangalore city for Pink Slip:");
		display(p1.and(p2), list);
		
		System.out.println("Employees Information who are either Managers or salary <2000 0");
		display(p1.or(p3), list);
		
		System.out.println("All Employees Information who are not managers:");
		display(p1.negate(), list);
		
		Predicate<Employees> isCEO = Predicate.isEqual(new Employees("Durga", "CEO", 30000, " Hyderabad"));
		Employees e1 = new Employees("Durga", "CEO", 30000, "Hyderabad1");
		Employees e2 = new Employees("Sunny", "Manager", 20000, "Hyderabad");

		System.out.println(isCEO.test(e1));// true
		System.out.println(isCEO.test(e2));// false
	}

	public static void populate(ArrayList<Employees> list) {
		list.add(new Employees("Durga", "CEO", 30000, "Hyderabad"));
		list.add(new Employees("Sunny", "Manager", 20000, "Hyderabad"));
		list.add(new Employees("Mallika", "Manager", 20000, "Bangalore"));
		list.add(new Employees("Kareena", "Lead", 15000, "Hyderabad"));
		list.add(new Employees("Katrina", "Lead", 15000, "Bangalore"));
		list.add(new Employees("Anushka", "Developer", 10000, "Hyderabad"));
		list.add(new Employees("Kanushka", "Developer", 10000, "Hyderabad"));
		list.add(new Employees("Sowmya", "Developer", 10000, "Bangalore"));
		list.add(new Employees("Ramya", "Developer", 10000, "Bangalore"));
	}

	public static void display(Predicate<Employees> p, ArrayList<Employees> list) {
		for (Employees e : list) {
			if (p.test(e)) {
				System.out.println(e);
			}
		}
		System.out.println("**************************************************");
	}

}

class Employees {
	String name;
	String designation;
	double salary;
	String city;

	Employees(String name, String designation, double salary, String city) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

	public String toString() {
		String s = String.format("[%s,%s,%.2f,%s]", name, designation, salary, city);
		return s;
	}

	public boolean equals(Object obj) {
		Employees e = (Employees) obj;
		if (name.equals(e.name) && designation.equals(e.designation) && salary == e.salary ){//&& city == e.city) {
			return true;
		} else {
			return false;
		}
	}
}