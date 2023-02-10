package _21javaVersions._8version;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Sample {
	private String s;

	Sample(String s) {
		this.s = s;
		System.out.println("Constructor Executed:" + s);
	}
	
}

interface Interf {
	public Sample get(String s);
}

public class Demo {
	int x = 10;
	static int i = 1;

	public static void main(String[] args) {

		// m1();
		// m2((name) -> { int x = 10; return "Hello " + name;});

		// new Demo().m3();
		// m5();
		// m6();
		// m7();

		//m8();
		//m9();
		
		List<String> list = Arrays.asList("A","B","");
		long count = list.stream().filter(String::isEmpty).count();
		//System.out.println(count);
		String s1="bbbbbb";
		//String out=
				Optional<Object> map = Optional.ofNullable(s1).map(a->{return null;});
		System.out.println(map);
		System.out.println(map);
	}

	private static String m11() {
		// TODO Auto-generated method stub
		return "aaaaaaaaa";
	}

	private static void m9() {

		Optional.empty();
	}

	private static void m8() {
		List<Integer> a = Arrays.asList(1, 2, 3,5);
		List<Integer> b = Arrays.asList(2, 2, 1,2);
		List<Integer> list = Arrays.asList(
				(int) IntStream.range(0, a.size()).filter(i -> a.get(i) > b.get(i)).count(),
				(int) IntStream.range(0, a.size()).filter(i -> a.get(i) < b.get(i)).count());
		System.out.println(list);//[2, 1]
		
		
		long[] arr={1,2,3};
		long sum=Arrays.stream(arr).parallel().sum();
		System.out.println(sum);
		

	}

	private static void m7() {
		int sum = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		sum = Stream.of(10, 2, 3).mapToInt(x -> x).sum();
		System.out.println(sum);
		System.out.println(Arrays.asList(1, 2, 3).stream().mapToInt(i -> i.intValue()).sum());
		System.out.println(Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).sum());
	}

	private static void m6() {
		Stream<String> streamGenerated = Stream.generate(() -> {
			return (i++) + " ";
		}).limit(1000);
		System.out.println(streamGenerated.collect(Collectors.toList()));
	}

	private void m3() {
		int z = 20;
		z = z + 1;

		Function<String, String> f11 = (name) -> {
			System.out.println(this.x);
			// m1();
			int x = 10;
			x = x + 1;
			// z=z+1;//Implicitly final for Lamda expression
			return "Hello " + name;
		};
	}

	private static void m1() {
		Function<String, String> f11 = (name) -> {
			return "Hello " + name;
		};
		String s11 = f11.apply("Khusi");

		System.out.println(s11);
		System.out.println(f11.apply("Khusi"));
	}

	private static void m2(Function<String, String> f11) {
		String s = f11.apply("Shila");
		System.out.println(s);
		System.out.println(f11.apply("Khusi"));
	}

	private static void m5() {
		/*
		 * Interf f0 = (s) -> return new Sample(s); ;
		 */
		Interf f = (s) -> {
			return new Sample(s);
		};
		f.get("From Lambda Expression");

		Interf f1 = Sample::new;
		f1.get("From Constructor Reference");
	}
}
