package org.threading;

public class DaemonThreadExample {

	public static void main(String[] args) {
		System.out.println("Main Function  ===> Start");
		MainThreadRunnable mainRunnable = new MainThreadRunnable();
		Thread mainThread = new Thread(mainRunnable);
		mainThread.start();
		System.out.println("Main Function  ===> End");
	}

}

class MainThreadRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Main Thread =====> Start");

			DaemonThreadRunnable runnable = new DaemonThreadRunnable();
			Thread daemonThread = new Thread(runnable);
			daemonThread.setDaemon(true);
			daemonThread.start();

			for (int i = 0; i < 2; i++) {
				System.out.println("Main Thread =====> Working");
				Thread.sleep(500l);
			}

			System.out.println("Main Thread =====> End");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class DaemonThreadRunnable implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Daemon Thread =====> Start");
			while (true) {
				System.out.println("Daemon Thread =====> Working");
				Thread.sleep(300l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}