package _2OOPs._8Generic;

import java.util.ArrayList;

public class GenericData {
	public static void main(String[] args) {
		 m1();
		 m2();
		 m3();
		m4();
		ArrayList<Number> box = new ArrayList<Number>();
		box.add(new Integer(10));   // OK
		box.add(new Double(10.1));  // OK
		System.out.println(box);
	}

	private static void m1() {
		Data data = new Data("hello generic");
		String stringData = (String) data.getData();
		Data data2 = new Data(10);
		int intData2 = (int) data2.getData();
		System.out.println(intData2);
		//int intData4 = (int) data.getData();// RTE,ClassCastException
	}

	private static void m2() {
		Data2 data = new Data2("hello generic");
		String stringData = (String) data.getData();
		Data2 data2 = new Data2(10);
		int intData2 = (int) data2.getData();
		System.out.println(intData2);
		//int intData3 = (int) data.getData();// RTE,ClassCastException
	}

	private static void m3() {
		Data2 data = new Data2<String>("hello generic");
		String stringData = (String) data.getData();
		Data2 data2 = new Data2<>(10);
		int intData2 = (int) data2.getData();
		System.out.println(intData2);
//		int intData4 = (int) data.getData();// RTE,ClassCastException
	}

	private static void m4() {
		Data2<String> data = new Data2<String>("hello generic");
		String stringData = (String) data.getData();
		String stringData2 =  data.getData();
		Data2<Integer> data2 = new Data2<>(10);
		int intData2 = (int) data2.getData();
		System.out.println(intData2);
		// int intData4 = (int) data.getData();//CTE,Cannot cast from String to
		// int
	}

}
