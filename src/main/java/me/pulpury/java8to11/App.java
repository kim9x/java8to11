package me.pulpury.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});
		
		CompletableFuture<String> future = hello.thenCompose(App::getWorld);
		
		System.out.println(future.get());
		
		CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello2 " + Thread.currentThread().getName());
			return "Hello2";
		});
		
		CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("World2 " + Thread.currentThread().getName());
			return "World2";
		});
		
		CompletableFuture<String> future2 = hello2.thenCombine(world2, (h, w) -> h + " " + w);
		System.out.println(future2.get());
		
		// 아래는 null 값이 나온다.
		CompletableFuture<Void> future3 = CompletableFuture.allOf(hello2, world2)
					.thenAccept((result) -> {
						System.out.println(result);
					});
		
		System.out.println(future3.get());
		
		List<CompletableFuture> futures = Arrays.asList(hello2, future2);
		
		CompletableFuture<Void> futureArray = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
		
		CompletableFuture<List<Object>> results = CompletableFuture.allOf(futureArray)
				.thenApply((v) -> {
					return futures.stream()
							.map(CompletableFuture::join)
							.collect(Collectors.toList());
				});
		
		results.get().forEach(System.out::println);
		
		System.out.println(results.get());
		
		CompletableFuture<Void> future4 = CompletableFuture.anyOf(hello2, world2).thenAccept((s) -> {
			System.out.println(s);
		});
		
		future4.get();
		
		boolean throwError = true;
		
		CompletableFuture<String> hello5 = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}
			
			System.out.println("Hello5 " + Thread.currentThread().getName());
			return "Hello";
		}).exceptionally(ex -> {
			return "Error!";
		});
		
		CompletableFuture<String> hello6 = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}
			
			System.out.println("Hello5 " + Thread.currentThread().getName());
			return "Hello";
		}).handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				return "ERROR!";
			}
			
			return result;
		});
		
		System.out.println(hello6.get());
		
	}
	
	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return message + " World";
		});
	}
	
}
