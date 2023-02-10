package _101InterviewQuestions;
//https://app.codility.com/
/*that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000]*/
public class CodilityTest1 {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));

		System.out.println(solution2(new int[] { 1, 1, 2, 3, 4, 4, 6 }));// Sorted array
		System.out.println(solution2(new int[] { 1, 2, 3, 4, 4, 6 }));// Sorted array
		System.out.println(solution2(new int[] { 1, 2, 3, 4, 4, 6 }));// Sorted array
		System.out.println(solution2(new int[] { 1, 2, 3, 4, 5, 6 }));// Sorted array

		System.out.println(solution3(new int[] { 1, 3, 6, 4, 1, 2 }));

	}

	public static int solution3(int[] arr) {
		int result = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && arr[i] == result) {
				result = result + 1;
			} else {
				if (arr[i] <= result) {
					if (arr[i - 1] != arr[i]) {
						result = result + 1;
					}
				}
			}
		}
		return result;

	}

	public static int solution2(int[] arr) {
		int result = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && arr[i] == result) {
				result = result + 1;
			} else {
				if (arr[i] <= result) {
					if (arr[i - 1] != arr[i]) {
						result = result + 1;
					}
				}
			}
		}
		return result;

	}

	public static int solution(int[] arr) {
		int result = 1;
		Boolean flag = false;
		for (int j = 1; j < 100000; j++) {
			flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == j) {
					result = 1 + j;
					flag = true;
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		return result;
	}
}
