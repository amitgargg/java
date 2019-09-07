package org.threading;

public class VolatileExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread ====> Start");

		healthCheck_Without_Volatile();

//		healthCheck_With_Volatile();

		System.out.println("Main Thread ====> End");
	}

	private static void healthCheck_Without_Volatile() throws InterruptedException {
		SharedResourceRunning runningWithoutVolatile = new SharedResourceRunningWithoutVolatile();
		HealthCheckRunnable healthCheckRunnable = new HealthCheckRunnable(runningWithoutVolatile);
		Thread t1 = new Thread(healthCheckRunnable);
		runningWithoutVolatile.startRunning();
		t1.start();

		Thread.sleep(500l);

		runningWithoutVolatile.stopRunning();

		System.out.println("Waiting Server to Stop Successfully");
		t1.join();
		System.out.println("Server Stoped Successfully");

	}

	private static void healthCheck_With_Volatile() throws InterruptedException {
		SharedResourceRunning runningWithVolatile = new SharedResourceRunningWithVolatile();
		HealthCheckRunnable healthCheckRunnable = new HealthCheckRunnable(runningWithVolatile);
		Thread t1 = new Thread(healthCheckRunnable);
		runningWithVolatile.startRunning();
		t1.start();

		Thread.sleep(500l);

		runningWithVolatile.stopRunning();

		System.out.println("Waiting Server to Stop Successfully");
		t1.join();
		System.out.println("Server Stoped Successfully");

	}

}

class HealthCheckRunnable implements Runnable {

	SharedResourceRunning running;

	HealthCheckRunnable(SharedResourceRunning running) {
		this.running = running;
	}

	@Override
	public void run() {
		System.out.println("Server is Health Check Start.........");
		int count = 0;
		while (running.isRunning()) {
			count++;
		}
		System.out.println("Server Running while loop execution Count =====>" + count);

	}

}

class StopRunnable implements Runnable {

	SharedResourceRunning running;

	StopRunnable(SharedResourceRunning running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (running.isRunning()) {
			running.stopRunning();
		}
	}
}

interface SharedResourceRunning {
	public void startRunning();

	public void stopRunning();

	public boolean isRunning();
}

class SharedResourceRunningWithoutVolatile implements SharedResourceRunning {

	private boolean running;

	public void startRunning() {
		System.out.println("Non Volatile Server Start Initiated...");
		this.running = true;
	}

	public void stopRunning() {
		System.out.println("Non Volatile Server Stop Initiated....");
		this.running = false;
	}

	public boolean isRunning() {
		return running;
	}

}

class SharedResourceRunningWithVolatile implements SharedResourceRunning {

	private volatile boolean running;

	public void startRunning() {
		System.out.println("Volatile Server Start Initiated...");
		this.running = true;
	}

	public void stopRunning() {
		System.out.println("Volatile Server Stop Initiated....");
		this.running = false;
	}

	public boolean isRunning() {
		return running;
	}

}