package _101InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//https://interview.codejudge.io/f119985f62c349168a6fa4346ceedb22?user_type=DEVELOPER
public class NinjaCart {

	public static void main(String[] args) {
		m1();
		m2();
	}

	private static void m1() {
		// TODO Auto-generated method stub

	}

	private static void m2() {
		String[][] badgeTimes = new String[][] { { "Paul", "1355" }, { "Jennifer", "1910" }, { "Jose", "835" },
				{ "Jose", "830" }, { "Paul", "1315" }, { "Chloe", "0" }, { "Chloe", "1910" }, { "Jose", "1615" },
				{ "Jose", "1640" }, { "Paul", "1405" }, { "Jose", "855" }, { "Jose", "930" }, { "Jose", "915" },
				{ "Jose", "730" }, { "Jose", "940" }, { "Jennifer", "1335" }, { "Jennifer", "730" }, { "Jose", "1630" },
				{ "Jennifer", "5" }, { "Chloe", "1909" }, { "Zhang", "1" }, { "Zhang", "10" }, { "Zhang", "109" },
				{ "Zhang", "110" }, { "Amos", "1" }, { "Amos", "2" }, { "Amos", "400" }, { "Amos", "500" },
				{ "Amos", "503" }, { "Amos", "504" }, { "Amos", "601" }, { "Amos", "602" }, { "Paul", "1416" }, };
		String[][] badgeTimes2 = new String[][] { { "Paul", "1355" }, { "Jennifer", "1910" }, { "John", "835" },
				{ "John", "830" }, { "Paul", "1315" }, { "John", "1615" }, { "John", "1640" }, { "Paul", "1405" },
				{ "John", "855" }, { "John", "930" }, { "John", "915" }, { "John", "730" }, { "John", "940" },
				{ "Jennifer", "1335" }, { "Jennifer", "730" }, { "John", "1630" }, { "Jennifer", "5" } };

		// int ans = ;
		System.out.println(new Solution2().solution(badgeTimes));
		System.out.println(new Solution2().solution(badgeTimes2));
	}

}

//[1,2,3,3,2,0]
//1.     2
//[0,0,7,6,5,6,1]

//p1.   p2
//1.     6
//5      6
//7.     0
//0

//"We are working on a security system for a badged-access room in our company's building.

//We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as ""800"" or ""2250"".

//Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

//badge_times = [
//[""Paul"", ""1355""],
//[""Jennifer"", ""1910""],
//[""John"", ""835""],
//[""John"", ""830""],
//[""Paul"", ""1315""],
//[""John"", ""1615""],
//[""John"", ""1640""],
//[""Paul"", ""1405""],
//[""John"", ""855""],
//[""John"", ""930""],
//[""John"", ""915""],
//[""John"", ""730""],
//[""John"", ""940""],
//[""Jennifer"", ""1335""],
//[""Jennifer"", ""730""],
//[""John"", ""1630""],
//[""Jennifer"", ""5""]
//]

//Expected output (in any order)
//John: 830 835 855 915 930
//Paul: 1315 1355 1405"
class Solution2 {
	// map
	// name value( map key=(1,2,3) value=sorted timelist)
	//
	public Map<String, List<String>> solution(String[][] badgeTime) {
		Map<String, List<String>> resultMap = new HashMap<>();
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < badgeTime.length; i++) {
			List<String> timeList = map.get(badgeTime[i][0]);
			if (timeList == null) {
				timeList = new ArrayList();
			}
			timeList.add(badgeTime[i][1]);
			Collections.sort(timeList,
					(time1, time2) -> Integer.compare(Integer.parseInt(time1), Integer.parseInt(time2)));
			map.put(badgeTime[i][0], timeList);
		}
		System.out.println("1 " + map);
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> timeList = entry.getValue();
			System.out.println("2 " + entry.getKey() + " " + timeList);
			if (timeList.size() >= 3) {
				List<String> timeEligibleList = timeEligibleList(timeList);
				if (timeEligibleList.size() >= 3) {
					resultMap.put(entry.getKey(), timeEligibleList);
				}
			}
		}

		return resultMap;
	}

	public List<String> timeEligibleList(List<String> timeList) {
		List<String> timeEligibleList = new LinkedList<>();
		int time1 = 0;
		int time2 = 0;
		int time3 = 0;
		boolean isFound = false;
		for (int i = 0; i < timeList.size() - 2; i++) {
			if (!isFound) {
				time1 = Integer.parseInt(timeList.get(i));
				time2 = Integer.parseInt(timeList.get(i + 1));
				time3 = Integer.parseInt(timeList.get(i + 2));
			} else {
				time2 = Integer.parseInt(timeList.get(i));
				time3 = Integer.parseInt(timeList.get(i + 1));
			}
			if (time1 < time2 && time2 < time3 && time2 - time1 < 100 && time3 - time1 < 100) {
				if (!isFound) {
					timeEligibleList.add(time1 + "");
					timeEligibleList.add(time2 + "");
					timeEligibleList.add(time3 + "");
					i++;
				} else {
					timeEligibleList.add(time3 + "");
				}
				isFound = true;
			}
		}
		return timeEligibleList;
	}
}

//You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

//Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

//Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.

//Example 1:

//Input: nums = [1,5,2]
//Output: false
//[9,5,2] //

//Example 2:

//Input: nums = [1,5,233,7]
//Output: true

class Solution {

	public boolean solution(String s) {
		String[] strArr = s.split(",");
		int aScore = 0;
		int bScore = 0;
		int index1 = 0; // index1++
		int index2 = strArr.length - 1; // index2--;
		boolean isAPlayed = false;
		for (int i = 0; index1 <= index2; i++) {
			int value1 = Integer.parseInt(strArr[index1]);
			int value2 = Integer.parseInt(strArr[index2]);
			int value = 0;
			if (value1 > value2) {
				value = value1;
				index1++;
			} else {
				value = value2;
				index2--;
			}
			if (!isAPlayed) {
				aScore = aScore + value;
				isAPlayed = true;
			} else {
				bScore = bScore + value;
				isAPlayed = false;
			}
		}
		return aScore >= bScore;
	}
}

class Main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		String line = myObj.nextLine();

		boolean ans = new Solution().solution(line);
		System.out.print(ans);
	}
}