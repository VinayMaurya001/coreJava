package _6Multithreading._2enhancement;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

	public static void main(String[] args) throws Exception {
		// m1();
		m2();
	}

	private static void m2() {
		MyCallable[] jobs = { 
				new MyCallable(10), 
				new MyCallable(20), 
				new MyCallable(30), 
				new MyCallable(40),
				new MyCallable(50), 
				new MyCallable(60) 
		};.
		ExecutorService service = Executors.newFixedThreadPool(3);// 2,3,4,5,6,7
		for (MyCallable job : jobs) {
			Future f = service.submit(job);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		service.shutdown();
	}

	private static void m1() {
		MyThreadJob[] jobs = { 
				new MyThreadJob("Sachin"), 
				new MyThreadJob("Rahul"), 
				new MyThreadJob("Kumble"),
				new MyThreadJob("Abhinav"), 
				new MyThreadJob("Mohan"), 
				new MyThreadJob("Zebra") 
		};
		ExecutorService service = Executors.newFixedThreadPool(6);// 2,3,4,5,6,7
		for (MyThreadJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}
}
