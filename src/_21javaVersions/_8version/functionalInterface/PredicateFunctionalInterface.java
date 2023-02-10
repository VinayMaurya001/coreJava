package _21javaVersions._8version.functionalInterface;

import java.util.ArrayList;
import java.util.function.*;

public class PredicateFunctionalInterface {
	public static void main(String[] args) {
		//m2();
	//	m3();
		m4();

		
	}

	private static void m4() {

		String[] names = { "Durga", "", null, "Ravi", "", "Shiva", null };
		Predicate<String> p = s -> s != null && s.length() != 0;
		Predicate<String> p2 = s -> !(s == null || s.length() == 0);
		ArrayList<String> list = new ArrayList<String>();
		for (String s : names) {
			if (p.test(s)) {
				list.add(s);
			}
		}
		System.out.println("List of valid names: ");
		System.out.println(list);
		ArrayList<String> list2 = new ArrayList<String>();
		for (String s : names) {
			if (p2.test(s)) {
				list2.add(s);
			}
		}
		System.out.println("List of valid names: ");
		System.out.println(list2);

	}

	private static void m3() {

		String[] names = { "Sunny", "Kajal", "Katrina", "Karina" };

		Predicate<String> startsWithK = s -> s.charAt(0) == 'K';
		System.out.println("The names starts with K are: ");

		for (String s : names) {
			if (startsWithK.test(s)) {
				System.out.print(s + " ");
			}
		}

	}

	private static void m2() {
		int[] x = { 1, 0, 5, 10, 15, 20, 25, 30 };

		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i % 2 == 0;

		System.out.println("The Numbers Greater Than 10: ");
		m1(p1, x);
		System.out.println();

		System.out.println("The Even Numbers Are: ");
		m1(p2, x);
		System.out.println();

		System.out.println("The Numbers Not Greater Than 10: ");
		m1(p1.negate(), x);
		System.out.println();

		System.out.println("The Odd Numbers Are: ");
		m1(p2.negate(), x);
		System.out.println();

		System.out.println("The Numbers Greater Than 10 And Even Are: ");
		m1(p1.and(p2), x);
		System.out.println();

		System.out.println("The Numbers Greater Than 10 OR Even: ");
		m1(p1.or(p2), x);
		System.out.println();
	}

	public static void m1(Predicate<Integer> p, int[] x) {
		for (int x1 : x) {
			if (p.test(x1))
				System.out.println(x1);
		}
	}
}
