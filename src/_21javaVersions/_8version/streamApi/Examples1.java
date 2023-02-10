package _21javaVersions._8version.streamApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples1 {

	public static void main(String[] args) {
		m0();
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		//m8();
		//m9();
	}

private static void m0() {
	List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
	Stream<Integer> stream = myList.stream();
	Stream<Integer> stream2 = stream.filter(n->n>8);
			long count = stream.count();
			stream.distinct();
	}

//Given a list of integers, sort all the values present in it using Stream functions?
	private static void m9() {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

		myList.stream().sorted().forEach(System.out::println);
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

//Given a String, find the first repeated character in it using Stream functions?
	private static void m8() {
		String input = "Jajva Hungry Blog Alive is Awesome";
		IntStream intStream = input.chars();
		Stream<Character> characterStream = intStream.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)));
		LinkedHashMap<Character, Long> linkedHashMap = characterStream
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Character result = linkedHashMap.entrySet().stream().filter(entry -> entry.getValue() > 1L)
				.map(entry -> entry.getKey()).findFirst().get();
		System.out.println(result);
	}

	// Given a String, find the first non-repeated character in it using Stream
	// functions?
	private static void m7() {
		// String input="aabbcdde";
		String input = "Jajva Hungry Blog Alive is Awesome";
		IntStream intStream = input.chars();
		Stream<Character> characterStream = intStream.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)));
		LinkedHashMap<Character, Long> linkedHashMap = characterStream
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Character result = linkedHashMap.entrySet().stream().filter(entry -> entry.getValue() == 1L)
				.map(entry -> entry.getKey()).findFirst().get();
		System.out.println(result);
	}

	// Given a list of integers, find the maximum value element present in it using
	// Stream functions?
	private static void m6() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3, 10);
		list.stream().max(Integer::compare).ifPresent(System.out::println);
		System.out.println(list.stream().max(Integer::compare).get());
		System.out.println(list.stream().max(Integer::compareTo).get());
		System.out.println(list.stream().max(Comparator.naturalOrder()).get());
		System.out.println(list.stream().max(Comparator.comparingInt(i -> i)).get());
		System.out.println(list.stream().max(Comparator.comparing(i -> i)).get());
		System.out.println(list.stream().max(Comparator.comparing(Function.identity())).get());

		System.out.println(list.stream().sorted(Comparator.reverseOrder()).findFirst().get());
		System.out.println(list.stream().reduce((a, b) -> {
			return a > b ? a : b;
		}).get());
		
		System.out.println(list.stream().max(Collections.reverseOrder()).get());
	}

	// Given a list of integers, find the total number of elements present in the
	// list using Stream functions?
	private static void m5() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3);
		System.out.println(list.stream().count());
	}

	// Given the list of integers, find the first element of the list using Stream
	// functions?
	private static void m4() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3);
		Optional<Integer> findFirst = list.stream().findFirst();
		System.out.println(findFirst.get());

		list.stream().findFirst().ifPresent(System.out::println);

		Integer orElse = list.stream().findFirst().orElse(-1);
		System.out.println(orElse);
		List<Integer> list2 = Arrays.asList();
		Integer orElse2 = list2.stream().findFirst().orElse(-1);
		System.out.println(orElse2);
	}

	// How to find duplicate elements in a given integers list in java using Stream
	// functions?
	private static void m3() {
		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3);
		Set<Integer> set = new HashSet();
		myList.stream().filter(i -> !set.add(i)).forEach(i -> System.out.println(i));
	}

	// Given a list of integers, find out all the numbers starting with 1 using
	// Stream functions?
	private static void m2() {
		Stream<Integer> stream = Stream.of(1, 2, 13, 4, 5, 126, 1234);
		List<Integer> result = stream.filter(i -> {
			while (i >= 10) {
				i = i / 10;
			}
			return i == 1;
		}).collect(Collectors.toList());
		System.out.println(result);

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(System.out::println);
	}

	// Given a list of integers, find out all the even numbers exist in the list
	// using Stream functions?
	private static void m1() {
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		myList.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
	}
}