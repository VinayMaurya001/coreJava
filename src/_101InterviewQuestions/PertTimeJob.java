package _101InterviewQuestions;

/*
 Package 1 lacs per month- WFH
 Q)
10 thread
10 core
100 files
using jpa or hibernate
1)transaction manage
2)transaction failed is ok 

Q)
Multi thread
1000 threadd
cuaght excpetion in any thread

Q)
Databse use in spring vs boot
why use spring boot

Q)Any critical task you do
	client poller thread
	https://stackoverflow.com/questions/38895884/high-cpu-load-with-the-jsse-client-poller-on-tomcat-8-5
	https://bz.apache.org/bugzilla/show_bug.cgi?id=60030
 */
public class PertTimeJob {

	public static void main(String[] args) {
		/*
		 * return type of array whether it is incresing or desc or in-de or de-in
		 */

		System.out.println(typeArr(new int[] { 1, 2, 3, 4 }));// I
		//System.out.println(typeArr(new int[] { 4, 3, 2, 1 }));// D
		//System.out.println(typeArr(new int[] { 5, 6, 3, 1 }));// I , D
		//System.out.println(typeArr(new int[] { 4, 3, 5, 6 }));// D, I

	}

	private static String typeArr(int input[]) {
		String type = "";

		// increasing
		if (input[0] < input[1]) {
			type = "I";
		}
		for (int i = 0; i < input.length - 1; i++) {
			if ("I".equals(type) || "".equals(type)) {
				if (input[i] > input[i + 1]) {
					type = "NI";
					break;
				}
			}
		}

		if (input[0] > input[1]) {
			type = "D";
		}
		// decreasing
		for (int i = 0; i < input.length - 1; i++) {
			if ("D".equals(type) || "".equals(type)) {
				if (input[i] < input[i + 1]) {
					type = "ND";
					break;
				}
			}

		}

		// incre-decres
		for (int i = 0; i < input.length; i++) {
		}

		// dec-in
		for (int i = 0; i < input.length; i++) {
		}
		return type;
	}

}
