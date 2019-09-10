package org.threading;

public class SynchronizedExampleOneRunnbaleMultipleThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread ====> Start");

		oneRunnableMultipleThread_synchronized_success();

		multipleRunnableMultipleThread_not_a_synchronization();

		System.out.println("Main Thread ====> End");
	}

	private static void multipleRunnableMultipleThread_not_a_synchronization() throws InterruptedException {
		SynchronizedRunnable synchronizedRunnable1 = new SynchronizedRunnable();
		SynchronizedRunnable synchronizedRunnable2 = new SynchronizedRunnable();
		SynchronizedRunnable synchronizedRunnable3 = new SynchronizedRunnable();
		Thread t1 = new Thread(synchronizedRunnable1);
		Thread t2 = new Thread(synchronizedRunnable2);
		Thread t3 = new Thread(synchronizedRunnable3);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final Sum after incremented By 1st Thread ===>" + synchronizedRunnable1.getSum());
		System.out.println("Final Sum after incremented By 2nd Thread ===>" + synchronizedRunnable2.getSum());
		System.out.println("Final Sum after incremented By 3rd Thread ===>" + synchronizedRunnable3.getSum());
	}

	private static void oneRunnableMultipleThread_synchronized_success() throws InterruptedException {
		SynchronizedRunnable synchronizedRunnable = new SynchronizedRunnable();
		Thread t1 = new Thread(synchronizedRunnable);
		Thread t2 = new Thread(synchronizedRunnable);
		Thread t3 = new Thread(synchronizedRunnable);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final Sum after incremented By 3 Threads ===>" + synchronizedRunnable.getSum());
	}

}

class SynchronizedRunnable implements Runnable {

	private int sum = 0;

	@Override
	public void run() {
		increment100Times();

	}

	private synchronized void increment100Times() {

		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(10l);
				sum++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getSum() {
		return sum;
	}

}