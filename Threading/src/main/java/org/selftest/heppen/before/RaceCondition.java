package org.selftest.heppen.before;

public class RaceCondition {

	private long l;

	RaceCondition(long l) {
		this.l = l;
	}

	private long getValue() {
		return l;
	}

	private void increment() {
		l = l + 1;
	}

	public static void main(String[] args) throws InterruptedException {
		RaceCondition raceCondition = new RaceCondition(1);
		Runnable run1 = new Runnable() {
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					raceCondition.increment();
				}
			}
		};

		Thread[] thread = new Thread[1000];
		for (int i = 0; i < 1_000; i++) {
			thread[i] = new Thread(run1);
			thread[i].start();
		}

		for (int i = 0; i < thread.length; i++) {
			thread[i].join();
		}

		System.out.println(raceCondition.getValue());

	}

}
