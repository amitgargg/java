package org.threading;

public class SynchronizedBlockUsingMutex {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread ====> Start");

		oneRunnableMultipleThread_synchronized_success();

		System.out.println("Main Thread ====> End");
	}

	private static void oneRunnableMultipleThread_synchronized_success() throws InterruptedException {
		synchronizedBlockRunnable synchronizedBlockRunnable = new synchronizedBlockRunnable();
		Thread t1 = new Thread(synchronizedBlockRunnable);
		Thread t2 = new Thread(synchronizedBlockRunnable);
		Thread t3 = new Thread(synchronizedBlockRunnable);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final Sum after incremented By 3 Threads ===>" + synchronizedBlockRunnable.getSum());
	}

}

class synchronizedBlockRunnable implements Runnable {

	private int sum = 0;

	private final Object mutex = new Object();

	@Override
	public void run() {
		increment100Times();

	}

	private void increment100Times() {

		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(10l);
				synchronized (mutex) {
					sum++;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getSum() {
		return sum;
	}
}