package org.threading;

public class ShutdonwHookupExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Inside Main Thread");

		System.out.println("Hookup Intialization Start");
		Runtime runtime = Runtime.getRuntime();

		Thread shutdownHookupThread = new Thread(getHookupRunnable());
		runtime.addShutdownHook(shutdownHookupThread);
		System.out.println("Hookup Intialization END");

		Thread.sleep(1000l);
		System.out.println("Main Thread ==> end");
	}

	private static Runnable getHookupRunnable() {
		return () -> {
			try {
				System.out.println("Saving the state of window shutdown====> Start");
				Thread.sleep(1000l);
				System.out.println("Saving the state of window shutdown=====> Done");

				System.out.println("Cleaning Resource====> Start");
				Thread.sleep(1000l);
				System.out.println("Cleaning Resource====> Done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
}
