package _101InterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HCLInterview2 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("c", "1");
		map.put("b", "1");
		map.keySet().stream().sorted().collect(Collectors.toList()).forEach((key) -> System.out.println(key));

	}

}
