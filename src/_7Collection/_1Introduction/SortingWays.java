package _7Collection._1Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWays {

	public static void main(String[] args) {

		// m1();

		// m2();

		m3();
		
		getList().stream().sorted();
	}

	private static void m3() {
		List<A> list = getList();
		System.out.println(list);

		Collections.sort(list, Comparator.comparing(a -> a.getAge()));
		System.out.println(list);

		Collections.sort(list, Comparator.comparing(a -> a.getName()));
		System.out.println(list);

		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);
	}

	private static void m2() {
		List<A> list = getList();
		System.out.println(list);

		Collections.sort(list, (a1, a2) -> (a1.getAge() < a2.getAge()) ? 1 : (a1.getAge() > a2.getAge()) ? -1 : 0);// Age
																													// Descending
																													// order
		System.out.println(list);

		Collections.sort(list, (a1, a2) -> -a1.getName().compareTo(a2.getName()));// Name Descending order
		System.out.println(list);
	}

	private static void m1() {
		List<A> list = getList();
		System.out.println(list);

		Collections.sort(list);// Element of list must be comparable
		System.out.println(list);

		// Arrays.sort(list);//CTE
	}

	private static List<A> getList() {
		List<A> list = new ArrayList<>();
		list.add(new A(4, "D"));
		list.add(new A(1, "A"));
		list.add(new A(2, "Z"));
		list.add(new A(1, "A"));
		return list;
	}

}

class A implements Comparable<A> {
	int age;
	String name;

	public A(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "A [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int compareTo(A a) {
		Integer ageI = age;
		if (age == a.getAge() && name.equals(a.getName())) {
			return 0;
		}
		return name.compareTo(a.getName());
	}

}