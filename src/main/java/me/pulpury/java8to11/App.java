package me.pulpury.java8to11;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class App {
	
	// @Target(ElementType.TYPE_USE)를 사용하면 type을 사용하는 모든 곳에서
	// 사용할 수 있다.
//	public static void main(@Chicken String[] args) throws @Chicken RuntimeException {
	public static void main(String[] args) throws RuntimeException {
//		List<@Chicken String> names = Arrays.asList("Taeju");
		
		Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
		Arrays.stream(chickens).forEach(c -> {
			System.out.println(c.value());
		});
		
		// Chicken타입이 아닌 ChickenContainer 타입으로도 가져올 수 있다.!
		ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
		Arrays.stream(chickenContainer.value()).forEach(c -> {
			System.out.println(c.value());
		});
	}
	
	// @Target(ElementType.TYPE_PARAMETER) 덕분에 사용이 가능하다.
//	static class FeelsLikeChichichen<@Chicken T> {
		
//		public static <@Chicken C> void print(@Chicken C c) {
//			System.out.println(c);
//		}
		
//	}
	
}
