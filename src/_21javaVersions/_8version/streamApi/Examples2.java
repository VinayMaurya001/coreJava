package _21javaVersions._8version.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples2 {

	public static void main(String[] args) {

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		m11();
	}

//	Conditionally apply Filter condition, say if flag is enabled then.
	private static void m11() {
		List<Student> students = getStudentList();
		Stream<Student> conditionalFilterResult = students.stream().filter(std -> std.getName().startsWith("A"));

		boolean sortConditionFlag = true;
		if (sortConditionFlag) {
			conditionalFilterResult = conditionalFilterResult.sorted(Comparator.comparing(Student::getName));
		}
		
		System.out.println("Before sorting :");
		students.forEach(s -> System.out.println(s.getName()));
		List<Student> list = conditionalFilterResult.collect(Collectors.toList());
		System.out.println("After filter and conditional sorting :");
		list.forEach(s -> System.out.println(s.getName()));
	}

	private static void m10() {
		List<Student> students = getStudentList();
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
		Comparator<Student> zipComparator = (st1, st2) -> st1.getAddress().getZipcode()
				.compareTo(st2.getAddress().getZipcode());
		Comparator<Student> mobileComparator = (st1, st2) -> getSortedMobileNumbersString(st1)
				.compareTo(getSortedMobileNumbersString(st2));
		students.stream().sorted(nameComparator.thenComparing(mobileComparator).thenComparing(ageComparator)
				.thenComparing(zipComparator)).collect(Collectors.toList()).forEach(System.out::println);
	}

	private static String getSortedMobileNumbersString(Student st) {
		Stream<MobileNumber> mobileNumberStream = st.getMobileNumbers().stream()
				.sorted(Comparator.comparing(MobileNumber::getNumber));
		return mobileNumberStream.map(m -> m.getNumber()).collect(Collectors.joining(""));
	}

	// Sort List<String>
	private static void m9() {
		List<Student> students = getStudentList();
		students.stream().map(st -> {
			return st.toString();
		}).sorted().collect(Collectors.toList()).forEach(System.out::println);
	}

	// Change the case of List<String>
	private static void m8() {
		List<Student> students = getStudentList();
		students.stream().map(st -> {
			return st.toString().toUpperCase();
		}).collect(Collectors.toList()).forEach(System.out::println);
	}

	// Convert List<students> to String
	private static void m7() {
		List<Student> students = getStudentList();
		students.stream().map(st -> {
			return st.toString();
			// st.getName() + " " + st.getAge() + " " + st.getAddress()+"
			// "+st.getMobileNumbers())
		}).collect(Collectors.toList()).forEach(System.out::println);
	}

	// Convert List<Student> to List<String> of student name
	private static void m6() {
		List<Student> students = getStudentList();
		String studentNameString = students.stream().map(st -> st.getName()).collect(Collectors.joining(",", "[", "]"));
		System.out.println(studentNameString);
	}

	// Create a List<Student> from the List<TempStudent>
	private static void m5() {
		TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
		TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		tmpStudents.stream().map(ts -> {
			return new Student(ts.name, ts.age, ts.address, ts.mobileNumbers);
		}).collect(Collectors.toList()).forEach(System.out::println);
	}

	// Get all student having mobile number 1233 and 1234
	private static void m4() {
		List<Student> students = getStudentList();
		Stream<Student> studentStream = students.stream().filter((st) -> {
			List<MobileNumber> numbers = st.getMobileNumbers();
			return numbers.stream().anyMatch(num -> "1233".equals(num.getNumber()))
					&& numbers.stream().anyMatch(num -> "1234".equals(num.getNumber()));
		});
		studentStream.forEach(System.out::println);
	}

//	Get all student having mobile numbers 3333.
	private static void m3() {
		List<Student> students = getStudentList();
		Stream<Student> studentStream = students.stream().filter((st) -> {
			List<MobileNumber> numbers = st.getMobileNumbers();
			return numbers.stream().anyMatch(num -> "3333".equals(num.getNumber()));
		});
		// studentStream.peek(System.out::println);//Exception in thread "main"
		// java.lang.IllegalStateException: stream has already been operated upon or
		// closed
		studentStream = studentStream.peek(System.out::println);
		studentStream.forEach(System.out::println);

	}

//	Get student with matching address "1235"
	private static void m2() {
		List<Student> students = getStudentList();
		Stream<Student> studentStream = students.stream().filter(st -> "1235".equals(st.getAddress().getZipcode()));
		Optional<Student> student = studentStream.findFirst();
		student.ifPresent(System.out::println);
	}

	// Get student with exact match name "jayesh"
	private static void m1() {
		List<Student> students = getStudentList();
		Stream<Student> studentStream = students.stream().filter(st -> "Jayesh".equals(st.getName()));
		Optional<Student> student = studentStream.findFirst();
		student.ifPresent(System.out::println);
	}

	private static List<Student> getStudentList() {
		Student student1 = new Student("A", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("AC", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("AB", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1133"), new MobileNumber("4444")));

		return Arrays.asList(student1, student2, student3);
	}

}

class TempStudent {
	public String name;
	public int age;
	public Address address;
	public List<MobileNumber> mobileNumbers;

	public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}
}

class Student {
	private String name;
	private int age;
	private Address address;
	private List<MobileNumber> mobileNumbers;

	public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNumbers = mobileNumbers;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	public List<MobileNumber> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + ", mobileNumbers="
				+ mobileNumbers + '}';
	}
}

class Address {
	private String zipcode;

	public Address(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + "]";
	}

}

class MobileNumber {
	private String number;

	public MobileNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "MobileNumber [number=" + number + "]";
	}

}