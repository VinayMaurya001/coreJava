package _101InterviewQuestions;

public class ChqbookInterview1 {

	public static void main(String[] args) {

//		m1();

		m2();
	}

	private static void m2() {
		
	}

	private static void m1() {
		int[] arr = { 1,3, 4, 5};
		int j = 0;
		for (int i = 0; i <= 10 && j < arr.length; i++) {
			if ((i + 1) < arr[j]) {
				System.out.println(i + 1);
			} else {
				j++;
				if (arr.length == j) {
					for (int k = arr[arr.length - 1] + 1; k <= 10; k++) {
						System.out.println(k);
					}
				}
			}
		}
		System.out.println();// 1,3,6,8,10
	}

	//circular street
//	[1,2,3,1] max money but no adjacent
	//[,] 
	
	
	//3 tyres 5 km 
	//max travel scooter 5km
	
	
//	Actuator
//	@Spring boot application
	
	
	
	
	
}
