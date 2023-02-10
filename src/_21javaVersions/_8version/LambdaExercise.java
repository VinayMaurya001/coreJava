package _21javaVersions._8version;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaExercise {

	public static void main(String[] args) {
		List<Person> peopleList = Arrays.asList(new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42), new Person("Thomas", "Carlyle", 51),
				new Person("Carlatte", "Bronte", 45), new Person("Methew", "Arnold", 39));
		// m1(peopleList);
		m2(peopleList);

		
	}

	private static void m2(List<Person> peopleList) {
		Collections.sort(peopleList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		System.out.println(peopleList);
		System.out.println();
		printConditionally(peopleList, people -> {
			return true;
		});
		printConditionally(peopleList, people -> true);
		printConditionally(peopleList, (people) -> people.getLastName().startsWith("C"));
		printConditionally(peopleList, (people) -> people.getFirstName().startsWith("C"));
	}

	private static void m1(List<Person> peopleList) {

		Collections.sort(peopleList, new Comparator() {
			public int compare(Object o1, Object o2) {
				Person p1 = (Person) o1;
				Person p2 = (Person) o2;
				return -p1.getLastName().compareTo(p2.getLastName());
			}
		});
		System.out.println(peopleList);

		Collections.sort(peopleList, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return -o1.getLastName().compareTo(o2.getLastName());
			}
		});
		System.out.println(peopleList);

		printAll(peopleList);
		System.out.println();

		printLastNameBeginningWithC(peopleList);
		System.out.println();

		printConditionally(peopleList, new Condition() {
			public boolean test(Person p) {
				return true;
			}
		});
		System.out.println();

		printConditionally(peopleList, new Condition() {
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
		System.out.println();

		printConditionally(peopleList, new Condition() {
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});
		System.out.println();

	}

	private static void printConditionally(List<Person> peopleList, Condition condition) {
		for (Person people : peopleList) {
			if (condition.test(people))
				System.out.println(people);
		}
	}

	private static void printLastNameBeginningWithC(List<Person> peopleList) {
		for (Person people : peopleList) {
			if (people.getLastName().startsWith("C")) {
				System.out.println(people);
			}
		}
	}

	private static void printAll(List<Person> peopleList) {
		for (Person people : peopleList) {
			System.out.println(people.getFirstName() + " " + people.getLastName() + "-" + people.getAge());
		}
	}
}

interface Condition {
	public boolean test(Person p);
}

class Person {
	private String firstName;
	private String lastName;
	private int age;

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
