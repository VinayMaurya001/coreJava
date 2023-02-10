package _3javaLangPackage;

import java.util.HashMap;
import java.util.Iterator;

public class Cloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		// m1();

		m2();
	}

	private static void m2() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "first");
		hm.put("2", "second");

		HashMap<String, String> hm1 = new HashMap<String, String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			hm1.put(key, hm.get(key));
		}

		HashMap<String, String> hm2 = (HashMap<String, String>) hm1.clone();
		
		
		System.out.println(hm==hm1);
		System.out.println(hm==hm2);
		System.out.println(hm.equals(hm1));
		System.out.println(hm.equals(hm2));
		
		
		hm.put("3", "Third");
		System.out.println(hm);
		System.out.println(hm1);
		System.out.println(hm2);
		
		hm2.put("4", "Fourth");
		System.out.println(hm);
		System.out.println(hm1);
		System.out.println(hm2);
		
		hm1.put("5", "Fifth");
		System.out.println(hm);
		System.out.println(hm1);
		System.out.println(hm2);

	
	}
	private static void m1() throws CloneNotSupportedException {
		Cat c = new Cat(20);
		Dog d1 = new Dog(c, 10);
		System.out.print(d1.i + "\t");
		System.out.println(d1.c.j);

		Dog d2 = (Dog) d1.clone();
		System.out.print(d2.i + "\t");
		System.out.println(d2.c.j);

		d2.i = 888;
		d2.c.j = 999;
		System.out.print(d2.i + "\t");
		System.out.println(d2.c.j);

		System.out.print(d1.i + "\t");
		System.out.println(d1.c.j);
	}
}