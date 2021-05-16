package me.pulpury.java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
	
	public static void main(String[] args) {
//		Foo2 foo = new DefaultFoo("taeju");
////		Bar foo = new DefaultFoo("taeju");
//		foo.printName();
//		foo.printNameUpperCase();
//		
//		Foo2.printAnything();
//		
		
		List<String> names =  new ArrayList<>();
		names.add("taeju");
		names.add("pulpury");
		names.add("toby");
		names.add("foo");
		
//		names.forEach(System.out::println);
//		
//		// 위의 경우와 똑같다.
//		for (String n : names) {
//			System.out.println(n);
//		}
//		
//		Spliterator<String> spliterator = names.spliterator();
//		Spliterator<String> spliterator1 = spliterator.trySplit();
//		while (spliterator.tryAdvance(System.out::println));
//		System.out.println("============");
//		while (spliterator1.tryAdvance(System.out::println));
		
//		long k = name.stream().map(String::toUpperCase));
		
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//		name.sort(compareToIgnoreCase.reversed().thenComparing());
		
		List<String> collect = names.stream().map((s) -> {
			System.out.println(s);
			return s.toUpperCase();
		}).collect(Collectors.toList());
		
		collect.forEach(System.out::println);
		
		System.out.println("============");
		
		names.forEach(System.out::println);
		
		System.out.println("============");
		
		// Stream과 다르게
		// parallelStream는 병렬적인 구조 처리가 가능함.(쓰레기가 다름, Tread safe 하지 않다.)
		// parallelStream는 데이터가 정말 방대한 경우(아주 드문경우) 유용함.
		// 일반적인 경우 Stream이 유용.
		// 그러나 성능 차이는 직접 테스트해서 따져봐야 함.
		List<String> collect1 = names.parallelStream().map((s) -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		})
				.collect(Collectors.toList());
		
		collect1.forEach(System.out::println);
		
		
	}
}
