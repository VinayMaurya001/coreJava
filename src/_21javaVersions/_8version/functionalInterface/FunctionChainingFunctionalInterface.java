package _21javaVersions._8version.functionalInterface;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionChainingFunctionalInterface {

	public static void main(String[] args) {
		// m1();
		 m2();
		// m3();
		//m4();
	}

	private static void m4() {
		Function<String, String> f1 = Function.identity();//
		String s2 = f1.apply("durga");
		System.out.println(s2);
	}

	private static void m3() {
		Function<String, String> f1 = s -> s.toLowerCase();
		Function<String, String> f2 = s -> s.substring(0, 5);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name:");
		String username = sc.next();
		System.out.println("Enter Password:");
		String pwd = sc.next();
		
		if (f1.andThen(f2).apply(username).equals("shila") && pwd.equals("java")) {
			System.out.println("Valid User");
		} else {
			System.out.println("Invalid User");
		}
	}

	private static void m2() {
		Function<Integer, Integer> f1 = i -> i *2;
		Function<Integer, Integer> f2 = i -> i * i * i;
		System.out.println(f1.andThen(f2).apply(2));//64
		System.out.println(f1.compose(f2).apply(2));//16
	}

	private static void m1() {
		Function<String, String> f1 = s -> s.toUpperCase();
		Function<String, String> f2 = s -> s.substring(0, 9);
		
		System.out.println("The Result of f1:" + f1.apply("AishwaryaAbhi"));//AISHWARYAABHI
		System.out.println("The Result of f2:" + f2.apply("AishwaryaAbhi"));//Aishwarya
		System.out.println("The Result of f1.andThen(f2):" + f1.andThen(f2).apply("Aishwarya Abhi"));//AISHWARYA
		System.out.println("The Result of f1.compose(f2):" + f1.compose(f2).apply("Aishwarya Abhi"));//AISHWARYA
	}

}
