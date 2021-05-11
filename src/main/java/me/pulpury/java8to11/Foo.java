package me.pulpury.java8to11;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo {
	
	public static void main(String[] args) {
		
		// java 8 전에는 아래처럼 익명 내부 클래스(anonymous inner class)로 사용
//		RunSomething runSomething1 = new RunSomething() {
//			
//			@Override
//			public void doIt() {
//				System.out.println("Hello");
//				
//			}
//		};
		
		// 한줄인 경우 람다로 아래처럼 사용 가능
//		RunSomething runSomething2 = () -> System.out.println("Hello");
//		runSomething2.doIt();
//		
//		// 한줄이 아닌 경우 람다로 아래처럼 사용 가능
//		RunSomething runSomething3 = () -> {
//			System.out.println("Hello");
//			System.out.println("Lamda");
//		};
		
		// 다른 언어의 함수를 정의한 것처럼 보이지만
		// 사실 java에서 람다는 특수한 형태의 오브젝트
		// 함수형 인터페이스를 인라인으로 구현한 오브젝트
		// 
		
		int baseNumber = 10;
		RunSomething runSomething = number -> number + baseNumber;
		System.out.println(runSomething.doIt(10));
		
		
		Plus10 plus10 = new Plus10();
		System.out.println(plus10.apply(1));
		
		Function<Integer, Integer> plus10_2 = (i) -> i + 10;
		System.out.println(plus10_2.apply(2));
		
		Function<Integer, Integer> plus10_3 = (i) -> i + 10;
		Function<Integer, Integer> multiply2 = (i) -> i * 2;
		System.out.println(multiply2.apply(2));
		 
		System.out.println(plus10.compose(multiply2).apply(3));
		Function<Integer, Integer> multiply2AndPlus10 =  plus10.compose(multiply2);
		System.out.println(multiply2AndPlus10.apply(2));
		
		System.out.println(plus10.andThen(multiply2).apply(2));
		
		
		// 두개의 값을 받아서 도니 읍따!.
//		Function의 상위 버전이라고 보면 된다.
		BiFunction<Integer, Integer, Integer> biF = (a, b) -> a * b;
		System.out.println(biF.apply(3, 7));
		
		// BiFunction 대신 사용할 수 있는 좀 특수한 인터페이스
		// parameter와 return가 모두 같은 자료형일 때 사용.
		BinaryOperator<Integer> BiOper = (a, b) -> a + b;
		System.out.println(BiOper.apply(100, 200));
		;
		
		// return이 void임!
		// 아래의 경우 입력한 값 출력만 가능.
		Consumer<Integer> printT = (i) -> System.out.println(i);
		printT.accept(4);
		
		// parameter가 없음
		// 아래의 경우 무조건 10만 리턴 함.
		Supplier<Integer> get10 = () -> 10;
		System.out.println(get10.get());
		
		// true or false를 return 함
		Predicate<String> startsWithTaeju = (s) -> s.startsWith("taeju");
		System.out.println(startsWithTaeju.equals("taeju"));
		// 위의 경우 String이므로 String class에 있는 equals를 사용해야 한다.		
		Predicate<Integer> isEven = (i) -> i%2 == 0;
		
		// 입력 값과 리턴 값이 같으면
		// unaryOperator를 사용하면 된다.
		// Function를 상속 받았으므로
		// Function의 디폴트 메서드를 사용할 수 있다!
		UnaryOperator<Integer> plus10_5 = (i) -> i + 10;
		System.out.println(plus10_5.apply(30));
		
		Foo foo = new Foo();
		foo.run();
	}

	private void run() {
		// java 8 이전에는 final이라는 키워가 붙어있어야만
		// 익명 내부 클래스에서 사용할 수 잇었음
		// java 8 이후부터는 final 키워드 생략 가능
		// effective final이라고 함.		

		final int baseNumber = 10;
		
		// 로컬 클래스
		// 개별 scope을 가진다.
		// 쉐도잉 가능.
		class LocalClass {
			void printBaseNumber() {
				System.out.println(baseNumber);
			}
		}
		
		// 익명 클래스
		// 개별 scope을 가진다.
		// 쉐도잉 가능.
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(baseNumber);
			}
			
		};
		
		// 람다
		// 위의 익명, 내부 클래스와 달리 쉐도윙하지 않는다. (동일 이름의 변수 선언 불가)
		// 위의 두 클래스는 scope이 새로 생기지만
		// 람다의 경우엔 run과 scope이 같기 때문
		IntConsumer printInt = (i) -> {
			System.out.println(i + baseNumber);
		};
		
		printInt.accept(10);
	}

}
