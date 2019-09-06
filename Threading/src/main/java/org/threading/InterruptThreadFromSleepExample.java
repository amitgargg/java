package org.threading;

import java.util.function.Supplier;

public class InterruptThreadFromSleepExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread =====> Start");
		Supplier<Runnable> runnableSupplier = getInterruptRunnable();
		Runnable interruptableRunnable = runnableSupplier.get();
		Thread interruptableThread = new Thread(interruptableRunnable);
		interruptableThread.start();
		Thread.sleep(1500l);
		interruptableThread.interrupt();
		System.out.println("Main Thread =====> End");
	}

	private static Supplier<Runnable> getInterruptRunnable() {
		Runnable interruptableRunnable = () -> {
			try {
				System.out.println("Interruptable Thread =====> Start");
				for (int i = 0; i < 5; i++) {
					System.out.println("Interruptable Thread Inside loop: Loop Count => " + i);
					Thread.sleep(1000);
				}
				System.out.println("Interruptable Thread =====> End");
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception Thrown");
				e.printStackTrace();
			}
		};

		Supplier<Runnable> supplier = () -> interruptableRunnable;
		return supplier;
	}
}
