package _21javaVersions._8version.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples3 {

	public static void main(String[] args) {

		// m1();
		// m2();
		//m3();
		m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		// m11();
	}

	private static void m4() {
		List<List<String>> list3 = new ArrayList<>();
		list3.add(Arrays.asList("a", "b", "c"));
		list3.add(Arrays.asList("x", "y", "z"));

		List<List<String>> list10 = list3.stream().map(l -> l.stream().collect(Collectors.toList()))
				.collect(Collectors.toList());
		System.out.println(list10);
		
		List<Stream<String>> list8 = list3.stream().map(l -> l.stream()).collect(Collectors.toList());
		System.out.println(list8);
		for (Stream<String> stream : list8) {
			List<String> list9 = stream.collect(Collectors.toList());
			System.out.println(list9);
		}

		
	}

	private static void m3() {
		List<List<String>> list3 = new ArrayList<>();
		list3.add(Arrays.asList("a", "b", "c"));
		list3.add(Arrays.asList("x", "y", "z"));

		List<String> list4 = list3.stream().flatMap(l -> l.stream().map(str -> str.toUpperCase()))
				.collect(Collectors.toList());
		System.out.println(list4);// A,B,C,X,Y,Z

		List<String> list5 = list3.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(list5);

		List<String> list6 = list3.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(list6);
		List<String> list7 = list3.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		System.out.println(list7);
	}

	// <R> Stream<R> map(Function<? super T, ? extends R> mapper);
	// IntStream mapToInt(ToIntFunction<? super T> mapper);
	// <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>>
	// mapper);
	// IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
	private static void m2() {
		List<String> list = Arrays.asList("a", "b", "c");
		List list2 = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
		// System.out.println(list2);

		List<List<String>> list3 = new ArrayList<>();
		list3.add(Arrays.asList("a", "b", "c"));
		list3.add(Arrays.asList("x", "y", "z"));

		List<String> list4 = list3.stream().flatMap(l -> l.stream().map(str -> str.toUpperCase()))
				.collect(Collectors.toList());
		System.out.println(list4);// A,B,C,X,Y,Z

	}

	private static void m1() {
		List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
		list.stream().map(number -> number * 3).forEach((n) -> System.out.print(n + " "));

		System.out.println(list.stream().collect(Collectors.toList()));
		System.out.println(list.stream().map(n -> n).collect(Collectors.toList()));
	}

}