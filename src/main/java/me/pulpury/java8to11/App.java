package me.pulpury.java8to11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
//		ScheduledExecutorService
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		executorService.execute(new Runnable() {
//		executorService.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Thread " + Thread.currentThread().getName());
//			}
//		});
		executorService.submit(getRunnable("Hello"));
		executorService.submit(getRunnable("Taeju"));
		executorService.submit(getRunnable("The"));
		executorService.submit(getRunnable("Java"));
		executorService.submit(getRunnable("Thread"));
		
		// 하던 일을 마저하고 shutdown 시킨다.
		executorService.shutdown();
		
		// 바로 shutdown 시킨다. 
//		executorService.shutdownNow();
		
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//		scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
		
//		scheduledExecutorService.shutdown();
	}

	private static Runnable getRunnable(String message) {
		// TODO Auto-generated method stub
		return () -> {
			System.out.println(message + ": " + Thread.currentThread().getName());
		};
	}
}
