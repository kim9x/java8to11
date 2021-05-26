package me.pulpury.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService2 = Executors.newFixedThreadPool(4);
		
		Callable<String> hello = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		Callable<String> hello2 = () ->  "Hello";
		
		Callable<String> hello3 = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};
		
		Callable<String> java = () -> {
			Thread.sleep(3000L);
			return "Java";
		};
		
		Callable<String> taeju = () -> {
			Thread.sleep(1000L);
			return "Taeju";
		};
		
		
		// invokeAll은 배열에 들어있는 모든 값들을 기다려 준 후 한번에 보여줌!
		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello3, java, taeju));
		for (Future<String> f : futures) {
			System.out.println(f.get());
		}
		
		// executorService2를 사용한 이유.
		// singleThread 사용 시 hello3가 먼저 들어가 있고
		// Thread가 하나 밖에 없어 hello3, java, taeju가 순차적으로 들어가게 되므로
		// hello3가 먼저 나오는 것 같다.
		String s= executorService2.invokeAny(Arrays.asList(hello3, java, taeju));

		System.out.println(s);
		
//		Future<String> helloFuture = executorService.submit(hello3);
//		
//		System.out.println(helloFuture.isDone());
//		System.out.println("Started!");
		
//		helloFuture.get(); //블록킹 콜
		
		// cancel 사용 시 true는 현재 진행 중인 작업 interrupt 후 종료
		// false는 그 반대.
		// 일단 cancel을 사용하면 false라도 값을 가져올 수 없다.
//		helloFuture.cancel(false);
//		
//		System.out.println(helloFuture.isDone());
//		System.out.println("End!");
		
		executorService.shutdown();
		
	}
}
