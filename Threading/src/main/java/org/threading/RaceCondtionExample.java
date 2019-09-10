package org.threading;

public class RaceCondtionExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread ====> Start");
		
		System.out.println("3 Threads updating sum variable 100 time each ====> Expected Result 300");
		
		multipleThread_Updating_SharedResource_Without_Synchronization();
		
		multipleThread_Updating_SharedResource_With_Synchronization();

		System.out.println("Main Thread ====> End");
	}

	private static void multipleThread_Updating_SharedResource_Without_Synchronization() throws InterruptedException {
		SharedResource resource = new SharedResource();
		RaceCondtionRunnableWithoutSynchronization synchronizedBlockRunnable = new RaceCondtionRunnableWithoutSynchronization(
				resource);
		Thread t1 = new Thread(synchronizedBlockRunnable);
		Thread t2 = new Thread(synchronizedBlockRunnable);
		Thread t3 = new Thread(synchronizedBlockRunnable);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final Sum after incremented By 3 Threads non synchronized environment ===>" + resource.getSum());
	}
	
	
	private static void multipleThread_Updating_SharedResource_With_Synchronization() throws InterruptedException {
		SharedResource resource = new SharedResource();
		RaceCondtionRunnableWithSynchronization synchronizedBlockRunnable = new RaceCondtionRunnableWithSynchronization(
				resource);
		Thread t1 = new Thread(synchronizedBlockRunnable);
		Thread t2 = new Thread(synchronizedBlockRunnable);
		Thread t3 = new Thread(synchronizedBlockRunnable);
		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
		System.out.println("Final Sum after incremented By 3 Threads synchronized environment ===>" + resource.getSum());
	}


}

class RaceCondtionRunnableWithoutSynchronization implements Runnable {

	SharedResource sharedResource;

	RaceCondtionRunnableWithoutSynchronization(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		increment100Times();

	}

	private void increment100Times() {

		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(10l);
				int sum = sharedResource.getSum();
				sum = sum + 1;
				sharedResource.setSum(sum);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class RaceCondtionRunnableWithSynchronization implements Runnable {

	SharedResource sharedResource;

	RaceCondtionRunnableWithSynchronization(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		increment100Times();

	}

	private synchronized void increment100Times() {

		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(10l);
				int sum = sharedResource.getSum();
				sum = sum + 1;
				sharedResource.setSum(sum);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SharedResource {
	private int sum;

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
}