package _6Multithreading._3udemy._3BasicMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

	private static int counter = 0;
	private static Lock lock = new ReentrantLock(true);

	public static void increment2() {
		lock.lock();
		counter++;
		lock.unlock();
	}

	public static void increment() {
		synchronized (lock)
		{
			counter++;
		}
	}

	public static void firstThread() {
		
		for (int i = 0; i < 1000; i++) {
			increment();
		}
		
	}

	public static void secondThread() {
		
		for (int i = 0; i < 500; i++) {
			increment();
		}
		
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				secondThread();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(counter);

	}
}
