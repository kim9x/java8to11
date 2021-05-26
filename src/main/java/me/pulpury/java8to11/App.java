package me.pulpury.java8to11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<String> future = executorService.submit(() -> "Hello");
		
		future.get();
//		System.out.println(future.get());
		
		CompletableFuture<String> future2 = new CompletableFuture<>();
		future2.complete("Taeju");
//		System.out.println(future2.get());
		 
		CompletableFuture<String> future3 = CompletableFuture.completedFuture("taeju");
//		System.out.println(future3.get());
		  
		CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
//			System.out.println("Hello " + Thread.currentThread().getName());
		});
//		future4.get();
		
		CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		})
		// Function이 들어오므로 Return 값 지정 가능.
		.thenApply((s) ->  {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});
		
		System.out.println(future5.get());
		
		
		CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
//			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		})
		// Consumer가 들어오므로 return 값을 void형
		.thenAccept((s) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(s.toUpperCase());
		});
		
		
		
		CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
//			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).thenRun(() -> {
			System.out.println(Thread.currentThread().getName());
		});
		
		
	}
}
